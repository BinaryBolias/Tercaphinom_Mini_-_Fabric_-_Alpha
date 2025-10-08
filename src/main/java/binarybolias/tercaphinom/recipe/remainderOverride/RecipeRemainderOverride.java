package binarybolias.tercaphinom.recipe.remainderOverride;

import binarybolias.tercaphinom.recipe.BasicGridRecipe;
import binarybolias.tercaphinom.references.Reference;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;


//TODO: Should this be a record instead of a class?
// - Ideally, a variable of this type could be set to 'null' within BasicGridRecipe to denote when a recipe uses default remainders.
// - Abstract? Only classes extending this one should be used directly; the role of this class is definitive, but the way it does it may be diverse.
//  - One derivative produces no remainder, regardless of input.
//   - This would logically be a subtype of constant remainder, simply with no items defined.
//   - Except, there could still be a separate class/record for empty, to provide a simpler method to return nothing.
//  - One derivative produces a constant remainder, regardless of input.
//   - Can optionally define a shape for the remainder.
//  - One derivative overrides remainders on a per-item basis, using a hash map of items to items.
//   - Items not found in the hash map use their default remainders.
//   - Items can have their remainders overridden to nothing.
//  - One derivative might override based on the index of the input ingredients?
//   - This may need to cooperate with the recipe shape and/or quota, particularly in cases where multiple ingredients in the list are the same.
//TODO:
// - Implement mechanism for saving/loading JSON data.
//  - Should be referenced within BasicGridRecipe.
// - Add the ability for a recipe remainder override to be added through the BasicGridRecipeJsonBuilder.
//  - We can start with adding the "constant" type, which requires no extra parameters.
//   - With no extra parameters, the EmptyRemainderOverride instance will be used.
/**
 * @see BasicGridRecipe
 * @see net.minecraft.recipe.RawShapedRecipe
 *
 * @see EmptyRemainderOverride
 * @see ConstantRemainderOverride
 * @see ItemMapRemainderOverride
 */
public abstract class RecipeRemainderOverride {
	public enum Type { //TODO: Implement 'StringIdentifiable'?
		NONE("none"), // Corresponds to a null value.
		EMPTY("empty"), // Corresponds to an override which enforces no items as the remainder.
		CONSTANT("constant"), // Corresponds to an override which always produces the same remainder.
		ITEM_MAP("item_map"); // Corresponds to an override which replaces default remainders per item.
		//TODO:
		// - Require 'CONSTANT' and 'ITEM_TYPE' to supply data when reading from JSON.
		
		// To be used for interfacing with JSON data.
		// When reading a JSON file, the expected format of the remainder override object is to be based on the given
		//  "type" parameter (a string), which should correspond to one of these valid identifiers.
		// Each enum entry should have a unique identifier.
		final String identifier;
		
		
		Type(String identifier) {
			this.identifier = identifier;
		}
		
		
		public String getIdentifier() {
			return this.identifier;
		}
	}
	
	
	/**
	 * Returns a recipe remainder override type based on the given string. Returns NONE and prints a warning if the
	 * string is not recognized as a valid type identifier.
	 */
	public static Type getType(String identifier) {
		if (identifier.equals(Type.EMPTY.identifier)) {
			return Type.EMPTY;
		}
		if (identifier.equals(Type.CONSTANT.identifier)) {
			return Type.CONSTANT;
		}
		if (identifier.equals(Type.ITEM_MAP.identifier)) {
			return Type.ITEM_MAP;
		}
		// Explicitly check for "none" last; assumed to not usually be used in JSON files,
		//  with the remainder override object simply being made absent instead.
		if (identifier.equals(Type.NONE.identifier)) {
			return Type.NONE;
		}
		Reference.logWarning("Recipe remainder override type \"" + identifier + "\" does not exist.");
		return Type.NONE;
	}
	
	
	public abstract DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory);
}
