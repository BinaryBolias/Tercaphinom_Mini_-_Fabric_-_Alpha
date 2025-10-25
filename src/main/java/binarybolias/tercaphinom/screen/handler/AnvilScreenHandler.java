package binarybolias.tercaphinom.screen.handler;


import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.text.Text;
import net.minecraft.util.StringHelper;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;


/**
 * A custom version of {@link net.minecraft.screen.AnvilScreenHandler}.
 * @see net.minecraft.client.gui.screen.ingame.AnvilScreen
 * @see net.minecraft.client.gui.screen.ingame.ForgingScreen
 */
public class AnvilScreenHandler extends ForgingScreenHandler {
	private static final int TARGET_INPUT_ID = 0;
	private static final int MATERIAL_INPUT_ID = 1;
	private static final int OUTPUT_ID = 2;
	
	public static final int MAX_NAME_LENGTH = 50;
	
	private int repairItemUsage;
	@Nullable
	private String newItemName;
	private final Property levelCost = Property.create();
	
	private static final int SLOT_Y_POS = 47;
	
	
	public AnvilScreenHandler(int syncId, PlayerInventory inventory) {
		this(syncId, inventory, ScreenHandlerContext.EMPTY);
	}
	
	
	public AnvilScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
		super(ScreenHandlerType.ANVIL, syncId, inventory, context);
		this.addProperty(this.levelCost);
	}
	
	
	@Override
	public ForgingSlotsManager getForgingSlotsManager() {
		return ForgingSlotsManager.create()
				.input(TARGET_INPUT_ID, 27, SLOT_Y_POS, stack -> true)
				.input(MATERIAL_INPUT_ID, 76, SLOT_Y_POS, stack -> true)
				.output(OUTPUT_ID, 134, SLOT_Y_POS).build();
	}
	
	
	@Override
	protected boolean canUse(BlockState state) {
		return state.isIn(BlockTags.ANVIL);
	}
	
	
	@Override
	protected boolean canTakeOutput(PlayerEntity player, boolean present) {
		return (player.isInCreativeMode() || player.experienceLevel >= this.levelCost.get()) && this.levelCost.get() > 0;
	}
	
	
	/**
	 * Anvil damage chance now based on the anvil operation level cost.<br>
	 * In future, if the anvil is in its most broken stage,
	 * any anvil operation of level cost greater than 1 would be forbidden.<br>
	 * Since a level cost of 1 (or less) is guaranteed to not damage the anvil (as specified here),
	 * anvils would no longer be capable of being completely destroyed from ordinary usage.<br>
	 * (would still be destroyable from dropping, if that is not elsewise overridden)<br>
	 * Note: A damaged anvil should be repairable with an ingot or corresponding metal,
	 * perhaps also requiring a mallet (and consuming 1 point of the mallet's durability).<br>
	 * Note: Anvils not being destroyable would make them a good candidate as a new NPC profession block.
	 */
	@Override
	public void onTakeOutput(PlayerEntity player, ItemStack stack) {
		if (!player.getAbilities().creativeMode) {
			player.addExperienceLevels(-this.levelCost.get());
		}
		
		this.input.setStack(0, ItemStack.EMPTY);
		if (this.repairItemUsage > 0) {
			ItemStack itemStack = this.input.getStack(1);
			if (!itemStack.isEmpty() && itemStack.getCount() > this.repairItemUsage) {
				itemStack.decrement(this.repairItemUsage);
				this.input.setStack(1, itemStack);
			} else {
				this.input.setStack(1, ItemStack.EMPTY);
			}
		} else {
			this.input.setStack(1, ItemStack.EMPTY);
		}
		
		// Get the chance for damaging the anvil.
		// For a level cost from 1 to 64, break chance is ( ([levelCost] - 1) / 64).
		// Break chance is 0 at a level cost of 1.
		// Any nonzero chance is an increment of 1/64th.
		// Maximizes at 63/64ths (0.984375F) from a level cost of 64 or greater.
		float breakChance = Math.min(((float) this.getLevelCost() - 1.0F), 63.0F) / 64.0F;
		
		this.levelCost.set(0);
		this.context.run((world, pos) -> {
			BlockState blockState = world.getBlockState(pos);
			// Modified anvil break chance calculation.
			// Original: (player.getRandom().nextFloat() < 0.12F)
			// Now with chance defined by 'breakChance' which is proportional to the level cost.
			
			if (!player.isInCreativeMode() && blockState.isIn(BlockTags.ANVIL) && player.getRandom().nextFloat() < breakChance) {
				BlockState blockState2 = AnvilBlock.getLandingState(blockState);
				if (blockState2 == null) {
					world.removeBlock(pos, false);
					world.syncWorldEvent(WorldEvents.ANVIL_DESTROYED, pos, 0);
				} else {
					world.setBlockState(pos, blockState2, Block.NOTIFY_LISTENERS);
					world.syncWorldEvent(WorldEvents.ANVIL_USED, pos, 0);
				}
			} else {
				world.syncWorldEvent(WorldEvents.ANVIL_USED, pos, 0);
			}
		});
	}
	
	
	/**
	 * General refactoring of the vanilla version.<br>
	 * Removed logic for repair cost item components,
	 * which previously inflated anvil operation costs through a hidden, unintuitive metric.
	 * <br><br>
	 * Note:
	 * Due to the removed interfacing with repair cost item components,
	 * there is no longer a limit to how many times an item can be repaired or modified at an anvil,
	 * provided the cost to perform the anvil operation remains less than the maximum.
	 * <br><br>
	 * Note:
	 * The anvil interface should be modified to only allow entering a custom name if
	 * either the target slot or material slot is a Name Tag.<br>
	 * If the target slot is a Name Tag, then an item should not be allowed in the material slot.
	 */
	@Override
	public void updateResult() {
		// Get the stack of the target input slot.
		ItemStack targetStack = this.input.getStack(TARGET_INPUT_ID);
		
		// Require the target stack to not be empty, and to be an item which can have enchantments.
		if (targetStack.isEmpty() || !EnchantmentHelper.canHaveEnchantments(targetStack)) {
			this.output.setStack(0, ItemStack.EMPTY);
			this.levelCost.set(0);
			return;
		}
		
		this.levelCost.set(1);
		
		// Reset the tally of materials used in repair.
		this.repairItemUsage = 0;
		
		// Get the stack of the material input slot.
		ItemStack materialStack = this.input.getStack(MATERIAL_INPUT_ID);
		
		// Get an enchantment component builder containing the enchantments of the target stack.
		ItemEnchantmentsComponent.Builder enchantmentBuilder = new ItemEnchantmentsComponent.Builder(
				EnchantmentHelper.getEnchantments(targetStack));
		
		// Track the base anvil operation cost.
		int baseCost = 0;
		
		// Create the item stack for output.
		ItemStack newStack = targetStack.copy();
		
		// Handle material slot logic.
		if (!materialStack.isEmpty()) {
			if (targetStack.isDamageable() && targetStack.getItem().canRepair(targetStack, materialStack)) {
				// The target input is damageable, and the material input is a repair material for the target.
				
				// Calculate the repair cost and consumed material amount.
				
				//TODO: Instead of always repairing by 1/4th of total durability for every item,
				// allow the item to define its own repair increment.
				int repairIncrement = targetStack.getMaxDamage() / 4;
				
				int repairability = Math.min(targetStack.getDamage(), repairIncrement);
				if (repairability <= 0) {
					this.output.setStack(0, ItemStack.EMPTY);
					this.levelCost.set(0);
					return;
				}
				
				int itemsUsed;
				for (itemsUsed = 0; repairability > 0 && itemsUsed < materialStack.getCount(); itemsUsed++) {
					// Reduce the new stack's damage.
					newStack.setDamage(newStack.getDamage() - repairability);
					
					baseCost++;
					// Get the remaining repairability.
					repairability = Math.min(newStack.getDamage(), repairIncrement);
				}
				
				this.repairItemUsage = itemsUsed;
			} else {
				// The target stack is not damageable, or the material input is not a repair material for the target.
				
				// Get whether the material has stored enchantments.
				// Generally, only Enchanted Books contain stored enchantments.
				boolean materialHasStoredEnchantments = materialStack.contains(DataComponentTypes.STORED_ENCHANTMENTS);
				
				// Require that the material has stored enchantments,
				//  or that the target is damageable and of the same type as the material.
				if ( !materialHasStoredEnchantments &&
						(!targetStack.isOf(materialStack.getItem()) || !targetStack.isDamageable()) ) {
					// Material does not have stored enchantments.
					// Material is not of the same type as the target, or the target is not damageable.
					this.output.setStack(0, ItemStack.EMPTY);
					this.levelCost.set(0);
					return;
				}
				
				// Try repairing the target by merging it with the material.
				// Combines remaining durability values and provides a bonus of 1/8th maximum durability.
				if (targetStack.isDamageable() && !materialHasStoredEnchantments) {
					//TODO: Perhaps not check if the material has stored enchantments?
					// - Currently, this ensures that items are not repaired by applying Enchanted Books to them.
					// - Maybe instead use a new system of checking whether two items can be used to repair each other...
					//  - Items that are not identical, but both damageable and made of the same material
					//   could be used for repairing each other.
					
					int maxDamage = targetStack.getMaxDamage();
					
					// Get the target's remaining durability.
					int targetHealth = maxDamage - targetStack.getDamage();
					// Get the material's remaining durability.
					// Note: Using the material's max damage here specifically to allow the potential for
					//  repairing an item with an item of a different type.
					//  E.g, repairing an Iron Sword with an Iron Spear.
					int remainingMaterialDurability = materialStack.getMaxDamage() - materialStack.getDamage();
					
					//TODO: Instead of a static merge repair bonus proportion,
					// allow the bonus from merging items to be defined by the item itself.
					// - Perhaps enumerate a base resource value of each repairable item type,
					//  and apply a bonus based on the comparison between the resource values
					//  of the target and material items.
					// - A merge repair bonus would not be added unless both items have this value.
					// - E.g:
					//  - Iron Spear has a value of 6 (made of 1 ingot; 6 grams)
					//  - Iron Sword has a value of 12 (made of 2 ingots; 12 grams)
					//  - Using the spear to repair the sword would provide (6 / 12) 0.5 merge repair bonus power.
					//  - Using the sword to repair the spear would provide (12 / 6) 2.0 merge repair bonus power.
					//  - mergeRepairBonus = (int) (mergeRepairPower * maxDamage) / 8;
					//  - Using an Iron Chestplate (value 48) to repair the spear would provide enough
					//   merge repair power to fully repair the spear on its own,
					//   even when both items are at 0 remaining durability.
					//  - Given that items of different types cannot be merged,
					//   a constant merge repair bonus of 1/8th 'maxDamage' is still accurate to this idea.
					
					// Calculate a repair bonus for merging items.
					// Equal to 1/8th of maximum durability, rounding down.
					int mergeRepairBonus = maxDamage / 8;
					
					// Set the output stack's damage.
					int outputHealth = targetHealth + remainingMaterialDurability + mergeRepairBonus;
					newStack.setDamage(Math.max(0, maxDamage - outputHealth));
					
					baseCost += 2;
				}
				
				boolean materialHasTransferrableEnchantment = false;
				boolean materialHasIncompatibleEnchantment = false;
				
				// Apply enchantments of the material to the target.
				for (Object2IntMap.Entry<RegistryEntry<Enchantment>> entry
						: EnchantmentHelper.getEnchantments(materialStack).getEnchantmentsMap()) {
					// Get the enchantment.
					RegistryEntry<Enchantment> materialEntry = entry.getKey();
					Enchantment enchantment = materialEntry.value();
					
					// Get the enchantment level.
					int targetEnchantmentLevel = enchantmentBuilder.getLevel(enchantment);
					int materialEnchantmentLevel = entry.getIntValue();
					// If the level is the same for both material and target,
					//  get the value one greater up to the enchantment's maximum.
					// Else, choose the higher level between the two.
					int newEnchantmentLevel = (targetEnchantmentLevel == materialEnchantmentLevel)
							? Math.min(materialEnchantmentLevel + 1, enchantment.getMaxLevel())
							: Math.max(materialEnchantmentLevel, targetEnchantmentLevel);
					
					// Get enchantment compatibility with the target item.
					boolean isCompatibleWithTarget = enchantment.isAcceptableItem(targetStack);
					// Make compatible in creative mode or if applying to an Enchanted Book.
					if (this.player.getAbilities().creativeMode || targetStack.isOf(Items.ENCHANTED_BOOK)) {
						isCompatibleWithTarget = true;
					}
					// Make incompatible if the target item already has a mutually exclusive enchantment.
					for (RegistryEntry<Enchantment> targetEntry : enchantmentBuilder.getEnchantments()) {
						if (!targetEntry.equals(materialEntry) && !enchantment.canCombine(targetEntry.value())) {
							isCompatibleWithTarget = false;
							// Apparently we increase the anvil operation cost for each enchantment on the target
							//  that is mutually exclusive with each enchantment on the material.
							baseCost++;
						}
					}
					// Apply the enchantment if compatible.
					if (isCompatibleWithTarget) {
						// Track that at least one enchantment of the material is transferable onto the target.
						materialHasTransferrableEnchantment = true;
						// Apply the enchantment to the builder.
						enchantmentBuilder.set(enchantment, newEnchantmentLevel);
						// Determine the base enchantment cost.
						// The base enchantment cost is halved (minimum of 1) if the material is an Enchanted Book.
						int enchantmentCost = materialHasStoredEnchantments ?
								Math.max(1, enchantment.getAnvilCost() / 2)
								: enchantment.getAnvilCost();
						// Increase the base anvil operation cost based on the enchantment cost.
						baseCost += enchantmentCost * newEnchantmentLevel;
					} else {
						// Track that at least one enchantment of the material is not compatible with the target.
						materialHasIncompatibleEnchantment = true;
					}
				}
				// Severely increase the base cost if more than 1 item is in the target stack.
				if (targetStack.getCount() > 1) {
					// Multiplying the base operation cost by stack size... for, uh... realism!
					baseCost *= targetStack.getCount();
					// Add a flat increase equal to the limit for anvil operations outside creative mode;
					//  enchantments to not be applicable to stacks of items except in creative mode.
					baseCost += 40;
				}
				
				// Require that the material has no incompatible enchantments,
				//  unless also containing transferable enchantments.
				
				//TODO: Perhaps add a third requirement for aborting the anvil operation:
//				boolean repairCannotOccur = targetStack.getDamage() == newStack.getDamage();
				//TODO: Also perhaps remove the incompatible enchantment check;
				// allow as long as there is at least one transferable enchantment,
				// or the target can be repaired by the material.
				
				if (materialHasIncompatibleEnchantment && !materialHasTransferrableEnchantment) {
					// Abort the anvil operation.
					this.output.setStack(0, ItemStack.EMPTY);
					this.levelCost.set(0);
					return;
				}
			}
		}
		// The target slot is not empty.
		// The material slot is empty, or it contains a valid item for combination with the target slot.
		
		int costFromNameChange = 0;
		
		// Assign or remove a custom name to/from the target stack.
		if (this.newItemName != null && !StringHelper.isBlank(this.newItemName)) {
			// Set the output stack's name if the name input is not equal to the target stack's default name.
			if (!this.newItemName.equals(targetStack.getName().getString())) {
				// Ha HA! Fools! You think you can rename and item for only 1 level?!
				// Nay! A minimum of 3 levels you must pay!
				// TODO: Perhaps only allow renaming if the material slot is empty, or contains a Name Tag.
				//  - If the material slot contains a Name Tag, the renaming cost can be reduced to 1.
				costFromNameChange = 3;
				baseCost += costFromNameChange;
				newStack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(this.newItemName));
			}
		} else if (targetStack.contains(DataComponentTypes.CUSTOM_NAME)) {
			// Custom name removal services are at a discount! You're welcome, and have a nice day!
			costFromNameChange = 1;
			baseCost += costFromNameChange;
			newStack.remove(DataComponentTypes.CUSTOM_NAME);
		}

//			// Get the despair cost (sum of repair costs).
//			long despairCost = (long) targetStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0)
//					+ (long) materialStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
//			// Assign the despair to the level cost.
//			this.levelCost.set((int) MathHelper.clamp(despairCost + (long)baseCost, 0L, 2147483647L));
		// HA! Lame! Despair is for losers! Get rekt, despair nerds!
		this.levelCost.set(baseCost);
		
		// Allow for renaming if the only function being performed is renaming.
		// Note: '40' is assumed to be strictly too expensive for performing an anvil operation except in creative.
		// Note: Since pure evil has been removed, a super high cost just for renaming might not even be possible anymore...
		if (costFromNameChange > 0 && costFromNameChange == baseCost && this.levelCost.get() >= 40) {
			this.levelCost.set(39);
		}
		
		// Require the base cost to be greater than 0.
		if (baseCost <= 0) {
			newStack = ItemStack.EMPTY;
		}
		// Require the cost to be less than 40 unless in creative mode.
		if (this.levelCost.get() >= 40 && !this.player.getAbilities().creativeMode) {
			newStack = ItemStack.EMPTY;
		}
		
		// Apply item components to the output stack.
		if (!newStack.isEmpty()) {
//			// Set pure evil to the greater of two evils.
//			int pureEvil = newStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
//			if (pureEvil < materialStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0)) {
//				pureEvil = materialStack.getOrDefault(DataComponentTypes.REPAIR_COST, 0);
//			}
//			// Increase the level of evil if not just renaming.
//			if (costFromNameChange != baseCost || costFromNameChange == 0) {
//				pureEvil = getNextCost(pureEvil);
//			}
//			// Apply the pure evil.
//			newStack.set(DataComponentTypes.REPAIR_COST, pureEvil);
			// Um... Actually, how about we UN-apply the pure evil, tee hee!
			newStack.set(DataComponentTypes.REPAIR_COST, null);
			// Disclaimer: "Un-setting" a component has no effect on an item which already lacks said component.
			// Ask your doctor if un-setting data components is right for you.
			
			EnchantmentHelper.set(newStack, enchantmentBuilder.build());
		}
		
		this.output.setStack(0, newStack);
		this.sendContentUpdates();
	}
	
	
	public static int getNextCost(int cost) { // Deprecated method of pure, unadulterated evil. And maybe some additional adulterated evil. Possibly a little medium-refinement evil thrown in there, too.
		return 0;
	}
	
	
	public boolean setNewItemName(String newItemName) {
		String string = sanitize(newItemName);
		if (string != null && !string.equals(this.newItemName)) {
			this.newItemName = string;
			if (this.getSlot(2).hasStack()) {
				ItemStack itemStack = this.getSlot(2).getStack();
				if (StringHelper.isBlank(string)) {
					itemStack.remove(DataComponentTypes.CUSTOM_NAME);
				} else {
					itemStack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(string));
				}
			}
			
			this.updateResult();
			return true;
		} else {
			return false;
		}
	}
	
	
	@Nullable
	private static String sanitize(String name) {
		String string = StringHelper.stripInvalidChars(name);
		return string.length() <= 50 ? string : null;
	}
	
	
	public int getLevelCost() {
		return this.levelCost.get();
	}
}
