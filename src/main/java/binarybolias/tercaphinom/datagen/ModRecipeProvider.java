package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.datagen.recipe.BasicGridRecipeJsonBuilder;
import binarybolias.tercaphinom.recipe.BucketFertilizerTransfer;
import binarybolias.tercaphinom.recipe.ReinforcedStainedGlassBlock;
import binarybolias.tercaphinom.recipe.SuspiciousStewRecipe;
import binarybolias.tercaphinom.recipe.WaterTransferRecipe;
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

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * Relevant references:
 * {@link net.minecraft.data.server.recipe.VanillaRecipeProvider}
 */
public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	public void generate(RecipeExporter exporter) {
		logMainEvent("Generating recipe data");
		
		//region ## Recipe Sets - Plank ##
		//# Acacia #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_ACACIA_LOG, ModItems.ACACIA_PLANK, Blocks.ACACIA_PLANKS,
				Blocks.ACACIA_BUTTON, Blocks.ACACIA_PRESSURE_PLATE,
				Blocks.ACACIA_DOOR, Blocks.ACACIA_TRAPDOOR,
				Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_FENCE,
				Blocks.ACACIA_SLAB, Blocks.ACACIA_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.ACACIA_PLANK, Items.ACACIA_BOAT, Items.ACACIA_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.ACACIA_PLANK, Blocks.ACACIA_SIGN, Blocks.ACACIA_HANGING_SIGN);
		//# Birch #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_BIRCH_LOG, ModItems.BIRCH_PLANK, Blocks.BIRCH_PLANKS,
				Blocks.BIRCH_BUTTON, Blocks.BIRCH_PRESSURE_PLATE,
				Blocks.BIRCH_DOOR, Blocks.BIRCH_TRAPDOOR,
				Blocks.BIRCH_FENCE_GATE, Blocks.BIRCH_FENCE,
				Blocks.BIRCH_SLAB, Blocks.BIRCH_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.BIRCH_PLANK, Items.BIRCH_BOAT, Items.BIRCH_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.BIRCH_PLANK, Blocks.BIRCH_SIGN, Blocks.BIRCH_HANGING_SIGN);
		//# Cherry #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_CHERRY_LOG, ModItems.CHERRY_PLANK, Blocks.CHERRY_PLANKS,
				Blocks.CHERRY_BUTTON, Blocks.CHERRY_PRESSURE_PLATE,
				Blocks.CHERRY_DOOR, Blocks.CHERRY_TRAPDOOR,
				Blocks.CHERRY_FENCE_GATE, Blocks.CHERRY_FENCE,
				Blocks.CHERRY_SLAB, Blocks.CHERRY_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.CHERRY_PLANK, Items.CHERRY_BOAT, Items.CHERRY_CHEST_BOAT);
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
		offerBoatRecipeSet(exporter, ModItems.DARK_OAK_PLANK, Items.DARK_OAK_BOAT, Items.DARK_OAK_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_SIGN, Blocks.DARK_OAK_HANGING_SIGN);
		//# Mahogany #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_JUNGLE_LOG, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_PLANKS,
				Blocks.JUNGLE_BUTTON, Blocks.JUNGLE_PRESSURE_PLATE,
				Blocks.JUNGLE_DOOR, Blocks.JUNGLE_TRAPDOOR,
				Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_FENCE,
				Blocks.JUNGLE_SLAB, Blocks.JUNGLE_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.MAHOGANY_PLANK, Items.JUNGLE_BOAT, Items.JUNGLE_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_SIGN, Blocks.JUNGLE_HANGING_SIGN);
		//# Mangrove #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_MANGROVE_LOG, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_PLANKS,
				Blocks.MANGROVE_BUTTON, Blocks.MANGROVE_PRESSURE_PLATE,
				Blocks.MANGROVE_DOOR, Blocks.MANGROVE_TRAPDOOR,
				Blocks.MANGROVE_FENCE_GATE, Blocks.MANGROVE_FENCE,
				Blocks.MANGROVE_SLAB, Blocks.MANGROVE_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.MANGROVE_PLANK, Items.MANGROVE_BOAT, Items.MANGROVE_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_SIGN, Blocks.MANGROVE_HANGING_SIGN);
		//# Oak #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_OAK_LOG, ModItems.OAK_PLANK, Blocks.OAK_PLANKS,
				Blocks.OAK_BUTTON, Blocks.OAK_PRESSURE_PLATE,
				Blocks.OAK_DOOR, Blocks.OAK_TRAPDOOR,
				Blocks.OAK_FENCE_GATE, Blocks.OAK_FENCE,
				Blocks.OAK_SLAB, Blocks.OAK_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.OAK_PLANK, Items.OAK_BOAT, Items.OAK_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.OAK_PLANK, Blocks.OAK_SIGN, Blocks.OAK_HANGING_SIGN);
		//# Spruce #
		offerStandardPlankRecipeSet(exporter,
				Blocks.STRIPPED_SPRUCE_LOG, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_PLANKS,
				Blocks.SPRUCE_BUTTON, Blocks.SPRUCE_PRESSURE_PLATE,
				Blocks.SPRUCE_DOOR, Blocks.SPRUCE_TRAPDOOR,
				Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_FENCE,
				Blocks.SPRUCE_SLAB, Blocks.SPRUCE_STAIRS);
		offerBoatRecipeSet(exporter, ModItems.SPRUCE_PLANK, Items.SPRUCE_BOAT, Items.SPRUCE_CHEST_BOAT);
		offerStandingAndHangingSignRecipes(exporter, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_SIGN, Blocks.SPRUCE_HANGING_SIGN);
		//# Verdak #
		offerStandardPlankRecipeSet(exporter,
				ModItems.VERDAK_LOG, ModItems.VERDAK_PLANK, ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_GATE, ModBlocks.VERDAK_FENCE_POST,
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
		//# Extra - Cactus #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, ModItems.BIRCH_PLANK, 4, Items.CACTUS,
				"_from_cactus_trunk", null);
		//endregion
		
		//region ## Recipe Sets - Stone ##
		//# Stiefane #
		offerStandardStoneRecipeSet(exporter,
				ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK,
				ModBlocks.NATURAL_STIEFANE_BLOCK, ModBlocks.COBBLED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//endregion
		
		
		//region ### Basic Resource Recipes ###
		//## Resources with Basic Block Forms ##
		//# Amethyst #
		offerBlockOfEightRecipe(exporter, Blocks.AMETHYST_BLOCK, Items.AMETHYST_SHARD, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BUDDING_AMETHYST,
				ModItems.MINIWIZARD, Items.AMETHYST_SHARD, "", null);
		//# Ash #
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.LEAF_PILE, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.WOODEN_STICK_BUNDLE, 0.125F);
		offerBlastingRecipe(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Tags.Item.ALL_PLANKS, "has_any_plank", "_from_plank", 0.125F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Tags.Item.ALL_YARN_ROLLS, "has_any_yarn_roll",
				"_from_yarn_roll", 0.125F);
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BLOCK, 1, ModItems.ASH_PILE, "", null);
		// Ash from charcoal and coal done through campfire only to maintain proper quick-movement from inventory to furnace fuel slot.
		offerCampfireCookingRecipe(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Items.CHARCOAL, 0.125F, "ash");
		offerCampfireCookingRecipe(exporter, RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Items.COAL, 0.125F, "ash");
		//# Charcoal #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.CHARCOAL, 400,
				Tags.Item.ALL_PLANKS, "has_any_plank", "_from_plank", 0.25F);
		//# Coal #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.COAL_BLOCK, 1, Items.COAL, "", null);
		//# Diamond #
		offerBlockOfEightRecipe(exporter, Blocks.DIAMOND_BLOCK, Items.DIAMOND, "", null);
		//# Dirt #
		offerSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.MISC, ModItems.DIRT_PILE,
				50, ModItems.MUDBALL, 0.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIRT_PILE, 2)
				.input(Ingredient.ofItems(ModItems.DIRT_PILE))
				.input(Ingredient.fromTag(Tags.Item.DECOMPOSABLE_MATERIALS), 3)
				.group(itemName(ModItems.DIRT_PILE))
				.criterion(hasItem(ModItems.DIRT_PILE), conditionsFromItem(ModItems.DIRT_PILE))
				.criterion(hasItem(ModItems.LEAF_PILE), conditionsFromItem(ModItems.LEAF_PILE))
				.criterion("has_decomposable_material", conditionsFromTag(Tags.Item.DECOMPOSABLE_MATERIALS))
				.offerTo(exporter, idFromItem(ModItems.DIRT_PILE, fromItem(ModItems.DIRT_PILE) + "_and_decomposable_material"));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIRT_PILE, 2)
				.input(Tags.Item.ALL_GLASSY_SAND_PILES)
				.input(Tags.Item.DECOMPOSABLE_MATERIALS)
				.input(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.group(itemName(ModItems.DIRT_PILE))
				.criterion("has_any_glassy_sand_pile", conditionsFromTag(Tags.Item.ALL_GLASSY_SAND_PILES))
				.criterion("has_decomposable_material", conditionsFromTag(Tags.Item.DECOMPOSABLE_MATERIALS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(ModItems.DIRT_PILE, "_from_glassy_sand_and_decomposable_material_and_brimwater"));
		//# Dry Kelp #
		offerReversibleSmallSquareRecipes(exporter, RecipeCategory.FOOD, ModItems.DRY_KELP_BUNDLE,
				"_from_leaf", null,
				RecipeCategory.FOOD, Items.DRIED_KELP, "_from_bundle", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DRIED_KELP_BLOCK,
				Items.STRING, ModItems.DRY_KELP_BUNDLE, "", null);
		//# Emerald #
		offerBlockOfEightRecipe(exporter, Blocks.EMERALD_BLOCK, Items.EMERALD, "", null);
		//# Erythrite #
		offerBlockOfEightRecipe(exporter, Blocks.REDSTONE_BLOCK, Items.REDSTONE, "", null);
		//# Lazurite #
		offerBlockOfEightRecipe(exporter, Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI, "", null);
		//# Mud #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUDBALL)
				.input(ModItems.DIRT_PILE)
				.input(ModItems.BOWL_OF_WATER)
				.criterion(hasItem(ModItems.BOWL_OF_WATER), conditionsFromItem(ModItems.BOWL_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.MUDBALL, "_from_bowled_water"));
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MUD, 1,
				ModItems.MUDBALL, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.MUDDY_MANGROVE_ROOTS,
				Items.MANGROVE_ROOTS, ModItems.MUDBALL, "", null);
		//# Popped Chorus Fruit | Purpur #
		offerBlastingAndSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.BUILDING_BLOCKS, Items.POPPED_CHORUS_FRUIT,
				50, Items.CHORUS_FRUIT, 0.125F, null);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_PILLAR, 1, Blocks.PURPUR_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PURPUR_SLAB, 2, Blocks.PURPUR_BLOCK);
		offerGenericBlockAndSlabAndStairRecipeSet(exporter, Items.POPPED_CHORUS_FRUIT,
				Blocks.PURPUR_BLOCK, Blocks.PURPUR_SLAB, Blocks.PURPUR_STAIRS, "purpur_blocks");
		//# Prismarine (dark) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.DARK_PRISMARINE_SHARD,
				Items.PRISMARINE_SHARD, Items.INK_SAC, "", "prismarine_shard_transformation");
		offerGenericBlockAndSlabAndStairRecipeSet(exporter, ModItems.DARK_PRISMARINE_SHARD,
				Blocks.DARK_PRISMARINE, Blocks.DARK_PRISMARINE_SLAB, Blocks.DARK_PRISMARINE_STAIRS, "dark_prismarine_blocks");
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE_SLAB, 2, Blocks.DARK_PRISMARINE);
		// NOTE: No Dark Prismarine Wall Post...
		//# Prismarine (pale) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.PRISMARINE_SHARD,
				ModItems.DARK_PRISMARINE_SHARD, ModItems.BOWL_OF_BRIMWATER, "", "prismarine_shard_transformation");
		offerGenericBlockAndSlabAndStairRecipeSet(exporter, Items.PRISMARINE_SHARD,
				Blocks.PRISMARINE, Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_STAIRS, "pale_prismarine_blocks");
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_SLAB, 2, Blocks.PRISMARINE);
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_WALL)
				.input('#', Items.PRISMARINE_SHARD)
				.pattern(" # ")
				.pattern("###")
				.group("pale_prismarine_blocks")
				.criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
				.offerTo(exporter, idFromItem(Blocks.PRISMARINE_WALL));
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_WALL, 2, Blocks.PRISMARINE);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICKS, 1, Blocks.PRISMARINE);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_SLAB, 2, Blocks.PRISMARINE_BRICKS);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_SLAB, 1, Blocks.PRISMARINE_SLAB);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_STAIRS, 1, Blocks.PRISMARINE_STAIRS);
		//# Quartz #
		offerGenericBlockAndSlabAndStairRecipeSet(exporter, Items.QUARTZ,
				Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_SLAB, Blocks.QUARTZ_STAIRS, "quartz_blocks");
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_SLAB, 2, Blocks.QUARTZ_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BRICKS, 1, Blocks.QUARTZ_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_PILLAR, 1, Blocks.QUARTZ_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_QUARTZ_BLOCK, 1, Blocks.QUARTZ_BLOCK);
		//# Travertine #
		offerSmallSquareRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_BLOCK, 1,
				Blocks.POINTED_DRIPSTONE, "_from_spike", null);
		//# Wheat #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HAY_BLOCK,
				Items.STRING, Items.WHEAT, "", null);
		
		//## Seeds (and Saplings) ##
		//# Cherry Sapling #
		offerItemWithFertilizerBucketRecipe(exporter, RecipeCategory.MISC, Items.CHERRY_SAPLING, ModItems.CHERRY_BUNCH,
				fromItem(ModItems.CHERRY_BUNCH), "saplings");
		//# Dark Oak Sapling #
		offerItemWithFertilizerBucketRecipe(exporter, RecipeCategory.MISC, Items.DARK_OAK_SAPLING, Items.GOLDEN_APPLE,
				fromItem(Items.GOLDEN_APPLE), "saplings");
		//# Mahogany Sapling #
		offerItemWithFertilizerBucketRecipe(exporter, RecipeCategory.MISC, Items.JUNGLE_SAPLING, Items.COCOA_BEANS,
				fromItem(Items.COCOA_BEANS), "saplings");
		//# Melon Seed Pile #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.MELON_SEEDS, 1,
				Items.MELON_SLICE, "", null);
		//# Oak Sapling #
		offerItemWithFertilizerBucketRecipe(exporter, RecipeCategory.MISC, Items.OAK_SAPLING, Items.APPLE,
				fromItem(Items.APPLE), "saplings");
		//# Pumpkin Seed Pile #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.PUMPKIN_SEEDS, 4,
				Items.PUMPKIN, "", null);
		
		
		//## Miscellaneous ##
		//# Blastpowder #
		offerShapelessFourIntoOneRecipe(exporter,
				RecipeCategory.MISC, Items.GUNPOWDER, 3,
				ModItems.ASH_PILE, ModItems.SULPHUR_LUMP, Items.CHARCOAL,
				Tags.Item.ALL_GLASSY_SAND_PILES, "has_any_glassy_sand_pile", "", null);
		//# Blaze Powder #
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.BLAZE_POWDER, 3, Items.BLAZE_ROD, "_from_rod", "elemental_rod_pulverizing");
		//# Bonemeal #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.BONE_MEAL, 2, Items.BONE,
				fromItem(Items.BONE), "bonemeal_ball");
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.BONE_MEAL, 3, Items.NAUTILUS_SHELL,
				fromItem(Items.NAUTILUS_SHELL), "bonemeal_ball");
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.BONE_MEAL, 3, Blocks.SKELETON_SKULL,
				fromItem(Blocks.SKELETON_SKULL), "bonemeal_ball");
		//# Clay Brick #
		offerBlastingAndSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.MISC, Items.BRICK,
				50, Items.CLAY_BALL, 0.125F, null);
		offerBrickAndMortarBlockAndSlabAndStairAndWallRecipeSet(exporter, Items.BRICK, Items.CLAY_BALL,
				Blocks.BRICKS, Blocks.BRICK_SLAB, Blocks.BRICK_STAIRS, Blocks.BRICK_WALL, "clay_brick_blocks");
		//# Freeze Powder #
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.FREEZE_POWDER_PILE, 3, ModItems.FREEZE_ROD, "_from_rod", "elemental_rod_pulverizing");
		//# Honey #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HONEY_BLOCK,
				Items.SLIME_BALL, Items.HONEY_BOTTLE, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HONEY_BOTTLE, 8,
				Items.HONEY_BLOCK, Items.GLASS_BOTTLE, "", null);
		//# Honeycomb #
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HONEYCOMB_BLOCK, 1,
				Items.HONEYCOMB, "", null);
		//# Infernocoal #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFERNOCOAL_LUMP)
				.input(Items.COAL)
				.input(Items.REDSTONE)
				.input(Items.REDSTONE)
				.input(Items.MAGMA_CREAM)
				.criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.offerTo(exporter, idFromItem(ModItems.INFERNOCOAL_LUMP));
		//# Nether Brick #
		//TODO: Add smelting recipe to Nether Brick from Netherrack Chunk upon its implementation.
		offerBrickAndMortarBlockAndSlabAndStairAndWallRecipeSet(exporter, Items.NETHER_BRICK, Items.NETHER_WART,
				Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_SLAB, Blocks.NETHER_BRICK_STAIRS, Blocks.NETHER_BRICK_WALL, "nether_brick_blocks");
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.NETHER_BRICK_FENCE)
				.input('#', Items.NETHER_BRICK)
				.input('X', Items.NETHER_WART)
				.pattern(" X ")
				.pattern("###")
				.pattern(" # ")
				.group("nether_brick_blocks")
				.criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
				.criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
				.offerTo(exporter, idFromItem(Blocks.NETHER_BRICK_FENCE));
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_NETHER_BRICKS, 1, Blocks.NETHER_BRICKS);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CRACKED_NETHER_BRICKS, 1, Blocks.NETHER_BRICKS);
		//# Netherwart Brick #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERWART_BRICK)
				.input(Items.NETHER_BRICK)
				.input(Items.NETHER_WART, 3)
				.criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
				.criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
				.offerTo(exporter, idFromItem(ModItems.NETHERWART_BRICK));
		offerBrickAndMortarBlockAndSlabAndStairAndWallRecipeSet(exporter, ModItems.NETHERWART_BRICK, Items.NETHER_WART,
				Blocks.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICK_STAIRS, Blocks.RED_NETHER_BRICK_WALL, "netherwart_brick_blocks");
		//# Slime #
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SLIME_BLOCK, 1,
				Items.SLIME_BALL, "", null);
		//endregion
		
		
		//region ### Container Recipes (handheld) ###
		//## Bottle (empty) ##
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLASS_BOTTLE)
				.input('#', ModItems.CLEAR_GLASS_PANE)
				.input('/', Items.STICK)
				.pattern("/")
				.pattern("#")
				.group("empty_bottle")
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(ModItems.CLEAR_GLASS_PANE, "_single"));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLASS_BOTTLE, 3)
				.input('#', ModItems.CLEAR_GLASS_PANE)
				.input('/', Items.STICK)
				.pattern(" / ")
				.pattern("# #")
				.pattern(" # ")
				.group("empty_bottle")
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(ModItems.CLEAR_GLASS_PANE, "_triple"));
		//## Bowl (empty) ##
		offerBowlRecipe(exporter,
				RecipeCategory.MISC, Items.BOWL, 2, Tags.Item.ALL_PLANKS,
				"has_any_plank", "", null);
		//## Bucket (empty) ##
		offerBowlRecipe(exporter,
				RecipeCategory.MISC, Items.BUCKET, 1, Items.IRON_INGOT, "", null);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.RAW_IRON, 3,
				Items.BUCKET, "", null);
		//## Bucket (filled) ##
		//# Bucket of Fertilizer #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_FERTILIZER)
				.input(ModItems.ASH_PILE)
				.input(Items.BONE_MEAL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.input(Items.BUCKET)
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_FERTILIZER));
		ComplexRecipeJsonBuilder.create(BucketFertilizerTransfer::new).offerTo(exporter, "bucket_fertilizer_transfer");
		//endregion
		
		
		//region ## Container Recipes (placed) ##
		//# Barrel #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BARREL)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('O', Items.SLIME_BALL)
				.pattern("#X#")
				.pattern("#O#")
				.pattern("#X#")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.offerTo(exporter, idFromItem(Blocks.BARREL));
		//# Basic Chest #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.CHEST, 1,
				Items.IRON_INGOT, Tags.Item.ALL_PLANKS,
				"has_any_plank", "", null);
		//# Ender Chest #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.ENDER_CHEST,
				Items.ENDER_EYE, ModItems.OBSIDIAN_SHARD, "", null);
		//# Shulker Box #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SHULKER_BOX)
				.input('#', Blocks.CHEST)
				.input('-', Items.SHULKER_SHELL)
				.pattern("-")
				.pattern("#")
				.pattern("-")
				.criterion(hasItem(Items.SHULKER_SHELL), conditionsFromItem(Items.SHULKER_SHELL))
				.offerTo(exporter, idFromItem(Blocks.SHULKER_BOX));
		//# Trapped Chest #
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.TRAPPED_CHEST, 1,
				Blocks.CHEST, Blocks.TRIPWIRE_HOOK, "", null);
		//endregion
		
		//region ## Equipment Recipes ##
		//# [tier 0] Wooden Stick #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHARP_WOODEN_STICK)
				.input(Items.STICK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(ModItems.SHARP_WOODEN_STICK));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BOW)
				.input('/', Items.STICK)
				.input('@', Items.STRING)
				.pattern("@/ ")
				.pattern("@ /")
				.pattern("@/ ")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(Items.BOW));
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.STICK, 1,
				Items.BOW, fromItem(Items.BOW), null);
		//# [tier 1] Leather #
		// Leather Boot Pair
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.LEATHER_BOOTS)
				.input('#', Items.LEATHER)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("# #")
				.pattern("#O#")
				.group("leather_armor")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.offerTo(exporter, idFromItem(Items.LEATHER_BOOTS));
		// Leather Cap
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.LEATHER_HELMET)
				.input('#', Items.LEATHER)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("###")
				.pattern("#O#")
				.group("leather_armor")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.offerTo(exporter, idFromItem(Items.LEATHER_HELMET));
		// Leather Horse Harness
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.LEATHER_HORSE_ARMOR)
				.input('#', Items.LEATHER)
				.input('X', Tags.Item.ALL_YARN_ROLLS)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("#X#")
				.pattern("###")
				.pattern("#O#")
				.group("leather_armor")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.offerTo(exporter, idFromItem(Items.LEATHER_HORSE_ARMOR));
		// Leather Pant Pair
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.LEATHER_LEGGINGS)
				.input('#', Items.LEATHER)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("###")
				.pattern("#O#")
				.pattern("# #")
				.group("leather_armor")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.offerTo(exporter, idFromItem(Items.LEATHER_LEGGINGS));
		// Leather Tunic
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.LEATHER_CHESTPLATE)
				.input('#', Items.LEATHER)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("#O#")
				.pattern("###")
				.pattern("###")
				.group("leather_armor")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.offerTo(exporter, idFromItem(Items.LEATHER_CHESTPLATE));
		// Leather Wolf Harness
		// TODO: Implement Leather Wolf Harness item.
		//# [tier 1] Wood #
		offerBasicDaggerRecipe(exporter, ModItems.WOODEN_DAGGER, Tags.Item.ALL_PLANKS, "has_any_plank", "", "wooden_tools");
		offerBasicMalletRecipe(exporter, ModItems.WOODEN_MALLET, Tags.Item.ALL_PLANKS, "has_any_plank", "", "wooden_tools");
		offerBasicShovelRecipe(exporter, ModItems.WOODEN_SHOVEL, Tags.Item.ALL_PLANKS, "has_any_plank", "", "wooden_tools");
		offerBasicSpearRecipe(exporter, ModItems.WOODEN_SPEAR, Tags.Item.ALL_PLANKS, "has_any_plank", "", "wooden_tools");
		offerBasicSwordRecipe(exporter, ModItems.WOODEN_SWORD, Tags.Item.ALL_PLANKS, "has_any_plank", "", "wooden_tools");
		//# [tier 2] Flint #
		offerPrimitiveShaftedToolRecipeSet(exporter, Items.FLINT, "flint",
				ModItems.FLINT_DAGGER, ModItems.FLINT_HATCHET, ModItems.FLINT_HOE, ModItems.FLINT_SPEAR);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.TOOLS, Items.FLINT_AND_STEEL, 1,
				Items.FLINT, Items.IRON_INGOT, "", null);
		//# [tier 2] Glass #
		offerPrimitiveShaftedToolRecipeSet(exporter, ModItems.GLASS_SHARD, "glass",
				ModItems.GLASS_DAGGER, ModItems.GLASS_HATCHET, ModItems.GLASS_HOE, ModItems.GLASS_SPEAR);
		//# [tier 2] Obsidian #
		offerPrimitiveShaftedToolRecipeSet(exporter, ModItems.OBSIDIAN_SHARD, "obsidian",
				ModItems.OBSIDIAN_DAGGER, ModItems.OBSIDIAN_HATCHET, ModItems.OBSIDIAN_HOE, ModItems.OBSIDIAN_SPEAR);
		//# [tier 3] Brass #
		offerMetalEquipmentRecipeSet(exporter, ModItems.BRASS_INGOT, ModItems.RAW_BRASS_NUGGET, "brass",
				ModItems.BRASS_BOOT_PAIR, ModItems.BRASS_CHESTPLATE,
				ModItems.BRASS_HELMET, ModItems.BRASS_LEGGING_PAIR,
				ModItems.BRASS_HORSE_HARNESS,
				ModItems.BRASS_AXE, ModItems.BRASS_DAGGER, ModItems.BRASS_HATCHET,
				ModItems.BRASS_HOE, ModItems.BRASS_MALLET, ModItems.BRASS_PICKAXE,
				ModItems.BRASS_SHOVEL, ModItems.BRASS_SPEAR, ModItems.BRASS_SWORD);
		//# [tier 3] Copper #
		offerMetalEquipmentRecipeSet(exporter, Items.COPPER_INGOT, ModItems.RAW_COPPER_NUGGET, "copper",
				ModItems.COPPER_BOOT_PAIR, ModItems.COPPER_CHESTPLATE,
				ModItems.COPPER_HELMET, ModItems.COPPER_LEGGING_PAIR,
				ModItems.COPPER_HORSE_HARNESS,
				ModItems.COPPER_AXE, ModItems.COPPER_DAGGER, ModItems.COPPER_HATCHET,
				ModItems.COPPER_HOE, ModItems.COPPER_MALLET, ModItems.COPPER_PICKAXE,
				ModItems.COPPER_SHOVEL, ModItems.COPPER_SPEAR, ModItems.COPPER_SWORD);
		//# [tier 3] Eiduril #
		offerMetalEquipmentRecipeSet(exporter, ModItems.EIDURIL_INGOT, ModItems.RAW_EIDURIL_NUGGET, "eiduril",
				ModItems.EIDURIL_BOOT_PAIR, ModItems.EIDURIL_CHESTPLATE,
				ModItems.EIDURIL_HELMET, ModItems.EIDURIL_LEGGING_PAIR,
				ModItems.EIDURIL_HORSE_HARNESS,
				ModItems.EIDURIL_AXE, ModItems.EIDURIL_DAGGER, ModItems.EIDURIL_HATCHET,
				ModItems.EIDURIL_HOE, ModItems.EIDURIL_MALLET, ModItems.EIDURIL_PICKAXE,
				ModItems.EIDURIL_SHOVEL, ModItems.EIDURIL_SPEAR, ModItems.EIDURIL_SWORD);
		//# [tier 3] Gold #
		offerMetalEquipmentRecipeSet(exporter, Items.GOLD_INGOT, Items.GOLD_NUGGET, "gold",
				Items.GOLDEN_BOOTS, Items.GOLDEN_CHESTPLATE,
				Items.GOLDEN_HELMET, Items.GOLDEN_LEGGINGS,
				Items.GOLDEN_HORSE_ARMOR,
				Items.GOLDEN_AXE, ModItems.GOLDEN_DAGGER, ModItems.GOLDEN_HATCHET,
				Items.GOLDEN_HOE, ModItems.GOLDEN_MALLET, Items.GOLDEN_PICKAXE,
				Items.GOLDEN_SHOVEL, ModItems.GOLDEN_SPEAR, Items.GOLDEN_SWORD);
		//# [tier 3] Iron
		offerMetalEquipmentRecipeSet(exporter, Items.IRON_INGOT, Items.IRON_NUGGET, "iron",
				Items.IRON_BOOTS, Items.IRON_CHESTPLATE,
				Items.IRON_HELMET, Items.IRON_LEGGINGS,
				Items.IRON_HORSE_ARMOR,
				Items.IRON_AXE, ModItems.IRON_DAGGER, ModItems.IRON_HATCHET,
				Items.IRON_HOE, ModItems.IRON_MALLET, Items.IRON_PICKAXE,
				Items.IRON_SHOVEL, ModItems.IRON_SPEAR, Items.IRON_SWORD);
		//# [tier 3] Chainmail Recycling #
		offerMetalHumanoidArmorRecyclingRecipeSet(exporter, Items.IRON_NUGGET, "chainmail",
				Items.CHAINMAIL_BOOTS, Items.CHAINMAIL_CHESTPLATE,
				Items.CHAINMAIL_HELMET, Items.CHAINMAIL_LEGGINGS);
		//# Miscellaneous Armor & Tools #
		// MA&T - Brush
		offerBrushRecipe(exporter, Items.BRUSH);
		// MA&T - Clock
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.CLOCK,
				Items.REDSTONE, ModItems.GOLD_GRAM, "", null);
		// MA&T - Compass
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.COMPASS,
				Items.REDSTONE, ModItems.IRON_GRAM, "", null);
		// MA&T - Crossbow
		offerCrossbowRecipe(exporter, ModItems.BRASS_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.COPPER_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, ModItems.EIDURIL_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.GOLD_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.IRON_INGOT, "crossbow");
		// MA&T - Experience Bottle
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.EXPERIENCE_BOTTLE)
				.input('#', Items.GLASS_BOTTLE)
				.input('X', Items.ECHO_SHARD)
				.input('O', Items.LAPIS_LAZULI)
				.input('-', Items.GUNPOWDER)
				.pattern(" - ")
				.pattern("XOX")
				.pattern(" # ")
				.criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
				.offerTo(exporter, idFromItem(Items.EXPERIENCE_BOTTLE));
		// MA&T - Fishing Rod
		offerFishingRodRecipe(exporter, Items.FISHING_ROD, ModItems.BRASS_GRAM);
		offerFishingRodRecipe(exporter, Items.FISHING_ROD, ModItems.COPPER_GRAM);
		offerFishingRodRecipe(exporter, Items.FISHING_ROD, ModItems.EIDURIL_GRAM);
		offerFishingRodRecipe(exporter, Items.FISHING_ROD, ModItems.GOLD_GRAM);
		offerFishingRodRecipe(exporter, Items.FISHING_ROD, ModItems.IRON_GRAM);
		// MA&T - Helmet (turtle)
		offerEightAroundOneRecipe(exporter, RecipeCategory.COMBAT, Items.TURTLE_HELMET,
				Items.LEATHER_HELMET, Items.TURTLE_SCUTE, "", null);
		// MA&T - Map
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.MAP,
				Items.PAPER, Items.COMPASS, fromItem(Items.PAPER), "empty_map");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.MAP,
				ModItems.WHITE_YARN_ROLL, Items.COMPASS, fromItem(ModItems.WHITE_YARN_ROLL), "empty_map");
		// MA&T - Modified Fishing Rod - Carrot on a Stick
		offerTwoIntoOneRecipe(exporter, RecipeCategory.TRANSPORTATION, Items.CARROT_ON_A_STICK,
				Items.FISHING_ROD, Items.CARROT, "", "modified_fishing_rods");
		// MA&T - Modified Fishing Rod - Wallompus Mushroom on a Stick
		offerTwoIntoOneRecipe(exporter, RecipeCategory.TRANSPORTATION, Items.WARPED_FUNGUS_ON_A_STICK,
				Items.FISHING_ROD, Items.WARPED_FUNGUS, "", "modified_fishing_rods");
		// MA&T - Pair of Shears
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SHEARS)
				.input('#', ModItems.BRASS_GRAM)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X X")
				.pattern("X#X")
				.pattern("###")
				.criterion(hasItem(ModItems.BRASS_GRAM), conditionsFromItem(ModItems.BRASS_GRAM))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Items.SHEARS));
		// MA&T - Recovery Compass
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.RECOVERY_COMPASS,
				Items.COMPASS, Items.ECHO_SHARD, "", null);
		// MA&T - Saddle
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SADDLE)
				.input('#', Items.LEATHER)
				.input('X', Items.IRON_INGOT)
				.input('O', Items.LEAD)
				.pattern("###")
				.pattern("#O#")
				.pattern("OXO")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.LEAD), conditionsFromItem(Items.LEAD))
				.offerTo(exporter, idFromItem(Items.SADDLE));
		// MA&T - Shield
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SHIELD)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('-', ModItems.IRON_GRAM)
				.pattern("-#-")
				.pattern("-#-")
				.pattern("-#-")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Items.SHIELD));
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, Items.IRON_NUGGET, 1,
				Items.SHIELD, fromItem(Items.SHIELD) + "_recycling", "iron_equipment_recycling");
		// MA&T - Spatial Recall Stone
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SPATIAL_RECALL_STONE)
				.input('#', Items.GHAST_TEAR)
				.input('@', Items.ENDER_EYE)
				.input('/', Items.AMETHYST_SHARD)
				.input('O', Items.MAGMA_CREAM)
				.input('H', Items.RECOVERY_COMPASS)
				.input('-', ModItems.EIDURIL_GRAM)
				.pattern("#/#")
				.pattern("O@O")
				.pattern("-H-")
				.criterion(hasItem(Items.GHAST_TEAR), conditionsFromItem(Items.GHAST_TEAR))
				.criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
				.criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.criterion(hasItem(Items.RECOVERY_COMPASS), conditionsFromItem(Items.RECOVERY_COMPASS))
				.criterion(hasItem(ModItems.EIDURIL_INGOT), conditionsFromItem(ModItems.EIDURIL_INGOT))
				.offerTo(exporter, idFromItem(ModItems.SPATIAL_RECALL_STONE));
		// MA&T - Spyglass
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SPYGLASS)
				.input('#', Ingredient.ofItems(ModItems.BRASS_INGOT, Items.COPPER_INGOT))
				.input('X', Items.AMETHYST_SHARD)
				.pattern("X")
				.pattern("#")
				.pattern("#")
				.criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
				.offerTo(exporter, idFromItem(Items.SPYGLASS));
		// MA&T - Target Teleportation Tuner
		// Note: Eiduril ingot and grams would be replaced by a pair of rods, given the implementation of rods.
		// - A rod would be equivalent to 2 grams.
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TARGET_TELEPORTATION_TUNER)
				.input('#', Items.NETHERITE_INGOT)
				.input('X', Items.ECHO_SHARD)
				.input('/', ModItems.EIDURIL_INGOT)
				.input('@', ModItems.EIDURIL_GRAM)
				.input('O', Items.REDSTONE)
				.pattern(" @/")
				.pattern("OX@")
				.pattern("#O ")
				.criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
				.criterion(hasItem(Items.ECHO_SHARD), conditionsFromItem(Items.ECHO_SHARD))
				.criterion(hasItem(ModItems.EIDURIL_INGOT), conditionsFromItem(ModItems.EIDURIL_INGOT))
				.criterion(hasItem(ModItems.EIDURIL_GRAM), conditionsFromItem(ModItems.EIDURIL_GRAM))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(ModItems.TARGET_TELEPORTATION_TUNER));
		// MA&T - Totem of Undying
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.TOTEM_OF_UNDYING)
				.input('#', Items.GOLD_INGOT)
				.input('O', Items.EMERALD)
				.input('X', Items.NETHER_STAR)
				.pattern("O#O")
				.pattern("#X#")
				.pattern(" # ")
				.criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
				.offerTo(exporter, idFromItem(Items.TOTEM_OF_UNDYING));
		// MA&T - Trident
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.TRIDENT)
				.input('#', Items.COPPER_INGOT)
				.input('O', Items.HEART_OF_THE_SEA)
				.input('/', Items.PRISMARINE_SHARD)
				.input('-', Items.PRISMARINE_CRYSTALS)
				.pattern(" /-")
				.pattern(" O/")
				.pattern("#  ")
				.criterion(hasItem(Items.HEART_OF_THE_SEA), conditionsFromItem(Items.HEART_OF_THE_SEA))
				.criterion(hasItem(Items.PRISMARINE_CRYSTALS), conditionsFromItem(Items.PRISMARINE_CRYSTALS))
				.offerTo(exporter, idFromItem(Items.TRIDENT));
		// MA&T - Wolf Harness (armadillo)
		offerEightAroundOneRecipe(exporter, RecipeCategory.COMBAT, Items.WOLF_ARMOR,
				Items.LEATHER, //TODO: Replace with Leather Wolf Harness upon implementation.
				Items.ARMADILLO_SCUTE, "", "wolf_harnesses");
		// MA&T - Wolf Harness (armadillo)
		// TODO: Implement Turtle Wolf Harness item.
		//endregion
		
		//region ## Fluid Recipes ##
		//# (FlR) Brimwater (production) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOTTLE_OF_BRIMWATER)
				.input(ModItems.SULPHUR_LUMP)
				.input(Items.GLASS_BOTTLE)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOTTLE_OF_BRIMWATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_BRIMWATER)
				.input(ModItems.SULPHUR_LUMP)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_BRIMWATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_BRIMWATER)
				.input(ModItems.SULPHUR_LUMP).input(ModItems.SULPHUR_LUMP).input(ModItems.SULPHUR_LUMP)
				.input(Items.BUCKET)
				.input(ModItems.BUCKET_OF_STEAMING_WATER)
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(ModItems.BUCKET_OF_STEAMING_WATER), conditionsFromItem(ModItems.BUCKET_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_BRIMWATER));
		
		//# (FlR) Brimwater (transfer) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_BRIMWATER, 1,
				ModItems.BOWL_OF_BRIMWATER, Items.GLASS_BOTTLE, "_from_bowl_transfer", "brimwater_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_BRIMWATER, 3,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_BRIMWATER, "_from_bucket_transfer_into_three", "brimwater_transfer");
		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_BRIMWATER, 2,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_BRIMWATER, "_from_bucket_transfer_into_two", "brimwater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_BRIMWATER, 1,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_BRIMWATER, "_from_bucket_transfer_into_one", "brimwater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_BRIMWATER, 1,
				ModItems.BOTTLE_OF_BRIMWATER, Items.BOWL, "_from_bottle_transfer", "brimwater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_BRIMWATER, 1,
				Items.BOWL, ModItems.BUCKET_OF_BRIMWATER, "_from_bucket_transfer", "brimwater_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BUCKET_OF_BRIMWATER, 1,
				Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER, "has_small_container_of_brimwater", Items.BUCKET,
				"_from_small_container_transfer", "brimwater_transfer");
		
		//# (FlR) Freezewater (production) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOTTLE_OF_FREEZEWATER)
				.input(ModItems.FREEZE_POWDER_PILE)
				.input(Items.GLASS_BOTTLE)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(ModItems.FREEZE_POWDER_PILE), conditionsFromItem(ModItems.FREEZE_POWDER_PILE))
				.criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOTTLE_OF_FREEZEWATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_FREEZEWATER)
				.input(ModItems.FREEZE_POWDER_PILE)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(ModItems.FREEZE_POWDER_PILE), conditionsFromItem(ModItems.FREEZE_POWDER_PILE))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_FREEZEWATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_FREEZEWATER)
				.input(ModItems.FREEZE_POWDER_PILE).input(ModItems.FREEZE_POWDER_PILE).input(ModItems.FREEZE_POWDER_PILE)
				.input(Items.BUCKET)
				.input(Items.WATER_BUCKET)
				.criterion(hasItem(ModItems.FREEZE_POWDER_PILE), conditionsFromItem(ModItems.FREEZE_POWDER_PILE))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_FREEZEWATER));
		
		//# (FlR) Freezewater (transfer) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_FREEZEWATER, 1,
				ModItems.BOWL_OF_FREEZEWATER, Items.GLASS_BOTTLE, "_from_bowl_transfer", "freezewater_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_FREEZEWATER, 3,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_FREEZEWATER, "_from_bucket_transfer_into_three", "freezewater_transfer");
		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_FREEZEWATER, 2,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_FREEZEWATER, "_from_bucket_transfer_into_two", "freezewater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_FREEZEWATER, 1,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_FREEZEWATER, "_from_bucket_transfer_into_one", "freezewater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_FREEZEWATER, 1,
				ModItems.BOTTLE_OF_FREEZEWATER, Items.BOWL, "_from_bottle_transfer", "freezewater_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_FREEZEWATER, 1,
				Items.BOWL, ModItems.BUCKET_OF_FREEZEWATER, "_from_bucket_transfer", "freezewater_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BUCKET_OF_FREEZEWATER, 1,
				Tags.Item.SMALL_CONTAINERS_OF_FREEZEWATER, "has_small_container_of_freezewater", Items.BUCKET,
				"_from_small_container_transfer", "freezewater_transfer");
		
		//# (FlR) Honey (transfer) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.HONEY_BOTTLE, 1,
				ModItems.BOWL_OF_HONEY, Items.GLASS_BOTTLE, "_from_bowl_transfer", "honey_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, Items.HONEY_BOTTLE, 3,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_HONEY, "_from_bucket_transfer_into_three", "honey_transfer");
		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, Items.HONEY_BOTTLE, 2,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_HONEY, "_from_bucket_transfer_into_two", "honey_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.HONEY_BOTTLE, 1,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_HONEY, "_from_bucket_transfer_into_one", "honey_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_HONEY, 1,
				Items.HONEY_BOTTLE, Items.BOWL, "_from_bottle_transfer", "honey_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_HONEY, 1,
				Items.BOWL, ModItems.BUCKET_OF_HONEY, "_from_bucket_transfer", "honey_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BUCKET_OF_HONEY, 1,
				Tags.Item.SMALL_CONTAINERS_OF_HONEY, "has_small_container_of_honey", Items.BUCKET,
				"_from_small_container_transfer", "honey_transfer");
		
		//# (FlR) Milk (transfer) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_MILK, 1,
				ModItems.BOWL_OF_MILK, Items.GLASS_BOTTLE, "_from_bowl_transfer", "milk_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_MILK, 3,
				Items.GLASS_BOTTLE, Items.MILK_BUCKET, "_from_bucket_transfer_into_three", "milk_transfer");
		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_MILK, 2,
				Items.GLASS_BOTTLE, Items.MILK_BUCKET, "_from_bucket_transfer_into_two", "milk_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_MILK, 1,
				Items.GLASS_BOTTLE, Items.MILK_BUCKET, "_from_bucket_transfer_into_one", "milk_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_MILK, 1,
				ModItems.BOTTLE_OF_MILK, Items.BOWL, "_from_bottle_transfer", "milk_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_MILK, 1,
				Items.BOWL, Items.MILK_BUCKET, "_from_bucket_transfer", "milk_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, Items.MILK_BUCKET, 1,
				Tags.Item.SMALL_CONTAINERS_OF_MILK, "has_small_container_of_milk", Items.BUCKET,
				"_from_small_container_transfer", "milk_transfer");
		
		//# (FlR) Steaming Water (production) #
		// NOTE: Steaming water production allows for removing the effects of potions.
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER,
				50, Items.POTION, 0.0625F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_STEAMING_WATER,
				50, ModItems.BOWL_OF_WATER, 0.0625F);
		
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER)
				.input(Items.BLAZE_POWDER)
				.input(Items.GLASS_BOTTLE)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOTTLE_OF_STEAMING_WATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_STEAMING_WATER)
				.input(Items.BLAZE_POWDER)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_STEAMING_WATER));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_STEAMING_WATER)
				.input(Items.BLAZE_POWDER).input(Items.BLAZE_POWDER).input(Items.BLAZE_POWDER)
				.input(Items.BUCKET)
				.input(Items.WATER_BUCKET)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_STEAMING_WATER));
		
		//# (FlR) Steaming Water (transfer) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER, 1,
				ModItems.BOWL_OF_STEAMING_WATER, Items.GLASS_BOTTLE, "_from_bowl_transfer", "steaming_water_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER, 3,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_STEAMING_WATER, "_from_bucket_transfer_into_three", "steaming_water_transfer");
		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER, 2,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_STEAMING_WATER, "_from_bucket_transfer_into_two", "steaming_water_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOTTLE_OF_STEAMING_WATER, 1,
				Items.GLASS_BOTTLE, ModItems.BUCKET_OF_STEAMING_WATER, "_from_bucket_transfer_into_one", "steaming_water_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_STEAMING_WATER, 1,
				ModItems.BOTTLE_OF_STEAMING_WATER, Items.BOWL, "_from_bottle_transfer", "steaming_water_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_STEAMING_WATER, 1,
				Items.BOWL, ModItems.BUCKET_OF_STEAMING_WATER, "_from_bucket_transfer", "steaming_water_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, ModItems.BUCKET_OF_STEAMING_WATER, 1,
				Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER, "has_small_container_of_steaming_water", Items.BUCKET,
				"_from_small_container_transfer", "steaming_water_transfer");
		
		//# (FlR) Water (transfer) #
		ComplexRecipeJsonBuilder.create(WaterTransferRecipe::new).offerTo(exporter, "fluid_transfer_of_water");
		//endregion
		
		//region ## Food Recipes ##
		//# (FoR) Basic Food Cooking #
		// Baked Carrot
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_CARROT,
				100, Items.CARROT, 0.125F);
		// Baked Mushroom
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_MUSHROOM,
				100, Items.BROWN_MUSHROOM, 0.125F, "baked_mushroom");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_MUSHROOM,
				200, Items.RED_MUSHROOM, 0.125F, "baked_mushroom");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_MUSHROOM,
				400, Items.CRIMSON_FUNGUS, 0.125F, "baked_mushroom");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_MUSHROOM,
				400, Items.WARPED_FUNGUS, 0.125F, "baked_mushroom");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_MUSHROOM,
				200, ModItems.STARCHCAP_MUSHROOM, 0.125F, "baked_mushroom");
		// Baked Potato
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.BAKED_POTATO,
				100, Items.POTATO, 0.125F);
		// Baked Radish
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.BAKED_RADISH,
				100, Items.BEETROOT, 0.125F);
		// Cooked Beef Steak
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_BEEF,
				100, Items.BEEF, 0.125F);
		// Cooked Bugmeat Steak
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.COOKED_BUGMEAT_STEAK,
				100, ModItems.RAW_BUGMEAT_STEAK, 0.125F);
		// Cooked Chicken
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_CHICKEN,
				100, Items.CHICKEN, 0.125F);
		// Cooked Cod
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_COD,
				100, Items.COD, 0.125F);
		// Cooked Meat Morsel
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.COOKED_MEAT_MORSEL,
				50, ModItems.RAW_MEAT_MORSEL, 0.125F);
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.COOKED_MEAT_MORSEL,
				100, Items.TROPICAL_FISH, 0.125F);
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.COOKED_MEAT_MORSEL,
				200, Items.PUFFERFISH, 0.125F);
		// Cooked Mutton Steak
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_MUTTON,
				100, Items.MUTTON, 0.125F);
		// Cooked Porkchop
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_PORKCHOP,
				100, Items.PORKCHOP, 0.125F);
		// Cooked Rabbit
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_RABBIT,
				100, Items.RABBIT, 0.125F);
		// Cooked Salmon
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.COOKED_SALMON,
				100, Items.SALMON, 0.125F);
		// Dry Kelp Leaf
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, Items.DRIED_KELP,
				100, Items.KELP, 0.0625F);
		// Fried Egg
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100,
				Items.EGG, 0.125F, "fried_egg");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100,
				Items.SNIFFER_EGG, 0.125F, "fried_egg");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100,
				Items.TURTLE_EGG, 0.125F, "fried_egg");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100, Tags.Item.SPAWN_EGGS,
				"has_any_spawn_egg", "_from_spawn_egg", 0.125F, "fried_egg");
		
		//# (FoR) Bowl (soup) #
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_CARROT_SOUP, ModItems.BAKED_CARROT, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_KELP_SOUP, ModItems.DRY_KELP_BUNDLE, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_MUSHROOM_SOUP, ModItems.BAKED_MUSHROOM, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_PORRIDGE, Items.WHEAT, "", null);
		// Using new recipe type!
		//TODO: Override the ingredient remainder for the Bowl of Steaming Water (when the feature is implemented).
		BasicGridRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BOWL_OF_POISONOUS_POTATO_SOUP)
				.input(Items.POISONOUS_POTATO)
				.input(Items.BAKED_POTATO, 2)
				.input(ModItems.BOWL_OF_STEAMING_WATER)
				.criterion(hasItem(Items.POISONOUS_POTATO), conditionsFromItem(Items.POISONOUS_POTATO))
				.criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
				.criterion(hasItem(ModItems.BOWL_OF_STEAMING_WATER), conditionsFromItem(ModItems.BOWL_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_POISONOUS_POTATO_SOUP));
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_POTATO_SOUP, Items.BAKED_POTATO, "", null);
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.FOOD, ModItems.BOWL_OF_PUMPKIN_SOUP, 1,
				Items.PUMPKIN, Items.BOWL, Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER,
				"has_small_container_of_steaming_water", "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_RADISH_SOUP, ModItems.BAKED_RADISH, "", null);
		
		//# (FoR) Bowl (stew) #
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_BEEF_STEW, Items.COOKED_BEEF);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_BUGMEAT_STEW, ModItems.COOKED_BUGMEAT_STEAK);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_CHICKEN_STEW, Items.COOKED_CHICKEN);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_COD_STEW, Items.COOKED_COD);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_MORSEL_STEW, ModItems.COOKED_MEAT_MORSEL);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_MUTTON_STEW, Items.COOKED_MUTTON);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_PORK_STEW, Items.COOKED_PORKCHOP);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_RABBIT_STEW, Items.COOKED_RABBIT);
		offerBowlOfStewRecipe(exporter, ModItems.BOWL_OF_SALMON_STEW, Items.COOKED_SALMON);
		ComplexRecipeJsonBuilder.create(SuspiciousStewRecipe::new).offerTo(exporter, "bowl_of_suspicious_stew");
		
		//# (FoR) Pie #
		// Apple Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.APPLE_PIE,
				200, ModItems.RAW_APPLE_PIE, 2.5F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_APPLE_PIE)
				.input(Items.APPLE)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_APPLE_PIE));
		// Cherry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.CHERRY_PIE,
				200, ModItems.RAW_CHERRY_PIE, 2.5F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_CHERRY_PIE)
				.input(ModItems.CHERRY_BUNCH).input(ModItems.CHERRY_BUNCH).input(ModItems.CHERRY_BUNCH)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(ModItems.CHERRY_BUNCH), conditionsFromItem(ModItems.CHERRY_BUNCH))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_CHERRY_PIE));
		// Glowberry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.GLOWBERRY_PIE,
				200, ModItems.RAW_GLOWBERRY_PIE, 2.5F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_GLOWBERRY_PIE)
				.input(Items.GLOW_BERRIES).input(Items.GLOW_BERRIES).input(Items.GLOW_BERRIES)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_GLOWBERRY_PIE));
		// Pumpkin Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.PUMPKIN_PIE,
				200, ModItems.RAW_PUMPKIN_PIE, 2.5F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_PUMPKIN_PIE)
				.input(Items.PUMPKIN)
				.input(Items.SUGAR)
				.input(Items.SUGAR)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.PUMPKIN), conditionsFromItem(Items.PUMPKIN))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_PUMPKIN_PIE));
		// Sweetberry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SWEETBERRY_PIE,
				200, ModItems.RAW_SWEETBERRY_PIE, 2.5F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_SWEETBERRY_PIE)
				.input(Items.SWEET_BERRIES).input(Items.SWEET_BERRIES).input(Items.SWEET_BERRIES)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_SWEETBERRY_PIE));
		
		//# (FoR) Miscellaneous Pastries & Baked Foods #
		// Bread & Raw Dough
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.BREAD,
				200, ModItems.RAW_DOUGH_LUMP, 0.5F, null);
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_DOUGH_LUMP)
				.input('#', Items.WHEAT)
				.input('@', ModItems.BOWL_OF_WATER)
				.pattern("###")
				.pattern("###")
				.pattern(" @ ")
				.criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
				.criterion(hasItem(ModItems.BOWL_OF_WATER), conditionsFromItem(ModItems.BOWL_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.RAW_DOUGH_LUMP));
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_DOUGH_LUMP)
				.input('#', Items.WHEAT)
				.input('O', Items.EGG)
				.input('@', ModItems.BOWL_OF_WATER)
				.pattern("###")
				.pattern("O@O")
				.criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
				.criterion(hasItem(ModItems.BOWL_OF_WATER), conditionsFromItem(ModItems.BOWL_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.RAW_DOUGH_LUMP, "_from_eggs"));
		// Cake
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.CAKE,
				400, ModItems.RAW_CAKE, 7.5F, null);
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_CAKE)
				.input('#', ModItems.RAW_DOUGH_LUMP)
				.input('X', Tags.Item.RAW_CAKE_BERRIES)
				.input('O', Items.EGG)
				.input('-', Items.SUGAR)
				.input('@', Items.MILK_BUCKET)
				.pattern("X-X")
				.pattern("-#-")
				.pattern("O@O")
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.criterion("has_raw_cake_berry", conditionsFromTag(Tags.Item.RAW_CAKE_BERRIES))
				.criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
				.offerTo(exporter, idFromItem(ModItems.RAW_CAKE));
		// Cookie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.COOKIE,
				100, ModItems.RAW_COOKIE_BALL, 0.375F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_COOKIE_BALL, 4)
				.input(Items.COCOA_BEANS)
				.input(Items.SUGAR)
				.input(Items.COCOA_BEANS)
				.input(Items.SUGAR)
				.input(ModItems.RAW_DOUGH_LUMP)
				.input(Items.SUGAR)
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_COOKIE_BALL));
		// Honeybun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.HONEYBUN,
				100, ModItems.RAW_HONEYBUN_BALL, 0.375F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_HONEYBUN_BALL, 4)
				.input(Items.HONEY_BOTTLE)
				.input(Items.HONEY_BOTTLE)
				.input(Items.HONEY_BOTTLE)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_HONEYBUN_BALL));
		// Magmabun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.MAGMABUN,
				100, ModItems.RAW_MAGMABUN_BALL, 0.375F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_MAGMABUN_BALL, 4)
				.input(Items.MAGMA_CREAM)
				.input(Items.SUGAR)
				.input(Items.MAGMA_CREAM)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_MAGMABUN_BALL));
		// Slimebun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SLIMEBUN,
				100, ModItems.RAW_SLIMEBUN_BALL, 0.375F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_SLIMEBUN_BALL, 4)
				.input(Items.SLIME_BALL)
				.input(Items.SUGAR)
				.input(Items.SLIME_BALL)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_SLIMEBUN_BALL));
		
		//# (FoR) Rotten & Warped Flesh #
		// Rotten Flesh Chunk (from 1 meat item)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.ROTTEN_FLESH)
				.input(Ingredient.fromTag(Tags.Item.LARGE_ROTTABLE_MEATS))
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.group("meat_rotting")
				.criterion("has_large_rottable_meat", conditionsFromTag(Tags.Item.LARGE_ROTTABLE_MEATS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.ROTTEN_FLESH, "_from_large_rottable_meat"));
		// Rotten Flesh Chunk (from 2 meat items)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.ROTTEN_FLESH)
				.input(Ingredient.fromTag(Tags.Item.SMALL_ROTTABLE_MEATS), 2)
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.group("meat_rotting")
				.criterion("has_small_rottable_meat", conditionsFromTag(Tags.Item.SMALL_ROTTABLE_MEATS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.ROTTEN_FLESH, "_from_small_rottable_meat"));
		// Warped Flesh Chunk
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.FOOD, ModItems.WARPED_FLESH_CHUNK, 1,
				Items.ROTTEN_FLESH, Items.SUGAR, Items.WARPED_FUNGUS, "", null);
		//endregion
		
		//region ### Decoration & Utility Recipes ###
		
		//region ## Workstation Recipes (cooking) ##
		//# Basic Furnace #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.FURNACE)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.pattern(" # ")
				.pattern("# #")
				.pattern("###")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.offerTo(exporter, idFromItem(Blocks.FURNACE));
		//# Blast Furnace #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Items.IRON_INGOT)
				.pattern(" # ")
				.pattern("# #")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.BLAST_FURNACE));
		//# Campfire (basic) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CAMPFIRE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', Tags.Item.BASIC_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_basic_flame_material", conditionsFromTag(Tags.Item.BASIC_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.CAMPFIRE));
		//# Campfire (spirit) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_CAMPFIRE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', Tags.Item.SPIRIT_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_spirit_flame_material", conditionsFromTag(Tags.Item.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.SOUL_CAMPFIRE));
		//# Smoker #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMOKER)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Tags.Item.ALL_PLANKS)
				.pattern(" # ")
				.pattern("# #")
				.pattern("X#X")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.offerTo(exporter, idFromItem(Blocks.SMOKER));
		//endregion
		
		//region ## Workstation Recipes (crafting) ##
		//# Anvil #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.ANVIL)
				.input('#', Items.IRON_INGOT)
				.pattern("###")
				.pattern(" # ")
				.pattern("###")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.ANVIL));
		//# Brewing Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BREWING_STAND)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('/', Items.BLAZE_ROD)
				.input('X', Items.IRON_INGOT)
				.input('O', ModItems.CLEAR_GLASS_PANE)
				.pattern("OXO")
				.pattern("X/X")
				.pattern("###")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.offerTo(exporter, idFromItem(Blocks.BREWING_STAND));
		//# Cartography Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CARTOGRAPHY_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.PAPER)
				.input('@', Items.COMPASS)
				.pattern("X@X")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
				.offerTo(exporter, idFromItem(Blocks.CARTOGRAPHY_TABLE));
		//# Crafting Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("##")
				.pattern("XX")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, idFromItem(Blocks.CRAFTING_TABLE));
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
				.offerTo(exporter, idFromItem(Blocks.ENCHANTING_TABLE));
		//# Fletching Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.FLETCHING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.STRING)
				.input('@', Items.ARROW)
				.pattern("X@X")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
				.offerTo(exporter, idFromItem(Blocks.FLETCHING_TABLE));
		//# Grindstone #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.GRINDSTONE)
				.input('#', Tags.Item.ALL_LARGE_BRICKS)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("X#X")
				.pattern("X@X")
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, idFromItem(Blocks.GRINDSTONE));
		//# Lectern #
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.LECTERN)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.BOOK)
				.pattern(" X ")
				.pattern("###")
				.pattern(" # ")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, idFromItem(Blocks.LECTERN));
		//# Loom #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LOOM)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', Tags.Item.ALL_YARNBALLS)
				.pattern("#@#")
				.pattern("X@X")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(Blocks.LOOM));
		//# Sawmill #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.STONECUTTER)
				.input('#', Tags.Item.ALL_LARGE_BRICKS)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('I', Items.IRON_INGOT)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("XIX")
				.pattern("###")
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, idFromItem(Blocks.STONECUTTER));
		//# Smithing Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMITHING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.IRON_INGOT)
				.pattern("XXX")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.SMITHING_TABLE));
		//endregion
		
		//region ## Minecarts ##
		ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, Items.MINECART)
				.input('#', Items.IRON_INGOT)
				.input('-', ModItems.IRON_GRAM)
				.input('O', Items.SLIME_BALL) // Lubricant for wheels.
				.pattern("# #")
				.pattern("###")
				.pattern("-O-")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Items.MINECART));
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.IRON_NUGGET, 32,
				Items.MINECART, "_from_minecart_recycling", null); // TODO: Hide this recipe in the recipe book.
		offerFilledMinecartRecipe(exporter, Items.CHEST_MINECART, Blocks.CHEST);
		offerFilledMinecartRecipe(exporter, Items.FURNACE_MINECART, Blocks.FURNACE);
		offerFilledMinecartRecipe(exporter, Items.HOPPER_MINECART, Blocks.HOPPER);
		offerFilledMinecartRecipe(exporter, Items.TNT_MINECART, Blocks.TNT);
		//endregion
		
		//region ## Miscellaneous Decoration & Utility Recipes ##
		//# Beehive #
		offerLargeRowSandwichRecipe(exporter, RecipeCategory.MISC, Blocks.BEEHIVE, 1,
				Items.HONEYCOMB, Tags.Item.ALL_PLANKS, "has_any_plank", "", null);
		//# Cauldron #
		ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, Blocks.CAULDRON)
				.input('#', Items.IRON_INGOT)
				.pattern("# #")
				.pattern("# #")
				.pattern("###")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.CAULDRON));
		//# Chiseled Bookshelf #
		offerLargeRowSandwichRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_BOOKSHELF, 1,
				Items.STICK, Tags.Item.ALL_PLANKS, "has_any_plank", "", null);
		//# Conduit #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.CONDUIT,
				Items.HEART_OF_THE_SEA, Items.NAUTILUS_SHELL, "", null);
		//# Decorated Pot #
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.DECORATIONS, Blocks.DECORATED_POT,
				Items.BLAZE_POWDER, Items.BRICK, "_basic", null);
		// TODO: Make custom complex recipe type for the Decorated Pot, which uses a Blaze Powder Pile at the center of the shape.
		ComplexRecipeJsonBuilder.create(CraftingDecoratedPotRecipe::new).offerTo(exporter, "decorated_pot_dynamic");
		//# End Crystal #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.END_CRYSTAL)
				.input('#', ModItems.CLEAR_GLASS_PANE)
				.input('O', Items.ENDER_EYE)
				.input('-', Items.GHAST_TEAR)
				.pattern("-#-")
				.pattern("#O#")
				.pattern("-#-")
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
				.criterion(hasItem(Items.GHAST_TEAR), conditionsFromItem(Items.GHAST_TEAR))
				.offerTo(exporter, idFromItem(Items.END_CRYSTAL));
		//# End Rod #
		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.END_ROD)
				.input('#', Items.POPPED_CHORUS_FRUIT)
				.input('/', Items.BLAZE_ROD)
				.input('O', Items.CHORUS_FRUIT)
				.input('@', ModItems.FREEZE_POWDER_PILE)
				.pattern(" O ")
				.pattern("@/@")
				.pattern(" # ")
				.criterion(hasItem(Items.POPPED_CHORUS_FRUIT), conditionsFromItem(Items.POPPED_CHORUS_FRUIT))
				.offerTo(exporter, idFromItem(Blocks.END_ROD));
		//# Flower Pot #
		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.FLOWER_POT)
				.input('#', Items.BRICK)
				.input('O', Items.BLAZE_POWDER)
				.input('X', ModItems.DIRT_PILE)
				.pattern(" X ")
				.pattern("#O#")
				.pattern(" # ")
				.criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
				.offerTo(exporter, idFromItem(Blocks.FLOWER_POT));
		//# Hopper #
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.HOPPER)
				.input('#', Items.IRON_INGOT)
				.input('@', Items.REDSTONE)
				.pattern("# #")
				.pattern("#@#")
				.pattern(" # ")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.HOPPER));
		//# Item Frame (basic) #
		offerFourAndFourCheckeredAroundOneRecipe(exporter, RecipeCategory.DECORATIONS, Items.ITEM_FRAME,
				Items.LEATHER, Items.STICK, Items.STRING, "", "item_frames");
		//# Item Frame (Glow) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.DECORATIONS, Items.GLOW_ITEM_FRAME,
				Items.ITEM_FRAME, Items.GLOW_INK_SAC, "", "item_frames");
		//# Jukebox #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.JUKEBOX, 1,
				Items.DIAMOND, Tags.Item.ALL_PLANKS, "has_any_plank", "", null);
		//# Lightning Rod #
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.LIGHTNING_ROD)
				.input('#', Items.COPPER_INGOT)
				.input('@', Items.REDSTONE)
				.pattern("#")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.LIGHTNING_ROD));
		//# Lit Pumpkin (basic) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.JACK_O_LANTERN,
				Blocks.CARVED_PUMPKIN, Items.TORCH, "", null);
		//# Sea Lantern #
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.SEA_LANTERN)
				.input('#', Items.PRISMARINE_SHARD)
				.input('O', Items.PRISMARINE_CRYSTALS)
				.pattern("#O#")
				.pattern("OOO")
				.pattern("#O#")
				.criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
				.criterion(hasItem(Items.PRISMARINE_CRYSTALS), conditionsFromItem(Items.PRISMARINE_CRYSTALS))
				.offerTo(exporter, idFromItem(Items.SEA_LANTERN));
		//# Tonebox #
		offerEightAroundOneRecipe(exporter, RecipeCategory.REDSTONE, Blocks.NOTE_BLOCK, 1,
				Items.REDSTONE, Tags.Item.ALL_PLANKS, "has_any_plank", "", null);
		//endregion
		
		//endregion
		
		
		//region ### Joke & Unserious Recipes ###
		//## (J&U) Equipment ##
		//# Enchanted Cheese Wheel #
		BasicGridRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENCHANTED_CHEESE_WHEEL)
				.input(ModItems.CHEESE_WHEEL)
				.input(ModItems.MINIWIZARD)
				.criterion(hasItem(ModItems.CHEESE_WHEEL), conditionsFromItem(ModItems.CHEESE_WHEEL))
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.offerTo(exporter, idFromItem(ModItems.ENCHANTED_CHEESE_WHEEL));
		//# Nutrillarn Compass #
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, ModItems.NUTRILLARN_COMPASS,
				Items.ENDER_EYE, ModItems.NUTRILLARN_GRAM, "", null);
		//# Orb of Zot #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ORB_OF_ZOT)
				.input(Items.ENDER_EYE)
				.input(ModItems.BOWL_OF_STONE_SOUP)
				.input(ModItems.MINIWIZARD)
				.criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
				.criterion(hasItem(ModItems.BOWL_OF_STONE_SOUP), conditionsFromItem(ModItems.BOWL_OF_STONE_SOUP))
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.offerTo(exporter, idFromItem(ModItems.ORB_OF_ZOT));
		//# Standard Nutrillarn Equipment Set #
		offerMetalEquipmentRecipeSet(exporter, ModItems.NUTRILLARN_INGOT, ModItems.NUTRILLARN_GRAM, "nutrillarn",
				ModItems.NUTRILLARN_BOOT_PAIR, ModItems.NUTRILLARN_CHESTPLATE,
				ModItems.NUTRILLARN_HELMET, ModItems.NUTRILLARN_LEGGING_PAIR,
				ModItems.NUTRILLARN_HORSE_HARNESS,
				ModItems.NUTRILLARN_AXE, ModItems.NUTRILLARN_DAGGER, ModItems.NUTRILLARN_HATCHET,
				ModItems.NUTRILLARN_HOE, ModItems.NUTRILLARN_MALLET, ModItems.NUTRILLARN_PICKAXE,
				ModItems.NUTRILLARN_SHOVEL, ModItems.NUTRILLARN_SPEAR, ModItems.NUTRILLARN_SWORD);
		offerFourAndFourCheckeredAroundOneRecipe(exporter, RecipeCategory.TOOLS, ModItems.NUTRILLARN_JELLYBOOT_PAIR, 1,
				Items.LEATHER_BOOTS, ModItems.NUTRILLARN_INGOT, ModItems.CHERRY_JELLYBALL, "", null);
		//## (J&U) Food ##
		//# Bowl of Omnistew #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_OMNISTEW)
				.input(Items.BOWL)
				.input(ModItems.BOWL_OF_BEEF_STEW)
				.input(ModItems.BOWL_OF_BUGMEAT_STEW)
				.input(ModItems.BOWL_OF_CHICKEN_STEW)
				.input(ModItems.BOWL_OF_COD_STEW)
				.input(ModItems.BOWL_OF_MUTTON_STEW)
				.input(ModItems.BOWL_OF_PORK_STEW)
				.input(Items.RABBIT_STEW)
				.input(ModItems.BOWL_OF_SALMON_STEW)
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion(hasItem(ModItems.BOWL_OF_BEEF_STEW), conditionsFromItem(ModItems.BOWL_OF_BEEF_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_BUGMEAT_STEW), conditionsFromItem(ModItems.BOWL_OF_BUGMEAT_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_CHICKEN_STEW), conditionsFromItem(ModItems.BOWL_OF_CHICKEN_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_COD_STEW), conditionsFromItem(ModItems.BOWL_OF_COD_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_MUTTON_STEW), conditionsFromItem(ModItems.BOWL_OF_MUTTON_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_PORK_STEW), conditionsFromItem(ModItems.BOWL_OF_PORK_STEW))
				.criterion(hasItem(Items.RABBIT_STEW), conditionsFromItem(Items.RABBIT_STEW))
				.criterion(hasItem(ModItems.BOWL_OF_SALMON_STEW), conditionsFromItem(ModItems.BOWL_OF_SALMON_STEW))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_OMNISTEW));
		//# Bowl of Stone Soup #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_STONE_SOUP)
				.input('#', ModItems.STONE_PEBBLE)
				.input('X', Items.GLOWSTONE_DUST)
				.input('O', Items.REDSTONE)
				.input('@', ModItems.BOWL_OF_STEAMING_WATER)
				.pattern("###")
				.pattern("###")
				.pattern("X@O")
				.criterion(hasItem(ModItems.STONE_PEBBLE), conditionsFromItem(ModItems.STONE_PEBBLE))
				.criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(ModItems.BOWL_OF_STEAMING_WATER), conditionsFromItem(ModItems.BOWL_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_STONE_SOUP));
		
		//## (J&U) Miscellaneous ##
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
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.YELLOW_CHEESE_WEDGE, 6)
				.input('#', Items.LAVA_BUCKET)
				.input('O', ModItems.CHEESE_WHEEL)
				.input('X', Items.YELLOW_DYE)
				.input('@', Items.ENDER_EYE)
				.input('+', Items.GUNPOWDER)
				.pattern("XXX")
				.pattern("+O+")
				.pattern("@#@")
				.criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
				.criterion(hasItem(ModItems.CHEESE_WHEEL), conditionsFromItem(ModItems.CHEESE_WHEEL))
				.criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE))
				.criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, idFromItem(ModItems.YELLOW_CHEESE_WEDGE, "_from_cheese_wheel"));
		offerShapelessThreeIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLUE_CHEESE_WEDGE, 1,
				ModItems.YELLOW_CHEESE_WEDGE, Items.MAGMA_CREAM, Items.LAPIS_LAZULI, "", null);
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.BLUE_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.YELLOW_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		//# Covered & Grassy Blocks (placeholder for other production methods) #
		//# Crimson Mycelium Covered Netherrack Block #
		createEightAroundOneFormat(RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_NYLIUM, 1,
				Ingredient.ofItems(Items.CRIMSON_FUNGUS, Items.NETHER_WART),
				Ingredient.ofItems(Blocks.NETHERRACK))
				.group("covered_netherrack_blocks")
				.criterion(hasItem(Blocks.NETHERRACK), conditionsFromItem(Blocks.NETHERRACK))
				.criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
				.criterion(hasItem(Items.NETHER_WART), conditionsFromItem(Items.NETHER_WART))
				.offerTo(exporter, idFromItem(Blocks.CRIMSON_NYLIUM));
		//# Grassy Dirt Block #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.GRASS_BLOCK,
				Blocks.DIRT, Items.WHEAT_SEEDS, "", "covered_dirt_blocks");
		//# Mycelium Covered Dirt Block #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MYCELIUM, 1,
				Blocks.DIRT, Tags.Item.ALL_MUSHROOMS, "has_any_mushroom",
				"", "covered_dirt_blocks");
		//# Warped Mycelium Covered Netherrack Block #
		createEightAroundOneFormat(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_NYLIUM, 1,
				Ingredient.ofItems(Items.WARPED_FUNGUS, Items.NETHER_SPROUTS),
				Ingredient.ofItems(Blocks.NETHERRACK))
				.group("covered_netherrack_blocks")
				.criterion(hasItem(Blocks.NETHERRACK), conditionsFromItem(Blocks.NETHERRACK))
				.criterion(hasItem(Items.WARPED_FUNGUS), conditionsFromItem(Items.WARPED_FUNGUS))
				.criterion(hasItem(Items.NETHER_SPROUTS), conditionsFromItem(Items.NETHER_SPROUTS))
				.offerTo(exporter, idFromItem(Blocks.WARPED_NYLIUM));
		//# Nutrillarn (basic) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_NUTRILLARN_LUMP)
				.input(ModItems.CHERRY_JELLYBALL)
				.input(ModItems.MILKLEAF_PILE)
				.input(ModItems.CHULK_BERRY_BUNCH)
				.input(ModItems.STARCHCAP_MUSHROOM)
				.criterion(hasItem(ModItems.CHERRY_JELLYBALL), conditionsFromItem(ModItems.CHERRY_JELLYBALL))
				.criterion(hasItem(ModItems.MILKLEAF_PILE), conditionsFromItem(ModItems.MILKLEAF_PILE))
				.criterion(hasItem(ModItems.CHULK_BERRY_BUNCH), conditionsFromItem(ModItems.CHULK_BERRY_BUNCH))
				.criterion(hasItem(ModItems.STARCHCAP_MUSHROOM), conditionsFromItem(ModItems.STARCHCAP_MUSHROOM))
				.offerTo(exporter, idFromItem(ModItems.RAW_NUTRILLARN_LUMP));
		offerSmeltingAndBlastingForMetalRecipes(exporter,
				ModItems.NUTRILLARN_GRAM, ModItems.NUTRILLARN_INGOT, 100,
				ModItems.RAW_NUTRILLARN_NUGGET, ModItems.RAW_NUTRILLARN_LUMP, 0.375F);
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, ModItems.RAW_NUTRILLARN_LUMP, "_from_nugget", "nugget_merging",
				RecipeCategory.MISC, ModItems.RAW_NUTRILLARN_NUGGET, "_from_lump", "lump_splitting");
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, ModItems.NUTRILLARN_INGOT, "_from_gram", "gram_merging",
				RecipeCategory.MISC, ModItems.NUTRILLARN_GRAM, "_from_ingot", "ingot_splitting");
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_NUTRILLARN_BLOCK, 1,
				ModItems.RAW_NUTRILLARN_LUMP,"", null);
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFINED_NUTRILLARN_BLOCK, 1,
				ModItems.NUTRILLARN_INGOT,"", null);
		//# Smooth Stone Habitat Preservation #
		offerSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE,
				200, Blocks.STONE, 0.125F, null);
		offerOneToOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE_SLAB, 1,
				Blocks.SMOOTH_STONE, "", null);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_STONE_SLAB, 1, Blocks.SMOOTH_STONE);
		//# Smoothest Stones: 1 - Ultrasmooth Stone #
		offerSmeltingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ULTRASMOOTH_STONE, 400,
				Blocks.SMOOTH_STONE, 0.125F, null);
		//# Smoothest Stones: 2 - Hypersmooth Creamstone #
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HYPERSMOOTH_CREAMSTONE)
				.input('#', ModBlocks.ULTRASMOOTH_STONE)
				.input('X', Blocks.BLUE_ICE)
				.input('@', Items.MAGMA_CREAM)
				.pattern("#@")
				.pattern("@X")
				.criterion(hasItem(ModBlocks.ULTRASMOOTH_STONE), conditionsFromItem(ModBlocks.ULTRASMOOTH_STONE))
				.criterion(hasItem(Blocks.BLUE_ICE), conditionsFromItem(Blocks.BLUE_ICE))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.offerTo(exporter, idFromItem(ModBlocks.HYPERSMOOTH_CREAMSTONE));
		
		//region # Spawn Eggs #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.IRON_GOLEM_SPAWN_EGG)
				.input('@', ModItems.MINIWIZARD)
				.input('#', Items.IRON_BLOCK)
				.pattern(" @ ")
				.pattern("###")
				.pattern(" # ")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.offerTo(exporter, idFromItem(Items.IRON_GOLEM_SPAWN_EGG));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SHULKER_SPAWN_EGG)
				.input('@', ModItems.MINIWIZARD)
				.input('#', Items.SHULKER_SHELL)
				.input('O', Items.ENDER_PEARL)
				.pattern(" # ")
				.pattern("O@O")
				.pattern(" # ")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.offerTo(exporter, idFromItem(Items.SHULKER_SPAWN_EGG));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SNOW_GOLEM_SPAWN_EGG)
				.input('@', ModItems.MINIWIZARD)
				.input('#', Items.SNOW_BLOCK)
				.pattern("@")
				.pattern("#")
				.pattern("#")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.offerTo(exporter, idFromItem(Items.SNOW_GOLEM_SPAWN_EGG));
		//endregion
		
		//# Miscellaneous #
		// Cherry Jellyball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.FOOD, ModItems.CHERRY_JELLYBALL, 1,
				ModItems.CHERRY_BUNCH, ModItems.HONEYPOD, "", null);
		offerCompactingEightRecipe(exporter, RecipeCategory.FOOD, ModBlocks.CHERRY_JELLYBLOCK,
				ModItems.CHERRY_JELLYBALL, "", null);
		
		
		//region ## Miscellaneous Recipes ##
		
		//# Armor Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ARMOR_STAND)
				.input('#', Tags.Item.ALL_LARGE_BRICKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern(" X ")
				.pattern("XXX")
				.pattern(" # ")
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, idFromItem(Items.ARMOR_STAND));
		
		//# Arrow (basic) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.ARROW)
				.input('#', Tags.Item.ARROWHEAD_MATERIALS)
				.input('/', Items.STICK)
				.input('X', Items.FEATHER)
				.pattern("#")
				.pattern("/")
				.pattern("X")
				.criterion("has_arrowhead_material", conditionsFromTag(Tags.Item.ARROWHEAD_MATERIALS))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
				.offerTo(exporter, idFromItem(Items.ARROW));
		//# Arrow (spectral) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SPECTRAL_ARROW, 2)
				.input('#', ModItems.GOLD_GRAM)
				.input('/', Items.STICK)
				.input('X', Items.FEATHER)
				.input('O', Items.GLOWSTONE_DUST)
				.input('@', Items.GHAST_TEAR)
				.pattern("O#O")
				.pattern("/@/")
				.pattern("XOX")
				.criterion(hasItem(ModItems.GOLD_GRAM), conditionsFromItem(ModItems.GOLD_GRAM))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
				.criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
				.criterion(hasItem(Items.GHAST_TEAR), conditionsFromItem(Items.GHAST_TEAR))
				.offerTo(exporter, idFromItem(Items.SPECTRAL_ARROW));
		
		//# Balls #
		// (balls) Cobweb Ball
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, ModItems.COBWEB_BALL,
				Items.GUNPOWDER, ModItems.SILK_WAD, "", null);
		// (balls) Magma Cream Ball
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_CREAM, 2)
				.input(Items.BLAZE_ROD).input(Items.SLIME_BALL)
				.input(Items.SLIME_BALL).input(ModItems.SULPHUR_LUMP)
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.offerTo(exporter, idFromItem(Items.MAGMA_CREAM));
		// (balls) Yarnballs (and String)
		offerYarnballDyingRecipeSet(exporter);
		offerDoubleRowRecipe(exporter,
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1, Items.STRING, "_from_string", null);
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 3,
				Tags.Item.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball", null);
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 1,
				ModItems.SILK_WAD, ModItems.SILK_WAD, "_from_silk", null);
		// TODO: Add Silk Wads from Spider Egg upon implementation.
		
		//# Banner Patterns #
		offerBannerPatternRecipe(exporter, Items.CREEPER_BANNER_PATTERN, Items.CREEPER_HEAD);
		offerBannerPatternRecipe(exporter, Items.FLOWER_BANNER_PATTERN, Items.OXEYE_DAISY);
		offerBannerPatternRecipe(exporter, Items.GLOBE_BANNER_PATTERN, ModItems.MINIWIZARD);
		offerBannerPatternRecipe(exporter, Items.MOJANG_BANNER_PATTERN, Items.ENCHANTED_GOLDEN_APPLE);
		offerBannerPatternRecipe(exporter, Items.PIGLIN_BANNER_PATTERN, Items.PIGLIN_HEAD);
		//TODO: Perhaps separate patterns for ordinary and wither skulls?
		// - (VMc only uses the wither skull for this recipe)
		offerBannerPatternRecipe(exporter, Items.SKULL_BANNER_PATTERN,
				Items.SKELETON_SKULL, Items.WITHER_SKELETON_SKULL);
		//endregion
		
		
		//region ## Recipes with Color Variants ##
		//# Banners #
		offerBannerRecipe(exporter, Blocks.BLACK_BANNER, ModItems.BLACK_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.BLUE_BANNER, ModItems.BLUE_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.BROWN_BANNER, ModItems.BROWN_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.CYAN_BANNER, ModItems.CYAN_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.GRAY_BANNER, ModItems.GRAY_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.GREEN_BANNER, ModItems.GREEN_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.LIGHT_BLUE_BANNER, ModItems.LIGHT_BLUE_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.LIGHT_GRAY_BANNER, ModItems.LIGHT_GRAY_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.LIME_BANNER, ModItems.LIME_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.MAGENTA_BANNER, ModItems.MAGENTA_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.ORANGE_BANNER, ModItems.ORANGE_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.PINK_BANNER, ModItems.PINK_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.PURPLE_BANNER, ModItems.PURPLE_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.RED_BANNER, ModItems.RED_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.WHITE_BANNER, ModItems.WHITE_YARN_ROLL);
		offerBannerRecipe(exporter, Blocks.YELLOW_BANNER, ModItems.YELLOW_YARN_ROLL);
		
		//# Beds #
		// Pigmented
		offerBedOfPigmentRecipe(exporter, Blocks.BLACK_BED, ModItems.BLACK_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.BLUE_BED, ModItems.BLUE_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.BROWN_BED, ModItems.BROWN_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.CYAN_BED, ModItems.CYAN_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.GRAY_BED, ModItems.GRAY_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.GREEN_BED, ModItems.GREEN_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIGHT_BLUE_BED, ModItems.LIGHT_BLUE_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIGHT_GRAY_BED, ModItems.LIGHT_GRAY_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.LIME_BED, ModItems.LIME_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.MAGENTA_BED, ModItems.MAGENTA_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.ORANGE_BED, ModItems.ORANGE_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.PINK_BED, ModItems.PINK_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.PURPLE_BED, ModItems.PURPLE_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.RED_BED, ModItems.RED_YARN_ROLL, "", "beds");
		offerBedOfPigmentRecipe(exporter, Blocks.YELLOW_BED, ModItems.YELLOW_YARN_ROLL, "", "beds");
		// White
		offerBedOfWhiteRecipe(exporter, Blocks.WHITE_BED, "", "beds");
		
		//# Candle (basic) #
		offerCandleRecipe(exporter, "");
		//# Candle (pigmented) #
		offerCandleOfPigmentRecipe(exporter, Items.BLACK_CANDLE, Items.BLACK_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.BLUE_CANDLE, Items.BLUE_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.BROWN_CANDLE, Items.BROWN_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.CYAN_CANDLE, Items.CYAN_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.GRAY_CANDLE, Items.GRAY_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.GREEN_CANDLE, Items.GREEN_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.LIGHT_BLUE_CANDLE, Items.LIGHT_BLUE_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.LIGHT_GRAY_CANDLE, Items.LIGHT_GRAY_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.LIME_CANDLE, Items.LIME_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.MAGENTA_CANDLE, Items.MAGENTA_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.ORANGE_CANDLE, Items.ORANGE_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.PINK_CANDLE, Items.PINK_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.PURPLE_CANDLE, Items.PURPLE_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.RED_CANDLE, Items.RED_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.WHITE_CANDLE, Items.WHITE_DYE);
		offerCandleOfPigmentRecipe(exporter, Items.YELLOW_CANDLE, Items.YELLOW_DYE);
		
		//# Concrete Powder #
		offerConcretePowderBlockRecipe(exporter, Blocks.BLACK_CONCRETE_POWDER, Items.BLACK_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.BLUE_CONCRETE_POWDER, Items.BLUE_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.BROWN_CONCRETE_POWDER, Items.BROWN_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.CYAN_CONCRETE_POWDER, Items.CYAN_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.GRAY_CONCRETE_POWDER, Items.GRAY_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.GREEN_CONCRETE_POWDER, Items.GREEN_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.LIME_CONCRETE_POWDER, Items.LIME_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.ORANGE_CONCRETE_POWDER, Items.ORANGE_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.PINK_CONCRETE_POWDER, Items.PINK_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.PURPLE_CONCRETE_POWDER, Items.PURPLE_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.RED_CONCRETE_POWDER, Items.RED_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.WHITE_CONCRETE_POWDER, Items.WHITE_DYE);
		offerConcretePowderBlockRecipe(exporter, Blocks.YELLOW_CONCRETE_POWDER, Items.YELLOW_DYE);
		
		//# Dye Blobs #
		offerDyeBlobRecipeSet(exporter,
				Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE,
				Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE,
				Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE,
				Items.PURPLE_DYE, Items.RED_DYE, Items.WHITE_DYE, Items.YELLOW_DYE,
				"black_dye_blob", "blue_dye_blob",
				"brown_dye_blob", "cyan_dye_blob",
				"gray_dye_blob", "green_dye_blob",
				"light_blue_dye_blob", "light_gray_dye_blob",
				"lime_dye_blob", "magenta_dye_blob",
				"orange_dye_blob", "pink_dye_blob",
				"purple_dye_blob", "red_dye_blob",
				"white_dye_blob", "yellow_dye_blob");
		
		//# Glass Blocks & Panes #
		// (glass) Clear Block
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, 1,
				ModItems.CLEAR_GLASS_PANE, "", null);
		// (glass) Clear Pane
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.CLEAR_GLASS_PANE,
				200, ModItems.GLASS_SHARD, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.CLEAR_GLASS_PANE,
				100, Items.GLASS_BOTTLE, 0.0625F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.CLEAR_GLASS_PANE,
				100, Tags.Item.ALL_STAINED_GLASS_PANES, "has_any_stained_glass_pane",
				"_from_stained_glass_pane", 0.0625F);
		// (glass) Stained Blocks
		offerStainedGlassBlockRecipe(exporter, Blocks.BLACK_STAINED_GLASS, ModItems.BLACK_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.BLUE_STAINED_GLASS, ModItems.BLUE_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.BROWN_STAINED_GLASS, ModItems.BROWN_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.CYAN_STAINED_GLASS, ModItems.CYAN_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.GRAY_STAINED_GLASS, ModItems.GRAY_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.GREEN_STAINED_GLASS, ModItems.GREEN_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.LIGHT_BLUE_STAINED_GLASS, ModItems.LIGHT_BLUE_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.LIGHT_GRAY_STAINED_GLASS, ModItems.LIGHT_GRAY_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.LIME_STAINED_GLASS, ModItems.LIME_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.MAGENTA_STAINED_GLASS, ModItems.MAGENTA_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.ORANGE_STAINED_GLASS, ModItems.ORANGE_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.PINK_STAINED_GLASS, ModItems.PINK_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.PURPLE_STAINED_GLASS, ModItems.PURPLE_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.RED_STAINED_GLASS, ModItems.RED_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.WHITE_STAINED_GLASS, ModItems.WHITE_STAINED_GLASS_PANE);
		offerStainedGlassBlockRecipe(exporter, Blocks.YELLOW_STAINED_GLASS, ModItems.YELLOW_STAINED_GLASS_PANE);
		// (glass) Stained Panes
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.PURPLE_STAINED_GLASS_PANE,
				200, Items.AMETHYST_SHARD, 0.125F);
		offerStainedGlassPaneRecipe(exporter, ModItems.BLACK_STAINED_GLASS_PANE, Items.BLACK_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.BLUE_STAINED_GLASS_PANE, Items.BLUE_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.BROWN_STAINED_GLASS_PANE, Items.BROWN_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.CYAN_STAINED_GLASS_PANE, Items.CYAN_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.GRAY_STAINED_GLASS_PANE, Items.GRAY_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.GREEN_STAINED_GLASS_PANE, Items.GREEN_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.LIGHT_BLUE_STAINED_GLASS_PANE, Items.LIGHT_BLUE_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.LIGHT_GRAY_STAINED_GLASS_PANE, Items.LIGHT_GRAY_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.LIME_STAINED_GLASS_PANE, Items.LIME_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.MAGENTA_STAINED_GLASS_PANE, Items.MAGENTA_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.ORANGE_STAINED_GLASS_PANE, Items.ORANGE_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.PINK_STAINED_GLASS_PANE, Items.PINK_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.PURPLE_STAINED_GLASS_PANE, Items.PURPLE_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.RED_STAINED_GLASS_PANE, Items.RED_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.WHITE_STAINED_GLASS_PANE, Items.WHITE_DYE);
		offerStainedGlassPaneRecipe(exporter, ModItems.YELLOW_STAINED_GLASS_PANE, Items.YELLOW_DYE);
		// (glass) Tinted Block
		offerCheckeredRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.TINTED_GLASS, 1,
				ModItems.CLEAR_GLASS_PANE, Items.AMETHYST_SHARD, "", null);
		// (glass) Reinforced Stained Glass Block
		ComplexRecipeJsonBuilder.create(ReinforcedStainedGlassBlock::new).offerTo(exporter, "reinforced_stained_glass_block");
		
		//# Terracotta (basic) #
		//TODO: Use Clay Ball & Terracotta Chunk instead of blocks upon implementation of terracotta chunks.
		offerBlastingAndSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA,
				50, Blocks.CLAY, 0.125F, null);
		//# Terracotta (glazed) #
		//TODO: Use glazed and stained terracotta chunks instead of blocks upon implementation.
		offerGlazedTerracottaRecipeSet(exporter, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLACK_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BLUE_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.BROWN_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.CYAN_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GRAY_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.GREEN_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.LIME_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.PINK_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.PURPLE_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.RED_GLAZED_TERRACOTTA, Blocks.RED_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.WHITE_TERRACOTTA);
		offerGlazedTerracottaRecipeSet(exporter, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.YELLOW_TERRACOTTA);
		//# Terracotta (stained) #
		//TODO: Use stained terracotta chunks instead of blocks upon implementation.
		offerStainedTerracottaRecipe(exporter, Blocks.BLACK_TERRACOTTA, Items.BLACK_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.BLUE_TERRACOTTA, Items.BLUE_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.BROWN_TERRACOTTA, Items.BROWN_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.CYAN_TERRACOTTA, Items.CYAN_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.GRAY_TERRACOTTA, Items.GRAY_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.GREEN_TERRACOTTA, Items.GREEN_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.LIGHT_BLUE_TERRACOTTA, Items.LIGHT_BLUE_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.LIGHT_GRAY_TERRACOTTA, Items.LIGHT_GRAY_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.LIME_TERRACOTTA, Items.LIME_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.MAGENTA_TERRACOTTA, Items.MAGENTA_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.ORANGE_TERRACOTTA, Items.ORANGE_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.PINK_TERRACOTTA, Items.PINK_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.PURPLE_TERRACOTTA, Items.PURPLE_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.RED_TERRACOTTA, Items.RED_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.WHITE_TERRACOTTA, Items.WHITE_DYE);
		offerStainedTerracottaRecipe(exporter, Blocks.YELLOW_TERRACOTTA, Items.YELLOW_DYE);
		//endregion
		
		
		//# Beacon #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BEACON)
				.input('#', ModItems.OBSIDIAN_SHARD)
				.input('@', Items.NETHER_STAR)
				.input('X', ModItems.CLEAR_GLASS_PANE)
				.input('O', Items.DIAMOND) // TODO: Replace with celestine upon implementation.
				.pattern("XXX")
				.pattern("X@X")
				.pattern("#O#")
				.criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
				.offerTo(exporter, idFromItem(Blocks.BEACON));
		
		//# Book (ordinary) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BOOK)
				.input(Items.LEATHER)
				.input(Items.PAPER, 8)
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.offerTo(exporter, idFromItem(Items.BOOK));
		//# Book (writable) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WRITABLE_BOOK)
				.input(Items.BOOK)
				.input(Items.INK_SAC)
				.input(Items.FEATHER)
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, idFromItem(Items.WRITABLE_BOOK));
		
		//# Bookshelf #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BOOKSHELF)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.BOOK)
				.pattern("###")
				.pattern("XXX")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS)) // TODO: Wood type specific "Packed Bookshelves"?
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, idFromItem(Blocks.BOOKSHELF));
		
		//# Chain #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CHAIN)
				.input('-', ModItems.IRON_GRAM)
				.pattern(" - ")
				.pattern("- -")
				.pattern(" - ")
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Blocks.CHAIN, "_single"));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CHAIN, 2)
				.input('#', Items.IRON_INGOT)
				.input('-', ModItems.IRON_GRAM)
				.pattern("-")
				.pattern("#")
				.pattern("-")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.CHAIN, "_double"));
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.IRON_GRAM, 4,
				Blocks.CHAIN, "_from_chain", "iron_recycling_to_gram");
		
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
				.offerTo(exporter, idFromItem(ModItems.CHEESE_WHEEL));
		// NOTE: Doesn't work; bucket gets consumed, not leaving behind an Empty Bucket:
//		offerSmeltingRecipe(exporter,
//				RecipeCategory.FOOD, ModItems.CHEESE_WHEEL, 400,
//				Items.MILK_BUCKET, 0.125F, null);
		
		//# Clay #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.CLAY_BALL, 2, Tags.Item.ALL_GLASSY_SAND_PILES,
				"has_any_glassy_sand_pile", Items.SLIME_BALL, "", null);
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, 1, Items.CLAY_BALL, "", null);
		
		//# Compost Bin #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COMPOSTER)
				.input('#', Tags.Item.ALL_PLANKS)
				.pattern("# #")
				.pattern("# #")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.offerTo(exporter, idFromItem(Blocks.COMPOSTER));
		
		//# Dry Grass Tuft #
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, ModItems.DRY_GRASS_TUFT,
				25, ModItems.LIVE_GRASS_TUFT, 0.0625F, "dry_grass_tuft");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, ModItems.DRY_GRASS_TUFT,
				25, Items.SEAGRASS, 0.0625F, "dry_grass_tuft");
		
		//# Dynamite #
		// (dynamite) Block
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.REDSTONE, Blocks.TNT,
				"", "dynamite_packing",
				RecipeCategory.MISC, ModItems.DYNAMITE_BUNDLE,
				"_from_block", "dynamite_packing");
		// (dynamite) Bundle
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.DYNAMITE_BUNDLE,
				"_from_stick", "dynamite_packing",
				RecipeCategory.MISC, ModItems.DYNAMITE_STICK,
				"_from_bundle", "dynamite_packing");
		// (dynamite) Stick
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(Tags.Item.ALL_YARNBALLS)
				.input(Items.PAPER).input(Items.PAPER)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, idFromItem(ModItems.DYNAMITE_STICK, "_from_paper"));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(Tags.Item.ALL_YARNBALLS)
				.input(Blocks.BAMBOO)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO)) // TODO: Replace with Dry Bamboo Stick upon implementation.
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, idFromItem(ModItems.DYNAMITE_STICK, "_from_bamboo"));
		
		
		//region ## Elemental Blocks ##
		//# Bone #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BONE_BLOCK, 1, Items.BONE, "", null);
		//# Dementhum Scrap Block #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.ANCIENT_DEBRIS,
				Items.NETHERITE_INGOT, Items.NETHERITE_SCRAP, "", null);
		//# Obsidian #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, 1, ModItems.OBSIDIAN_SHARD, "", null);
		//# Wart - Crimson #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.NETHER_WART_BLOCK,
				Items.CRIMSON_ROOTS, Items.NETHER_WART, "", null);
		//# Wart - Warped #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_WART_BLOCK,
				Items.WARPED_ROOTS, Items.NETHER_SPROUTS, "", null);
		//endregion
		
		
		//# Ender Eye #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ENDER_EYE)
				.input(Items.ENDER_PEARL)
				.input(Items.MAGMA_CREAM).input(Items.MAGMA_CREAM)
				.input(Items.REDSTONE)
				.criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Items.ENDER_EYE));
		
		//# Fermented Spider Eye #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.BREWING, Items.FERMENTED_SPIDER_EYE)
				.input(Items.SPIDER_EYE)
				.input(Blocks.BROWN_MUSHROOM)
				.input(Items.SUGAR)
				.criterion(hasItem(Items.SPIDER_EYE), conditionsFromItem(Items.SPIDER_EYE))
				.offerTo(exporter, idFromItem(Items.FERMENTED_SPIDER_EYE));
		
		//# Fire Charge #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.FIRE_CHARGE, 3)
				.input(Items.GUNPOWDER)
				.input(Items.BLAZE_POWDER)
				.input(Ingredient.ofItems(Items.COAL, Items.CHARCOAL))
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.offerTo(exporter, idFromItem(Items.FIRE_CHARGE));
		
		//# Firework Rocket | Firework Star #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.FIREWORK_ROCKET, 1,
				ModItems.DYNAMITE_STICK, Items.PAPER, "_basic", null);
		//TODO: Add custom complex recipe which uses Dynamite Stick item.
		// - Only output 1 Firework Rocket.
		// - Perhaps remove the basic recipe? (seemingly superfluous)
		//  - The basic recipe probably exists exclusively to demonstrate the craftability of rockets within the recipe book.
		ComplexRecipeJsonBuilder.create(FireworkRocketRecipe::new).offerTo(exporter, "firework_rocket");
		ComplexRecipeJsonBuilder.create(FireworkStarRecipe::new).offerTo(exporter, "firework_star");
		ComplexRecipeJsonBuilder.create(FireworkStarFadeRecipe::new).offerTo(exporter, "firework_star_fade");
		
		//# Glass Shard #
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, ModItems.GLASS_SHARD,
				200, Tags.Item.ALL_GLASSY_SAND_PILES, "has_glassy_sand_pile",
				"_from_glassy_sand_pile", 0.125F);
		// (glass shard) Bottle recycling
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GLASS_SHARD, 1, Items.GLASS_BOTTLE, "_from_bottle", null);
		
		//# Golden Foods #
		// Glistering Melon Slice
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.FOOD,Items.GLISTERING_MELON_SLICE,
				Items.MELON_SLICE, ModItems.GOLD_GRAM, "", null);
		// Golden Apple
		offerEightAroundOneRecipe(exporter, RecipeCategory.FOOD,Items.GOLDEN_APPLE,
				Items.APPLE, ModItems.GOLD_GRAM, "", null);
		// Golden Carrot
		offerEightAroundOneRecipe(exporter, RecipeCategory.FOOD,Items.GOLDEN_CARROT,
				Items.CARROT, ModItems.GOLD_GRAM, "", null);
		
		//# Gravel, Sands, & Soils #
		// (GS&S) Coarse Dirt
		offerCompactingFourAndFourRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.COARSE_DIRT, 1,
				ModItems.DIRT_PILE, ModItems.GRAVEL_PILE, "", null);
		// (GS&S) Dirt
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT, 1,
				ModItems.DIRT_PILE, "", null);
		// (GS&S) Gravel
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GRAVEL_PILE, 1, Tags.Item.ALL_COBBLESTONES,
				"has_any_cobblestone", "_from_cobblestone" , null);
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRAVEL, 1,
				ModItems.GRAVEL_PILE, "", null);
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.GRAVEL_PILE, "_from_stone_pebble", null,
				RecipeCategory.MISC, ModItems.STONE_PEBBLE, "_from_gravel_pile", null);
		// (GS&S) Sand (feldsand)
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.SAND, 1,
				ModItems.FELDSAND_PILE, "", "sand_blocks");
		// (GS&S) Sand (ferrosand)
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SAND, 1,
				ModItems.FERROSAND_PILE, "", "sand_blocks");
		// (GS&S) Sand (skorsand)
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.SKORSAND_BLOCK, 1,
				ModItems.SKORSAND_PILE, "", "sand_blocks");
		
		//# Ice #
		// (ice) Packed
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE, 1,
				Blocks.ICE, "", null);
		// (ice) Blue
		offerShapelessFourIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BLUE_ICE, 1,
				Blocks.PACKED_ICE, Blocks.PACKED_ICE, Blocks.PACKED_ICE, Blocks.LAPIS_BLOCK,
				"", null);
		
		//# Metal Door & Hatch #
		// TODO: Enable copper door and hatch recipes after updating MC version.
//		offerDoorAndHatchRecipeSet(exporter, Blocks.COPPER_DOOR, Blocks.COPPER_TRAPDOOR, Items.COPPER_INGOT,
//				"", "", "metal_doors", "metal_hatches");
		offerDoorAndHatchRecipeSet(exporter, Blocks.IRON_DOOR, Blocks.IRON_TRAPDOOR, Items.IRON_INGOT,
				"", "", "metal_doors", "metal_hatches");
		
		//# Lantern #
		// (lantern) Basic
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LANTERN)
				.input('-', ModItems.IRON_GRAM)
				.input('X', Items.CHAIN)
				.input('O', ModItems.CLEAR_GLASS_PANE)
				.input('@', Items.GLOWSTONE_DUST)
				.pattern("-X-")
				.pattern("O@O")
				.pattern("---")
				.criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
				.offerTo(exporter, idFromItem(Blocks.LANTERN));
		// (lantern) Spirit
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_LANTERN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.input('O', ModItems.CLEAR_GLASS_PANE)
				.input('@', Tags.Item.SPIRIT_FLAME_MATERIALS)
				.pattern(" X ")
				.pattern("O@O")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.criterion("has_spirit_flame_material", conditionsFromTag(Tags.Item.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.SOUL_LANTERN));
		
		//# Ladders #
		// (ladders) Wooden
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.LADDER)
				.input('#', Items.STICK)
				.input('@', Items.STRING)
				.pattern("#@#")
				.pattern("###")
				.pattern("#@#")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(Blocks.LADDER));
		// (ladders) Brass
		// (ladders) Copper
		// (ladders) Eiduril
		// (ladders) Gold
		// (ladders) Iron
		// (ladders) Netherite
		
		//# Leash #
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.LEAD)
				.input('#', Ingredient.fromTag(Tags.Item.ALL_YARNBALLS))
				.input('X', Items.SLIME_BALL)
				.pattern("## ")
				.pattern("#X ")
				.pattern("  #")
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.offerTo(exporter, idFromItem(Items.LEAD));
		
		//# Leather #
		offerSmallSquareRecipe(exporter, RecipeCategory.MISC, Items.LEATHER, 1,
				Items.RABBIT_HIDE, "_from_rodent_hide", null);
		offerSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, Items.LEATHER,
				400, Items.ROTTEN_FLESH, 0.125F);
		offerSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, Items.LEATHER,
				400, ModItems.WARPED_FLESH_CHUNK, 0.125F);
		
		//# Lodestone #
		offerFourAndFourCheckeredAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.LODESTONE, 1,
				Items.NETHERITE_INGOT, Tags.Item.ALL_LARGE_BRICKS, "has_any_large_brick", Items.BLAZE_POWDER, "", null);
		
		//# Lumithite #
		// (lumithite) Chunk
		// (lumithite) Powder Pile
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, Items.GLOWSTONE_DUST,
				400, Items.GLOW_BERRIES, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, Items.GLOWSTONE_DUST,
				200, Items.SPECTRAL_ARROW, 0.125F);
		
		//# Magma Block #
		offerCheckeredRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MAGMA_BLOCK, 1,
				Items.MAGMA_CREAM, Tags.Item.ALL_COBBLESTONES, "has_any_cobblestone",
				"", null);
		
		//# Melon #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.MELON,
				Items.SUGAR, Items.MELON_SLICE,"", "");
		
		//# Metal (brass) #
		offerStandardMetalRecipeSet(exporter, ModItems.BRASS_GRAM, ModItems.BRASS_INGOT,
				ModItems.RAW_BRASS_LUMP, ModItems.RAW_BRASS_NUGGET, 100, 0.375F,
				ModBlocks.RAW_BRASS_BLOCK, ModBlocks.REFINED_BRASS_BLOCK);
		//# Metal (copper) #
		offerStandardMetalRecipeSet(exporter, ModItems.COPPER_GRAM, Items.COPPER_INGOT,
				Items.RAW_COPPER, ModItems.RAW_COPPER_NUGGET, 100, 0.25F,
				Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK);
		//region Extra Copper Block Recipes
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_COPPER, 1, Blocks.COPPER_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CUT_COPPER, 1, Blocks.COPPER_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CUT_COPPER_SLAB, 2, Blocks.COPPER_BLOCK);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CUT_COPPER_SLAB, 2, Blocks.CUT_COPPER);
		offerSlabBlockOfSmallShapeRecipe(exporter, Blocks.CUT_COPPER_SLAB, Items.COPPER_INGOT, "", null);
		offerStairBlockOfLargeShapeRecipe(exporter, Blocks.CUT_COPPER_STAIRS, Items.COPPER_INGOT, "", null);
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COPPER_GRATE)
				.input('#', Items.COPPER_INGOT)
				.pattern("# #")
				.pattern(" # ")
				.pattern("# #")
				.criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
				.offerTo(exporter, idFromItem(Blocks.COPPER_GRATE));
		//endregion
		//# Metal (eiduril) #
		offerStandardMetalRecipeSet(exporter, ModItems.EIDURIL_GRAM, ModItems.EIDURIL_INGOT,
				ModItems.RAW_EIDURIL_LUMP, ModItems.RAW_EIDURIL_NUGGET, 200, 0.5F,
				ModBlocks.RAW_EIDURIL_BLOCK, ModBlocks.REFINED_EIDURIL_BLOCK);
		//# Metal (gold) #
		offerStandardMetalRecipeSet(exporter, ModItems.GOLD_GRAM, Items.GOLD_INGOT,
				Items.RAW_GOLD, Items.GOLD_NUGGET, 100, 0.25F,
				Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK);
		//# Metal (iron) #
		offerStandardMetalRecipeSet(exporter, ModItems.IRON_GRAM, Items.IRON_INGOT,
				Items.RAW_IRON, Items.IRON_NUGGET, 100, 0.25F,
				Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK);
		// Metal Production (brass)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_BRASS_LUMP, 1)
				.input(ModItems.COPPER_GRAM).input(Items.BLAZE_POWDER)
				.input(ModItems.COPPER_GRAM).input(Items.BLAZE_POWDER)
				.input(ModItems.IRON_GRAM)
				.input(Items.BLAZE_POWDER).input(ModItems.COPPER_GRAM)
				.input(Items.BLAZE_POWDER).input(ModItems.COPPER_GRAM)
				.criterion(hasItem(ModItems.COPPER_GRAM), conditionsFromItem(ModItems.COPPER_GRAM))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.offerTo(exporter, idFromItem(ModItems.RAW_BRASS_LUMP));
		// Metal Production (eiduril)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_EIDURIL_LUMP, 1)
				.input(Items.DIAMOND).input(ModItems.COPPER_GRAM).input(Items.LAPIS_LAZULI)
				.input(ModItems.COPPER_GRAM).input(ModItems.COPPER_GRAM).input(ModItems.COPPER_GRAM)
				.input(Items.LAPIS_LAZULI).input(ModItems.COPPER_GRAM).input(Items.REDSTONE)
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.criterion(hasItem(ModItems.COPPER_GRAM), conditionsFromItem(ModItems.COPPER_GRAM))
				.criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(ModItems.RAW_EIDURIL_LUMP));
		
		//# Metal & Wooden Panes #
		// (M&WP) Metal (brass)
		// (M&WP) Metal (copper)
		// (M&WP) Metal (dementhum)
		SmithingTransformRecipeJsonBuilder.create(
						Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
						Ingredient.ofItems(Items.IRON_INGOT), // Base item
						Ingredient.ofItems(ModItems.INFERNOCOAL_LUMP), // Addition item
						RecipeCategory.MISC, Items.NETHERITE_INGOT
				)
				.criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
				.offerTo(exporter, idFromItem(Items.NETHERITE_INGOT, "_smithing"));
		// (M&WP) Metal (eiduril)
		// (M&WP) Metal (gold)
		// (M&WP) Metal (iron)
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.IRON_BARS, 1)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X#X")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Blocks.IRON_BARS));
		// (M&WP) Wooden
		
		//# Miniwizard #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MINIWIZARD, 2)
				.input('#', ModItems.MINIWIZARD)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.input('X', ModItems.WARPED_FLESH_CHUNK)
				.input('@', Items.ENCHANTED_GOLDEN_APPLE)
				.pattern("O@O")
				.pattern("X#X")
				.pattern("OXO")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(ModItems.WARPED_FLESH_CHUNK), conditionsFromItem(ModItems.WARPED_FLESH_CHUNK))
				.criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE), conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
				.offerTo(exporter, idFromItem(ModItems.MINIWIZARD, "_replication"));
		
		//# Miscellaneous Redstone Devices #
		// (MRD) Calibrated Skulkroot Sensor
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.CALIBRATED_SCULK_SENSOR)
				.input('X', Items.AMETHYST_SHARD)
				.input('@', Blocks.SCULK_SENSOR)
				.input('O', Items.REDSTONE)
				.pattern(" X ")
				.pattern("X@X")
				.pattern(" O ")
				.criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
				.criterion(hasItem(Blocks.SCULK_SENSOR), conditionsFromItem(Blocks.SCULK_SENSOR))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.CALIBRATED_SCULK_SENSOR));
		// (MRD) Copper Bulb
		// TODO: Replace glowstone block in recipe with Lumithite Chunk.
		offerFourAndFourCheckeredAroundOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.COPPER_BULB, 1,
				Blocks.GLOWSTONE, Items.REDSTONE, Items.COPPER_INGOT, "", null);
		// (MRD) Daylight Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
				.input('#', ModItems.CLEAR_GLASS_PANE)
				.input('/', Tags.Item.ALL_PLANKS)
				.input('X', Items.QUARTZ)
				.input('@', Items.REDSTONE)
				.pattern("###")
				.pattern("XXX")
				.pattern("/@/")
				.criterion(hasItem(ModItems.CLEAR_GLASS_PANE), conditionsFromItem(ModItems.CLEAR_GLASS_PANE))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.DAYLIGHT_DETECTOR));
		// (MRD) Dispenser
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DISPENSER)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Items.CROSSBOW)
				.input('@', Items.REDSTONE)
				.pattern("###")
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.DISPENSER));
		// (MRD) Dropper
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DROPPER)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Items.BOW)
				.input('@', Items.REDSTONE)
				.pattern("###")
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.DROPPER));
		// (MRD) Lever
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.LEVER)
				.input('|', Items.STICK)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('@', Items.REDSTONE)
				.pattern("|")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.LEVER));
		// (MRD) Observer
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.OBSERVER)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Items.QUARTZ)
				.input('@', Items.REDSTONE)
				.input('O', Items.SPIDER_EYE)
				.group("pistons")
				.pattern("###")
				.pattern("@OX")
				.pattern("###")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.SPIDER_EYE), conditionsFromItem(Items.SPIDER_EYE))
				.offerTo(exporter, idFromItem(Blocks.OBSERVER));
		// (MRD) Piston
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.PISTON)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('@', Items.REDSTONE)
				.input('O', Items.IRON_INGOT)
				.group("pistons")
				.pattern("XXX")
				.pattern("#O#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.PISTON));
		offerTwoIntoOneRecipe(exporter, RecipeCategory.REDSTONE, Blocks.STICKY_PISTON,
				Blocks.PISTON, Items.SLIME_BALL, "", "pistons");
		// (MRD) Redstone Lamp ("Iron Bulb")
		// TODO: Replace glowstone block in recipe with Lumithite Chunk.
		offerFourAndFourCheckeredAroundOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.REDSTONE_LAMP, 1,
				Blocks.GLOWSTONE, Items.REDSTONE, Items.IRON_INGOT, "", null);
		// (MRD) Redstone Signal Comparator
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COMPARATOR)
				.input('#', Tags.Item.ALL_LARGE_BRICKS)
				.input('/', Blocks.REDSTONE_TORCH)
				.input('O', Items.REDSTONE)
				.input('X', Items.QUARTZ)
				.pattern(" / ")
				.pattern("/X/")
				.pattern("#O#")
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.offerTo(exporter, idFromItem(Blocks.COMPARATOR));
		// (MRD) Redstone Signal Repeater
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.REPEATER)
				.input('#', Tags.Item.ALL_LARGE_BRICKS)
				.input('/', Blocks.REDSTONE_TORCH)
				.input('O', Items.REDSTONE)
				.pattern("/O/")
				.pattern("#O#")
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.REPEATER));
		// (MRD) Target Block
		offerFourAndFourCheckeredAroundOneRecipe(exporter, RecipeCategory.REDSTONE, Blocks.TARGET, 1,
				Blocks.HAY_BLOCK, Items.REDSTONE, Items.WHITE_DYE, "", null);
		// (MRD) Tripwire Hook
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.TRIPWIRE_HOOK)
				.input('/', Items.STICK)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Tags.Item.ALL_METAL_GRAMS)
				.input('@', Items.REDSTONE)
				.pattern("/X")
				.pattern("# ")
				.pattern("@ ")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion("has_any_metal_gram", conditionsFromTag(Tags.Item.ALL_METAL_GRAMS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.TRIPWIRE_HOOK));
		// (MRD) Weighted Pressure Plate (Heavy)
		offerRedstonePressurePlateRecipe(exporter, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Items.IRON_INGOT, "", null);
		// (MRD) Weighted Pressure Plate (Light)
		offerRedstonePressurePlateRecipe(exporter, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Items.GOLD_INGOT, "", null);
		
		//# Moss Block #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MOSS_BLOCK, 1,
				Blocks.MOSS_CARPET, "", null);
		
		//# Music Discs #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Items.MUSIC_DISC_5,
				Items.ECHO_SHARD, Items.DISC_FRAGMENT_5, "", null);
		
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
				.offerTo(exporter, idFromItem(Items.NAME_TAG));
		
		//# Painting #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Items.PAINTING, 1,
				Tags.Item.ALL_YARN_ROLLS, "has_any_yarn_roll", Items.STICK, "", null);
		
		//# Paper (production) #
		offerLargeRowRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 2,
				Items.SUGAR_CANE, fromItem(Items.SUGAR_CANE), "paper");
		offerLargeRowRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1,
				ModItems.WOODEN_STICK_BUNDLE, fromItem(ModItems.WOODEN_STICK_BUNDLE), "paper");
//		offerLargeRowRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1,
//				Tags.Item.ALL_PLANKS, "has_any_plank", "", null);
		//# Paper (recycling) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1, Items.MAP, Items.WHITE_DYE,
				"_from_map_recycling", "map_recycling");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1, Items.FILLED_MAP, Items.WHITE_DYE,
				"_from_filled_map_recycling", "map_recycling");
		
		//# Rails #
		// Rail - Basic
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.RAIL)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("# #")
				.pattern("#X#")
				.pattern("# #")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, idFromItem(Blocks.RAIL));
		// Rail - Accelerator
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
				.offerTo(exporter, idFromItem(Blocks.POWERED_RAIL));
		// Rail - Activator
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.ACTIVATOR_RAIL)
				.input('#', Blocks.RAIL)
				.input('@', Items.REDSTONE)
				.pattern("@")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.ACTIVATOR_RAIL));
		// Rail - Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.DETECTOR_RAIL)
				.input('#', Blocks.RAIL)
				.input('X', Tags.Item.ALL_LARGE_BRICKS)
				.input('@', Items.REDSTONE)
				.pattern("X")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion("has_any_large_brick", conditionsFromTag(Tags.Item.ALL_LARGE_BRICKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.DETECTOR_RAIL));
		
		//# Scaffolding #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SCAFFOLDING)
				.input('#', Blocks.BAMBOO)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("###")
				.pattern("#O#")
				.pattern("# #")
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(Blocks.SCAFFOLDING));
		
		//# Slime Ball #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SLIME_BALL)
				.input(Ingredient.fromTag(Tags.Item.ALL_YARNBALLS))
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.SLIME_BALL));
		
		//# Smithing Templates (armor trim - application) #
		VanillaRecipeProvider.streamSmithingTemplates().forEach(
				template -> offerArmorTrimSmithingRecipe(exporter, template.template(), template.id()));
		//# Smithing Templates (armor trim - duplication) #
		offerSmithingTemplateDuplicationRecipe(exporter, Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE,
				Items.COPPER_INGOT, ModItems.COPPER_GRAM);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Shale Cobblestone upon implementation.
				Items.NAUTILUS_SHELL);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Feldsand Cobblestone upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Zygolith Chunk upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
				Items.BREEZE_ROD, Items.WIND_CHARGE);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Terracotta Chunk upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Terracotta Chunk upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Netherrack Chunk upon implementation.
				Items.MAGMA_CREAM);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Shale Cobblestone upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Terracotta Chunk upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Slate Cobblestone upon implementation.
				ModItems.LIVE_GRASS_TUFT); //TODO: Replace with Skulkroot Wad upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Blackstone Cobblestone [name perhaps TBD] upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
				Items.POPPED_CHORUS_FRUIT, Items.CHORUS_FRUIT);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
				Items.PRISMARINE_SHARD, Items.PRISMARINE_CRYSTALS);
		offerSmithingTemplateDuplicationRecipe(exporter, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Shale Cobblestone upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Slate Cobblestone upon implementation.
				ModItems.LIVE_GRASS_TUFT); //TODO: Replace with Skulkroot Wad upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL); //TODO: Replace with Terracotta Chunk upon implementation.
		offerSmithingTemplateDuplicationRecipe(exporter, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Shale Cobblestone upon implementation.
				ModItems.LIVE_GRASS_TUFT); //TODO: Replace with Live Moss Wad upon implementation.
		//# Smithing Templates (equipment upgrade) #
		offerSmithingTemplateDuplicationRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
				ModItems.MUDBALL, //TODO: Replace with Netherrack Chunk upon implementation.
				Items.MAGMA_CREAM);
		
		//# Snow #
		// (snow) Ball
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.SNOWBALL, ModItems.SNOW_PILE,
				"_from_pile", null);
		// (snow) Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.SNOW_BLOCK, 1,
				ModItems.SNOW_PILE, "", null);
		// (snow) Pile
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNOW_PILE, 1)
				.input(Items.SNOWBALL, 2)
				.criterion(hasItem(Items.SNOWBALL), conditionsFromItem(Items.SNOWBALL))
				.offerTo(exporter, idFromItem(ModItems.SNOW_PILE));
		
		//# Sponge #
		offerSmeltingAndCampfireRecipeSet(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SPONGE,
				200, Blocks.WET_SPONGE, 0.125F, null);
		
		//# Sticks #
		// Stick from any plank
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 2)
				.input(Ingredient.fromTag(Tags.Item.ALL_PLANKS))
				.group("wooden_stick")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.offerTo(exporter, idFromItem(Items.STICK, "_from_plank"));
		// Stick from bamboo
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 1)
				.input(Ingredient.ofItems(Items.BAMBOO), 2)
				.group("wooden_stick")
				.criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
				.offerTo(exporter, idFromItem(Items.STICK, fromItem(Items.BAMBOO)));
		// Wooden Stick Bundle
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.WOODEN_STICK_BUNDLE, "", null,
				RecipeCategory.MISC, Items.STICK, "_from_bundle", "wooden_stick");
		
		//# Sugar #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.SUGAR, 200,
				Items.SUGAR_CANE, 0.125F, null);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, Items.SUGAR, 2, Items.HONEY_BOTTLE,
				"_from_honey_bottle", null);
		
		//# Torches #
		// Basic Torch
		offerTorchRecipeSet(exporter, Items.TORCH, Tags.Item.BASIC_FLAME_MATERIALS,
				"has_basic_flame_material", "" , "basic_torch");
		// Erythrite Torch
		offerTorchRecipeSet(exporter, Items.REDSTONE_TORCH, Items.REDSTONE, "" , "erythrite_torch");
		// Spirit Torch
		offerTorchRecipeSet(exporter, Items.SOUL_TORCH, Tags.Item.SPIRIT_FLAME_MATERIALS,
				"has_spirit_flame_material", "" , "spirit_torch");
		
		//# Yarn #
		// Yarn Blocks
		offerYarnBlockRecipe(exporter, Blocks.BLACK_WOOL, ModItems.BLACK_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.BLUE_WOOL, ModItems.BLUE_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.BROWN_WOOL, ModItems.BROWN_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.CYAN_WOOL, ModItems.CYAN_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.GRAY_WOOL, ModItems.GRAY_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.GREEN_WOOL, ModItems.GREEN_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.LIGHT_BLUE_WOOL, ModItems.LIGHT_BLUE_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.LIGHT_GRAY_WOOL, ModItems.LIGHT_GRAY_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.LIME_WOOL, ModItems.LIME_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.MAGENTA_WOOL, ModItems.MAGENTA_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.ORANGE_WOOL, ModItems.ORANGE_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.PINK_WOOL, ModItems.PINK_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.PURPLE_WOOL, ModItems.PURPLE_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.RED_WOOL, ModItems.RED_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.WHITE_WOOL, ModItems.WHITE_YARN_ROLL);
		offerYarnBlockRecipe(exporter, Blocks.YELLOW_WOOL, ModItems.YELLOW_YARN_ROLL);
		// Yarn Rolls
		offerYarnRollRecipes(exporter, ModItems.BLACK_YARN_ROLL, ModItems.BLACK_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.BLUE_YARN_ROLL, ModItems.BLUE_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.BROWN_YARN_ROLL, ModItems.BROWN_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.CYAN_YARN_ROLL, ModItems.CYAN_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.GRAY_YARN_ROLL, ModItems.GRAY_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.GREEN_YARN_ROLL, ModItems.GREEN_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.LIGHT_BLUE_YARN_ROLL, ModItems.LIGHT_BLUE_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.LIGHT_GRAY_YARN_ROLL, ModItems.LIGHT_GRAY_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.LIME_YARN_ROLL, ModItems.LIME_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.MAGENTA_YARN_ROLL, ModItems.MAGENTA_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.ORANGE_YARN_ROLL, ModItems.ORANGE_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.PINK_YARN_ROLL, ModItems.PINK_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.PURPLE_YARN_ROLL, ModItems.PURPLE_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.RED_YARN_ROLL, ModItems.RED_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.WHITE_YARN_ROLL, ModItems.WHITE_YARNBALL);
		offerYarnRollRecipes(exporter, ModItems.YELLOW_YARN_ROLL, ModItems.YELLOW_YARNBALL);
		//endregion
		
		
		//region Miscellaneous Vanilla Complex Recipes
		ComplexRecipeJsonBuilder.create(ArmorDyeRecipe::new).offerTo(exporter, "armor_dying");
		ComplexRecipeJsonBuilder.create(BannerDuplicateRecipe::new).offerTo(exporter, "banner_duplication");
		ComplexRecipeJsonBuilder.create(BookCloningRecipe::new).offerTo(exporter, "book_cloning");
		ComplexRecipeJsonBuilder.create(MapCloningRecipe::new).offerTo(exporter, "map_cloning");
		ComplexRecipeJsonBuilder.create(MapExtendingRecipe::new).offerTo(exporter, "map_extending");
		ComplexRecipeJsonBuilder.create(ShieldDecorationRecipe::new).offerTo(exporter, "shield_decoration");
		ComplexRecipeJsonBuilder.create(ShulkerBoxColoringRecipe::new).offerTo(exporter, "shulker_box_coloring");
		ComplexRecipeJsonBuilder.create(TippedArrowRecipe::new).offerTo(exporter, "tipped_arrow");
		//endregion
	}
	
	
	//region ## General Utility ##
	public static String itemName(ItemConvertible item) {
		return item.asItem().toString();
	}
	
	
	public static String fromItem(ItemConvertible item) {
		return "_from_" + itemName(item);
	}
	
	
	public static String fromItems(ItemConvertible item, ItemConvertible... items) {
		StringBuilder stringBuilder = new StringBuilder(fromItem(item));
		// Add each item of 'items', each beginning with "_and_".
		for (ItemConvertible i : items) {
			stringBuilder.append("_and_").append(itemName(i));
		}
		// NOTE: In GDScript, I could pass in an array of strings to this method, and use a built-in method
		//  to convert the array into a single stringBuilder with "_and_" as a separator between elements.
		return stringBuilder.toString();
	}
	
	
	public static String getCookingId(ItemConvertible resultItem, String fromString, String cookingType) {
		return getRecipeName(resultItem) + fromString + "_via_" + cookingType;
	}
	
	public static String getCookingId(ItemConvertible resultItem, ItemConvertible inputItem, String cookingType) {
		return getRecipeName(resultItem) + fromItem(inputItem) + "_via_" + cookingType;
	}
	//endregion
	
	
	//region ## Recipe Set Offers ##
	public static void offerBoatRecipeSet(
			RecipeExporter exporter, ItemConvertible plankItem, ItemConvertible boatItem, ItemConvertible chestBoatItem
	) {
		offerBoatRecipe(exporter, boatItem, plankItem);
		offerChestBoatRecipe(exporter, chestBoatItem, boatItem);
		//TODO: Implement chest boat separation crafting recipe.
		// - Output a Basic Chest and override the remainder of the chest boat to be an empty boat.
		// - Both merging and separation between boat and chest might want to use a special crafting recipe to retain chest name within item data...
	}
	
	
	public static void offerBowlOfStewRecipeSet(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible mainItem
	) {
		String group = itemName(resultItem);
		offerOldBowlOfStewRecipe(exporter, resultItem, mainItem, Items.BROWN_MUSHROOM, group);
		offerOldBowlOfStewRecipe(exporter, resultItem, mainItem, Items.CRIMSON_FUNGUS, group);
		offerOldBowlOfStewRecipe(exporter, resultItem, mainItem, Items.RED_MUSHROOM, group);
		offerOldBowlOfStewRecipe(exporter, resultItem, mainItem, ModItems.STARCHCAP_MUSHROOM, group);
		offerOldBowlOfStewRecipe(exporter, resultItem, mainItem, Items.WARPED_FUNGUS, group);
	}
	
	
	public static void offerBrickAndMortarBlockAndSlabAndStairAndWallRecipeSet(
			RecipeExporter exporter, ItemConvertible brickItem, ItemConvertible mortarItem,
			ItemConvertible blockItem, ItemConvertible slabItem, ItemConvertible stairItem, ItemConvertible wallItem,
			@Nullable String group
	) {
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, blockItem,
				mortarItem, brickItem, "", group);
		offerFourDiagonallyAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slabItem,
				mortarItem, brickItem, "", group);
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, stairItem)
				.input('#', brickItem)
				.input('O', mortarItem)
				.pattern("#  ")
				.pattern("##O")
				.pattern("###")
				.group(group)
				.criterion(hasItem(brickItem), conditionsFromItem(brickItem))
				.criterion(hasItem(mortarItem), conditionsFromItem(mortarItem))
				.offerTo(exporter, idFromItem(stairItem));
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wallItem,
				mortarItem, brickItem, "", group);
	}
	
	
	public static void offerDoorAndHatchRecipeSet(
			RecipeExporter exporter, ItemConvertible doorItem, ItemConvertible hatchItem,
			ItemConvertible materialItem, String doorIdSuffix, String hatchIdSuffix,
			@Nullable String doorGroup, @Nullable String hatchGroup
	) {
		offerDoorRecipe(exporter, doorItem, materialItem, doorIdSuffix, doorGroup);
		offerHatchRecipe(exporter, hatchItem, materialItem, hatchIdSuffix, hatchGroup);
	}
	
	
	public static void offerDyeBlobRecipeSet(
			RecipeExporter exporter,
			ItemConvertible blackDyeBlobItem, ItemConvertible blueDyeBlobItem,
			ItemConvertible brownDyeBlobItem, ItemConvertible cyanDyeBlobItem,
			ItemConvertible grayDyeBlobItem, ItemConvertible greenDyeBlobItem,
			ItemConvertible lightBlueDyeBlobItem, ItemConvertible lightGrayDyeBlobItem,
			ItemConvertible limeDyeBlobItem, ItemConvertible magentaDyeBlobItem,
			ItemConvertible orangeDyeBlobItem, ItemConvertible pinkDyeBlobItem,
			ItemConvertible purpleDyeBlobItem, ItemConvertible redDyeBlobItem,
			ItemConvertible whiteDyeBlobItem, ItemConvertible yellowDyeBlobItem,
			String blackDyeBlobGroup, String blueDyeBlobGroup,
			String brownDyeBlobGroup, String cyanDyeBlobGroup,
			String grayDyeBlobGroup, String greenDyeBlobGroup,
			String lightBlueDyeBlobGroup, String lightGrayDyeBlobGroup,
			String limeDyeBlobGroup, String magentaDyeBlobGroup,
			String orangeDyeBlobGroup, String pinkDyeBlobGroup,
			String purpleDyeBlobGroup, String redDyeBlobGroup,
			String whiteDyeBlobGroup, String yellowDyeBlobGroup
	) {
		//TODO: Create shapeless recipes which automatically generate the "from" string based on the input items.
		// - Also use overrides to:
		//  - Not require the 'recipeCategory' parameter, defaulting to 'RecipeCategory.MISC'.
		//  - Not require the 'count' parameter, defaulting to '1'.
		//region # Black Dye Blob #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, blackDyeBlobItem,
				Items.INK_SAC, fromItem(Items.INK_SAC), blackDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, blackDyeBlobItem, 2,
				Items.INK_SAC, Items.SLIME_BALL, fromItems(Items.INK_SAC, Items.SLIME_BALL), blackDyeBlobGroup);
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.MISC, blackDyeBlobItem, 4,
				Items.INK_SAC, Items.SLIME_BALL, ModItems.SULPHUR_LUMP,
				fromItems(Items.INK_SAC, Items.SLIME_BALL, ModItems.SULPHUR_LUMP), blackDyeBlobGroup);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, blackDyeBlobItem, 1,
				Items.WITHER_ROSE, fromItem(Items.WITHER_ROSE), blackDyeBlobGroup);
		//endregion
		//region # Blue Dye Blob #
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem,
				Items.CORNFLOWER, fromItem(Items.CORNFLOWER), blueDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem, 2,
				Items.LAPIS_LAZULI, Items.SLIME_BALL, fromItems(Items.LAPIS_LAZULI, Items.SLIME_BALL), blueDyeBlobGroup);
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem, 4,
				Items.LAPIS_LAZULI, Items.SLIME_BALL, ModItems.SULPHUR_LUMP,
				fromItems(Items.LAPIS_LAZULI, Items.SLIME_BALL, ModItems.SULPHUR_LUMP), blueDyeBlobGroup);
		//endregion
		//region # Brown Dye Blob #
		// from Cocoa Bean Pile
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, brownDyeBlobItem,
				Items.COCOA_BEANS, fromItem(Items.COCOA_BEANS), brownDyeBlobGroup);
		// from Cocoa Bean Pile & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, brownDyeBlobItem, 2,
				Items.COCOA_BEANS, Items.SLIME_BALL, fromItems(Items.COCOA_BEANS, Items.SLIME_BALL), brownDyeBlobGroup);
		// from Cocoa Bean Pile & Slime Ball & Sulphur Lump
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.MISC, brownDyeBlobItem, 4,
				Items.COCOA_BEANS, Items.SLIME_BALL, ModItems.SULPHUR_LUMP,
				fromItems(Items.COCOA_BEANS, Items.SLIME_BALL, ModItems.SULPHUR_LUMP), brownDyeBlobGroup);
		// Black + Orange
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, brownDyeBlobItem, 2,
			blackDyeBlobItem, orangeDyeBlobItem, fromItems(blackDyeBlobItem, orangeDyeBlobItem), brownDyeBlobGroup);
		// Green + Purple + Red
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, brownDyeBlobItem, 3)
				.input(Ingredient.ofItems(greenDyeBlobItem))
				.input(Ingredient.ofItems(purpleDyeBlobItem))
				.input(Ingredient.ofItems(redDyeBlobItem))
				.group(brownDyeBlobGroup)
				.criterion(hasItem(greenDyeBlobItem), conditionsFromItem(greenDyeBlobItem))
				.criterion(hasItem(purpleDyeBlobItem), conditionsFromItem(purpleDyeBlobItem))
				.criterion(hasItem(redDyeBlobItem), conditionsFromItem(redDyeBlobItem))
				.offerTo(exporter, idFromItem(brownDyeBlobItem, fromItems(greenDyeBlobItem, purpleDyeBlobItem, redDyeBlobItem)));
		//endregion
		//region # Cyan Dye Blob #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, cyanDyeBlobItem, 2,
				blueDyeBlobItem, greenDyeBlobItem, "_from_blue_and_green", cyanDyeBlobGroup);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, cyanDyeBlobItem, 3,
				Items.PITCHER_PLANT, fromItem(Items.PITCHER_PLANT), cyanDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, cyanDyeBlobItem, 5,
				Items.PITCHER_PLANT, Items.SLIME_BALL, "_from_pitcher_plant_and_slime_ball", cyanDyeBlobGroup);
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.MISC, cyanDyeBlobItem, 9,
				Items.PITCHER_PLANT, Items.SLIME_BALL, ModItems.SULPHUR_LUMP,
				"_from_pitcher_plant_and_slime_ball_and_sulphur_lump", cyanDyeBlobGroup);
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, cyanDyeBlobItem, 200,
				Items.NETHER_SPROUTS, 0.125F, cyanDyeBlobGroup);
		//endregion
		//region # Gray Dye Blob #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, grayDyeBlobItem)
				.input(Ingredient.ofItems(
						blueDyeBlobItem,
						brownDyeBlobItem,
						cyanDyeBlobItem,
						greenDyeBlobItem,
						magentaDyeBlobItem,
						orangeDyeBlobItem,
						purpleDyeBlobItem,
						redDyeBlobItem))
				.input(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.group(grayDyeBlobGroup)
				.criterion(hasItem(blueDyeBlobItem), conditionsFromItem(blueDyeBlobItem))
				.criterion(hasItem(brownDyeBlobItem), conditionsFromItem(brownDyeBlobItem))
				.criterion(hasItem(cyanDyeBlobItem), conditionsFromItem(cyanDyeBlobItem))
				.criterion(hasItem(greenDyeBlobItem), conditionsFromItem(greenDyeBlobItem))
				.criterion(hasItem(magentaDyeBlobItem), conditionsFromItem(magentaDyeBlobItem))
				.criterion(hasItem(orangeDyeBlobItem), conditionsFromItem(orangeDyeBlobItem))
				.criterion(hasItem(purpleDyeBlobItem), conditionsFromItem(purpleDyeBlobItem))
				.criterion(hasItem(redDyeBlobItem), conditionsFromItem(redDyeBlobItem))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(grayDyeBlobItem, "_from_brimwater_desaturation"));
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, grayDyeBlobItem, 2,
			blackDyeBlobItem, whiteDyeBlobItem, "_from_black_and_white", grayDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, grayDyeBlobItem, 2,
				Items.CHARCOAL, Items.SLIME_BALL, fromItem(Items.CHARCOAL), grayDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, grayDyeBlobItem, 3,
				Items.COAL, Items.SLIME_BALL, fromItem(Items.COAL), grayDyeBlobGroup);
		//endregion
		//region # Green Dye Blob #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, greenDyeBlobItem, 200,
				Items.CACTUS, 1.0F, greenDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, greenDyeBlobItem,
				ModItems.LIVE_GRASS_TUFT, Items.SLIME_BALL, fromItems(ModItems.LIVE_GRASS_TUFT, Items.SLIME_BALL), greenDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, greenDyeBlobItem, 2,
				ModItems.SULPHUR_LUMP, Items.SLIME_BALL, fromItems(ModItems.SULPHUR_LUMP, Items.SLIME_BALL), greenDyeBlobGroup);
		//endregion
		//region # Light Blue Dye Blob #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, lightBlueDyeBlobItem, 2,
			blueDyeBlobItem, whiteDyeBlobItem, "_from_blue_and_white", lightBlueDyeBlobGroup);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightBlueDyeBlobItem,
				Items.BLUE_ORCHID, fromItem(Items.BLUE_ORCHID), lightBlueDyeBlobGroup);
		//endregion
		//region # Light Gray Dye Blob #
		// from Ash Pile & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem,
				ModItems.ASH_PILE, Items.SLIME_BALL, fromItem(ModItems.ASH_PILE) + "_and_" + itemName(Items.SLIME_BALL), lightGrayDyeBlobGroup);
		// from Azure Bluet
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem,
				Items.AZURE_BLUET, fromItem(Items.AZURE_BLUET), lightGrayDyeBlobGroup);
		// Black + White
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, lightGrayDyeBlobItem)
				.input(Ingredient.ofItems(blackDyeBlobItem))
				.input(Ingredient.ofItems(whiteDyeBlobItem), 2)
				.group(lightGrayDyeBlobGroup)
				.criterion(hasItem(blackDyeBlobItem), conditionsFromItem(blackDyeBlobItem))
				.criterion(hasItem(whiteDyeBlobItem), conditionsFromItem(whiteDyeBlobItem))
				.offerTo(exporter, idFromItem(lightGrayDyeBlobItem, "_from_black_and_white"));
		// Gray + White
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem, 2,
				grayDyeBlobItem, whiteDyeBlobItem, "_from_gray_and_white", lightGrayDyeBlobGroup);
		// Light Blue + Lime + Pink + Yellow
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, lightGrayDyeBlobItem)
				.input(Ingredient.ofItems(
						lightBlueDyeBlobItem,
						limeDyeBlobItem,
						pinkDyeBlobItem,
						yellowDyeBlobItem))
				.input(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.group(lightGrayDyeBlobGroup)
				.criterion(hasItem(lightBlueDyeBlobItem), conditionsFromItem(lightBlueDyeBlobItem))
				.criterion(hasItem(limeDyeBlobItem), conditionsFromItem(limeDyeBlobItem))
				.criterion(hasItem(pinkDyeBlobItem), conditionsFromItem(pinkDyeBlobItem))
				.criterion(hasItem(yellowDyeBlobItem), conditionsFromItem(yellowDyeBlobItem))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(lightGrayDyeBlobItem, "_from_brimwater_desaturation"));
		// from Oxeye Daisy
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem,
				Items.OXEYE_DAISY, fromItem(Items.OXEYE_DAISY), lightGrayDyeBlobGroup);
		// from White Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem,
				Items.WHITE_TULIP, fromItem(Items.WHITE_TULIP), lightGrayDyeBlobGroup);
		//endregion
		//region # Lime Dye Blob #
		// Green + White
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, limeDyeBlobItem, 2,
			greenDyeBlobItem, whiteDyeBlobItem, "_from_green_and_white", limeDyeBlobGroup);
		// from Sea Pickle
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, limeDyeBlobItem, 200,
				Items.SEA_PICKLE, 0.125F, limeDyeBlobGroup);
		//endregion
		//region # Magenta Dye Blob #
		// from Allium
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, magentaDyeBlobItem,
				Items.ALLIUM, fromItem(Items.ALLIUM), magentaDyeBlobGroup);
		// Blue + Pink + Red
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, magentaDyeBlobItem, 3)
				.input(Ingredient.ofItems(blueDyeBlobItem))
				.input(Ingredient.ofItems(pinkDyeBlobItem))
				.input(Ingredient.ofItems(redDyeBlobItem))
				.group(magentaDyeBlobGroup)
				.criterion(hasItem(blueDyeBlobItem), conditionsFromItem(blueDyeBlobItem))
				.criterion(hasItem(pinkDyeBlobItem), conditionsFromItem(pinkDyeBlobItem))
				.criterion(hasItem(redDyeBlobItem), conditionsFromItem(redDyeBlobItem))
				.offerTo(exporter, idFromItem(magentaDyeBlobItem, fromItems(blueDyeBlobItem, pinkDyeBlobItem, redDyeBlobItem)));
		// Purple + Pink
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, magentaDyeBlobItem, 2,
				purpleDyeBlobItem, pinkDyeBlobItem, fromItems(purpleDyeBlobItem, pinkDyeBlobItem), magentaDyeBlobGroup);
		// Blue + Red + Red + White
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, magentaDyeBlobItem, 4)
				.input(Ingredient.ofItems(blueDyeBlobItem))
				.input(Ingredient.ofItems(redDyeBlobItem), 2)
				.input(Ingredient.ofItems(whiteDyeBlobItem))
				.group(magentaDyeBlobGroup)
				.criterion(hasItem(blueDyeBlobItem), conditionsFromItem(blueDyeBlobItem))
				.criterion(hasItem(redDyeBlobItem), conditionsFromItem(redDyeBlobItem))
				.criterion(hasItem(whiteDyeBlobItem), conditionsFromItem(whiteDyeBlobItem))
				.offerTo(exporter, idFromItem(magentaDyeBlobItem, fromItems(blueDyeBlobItem, redDyeBlobItem, whiteDyeBlobItem)));
		// from Lilac
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, magentaDyeBlobItem, 2,
				Items.LILAC, fromItem(Items.LILAC), magentaDyeBlobGroup);
		//endregion
		//region # Orange Dye Blob #
		// from Orange Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, orangeDyeBlobItem,
				Items.ORANGE_TULIP, fromItem(Items.ORANGE_TULIP), orangeDyeBlobGroup);
		// Red + Yellow
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, orangeDyeBlobItem, 2,
				redDyeBlobItem, yellowDyeBlobItem, fromItems(redDyeBlobItem, yellowDyeBlobItem), orangeDyeBlobGroup);
		// from Torchflower
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, orangeDyeBlobItem, 2,
				Items.TORCHFLOWER, fromItem(Items.TORCHFLOWER), orangeDyeBlobGroup);
		//endregion
		//region # Pink Dye Blob #
		// from Cherry Petal Pile
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem,
				Items.PINK_PETALS, fromItem(Items.PINK_PETALS), pinkDyeBlobGroup);
		// from Peony
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem, 2,
				Items.PEONY, fromItem(Items.PEONY), pinkDyeBlobGroup);
		// from Pink Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem,
				Items.PINK_TULIP, fromItem(Items.PINK_TULIP), pinkDyeBlobGroup);
		// Red + White
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem, 2,
				redDyeBlobItem, whiteDyeBlobItem, fromItems(redDyeBlobItem, whiteDyeBlobItem), pinkDyeBlobGroup);
		//endregion
		//region # Purple Dye Blob #
		// Blue + Red
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, purpleDyeBlobItem, 2,
				blueDyeBlobItem, redDyeBlobItem, fromItems(blueDyeBlobItem, redDyeBlobItem), purpleDyeBlobGroup);
		//endregion
		//region # Red Dye Blob #
		// from Netherwart Pile
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 200, Items.NETHER_WART,
				0.25F, redDyeBlobGroup);
		// from Poppy
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, Items.POPPY,
				fromItem(Items.POPPY), redDyeBlobGroup);
		// from Radish
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, Items.BEETROOT,
				fromItem(Items.BEETROOT), redDyeBlobGroup);
		// from Red Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, Items.RED_TULIP,
				fromItem(Items.RED_TULIP), redDyeBlobGroup);
		// from Rose Bush
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 2, Items.ROSE_BUSH,
				fromItem(Items.ROSE_BUSH), redDyeBlobGroup);
		//endregion
		//region # White Dye Blob #
		// from Bonemeal Ball & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, whiteDyeBlobItem, Items.BONE_MEAL, Items.SLIME_BALL,
				fromItem(Items.BONE_MEAL) + "_and_" + itemName(Items.SLIME_BALL), whiteDyeBlobGroup);
		// from Lily of the Valley
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, whiteDyeBlobItem, Items.LILY_OF_THE_VALLEY,
				fromItem(Items.LILY_OF_THE_VALLEY), whiteDyeBlobGroup);
		// from Lily of the Valley & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, whiteDyeBlobItem, 2, Items.LILY_OF_THE_VALLEY, Items.SLIME_BALL,
				fromItem(Items.LILY_OF_THE_VALLEY) + "_and_" + itemName(Items.SLIME_BALL), whiteDyeBlobGroup);
		//endregion
		//region # Yellow Dye Blob #
		// from Brown Dye Blob & Sulphur Lump & White Dye Blob
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, yellowDyeBlobItem, 4)
				.input(Ingredient.ofItems(brownDyeBlobItem))
				.input(Ingredient.ofItems(ModItems.SULPHUR_LUMP))
				.input(Ingredient.ofItems(whiteDyeBlobItem))
				.group(yellowDyeBlobGroup)
				.criterion(hasItem(brownDyeBlobItem), conditionsFromItem(brownDyeBlobItem))
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(whiteDyeBlobItem), conditionsFromItem(whiteDyeBlobItem))
				.offerTo(exporter, idFromItem(yellowDyeBlobItem, fromItems(brownDyeBlobItem, ModItems.SULPHUR_LUMP, whiteDyeBlobItem)));
		// from Dandelion
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, yellowDyeBlobItem,
				Items.DANDELION, fromItem(Items.DANDELION), yellowDyeBlobGroup);
		// from Slime Ball Blob & Sulphur Lump & White Dye Blob
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, yellowDyeBlobItem, 3)
				.input(Ingredient.ofItems(Items.SLIME_BALL))
				.input(Ingredient.ofItems(ModItems.SULPHUR_LUMP))
				.input(Ingredient.ofItems(whiteDyeBlobItem))
				.group(yellowDyeBlobGroup)
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(whiteDyeBlobItem), conditionsFromItem(whiteDyeBlobItem))
				.offerTo(exporter, idFromItem(yellowDyeBlobItem, fromItems(Items.SLIME_BALL, ModItems.SULPHUR_LUMP, whiteDyeBlobItem)));
		// from Sunflower
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, yellowDyeBlobItem,
				Items.SUNFLOWER, fromItem(Items.SUNFLOWER), yellowDyeBlobGroup);
		//endregion
	}
	
	
	public static void offerGenericBlockAndSlabAndStairRecipeSet(
			RecipeExporter exporter, ItemConvertible materialItem,
			ItemConvertible blockItem, ItemConvertible slabItem, ItemConvertible stairItem, @Nullable String group
	) {
		offerBlockOfEightRecipe(exporter, blockItem, materialItem, "", group);
		offerSlabBlockOfLargeShapeRecipe(exporter, slabItem, materialItem, "", group);
		offerStairBlockOfLargeShapeRecipe(exporter, stairItem, materialItem, "", group);
	}
	
	
	public static void offerPrimitiveShaftedToolRecipeSet(
			RecipeExporter exporter, ItemConvertible shardItem, String materialName,
			ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible spearItem
	) {
		String group = materialName + "_tools";
		offerStringedDaggerRecipe(exporter, daggerItem, shardItem, "", group);
		offerStringedHatchetRecipe(exporter, hatchetItem, shardItem, "", group);
		offerStringedHoeRecipe(exporter, hoeItem, shardItem, "", group);
		offerStringedSpearRecipe(exporter, spearItem, shardItem, "", group);
	}
	
	
	public static void offerSandstoneRecipeSet(
			RecipeExporter exporter,
			ItemConvertible sandstoneBlock, ItemConvertible cutSandstoneBlock,
			ItemConvertible chiseledSandstoneBlock, ItemConvertible polishedSandstoneBlock
//			ItemConvertible sandstoneSlab, ItemConvertible sandstoneStair
			) {
		// TODO: Rework upon implementation of sandstone chunks.
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, cutSandstoneBlock, 1, sandstoneBlock);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, chiseledSandstoneBlock, 1, sandstoneBlock);
		offerSawmillRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedSandstoneBlock, 1, sandstoneBlock);
		//TODO: Add temporary slab and stair recipes.
		
		//TODO: Don't bother with this yet; just add proper recipes when the ingredient items are added.
	}
	
	
	public static void offerStandardMetalRecipeSet(
			RecipeExporter exporter,
			ItemConvertible gramItem, ItemConvertible ingotItem,
			ItemConvertible rawLumpItem, ItemConvertible rawNuggetItem,
			int baseCookingTime, float baseCookingExperience,
			ItemConvertible rawBlock, ItemConvertible refinedBlock
	) {
		// Block (raw)
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, rawBlock, 1, rawLumpItem,"", null);
		// Block (refined)
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, refinedBlock, 1, ingotItem,"", null);
		// Cooking Grams and Ingots
		offerSmeltingAndBlastingForMetalRecipes(exporter, gramItem, ingotItem,
				baseCookingTime, rawNuggetItem, rawLumpItem, baseCookingExperience);
		// Merging and Splitting (raw)
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, rawLumpItem, "_from_nugget", "nugget_merging",
				RecipeCategory.MISC, rawNuggetItem, "_from_lump", "lump_splitting");
		// Merging and Splitting (refined)
		offerReversibleDoubleRowRecipes(exporter,
				RecipeCategory.MISC, ingotItem, "_from_gram", "gram_merging",
				RecipeCategory.MISC, gramItem, "_from_ingot", "ingot_splitting");
	}
	
	
	public static void offerStandardPlankRecipeSet(
			RecipeExporter exporter,
			ItemConvertible woodenLog, // NOTE: Planks cannot be crafted directly from trunks.
			ItemConvertible plankItem, ItemConvertible plankBlock,
			ItemConvertible button, ItemConvertible pressurePlate,
			ItemConvertible door, ItemConvertible hatch,
			ItemConvertible fenceGate, ItemConvertible fencePost,
			ItemConvertible plankSlab, ItemConvertible plankStair
	) {
		// Planks from log
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, plankItem, 6)
				.input(woodenLog)
				.group("log_splitting")
				.criterion(hasItem(woodenLog), conditionsFromItem(woodenLog))
				.offerTo(exporter, idFromItem(plankItem, "_from_log"));
		offerSawmillRecipe(exporter, RecipeCategory.MISC, plankItem, 7, woodenLog);
		// Plank Block
		offerBlockOfEightRecipe(exporter, plankBlock, plankItem, "", "plank_blocks");
		// Button
		offerRedstoneButtonRecipe(exporter, button, plankItem, "", "wooden_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter, pressurePlate, plankItem, "", "wooden_pressure_plates");
		// Door & Hatch
		offerDoorAndHatchRecipeSet(exporter, door, hatch, plankItem,
				"", "","wooden_doors", "wooden_hatches");
		// Fence Gate
		offerWoodenFenceGateRecipe(exporter, RecipeCategory.REDSTONE, fenceGate, plankItem);
		// Fence Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.DECORATIONS, fencePost, 1, plankItem, "", "wooden_fence_posts");
		// Plank Slab
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, plankSlab, 1, plankItem, "", "wooden_slabs");
		// Plank Stair
		offerStairBlockOfLargeShapeRecipe(exporter, plankStair, plankItem, "", "wooden_stairs");
	}
	
	
	public static void offerStandardStoneRecipeSet(
			RecipeExporter exporter, ItemConvertible cobblestoneItem, ItemConvertible brickItem,
			ItemConvertible naturalBlock, ItemConvertible cobblestoneBlock,
			ItemConvertible brickBlock, ItemConvertible polishedBlock,
			ItemConvertible button, ItemConvertible pressurePlate,
			ItemConvertible brickWallPost,
			ItemConvertible brickSlab, ItemConvertible brickStair
	) {
		// Brick
		offerReversibleSmallRowRecipes(exporter,
				RecipeCategory.MISC, brickItem, "_from_cobblestone", "bricks",
				RecipeCategory.MISC, cobblestoneItem, "_from_brick", "cobblestones"
		);
		// Natural Block
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, naturalBlock,
				Items.BLAZE_POWDER, cobblestoneItem, "", "natural_stone_blocks");
		// Cobblestone Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, cobblestoneBlock, 1,
				cobblestoneItem, "", "cobbled_stone_blocks");
		// Brick Block
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickBlock, 1, brickItem, "", "brick_blocks");
		// Polished Block
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, polishedBlock,
				Items.BLAZE_POWDER, brickItem, "", "stone_polishing");
		// Button
		offerRedstoneButtonRecipe(exporter, button, brickItem, "", "stone_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter, pressurePlate, brickItem, "", "stone_pressure_plates");
		// Brick Wall Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickWallPost, 1, brickItem, "", "brick_wall_posts");
		// Brick Slab
		offerSmallRowRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickSlab, 1, brickItem, "", "brick_slabs");
		// Brick Stair
		offerStairBlockOfSmallShapeRecipe(exporter, brickStair, brickItem, "", "brick_stairs");
	}
	
	
	public static void offerStandardShaftedToolRecipeSet(
			RecipeExporter exporter, ItemConvertible ingotItem, String materialName,
			ItemConvertible axeItem, ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible malletItem, ItemConvertible pickaxeItem,
			ItemConvertible shovelItem, ItemConvertible spearItem, ItemConvertible swordItem
	) {
		String group = materialName + "_shafted_tools";
		offerBasicAxeRecipe(exporter, axeItem, ingotItem, "", group);
		offerBasicDaggerRecipe(exporter, daggerItem, ingotItem, "", group);
		offerBasicHatchetRecipe(exporter, hatchetItem, ingotItem, "", group);
		offerBasicHoeRecipe(exporter, hoeItem, ingotItem, "", group);
		offerBasicMalletRecipe(exporter, malletItem, ingotItem, "", group);
		offerBasicPickaxeRecipe(exporter, pickaxeItem, ingotItem, "", group);
		offerBasicShovelRecipe(exporter, shovelItem, ingotItem, "", group);
		offerBasicSpearRecipe(exporter, spearItem, ingotItem, "", group);
		offerBasicSwordRecipe(exporter, swordItem, ingotItem, "", group);
	}
	
	
	public static void offerMetalArmorRecipeSet(
			RecipeExporter exporter, ItemConvertible ingotItem, String materialName,
			ItemConvertible bootPairItem, ItemConvertible chestplateItem,
			ItemConvertible helmetItem, ItemConvertible leggingPairItem,
			ItemConvertible horseArmorItem
	) {
		String group = materialName + "_armor";
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.COMBAT, bootPairItem,
				Items.LEATHER_BOOTS, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.COMBAT, chestplateItem,
				Items.LEATHER_CHESTPLATE, ingotItem, "", group);
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.COMBAT, helmetItem,
				Items.LEATHER_HELMET, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.COMBAT, leggingPairItem,
				Items.LEATHER_LEGGINGS, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.COMBAT, horseArmorItem,
				Items.LEATHER_HORSE_ARMOR, ingotItem, "", group);
	}
	
	
	public static void offerMetalEquipmentRecipeSet(
			RecipeExporter exporter, ItemConvertible ingotItem, ItemConvertible refundItem, String materialName,
			ItemConvertible bootPairItem, ItemConvertible chestplateItem,
			ItemConvertible helmetItem, ItemConvertible leggingPairItem,
			ItemConvertible horseArmorItem,
			ItemConvertible axeItem, ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible malletItem, ItemConvertible pickaxeItem,
			ItemConvertible shovelItem, ItemConvertible spearItem, ItemConvertible swordItem
	) {
		offerMetalArmorRecipeSet(exporter, ingotItem, materialName,
				bootPairItem, chestplateItem, helmetItem, leggingPairItem, horseArmorItem);
		offerStandardShaftedToolRecipeSet(exporter, ingotItem, materialName,
				axeItem, daggerItem, hatchetItem, hoeItem, malletItem, pickaxeItem, shovelItem,spearItem, swordItem);
		offerMetalEquipmentRecyclingRecipeSet(exporter, refundItem, materialName,
				bootPairItem, chestplateItem, helmetItem, leggingPairItem, horseArmorItem,
				axeItem, daggerItem, hatchetItem, hoeItem, malletItem, pickaxeItem, shovelItem, spearItem,swordItem);
	}
	
	
	public static void offerMetalEquipmentRecyclingRecipeSet(
			RecipeExporter exporter, ItemConvertible refundItem, String materialName,
			ItemConvertible bootPairItem, ItemConvertible chestplateItem,
			ItemConvertible helmetItem, ItemConvertible leggingPairItem,
			ItemConvertible horseArmorItem,
			ItemConvertible axeItem, ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible malletItem, ItemConvertible pickaxeItem,
			ItemConvertible shovelItem, ItemConvertible spearItem, ItemConvertible swordItem
	) {
		String group = materialName + "_equipment_recycling";
		// Armor
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 4,
				bootPairItem, fromItem(bootPairItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 8,
				chestplateItem, fromItem(chestplateItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 4,
				helmetItem, fromItem(helmetItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 8,
				leggingPairItem, fromItem(leggingPairItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 8,
				horseArmorItem, fromItem(horseArmorItem) + "_recycling", group);
		// Tools
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 2,
				axeItem, fromItem(axeItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 1,
				daggerItem, fromItem(daggerItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 1,
				hatchetItem, fromItem(hatchetItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 1,
				hoeItem, fromItem(hoeItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 2,
				malletItem, fromItem(malletItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 2,
				pickaxeItem, fromItem(pickaxeItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 1,
				shovelItem, fromItem(shovelItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 1,
				spearItem, fromItem(spearItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, refundItem, 2,
				swordItem, fromItem(swordItem) + "_recycling", group);
	}
	
	
	public static void offerMetalHumanoidArmorRecyclingRecipeSet(
			RecipeExporter exporter, ItemConvertible nuggetItem, String materialName,
			ItemConvertible bootPairItem, ItemConvertible chestplateItem,
			ItemConvertible helmetItem, ItemConvertible leggingPairItem
	) {
		String group = materialName + "_equipment_recycling";
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, nuggetItem, 4,
				bootPairItem, fromItem(bootPairItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, nuggetItem, 8,
				chestplateItem, fromItem(chestplateItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, nuggetItem, 4,
				helmetItem, fromItem(helmetItem) + "_recycling", group);
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, nuggetItem, 8,
				leggingPairItem, fromItem(leggingPairItem) + "_recycling", group);
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
				.offerTo(exporter, idFromItem(standingSignItem));
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
				.offerTo(exporter, idFromItem(hangingSignItem));
	}
	
	
	public static void offerTorchRecipeSet(
			RecipeExporter exporter, ItemConvertible resultItem, TagKey<Item> flammableInputItemTag,
			String hasTagString, String idSuffix, @Nullable String group
	) {
		offerTorchOfStrongBinderRecipe(exporter, RecipeCategory.TOOLS, resultItem, 1,
				Items.STICK, flammableInputItemTag, hasTagString, idSuffix, group);
		offerTorchOfWeakBinderRecipe(exporter, RecipeCategory.TOOLS, resultItem, 1,
				Items.STICK, flammableInputItemTag, hasTagString, idSuffix, group);
	}
	
	public static void offerTorchRecipeSet(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible flammableInputItem,
			String idSuffix, @Nullable String group
	) {
		offerTorchOfStrongBinderRecipe(exporter, RecipeCategory.TOOLS, resultItem, 1,
				Items.STICK, flammableInputItem, idSuffix, group);
		offerTorchOfWeakBinderRecipe(exporter, RecipeCategory.TOOLS, resultItem, 1,
				Items.STICK, flammableInputItem, idSuffix, group);
	}
	
	
	public static void offerYarnballDyingRecipeSet(RecipeExporter exporter) {
		String group = "yarnball_dying";
		//region Black Yarnball
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_YARNBALL)
				.input(Ingredient.ofItems(
						ModItems.BLUE_YARNBALL,
						ModItems.BROWN_YARNBALL,
						ModItems.CYAN_YARNBALL,
						ModItems.GRAY_YARNBALL,
						ModItems.GREEN_YARNBALL,
						ModItems.LIGHT_BLUE_YARNBALL,
						ModItems.LIGHT_GRAY_YARNBALL,
						ModItems.LIME_YARNBALL,
						ModItems.MAGENTA_YARNBALL,
						ModItems.ORANGE_YARNBALL,
						ModItems.PINK_YARNBALL,
						ModItems.PURPLE_YARNBALL,
						ModItems.RED_YARNBALL,
						ModItems.WHITE_YARNBALL,
						ModItems.YELLOW_YARNBALL))
				.input(Items.BLACK_DYE)
				.group(group)
				.criterion(hasItem(ModItems.BLUE_YARNBALL), conditionsFromItem(ModItems.BLUE_YARNBALL))
				.criterion(hasItem(ModItems.BROWN_YARNBALL), conditionsFromItem(ModItems.BROWN_YARNBALL))
				.criterion(hasItem(ModItems.CYAN_YARNBALL), conditionsFromItem(ModItems.CYAN_YARNBALL))
				.criterion(hasItem(ModItems.GRAY_YARNBALL), conditionsFromItem(ModItems.GRAY_YARNBALL))
				.criterion(hasItem(ModItems.GREEN_YARNBALL), conditionsFromItem(ModItems.GREEN_YARNBALL))
				.criterion(hasItem(ModItems.LIGHT_BLUE_YARNBALL), conditionsFromItem(ModItems.LIGHT_BLUE_YARNBALL))
				.criterion(hasItem(ModItems.LIGHT_GRAY_YARNBALL), conditionsFromItem(ModItems.LIGHT_GRAY_YARNBALL))
				.criterion(hasItem(ModItems.LIME_YARNBALL), conditionsFromItem(ModItems.LIME_YARNBALL))
				.criterion(hasItem(ModItems.MAGENTA_YARNBALL), conditionsFromItem(ModItems.MAGENTA_YARNBALL))
				.criterion(hasItem(ModItems.ORANGE_YARNBALL), conditionsFromItem(ModItems.ORANGE_YARNBALL))
				.criterion(hasItem(ModItems.PINK_YARNBALL), conditionsFromItem(ModItems.PINK_YARNBALL))
				.criterion(hasItem(ModItems.PURPLE_YARNBALL), conditionsFromItem(ModItems.PURPLE_YARNBALL))
				.criterion(hasItem(ModItems.RED_YARNBALL), conditionsFromItem(ModItems.RED_YARNBALL))
				.criterion(hasItem(ModItems.WHITE_YARNBALL), conditionsFromItem(ModItems.WHITE_YARNBALL))
				.criterion(hasItem(ModItems.YELLOW_YARNBALL), conditionsFromItem(ModItems.YELLOW_YARNBALL))
				.criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
				.offerTo(exporter, idFromItem(ModItems.BLACK_YARNBALL, fromItem(Items.BLACK_DYE)));
		//endregion
		
		//region Common Yarnball Dying (from White Yarnball)
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.BLUE_YARNBALL, Items.BLUE_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.BROWN_YARNBALL, Items.BROWN_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.CYAN_YARNBALL, Items.CYAN_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.GRAY_YARNBALL, Items.GRAY_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.GREEN_YARNBALL, Items.GREEN_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.LIGHT_BLUE_YARNBALL, Items.LIGHT_BLUE_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.LIGHT_GRAY_YARNBALL, Items.LIGHT_GRAY_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.LIME_YARNBALL, Items.LIME_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.MAGENTA_YARNBALL, Items.MAGENTA_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.ORANGE_YARNBALL, Items.ORANGE_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.PINK_YARNBALL, Items.PINK_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.PURPLE_YARNBALL, Items.PURPLE_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.RED_YARNBALL, Items.RED_DYE, group);
		offerBasicYarnballDyingFromWhiteRecipe(exporter, ModItems.YELLOW_YARNBALL, Items.YELLOW_DYE, group);
		//endregion
		
		//region Yarnball Lightening
		offerBasicYarnballDyingRecipe(exporter, ModItems.GRAY_YARNBALL, ModItems.BLACK_YARNBALL, Items.WHITE_DYE, group);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL)
				.input(Ingredient.ofItems(
						ModItems.BLUE_YARNBALL,
						ModItems.BROWN_YARNBALL,
						ModItems.CYAN_YARNBALL,
						ModItems.GRAY_YARNBALL,
						ModItems.GREEN_YARNBALL,
						ModItems.LIGHT_BLUE_YARNBALL,
						ModItems.LIME_YARNBALL,
						ModItems.MAGENTA_YARNBALL,
						ModItems.ORANGE_YARNBALL,
						ModItems.PINK_YARNBALL,
						ModItems.PURPLE_YARNBALL,
						ModItems.RED_YARNBALL,
						ModItems.YELLOW_YARNBALL))
				.input(Items.WHITE_DYE)
				.group(group)
				.criterion(hasItem(ModItems.BLUE_YARNBALL), conditionsFromItem(ModItems.BLUE_YARNBALL))
				.criterion(hasItem(ModItems.BROWN_YARNBALL), conditionsFromItem(ModItems.BROWN_YARNBALL))
				.criterion(hasItem(ModItems.CYAN_YARNBALL), conditionsFromItem(ModItems.CYAN_YARNBALL))
				.criterion(hasItem(ModItems.GRAY_YARNBALL), conditionsFromItem(ModItems.GRAY_YARNBALL))
				.criterion(hasItem(ModItems.GREEN_YARNBALL), conditionsFromItem(ModItems.GREEN_YARNBALL))
				.criterion(hasItem(ModItems.LIGHT_BLUE_YARNBALL), conditionsFromItem(ModItems.LIGHT_BLUE_YARNBALL))
				.criterion(hasItem(ModItems.LIME_YARNBALL), conditionsFromItem(ModItems.LIME_YARNBALL))
				.criterion(hasItem(ModItems.MAGENTA_YARNBALL), conditionsFromItem(ModItems.MAGENTA_YARNBALL))
				.criterion(hasItem(ModItems.ORANGE_YARNBALL), conditionsFromItem(ModItems.ORANGE_YARNBALL))
				.criterion(hasItem(ModItems.PINK_YARNBALL), conditionsFromItem(ModItems.PINK_YARNBALL))
				.criterion(hasItem(ModItems.PURPLE_YARNBALL), conditionsFromItem(ModItems.PURPLE_YARNBALL))
				.criterion(hasItem(ModItems.RED_YARNBALL), conditionsFromItem(ModItems.RED_YARNBALL))
				.criterion(hasItem(ModItems.YELLOW_YARNBALL), conditionsFromItem(ModItems.YELLOW_YARNBALL))
				.criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
				.offerTo(exporter, idFromItem(ModItems.BLACK_YARNBALL, fromItem(Items.WHITE_DYE)));
		offerBasicYarnballDyingRecipe(exporter, ModItems.WHITE_YARNBALL, ModItems.LIGHT_GRAY_YARNBALL, Items.WHITE_DYE, group);
		//endregion
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBowlRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createBowlFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBoatRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem) {
		createBoatFormat(RecipeCategory.TRANSPORTATION, resultItem, 1, Ingredient.ofItems(inputItem))
				.group("boats")
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerChestBoatRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, resultItem)
				.input(Blocks.CHEST)
				.input(inputItem)
				.group("chest_boats")
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerDoubleColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerDoubleRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerFilledMinecartRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, resultItem)
				.input(inputItem)
				.input(Items.MINECART)
				.group("filled_minecarts")
				.criterion(hasItem(Items.MINECART), conditionsFromItem(Items.MINECART))
				.offerTo(exporter, idFromItem(resultItem));
		//TODO: Implement filled minecart separation crafting recipe.
		// - Output a the item contained within the filled minecart ('inputItem').
		// - Override the remainder of the filled minecart to be an empty Minecart.
		// - Rename this method to 'offerFilledMinecartRecipeSet'.
	}
	
	
	public static void offerLargeRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		createLargeRowFormat(category, resultItem, count, Ingredient.fromTag(inputItemTag))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerLargeRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerLargeRowSandwichRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, TagKey<Item> topAndBottomItemTag, String topAndBottomTagString,
			String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem, count)
				.input('#', topAndBottomItemTag)
				.input('O', centralItem)
				.pattern("###")
				.pattern("OOO")
				.pattern("###")
				.group(group)
				.criterion(topAndBottomTagString, conditionsFromTag(topAndBottomItemTag))
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerLargeRowSandwichRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, ItemConvertible topAndBottomItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem, count)
				.input('#', topAndBottomItem)
				.input('O', centralItem)
				.pattern("###")
				.pattern("OOO")
				.pattern("###")
				.group(group)
				.criterion(hasItem(topAndBottomItem), conditionsFromItem(topAndBottomItem))
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerLargeStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSmallColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSmallRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSmallSquareRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallSquareFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSmallStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerStairBlockOfLargeShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeStairFormat(RecipeCategory.BUILDING_BLOCKS, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSlabBlockOfLargeShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, resultItem)
				.input('#', inputItem)
				.pattern("##")
				.pattern("##")
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSlabBlockOfSmallShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		offerSlabBlockOfSmallShapeRecipe(exporter, resultItem, 1, inputItem, idSuffix, group);
	}
	
	public static void offerSlabBlockOfSmallShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallRowFormat(RecipeCategory.BUILDING_BLOCKS, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerStairBlockOfSmallShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		offerStairBlockOfSmallShapeRecipe(exporter, resultItem, 1, inputItem, idSuffix, group);
	}
	
	public static void offerStairBlockOfSmallShapeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallStairFormat(RecipeCategory.BUILDING_BLOCKS, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Handheld Container Items ##
	public static void offerBowlOfSoupRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible mainItem,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, resultItem)
				.input(mainItem, 3)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.group(group)
				.criterion(hasItem(mainItem), conditionsFromItem(mainItem))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBowlOfStewRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible meatItem
	) {
		ItemConvertible carrotItem = ModItems.BAKED_CARROT;
		ItemConvertible potatoItem = Items.BAKED_POTATO;
		ItemConvertible mushroomItem = ModItems.BAKED_MUSHROOM;
		ItemConvertible emptyBowlItem = Items.BOWL;
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, resultItem)
				.input(meatItem)
				.input(carrotItem).input(potatoItem).input(mushroomItem)
				.input(emptyBowlItem)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.criterion(hasItem(meatItem), conditionsFromItem(meatItem))
				.criterion(hasItem(carrotItem), conditionsFromItem(carrotItem))
				.criterion(hasItem(potatoItem), conditionsFromItem(potatoItem))
				.criterion(hasItem(mushroomItem), conditionsFromItem(mushroomItem))
				.criterion(hasItem(emptyBowlItem), conditionsFromItem(emptyBowlItem))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerOldBowlOfStewRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible mainItem,
			ItemConvertible mushroomItem, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, resultItem)
				.input(mainItem)
				.input(ModItems.BAKED_CARROT)
				.input(Items.BAKED_POTATO)
				.input(mushroomItem)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.group(group)
				.criterion(hasItem(mainItem), conditionsFromItem(mainItem))
				.criterion(hasItem(ModItems.BAKED_CARROT), conditionsFromItem(ModItems.BAKED_CARROT))
				.criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
				.criterion(hasItem(mushroomItem), conditionsFromItem(mushroomItem))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(resultItem, fromItem(mushroomItem)));
	}
	//endregion
	
	//region ## Recipe Offers - Decoration & Utility ##
	public static void offerArmorTrimSmithingRecipe(RecipeExporter exporter, Item templateItem, Identifier recipeId) {
		SmithingTrimRecipeJsonBuilder.create(
						Ingredient.ofItems(templateItem),
						Ingredient.fromTag(ItemTags.TRIMMABLE_ARMOR),
						Ingredient.fromTag(ItemTags.TRIM_MATERIALS),
						RecipeCategory.MISC)
				.criterion("has_armor_trim_smithing_template", conditionsFromItem(templateItem))
				.offerTo(exporter, recipeId);
	}
	
	
	public static void offerBannerRecipe(RecipeExporter exporter, ItemConvertible bannerResult, ItemConvertible yarnRollItem) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, bannerResult)
				.input('/', Items.STICK)
				.input('#', yarnRollItem)
				.input('@', Items.STRING)
				.pattern("/#/")
				.pattern("@#@")
				.pattern(" / ")
				.group("banners")
				.criterion(hasItem(yarnRollItem), conditionsFromItem(yarnRollItem))
				.offerTo(exporter, idFromItem(bannerResult));
	}
	
	
	public static void offerBannerPatternRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible altInputItemA, ItemConvertible altInputItemB
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
				.input(Items.PAPER)
				.input(Items.FEATHER)
				.input(Items.INK_SAC)
				.input(Ingredient.ofItems(altInputItemA, altInputItemB))
				.group("banner_patterns")
				.criterion(hasItem(altInputItemA), conditionsFromItem(altInputItemA))
				.criterion(hasItem(altInputItemB), conditionsFromItem(altInputItemB))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	public static void offerBannerPatternRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
				.input(Items.PAPER)
				.input(inputItem)
				.group("banner_patterns")
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerBedOfPigmentRecipe(
			RecipeExporter exporter, ItemConvertible bedResult,
			ItemConvertible pigmentedYarnRollItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, bedResult)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WHITE_YARN_ROLL)
				.input('O', pigmentedYarnRollItem)
				.pattern("OOX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WHITE_YARN_ROLL), conditionsFromItem(ModItems.WHITE_YARN_ROLL))
				.criterion(hasItem(pigmentedYarnRollItem), conditionsFromItem(pigmentedYarnRollItem))
				.offerTo(exporter, idFromItem(bedResult, idSuffix));
	}
	
	
	public static void offerBedOfWhiteRecipe(
			RecipeExporter exporter, ItemConvertible bedResult, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, bedResult)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WHITE_YARN_ROLL)
				.pattern("XXX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WHITE_YARN_ROLL), conditionsFromItem(ModItems.WHITE_YARN_ROLL))
				.offerTo(exporter, idFromItem(bedResult, idSuffix));
	}
	
	
	public static void offerCandleRecipe(
			RecipeExporter exporter, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CANDLE)
				.input('#', Items.HONEYCOMB)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("O")
				.pattern("#")
				.group(null)
				.criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(Items.CANDLE, idSuffix));
	}
	
	
	public static void offerCandleOfPigmentRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible pigmentItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
				.input('#', Items.HONEYCOMB)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.input('@', pigmentItem)
				.pattern("O ")
				.pattern("#@")
				.group("dyed_candles")
				.criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(pigmentItem), conditionsFromItem(pigmentItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerDoorRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, resultItem)
				.input('#', inputItem)
				.input('O', ModItems.IRON_GRAM)
				.pattern("O##")
				.pattern("O##")
				.pattern("O##")
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerHatchRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, resultItem)
				.input('#', inputItem)
				.input('O', ModItems.IRON_GRAM)
				.pattern("O O")
				.pattern("###")
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerRedstoneButtonRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstoneButtonFormat(RecipeCategory.REDSTONE, resultItem, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerRedstonePressurePlateRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstonePressurePlateFormat(RecipeCategory.REDSTONE, resultItem, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerSmithingTemplateDuplicationRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseMaterialItem, ItemConvertible extraAlternativeItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem, 2)
				.input('#', resultItem)
				.input('X', Items.DIAMOND)
				.input('-', Ingredient.ofItems(Items.EMERALD, extraAlternativeItem))
				.input('O', baseMaterialItem)
				.pattern("-X-")
				.pattern("-O-")
				.pattern("-#-")
				.group("smithing_templates")
				.criterion(hasItem(resultItem), conditionsFromItem(resultItem))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
				.criterion(hasItem(baseMaterialItem), conditionsFromItem(baseMaterialItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	public static void offerSmithingTemplateDuplicationRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseMaterialItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem, 2)
				.input('#', resultItem)
				.input('X', Items.DIAMOND)
				.input('-', Items.EMERALD)
				.input('O', baseMaterialItem)
				.pattern("-X-")
				.pattern("-O-")
				.pattern("-#-")
				.group("smithing_templates")
				.criterion(hasItem(resultItem), conditionsFromItem(resultItem))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
				.criterion(hasItem(baseMaterialItem), conditionsFromItem(baseMaterialItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	//endregion
	
	
	//region ## Recipe Offers - Equipment ##
	public static void offerBasicAxeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("##")
				.pattern(" X")
				.pattern(" X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicDaggerRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.group(group)
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBasicDaggerRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicHatchetRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X")
				.pattern(" X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicHoeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X")
				.pattern(" X")
				.pattern(" X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicLanceRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible ingotItem, ItemConvertible gramItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', ingotItem)
				.input('-', gramItem)
				.input('/', Items.STICK)
				.pattern(" -#")
				.pattern(" /-")
				.pattern("/  ")
				.group(group)
				.criterion(hasItem(ingotItem), conditionsFromItem(ingotItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicMalletRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern(" # ")
				.pattern(" X#")
				.pattern("X  ")
				.group(group)
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBasicMalletRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern(" # ")
				.pattern(" X#")
				.pattern("X  ")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicPickaxeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#X#")
				.pattern(" X ")
				.pattern(" X ")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicShovelRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.pattern("X")
				.group(group)
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBasicShovelRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.pattern("X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicSpearRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("  #")
				.pattern(" X ")
				.pattern("X  ")
				.group(group)
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBasicSpearRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("  #")
				.pattern(" X ")
				.pattern("X  ")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBasicSwordRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.group(group)
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerBasicSwordRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerBrushRecipe(RecipeExporter exporter, ItemConvertible resultItem) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', Items.FEATHER)
				.input('X', Items.STICK)
				.input('O', ModItems.COPPER_GRAM)
				.pattern(" ##")
				.pattern(" O#")
				.pattern("X  ")
				.criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(ModItems.COPPER_GRAM), conditionsFromItem(ModItems.COPPER_GRAM))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerCrossbowRecipe(RecipeExporter exporter, ItemConvertible ingotItem, @Nullable String group) {
		ItemConvertible resultItem = Items.CROSSBOW;
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', ModItems.WOODEN_STICK_BUNDLE)
				.input('/', Items.STICK)
				.input('~', Items.STRING)
				.input('O', ingotItem)
				.pattern("///")
				.pattern("~O~")
				.pattern(" # ")
				.group(group)
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion(hasItem(ingotItem), conditionsFromItem(ingotItem))
				.offerTo(exporter, idFromItem(resultItem, fromItem(ingotItem)));
	}
	
	
	public static void offerFishingRodRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible gramInputItem
	) {
		// Different types of fishing rods in future, for different metal types?
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('/', Items.STICK)
				.input('@', Items.STRING)
				.input('-', gramInputItem)
				.pattern("  /")
				.pattern(" /@")
				.pattern("/-@")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion(hasItem(gramInputItem), conditionsFromItem(gramInputItem))
				.offerTo(exporter, idFromItem(resultItem, fromItem(gramInputItem)));
	}
	
	
	public static void offerStringedDaggerRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("# ")
				.pattern("X@")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerStringedHatchetRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("#X")
				.pattern("@X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerStringedHoeRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("#X")
				.pattern("@X")
				.pattern(" X")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerStringedSpearRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible baseItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItem)
				.input('X', Items.STICK)
				.input('@', Items.STRING)
				.pattern("  #")
				.pattern(" X@")
				.pattern("X  ")
				.group(group)
				.criterion(hasItem(baseItem), conditionsFromItem(baseItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	//endregion
	
	
	//region ## Recipe Offers - Heating ##
	public static void offerBlastingRecipe(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int cookingTime,
			TagKey<Item> inputItemTag, String hasTagString, String fromTagString, float experience
	) {
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, experience, cookingTime,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "blasting"));
	}
	
	
	public static void offerBlastingAndSmeltingRecipeSet(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience, @Nullable String group
	) {
		// Blasting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "blasting"));
		
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 4,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
	}
	
	
	public static void offerBlastingAndSmeltingAndCampfireRecipeSet(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience, @Nullable String group
	) {
		// Blasting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "blasting"));
		
		// Smelting recipe; 2x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 4,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
		
		// Campfire cooking recipe; 4x experience, 6x duration.
		offerCampfireCookingRecipe(exporter, recipeCategory, resultItem, baseCookingTime * 6,
				inputItem, baseExperience * 4, group);
		// Replaced with method call. TODO: Do this for other instances; call a method instead of manually constructing a new smelting/blasting/campfire recipe.
//		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
//						resultItem, baseExperience * 4, baseCookingTime * 6,
//						RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
//				.group(group)
//				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
//				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
	}
	
	
	public static void offerCampfireCookingRecipe(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int cookingTime,
			ItemConvertible inputItem, float experience, @Nullable String group
	) {
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, experience, cookingTime,
						RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
	}
	
	
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
	
	
	public static void offerSmeltingAndBlastingForMetalRecipes(
			RecipeExporter exporter, ItemConvertible gramItem, ItemConvertible ingotItem, int baseCookingTime,
			ItemConvertible nuggetItem, ItemConvertible lumpItem, float baseExperience
	) {
		// Blasting nugget to gram; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(nuggetItem), RecipeCategory.MISC,
						gramItem, baseExperience, baseCookingTime,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasItem(nuggetItem), conditionsFromItem(nuggetItem))
				.offerTo(exporter, getCookingId(gramItem, nuggetItem, "blasting"));
		
		// Smelting nugget to gram; 4x experience, 8x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(nuggetItem), RecipeCategory.MISC,
						gramItem, baseExperience * 4, baseCookingTime * 8,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(nuggetItem), conditionsFromItem(nuggetItem))
				.offerTo(exporter, getCookingId(gramItem, nuggetItem, "smelting"));
		
		// Blasting lump to ingot; 5x experience, 4x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(lumpItem), RecipeCategory.MISC,
						ingotItem, baseExperience * 5, baseCookingTime * 4,
						RecipeSerializer.BLASTING, BlastingRecipe::new)
				.criterion(hasItem(lumpItem), conditionsFromItem(lumpItem))
				.offerTo(exporter, getCookingId(ingotItem, lumpItem, "blasting"));
		
		// Smelting lump to ingot; 20x experience, 24x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(lumpItem), RecipeCategory.MISC,
						ingotItem, baseExperience * 20, baseCookingTime * 24,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(lumpItem), conditionsFromItem(lumpItem))
				.offerTo(exporter, getCookingId(ingotItem, lumpItem, "smelting"));
	}
	
	
	public static void offerSmeltingAndCampfireRecipeSet(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience, @Nullable String group
	) {
		// Smelting recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
		
		// Campfire cooking recipe; 2x experience, 3x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 3,
						RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
	}
	
	
	public static void offerSmeltingAndSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			TagKey<Item> inputItemTag, String hasTagString, String fromTagString, float baseExperience, @Nullable String group
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.SMOKING, SmokingRecipe::new)
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "smoking"));
		
		// Smelting recipe; 2x experience, 2x duration.
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 2,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "smelting"));
		
		// Campfire cooking recipe; 4x experience, 6x duration.
		CookingRecipeJsonBuilder.create(Ingredient.fromTag(inputItemTag), recipeCategory,
						resultItem, baseExperience * 4, baseCookingTime * 6,
						RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, getCookingId(resultItem, fromTagString, "campfire_cooking"));
	}
	
	public static void offerSmeltingAndSmokingAndCampfireRecipes(
			RecipeExporter exporter, RecipeCategory recipeCategory, ItemConvertible resultItem, int baseCookingTime,
			ItemConvertible inputItem, float baseExperience, @Nullable String group
	) {
		// Smoking recipe; 1x experience, 1x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience, baseCookingTime,
						RecipeSerializer.SMOKING, SmokingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smoking"));
		
		// Smelting recipe; 2x experience, 2x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience * 2, baseCookingTime * 2,
						RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
		
		// Campfire cooking recipe; 4x experience, 6x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
						resultItem, baseExperience * 4, baseCookingTime * 6,
						RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "campfire_cooking"));
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
		
		// Smelting recipe; 2x experience, 2x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 2, baseCookingTime * 2,
				RecipeSerializer.SMELTING, SmeltingRecipe::new)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, getCookingId(resultItem, inputItem, "smelting"));
		
		// Campfire cooking recipe; 4x experience, 6x duration.
		CookingRecipeJsonBuilder.create(Ingredient.ofItems(inputItem), recipeCategory,
				resultItem, baseExperience * 4, baseCookingTime * 6,
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(itemA, idSuffixA));
		// Item B from item A.
		ShapelessRecipeJsonBuilder.create(categoryB, itemB)
				.input(itemA)
				.group(groupB)
				.criterion(hasItem(itemA), conditionsFromItem(itemA))
				.offerTo(exporter, idFromItem(itemB, idSuffixB));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
	}
	
	
	public static void offerYarnRollRecipes(RecipeExporter exporter, ItemConvertible yarnRollItem, ItemConvertible yarnballItem) {
		// Compacting.
		createSmallSquareFormat(RecipeCategory.MISC, yarnRollItem, Ingredient.ofItems(yarnballItem))
				.group("yarn_rolls")
				.criterion(hasItem(yarnballItem), conditionsFromItem(yarnballItem))
				.offerTo(exporter, idFromItem(yarnRollItem));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, yarnballItem, 4)
				.input(yarnRollItem)
				.group("yarn_roll_dismantling")
				.criterion(hasItem(yarnRollItem), conditionsFromItem(yarnRollItem))
				.offerTo(exporter, idFromItem(yarnballItem, "_from_roll"));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerTwoIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, TagKey<Item> inputItemBTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		createTwoIntoOneFormat(category, resultItem, count, Ingredient.fromTag(inputItemBTag), Ingredient.ofItems(inputItemA))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemBTag))
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerTwoIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createTwoIntoOneFormat(category, resultItem, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerTwoIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createTwoIntoOneFormat(category, resultItem, count, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerShapelessThreeIntoOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, TagKey<Item> inputItemCTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemA).input(inputItemB).input(inputItemCTag)
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.criterion(hasTagString, conditionsFromTag(inputItemCTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Shapeless (# Multi-quantified) ##
	public static void offerShapelessTwoAndOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createShapelessTwoAndOneFormat(category, resultItem, count, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerShapelessThreeAndOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemATag, String hasTagString, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createShapelessThreeAndOneFormat(category, resultItem, count, Ingredient.fromTag(inputItemATag), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemATag))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerShapelessThreeAndOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItemA, ItemConvertible inputItemB, String idSuffix, @Nullable String group
	) {
		createShapelessThreeAndOneFormat(category, resultItem, count, Ingredient.ofItems(inputItemA), Ingredient.ofItems(inputItemB))
				.group(group)
				.criterion(hasItem(inputItemA), conditionsFromItem(inputItemA))
				.criterion(hasItem(inputItemB), conditionsFromItem(inputItemB))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Shapeless (miscellaneous) ##
	public static void offerBasicYarnballDyingRecipe(
			RecipeExporter exporter, ItemConvertible outputYarnballItem, ItemConvertible inputYarnballItem,
			ItemConvertible dyeItem, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, outputYarnballItem)
				.input(inputYarnballItem)
				.input(dyeItem)
				.group(group)
				.criterion(hasItem(inputYarnballItem), conditionsFromItem(inputYarnballItem))
				.criterion(hasItem(dyeItem), conditionsFromItem(dyeItem))
				.offerTo(exporter, idFromItem(outputYarnballItem, fromItem(dyeItem)));
	}
	
	
	public static void offerBasicYarnballDyingFromWhiteRecipe(
			RecipeExporter exporter, ItemConvertible yarnballItem, ItemConvertible dyeItem, @Nullable String group
	) {
		offerBasicYarnballDyingRecipe(exporter, yarnballItem, ModItems.WHITE_YARNBALL, dyeItem, group);
	}
	
	
	public static void offerShapelessFourAndFourCheckeredAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, TagKey<Item> orthogonalItemTag, String hasTagString,
			ItemConvertible diagonalItem, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(diagonalItem).input(orthogonalItemTag).input(diagonalItem)
				.input(orthogonalItemTag).input(centralItem).input(orthogonalItemTag)
				.input(diagonalItem).input(orthogonalItemTag).input(diagonalItem)
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasTagString, conditionsFromTag(orthogonalItemTag))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	//endregion
	
	
	//region ## Recipe Offers - Miscellaneous ##
	public static void offerBlockOfEightRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(RecipeCategory.BUILDING_BLOCKS, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerCheckeredRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> orthogonalItemTag, String hasTagString, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createCheckeredFormat(category, resultItem, count,
				Ingredient.fromTag(orthogonalItemTag), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(orthogonalItemTag))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerCheckeredRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible orthogonalItem, TagKey<Item> diagonalItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createCheckeredFormat(category, resultItem, count,
				Ingredient.ofItems(orthogonalItem), Ingredient.fromTag(diagonalItemTag))
				.group(group)
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasTagString, conditionsFromTag(diagonalItemTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(category, resultItem, count, Ingredient.fromTag(inputItemTag))
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		offerCompactingEightRecipe(exporter, category, resultItem, 1, inputItem, idSuffix, group);
	}
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerConcretePowderBlockRecipe(
			RecipeExporter exporter, ItemConvertible concretePowderBlock, ItemConvertible dyeItem
	) {
		TagKey<Item> sandItemTag = Tags.Item.ALL_GLASSY_SAND_PILES;
		ItemConvertible gravelItem = ModItems.GRAVEL_PILE;
		ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, concretePowderBlock)
				.input(gravelItem).input(sandItemTag).input(gravelItem)
				.input(sandItemTag).input(dyeItem).input(sandItemTag)
				.input(gravelItem).input(sandItemTag).input(gravelItem)
				.group("concrete_powder_blocks")
				.criterion(hasItem(dyeItem), conditionsFromItem(dyeItem))
				.criterion("has_any_glassy_sand_pile", conditionsFromTag(sandItemTag))
				.criterion(hasItem(gravelItem), conditionsFromItem(gravelItem))
				.offerTo(exporter, idFromItem(concretePowderBlock));
	}
	
	
	public static void offerEightAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> centralItemTag, String hasCentralTagString, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createEightAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(surroundingItem), Ingredient.fromTag(centralItemTag))
				.group(group)
				.criterion(hasCentralTagString, conditionsFromTag(centralItemTag))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerEightAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		offerEightAroundOneRecipe(exporter, category, resultItem, 1, centralItem, surroundingItem, idSuffix, group);
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerItemWithFertilizerBucketRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		//TODO: Implement a complex/special recipe type for handling this type of recipe.
		// - Bucket of Fertilizer (BoF) on bottom, other ingredient item on top.
		// - Only 1 durability point is consumed from BoF.
		//  - BoF converts to its default ingredient remainder at 0 durability.
		// - To use individual JSON files, which simply define the ingredient (beside BoF), output, and output quantity.
		offerOneAtopAnotherRecipe(exporter, category, resultItem, 1, inputItem, ModItems.BUCKET_OF_FERTILIZER, idSuffix, group);
	}
	
	
	public static void offerFourAndFourCheckeredAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, TagKey<Item> orthogonalItemTag, String hasTagString,
			ItemConvertible diagonalItem, String idSuffix, @Nullable String group
	) {
		createFourAndFourCheckeredAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.fromTag(orthogonalItemTag), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasTagString, conditionsFromTag(orthogonalItemTag))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerFourAndFourCheckeredAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible centralItem, ItemConvertible orthogonalItem, ItemConvertible diagonalItem,
			String idSuffix, @Nullable String group
	) {
		createFourAndFourCheckeredAroundOneFormat(category, resultItem,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(orthogonalItem), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(orthogonalItem), conditionsFromItem(orthogonalItem))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerFourDiagonallyAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createFourDiagonallyAroundOneFormat(category, resultItem,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(surroundingItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerFourOrthogonallyAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible centralItem, TagKey<Item> surroundingItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createFourOrthogonallyAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.fromTag(surroundingItemTag))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasTagString, conditionsFromTag(surroundingItemTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerFourOrthogonallyAroundOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible centralItem, ItemConvertible surroundingItem,
			String idSuffix, @Nullable String group
	) {
		createFourOrthogonallyAroundOneFormat(category, resultItem,
				Ingredient.ofItems(centralItem), Ingredient.ofItems(surroundingItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasItem(surroundingItem), conditionsFromItem(surroundingItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerGlazedTerracottaRecipeSet(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem
	) {
		offerBlastingAndSmeltingRecipeSet(exporter, RecipeCategory.BUILDING_BLOCKS, resultItem,
				50, inputItem, 0.125F, "glazed_terracotta_chunks");
	}
	
	
	public static void offerOneAtopAnotherRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible topItem, ItemConvertible bottomItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem, count)
				.input('X', topItem)
				.input('O', bottomItem)
				.pattern("X")
				.pattern("O")
				.group(group)
				.criterion(hasItem(topItem), conditionsFromItem(topItem))
				.criterion(hasItem(bottomItem), conditionsFromItem(bottomItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			TagKey<Item> inputItemTag, String hasTagString, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItemTag)
				.group(group)
				.criterion(hasTagString, conditionsFromTag(inputItemTag))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem)
				.input(inputItem)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	public static void offerOneToOneRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(category, resultItem, count)
				.input(inputItem)
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
	}
	
	
	public static void offerStainedGlassBlockRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem
	) {
		offerBlockOfEightRecipe(exporter, resultItem, inputItem, "", "stained_glass_blocks");
	}
	
	
	public static void offerStainedGlassPaneRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible dyeInputItem
	) {
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, resultItem, 1,
				ModItems.CLEAR_GLASS_PANE, dyeInputItem, "", "glass_pane_staining");
	}
	
	
	public static void offerStainedTerracottaRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible dyeInputItem
	) {
		//TODO: Use Terracotta Chunk instead of block upon implementation.
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, resultItem, 1,
				Blocks.TERRACOTTA, dyeInputItem, "", "terracotta_staining");
	}
	
	
	public static void offerSawmillRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem
	) {
		SingleItemRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(inputItem), category, resultItem, count)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, convertBetween(resultItem, inputItem) + "_stonecutting");
	}
	
	
	public static void offerTorchOfStrongBinderRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, TagKey<Item> flammableInputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createTorchOfStrongBinderFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.fromTag(flammableInputItemTag))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasTagString, conditionsFromTag(flammableInputItemTag))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(resultItem, idSuffix + "_from_strong_binder"));
	}
	
	public static void offerTorchOfStrongBinderRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, ItemConvertible flammableInputItem, String idSuffix, @Nullable String group
	) {
		createTorchOfStrongBinderFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.ofItems(flammableInputItem))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasItem(flammableInputItem), conditionsFromItem(flammableInputItem))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(resultItem, idSuffix + "_from_strong_binder"));
	}
	
	
	public static void offerTorchOfWeakBinderRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, TagKey<Item> flammableInputItemTag, String hasTagString,
			String idSuffix, @Nullable String group
	) {
		createTorchOfWeakBinderFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.fromTag(flammableInputItemTag))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasTagString, conditionsFromTag(flammableInputItemTag))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(resultItem, idSuffix + "_from_weak_binder"));
	}
	
	public static void offerTorchOfWeakBinderRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible shaftInputItem, ItemConvertible flammableInputItem, String idSuffix, @Nullable String group
	) {
		createTorchOfWeakBinderFormat(
				category, resultItem, count, Ingredient.ofItems(shaftInputItem), Ingredient.ofItems(flammableInputItem))
				.group(group)
				.criterion(hasItem(shaftInputItem), conditionsFromItem(shaftInputItem))
				.criterion(hasItem(flammableInputItem), conditionsFromItem(flammableInputItem))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(resultItem, idSuffix + "_from_weak_binder"));
	}
	
	
	public static void offerWoodenFenceGateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, ItemConvertible plankItem
	) {
		ShapedRecipeJsonBuilder.create(category, resultItem)
				.input('#', plankItem)
				.input('-', ModItems.IRON_GRAM)
				.pattern("-#-")
				.pattern(" # ")
				.group("wooden_fence_gates")
				.criterion(hasItem(plankItem), conditionsFromItem(plankItem))
				.offerTo(exporter, idFromItem(resultItem));
	}
	
	
	public static void offerYarnBlockRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible inputItem
	) {
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, resultItem, inputItem, "", "yarn_blocks");
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
			RecipeCategory category, ItemConvertible output, Ingredient ingredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', ingredient)
				.pattern("##")
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
	
	
	public static CraftingRecipeJsonBuilder createShapelessTwoAndOneFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredientA, Ingredient ingredientB
	) {
		return ShapelessRecipeJsonBuilder.create(category, output, count)
				.input(ingredientA).input(ingredientA)
				.input(ingredientB);
	}
	
	
	public static CraftingRecipeJsonBuilder createShapelessThreeAndOneFormat(
			RecipeCategory category, ItemConvertible output, int count, Ingredient ingredientA, Ingredient ingredientB
	) {
		return ShapelessRecipeJsonBuilder.create(category, output, count)
				.input(ingredientA).input(ingredientA)
				.input(ingredientA).input(ingredientB);
	}
	
	
	public static CraftingRecipeJsonBuilder createTwoIntoOneFormat(
			RecipeCategory category, ItemConvertible output, Ingredient ingredientA, Ingredient ingredientB
	) {
		return ShapelessRecipeJsonBuilder.create(category, output)
				.input(ingredientA).input(ingredientB);
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
			RecipeCategory category, ItemConvertible output,
			Ingredient centralIngredient, Ingredient orthogonalIngredient, Ingredient diagonalIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', centralIngredient)
				.input('O', orthogonalIngredient)
				.input('X', diagonalIngredient)
				.pattern("XOX")
				.pattern("O#O")
				.pattern("XOX");
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
			RecipeCategory category, ItemConvertible output,
			Ingredient centralIngredient, Ingredient surroundingIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', centralIngredient)
				.input('X', surroundingIngredient)
				.pattern("X X")
				.pattern(" # ")
				.pattern("X X");
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
			RecipeCategory category, ItemConvertible output,
			Ingredient centralIngredient, Ingredient surroundingIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', centralIngredient)
				.input('O', surroundingIngredient)
				.pattern(" O ")
				.pattern("O#O")
				.pattern(" O ");
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
			RecipeCategory category, ItemConvertible output, Ingredient baseIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', baseIngredient)
				.input('X', Items.REDSTONE)
				.pattern("#")
				.pattern("X");
	}
	
	
	public static CraftingRecipeJsonBuilder createRedstonePressurePlateFormat(
			RecipeCategory category, ItemConvertible output, Ingredient baseIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output)
				.input('#', baseIngredient)
				.input('X', Items.REDSTONE)
				.pattern("##")
				.pattern("X ");
	}
	
	
	public static CraftingRecipeJsonBuilder createTorchOfStrongBinderFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient shaftIngredient, Ingredient flammableIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('/', shaftIngredient)
				.input('@', Ingredient.fromTag(Tags.Item.STRONG_TORCH_BINDERS))
				.input('X', flammableIngredient)
				.pattern("@X")
				.pattern("/ ");
	}
	
	
	public static CraftingRecipeJsonBuilder createTorchOfWeakBinderFormat(
			RecipeCategory category, ItemConvertible output, int count,
			Ingredient shaftIngredient, Ingredient flammableIngredient
	) {
		return ShapedRecipeJsonBuilder.create(category, output, count)
				.input('/', shaftIngredient)
				.input('@', Ingredient.fromTag(Tags.Item.WEAK_TORCH_BINDERS))
				.input('X', flammableIngredient)
				.pattern("@X")
				.pattern("/@");
	}
	//endregion
	
	//region ## Recipe Identifiers ##
	public static Identifier idFromItem(ItemConvertible item) {
		return new Identifier(getRecipeName(item));
	}
	
	public static Identifier idFromItem(ItemConvertible item, String suffix) {
		return new Identifier(getRecipeName(item) + suffix);
	}
	//endregion
}
