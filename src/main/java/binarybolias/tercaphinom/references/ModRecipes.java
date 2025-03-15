package binarybolias.tercaphinom.references;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModRecipes {
	public ModRecipes() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering recipes");
	}
	
	public static void register(String name, RecipeSerializer<?> serializer) {
		Registry.register(Registries.RECIPE_SERIALIZER, identifier(name), serializer);
	}
	
	public static void register(String name, RecipeType<?> recipeType) {
		Registry.register(Registries.RECIPE_TYPE, identifier(name), recipeType);
	}
}
