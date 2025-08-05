package binarybolias.tercaphinom.recipe.remainderOverride;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;


public class ConstantRemainderOverride extends RecipeRemainderOverride {
	private static ArrayList<ConstantRemainderOverride> INSTANCES = new ArrayList<>();
	
	final List<Item> items;
	final byte[] shape; // TODO: Create a shape record?
	
	
	private ConstantRemainderOverride(List<Item> items, byte[] shape) {
		this.items = items;
		this.shape = shape;
	}
	
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		return null;
	}
}
