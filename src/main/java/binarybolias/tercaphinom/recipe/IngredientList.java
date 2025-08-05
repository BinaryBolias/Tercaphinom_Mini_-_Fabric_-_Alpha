package binarybolias.tercaphinom.recipe;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.recipe.Ingredient;


public record IngredientList(Ingredient[] ingredients) {
	private static final int MAX_AMOUNT = 9;
	
	
//	public static IngredientList create(Ingredient... ingredients) {
//		if (ingredients.length == 0) {
//			return null;
//		}
//
//		final int size = Math.min(MAX_AMOUNT, ingredients.length);
//		Ingredient[] array = new Ingredient[size];
//
//		System.arraycopy(ingredients, 0, array, 0, size);
//
//		return IngredientList()
//		//TODO: Return IngredientList with assigned array?
//	}
	//TODO: Data stream or whatever for IngredientList creation?
	
	
	public boolean matches(RecipeInputInventory inventory) {
		return matches(inventory, IngredientQuota.getDefault(ingredients.length));
	}
	
	
	public boolean matches(RecipeInputInventory inventory, IngredientQuota quota) {
		return false;
		//TODO: Return 'true' if the input of 'inventory' fully match 'ingredients' of self, and the quota is perfectly matched.
		// - No extra ingredients; immediately return 'false' if an input is found which does not exist in 'ingredients'.
		// - Note: A single input could potentially match multiple ingredients...
		// - Or perhaps use a dedicated recipe matcher class instead?
	}
}
