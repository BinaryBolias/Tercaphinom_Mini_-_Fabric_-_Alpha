package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.registry.tag.BlockTags;
import binarybolias.tercaphinom.registry.tag.ItemTags;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;


/**
 * Provides the default {@link ToolMaterial}s used by Tercaphinom's tools.
 * @see ModArmorMaterials
 * @see net.minecraft.item.ToolMaterials
 */
public enum ModToolMaterials implements ToolMaterial {
	//TODO: Repair materials:
	// - Use only materials defined here upon implementation of custom iron and gold equipment.
	// - Rework equipment stats upon making vanilla shafted tools and metal armor unobtainable.
	//  - Copper, Gold, Iron, and Brass to all have higher durability.
	//  - Base attack damage of all tier 3 tools (except nutrillarn and perhaps dementhum) should probably be 3.0.
	// - Modded equipment repairs with grams while vanilla repairs with ingots.
	// - Modify anvil behavior:
	//  - Do not produce nor propagate any hidden "anvil uses" attribute.
	//   - Items can be repaired or merged an unlimited amount of times, except when merging items produces too high a cost.
	//  - Display a meter for anvil work cost, and make renaming and repair/merge mutually exclusive?
	//   - The name input field is to be replaced with a cost meter when an item is put into the material slot.
	//   - The material slot is to be locked when the name input field has a new name.
	//   - Renaming never advances the wear of the anvil block.
	//   - Repair/merge has a chance of advancing anvil block wear based on cost in proportion to maximum.
	//   - Repair/merge cannot be performed when anvil wear is at maximum.
	//    - Message: "Anvil needs repair"
	//    - Anvil thus can never break completely.
	//    - Renaming is still allowed.
	//     - Anvil block wear can never remove the ability to rename an item (e.g by breaking the anvil, as in VMc).
	
	// NOTE: Tool "tiers" no longer matter for block destruction; the "INCORRECT_FOR" tags are deprecated.
	// "INCORRECT_FOR" tags replaced with 'BlockTags.NIL' for brevity.
	
	// Tier 0: Wooden Stick
	WOODEN_STICK(BlockTags.NIL, 7, 2.0F, 0.0F, 0,
			() -> Ingredient.ofItems(Items.STICK)),
	// Tier 1: Wood
	WOOD(BlockTags.NIL, 59, 2.0F, 1.0F, 15,
			() -> Ingredient.fromTag(ItemTags.ALL_PLANKS)),
	// Tier 2: Shard
	AMETHYST(BlockTags.NIL, 100, 4.0F, 2.0F, 1,
			() -> Ingredient.ofItems(Items.AMETHYST_SHARD)),
	CRYING_OBSIDIAN(BlockTags.NIL, 60, 6.0F, 4.0F, 15,
			() -> Ingredient.ofItems(ModItems.OBSIDIAN_SHARD)), // TODO: Rename and provide new repair material.
	FLINT(BlockTags.NIL, 120, 3.0F, 2.0F, 5,
			() -> Ingredient.ofItems(Items.FLINT)),
	GLASS(BlockTags.NIL, 108, 4.0F, 2.0F, 0,
			() -> Ingredient.ofItems(ModItems.GLASS_SHARD)),
	OBSIDIAN(BlockTags.NIL, 96, 5.0F, 3.0F, 7,
			() -> Ingredient.ofItems(ModItems.OBSIDIAN_SHARD)),
	// Tier 3: Metal/Metalloid
	COPPER(BlockTags.NIL, 228, 6.0F, 2.0F, 15,
			() -> Ingredient.ofItems(ModItems.COPPER_GRAM)),
	// (gold and iron here are presently just quick references for vanilla)
	//GOLD(BlockTags.NIL, 32, 12.0F, 0.0F, 22,
	//			() -> Ingredient.ofItems(ModItems.GOLD_GRAM));
	//IRON(BlockTags.NIL, 250, 6.0F, 2.0F, 14,
	//			() -> Ingredient.ofItems(ModItems.IRON_GRAM));
	BRASS(BlockTags.NIL, 276, 5.0F, 2.0F, 14,
			() -> Ingredient.ofItems(ModItems.BRASS_GRAM)),
	EIDURIL(BlockTags.NIL, 1440, 8.0F, 3.0F, 12,
			() -> Ingredient.ofItems(ModItems.EIDURIL_GRAM)),
	// ("Netherite" as placeholder name)
	//NETHERITE(BlockTags.NIL, 2031, 9.0F, 4.0F, 15,
	//			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT));
	NUTRILLARN(BlockTags.NIL, 96, 12.0F, 7.0F, 0,
			() -> Ingredient.ofItems(JAUItems.NUTRILLARN_GRAM));
	
	private final TagKey<Block> inverseTag;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairIngredient;
	
	ModToolMaterials(
			final TagKey<Block> inverseTag,
			final int itemDurability,
			final float miningSpeed,
			final float attackDamage,
			final int enchantability,
			final Supplier<Ingredient> repairIngredient
	) {
		this.inverseTag = inverseTag;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = Suppliers.memoize(repairIngredient::get);
	}
	
	
	@Override
	public int getDurability() {
		return itemDurability;
	}
	
	
	@Override
	public float getMiningSpeedMultiplier() {
		return miningSpeed;
	}
	
	
	@Override
	public float getAttackDamage() {
		return attackDamage;
	}
	
	
	//TODO: Shortcut this to just always return 'BlockTags.NIL'?
	// - We could remove the 'inverseTag' parameter from tool materials defined here.
	@Override
	public TagKey<Block> getInverseTag() {
		return inverseTag;
	}
	
	
	@Override
	public int getEnchantability() {
		return enchantability;
	}
	
	
	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}
}
