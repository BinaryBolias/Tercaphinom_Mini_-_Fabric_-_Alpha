package binarybolias.tercaphinom.recipe;


import net.minecraft.inventory.RecipeInputInventory;


public record GridShape(byte width, byte height, byte[] pattern) {
	private static final int MAX_EXTENT = 3;
	
	
	public boolean fits(int width, int height) {
		return this.width >= width && this.height >= height;
	}
	
	
	public boolean matches(RecipeInputInventory inventory, IngredientList ingredientList, IngredientQuota quota) {
		return false;
		//TODO: Perhaps export this functionality to BasicGridRecipe instead?
		// - Could perhaps consolidate multiple shapes?
		// - Maybe just don't handle quota here; only check for shape, allowing not all ingredients to be present.
		//  - Perhaps different methods for requiring all ingredients versus only requiring no invalid inputs?
		//   - "strict" versus "loose"?
		//    - Both need to first identify the location of the shape within the 'inventory' (crafting grid).
		//    - Both also require each cell of the shape to contain an item which matches the ingredient of index based on 'pattern'.
		//    - Strict requires all values of '-1' (or less than '0') within 'pattern' to correspond to empty cells in 'inventory'.
		//   - Perhaps return a list of the ingredients used?
		//    - Same format of a quota; 'byte[]', index corresponding to index of ingredient, value corresponding to amount found.
		//    - Method name of "findIngredients"?
		// - Or perhaps use a dedicated recipe matcher class instead?
	}
	
	
	// The grid shape is incompatible with any list of items which has a length less than the pattern's highest index.
	public int highestIndex() {
		int highest_index = -1;
		
		for (byte b : pattern) {
			highest_index = Math.max(highest_index, b);
		}
		
		return highest_index;
	}
}
