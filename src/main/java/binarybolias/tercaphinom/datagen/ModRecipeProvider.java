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
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	public void generate(RecipeExporter exporter) {
		log("Generating recipe data");
		
		//region ## Recipe Sets - Plank ##
		//# Acacia #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_ACACIA_LOG, ModItems.ACACIA_PLANK, Blocks.ACACIA_PLANKS,
				Blocks.ACACIA_BUTTON, Blocks.ACACIA_PRESSURE_PLATE,
				Blocks.ACACIA_DOOR, Blocks.ACACIA_TRAPDOOR,
				Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_FENCE,
				Blocks.ACACIA_SLAB, Blocks.ACACIA_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.ACACIA_BOAT, 1, ModItems.ACACIA_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.ACACIA_PLANK, Blocks.ACACIA_SIGN, Blocks.ACACIA_HANGING_SIGN);
		//# Birch #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_BIRCH_LOG, ModItems.BIRCH_PLANK, Blocks.BIRCH_PLANKS,
				Blocks.BIRCH_BUTTON, Blocks.BIRCH_PRESSURE_PLATE,
				Blocks.BIRCH_DOOR, Blocks.BIRCH_TRAPDOOR,
				Blocks.BIRCH_FENCE_GATE, Blocks.BIRCH_FENCE,
				Blocks.BIRCH_SLAB, Blocks.BIRCH_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.BIRCH_BOAT, 1, ModItems.BIRCH_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.BIRCH_PLANK, Blocks.BIRCH_SIGN, Blocks.BIRCH_HANGING_SIGN);
		//# Cherry #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_CHERRY_LOG, ModItems.CHERRY_PLANK, Blocks.CHERRY_PLANKS,
				Blocks.CHERRY_BUTTON, Blocks.CHERRY_PRESSURE_PLATE,
				Blocks.CHERRY_DOOR, Blocks.CHERRY_TRAPDOOR,
				Blocks.CHERRY_FENCE_GATE, Blocks.CHERRY_FENCE,
				Blocks.CHERRY_SLAB, Blocks.CHERRY_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.CHERRY_BOAT, 1, ModItems.CHERRY_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.CHERRY_PLANK, Blocks.CHERRY_SIGN, Blocks.CHERRY_HANGING_SIGN);
		//# Crimson #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_CRIMSON_STEM, ModItems.CRIMSON_PLANK, Blocks.CRIMSON_PLANKS,
				Blocks.CRIMSON_BUTTON, Blocks.CRIMSON_PRESSURE_PLATE,
				Blocks.CRIMSON_DOOR, Blocks.CRIMSON_TRAPDOOR,
				Blocks.CRIMSON_FENCE_GATE, Blocks.CRIMSON_FENCE,
				Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STAIRS);
		// Note: There is no Crimson Boat.
		offerStandingAndHangingSignRecipes(exporter, ModItems.CRIMSON_PLANK, Blocks.CRIMSON_SIGN, Blocks.CRIMSON_HANGING_SIGN);
		//# Dark Oak #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_DARK_OAK_LOG, ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_PLANKS,
				Blocks.DARK_OAK_BUTTON, Blocks.DARK_OAK_PRESSURE_PLATE,
				Blocks.DARK_OAK_DOOR, Blocks.DARK_OAK_TRAPDOOR,
				Blocks.DARK_OAK_FENCE_GATE, Blocks.DARK_OAK_FENCE,
				Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.DARK_OAK_BOAT, 1, ModItems.DARK_OAK_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_SIGN, Blocks.DARK_OAK_HANGING_SIGN);
		//# Mahogany #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_JUNGLE_LOG, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_PLANKS,
				Blocks.JUNGLE_BUTTON, Blocks.JUNGLE_PRESSURE_PLATE,
				Blocks.JUNGLE_DOOR, Blocks.JUNGLE_TRAPDOOR,
				Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_FENCE,
				Blocks.JUNGLE_SLAB, Blocks.JUNGLE_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.JUNGLE_BOAT, 1, ModItems.MAHOGANY_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_SIGN, Blocks.JUNGLE_HANGING_SIGN);
		//# Mangrove #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_MANGROVE_LOG, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_PLANKS,
				Blocks.MANGROVE_BUTTON, Blocks.MANGROVE_PRESSURE_PLATE,
				Blocks.MANGROVE_DOOR, Blocks.MANGROVE_TRAPDOOR,
				Blocks.MANGROVE_FENCE_GATE, Blocks.MANGROVE_FENCE,
				Blocks.MANGROVE_SLAB, Blocks.MANGROVE_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.MANGROVE_BOAT, 1, ModItems.MANGROVE_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_SIGN, Blocks.MANGROVE_HANGING_SIGN);
		//# Oak #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_OAK_LOG, ModItems.OAK_PLANK, Blocks.OAK_PLANKS,
				Blocks.OAK_BUTTON, Blocks.OAK_PRESSURE_PLATE,
				Blocks.OAK_DOOR, Blocks.OAK_TRAPDOOR,
				Blocks.OAK_FENCE_GATE, Blocks.OAK_FENCE,
				Blocks.OAK_SLAB, Blocks.OAK_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.OAK_BOAT, 1, ModItems.OAK_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.OAK_PLANK, Blocks.OAK_SIGN, Blocks.OAK_HANGING_SIGN);
		//# Spruce #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_SPRUCE_LOG, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_PLANKS,
				Blocks.SPRUCE_BUTTON, Blocks.SPRUCE_PRESSURE_PLATE,
				Blocks.SPRUCE_DOOR, Blocks.SPRUCE_TRAPDOOR,
				Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_FENCE,
				Blocks.SPRUCE_SLAB, Blocks.SPRUCE_STAIRS);
		offerBoatRecipe(exporter, // Perhaps transportation category instead?
				RecipeCategory.MISC, Items.SPRUCE_BOAT, 1, ModItems.SPRUCE_PLANK, "", "boats");
		offerStandingAndHangingSignRecipes(exporter, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_SIGN, Blocks.SPRUCE_HANGING_SIGN);
		//# Verdak #
		offerStandardPlankRecipeSet(exporter,
				ModBlocks.VERDAK_LOG, ModItems.VERDAK_PLANK, ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_FENCE_GATE, ModBlocks.VERDAK_FENCE_POST,
				ModBlocks.VERDAK_PLANK_SLAB, ModBlocks.VERDAK_PLANK_STAIR);
		// Note: There is no verdak boat or sign pair.
		//# Warped #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_WARPED_STEM, ModItems.WARPED_PLANK, Blocks.WARPED_PLANKS,
				Blocks.WARPED_BUTTON, Blocks.WARPED_PRESSURE_PLATE,
				Blocks.WARPED_DOOR, Blocks.WARPED_TRAPDOOR,
				Blocks.WARPED_FENCE_GATE, Blocks.WARPED_FENCE,
				Blocks.WARPED_SLAB, Blocks.WARPED_STAIRS);
		// Note: There is no Warped Boat.
		offerStandingAndHangingSignRecipes(exporter, ModItems.WARPED_PLANK, Blocks.WARPED_SIGN, Blocks.WARPED_HANGING_SIGN);
		//endregion
		
		//region ## Recipe Sets - Stone ##
		//# Stiefane #
		offerStandardStoneRecipeSet(exporter,
				ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK,
				ModBlocks.COBBLED_STIEFANE_BLOCK, ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//endregion
		
		
		//region ## Container Recipes (handheld) ##
		//# Bowl #
		offerBowlRecipe(exporter,
				RecipeCategory.MISC, Items.BOWL, 2, ModTags.Items.ALL_PLANKS,
				"has_any_plank", "", null);
		//# Bucket #
		offerBowlRecipe(exporter,
				RecipeCategory.MISC, Items.BUCKET, 1, Items.IRON_INGOT, "", null);
		//# Glass Bottle #
		offerBowlRecipe(exporter,
				RecipeCategory.MISC, Items.GLASS_BOTTLE, 3, Items.GLASS_PANE, "", null);
		//endregion
		
		//region ## Container Recipes (placed) ##
		//# Barrel #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BARREL)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("#X#")
				.pattern("# #")
				.pattern("#X#")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BARREL)));
		//# Chest #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.CHEST, 1, ModItems.IRON_GRAM, ModTags.Items.ALL_PLANKS,
				"has_any_plank", "", null);
		//# Ender Chest #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.ENDER_CHEST, 1,
				Items.ENDER_EYE, ModItems.OBSIDIAN_SHARD, "", null);
		//endregion
		
		//region ## Equipment Recipes ##
		//# Fishing Rod #
		offerFishingRodRecipe(exporter, Items.FISHING_ROD);
		//# Pair of Shears #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SHEARS)
				.input('#', Items.COPPER_INGOT)
				.input('X', Items.IRON_INGOT)
				.pattern(" X")
				.pattern("# ")
				.criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, new Identifier(getRecipeName(Items.SHEARS)));
		//endregion
		
		//region ## Food Recipes ##
		// Cake
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CAKE)
				.input('#', Items.WHEAT)
				.input('X', Items.SUGAR)
				.input('O', Items.EGG)
				.input('@', Items.MILK_BUCKET)
				.pattern("XXX")
				.pattern("###")
				.pattern("O@O")
				.criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
				.criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CAKE)));
		//endregion
		
		//region ## Workstation Recipes (cooking) ##
		//# Blast Furnace #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
				.input('#', ModTags.Items.ALL_BRICKS)
				.input('X', Items.IRON_INGOT)
				.input('@', ModItems.ASH_PILE)
				.pattern("XXX")
				.pattern("X@X")
				.pattern("###")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BLAST_FURNACE)));
		//# Campfire (basic) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CAMPFIRE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', ModTags.Items.BASIC_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_basic_flame_material", conditionsFromTag(ModTags.Items.BASIC_FLAME_MATERIALS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CAMPFIRE)));
		//# Campfire (spirit) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_CAMPFIRE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', ModTags.Items.SPIRIT_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_basic_flame_material", conditionsFromTag(ModTags.Items.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_CAMPFIRE)));
		//# Furnace #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.FURNACE, 1, ModItems.ASH_PILE, ModTags.Items.ALL_COBBLESTONES,
				"has_any_cobblestone", "", null);
		//# Smoker #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMOKER)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', ModItems.ASH_PILE)
				.pattern("X#X")
				.pattern("#@#")
				.pattern("X#X")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SMOKER)));
		//endregion
		
		//region ## Workstation Recipes (crafting) ##
		//# Anvil #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.ANVIL)
				.input('#', Items.IRON_INGOT)
				.pattern("###")
				.pattern(" # ")
				.pattern("###")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.ANVIL)));
		//# Brewing Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BREWING_STAND)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('/', Items.BLAZE_ROD)
				.input('X', Items.IRON_INGOT)
				.input('O', Blocks.GLASS_PANE)
				.pattern("OXO")
				.pattern("X/X")
				.pattern("###")
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BREWING_STAND)));
		//# Cartography Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CARTOGRAPHY_TABLE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Items.PAPER)
				.input('@', Items.COMPASS)
				.pattern("X@X")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CARTOGRAPHY_TABLE)));
		//# Crafting Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("##")
				.pattern("XX")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CRAFTING_TABLE)));
		//# Enchanting Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.ENCHANTING_TABLE)
				.input('#', ModItems.OBSIDIAN_SHARD)
				.input('X', Items.BOOK)
				.input('@', Items.DIAMOND)
				.pattern("@X@")
				.pattern("###")
				.pattern("###")
				.criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.ENCHANTING_TABLE)));
		//# Fletching Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.FLETCHING_TABLE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Items.STRING)
				.input('@', Items.ARROW)
				.pattern("X@X")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.FLETCHING_TABLE)));
		//# Grindstone #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.GRINDSTONE)
				.input('#', ModTags.Items.ALL_BRICKS)
				.input('X', ModTags.Items.ALL_PLANKS)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("X#X")
				.pattern("X@X")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.GRINDSTONE)));
		//# Lectern #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LECTERN)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Items.BOOK)
				.pattern("###")
				.pattern(" X ")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LECTERN)));
		//# Loom #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LOOM)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', ModTags.Items.ALL_YARNBALLS)
				.pattern("#@#")
				.pattern("X@X")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LOOM)));
		//# Sawmill #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.STONECUTTER)
				.input('#', ModTags.Items.ALL_BRICKS)
				.input('X', ModTags.Items.ALL_PLANKS)
				.input('I', Items.IRON_INGOT)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("XIX")
				.pattern("###")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.STONECUTTER)));
		//# Smithing Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMITHING_TABLE)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Items.IRON_INGOT)
				.pattern("XXX")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SMITHING_TABLE)));
		//endregion
		
		//region ## Joke & Unserious Recipes ##
		//# Cheese (blocks) #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CHEESE_BLOCK, 1,
				ModItems.BLUE_CHEESE_WEDGE, "", "cheese_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK, 1,
				ModItems.SILKY_SMOOTH_CHEESE_WEDGE, "", "cheese_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CHEESE_BLOCK, 1,
				ModItems.YELLOW_CHEESE_WEDGE, "", "cheese_blocks");
		//# Cheese (items) #
		offerShapelessThreeIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLUE_CHEESE_WEDGE, 1,
				ModItems.YELLOW_CHEESE_WEDGE, Items.MAGMA_CREAM, Items.LAPIS_LAZULI, "", null);
		offerSmeltingRecipe(exporter,
				RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.BLUE_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		offerSmeltingRecipe(exporter,
				RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.YELLOW_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		// TODO: Add Yellow Cheese Wedges from Cheese Wheel.
		//# Smoothest Stones #
		// Hypersmooth Creamstone
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HYPERSMOOTH_CREAMSTONE)
				.input('#', ModBlocks.ULTRASMOOTH_STONE)
				.input('X', Blocks.BLUE_ICE)
				.input('@', Items.MAGMA_CREAM)
				.pattern("@X@")
				.pattern("X#X")
				.pattern("@X@")
				.criterion(hasItem(ModBlocks.ULTRASMOOTH_STONE), conditionsFromItem(ModBlocks.ULTRASMOOTH_STONE))
				.criterion(hasItem(Blocks.BLUE_ICE), conditionsFromItem(Blocks.BLUE_ICE))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.offerTo(exporter, new Identifier(getRecipeName(ModBlocks.HYPERSMOOTH_CREAMSTONE)));
		// Ultrasmooth Stone
		offerSmeltingRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.ULTRASMOOTH_STONE, 400,
				Blocks.SMOOTH_STONE, 0.125F, null);
		//endregion
		
		//region ## Miscellaneous Recipes ##
		//# Armor Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ARMOR_STAND)
				.input('#', ModTags.Items.ALL_BRICKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern(" X ")
				.pattern("XXX")
				.pattern(" # ")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Items.ARMOR_STAND)));
		
		//# Arrow #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.ARROW)
				.input('#', ModTags.Items.ARROWHEAD_MATERIALS)
				.input('/', Items.STICK)
				.input('X', Items.FEATHER)
				.pattern("#")
				.pattern("/")
				.pattern("X")
				.criterion("has_arrowhead_material", conditionsFromTag(ModTags.Items.ARROWHEAD_MATERIALS))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
				.offerTo(exporter, new Identifier(getRecipeName(Items.ARROW)));
		
		//# Ash Pile from cooking #
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.WOODEN_STICK_BUNDLE, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModTags.Items.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball",
				0.125F);
		
		//# Balls #
		// Cobweb Ball
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.COBWEB_BALL, 1, Items.GUNPOWDER, ModItems.SILK_WAD, "", null);
		// Magma Cream
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_CREAM)
				.input(Items.BLAZE_POWDER).input(Items.SLIME_BALL).input(Items.BLAZE_POWDER)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.offerTo(exporter, new Identifier(getRecipeName(Items.MAGMA_CREAM)));
		// Yarnballs (dying)
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLACK_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.BLACK_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLUE_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.BLUE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BROWN_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.BROWN_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.CYAN_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.CYAN_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GRAY_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.GRAY_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GREEN_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.GREEN_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.LIGHT_BLUE_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.LIGHT_BLUE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.LIGHT_GRAY_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.LIME_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.LIME_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.MAGENTA_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.MAGENTA_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.ORANGE_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.ORANGE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.PINK_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.PINK_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.PURPLE_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.PURPLE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.RED_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.RED_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1,
				ModTags.Items.ALL_YARNBALLS_EXCEPT_WHITE, "has_any_yarnball_except_white",
				Items.WHITE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.YELLOW_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.YELLOW_DYE, "", "yarnball_dying");
		// Yarnballs (miscellaneous) - Also string from silk.
		offerDoubleRowRecipe(exporter,
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1, Items.STRING, "_from_string", null);
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 4,
				ModTags.Items.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball", "string");
		offerSmallSquareRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 1,
				ModItems.SILK_WAD, "_from_silk", "string");
		
		//# Beacon #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BEACON)
				.input('#', ModItems.OBSIDIAN_SHARD)
				.input('@', Items.NETHER_STAR)
				.input('X', Blocks.GLASS_PANE)
				.pattern("XXX")
				.pattern("X@X")
				.pattern("###")
				.criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
				.criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BEACON)));
		
		//# Beds #
		// Pigmented
		offerBedOfPigmentRecipe(exporter, Blocks.BLACK_BED, Blocks.BLACK_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.BLUE_BED, Blocks.BLUE_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.BROWN_BED, Blocks.BROWN_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.CYAN_BED, Blocks.CYAN_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.GRAY_BED, Blocks.GRAY_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.GREEN_BED, Blocks.GREEN_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_BLUE_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIGHT_GRAY_BED, Blocks.LIGHT_GRAY_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIME_BED, Blocks.LIME_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.MAGENTA_BED, Blocks.MAGENTA_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.ORANGE_BED, Blocks.ORANGE_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.PINK_BED, Blocks.PINK_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.PURPLE_BED, Blocks.PURPLE_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.RED_BED, Blocks.RED_CARPET, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.YELLOW_BED, Blocks.YELLOW_CARPET, "", "beds");
		// White
		offerBedOfWhiteRecipe(exporter, Blocks.WHITE_BED, "", "beds");
		
		//# Blastpowder #
		offerShapelessFourIntoOneRecipe(exporter,
				RecipeCategory.MISC, Items.GUNPOWDER, 3,
				ModItems.ASH_PILE, ModItems.SULPHUR_LUMP, Items.CHARCOAL,
				ModTags.Items.ALL_GLASSY_SAND_PILES, "has_any_glassy_sand_pile", "", null);
		
		//# Brick Block #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BRICKS, 1,
				Items.CLAY_BALL, Items.BRICK, "", null);
		
		//# Chain #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CHAIN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X")
				.pattern("#")
				.pattern("X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CHAIN)));
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.IRON_GRAM, 8,
				Blocks.CHAIN, "_from_chain", "iron_recycling_to_gram");
		
		//# Charcoal #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.CHARCOAL, 400,
				ModTags.Items.ALL_PLANKS, "has_any_plank", "_from_plank", 0.125F);
		
		//# Cheese #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHEESE_WHEEL)
				.input('@', Items.MILK_BUCKET)
				.input('X', Items.BLAZE_POWDER)
				.input('O', Items.SUGAR) // TODO: Replace with Salt Pile.
				.pattern(" X ")
				.pattern("XOX")
				.pattern(" @ ")
				.criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.CHEESE_WHEEL)));
		// NOTE: Won't work; bucket gets consumed, not leaving behind an Empty Bucket:
//		offerSmeltingRecipe(exporter,
//				RecipeCategory.FOOD, ModItems.CHEESE_WHEEL, 400,
//				Items.MILK_BUCKET, 0.125F, null);
		
		//# Clay Block #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, 1, Items.CLAY_BALL, "", null);
		
		//# Compost Bin #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COMPOSTER)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("# #")
				.pattern("#X#")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.COMPOSTER)));
		
		//# Dynamite #
		// Block.
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.REDSTONE, Blocks.TNT,
				"", "dynamite_packing",
				RecipeCategory.MISC, ModItems.DYNAMITE_BUNDLE,
				"_from_block", "dynamite_packing");
		// Bundle.
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.DYNAMITE_BUNDLE,
				"_from_stick", "dynamite_packing",
				RecipeCategory.MISC, ModItems.DYNAMITE_STICK,
				"_from_bundle", "dynamite_packing");
		// Stick.
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(ModTags.Items.ALL_YARNBALLS)
				.input(Items.PAPER).input(Items.PAPER)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_paper"));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(ModTags.Items.ALL_YARNBALLS)
				.input(Blocks.BAMBOO)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_bamboo"));
		
		//# Elemental Blocks #
		// Ash
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BLOCK, 1, ModItems.ASH_PILE, "", null);
		
		// Bone
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BONE_BLOCK, 1, Items.BONE, "", null);
		// Obsidian
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, 1, ModItems.OBSIDIAN_SHARD, "", null);
		
		//# Ender Eye #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ENDER_EYE)
				.input(Items.ENDER_PEARL)
				.input(Items.MAGMA_CREAM)
				.criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.offerTo(exporter, new Identifier(getRecipeName(Items.ENDER_EYE)));
		
		//# Glass Shard #
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.GLASS_SHARD, 200,
				ModTags.Items.ALL_GLASSY_SAND_PILES, "has_glassy_sand_pile",
				"_from_glassy_sand_pile", 0.125F);
		// Bottle recycling
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GLASS_SHARD, 1, Items.GLASS_BOTTLE, "_from_bottle", null);
		
		//# Glass Blocks & Panes #
		// (glass) Clear Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, 1, Blocks.GLASS_PANE, "", null);
		// (glass) Clear Pane
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.GLASS_PANE, 200, ModItems.GLASS_SHARD, 0.125F);
		// (glass) Stained Blocks
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_STAINED_GLASS, 1,
				Blocks.BLACK_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_STAINED_GLASS, 1,
				Blocks.BLUE_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_STAINED_GLASS, 1,
				Blocks.BROWN_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_STAINED_GLASS, 1,
				Blocks.CYAN_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_STAINED_GLASS, 1,
				Blocks.GRAY_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_STAINED_GLASS, 1,
				Blocks.GREEN_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_STAINED_GLASS, 1,
				Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_STAINED_GLASS, 1,
				Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_STAINED_GLASS, 1,
				Blocks.LIME_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_STAINED_GLASS, 1,
				Blocks.MAGENTA_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_STAINED_GLASS, 1,
				Blocks.ORANGE_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_STAINED_GLASS, 1,
				Blocks.PINK_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_STAINED_GLASS, 1,
				Blocks.PURPLE_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.RED_STAINED_GLASS, 1,
				Blocks.RED_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_STAINED_GLASS, 1,
				Blocks.WHITE_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_STAINED_GLASS, 1,
				Blocks.YELLOW_STAINED_GLASS_PANE, "", "stained_glass_blocks");
		// (glass) Stained Panes
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.BLACK_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.BLUE_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.BROWN_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.CYAN_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.GRAY_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.GREEN_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.LIGHT_BLUE_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.LIGHT_GRAY_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.LIME_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.MAGENTA_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.ORANGE_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.PINK_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.PURPLE_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.RED_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.RED_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.WHITE_DYE, "", "glass_pane_staining");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_STAINED_GLASS_PANE, 1,
				Blocks.GLASS_PANE, Items.YELLOW_DYE, "", "glass_pane_staining");
		// (glass) Tinted Block
		offerCheckeredRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.TINTED_GLASS, 1,
				Blocks.GLASS_PANE, Items.AMETHYST_SHARD, "", null);
		
		//# Golden Foods #
		// Glistering Melon Slice
		offerFourOrthogonallyAroundOneRecipe(exporter,
				RecipeCategory.FOOD,Items.GLISTERING_MELON_SLICE, 1,
				Items.MELON_SLICE, ModItems.GOLD_GRAM, "", null);
		// Golden Apple
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.FOOD,Items.GOLDEN_APPLE, 1,
				Items.APPLE, ModItems.GOLD_GRAM, "", null);
		// Golden Carrot
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.FOOD,Items.GOLDEN_CARROT, 1,
				Items.CARROT, ModItems.GOLD_GRAM, "", null);
		
		//# Gravel, Sands, & Soils #
		// Coarse Dirt
		offerCompactingFourAndFourRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.COARSE_DIRT, 1,
				ModItems.DIRT_PILE, ModItems.GRAVEL_PILE, "", null);
		//Dirt
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT, 1,
				ModItems.DIRT_PILE, "", null);
		// Gravel
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GRAVEL_PILE, 1, ModTags.Items.ALL_COBBLESTONES,
				"has_any_cobblestone", "_from_cobblestone" , null);
//		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRAVEL_PILE)
//				.input(Ingredient.fromTag(ModTags.Items.ALL_COBBLESTONES))
//				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.GRAVEL_PILE) + "_from_cobblestone"));
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRAVEL, 1,
				ModItems.GRAVEL_PILE, "", null);
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.GRAVEL_PILE, "_from_stone_pebble", null,
				RecipeCategory.MISC, ModItems.STONE_PEBBLE, "_from_gravel_pile", null);
		
		//# Ice #
		// Packed
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE, 1,
				Blocks.ICE, "", null);
		// Blue
		offerShapelessFourIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_ICE, 1,
				Blocks.PACKED_ICE, Blocks.PACKED_ICE, Blocks.PACKED_ICE, Blocks.LAPIS_BLOCK,
				"", null);
		
		//# Iron Door & Hatch #
		// Door
		offerDoubleColumnRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.IRON_DOOR, 1, Items.IRON_INGOT, "", null);
		// Hatch
		offerLargeRowRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.IRON_TRAPDOOR, 1, Items.IRON_INGOT, "", null);
		
		//# Lanterns #
		// Basic Lantern
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LANTERN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.input('O', Blocks.GLASS_PANE)
				.input('@', Items.GLOWSTONE_DUST)
				.pattern(" X ")
				.pattern("O@O")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LANTERN)));
		// Spirit Lantern
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_LANTERN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.input('O', Blocks.GLASS_PANE)
				.input('@', ModTags.Items.SPIRIT_FLAME_MATERIALS)
				.pattern(" X ")
				.pattern("O@O")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.criterion("has_spirit_flame_material", conditionsFromTag(ModTags.Items.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_LANTERN)));
		
		//# Ladders #
		// Wooden
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.LADDER)
				.input('#', Items.STICK)
				.input('X', Items.STRING)
				.pattern("#X#")
				.pattern("###")
				.pattern("#X#")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LADDER)));
		
		//# Leash #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.LEAD)
				.input('#', Ingredient.fromTag(ModTags.Items.ALL_YARNBALLS))
				.input('X', Items.SLIME_BALL)
				.pattern("## ")
				.pattern("#X ")
				.pattern("  #")
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.offerTo(exporter, new Identifier(getRecipeName(Items.LEAD)));
		
		//# Leather #
		offerSmokingAndCampfireRecipes(exporter,
				RecipeCategory.MISC, Items.LEATHER, 400, Items.ROTTEN_FLESH, 0.125F);
		
		//# Lumithite #
		// Powder
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.GLOWSTONE_DUST, 400, Items.GLOW_BERRIES, 0.125F);
		
		//# Magma Block #
		offerCheckeredRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MAGMA_BLOCK, 1,
				Items.MAGMA_CREAM, ModTags.Items.ALL_COBBLESTONES, "has_any_cobblestone",
				"", null);
		
		//# Melon #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.MELON, 1, Items.SUGAR, Items.MELON_SLICE,"", "");
		
		//# Metals #
		// Cooking grams and ingots.
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.COPPER_GRAM, 100,
				ModItems.RAW_COPPER_NUGGET, 0.25F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.COPPER_INGOT, 400,
				Items.RAW_COPPER, 1.0F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.GOLD_GRAM, 100,
				Items.GOLD_NUGGET, 0.25F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.GOLD_INGOT, 400,
				Items.RAW_GOLD, 1.0F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.IRON_GRAM, 100,
				Items.IRON_NUGGET, 0.25F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.IRON_INGOT, 400,
				Items.RAW_IRON, 1.0F);
		// Splitting and merging.
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.COPPER_INGOT, "_from_gram", "gram_merging",
				RecipeCategory.MISC, ModItems.COPPER_GRAM, "_from_ingot", "ingot_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.RAW_COPPER, "_from_nugget", "nugget_merging",
				RecipeCategory.MISC, ModItems.RAW_COPPER_NUGGET, "_from_lump", "lump_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.GOLD_INGOT, "_from_gram", "gram_merging",
				RecipeCategory.MISC, ModItems.GOLD_GRAM, "_from_ingot", "ingot_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.RAW_GOLD, "_from_nugget", "nugget_merging",
				RecipeCategory.MISC, Items.GOLD_NUGGET, "_from_lump", "lump_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.IRON_INGOT, "_from_gram", "gram_merging",
				RecipeCategory.MISC, ModItems.IRON_GRAM, "_from_ingot", "ingot_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, Items.RAW_IRON, "_from_nugget", "nugget_merging",
				RecipeCategory.MISC, Items.IRON_NUGGET, "_from_lump", "lump_splitting");
		
		//# Miniwizard #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MINIWIZARD, 2)
				.input('#', ModItems.MINIWIZARD)
				.input('O', ModTags.Items.ALL_YARNBALLS)
				.input('X', Items.ROTTEN_FLESH)
				.input('@', Items.ENCHANTED_GOLDEN_APPLE)
				.pattern("O@O")
				.pattern("X#X")
				.pattern("OXO")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
				.criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE), conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.MINIWIZARD) + "_duplication"));
		
		//# Miscellaneous Redstone Devices #
		// Daylight Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Items.QUARTZ)
				.input('O', Blocks.GLASS_PANE)
				.pattern("OOO")
				.pattern("XXX")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DAYLIGHT_DETECTOR)));
		// Dispenser
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DISPENSER)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('X', Items.CROSSBOW)
				.input('@', Items.REDSTONE)
				.pattern("###")
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DISPENSER)));
		// Dropper
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DROPPER)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('X', Items.BOW)
				.input('@', Items.REDSTONE)
				.pattern("###")
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DROPPER)));
		// Lever
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.LEVER)
				.input('|', Items.STICK)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('@', Items.REDSTONE)
				.pattern("|")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LEVER)));
		// Piston
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.PISTON)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('X', ModTags.Items.ALL_PLANKS)
				.input('@', Items.REDSTONE)
				.input('O', Items.IRON_INGOT)
				.pattern("XXX")
				.pattern("#O#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.PISTON)));
		// Redstone Lamp
		// TODO: Replace glowstone block in recipe with Lumithite Chunk.
		offerFourAndFourCheckeredAroundOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.REDSTONE_LAMP, 1,
				Blocks.GLOWSTONE, Items.REDSTONE, Items.IRON_INGOT, "", null);
		// Redstone Signal Repeater
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.REPEATER)
				.input('#', ModTags.Items.ALL_BRICKS)
				.input('/', Blocks.REDSTONE_TORCH)
				.input('O', Items.REDSTONE)
				.pattern("/O/")
				.pattern("#O#")
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.REPEATER)));
		// Tripwire Hook
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.TRIPWIRE_HOOK)
				.input('/', Items.STICK)
				.input('#', ModTags.Items.ALL_COBBLESTONES)
				.input('X', ModTags.Items.ALL_METAL_GRAMS)
				.input('@', Items.REDSTONE)
				.pattern("/X")
				.pattern("# ")
				.pattern("@ ")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion("has_any_cobblestone", conditionsFromTag(ModTags.Items.ALL_COBBLESTONES))
				.criterion("has_any_metal_gram", conditionsFromTag(ModTags.Items.ALL_METAL_GRAMS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.TRIPWIRE_HOOK)));
		// Weighted Pressure Plate (Heavy)
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 1, Items.IRON_INGOT, "", null);
		// Weighted Pressure Plate (Light)
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 1, Items.GOLD_INGOT, "", null);
		
		// Moss Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MOSS_BLOCK, 1,
				Blocks.MOSS_CARPET, "", null);
		
		//# Name Tag #
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
		
		//# Paper #
		offerLargeRowRecipe(exporter,
				RecipeCategory.MISC, Items.PAPER, 1, Items.SUGAR_CANE, "", null);
		
		//# Rails #
		// Basic
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.RAIL)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("# #")
				.pattern("#X#")
				.pattern("# #")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.RAIL)));
		// Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.DETECTOR_RAIL)
				.input('#', Blocks.RAIL)
				.input('X', ModTags.Items.ALL_BRICKS)
				.input('@', Items.REDSTONE)
				.pattern("X")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion("has_any_brick", conditionsFromTag(ModTags.Items.ALL_BRICKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DETECTOR_RAIL)));
		// Powered
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.POWERED_RAIL)
				.input('#', Blocks.RAIL)
				.input('X', Items.GOLD_INGOT)
				.input('@', Items.REDSTONE)
				.pattern(" @ ")
				.pattern("X#X")
				.pattern(" @ ")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.POWERED_RAIL)));
		
		//# Snow #
		// Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.SNOW_BLOCK, 1,
				Blocks.SNOW, "", null);
		// Pile // Note: The canonical Block corresponding to the Snow Pile would be the "Snow Mound".
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.SNOW, "", null,
				RecipeCategory.MISC, Items.SNOWBALL, "_from_pile", null);
		
		//# Sticks #
		// Sharp Wooden Stick
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHARP_WOODEN_STICK)
				.input(Items.STICK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARP_WOODEN_STICK)));
		// Stick from any plank
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 2)
				.input(Ingredient.fromTag(ModTags.Items.ALL_PLANKS))
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.offerTo(exporter, new Identifier(getRecipeName(Items.STICK) + "_from_plank"));
		// Wooden Stick Bundle
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.WOODEN_STICK_BUNDLE, "", null,
				RecipeCategory.MISC, Items.STICK, "_from_bundle", null);
		
		//# Sugar #
		offerSmeltingRecipe(exporter,
				RecipeCategory.MISC, Items.SUGAR, 200, Items.SUGAR_CANE, 0.125F, null);
		
		//# Torches #
		// Basic Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.TORCH, 1,
				Items.STICK, ModTags.Items.BASIC_FLAME_MATERIALS, "has_basic_flame_material",
				"", null);
//		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.TORCH)
//				.input('/', Items.STICK)
//				.input('@', Ingredient.fromTag(ModTags.Items.ALL_YARNBALLS))
//				.input('X', Ingredient.ofItems(Items.CHARCOAL, Items.COAL))
//				.pattern("@X")
//				.pattern("/ ")
//				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
////				.criterion("has_charcoal_or_coal", conditionsFrom) # TODO: Figure out how to add an arbitrary (non-tag) collection of items as a condition.
//				.offerTo(exporter, new Identifier(getRecipeName(Items.TORCH)));
		// Erythrite Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.REDSTONE_TORCH, 1,
				Items.STICK, Items.REDSTONE, "", null);
//		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.REDSTONE_TORCH)
//				.input('/', Items.STICK)
//				.input('@', Ingredient.fromTag(ModTags.Items.ALL_YARNBALLS))
//				.input('X', Items.REDSTONE)
//				.pattern("@X")
//				.pattern("/ ")
//				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
//				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.REDSTONE))
//				.offerTo(exporter, new Identifier(getRecipeName(Items.REDSTONE_TORCH)));
		// Spirit Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.SOUL_TORCH, 1,
				Items.STICK, ModTags.Items.SPIRIT_FLAME_MATERIALS, "has_spirit_flame_material",
				"", null);
//		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SOUL_TORCH)
//				.input('/', Items.STICK)
//				.input('@', Ingredient.fromTag(ModTags.Items.ALL_YARNBALLS))
//				.input('X', ModTags.Items.SPIRIT_FLAME_MATERIALS)
//				.pattern("@X")
//				.pattern("/ ")
//				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
//				.criterion("has_spirit_flame_material", conditionsFromTag(ModTags.Items.SPIRIT_FLAME_MATERIALS))
//				.offerTo(exporter, new Identifier(getRecipeName(Items.SOUL_TORCH)));
		
		//# Yarn #
		// Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLACK_WOOL, 1,
				Blocks.BLACK_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_WOOL, 1,
				Blocks.BLUE_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BROWN_WOOL, 1,
				Blocks.BROWN_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CYAN_WOOL, 1,
				Blocks.CYAN_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRAY_WOOL, 1,
				Blocks.GRAY_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GREEN_WOOL, 1,
				Blocks.GREEN_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_BLUE_WOOL, 1,
				Blocks.LIGHT_BLUE_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIGHT_GRAY_WOOL, 1,
				Blocks.LIGHT_GRAY_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.LIME_WOOL, 1,
				Blocks.LIME_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MAGENTA_WOOL, 1,
				Blocks.MAGENTA_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.ORANGE_WOOL, 1,
				Blocks.ORANGE_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PINK_WOOL, 1,
				Blocks.PINK_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PURPLE_WOOL, 1,
				Blocks.PURPLE_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.RED_WOOL, 1,
				Blocks.RED_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.WHITE_WOOL, 1,
				Blocks.WHITE_CARPET, "", "yarn_blocks");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.YELLOW_WOOL, 1,
				Blocks.YELLOW_CARPET, "", "yarn_blocks");
		// Carpet
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.BLACK_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.BLACK_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.BLUE_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.BLUE_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.BROWN_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.BROWN_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.CYAN_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.CYAN_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.GRAY_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.GRAY_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.GREEN_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.GREEN_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.LIGHT_BLUE_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.LIGHT_BLUE_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.LIGHT_GRAY_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.LIME_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.LIME_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.MAGENTA_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.MAGENTA_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.ORANGE_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.ORANGE_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.PINK_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.PINK_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.PURPLE_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.PURPLE_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.RED_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.RED_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.WHITE_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.YELLOW_CARPET, "", "yarn_carpets",
				RecipeCategory.MISC, ModItems.YELLOW_YARNBALL,
				"_from_carpet", "yarn_carpet_dismantling");
		
		//endregion
	}
	
	//region ## General Utility ##
	public static String fromItem(ItemConvertible item) {
		return "_from_" + item.asItem().toString();
	}
	
	
	public static String getCookingId(ItemConvertible resultItem, String fromString, String cookingType) {
		return getRecipeName(resultItem) + fromString + "_via_" + cookingType;
	}
	
	public static String getCookingId(ItemConvertible resultItem, ItemConvertible inputItem, String cookingType) {
		return getRecipeName(resultItem) + fromItem(inputItem) + "_via_" + cookingType;
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
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, plankBlock, 1, plankItem, "", "plank_blocks");
//		offerReversibleCompactingEightRecipes(exporter,
//				RecipeCategory.MISC, plankItem, "_from_block", "plank_recycling",
//				RecipeCategory.BUILDING_BLOCKS, plankBlock, "", "plank_blocks");
		// Button
		offerRedstoneButtonRecipe(exporter,
				RecipeCategory.REDSTONE, button, 1, plankItem, "", "wooden_buttons");
//		offerSemiReversibleButtonRecipes(exporter,
//				RecipeCategory.MISC, plankItem, "_from_button", "plank_recycling",
//				RecipeCategory.REDSTONE, button, "", "plank_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, pressurePlate, 1, plankItem, "", "wooden_pressure_plates");
//		offerSemiReversiblePressurePlateRecipes(exporter,
//				RecipeCategory.MISC, plankItem, "_from_pressure_plate", "plank_recycling",
//				RecipeCategory.REDSTONE, pressurePlate, "", "plank_pressure_plates");
		// Door
		offerDoubleColumnRecipe(exporter,
				RecipeCategory.REDSTONE, door, 1, plankItem, "", "wooden_doors");
//		offerReversibleDoubleColumnRecipes(exporter,
//				RecipeCategory.REDSTONE, door, "", "wooden_doors",
//				RecipeCategory.MISC, plankItem, "_from_door", "plank_recycling"
//		);
		// Hatch
		offerLargeRowRecipe(exporter,
				RecipeCategory.REDSTONE, hatch, 1, plankItem, "", "wooden_hatches");
//		offerReversibleLargeRowRecipes(exporter,
//				RecipeCategory.REDSTONE, hatch, "", "wooden_hatches",
//				RecipeCategory.MISC, plankItem, "_from_hatch", "plank_recycling"
//		);
		// Fence Gate
		offerWoodenFenceGateRecipe(exporter,
				RecipeCategory.REDSTONE, fenceGate, 1, plankItem, "", "wooden_fence_gates");
//		offerSemiReversibleFenceGateRecipes(exporter,
//				RecipeCategory.MISC, plankItem, "_from_fence_gate", "plank_recycling",
//				RecipeCategory.REDSTONE, fenceGate, "", "fence_gates");
		// Fence Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.DECORATIONS, fencePost, 1, plankItem, "", "wooden_fence_posts");
//		offerReversibleSmallColumnRecipes(exporter,
//				RecipeCategory.DECORATIONS, fencePost, "", "wooden_fence_posts",
//				RecipeCategory.MISC, plankItem, "_from_fence_post", "plank_recycling"
//		);
		// Plank Slab
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, plankSlab, 1, plankItem, "", "wooden_slabs");
//		offerReversibleSmallSquareRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, plankSlab, "", "plank_slabs",
//				RecipeCategory.MISC, plankItem, "_from_slab", "plank_recycling");
		// Plank Stair
		offerLargeStairRecipe(exporter,
				RecipeCategory.DECORATIONS, plankStair, 1, plankItem, "", "wooden_stairs");
//		offerReversibleLargeStairRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, plankStair, "", "wooden_stairs",
//				RecipeCategory.MISC, plankItem, "_from_stair", "plank_recycling"
//		);
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
				RecipeCategory.MISC, brickItem, "_from_cobblestone", "bricks", RecipeCategory.MISC, cobblestoneItem, "_from_brick", "cobblestones"
		);
		// Cobblestone Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, cobblestoneBlock, 1,
				cobblestoneItem, "", "cobbled_stone_blocks");
//		offerReversibleCompactingEightRecipes(exporter,
//				RecipeCategory.MISC, cobblestoneItem, "_from_block", "cobblestone_recycling",
//				RecipeCategory.BUILDING_BLOCKS, cobblestoneBlock, "", "cobblestone_blocks");
		// Brick Block
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickBlock, 1, brickItem, "", "brick_blocks");
//		offerReversibleSmallSquareRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, brickBlock, "", "brick_blocks",
//				RecipeCategory.MISC, brickItem, "_from_block", "brick_recycling"
//		);
		// Polished Block
		offerFourOrthogonallyAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, polishedBlock, 1,
				Items.BLAZE_POWDER, brickItem, "", "stone_polishing");
		// Button
		offerRedstoneButtonRecipe(exporter,
				RecipeCategory.REDSTONE, button, 1, brickItem, "", "stone_buttons");
//		offerSemiReversibleButtonRecipes(exporter,
//				RecipeCategory.MISC, brickItem, "_from_button", "brick_recycling",
//				RecipeCategory.REDSTONE, button, "", "stone_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, pressurePlate, 1, brickItem, "", "stone_pressure_plates");
//		offerSemiReversiblePressurePlateRecipes(exporter,
//				RecipeCategory.MISC, brickItem, "_from_pressure_plate", "brick_recycling",
//				RecipeCategory.REDSTONE, pressurePlate, "", "stone_pressure_plates");
		// Brick Wall Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickWallPost, 1, brickItem, "", "brick_wall_posts");
//		offerReversibleSmallColumnRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, brickWallPost, "", "brick_wall_posts",
//				RecipeCategory.MISC, brickItem, "_from_wall_post", "brick_recycling"
//		);
		// Brick Slab
		offerSmallRowRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickSlab, 1, brickItem, "", "brick_slabs");
//		offerReversibleSmallRowRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, brickSlab, "", "brick_slabs",
//				RecipeCategory.MISC, brickItem, "_from_slab", "brick_recycling"
//		);
		// Brick Stair
		offerSmallStairRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickStair, 1, brickItem, "", "brick_stairs");
//		offerReversibleSmallStairRecipes(exporter,
//				RecipeCategory.BUILDING_BLOCKS, brickStair, "", "brick_stairs",
//				RecipeCategory.MISC, brickItem, "_from_stair", "brick_recycling"
//		);
	}
	
	
	public static void offerStandingAndHangingSignRecipes(
			RecipeExporter exporter, ItemConvertible plankItem,
			ItemConvertible standingSignItem, ItemConvertible hangingSignItem
	) {
		// Standing Sign
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, standingSignItem)
				.input('/', Items.STICK)
				.input('#', plankItem)
				.pattern("###")
				.pattern("###")
				.pattern(" / ")
				.group("wooden_standing_signs")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(plankItem), conditionsFromItem(plankItem))
				.offerTo(exporter, new Identifier(getRecipeName(standingSignItem)));
		// Hanging Sign
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, hangingSignItem)
				.input('/', Items.CHAIN)
				.input('#', plankItem)
				.pattern("/ /")
				.pattern("###")
				.pattern("###")
				.group("wooden_hanging_signs")
				.criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
				.criterion(hasItem(plankItem), conditionsFromItem(plankItem))
				.offerTo(exporter, new Identifier(getRecipeName(hangingSignItem)));
	}
	//endregion
	
	//region ## Recipe Offers - Basic Shapes ##
	public static void offerBowlRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createBowlFormat(category, resultItem, count, Ingredient.fromTag(inputItemTag))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBowlRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createBowlFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBoatRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createBoatFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerDoubleColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerDoubleRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerLargeRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerLargeStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallSquareRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallSquareFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Equipment ##
	public static void offerBasicAxeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
	
	public static void offerFishingRodRecipe(
			RecipeExporter exporter, ItemConvertible resultItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', Items.STICK)
				.input('X', Items.STRING)
				.input('@', ModTags.Items.ALL_METAL_GRAMS)
				.pattern("  X")
				.pattern(" #X")
				.pattern("# @")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion("has_any_metal_gram", conditionsFromTag(ModTags.Items.ALL_METAL_GRAMS))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
	}
	
	public static void offerStringedDaggerRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix
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
	
	//region ## Recipe Offers - Heating ##
	public static void offerSmeltingRecipe(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int cookingTime,
			TagKey<Item> inputItemTag, String hasTagString, String fromTagString, float experience
	) {
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, experience, cookingTime,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "smelting"));
	}
	
	public static void offerSmeltingRecipe(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int cookingTime,
			ItemConvertible inputItem, float experience, @Nullable String group
	) {
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, experience, cookingTime,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
	}
	
	
	public static void offerSmeltingAndBlastingRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			TagKey<Item> inputItemTag, String hasTagString, String fromTagString, float baseExperience
	) {
		// Blasting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "blasting"));
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 4,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "smelting"));
	}
	
	public static void offerSmeltingAndBlastingRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience
	) {
		// Blasting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience, baseCookingTime,
				RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "blasting"));
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 2, baseCookingTime * 4,
				RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
	}
	
	
	public static void offerSmeltingAndSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience, baseCookingTime,
				RecipeSerializer.SMOKING, SmokingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smoking"));
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 2, baseCookingTime * 4,
				RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
		// Campfire cooking recipe; 4x experience, 12x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 4, baseCookingTime * 12,
				RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
	}
	
	
	public static void offerSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory,
			ItemConvertible resultItem, int baseCookingTime, ItemConvertible inputItem, float baseExperience
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience, baseCookingTime,
				RecipeSerializer.SMOKING, SmokingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smoking"));
		// Campfire cooking recipe; 2x experience, 3x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 2, baseCookingTime * 3,
				RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
	}
	//endregion
	
	//region ## Recipe Offers - Reversible ##
	public static void offerReversibleCompactingEightRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createCompactingEightFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 8)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleDoubleColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createDoubleColumnFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleDoubleRowRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createDoubleRowFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleLargeColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createLargeColumnFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleLargeRowRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createLargeRowFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleLargeSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createLargeSquareFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleLargeStairRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createLargeStairFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleOneToOneRecipes(
			RecipeExporter exporter,
			RecipeCategory categoryA, ItemConvertible itemA,
			String idSuffixA, @Nullable String groupA,
			RecipeCategory categoryB, ItemConvertible itemB,
			String idSuffixB, @Nullable String groupB
	) {
		// Item A from item B.
		ShapelessRecipeJsonBuilder.create(categoryA, itemA)
				.input(itemB)
				.group(groupA)
				.criterion(hasItem(itemB), conditionsFromItem(itemB))
				.offerTo(exporter, new Identifier(getRecipeName(itemA) + idSuffixA));
		// Item B from item A.
		ShapelessRecipeJsonBuilder.create(categoryB, itemB)
				.input(itemA)
				.group(groupB)
				.criterion(hasItem(itemA), conditionsFromItem(itemA))
				.offerTo(exporter, new Identifier(getRecipeName(itemB) + idSuffixB));
	}
	
	
	public static void offerReversibleSmallColumnRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createSmallColumnFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleSmallRowRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createSmallRowFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleSmallSquareRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createSmallSquareFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	
	
	public static void offerReversibleSmallStairRecipes(
			RecipeExporter exporter,
			RecipeCategory compactingCategory, ItemConvertible compactItem,
			String compactingIdSuffix, @Nullable String compactingGroup,
			RecipeCategory reverseCategory, ItemConvertible baseItem,
			String reverseIdSuffix, @Nullable String reverseGroup
	) {
		// Compacting.
		createSmallStairFormat(compactingCategory, compactItem, 1, Ingredient.ofItems(baseItem))
				.group(compactingGroup)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Shapeless (# Into One) ##
	public static void offerTwoIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemATag, String hasTagString, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createTwoIntoOneFormat(category, resultItem, count, Ingredient.fromTag(inputItemATag), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemATag))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerTwoIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createTwoIntoOneFormat(category, resultItem, count, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerShapelessThreeIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, ItemConvertible inputItemC,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemA).input(inputItemB).input(inputItemC)
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.criterion(hasItem(inputItemC), conditionsFromItem(inputItemC))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerShapelessFourIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB,
			ItemConvertible inputItemC, TagKey<Item> inputItemDTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemA).input(inputItemB).input(inputItemC).input(inputItemDTag)
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.criterion(hasItem(inputItemC), conditionsFromItem(inputItemC))
				.criterion(hasTagString, conditionsFromTag(inputItemDTag))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerShapelessFourIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB,
			ItemConvertible inputItemC, ItemConvertible inputItemD,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemA).input(inputItemB).input(inputItemC).input(inputItemD)
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.criterion(hasItem(inputItemC), conditionsFromItem(inputItemC))
				.criterion(hasItem(inputItemD), conditionsFromItem(inputItemD))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Miscellaneous ##
	public static void offerBedOfPigmentRecipe(
			RecipeExporter exporter, ItemConvertible bedResult,
			ItemConvertible pigmentedCarpetItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, bedResult)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Blocks.WHITE_CARPET)
				.input('O', pigmentedCarpetItem)
				.pattern("OOX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
				.criterion(hasItem(pigmentedCarpetItem), conditionsFromItem(pigmentedCarpetItem))
				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
	}
	
	
	public static void offerBedOfWhiteRecipe(
			RecipeExporter exporter, ItemConvertible bedResult, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, bedResult)
				.input('#', ModTags.Items.ALL_PLANKS)
				.input('X', Blocks.WHITE_CARPET)
				.pattern("XXX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(ModTags.Items.ALL_PLANKS))
				.criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
	}
	
	
	public static void offerCheckeredRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> orthogonalItemKey, String hasTagString, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createCheckeredFormat(category, resultItem, count,
				Ingredient.fromTag(orthogonalItemKey), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(orthogonalItemKey))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerCheckeredRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible orthogonalItem, TagKey<Item> diagonalItemKey, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createCheckeredFormat(category, resultItem, count,
				Ingredient.ofItems(orthogonalItem), Ingredient.fromTag(diagonalItemKey))
				.group(group)
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasTagString, conditionsFromTag(diagonalItemKey))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerCheckeredRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible orthogonalItem, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createCheckeredFormat(category, resultItem, count,
				Ingredient.ofItems(orthogonalItem), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerCheckeredBoxRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible orthogonalItem, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createCheckeredBoxFormat(category, resultItem, count,
				Ingredient.ofItems(orthogonalItem), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(category, resultItem, count, Ingredient.fromTag(inputItemTag))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerCompactingFourAndFourRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createCompactingFourAndFourFormat(
				category, resultItem, count, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerEightAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, TagKey<Item> surroundingItemTag, String hasSurroundingTagString,
			String idSuffix, @Nullable String group
	) {
		createEightAroundOneFormat(category, resultItem, count,
				Ingredient.fromTag(surroundingItemTag), Ingredient.ofItems(centralItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasSurroundingTagString, conditionsFromTag(surroundingItemTag))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerEightAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createEightAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(surroundingItem), Ingredient.ofItems(centralItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerFourAndFourCheckeredAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, ItemConvertible orthogonalItem, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createFourAndFourCheckeredAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(orthogonalItem), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerFourDiagonallyAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createFourDiagonallyAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(surroundingItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerFourOrthogonallyAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createFourOrthogonallyAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(surroundingItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemTag)
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItem)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstoneButtonRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstoneButtonFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstonePressurePlateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstonePressurePlateFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerTorchRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, TagKey<Item> flammableInputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createTorchFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.fromTag(flammableInputItemTag))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasTagString, conditionsFromTag(flammableInputItemTag))
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerTorchRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, ItemConvertible flammableInputItem, String idSuffix, @Nullable String group
	) {
		createTorchFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.ofItems(flammableInputItem))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasItem(flammableInputItem), conditionsFromItem(flammableInputItem))
				.criterion("has_any_yarnball", conditionsFromTag(ModTags.Items.ALL_YARNBALLS))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerWoodenFenceGateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createWoodenFenceGateFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	//region ## Recipe Formats (basic shapes) ##
	public static CraftingRecipeJsonBuilder createBowlFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("# #")
				.pattern(" # ");
	}
	
	
	public static CraftingRecipeJsonBuilder createBoatFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("# #")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createBoxFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("###")
				.pattern("# #")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createDoubleColumnFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("##")
				.pattern("##")
				.pattern("##");
	}
	
	
	public static CraftingRecipeJsonBuilder createDoubleRowFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("###")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createLargeColumnFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("#")
				.pattern("#")
				.pattern("#");
	}
	
	
	public static CraftingRecipeJsonBuilder createLargeRowFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createLargeSquareFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("###")
				.pattern("###")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createLargeStairFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("#  ")
				.pattern("## ")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createSmallColumnFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("#")
				.pattern("#");
	}
	
	
	public static CraftingRecipeJsonBuilder createSmallRowFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("##");
	}
	
	
	public static CraftingRecipeJsonBuilder createSmallSquareFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("##")
				.pattern("##");
	}
	
	
	public static CraftingRecipeJsonBuilder createSmallStairFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', ingredient)
				.pattern("# ")
				.pattern("##");
	}
	//endregion
	
	//region ## Recipe Formats (shapeless) ##
	public static CraftingRecipeJsonBuilder createCompactingEightFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredient
	) {
		return ShapelessRecipeJsonBuilder.create(category, output, count)
				.input(ingredient).input(ingredient).input(ingredient).input(ingredient)
				.input(ingredient).input(ingredient).input(ingredient).input(ingredient);
	}
	
	
	public static CraftingRecipeJsonBuilder createCompactingFourAndFourFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredientA, Ingredient ingredientB
	) {
		return ShapelessRecipeJsonBuilder.create(category, output, count)
				.input(ingredientA).input(ingredientA).input(ingredientA).input(ingredientA)
				.input(ingredientB).input(ingredientB).input(ingredientB).input(ingredientB);
	}
	
	
	public static CraftingRecipeJsonBuilder createTwoIntoOneFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredientA, Ingredient ingredientB
	) {
		return ShapelessRecipeJsonBuilder.create(category, output, count)
				.input(ingredientA).input(ingredientB);
	}
	//endregion
	
	//region ## Recipe Formats (miscellaneous) ##
	public static CraftingRecipeJsonBuilder createCheckeredFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient orthogonalIngredient, Ingredient diagonalIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('O', orthogonalIngredient)
				.input('X', diagonalIngredient)
				.pattern("XOX")
				.pattern("OXO")
				.pattern("XOX");
	}
	
	
	public static CraftingRecipeJsonBuilder createCheckeredBoxFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient orthogonalIngredient, Ingredient diagonalIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('O', orthogonalIngredient)
				.input('X', diagonalIngredient)
				.pattern("XOX")
				.pattern("O O")
				.pattern("XOX");
	}
	
	
	public static CraftingRecipeJsonBuilder createEightAroundOneFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient surroundingIngredient, Ingredient centralIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', surroundingIngredient)
				.input('X', centralIngredient)
				.pattern("###")
				.pattern("#X#")
				.pattern("###");
	}
	
	
	public static CraftingRecipeJsonBuilder createFourAndFourCheckeredAroundOneFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient centralIngredient, Ingredient orthogonalIngredient, Ingredient diagonalIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', centralIngredient)
				.input('O', orthogonalIngredient)
				.input('X', diagonalIngredient)
				.pattern("XOX")
				.pattern("O#O")
				.pattern("XOX");
	}
	
	
	public static CraftingRecipeJsonBuilder createFourDiagonallyAroundOneFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient centralIngredient, Ingredient surroundingIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', centralIngredient)
				.input('X', surroundingIngredient)
				.pattern("X X")
				.pattern(" # ")
				.pattern("X X");
	}
	
	
	public static CraftingRecipeJsonBuilder createFourOrthogonallyAroundOneFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient centralIngredient, Ingredient surroundingIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', centralIngredient)
				.input('O', surroundingIngredient)
				.pattern(" O ")
				.pattern("O#O")
				.pattern(" O ");
	}
	
	
	public static CraftingRecipeJsonBuilder createRedstoneButtonFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient baseIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', baseIngredient)
				.input('X', Items.REDSTONE)
				.pattern("#")
				.pattern("X");
	}
	
	
	public static CraftingRecipeJsonBuilder createRedstonePressurePlateFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient baseIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', baseIngredient)
				.input('X', Items.REDSTONE)
				.pattern("##")
				.pattern("X ");
	}
	
	
	public static CraftingRecipeJsonBuilder createTorchFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient shaftIngredient, Ingredient flammableIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('/', shaftIngredient)
				.input('@', Ingredient.fromTag(ModTags.Items.ALL_YARNBALLS))
				.input('X', flammableIngredient)
				.pattern("@X")
				.pattern("/ ");
	}
	
	
	public static CraftingRecipeJsonBuilder createWoodenFenceGateFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient baseIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', baseIngredient)
				.input('X', Items.STICK)
				.pattern("X#X")
				.pattern("X X");
	}
	//endregion
}
