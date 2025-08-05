package binarybolias.tercaphinom.recipe;

import binarybolias.tercaphinom.references.ModItems;
import binarybolias.tercaphinom.references.ModRecipes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


/**
 * Transfers damage between Buckets of Fertilizer, requiring both bucket stacks to be damaged, and be placed in a 1x2 shape.<br>
 * Overrides crafting ingredient remainders to disallow bucket duplication and facilitate damage transfer.
 * @see binarybolias.tercaphinom.references.ModItems
 * @see net.minecraft.recipe.RepairItemRecipe
 */
public class BucketFertilizerTransfer extends SpecialCraftingRecipe {
	public BucketFertilizerTransfer(CraftingRecipeCategory category) {
		super(category);
	}
	
	
	@Nullable
	private Pair<ItemStack, ItemStack> findPair(RecipeInputInventory inventory) {
		ItemStack itemStack1 = null;
		ItemStack itemStack2 = null;
		
		int secondStackIndex = inventory.getWidth();
		
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack newStack = inventory.getStack(i);
			if (!newStack.isEmpty()) { // The new stack is not empty.
				// Require the stack to be a Bucket of Fertilizer.
				if (!newStack.isOf(ModItems.BUCKET_OF_FERTILIZER)) {
					return null;
				}
				if (itemStack1 == null) {
					// Set the first (top) stack.
					itemStack1 = newStack;
					// Identify the expected position of the second stack (directly below the first).
					secondStackIndex += i;
				} else {
					if (i != secondStackIndex || itemStack2 != null) {
						// Too many stacks in the inventory, or the second stack is not in the correct position.
						return null;
					}
					// Set the second (bottom) stack.
					itemStack2 = newStack;
				}
			}
		}
		
		return itemStack1 != null && itemStack2 != null && canTransfer(itemStack1, itemStack2) ? Pair.of(itemStack1, itemStack2) : null;
	}
	
	
	private static boolean canTransfer(ItemStack first, ItemStack second) {
		// NOTE: Bucket of Fertilizer is assumed to have a max stack of 1 and be damageable.
		// Ensure both stacks are damaged; the crafting result would not be meaningful otherwise.
		return (first.getDamage() > 0) && (second.getDamage() > 0);
	}
	
	
	@Override
	public boolean matches(RecipeInputInventory inventory, World world) {
		return findPair(inventory) != null;
	}
	
	
	@Override
	public ItemStack craft(RecipeInputInventory inventory, RegistryWrapper.WrapperLookup lookup) {
		ItemStack itemStack = new ItemStack(ModItems.BUCKET_OF_FERTILIZER);
		
		// Find the top stack and set the output stack's damage.
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack checkedStack = inventory.getStack(i);
			
			if (!checkedStack.isEmpty()) {
				// 'i' is the top stack index.
				int topStackDurability = checkedStack.getMaxDamage() - checkedStack.getDamage();
				// Get the bottom stack.
				checkedStack = inventory.getStack(i + inventory.getWidth());
				int bottomStackDamage = checkedStack.getDamage();
				// Transfer amount is minimum between top stack durability and bottom stack damage.
				int transferAmount = Math.min(topStackDurability, bottomStackDamage);
				
				itemStack.setDamage(bottomStackDamage - transferAmount);
				
				break;
			}
		}
		
		return itemStack;
	}
	
	
	@Override
	public boolean fits(int width, int height) {
		return width >= 1 && height >= 2;
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
		
		// Find the top stack and set its remainder; bottom stack has no remainder.
		for (int i = 0; i < defaultedList.size(); i++) {
			ItemStack itemStack = inventory.getStack(i);
			
			if (!itemStack.isEmpty()) {
				// 'i' is the top stack index.
				int topStackDamage = itemStack.getDamage();
				int topStackDurability = itemStack.getMaxDamage() - topStackDamage;
				// Get the bottom stack.
				itemStack = inventory.getStack(i + inventory.getWidth());
				// Transfer amount is minimum between top stack durability and bottom stack damage.
				int transferAmount = Math.min(topStackDurability, itemStack.getDamage());
				
				ItemStack topStackRemainder;
				if (transferAmount == topStackDurability) {
					topStackRemainder = new ItemStack(Items.BUCKET);
				} else {
					topStackRemainder = new ItemStack(ModItems.BUCKET_OF_FERTILIZER);
					topStackRemainder.setDamage(topStackDamage + transferAmount);
				}
				
				defaultedList.set(i, topStackRemainder);
				
				break;
			}
		}
		
		return defaultedList;
	}
	
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.BUCKET_FERTILIZER_TRANSFER;
	}
}
