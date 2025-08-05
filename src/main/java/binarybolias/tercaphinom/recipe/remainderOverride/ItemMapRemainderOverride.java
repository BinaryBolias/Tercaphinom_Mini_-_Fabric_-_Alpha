package binarybolias.tercaphinom.recipe.remainderOverride;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;


public class ItemMapRemainderOverride extends RecipeRemainderOverride {
	private static ArrayList<ItemMapRemainderOverride> INSTANCES = new ArrayList<>();
	
	final Map<Item, @Nullable Item> itemMap;
	
	
	private ItemMapRemainderOverride(Map<Item, @Nullable Item> itemMap) {
		this.itemMap = itemMap;
		//TODO: Use parameters for this method.
		// - Perhaps just 1 parameter; a map of ingredients?
	}
	
	
	/**
	 * Get an instance of this override, for use in recipes with procedurally-defined input remainders.
	 * @return the empty remainder override instance
	 */
	public static ItemMapRemainderOverride getInstance(Map<Item, @Nullable Item> itemMap) {
		return null;
		//TODO:
		// - Check all preexisting item map remainder override instances (within 'INSTANCES').
		//  - Return a preexisting instance if one already has a matching item map.
		//   - Else, create a new instance, adding it to the INSTANCES list, and return it.
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		return null; //TODO.
	}
}
