package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.datagen.recipe.BasicGridRecipeJsonBuilder;
import binarybolias.tercaphinom.recipe.BucketFertilizerTransfer;
import binarybolias.tercaphinom.recipe.SuspiciousStewRecipe;
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
				ModBlocks.COBBLED_STIEFANE_BLOCK, ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//endregion
		
		
		//region ### Basic Resource Recipes ###
		//## Resources with Basic Block Forms ##
		//# Ash #
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.LEAF_PILE, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.WOODEN_STICK_BUNDLE, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Tags.Item.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball",
				0.125F);
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BLOCK, 1, ModItems.ASH_PILE, "", null);
		//# Coal #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.COAL_BLOCK, 1, Items.COAL, "", null);
		//# Dirt #
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
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.DRIED_KELP_BLOCK, 1,
				Items.STRING, ModItems.DRY_KELP_BUNDLE, "", null);
		//# Wheat #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HAY_BLOCK, 1,
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
		//# Oak Sapling #
		offerItemWithFertilizerBucketRecipe(exporter, RecipeCategory.MISC, Items.OAK_SAPLING, Items.APPLE,
				fromItem(Items.APPLE), "saplings");
		
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
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.BONE_MEAL, 3, Items.BONE, "_from_bone", "bonemeal_ball");
		//# Charcoal #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.CHARCOAL, 400,
				Tags.Item.ALL_PLANKS, "has_any_plank", "_from_plank", 0.125F);
		//# Freeze Powder #
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.FREEZE_POWDER_PILE, 3, ModItems.FREEZE_ROD, "_from_rod", "elemental_rod_pulverizing");
		//# Honey #
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.HONEY_BLOCK, 1,
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.INFERNOCOAL_LUMP)));
		//# Slime #
		offerCompactingEightRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.SLIME_BLOCK, 1,
				Items.SLIME_BALL, "", null);
		//endregion
		
		
		//region ### Container Recipes (handheld) ###
		//## Bottle (empty) ##
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLASS_BOTTLE)
				.input('#', Items.GLASS_PANE)
				.input('/', Items.STICK)
				.pattern("/")
				.pattern("#")
				.group("empty_bottle")
				.criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(Items.GLASS_PANE, "_single"));
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GLASS_BOTTLE, 3)
				.input('#', Items.GLASS_PANE)
				.input('/', Items.STICK)
				.pattern(" / ")
				.pattern("# #")
				.pattern(" # ")
				.group("empty_bottle")
				.criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(Items.GLASS_PANE, "_triple"));
//		offerBowlRecipe(exporter,
//				RecipeCategory.MISC, Items.GLASS_BOTTLE, 3, Items.GLASS_PANE, "_triple", "empty_bottle");
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
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.CHEST, 1, Items.IRON_INGOT, Tags.Item.ALL_PLANKS,
				"has_any_plank", "", null);
		//# Ender Chest #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.ENDER_CHEST, 1,
				Items.ENDER_EYE, ModItems.OBSIDIAN_SHARD, "", null);
		//# Trapped Chest #
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.TRAPPED_CHEST, 1,
				Blocks.CHEST, Blocks.TRIPWIRE_HOOK, "", null);
		//endregion
		
		//region ## Equipment Recipes ##
		//# [tier 0] Sharp Wooden Stick #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHARP_WOODEN_STICK)
				.input(Items.STICK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(ModItems.SHARP_WOODEN_STICK));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARP_WOODEN_STICK)));
		//# [tier 1] Wood #
		offerBasicDaggerRecipe(exporter, ModItems.WOODEN_DAGGER, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicMalletRecipe(exporter, ModItems.WOODEN_MALLET, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicShovelRecipe(exporter, ModItems.WOODEN_SHOVEL, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicSpearRecipe(exporter, ModItems.WOODEN_SPEAR, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicSwordRecipe(exporter, ModItems.WOODEN_SWORD, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		//# [tier 2] Flint #
		offerPrimitiveShaftedToolRecipeSet(exporter, Items.FLINT, "flint",
				ModItems.FLINT_DAGGER, ModItems.FLINT_HATCHET, ModItems.FLINT_HOE, ModItems.FLINT_SPEAR);
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
		// (MA&T) Brush
		offerBrushRecipe(exporter, Items.BRUSH);
		// (MA&T) Clock
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.CLOCK, 1,
				Items.REDSTONE, ModItems.GOLD_GRAM, "", null);
		// (MA&T) Compass
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.COMPASS, 1,
				Items.REDSTONE, ModItems.IRON_GRAM, "", null);
		// (MA&T) Crossbow
		offerCrossbowRecipe(exporter, ModItems.BRASS_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.COPPER_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.GOLD_INGOT, "crossbow");
		offerCrossbowRecipe(exporter, Items.IRON_INGOT, "crossbow");
		// (MA&T) Fishing Rod
		offerFishingRodRecipe(exporter, Items.FISHING_ROD);
		// (MA&T) Leather Horse Armor
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.LEATHER_HORSE_ARMOR)
				.input('#', Items.LEATHER)
				.input('X', ItemTags.WOOL_CARPETS)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("#X#")
				.pattern("###")
				.pattern("#O#")
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.criterion("has_any_carpet", conditionsFromTag(ItemTags.WOOL_CARPETS))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, idFromItem(Items.LEATHER_HORSE_ARMOR));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.LEATHER_HORSE_ARMOR)));
		// (MA&T) Map
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.MAP, 1,
				Items.PAPER, Items.COMPASS, "", null);
		// (MA&T) Pair of Shears
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SHEARS)
				.input('#', ModItems.BRASS_GRAM)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X X")
				.pattern("X#X")
				.pattern("###")
				.criterion(hasItem(ModItems.BRASS_GRAM), conditionsFromItem(ModItems.BRASS_GRAM))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Items.SHEARS));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.SHEARS)));
		// (MA&T) Recovery Compass
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, Items.RECOVERY_COMPASS, 1,
				Items.COMPASS, Items.ECHO_SHARD, "", null);
		// (MA&T) Saddle
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
//				.offerTo(exporter, new Identifier(getRecipeName(Items.SADDLE)));
		// (MA&T) Shield
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SHIELD)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('O', Items.IRON_INGOT)
				.pattern("#O#")
				.pattern("###")
				.pattern(" # ")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Items.SHIELD));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.SHIELD)));
		offerOneToOneRecipe(exporter, RecipeCategory.TOOLS, Items.IRON_NUGGET, 1,
				Items.SHIELD, fromItem(Items.SHIELD) + "_recycling", "iron_equipment_recycling");
		// (MA&T) Spatial Recall Stone
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.SPATIAL_RECALL_STONE)));
		// (MA&T) Target Teleportation Tuner
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.TARGET_TELEPORTATION_TUNER)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOTTLE_OF_BRIMWATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_BRIMWATER)
				.input(ModItems.SULPHUR_LUMP)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_BRIMWATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOWL_OF_BRIMWATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_BRIMWATER)
				.input(ModItems.SULPHUR_LUMP).input(ModItems.SULPHUR_LUMP).input(ModItems.SULPHUR_LUMP)
				.input(Items.BUCKET)
				.input(ModItems.BUCKET_OF_STEAMING_WATER)
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(ModItems.BUCKET_OF_STEAMING_WATER), conditionsFromItem(ModItems.BUCKET_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_BRIMWATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BUCKET_OF_BRIMWATER)));
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOTTLE_OF_FREEZEWATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_FREEZEWATER)
				.input(ModItems.FREEZE_POWDER_PILE)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(ModItems.FREEZE_POWDER_PILE), conditionsFromItem(ModItems.FREEZE_POWDER_PILE))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_FREEZEWATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOWL_OF_FREEZEWATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_FREEZEWATER)
				.input(ModItems.FREEZE_POWDER_PILE).input(ModItems.FREEZE_POWDER_PILE).input(ModItems.FREEZE_POWDER_PILE)
				.input(Items.BUCKET)
				.input(Items.WATER_BUCKET)
				.criterion(hasItem(ModItems.FREEZE_POWDER_PILE), conditionsFromItem(ModItems.FREEZE_POWDER_PILE))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_FREEZEWATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BUCKET_OF_FREEZEWATER)));
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOTTLE_OF_STEAMING_WATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOWL_OF_STEAMING_WATER)
				.input(Items.BLAZE_POWDER)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.BOWL_OF_STEAMING_WATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOWL_OF_STEAMING_WATER)));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUCKET_OF_STEAMING_WATER)
				.input(Items.BLAZE_POWDER).input(Items.BLAZE_POWDER).input(Items.BLAZE_POWDER)
				.input(Items.BUCKET)
				.input(Items.WATER_BUCKET)
				.criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
				.criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
				.criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
				.offerTo(exporter, idFromItem(ModItems.BUCKET_OF_STEAMING_WATER));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BUCKET_OF_STEAMING_WATER)));
		
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
		// TODO: Test the functionality of using a potion as a recipe output.
		// NOTE: We should output a potion of water.
//		ComplexRecipeJsonBuilder.create();
//		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, )
//				.input(ModItems.BOWL_OF_WATER).input(Items.GLASS_BOTTLE);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.POTION, 1,
				ModItems.BOWL_OF_WATER, Items.GLASS_BOTTLE, "_from_bowl_transfer", "water_transfer");
		// NOTE: Potions are non-stackable, so only one Bottle of Water can be provided per bucket.
//		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, Items.POTION, 3,
//				Items.GLASS_BOTTLE, Items.WATER_BUCKET, "_from_bucket_transfer_into_three", "water_transfer");
//		offerShapelessTwoAndOneRecipe(exporter, RecipeCategory.MISC, Items.POTION, 2,
//				Items.GLASS_BOTTLE, Items.WATER_BUCKET, "_from_bucket_transfer_into_two", "water_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.POTION, 1,
				Items.GLASS_BOTTLE, Items.WATER_BUCKET, "_from_bucket_transfer_into_one", "water_transfer");
		// TODO: Test the functionality of using a potion as a basic crafting recipe ingredient.
		//  - Make the potion (of water) give a remainder of Empty Bottle.
		// NOTE: We should only allow potions of water; only cooking should allow for removing the potion effect.
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_WATER, 1,
				Items.POTION, Items.BOWL, "_from_bottle_transfer", "water_transfer");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, ModItems.BOWL_OF_WATER, 1,
				Items.BOWL, Items.WATER_BUCKET, "_from_bucket_transfer", "water_transfer");
		offerShapelessThreeAndOneRecipe(exporter, RecipeCategory.MISC, Items.WATER_BUCKET, 1,
				Tags.Item.SMALL_CONTAINERS_OF_WATER, "has_small_container_of_water", Items.BUCKET,
				"_from_small_container_transfer", "water_transfer");
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
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100, Tags.Item.COOKABLE_EGGS,
				"has_cookable_egg", "_from_cookable_egg", 0.125F, "fried_egg");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.FOOD, ModItems.FRIED_EGG, 100, Tags.Item.SPAWN_EGGS,
				"has_any_spawn_egg", "_from_spawn_egg", 0.125F, "fried_egg");
		
		//# (FoR) Bowl (soup) #
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_CARROT_SOUP, ModItems.BAKED_CARROT, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_KELP_SOUP, ModItems.DRY_KELP_BUNDLE, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_MUSHROOM_SOUP, ModItems.BAKED_MUSHROOM, "", null);
		offerBowlOfSoupRecipe(exporter, ModItems.BOWL_OF_PORRIDGE, Items.WHEAT, "", null);
		// Using new recipe type!
		//TODO: Check that this works.
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
				200, ModItems.RAW_APPLE_PIE, 1.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_APPLE_PIE)
				.input(Items.APPLE)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_APPLE_PIE));
		// Cherry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.CHERRY_PIE,
				200, ModItems.RAW_CHERRY_PIE, 1.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_CHERRY_PIE)
				.input(ModItems.CHERRY_BUNCH).input(ModItems.CHERRY_BUNCH).input(ModItems.CHERRY_BUNCH)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(ModItems.CHERRY_BUNCH), conditionsFromItem(ModItems.CHERRY_BUNCH))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_CHERRY_PIE));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_CHERRY_PIE)));
		// Glowberry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.GLOWBERRY_PIE,
				200, ModItems.RAW_GLOWBERRY_PIE, 1.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_GLOWBERRY_PIE)
				.input(Items.GLOW_BERRIES).input(Items.GLOW_BERRIES).input(Items.GLOW_BERRIES)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_GLOWBERRY_PIE));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_GLOWBERRY_PIE)));
		// Pumpkin Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.PUMPKIN_PIE,
				200, ModItems.RAW_PUMPKIN_PIE, 1.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_PUMPKIN_PIE)
				.input(Items.PUMPKIN)
				.input(Items.SUGAR)
				.input(Items.SUGAR)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.PUMPKIN), conditionsFromItem(Items.PUMPKIN))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_PUMPKIN_PIE));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PUMPKIN_PIE)));
		// Sweetberry Pie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SWEETBERRY_PIE,
				200, ModItems.RAW_SWEETBERRY_PIE, 1.0F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_SWEETBERRY_PIE)
				.input(Items.SWEET_BERRIES).input(Items.SWEET_BERRIES).input(Items.SWEET_BERRIES)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_SWEETBERRY_PIE));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_SWEETBERRY_PIE)));
		
		//# (FoR) Miscellaneous Pastries & Baked Foods #
		// Bread & Raw Dough
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.BREAD,
				200, ModItems.RAW_DOUGH_LUMP, 0.25F, null);
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_DOUGH_LUMP)
				.input('#', Items.WHEAT)
				.input('@', ModItems.BOWL_OF_WATER)
				.pattern("###")
				.pattern("###")
				.pattern(" @ ")
				.criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
				.criterion(hasItem(ModItems.BOWL_OF_WATER), conditionsFromItem(ModItems.BOWL_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.RAW_DOUGH_LUMP));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_DOUGH_LUMP)));
		ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_DOUGH_LUMP)
				.input('#', Items.WHEAT)
				.input('O', Items.EGG)
				.input('@', ModItems.BOWL_OF_WATER)
				.pattern("###")
				.pattern("O@O")
				.criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
				.criterion(hasItem(ModItems.BOWL_OF_WATER), conditionsFromItem(ModItems.BOWL_OF_WATER))
				.offerTo(exporter, idFromItem(ModItems.RAW_DOUGH_LUMP, "_from_eggs"));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_DOUGH_LUMP) + "_from_eggs"));
		// Cake
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.CAKE,
				400, ModItems.RAW_CAKE, 1.0F, null);
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_CAKE)));
		// Cookie
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, Items.COOKIE,
				100, ModItems.RAW_COOKIE_BALL, 0.125F, null);
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_COOKIE_BALL)));
		// Honeybun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.HONEYBUN,
				100, ModItems.RAW_HONEYBUN_BALL, 0.125F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_HONEYBUN_BALL, 4)
				.input(Items.HONEY_BOTTLE)
				.input(Items.HONEY_BOTTLE)
				.input(Items.HONEY_BOTTLE)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_HONEYBUN_BALL));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_HONEYBUN_BALL)));
		// Magmabun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.MAGMABUN,
				100, ModItems.RAW_MAGMABUN_BALL, 0.125F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_MAGMABUN_BALL, 4)
				.input(Items.MAGMA_CREAM)
				.input(Items.SUGAR)
				.input(Items.MAGMA_CREAM)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_MAGMABUN_BALL));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_MAGMABUN_BALL)));
		// Slimebun
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SLIMEBUN,
				100, ModItems.RAW_SLIMEBUN_BALL, 0.125F, null);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_SLIMEBUN_BALL, 4)
				.input(Items.SLIME_BALL)
				.input(Items.SUGAR)
				.input(Items.SLIME_BALL)
				.input(ModItems.RAW_DOUGH_LUMP)
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
				.criterion(hasItem(ModItems.RAW_DOUGH_LUMP), conditionsFromItem(ModItems.RAW_DOUGH_LUMP))
				.offerTo(exporter, idFromItem(ModItems.RAW_SLIMEBUN_BALL));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_SLIMEBUN_BALL)));
		
		//# (FoR) Rotten & Warped Flesh #
		// Rotten Flesh Chunk (from 1 meat item)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.ROTTEN_FLESH)
				.input(Ingredient.fromTag(Tags.Item.LARGE_ROTTABLE_MEATS))
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.group("meat_rotting")
				.criterion("has_large_rottable_meat", conditionsFromTag(Tags.Item.LARGE_ROTTABLE_MEATS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.ROTTEN_FLESH, "_from_large_rottable_meat"));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.ROTTEN_FLESH) + "_from_large_rottable_meat"));
		// Rotten Flesh Chunk (from 2 meat items)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Items.ROTTEN_FLESH)
				.input(Ingredient.fromTag(Tags.Item.SMALL_ROTTABLE_MEATS), 2)
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.group("meat_rotting")
				.criterion("has_small_rottable_meat", conditionsFromTag(Tags.Item.SMALL_ROTTABLE_MEATS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.ROTTEN_FLESH, "_from_small_rottable_meat"));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.ROTTEN_FLESH) + "_from_small_rottable_meat"));
		// Warped Flesh Chunk
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.FOOD, ModItems.WARPED_FLESH_CHUNK, 1,
				Items.ROTTEN_FLESH, Items.SUGAR, Items.WARPED_FUNGUS, "", null);
		//endregion
		
		//region ## Workstation Recipes (cooking) ##
		//# Blast Furnace #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('X', Items.IRON_INGOT)
				.input('@', ModItems.ASH_PILE)
				.pattern("XXX")
				.pattern("X@X")
				.pattern("###")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.offerTo(exporter, idFromItem(Blocks.BLAST_FURNACE));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BLAST_FURNACE)));
		//# Campfire (basic) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CAMPFIRE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', Tags.Item.BASIC_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_basic_flame_material", conditionsFromTag(Tags.Item.BASIC_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.CAMPFIRE));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CAMPFIRE)));
		//# Campfire (spirit) #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_CAMPFIRE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', Tags.Item.SPIRIT_FLAME_MATERIALS)
				.pattern("#X#")
				.pattern("#@#")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion("has_basic_flame_material", conditionsFromTag(Tags.Item.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.SOUL_CAMPFIRE));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_CAMPFIRE)));
		//# Furnace #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.FURNACE, 1, ModItems.ASH_PILE, Tags.Item.ALL_COBBLESTONES,
				"has_any_cobblestone", "", null);
		//# Smoker #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMOKER)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('@', ModItems.ASH_PILE)
				.pattern("X#X")
				.pattern("#@#")
				.pattern("X#X")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.offerTo(exporter, idFromItem(Blocks.SMOKER));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SMOKER)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.ANVIL)));
		//# Brewing Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BREWING_STAND)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('/', Items.BLAZE_ROD)
				.input('X', Items.IRON_INGOT)
				.input('O', Blocks.GLASS_PANE)
				.pattern("OXO")
				.pattern("X/X")
				.pattern("###")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter, idFromItem(Blocks.BREWING_STAND));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BREWING_STAND)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CARTOGRAPHY_TABLE)));
		//# Crafting Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("##")
				.pattern("XX")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, idFromItem(Blocks.CRAFTING_TABLE));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CRAFTING_TABLE)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.ENCHANTING_TABLE)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.FLETCHING_TABLE)));
		//# Grindstone #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.GRINDSTONE)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("X#X")
				.pattern("X@X")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, idFromItem(Blocks.GRINDSTONE));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.GRINDSTONE)));
		//# Lectern #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LECTERN)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.BOOK)
				.pattern("###")
				.pattern(" X ")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, idFromItem(Blocks.LECTERN));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LECTERN)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LOOM)));
		//# Sawmill #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.STONECUTTER)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('I', Items.IRON_INGOT)
				.input('@', Items.DIAMOND)
				.pattern(" @ ")
				.pattern("XIX")
				.pattern("###")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.offerTo(exporter, idFromItem(Blocks.STONECUTTER));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.STONECUTTER)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SMITHING_TABLE)));
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
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, ModItems.NUTRILLARN_COMPASS, 1,
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.ORB_OF_ZOT)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOWL_OF_OMNISTEW)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.BOWL_OF_STONE_SOUP)));
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.YELLOW_CHEESE_WEDGE) + "_from_cheese_wheel"));
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
//		offerEightAroundOneRecipe(exporter,
//				RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_NYLIUM, 1,
//				Blocks.NETHERRACK, Items.CRIMSON_FUNGUS, "", "covered_netherrack_blocks");
//		offerEightAroundOneRecipe(exporter,
//				RecipeCategory.BUILDING_BLOCKS, Blocks.CRIMSON_NYLIUM, 1,
//				Blocks.NETHERRACK, Items.NETHER_WART, "", "covered_netherrack_blocks");
		//# Grassy Dirt Block #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRASS_BLOCK, 1,
				Blocks.DIRT, Items.WHEAT_SEEDS, "", "covered_dirt_blocks");
		//# Mycelium Covered Dirt Block #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MYCELIUM, 1,
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
//		offerEightAroundOneRecipe(exporter,
//				RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_NYLIUM, 1,
//				Blocks.NETHERRACK, Items.WARPED_FUNGUS, "", "covered_netherrack_blocks");
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_NUTRILLARN_LUMP)));
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
				.offerTo(exporter, idFromItem(ModBlocks.HYPERSMOOTH_CREAMSTONE));
//				.offerTo(exporter, new Identifier(getRecipeName(ModBlocks.HYPERSMOOTH_CREAMSTONE)));
		// Ultrasmooth Stone
		offerSmeltingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ULTRASMOOTH_STONE, 400,
				Blocks.SMOOTH_STONE, 0.125F, null);
		//# Miscellaneous #
		// Cherry Jellyball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.FOOD, ModItems.CHERRY_JELLYBALL, 1,
				ModItems.CHERRY_BUNCH, ModItems.HONEYPOD, "", null);
		
		
		//region ## Miscellaneous Recipes ##
		
		//# Armor Stand #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ARMOR_STAND)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern(" X ")
				.pattern("XXX")
				.pattern(" # ")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, idFromItem(Items.ARMOR_STAND));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.ARMOR_STAND)));
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(Items.ARROW)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Items.SPECTRAL_ARROW)));
		
		//# Balls #
		// (balls) Cobweb Ball
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.COBWEB_BALL, 1, Items.GUNPOWDER, ModItems.SILK_WAD, "", null);
		// (balls) Magma Cream Ball
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_CREAM, 2)
				.input(Items.BLAZE_ROD).input(Items.SLIME_BALL)
				.input(Items.SLIME_BALL).input(ModItems.SULPHUR_LUMP)
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.offerTo(exporter, idFromItem(Items.MAGMA_CREAM));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.MAGMA_CREAM)));
		// (balls) Yarnballs (and String)
		// TODO: Figure out how to use an arbitrary list as a recipe criterion,
		//  then remove the yarnball dying item tags, and refine this set of recipes.
		//  - .criterion("has_yarnball_which_dyes_to_black", conditionsFromItemPredicates(new ItemPredicate()))
		offerYarnballDyingRecipeSet(exporter);
		//region Deprecated yarnball dying recipes.
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.BLACK_YARNBALL, 1,
//				Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_BLACK, "has_any_yarnball_which_dyes_to_black",
//				Items.BLACK_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.BLUE_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.BLUE_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.BROWN_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.BROWN_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.CYAN_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.CYAN_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.GRAY_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.GRAY_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.GRAY_YARNBALL, 1,
//				ModItems.BLACK_YARNBALL, Items.WHITE_DYE, "_from_black_yarnball", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.GREEN_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.GREEN_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.LIGHT_BLUE_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.LIGHT_BLUE_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.LIGHT_GRAY_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL, 1,
//				Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_LIGHT_GRAY, "has_any_yarnball_which_dyes_to_light_gray",
//				Items.WHITE_DYE, "_from_yarnballs_which_lighten_to_light_gray", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.LIME_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.LIME_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.MAGENTA_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.MAGENTA_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.ORANGE_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.ORANGE_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.PINK_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.PINK_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.PURPLE_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.PURPLE_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.RED_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.RED_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1,
//				ModItems.LIGHT_GRAY_YARNBALL, Items.WHITE_DYE, "", "yarnball_dying");
//		offerTwoIntoOneRecipe(exporter,
//				RecipeCategory.MISC, ModItems.YELLOW_YARNBALL, 1,
//				ModItems.WHITE_YARNBALL, Items.YELLOW_DYE, "", "yarnball_dying");
		//endregion
		offerDoubleRowRecipe(exporter,
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1, Items.STRING, "_from_string", null);
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 4,
				Tags.Item.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball", null);
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 1,
				ModItems.SILK_WAD, ModItems.SILK_WAD, "_from_silk", null);
		// TODO: Add Silk Wads from Spider Egg upon implementation.
		
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
				.offerTo(exporter, idFromItem(Blocks.BEACON));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BEACON)));
		
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
		
		//# Brick Block #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BRICKS, 1,
				Items.CLAY_BALL, Items.BRICK, "", null);
		
		//# Candle (basic) #
		offerCandleRecipe(exporter, "");
		//# Candle (pigmented) #
		offerCandleOfPigmentRecipe(exporter, Items.BLACK_CANDLE, Items.BLACK_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.BLUE_CANDLE, Items.BLUE_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.BROWN_CANDLE, Items.BROWN_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.CYAN_CANDLE, Items.CYAN_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.GRAY_CANDLE, Items.GRAY_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.GREEN_CANDLE, Items.GREEN_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.LIGHT_BLUE_CANDLE, Items.LIGHT_BLUE_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.LIGHT_GRAY_CANDLE, Items.LIGHT_GRAY_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.LIME_CANDLE, Items.LIME_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.MAGENTA_CANDLE, Items.MAGENTA_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.ORANGE_CANDLE, Items.ORANGE_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.PINK_CANDLE, Items.PINK_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.PURPLE_CANDLE, Items.PURPLE_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.RED_CANDLE, Items.RED_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.WHITE_CANDLE, Items.WHITE_DYE, "");
		offerCandleOfPigmentRecipe(exporter, Items.YELLOW_CANDLE, Items.YELLOW_DYE, "");
		
		//# Chain #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CHAIN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X")
				.pattern("#")
				.pattern("X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(Blocks.CHAIN));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CHAIN)));
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.IRON_GRAM, 8,
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.CHEESE_WHEEL)));
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
				.input('X', Tags.Item.DECOMPOSABLE_MATERIALS)
				.pattern("# #")
				.pattern("#X#")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion("has_decomposable_material", conditionsFromTag(Tags.Item.DECOMPOSABLE_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.COMPOSTER));
		
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
		
		//# Dry Grass Tuft #
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, ModItems.DRY_GRASS_TUFT,
				25, ModItems.LIVE_GRASS_TUFT, 0.0625F, "dry_grass_tuft");
		offerSmeltingAndSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, ModItems.DRY_GRASS_TUFT,
				25, Items.SEAGRASS, 0.0625F, "dry_grass_tuft");
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_paper"));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(Tags.Item.ALL_YARNBALLS)
				.input(Blocks.BAMBOO)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO)) // TODO: Replace with Dry Bamboo Stick upon implementation.
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, idFromItem(ModItems.DYNAMITE_STICK, "_from_bamboo"));
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_bamboo"));
		
		//# Elemental Blocks #
		// (EB) Bone
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BONE_BLOCK, 1, Items.BONE, "", null);
		// (EB) Obsidian
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN, 1, ModItems.OBSIDIAN_SHARD, "", null);
		// (EB) Wart - Crimson
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.NETHER_WART_BLOCK, 1,
				Items.CRIMSON_ROOTS, Items.NETHER_WART, "", null);
		// (EB) Wart - Warped
		offerEightAroundOneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Items.WARPED_WART_BLOCK, 1,
				Items.WARPED_ROOTS, Items.NETHER_SPROUTS, "", null);
		
		//# Ender Eye #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ENDER_EYE)
				.input(Items.ENDER_PEARL)
				.input(Items.MAGMA_CREAM).input(Items.MAGMA_CREAM)
				.input(Items.REDSTONE)
				.criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
				.criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Items.ENDER_EYE));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.ENDER_EYE)));
		
		//# Glass Shard #
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.GLASS_SHARD, 200,
				Tags.Item.ALL_GLASSY_SAND_PILES, "has_glassy_sand_pile",
				"_from_glassy_sand_pile", 0.125F);
		// (glass shard) Bottle recycling
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.GLASS_SHARD, 1, Items.GLASS_BOTTLE, "_from_bottle", null);
		
		//# Glass Blocks & Panes #
		// (glass) Clear Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS, 1, Blocks.GLASS_PANE, "", null);
		// (glass) Clear Pane
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.GLASS_PANE, 200, ModItems.GLASS_SHARD, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, Items.GLASS_PANE, 100, Items.GLASS_BOTTLE, 0.0625F);
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
				.offerTo(exporter, idFromItem(Blocks.LANTERN));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LANTERN)));
		// (lantern) Spirit
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SOUL_LANTERN)
				.input('#', Items.IRON_INGOT)
				.input('X', ModItems.IRON_GRAM)
				.input('O', Blocks.GLASS_PANE)
				.input('@', Tags.Item.SPIRIT_FLAME_MATERIALS)
				.pattern(" X ")
				.pattern("O@O")
				.pattern("X#X")
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.criterion("has_spirit_flame_material", conditionsFromTag(Tags.Item.SPIRIT_FLAME_MATERIALS))
				.offerTo(exporter, idFromItem(Blocks.SOUL_LANTERN));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_LANTERN)));
		
		//# Ladders #
		// (ladders) Wooden
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.LADDER)
				.input('#', Items.STICK)
				.input('X', Items.STRING)
				.pattern("#X#")
				.pattern("###")
				.pattern("#X#")
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
		offerSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, Items.LEATHER,
				400, Items.ROTTEN_FLESH, 0.125F);
		offerSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, Items.LEATHER,
				400, ModItems.WARPED_FLESH_CHUNK, 0.125F);
		
		//# Lodestone #
//		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.LODESTONE, 1,
//				Items.NETHERITE_INGOT, Tags.Item.ALL_BRICKS, "has_any_brick", "", null);
		offerFourAndFourCheckeredAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.LODESTONE, 1,
				Items.NETHERITE_INGOT, Tags.Item.ALL_BRICKS, "has_any_brick", Items.BLAZE_POWDER, "", null);
		
		//# Lumithite #
		// (lumithite) Chunk
		// (lumithite) Powder Pile
		offerSmeltingAndBlastingRecipes(exporter, RecipeCategory.MISC, Items.GLOWSTONE_DUST,
				400, Items.GLOW_BERRIES, 0.125F);
		
		//# Magma Block #
		offerCheckeredRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MAGMA_BLOCK, 1,
				Items.MAGMA_CREAM, Tags.Item.ALL_COBBLESTONES, "has_any_cobblestone",
				"", null);
		
		//# Melon #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Blocks.MELON, 1,
				Items.SUGAR, Items.MELON_SLICE,"", "");
		
		//# Metal (brass) #
		offerStandardMetalRecipeSet(exporter, ModItems.BRASS_GRAM, ModItems.BRASS_INGOT,
				ModItems.RAW_BRASS_LUMP, ModItems.RAW_BRASS_NUGGET, 100, 0.375F,
				ModBlocks.RAW_BRASS_BLOCK, ModBlocks.REFINED_BRASS_BLOCK);
		//# Metal (copper) #
		offerStandardMetalRecipeSet(exporter, ModItems.COPPER_GRAM, Items.COPPER_INGOT,
				Items.RAW_COPPER, ModItems.RAW_COPPER_NUGGET, 100, 0.25F,
				Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK);
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_BRASS_LUMP)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_EIDURIL_LUMP)));
		
		//# Metal & Wooden Panes #
		// (M&WP) Metal (brass)
		// (M&WP) Metal (copper)
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.IRON_BARS)));
		// (M&WP) Metal (netherite)
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
//				.offerTo(exporter, new Identifier(getRecipeName(ModItems.MINIWIZARD) + "_duplication"));
		
		//# Miscellaneous Redstone Devices #
		// (MRD) Daylight Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.QUARTZ)
				.input('O', Blocks.GLASS_PANE)
				.pattern("OOO")
				.pattern("XXX")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter, idFromItem(Blocks.DAYLIGHT_DETECTOR));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DAYLIGHT_DETECTOR)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DISPENSER)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DROPPER)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LEVER)));
		// (MRD) Piston
		ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.PISTON)
				.input('#', Tags.Item.ALL_COBBLESTONES)
				.input('X', Tags.Item.ALL_PLANKS)
				.input('@', Items.REDSTONE)
				.input('O', Items.IRON_INGOT)
				.pattern("XXX")
				.pattern("#O#")
				.pattern("#@#")
				.criterion("has_any_cobblestone", conditionsFromTag(Tags.Item.ALL_COBBLESTONES))
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.offerTo(exporter, idFromItem(Blocks.PISTON));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.PISTON)));
		// (MRD) Redstone Lamp
		// TODO: Replace glowstone block in recipe with Lumithite Chunk.
		offerFourAndFourCheckeredAroundOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.REDSTONE_LAMP, 1,
				Blocks.GLOWSTONE, Items.REDSTONE, Items.IRON_INGOT, "", null);
		// (MRD) Redstone Signal Comparator
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COMPARATOR)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('/', Blocks.REDSTONE_TORCH)
				.input('O', Items.REDSTONE)
				.input('X', Items.QUARTZ)
				.pattern(" / ")
				.pattern("/X/")
				.pattern("#O#")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
				.offerTo(exporter, idFromItem(Blocks.COMPARATOR));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.COMPARATOR)));
		// (MRD) Redstone Signal Repeater
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.REPEATER)
				.input('#', Tags.Item.ALL_BRICKS)
				.input('/', Blocks.REDSTONE_TORCH)
				.input('O', Items.REDSTONE)
				.pattern("/O/")
				.pattern("#O#")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.REPEATER));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.REPEATER)));
		// (MRD) Target Block
		offerFourAndFourCheckeredAroundOneRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.TARGET, 1, Blocks.HAY_BLOCK,
				Items.REDSTONE, Items.WHITE_DYE, "", null);
		// (MRD) Tripwire Hook
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Blocks.TRIPWIRE_HOOK)
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.TRIPWIRE_HOOK)));
		// (MRD) Weighted Pressure Plate (Heavy)
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Items.IRON_INGOT, "", null);
		// (MRD) Weighted Pressure Plate (Light)
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Items.GOLD_INGOT, "", null);
		
		//# Moss Block #
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
				.offerTo(exporter, idFromItem(Items.NAME_TAG));
//				.offerTo(exporter, new Identifier(getRecipeName(Items.NAME_TAG)));
		
		//# Painting #
		offerEightAroundOneRecipe(exporter, RecipeCategory.MISC, Items.PAINTING, 1,
				ItemTags.WOOL_CARPETS, "has_any_yarn_carpet", Items.STICK, "", null);
		
		//# Paper (production) #
		offerLargeRowRecipe(exporter,
				RecipeCategory.MISC, Items.PAPER, 1, Items.SUGAR_CANE, "", null);
		//# Paper (recycling) #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1, Items.MAP, Items.WHITE_DYE,
				"_from_map_recycling", "map_recycling");
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, Items.PAPER, 1, Items.FILLED_MAP, Items.WHITE_DYE,
				"_from_filled_map_recycling", "map_recycling");
		
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
				.offerTo(exporter, idFromItem(Blocks.RAIL));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.RAIL)));
		// Detector
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.DETECTOR_RAIL)
				.input('#', Blocks.RAIL)
				.input('X', Tags.Item.ALL_BRICKS)
				.input('@', Items.REDSTONE)
				.pattern("X")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(Blocks.DETECTOR_RAIL));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DETECTOR_RAIL)));
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
				.offerTo(exporter, idFromItem(Blocks.POWERED_RAIL));
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.POWERED_RAIL)));
		
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
//				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SCAFFOLDING)));
		
		//# Slime Ball #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SLIME_BALL)
				.input(Ingredient.fromTag(Tags.Item.ALL_YARNBALLS))
				.input(Ingredient.fromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(Items.SLIME_BALL));
		
		//# Snow #
		// (snow) Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.SNOW_BLOCK, 1,
				Blocks.SNOW, "", null);
		// (snow) Pile // Note: The canonical Block corresponding to the Snow Pile would be the "Snow Mound".
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, Blocks.SNOW, "", null,
				RecipeCategory.MISC, Items.SNOWBALL, "_from_pile", null);
		
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, blackDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem, 1,
				Items.CORNFLOWER, fromItem(Items.CORNFLOWER), blueDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem, 2,
				Items.LAPIS_LAZULI, Items.SLIME_BALL, fromItems(Items.LAPIS_LAZULI, Items.SLIME_BALL), blueDyeBlobGroup);
		offerShapelessThreeIntoOneRecipe(exporter, RecipeCategory.MISC, blueDyeBlobItem, 4,
				Items.LAPIS_LAZULI, Items.SLIME_BALL, ModItems.SULPHUR_LUMP,
				fromItems(Items.LAPIS_LAZULI, Items.SLIME_BALL, ModItems.SULPHUR_LUMP), blueDyeBlobGroup);
		//endregion
		//region # Brown Dye Blob #
		// from Cocoa Bean Pile
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, brownDyeBlobItem, 1,
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
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, greenDyeBlobItem, 1,
				ModItems.LIVE_GRASS_TUFT, Items.SLIME_BALL, fromItems(ModItems.LIVE_GRASS_TUFT, Items.SLIME_BALL), greenDyeBlobGroup);
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, greenDyeBlobItem, 2,
				ModItems.SULPHUR_LUMP, Items.SLIME_BALL, fromItems(ModItems.SULPHUR_LUMP, Items.SLIME_BALL), greenDyeBlobGroup);
		//endregion
		//region # Light Blue Dye Blob #
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, lightBlueDyeBlobItem, 2,
			blueDyeBlobItem, whiteDyeBlobItem, "_from_blue_and_white", lightBlueDyeBlobGroup);
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightBlueDyeBlobItem, 1,
				Items.BLUE_ORCHID, fromItem(Items.BLUE_ORCHID), lightBlueDyeBlobGroup);
		//endregion
		//region # Light Gray Dye Blob #
		// from Ash Pile & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem, 1,
				ModItems.ASH_PILE, Items.SLIME_BALL, fromItem(ModItems.ASH_PILE) + "_and_" + itemName(Items.SLIME_BALL), lightGrayDyeBlobGroup);
		// from Azure Bluet
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem, 1,
				Items.OXEYE_DAISY, fromItem(Items.OXEYE_DAISY), lightGrayDyeBlobGroup);
		// from White Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, lightGrayDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, magentaDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, orangeDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem, 1,
				Items.PINK_PETALS, fromItem(Items.PINK_PETALS), pinkDyeBlobGroup);
		// from Peony
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem, 2,
				Items.PEONY, fromItem(Items.PEONY), pinkDyeBlobGroup);
		// from Pink Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, pinkDyeBlobItem, 1,
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
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 200,
				Items.NETHER_WART, 0.25F, redDyeBlobGroup);
		// from Poppy
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 1,
				Items.POPPY, fromItem(Items.POPPY), redDyeBlobGroup);
		// from Radish
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 1,
				Items.BEETROOT, fromItem(Items.BEETROOT), redDyeBlobGroup);
		// from Red Tulip
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 1,
				Items.RED_TULIP, fromItem(Items.RED_TULIP), redDyeBlobGroup);
		// from Rose Bush
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, redDyeBlobItem, 2,
				Items.ROSE_BUSH, fromItem(Items.ROSE_BUSH), redDyeBlobGroup);
		//endregion
		//region # White Dye Blob #
		// from Bonemeal Ball & Brimwater
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, whiteDyeBlobItem)
				.input(Ingredient.ofItems(Items.BONE_MEAL))
				.input(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.group(whiteDyeBlobGroup)
				.criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
				.criterion("has_small_container_of_brimwater", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER))
				.offerTo(exporter, idFromItem(whiteDyeBlobItem, fromItem(Items.BONE_MEAL) + "_and_brimwater"));
		// from Lily of the Valley
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, whiteDyeBlobItem, 1,
				Items.LILY_OF_THE_VALLEY, fromItem(Items.LILY_OF_THE_VALLEY), whiteDyeBlobGroup);
		//endregion
		//region # Yellow Dye Blob #
		// from Bonemeal Ball & Slime Ball
		offerTwoIntoOneRecipe(exporter, RecipeCategory.MISC, yellowDyeBlobItem, 1,
				Items.BONE_MEAL, Items.SLIME_BALL, fromItem(Items.BONE_MEAL) + "_and_" + itemName(Items.SLIME_BALL), yellowDyeBlobGroup);
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, yellowDyeBlobItem, 1,
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
		offerOneToOneRecipe(exporter, RecipeCategory.MISC, yellowDyeBlobItem, 1,
				Items.SUNFLOWER, fromItem(Items.SUNFLOWER), yellowDyeBlobGroup);
		//endregion
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
			ItemConvertible woodenLog, // NOTE: Planks are not to be craftable from trunks.
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
//				.offerTo(exporter, new Identifier(getRecipeName(plankItem) + "_from_log"));
		// Plank Block
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, plankBlock, 1, plankItem, "", "plank_blocks");
		// Button
		offerRedstoneButtonRecipe(exporter,
				RecipeCategory.REDSTONE, button, plankItem, "", "wooden_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, pressurePlate, plankItem, "", "wooden_pressure_plates");
		// Door & Hatch
		offerDoorAndHatchRecipeSet(exporter, door, hatch, plankItem,
				"", "","wooden_doors", "wooden_hatches");
		// Fence Gate
		offerWoodenFenceGateRecipe(exporter,
				RecipeCategory.REDSTONE, fenceGate, 1, plankItem, "", "wooden_fence_gates");
		// Fence Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.DECORATIONS, fencePost, 1, plankItem, "", "wooden_fence_posts");
		// Plank Slab
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, plankSlab, 1, plankItem, "", "wooden_slabs");
		// Plank Stair
		offerLargeStairRecipe(exporter,
				RecipeCategory.DECORATIONS, plankStair, 1, plankItem, "", "wooden_stairs");
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
		// Brick Block
		offerSmallSquareRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickBlock, 1, brickItem, "", "brick_blocks");
		// Polished Block
		offerFourOrthogonallyAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, polishedBlock, 1,
				Items.BLAZE_POWDER, brickItem, "", "stone_polishing");
		// Button
		offerRedstoneButtonRecipe(exporter,
				RecipeCategory.REDSTONE, button, brickItem, "", "stone_buttons");
		// Pressure Plate
		offerRedstonePressurePlateRecipe(exporter,
				RecipeCategory.REDSTONE, pressurePlate, brickItem, "", "stone_pressure_plates");
		// Brick Wall Post
		offerSmallColumnRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickWallPost, 1, brickItem, "", "brick_wall_posts");
		// Brick Slab
		offerSmallRowRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickSlab, 1, brickItem, "", "brick_slabs");
		// Brick Stair
		offerSmallStairRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, brickStair, 1, brickItem, "", "brick_stairs");
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
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, bootPairItem, 1,
				Items.LEATHER_BOOTS, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, chestplateItem, 1,
				Items.LEATHER_CHESTPLATE, ingotItem, "", group);
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, helmetItem, 1,
				Items.LEATHER_HELMET, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, leggingPairItem, 1,
				Items.LEATHER_LEGGINGS, ingotItem, "", group);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, horseArmorItem, 1,
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
//				.offerTo(exporter, new Identifier(getRecipeName(standingSignItem)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(hangingSignItem)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerBowlRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createBowlFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBoatRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createBoatFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerDoubleColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerDoubleRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createDoubleRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerLargeRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerLargeStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createLargeStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallColumnRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallColumnFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallRowRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallRowFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallSquareRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallSquareFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerSmallStairRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createSmallStairFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	//region ## Recipe Offers - Handheld Container Items ##
	public static void offerBowlOfSoupRecipe(
			RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible mainItem,
			String idSuffix, @Nullable String group
	) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, resultItem)
//				.input(mainItem).input(mainItem).input(mainItem)
				.input(mainItem, 3)
				.input(Items.BOWL)
				.input(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.group(group)
				.criterion(hasItem(mainItem), conditionsFromItem(mainItem))
				.criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
				.criterion("has_small_container_of_steaming_water", conditionsFromTag(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + fromItem(mushroomItem)));
	}
	//endregion
	
	//region ## Recipe Offers - Decoration & Utility ##
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
//				.offerTo(exporter, new Identifier(getRecipeName(Items.CANDLE) + idSuffix));
	}
	
	
	public static void offerCandleOfPigmentRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			ItemConvertible pigmentItem, String idSuffix
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
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstoneButtonRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstoneButtonFormat(category, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstonePressurePlateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstonePressurePlateFormat(category, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBasicDaggerRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBasicMalletRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern(" # ")
				.pattern(" X#")
				.pattern("X  ")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBasicShovelRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.pattern("X")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBasicSpearRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("  #")
				.pattern(" X ")
				.pattern("X  ")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerBasicSwordRecipe(
			RecipeExporter exporter, ItemConvertible resultItem,
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem)) + fromItem(ingotItem));
	}
	
	
	public static void offerFishingRodRecipe(
			RecipeExporter exporter, ItemConvertible resultItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('/', Items.STICK)
				.input('~', Items.STRING)
				.input('@', Tags.Item.ALL_METAL_GRAMS)
				.pattern("  /")
				.pattern(" /~")
				.pattern("/@~")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion("has_any_metal_gram", conditionsFromTag(Tags.Item.ALL_METAL_GRAMS))
				.offerTo(exporter, idFromItem(resultItem));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 8)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 6)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(itemA) + idSuffixA));
		// Item B from item A.
		ShapelessRecipeJsonBuilder.create(categoryB, itemB)
				.input(itemA)
				.group(groupB)
				.criterion(hasItem(itemA), conditionsFromItem(itemA))
				.offerTo(exporter, idFromItem(itemB, idSuffixB));
//				.offerTo(exporter, new Identifier(getRecipeName(itemB) + idSuffixB));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 2)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
				.offerTo(exporter, idFromItem(compactItem, compactingIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(compactItem) + compactingIdSuffix));
		// Reverse.
		ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 3)
				.input(compactItem)
				.group(reverseGroup)
				.criterion(hasItem(compactItem), conditionsFromItem(compactItem))
				.offerTo(exporter, idFromItem(baseItem, reverseIdSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(baseItem) + reverseIdSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	//endregion
	
	
	//region ## Recipe Offers - Miscellaneous ##
	public static void offerBedOfPigmentRecipe(
			RecipeExporter exporter, ItemConvertible bedResult,
			ItemConvertible pigmentedCarpetItem, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, bedResult)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Blocks.WHITE_CARPET)
				.input('O', pigmentedCarpetItem)
				.pattern("OOX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
				.criterion(hasItem(pigmentedCarpetItem), conditionsFromItem(pigmentedCarpetItem))
				.offerTo(exporter, idFromItem(bedResult, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
	}
	
	
	public static void offerBedOfWhiteRecipe(
			RecipeExporter exporter, ItemConvertible bedResult, String idSuffix, @Nullable String group
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, bedResult)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Blocks.WHITE_CARPET)
				.pattern("XXX")
				.pattern("XXX")
				.pattern("###")
				.group(group)
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
				.offerTo(exporter, idFromItem(bedResult, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	public static void offerCompactingEightRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createCompactingEightFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(concretePowderBlock)));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix + "_from_strong_binder"));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix + "_from_strong_binder"));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix + "_from_weak_binder"));
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
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix + "_from_weak_binder"));
	}
	
	
	public static void offerWoodenFenceGateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem, int count,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createWoodenFenceGateFormat(category, resultItem, count, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, idFromItem(resultItem, idSuffix));
//				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
	
	//region ## Recipe Identifiers ##
	public static Identifier idFromItem(ItemConvertible item) {
		return new Identifier(getRecipeName(item));
	}
	
	public static Identifier idFromItem(ItemConvertible item, String suffix) {
		return new Identifier(getRecipeName(item) + suffix);
	}
	//endregion
}
