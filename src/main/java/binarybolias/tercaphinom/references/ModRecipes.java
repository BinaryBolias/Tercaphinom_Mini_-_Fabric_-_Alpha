package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.recipe.*;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * @see RecipeSerializer
 */
public class ModRecipes {
	public ModRecipes() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static RecipeSerializer<BasicGridRecipe> BASIC_GRID_RECIPE;
	public static RecipeSerializer<BucketFertilizerTransfer> BUCKET_FERTILIZER_TRANSFER;
	public static RecipeSerializer<SuspiciousStewRecipe> SUSPICIOUS_STEW;
	public static RecipeSerializer<WaterTransferRecipe> WATER_TRANSFER;
	public static RecipeSerializer<ReinforcedStainedGlassBlock> REINFORCED_STAINED_GLASS_BLOCK;
	
	
	public static void register() {
		logMainEvent("Registering recipes");
		
		//# Fundamental #
		BASIC_GRID_RECIPE = register(
				"basic_grid_crafting", new BasicGridRecipe.Serializer());
		//# Specific #
		BUCKET_FERTILIZER_TRANSFER = register(
				"crafting_special_bucket_fertilizer_transfer", new SpecialRecipeSerializer<>(BucketFertilizerTransfer::new));
		SUSPICIOUS_STEW = register(
				"crafting_special_suspicious_stew", new SpecialRecipeSerializer<>(SuspiciousStewRecipe::new));
		WATER_TRANSFER = register(
				"crafting_special_water_transfer", new SpecialRecipeSerializer<>(WaterTransferRecipe::new));
		//# Joke & Unserious #
		REINFORCED_STAINED_GLASS_BLOCK = register(
				"reinforced_stained_glass_block", new SpecialRecipeSerializer<>(ReinforcedStainedGlassBlock::new));
	}
	
	
	// NOTE: This is from reverse-engineering the recipe serializer for vanilla recipes.
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
		return Registry.register(Registries.RECIPE_SERIALIZER, identifier(name), serializer);
	}
	
	// NOTE: This is from
//	public static void register(String name, RecipeSerializer<?> serializer) {
//		Registry.register(Registries.RECIPE_SERIALIZER, identifier(name), serializer);
//	}
	
	
	public static void register(String name, RecipeType<?> recipeType) {
		Registry.register(Registries.RECIPE_TYPE, identifier(name), recipeType);
	}
}
