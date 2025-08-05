package binarybolias.tercaphinom.recipe.remainderOverride;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;


public final class EmptyRemainderOverride extends RecipeRemainderOverride {
	private static EmptyRemainderOverride INSTANCE; // Only allow one instance, as all instances have identical function.
	
	
	private EmptyRemainderOverride() {}
	
	
	/**
	 * Get an instance of this override, for use in recipes with procedurally-defined input remainders.
	 * @return the empty remainder override instance
	 */
	public static EmptyRemainderOverride getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EmptyRemainderOverride();
		}
		return INSTANCE;
	}
	
	
	public static DefaultedList<ItemStack> remainder(RecipeInputInventory inventory) {
		return DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		return remainder(inventory);
	}
}
