package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	public void generate(RecipeExporter exporter) {
		log("Generating recipe data");
		
		//region ## Plank Sets ##
		// Verdak
		offerStandardPlankRecipeSet(exporter,
				ModBlocks.VERDAK_LOG, ModItems.VERDAK_PLANK, ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_FENCE_GATE, ModBlocks.VERDAK_FENCE_POST,
				ModBlocks.VERDAK_PLANK_SLAB, ModBlocks.VERDAK_PLANK_STAIR);
		//endregion
		
		//region ## Stone Sets ##
		// Stiefane
		offerStandardStoneRecipeSet(exporter,
				ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK,
				ModBlocks.COBBLED_STIEFANE_BLOCK, ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//endregion
		
		//region ## Joke & Unserious Recipes ##
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.BUILDING_BLOCKS, 200,
				Blocks.SMOOTH_STONE, ModBlocks.ULTRASMOOTH_STONE, 0.125F);
		//endregion
		
		//region ## Miscellaneous Recipes ##
		// Drying rotten flesh into leather.
		offerSmokingAndCampfireRecipes(exporter,
				RecipeCategory.MISC, 400, Items.ROTTEN_FLESH, Items.LEATHER, 0.125F);
		
		// Stick from any plank
		// TODO: Use a custom "all_planks" tag for allowing any plank with a single recipe.
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 2)
				.input(ModItems.VERDAK_PLANK) // TODO: Use a tag here instead.
//				.input(Ingredient.fromTag())
				.criterion(hasItem(ModItems.VERDAK_PLANK), conditionsFromItem(ModItems.VERDAK_PLANK)) // TODO: Use a tag here instead.
//				.criterion("has_any_plank", conditionsFromTag())
				.offerTo(exporter, new Identifier(getRecipeName(Items.STICK) + "_from_plank"));
		
		// TODO: Add "Gravel Pile" and "Stone Pebble" items.
		//  - Add recipe for 1 Gravel Pile crafted from 1 of any cobblestone.
		//   - Use a custom "all_cobblestones" tag for allowing any cobblestone with a single recipe.
		//  - Add reversible recipes for 1 gravel Pile crafted from Stone Pebbles in small square shape (2x2).
		
		// Sharp Wooden Stick
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHARP_WOODEN_STICK)
				.input(Items.STICK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARP_WOODEN_STICK)));
		
		// Name Tag
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NAME_TAG)
				.input(Items.FEATHER)
				.input(Items.INK_SAC)
				.input(Items.PAPER)
				.input(Items.STRING)
				.criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
				.criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(Items.NAME_TAG)));
		//endregion
	}
	
	//region ## General Utility ##
	public static String fromItem(ItemConvertible item) {
		return "_from_" + item.asItem().toString();
	}
	
	public static String getCookingId(ItemConvertible inputItem, ItemConvertible outputItem, String cookingType) {
		return getRecipeName(outputItem) + fromItem(inputItem) + "_via_" + cookingType;
	}
	//endregion
	
	//region ## Recipe Set Offers ##
	public static void offerStandardPlankRecipeSet(
			RecipeExporter exporter,
			ItemConvertible logBlock, // NOTE: Planks are not to be craftable from trunks.
			ItemConvertible plankItem, ItemConvertible plankBlock,
			ItemConvertible button, ItemConvertible pressurePlate,
			ItemConvertible door, ItemConvertible hatch,
			ItemConvertible fenceGate, ItemConvertible fencePost,
			ItemConvertible plankSlab, ItemConvertible plankStair
	) {
		// Planks from log
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, plankItem, 6)
				.input(logBlock)
				.group("log_splitting")
				.criterion(hasItem(logBlock), conditionsFromItem(logBlock))
				.offerTo(exporter, new Identifier(getRecipeName(plankItem) + "_from_log"));
		// Plank Block
		offerReversibleCompactingEightRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_block", "plank_recycling",
				RecipeCategory.BUILDING_BLOCKS, plankBlock, "", "plank_blocks");
		// Button
		offerSemiReversibleButtonRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_button", "plank_recycling",
				RecipeCategory.REDSTONE, button, "", "plank_buttons");
		// Pressure Plate
		offerSemiReversiblePressurePlateRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_pressure_plate", "plank_recycling",
				RecipeCategory.REDSTONE, pressurePlate, "", "plank_pressure_plates");
		// Door
		offerReversibleDoubleColumnRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_door", "plank_recycling",
				RecipeCategory.REDSTONE, door, "", "plank_doors");
		// Hatch
		offerReversibleLargeRowRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_hatch", "plank_recycling",
				RecipeCategory.REDSTONE, hatch, "", "plank_hatches");
		// Fence Gate
		offerSemiReversibleFenceGateRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_fence_gate", "plank_recycling",
				RecipeCategory.REDSTONE, fenceGate, "", "fence_gates");
		// Fence Post
		offerReversibleSmallColumnRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_fence_post", "plank_recycling",
				RecipeCategory.DECORATIONS, fencePost, "", "fence_posts");
		// Plank Slab
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_slab", "plank_recycling",
				RecipeCategory.BUILDING_BLOCKS, plankSlab, "", "plank_slabs");
		// Plank Stair
		offerReversibleLargeStairRecipes(exporter,
				RecipeCategory.MISC, plankItem, "_from_stair", "plank_recycling",
				RecipeCategory.BUILDING_BLOCKS, plankStair, "", "plank_stairs");
	}
	
	public static void offerStandardStoneRecipeSet(
			RecipeExporter exporter, ItemConvertible cobblestoneItem, ItemConvertible brickItem,
			ItemConvertible cobblestoneBlock, ItemConvertible brickBlock, ItemConvertible polishedBlock,
			ItemConvertible button, ItemConvertible pressurePlate,
			ItemConvertible brickWallPost,
			ItemConvertible brickSlab, ItemConvertible brickStair
	) {
		// Brick
		offerReversibleSmallRowRecipes(exporter,
				RecipeCategory.MISC, cobblestoneItem, "_from_brick", "cobblestones",
				RecipeCategory.MISC, brickItem, "_from_cobblestone", "bricks");
		// Cobblestone Block
		offerReversibleCompactingEightRecipes(exporter,
				RecipeCategory.MISC, cobblestoneItem, "_from_block", "cobblestone_recycling",
				RecipeCategory.BUILDING_BLOCKS, cobblestoneBlock, "", "cobblestone_blocks");
		// Brick Block
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_block", "brick_recycling",
				RecipeCategory.BUILDING_BLOCKS, brickBlock, "", "brick_blocks");
		// Polished Block
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, polishedBlock)
				.input('#', brickItem)
				.input('X', Items.BLAZE_POWDER)
				.pattern(" # ")
				.pattern("#X#")
				.pattern(" # ")
				.group("stone_polishing")
				.criterion(hasItem(brickItem), conditionsFromItem(brickItem))
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.offerTo(exporter, new Identifier(getRecipeName(polishedBlock)));
		// Button
		offerSemiReversibleButtonRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_button", "brick_recycling",
				RecipeCategory.REDSTONE, button, "", "stone_buttons");
		// Pressure Plate
		offerSemiReversiblePressurePlateRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_pressure_plate", "brick_recycling",
				RecipeCategory.REDSTONE, pressurePlate, "", "stone_pressure_plates");
		// Brick Wall Post
		offerReversibleSmallColumnRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_wall_post", "brick_recycling",
				RecipeCategory.BUILDING_BLOCKS, brickWallPost, "", "wall_posts");
		// Brick Slab
		offerReversibleSmallRowRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_slab", "brick_recycling",
				RecipeCategory.BUILDING_BLOCKS, brickSlab, "", "brick_slabs");
		// Brick Stair
		offerReversibleSmallStairRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_stair", "brick_recycling",
				RecipeCategory.BUILDING_BLOCKS, brickStair, "", "brick_stairs");
	}
	//endregion
	
	//region ## Equipment Recipe Offers ##
	public static void offerBasicAxeRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("##")
				.pattern(" X")
				.pattern(" X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicDaggerRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicHatchetRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X")
				.pattern(" X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicHoeRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X")
				.pattern(" X")
				.pattern(" X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicMalletRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern(" # ")
				.pattern(" X#")
				.pattern("X  ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicPickaxeRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X#")
				.pattern(" X ")
				.pattern(" X ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicPitchforkRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern(" ##")
				.pattern(" X#")
				.pattern("X  ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicShovelRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.pattern("X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicSpearRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("  #")
				.pattern(" X ")
				.pattern("X  ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBasicSwordRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerStringedDaggerRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("# ")
				.pattern("X@")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerStringedHatchetRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("#X")
				.pattern("@X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerStringedHoeRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("#X")
				.pattern("@X")
				.pattern(" X")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerStringedPitchforkRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern(" ##")
				.pattern(" X#")
				.pattern("X @")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerStringedSpearRecipe(
			RecipeExporter exporter,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("  #")
				.pattern(" X@")
				.pattern("X  ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	//region ## Heating Recipe Offers ##
	public static void offerSmeltingAndBlastingRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory,
			int baseCookingTime, ItemConvertible inputItem, ItemConvertible outputItem, float baseExperience
	) {
		// Blasting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience, baseCookingTime,
				RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "blasting"));
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience * 2, baseCookingTime * 4,
				RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "smelting"));
	}
	
	public static void offerSmeltingAndSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory,
			int baseCookingTime, ItemConvertible inputItem, ItemConvertible outputItem, float baseExperience
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience, baseCookingTime,
				RecipeSerializer.SMOKING, SmokingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "smoking"));
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience * 2, baseCookingTime * 4,
				RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "smelting"));
		// Campfire cooking recipe; 4x experience, 12x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience * 4, baseCookingTime * 12,
				RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "campfire_cooking"));
	}
	
	public static void offerSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory,
			int baseCookingTime, ItemConvertible inputItem, ItemConvertible outputItem, float baseExperience
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience, baseCookingTime,
				RecipeSerializer.SMOKING, SmokingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "smoking"));
		// Campfire cooking recipe; 2x experience, 3x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				outputItem, baseExperience * 2, baseCookingTime * 3,
				RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(inputItem, outputItem, "campfire_cooking"));
	}
	//endregion
	
	//region ## Reversible Recipe Offers ##
	public static void offerReversibleCompactingEightRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleCompactingEightRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleCompactingEightRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleCompactingEightRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleCompactingEightRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		// Compact item into eight base items.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 8)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		// Eight base items into compact item.
		ShapelessRecipeJsonBuilder.create(compactingCategory, compactItem)
				.input(baseItem).input(baseItem).input(baseItem).input(baseItem)
				.input(baseItem).input(baseItem).input(baseItem).input(baseItem)
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleDoubleColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleDoubleColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleDoubleColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleDoubleColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleDoubleColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createDoubleColumnRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleDoubleRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleDoubleRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleDoubleRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleDoubleRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleDoubleRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createDoubleRowRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleLargeColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleLargeColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleLargeColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleLargeColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleLargeColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createLargeColumnRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleLargeRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleLargeRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleLargeRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleLargeRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleLargeRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createLargeRowRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleLargeSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleLargeSquareRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleLargeSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleLargeSquareRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleLargeSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createLargeSquareRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleLargeStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleLargeStairRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleLargeStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleLargeStairRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleLargeStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createLargeStairRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleOneToOneRecipes(
			RecipeExporter exporter,
			RecipeCategory categoryA, ItemConvertible itemA, String idSuffixA,
			RecipeCategory categoryB, ItemConvertible itemB, String idSuffixB
	) {
		offerReversibleOneToOneRecipes(
				exporter,
				categoryA, itemA,
				categoryB, itemB,
				getRecipeName(itemA) + idSuffixA, null,
				getRecipeName(itemB) + idSuffixB, null
		);
	}
	
	public static void offerReversibleOneToOneRecipes(
			RecipeExporter exporter,
			RecipeCategory categoryA, ItemConvertible itemA,
			String idSuffixA, @Nullable String groupA,
			RecipeCategory categoryB, ItemConvertible itemB,
			String idSuffixB, @Nullable String groupB
	) {
		offerReversibleOneToOneRecipes(
				exporter,
				categoryA, itemA,
				categoryB, itemB,
				getRecipeName(itemA) + idSuffixA, groupA,
				getRecipeName(itemB) + idSuffixB, groupB
		);
	}
	
	public static void offerReversibleOneToOneRecipes(
			RecipeExporter exporter,
			RecipeCategory categoryA, ItemConvertible itemA,
			RecipeCategory categoryB, ItemConvertible itemB,
			String idA, @Nullable String groupA,
			String idB, @Nullable String groupB
	) {
		offerOneToOneRecipe(exporter, categoryA, itemB, itemA, idA, groupA);
		offerOneToOneRecipe(exporter, categoryB, itemA, itemB, idB, groupB);
	}
	
	public static void offerReversibleSmallColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleSmallColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleSmallColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleSmallColumnRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleSmallColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createSmallColumnRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleSmallRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleSmallRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleSmallRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleSmallRowRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleSmallRowRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createSmallRowRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleSmallSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleSmallSquareRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleSmallSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleSmallSquareRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleSmallSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createSmallSquareRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerReversibleSmallStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerReversibleSmallStairRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerReversibleSmallStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerReversibleSmallStairRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerReversibleSmallStairRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		createSmallStairRecipe(compactingCategory, compactItem, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerSemiReversibleButtonRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerSemiReversibleButtonRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerSemiReversibleButtonRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerSemiReversibleButtonRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerSemiReversibleButtonRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		// Compact item into base item. Redstone is not returned.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		// Base item and redstone into compact item.
		ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
				.input('#', baseItem)
				.input('X', Items.REDSTONE)
				.pattern("#")
				.pattern("X")
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerSemiReversibleFenceGateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerSemiReversibleFenceGateRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerSemiReversibleFenceGateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerSemiReversibleFenceGateRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerSemiReversibleFenceGateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		// Compact item into planks. Sticks are not returned.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		// Base item and sticks into compact item.
		ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("X#X")
				.pattern("X X")
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	
	public static void offerSemiReversiblePressurePlateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem, String reverseIdSuffix,
			RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingIdSuffix
	) {
		offerSemiReversiblePressurePlateRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, null,
				getRecipeName(compactItem) + compactingIdSuffix, null
		);
	}
	
	public static void offerSemiReversiblePressurePlateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup
	) {
		offerSemiReversiblePressurePlateRecipes(
				exporter,
				reverseCategory, baseItem,
				compactingCategory, compactItem,
				getRecipeName(baseItem) + reverseIdSuffix, reverseGroup,
				getRecipeName(compactItem) + compactingIdSuffix, compactingGroup
		);
	}
	
	public static void offerSemiReversiblePressurePlateRecipes(
			RecipeExporter exporter,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String reverseId, @Nullable String reverseGroup,
			String compactingId, @Nullable String compactingGroup
	) {
		// Compact item into two base items. Redstone is not returned.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(reverseId));
		// Base item and redstone into compact item.
		ShapedRecipeJsonBuilder.create(compactingCategory, compactItem)
				.input('#', baseItem)
				.input('X', Items.REDSTONE)
				.pattern("##")
				.pattern("X ")
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(compactingId));
	}
	//endregion
	
	//region ## Miscellaneous Recipe Offers ##
	public static void offerBowlRecipe(
			RecipeExporter exporter, RecipeCategory category,
			ItemConvertible baseItem, ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem)
				.input('#', baseItem)
				.pattern("# #")
				.pattern(" # ")
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerFourAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			ItemConvertible resultItem, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem)
				.input('#', surroundingItem)
				.input('X', centralItem)
				.pattern(" # ")
				.pattern("#X#")
				.pattern(" # ")
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category,
			ItemConvertible inputItem, ItemConvertible resultItem, String idSuffix
	) {
		offerOneToOneRecipe(exporter, category, inputItem,
				resultItem, getRecipeName(resultItem) + idSuffix, null);
	}
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category,
			ItemConvertible inputItem, ItemConvertible resultItem, String recipeId, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem)
				.input(inputItem)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(recipeId));
	}
	//endregion
	
	//region ## Recipe Shapes ##
	public static CraftingRecipeJsonBuilder createEightSurroundingOneRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient surroundingInput, Ingredient centerInput
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', surroundingInput)
				.input('X', centerInput)
				.pattern("###")
				.pattern("#X#")
				.pattern("###");
	}
	
	public static CraftingRecipeJsonBuilder createDoubleColumnRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("##")
				.pattern("##")
				.pattern("##");
	}
	
	public static CraftingRecipeJsonBuilder createDoubleRowRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("###")
				.pattern("###");
	}
	
	public static CraftingRecipeJsonBuilder createLargeColumnRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("#")
				.pattern("#")
				.pattern("#");
	}
	
	public static CraftingRecipeJsonBuilder createLargeRowRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("###");
	}
	
	public static CraftingRecipeJsonBuilder createLargeSquareRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("###")
				.pattern("###")
				.pattern("###");
	}
	
	public static CraftingRecipeJsonBuilder createLargeStairRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("#  ")
				.pattern("## ")
				.pattern("###");
	}
	
	public static CraftingRecipeJsonBuilder createSmallColumnRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("#")
				.pattern("#");
	}
	
	public static CraftingRecipeJsonBuilder createSmallRowRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("##");
	}
	
	public static CraftingRecipeJsonBuilder createSmallSquareRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("##")
				.pattern("##");
	}
	
	public static CraftingRecipeJsonBuilder createSmallStairRecipe(
			RecipeCategory category, ItemConvertible output, Ingredient input
	) {
		return ShapedRecipeJsonBuilder.create(category, output, 1)
				.input('#', input)
				.pattern("# ")
				.pattern("##");
	}
	//endregion
}
