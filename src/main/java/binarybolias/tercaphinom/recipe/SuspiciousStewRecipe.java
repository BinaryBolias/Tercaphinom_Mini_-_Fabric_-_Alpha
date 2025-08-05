package binarybolias.tercaphinom.recipe;

import binarybolias.tercaphinom.recipe.remainderOverride.EmptyRemainderOverride;
import binarybolias.tercaphinom.references.ModItems;
import binarybolias.tercaphinom.references.ModRecipes;
import net.minecraft.block.SuspiciousStewIngredient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


/**
 * A replacement for the vanilla {@link net.minecraft.recipe.SuspiciousStewRecipe}.
 * Using a Bowl of Steaming Water instead of an empty bowl, and two Baked Mushrooms instead of one Red Mushroom and one Brown Mushroom.
 * Also overrides the remainder of the Bowl of Steaming Water to not return an Empty Bowl.
 */
public class SuspiciousStewRecipe extends SpecialCraftingRecipe {
	public SuspiciousStewRecipe(CraftingRecipeCategory category) {
		super(category);
	}
	
	
	@Override
	public boolean matches(RecipeInputInventory inventory, World world) {
		boolean contains_first_mushroom = false;
		boolean contains_second_mushroom = false;
		boolean contains_small_flower = false;
		boolean contains_bowl = false;
		
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack itemStack = inventory.getStack(i);
			if (!itemStack.isEmpty()) {
				if (itemStack.isOf(ModItems.BAKED_MUSHROOM) && !contains_first_mushroom) {
					contains_first_mushroom = true;
				} else if (itemStack.isOf(ModItems.BAKED_MUSHROOM) && !contains_second_mushroom) {
					contains_second_mushroom = true;
				} else if (itemStack.isIn(ItemTags.SMALL_FLOWERS) && !contains_small_flower) {
					contains_small_flower = true;
				} else {
					if (!itemStack.isOf(ModItems.BOWL_OF_STEAMING_WATER) || contains_bowl) {
						return false;
					}
					
					contains_bowl = true;
				}
			}
		}
		
		return contains_first_mushroom && contains_second_mushroom && contains_small_flower && contains_bowl;
	}
	
	
	@Override
	public ItemStack craft(RecipeInputInventory inventory, RegistryWrapper.WrapperLookup lookup) {
		ItemStack itemStack = new ItemStack(Items.SUSPICIOUS_STEW);
		
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack ingredientStack = inventory.getStack(i);
			if (!ingredientStack.isEmpty()) {
				SuspiciousStewIngredient suspiciousStewIngredient = SuspiciousStewIngredient.of(ingredientStack.getItem());
				if (suspiciousStewIngredient != null) {
					itemStack.set(DataComponentTypes.SUSPICIOUS_STEW_EFFECTS, suspiciousStewIngredient.getStewEffects());
					break;
				}
			}
		}
		
		return itemStack;
	}
	
	
	@Override
	public boolean fits(int width, int height) {
		return width >= 2 && height >= 2;
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		// No remainder.
		return EmptyRemainderOverride.remainder(inventory);
	}
	
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.SUSPICIOUS_STEW;
	}
}
