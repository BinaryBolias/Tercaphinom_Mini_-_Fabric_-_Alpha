package binarybolias.tercaphinom.datagen.recipe;


import binarybolias.tercaphinom.recipe.BasicGridRecipe;
import binarybolias.tercaphinom.recipe.remainderOverride.RecipeRemainderOverride;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @see BasicGridRecipe
 * @see net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
 * @see net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
 */
public class BasicGridRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
	private final RecipeCategory category;
	private final Item result;
	private final int count;
	private final DefaultedList<Ingredient> inputs = DefaultedList.of();
	private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
	@Nullable
	private String group;
	
	//TODO: Implement remainder override functionality:
	// - If null, don't add an entry for remainder overrides to the JSON file.
	@Nullable
	final RecipeRemainderOverride remainderOverride = null; // TODO: Add a method for updating this.
	// Perhaps one method for each type of override?
	// Produce an error if 'remainderOverride' is already non-null, meaning it had already been set; remainder override setters are mutually exclusive.
	
	
	public BasicGridRecipeJsonBuilder(RecipeCategory category, ItemConvertible result, int count) {
		this.category = category;
		this.result = result.asItem();
		this.count = count;
	}
	
	
	public static BasicGridRecipeJsonBuilder create(RecipeCategory category, ItemConvertible result) {
		return new BasicGridRecipeJsonBuilder(category, result, 1);
	}
	
	public static BasicGridRecipeJsonBuilder create(RecipeCategory category, ItemConvertible result, int count) {
		return new BasicGridRecipeJsonBuilder(category, result, count);
	}
	
	
	public BasicGridRecipeJsonBuilder input(TagKey<Item> tag) {
		return input(Ingredient.fromTag(tag));
	}
	
	public BasicGridRecipeJsonBuilder input(TagKey<Item> tag, int amount) {
		return input(Ingredient.fromTag(tag), amount);
	}
	
	public BasicGridRecipeJsonBuilder input(ItemConvertible itemConvertible) {
		return input(Ingredient.ofItems(itemConvertible));
	}
	
	public BasicGridRecipeJsonBuilder input(ItemConvertible itemConvertible, int amount) {
		return input(Ingredient.ofItems(itemConvertible), amount);
	}
	
	public BasicGridRecipeJsonBuilder input(Ingredient ingredient) {
		return input(ingredient, 1);
	}
	
	public BasicGridRecipeJsonBuilder input(Ingredient ingredient, int amount) {
		for (int i = 0; i < amount; i++) {
			inputs.add(ingredient);
		}
		
		return this;
	}
	
	
	public BasicGridRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
		criteria.put(name, criterion);
		return this;
	}
	
	
	public BasicGridRecipeJsonBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}
	
	
	@Override
	public Item getOutputItem() {
		return result;
	}
	
	
	@Override
	public void offerTo(RecipeExporter exporter, Identifier recipeId) {
		validate(recipeId);
		
		Advancement.Builder builder = exporter.getAdvancementBuilder()
				.criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
				.rewards(AdvancementRewards.Builder.recipe(recipeId))
				.criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
		criteria.forEach(builder::criterion);
		
		BasicGridRecipe basicGridRecipe = new BasicGridRecipe(
				Objects.requireNonNullElse(group, ""),
				CraftingRecipeJsonBuilder.toCraftingCategory(category),
				new ItemStack(result, count),
				inputs
		);
		
		exporter.accept(recipeId, basicGridRecipe, builder.build(recipeId.withPrefixedPath("recipes/" + category.getName() + "/")));
	}
	
	
	private void validate(Identifier recipeId) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeId);
		}
	}
}
