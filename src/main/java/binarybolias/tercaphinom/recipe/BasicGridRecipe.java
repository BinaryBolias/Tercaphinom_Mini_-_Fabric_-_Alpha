package binarybolias.tercaphinom.recipe;

import binarybolias.tercaphinom.recipe.remainderOverride.EmptyRemainderOverride;
import binarybolias.tercaphinom.recipe.remainderOverride.RecipeRemainderOverride;
import binarybolias.tercaphinom.references.ModRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


/**
 * A replacement for vanilla basic grid crafting recipes.
 * Currently designed to behave merely as a shapeless recipe.
 * TODO: Implement remainder override functionality.
 * @see binarybolias.tercaphinom.datagen.recipe.BasicGridRecipeJsonBuilder
 * @see net.minecraft.recipe.Recipe
 * @see net.minecraft.recipe.ShapedRecipe
 * @see net.minecraft.recipe.ShapelessRecipe
 */
public class BasicGridRecipe implements CraftingRecipe {
	final String group;
	final CraftingRecipeCategory category;
	final ItemStack result;
	final DefaultedList<Ingredient> ingredients; // TODO: Replace with an 'IngredientList'.
	
	//TODO: Implement remainder override functionality:
	// - If null, fall back to returning the default remainders for items.
	@Nullable
	final RecipeRemainderOverride remainderOverride = null;
	
	// TODO: Overhaul input handling:
	//TODO: create an 'GridRecipeInputForm' class:
	// - Does not itself contain ingredients; the recipe's ingredient list is instead passed into it.
	// - Contains requirement definition for a successful match.
	//  - Includes a quota for each ingredient and any number of ingredient shapes.
	// - A shape is stored as an array of integers.
	//  - Array size equal to 2 plus the product of shape width and shape height.
	//  - First two integers represent the shape width and height, respectively.
	//  - Each integer after the first two corresponds to an index of a passed-in ingredient list.
	// - A quota is stored as an array of integers, with each value corresponding to the exact amount required of a passed-in ingredient.
	//  - No value may be '0'; all non-included ingredients are implicitly treated as having quota values of '0'.
	//  - The passed-in ingredient and its quota value have the same index in their corresponding arrays.
	//  - All indices referenced by each shape must be less than the size of the quota; an index out of bounds for the quota would also be out of bounds for the ingredient list.
	//  - No shape can have a greater amount of a given index than defined by the quota (but is allowed to have less).
	// - An input inventory matches the recipe if the inventory adheres to at least 1 shape while simultaneously meeting the full quota.
	//  - The quota can be checked first.
	//  - This naturally allows for both shaped and shapeless crafting, as well as hybrid crafting where only some ingredients have a required shape.
	// - Maybe just include a quota and shape list here directly?
	// - We would ideally be able to consolidate ingredient lists, quotas, and/or shapes, reusing references to them between recipes as applicable.
	//final InputForm inputForm; // Possibly not this.
	// - 'InputForm' could be a list of lists of integers?
	//  - First list of integers is the quota, each one after (if any) is a shape.
	//   - Each list needs separate size handling... what about putting everything into a single list of integers?
	//
	//final List<Ingredient> ingredients; // Not a DefaultedList; don't know what benefit we'd gain from that...
	//final List<int> quota;
	//final List<List<int>> shapes; // Perhaps a custom 'GridRecipeShape' interface or something?
	//
	// Perhaps use bytes instead of ints; we don't expect to be using more than 9 inputs, let alone more than 128.
	//final List<byte> quota;
	//final List<List<byte>> shapes; // Perhaps a custom 'GridRecipeShape' interface or something?
	//
 	// Perhaps use arrays instead of lists, since we don't need to change their lengths after initialization.
	//final Ingredient[] ingredients; // Not a DefaultedList; don't know what benefit we'd gain from that...
	//final byte[] quota;
	//final byte[][] shapes; // Would this syntax work for defining an array of arrays of bytes?
	
	
	public BasicGridRecipe(String group, CraftingRecipeCategory category, ItemStack result, DefaultedList<Ingredient> ingredients) {
		this.group = group;
		this.category = category;
		this.result = result;
		this.ingredients = ingredients; // TODO: Use an 'ingredients' variable that can be either shaped or shapeless?
	}
	
	
	@Override
	public CraftingRecipeCategory getCategory() {
		return category;
	}
	
	
	@Override
	public boolean matches(RecipeInputInventory inventory, World world) {
		// NOTE: Assumes the recipe to be shapeless.
		RecipeMatcher recipeMatcher = new RecipeMatcher();
		int inputItemAmount = 0;
		
		for (int inputSlotIndex = 0; inputSlotIndex < inventory.size(); inputSlotIndex++) {
			ItemStack itemStack = inventory.getStack(inputSlotIndex);
			if (!itemStack.isEmpty()) {
				inputItemAmount++;
				recipeMatcher.addInput(itemStack, 1);
			}
		}
		
		return inputItemAmount == ingredients.size() && recipeMatcher.match(this, null);
		//TODO: Defer to ingredients variable instead.
		// e.g:
		//  return gridRecipeInput.matches(inventory);
	}
	
	
	@Override
	public ItemStack craft(RecipeInputInventory inventory, RegistryWrapper.WrapperLookup lookup) {
		return result.copy();
	}
	
	
	@Override
	public boolean fits(int width, int height) {
		// NOTE: Assumes the recipe to be shapeless.
		return width * height >= ingredients.size();
		//TODO: Defer to ingredients variable instead.
		// e.g:
		//  return gridRecipeInput.fits(width, height);
	}
	
	
	@Override
	public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
		return result;
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		if (remainderOverride == null) {
			return CraftingRecipe.super.getRemainder(inventory);
		}
		return remainderOverride.getRemainder(inventory);
	}
	
	
	@Override
	public DefaultedList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
	@Override
	public String getGroup() {
		return group;
	}
	
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.BASIC_GRID_RECIPE;
	}
	
	
	public static class Serializer implements RecipeSerializer<BasicGridRecipe> {
		//TODO: Handle saving and loading JSON data for remainder overrides.
		// - Should be done via the RecipeRemainderOverride class or inheriting classes?
		// - Always look for an object corresponding to a "remainder_override" keyword; the object is to contain remainder override data.
		//  - If present, this object should always have a string corresponding to the "type" keyword, which corresponds to an identifier of 'RecipeRemainderOverride.Type'.
		//   - ("none", "constant", "ingredient_type", or "ingredient_index")
		//   - NONE: Doesn't do anything; same as "remainder_override" object not being present.
		//   - CONSTANT: Optionally uses a list of "items", and (with a list of items) a "shape".
		//    - Corresponds to an empty remainder if the item list is not present.
		//   - INGREDIENT_TYPE: Uses a list of objects containing "input"-"remainder" pairs.
		//   - INGREDIENT_INDEX: Uses a list of objects containing "key"-"remainder" pairs.
		//    - This type either requires access to the recipe ingredient list and/or pattern, or else will simply be an alias for INGREDIENT_TYPE, not using its own class...
		
		private static final MapCodec<BasicGridRecipe> CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(
						Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
						CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(recipe -> recipe.category),
						ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
						Ingredient.DISALLOW_EMPTY_CODEC
								.listOf()
								.fieldOf("ingredients")
								.flatXmap(
										ingredients1 -> {
											Ingredient[] ingredients2 = ingredients1.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
											if (ingredients2.length == 0) {
												return DataResult.error(() -> "No ingredients for basic grid recipe");
											} else {
												return ingredients2.length > 9
														? DataResult.error(() -> "Too many ingredients for basic grid recipe")
														: DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients2));
											}
										},
										DataResult::success
								)
								.forGetter(recipe -> recipe.ingredients)
				).apply(instance, BasicGridRecipe::new)
		);
		
		
		public static final PacketCodec<RegistryByteBuf, BasicGridRecipe> PACKET_CODEC = PacketCodec.ofStatic(
				BasicGridRecipe.Serializer::write, BasicGridRecipe.Serializer::read
		);
		
		
		@Override
		public MapCodec<BasicGridRecipe> codec() {
			return CODEC;
		}
		
		
		@Override
		public PacketCodec<RegistryByteBuf, BasicGridRecipe> packetCodec() {
			return PACKET_CODEC;
		}
		
		
		private static BasicGridRecipe read(RegistryByteBuf buf) {
			String group = buf.readString();
			CraftingRecipeCategory category = buf.readEnumConstant(CraftingRecipeCategory.class);
			int i = buf.readVarInt();
			DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(i, Ingredient.EMPTY);
			ingredients.replaceAll(empty -> Ingredient.PACKET_CODEC.decode(buf));
			ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
			return new BasicGridRecipe(group, category, result, ingredients);
		}
		
		
		private static void write(RegistryByteBuf buf, BasicGridRecipe recipe) {
			buf.writeString(recipe.group);
			buf.writeEnumConstant(recipe.category);
			buf.writeVarInt(recipe.ingredients.size());
			
			for (Ingredient ingredient : recipe.ingredients) {
				Ingredient.PACKET_CODEC.encode(buf, ingredient);
			}
			
			ItemStack.PACKET_CODEC.encode(buf, recipe.result);
		}
	}
}
