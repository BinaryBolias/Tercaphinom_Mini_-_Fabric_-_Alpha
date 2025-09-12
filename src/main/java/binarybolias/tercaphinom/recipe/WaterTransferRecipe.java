package binarybolias.tercaphinom.recipe;


import binarybolias.tercaphinom.references.ModItems;
import binarybolias.tercaphinom.references.ModRecipes;
import binarybolias.tercaphinom.references.Reference;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Objects;


public class WaterTransferRecipe extends SpecialCraftingRecipe {
	public WaterTransferRecipe(CraftingRecipeCategory category) {
		super(category);
	}
	
	private static final Item BOWL_OF_WATER_ITEM = ModItems.BOWL_OF_WATER;
	private static final Item BUCKET_OF_WATER_ITEM = Items.WATER_BUCKET;
	private static final Item EMPTY_BOTTLE_ITEM = Items.GLASS_BOTTLE;
	private static final Item EMPTY_BOWL_ITEM = Items.BOWL;
	private static final Item EMPTY_BUCKET_ITEM = Items.BUCKET;
	private static final PotionItem POTION_ITEM = (PotionItem) Items.POTION;
	
	
	@Override
	public boolean matches(RecipeInputInventory inventory, World world) {
		boolean containsEmptyBottle = false;
		boolean containsBottleOfWater = false;
		boolean containsEmptyBowl = false;
		boolean containsBowlOfWater = false;
		boolean containsEmptyBucket = false;
		boolean containsBucketOfWater = false;
		int inputCount = 0;
		
		// Return 'true' if input consists of:
		//  - An Empty Bottle and a Bowl of Water.
		//  - An Empty Bowl and a Bottle of Water (Potion of type "water")
		//  - An Empty Bucket and three of either Bottles of Water or Bowls of Water.
		//  - A Bucket of Water and three of either Empty Bottles or Empty Bowls.
		
		// Tally up the included ingredients, or fail the match if an invalid ingredient is included.
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack itemStack = inventory.getStack(i);
			if (!itemStack.isEmpty()) {
				// Check for Empty Bottle. Disallow mutual presence with Bottle of Water.
				if (itemStack.isOf(EMPTY_BOTTLE_ITEM)) {
					if (containsBottleOfWater) {
						return false;
					}
					containsEmptyBottle = true;
					inputCount += 1;
					continue;
				}
				
				// Check for Bottle of Water. Disallow mutual presence with Empty Bottle.
				// Disallow Potion of type other than "water".
				if (itemStack.isOf(POTION_ITEM)) {
					if (containsEmptyBottle) {
						return false;
					} else if (Objects.requireNonNull(itemStack.get(DataComponentTypes.POTION_CONTENTS)).matches(Potions.WATER)) {
						containsBottleOfWater = true;
						inputCount += 1;
						continue;
					}
					// Incorrect potion type.
					return false;
				}
				
				// Check for Empty Bowl. Disallow mutual presence with Bowl of Water.
				if (itemStack.isOf(EMPTY_BOWL_ITEM)) {
					if (containsBowlOfWater) {
						return false;
					}
					containsEmptyBowl = true;
					inputCount += 1;
					continue;
				}
				
				// Check for Bowl of Water. Disallow mutual presence with Empty Bowl.
				if (itemStack.isOf(BOWL_OF_WATER_ITEM)) {
					if (containsEmptyBowl) {
						return false;
					}
					containsBowlOfWater = true;
					inputCount += 1;
					continue;
				}
				
				// Check for Empty Bucket. Only allow 1 bucket at most.
				if (itemStack.isOf(EMPTY_BUCKET_ITEM)) {
					if (containsEmptyBucket | containsBucketOfWater) {
						return false;
					}
					containsEmptyBucket = true;
					inputCount += 1;
					continue;
				}
				
				// Check for Bucket of Water. Only allow 1 bucket at most.
				if (itemStack.isOf(BUCKET_OF_WATER_ITEM)) {
					if (containsBucketOfWater | containsEmptyBucket) {
						return false;
					}
					containsBucketOfWater = true;
					inputCount += 1;
					continue;
				}
				
				// Ingredient not identified; item of 'itemStack' is prohibited.
				return false;
			}
		}
		// Check the input count and included item types to determine whether a valid recipe has been matched.
		switch (inputCount) {
			case 2 -> {
				// Check for bottle-bowl transfer.
				return (containsEmptyBottle && containsBowlOfWater) || (containsEmptyBowl && containsBottleOfWater);
			}
			case 4 -> {
				// Check for bucket transfer.
				if (containsEmptyBucket) {
					// Filling bucket from small containers; must not contain empty small containers.
					return (!containsEmptyBottle && !containsEmptyBowl);
				} else if (containsBucketOfWater) {
					// Filling small containers from bucket; must not contain filled small containers.
					return (!containsBottleOfWater && !containsBowlOfWater);
				}
				// There is no bucket and I must scream.
				return false;
			}
			default -> {
				// Input count is not 2 nor 4.
				return false;
			}
		}
	}
	
	
	@Override
	public ItemStack craft(RecipeInputInventory inventory, RegistryWrapper.WrapperLookup lookup) {
		boolean containsEmptyBottle = false;
		boolean containsBottleOfWater = false;
		boolean containsEmptyBowl = false;
		boolean containsBowlOfWater = false;
		// Return bucket of opposite fullness state if a bucket is found, else just detect presence of bottles and bowls.
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack itemStack = inventory.getStack(i);
			if (!itemStack.isEmpty()) {
				if (itemStack.isOf(EMPTY_BOTTLE_ITEM)) {
					containsEmptyBottle = true;
					continue;
				}
				if (itemStack.isOf(POTION_ITEM)) {
					containsBottleOfWater = true;
					continue;
				}
				if (itemStack.isOf(EMPTY_BOWL_ITEM)) {
					containsEmptyBowl = true;
					continue;
				}
				if (itemStack.isOf(BOWL_OF_WATER_ITEM)) {
					containsBowlOfWater = true;
					continue;
				}
				if (itemStack.isOf(EMPTY_BUCKET_ITEM)) {
					return new ItemStack(BUCKET_OF_WATER_ITEM);
				}
				if (itemStack.isOf(BUCKET_OF_WATER_ITEM)) {
					return new ItemStack(EMPTY_BUCKET_ITEM);
				}
			}
		}
		// Check for transfer from bowl to bottle.
		if (containsEmptyBottle && containsBowlOfWater) {
			ItemStack itemStack = new ItemStack(POTION_ITEM);
			itemStack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER));
			return itemStack;
		}
		// Check for transfer from bottle to bowl.
		if (containsEmptyBowl && containsBottleOfWater) {
			return new ItemStack(BOWL_OF_WATER_ITEM);
		}
		Reference.logError("WaterTransferRecipe: Output item could not be determined.");
		return null;
	}
	
	
	@Override
	public boolean fits(int width, int height) {
		return width >= 2 && height >= 2;
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		// Check for Bucket of Water.
		boolean containsBucketOfWater = false;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.getStack(i).isOf(BUCKET_OF_WATER_ITEM)) {
				containsBucketOfWater = true;
				break;
			}
		}
		// Bucket of Water presence indicates filling small containers from water.
		if (containsBucketOfWater) {
			// Override remainders of empty small containers to their filled variants.
			DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
			for (int i = 0; i < inventory.size(); i++) {
				Item item = inventory.getStack(i).getItem();
				if (item == Items.AIR) {
					continue;
				} else if (item == EMPTY_BOTTLE_ITEM) {
					// Replace Empty Bottle with Bottle of Water.
					ItemStack itemStack = new ItemStack(POTION_ITEM);
					itemStack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER));
					defaultedList.set(i, itemStack);
				} else if (item == EMPTY_BOWL_ITEM) {
					// Replace Empty Bowl with Bowl of Water.
					defaultedList.set(i, new ItemStack(BOWL_OF_WATER_ITEM));
				}
				// Don't provide a remainder for Bucket of Water (the only remaining item type possible here).
				// Empty Bucket would be given as crafting output to compensate.
			}
			return defaultedList;
		} else {
			boolean containsBottleOfWater = false;
			boolean containsEmptyBowl = false;
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.getStack(i).isOf(POTION_ITEM)) {
					containsBottleOfWater = true;
					continue;
				}
				if (inventory.getStack(i).isOf(EMPTY_BOWL_ITEM)) {
					containsEmptyBowl = true;
					continue;
				}
				if (inventory.getStack(i).isOf(EMPTY_BUCKET_ITEM)) {
					// Override remainder of potion to Empty Bottle. Also manhandle the empty bowl remainder.
					DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
					for (int j = 0; j < inventory.size(); j++) {
						Item item = inventory.getStack(j).getItem();
						if (item == POTION_ITEM) {
							defaultedList.set(j, new ItemStack(EMPTY_BOTTLE_ITEM));
						} else if (item == BOWL_OF_WATER_ITEM) {
							defaultedList.set(j, new ItemStack(EMPTY_BOWL_ITEM));
						}
					}
					return defaultedList;
				}
			}
			if (containsBottleOfWater && containsEmptyBowl) {
				// Override remainder of potion to Empty Bottle.
				DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
				for (int i = 0; i < inventory.size(); i++) {
					Item item = inventory.getStack(i).getItem();
					if (item == POTION_ITEM) {
						defaultedList.set(i, new ItemStack(EMPTY_BOTTLE_ITEM));
						return defaultedList; // Technically overriding remainder of Empty Bowl too, but it's already null.
					}
				}
			}
			// Return default remainders if not filling small containers from bucket, nor transferring from bottle to bowl.
			return super.getRemainder(inventory);
		}
	}
	
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.WATER_TRANSFER;
	}
}
