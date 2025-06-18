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
				ModItems.VERDAK_LOG, ModItems.VERDAK_PLANK, ModBlocks.VERDAK_PLANK_BLOCK,
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
				RecipeCategory.MISC, Items.BOWL, 2, Tags.Item.ALL_PLANKS,
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
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.input('O', Items.SLIME_BALL)
				.pattern("#X#")
				.pattern("#O#")
				.pattern("#X#")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BARREL)));
		//# Chest #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.CHEST, 1, Items.IRON_INGOT, Tags.Item.ALL_PLANKS,
				"has_any_plank", "", null);
		//# Ender Chest #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, Blocks.ENDER_CHEST, 1,
				Items.ENDER_EYE, ModItems.OBSIDIAN_SHARD, "", null);
		//endregion
		
		//region ## Equipment Recipes ##
		//# [tier 0] Sharp Wooden Stick #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHARP_WOODEN_STICK)
				.input(Items.STICK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARP_WOODEN_STICK)));
		//# [tier 1] Wood #
		offerBasicDaggerRecipe(exporter, ModItems.WOODEN_DAGGER, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicMalletRecipe(exporter, ModItems.WOODEN_MALLET, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicShovelRecipe(exporter, ModItems.WOODEN_SHOVEL, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicSpearRecipe(exporter, ModItems.WOODEN_SPEAR, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		offerBasicSwordRecipe(exporter, ModItems.WOODEN_SWORD, Tags.Item.ALL_PLANKS, "has_any_plank", "");
		//# [tier 2] Flint #
		offerPrimitiveShaftedToolRecipeSet(exporter, Items.FLINT,
				ModItems.FLINT_DAGGER, ModItems.FLINT_HATCHET, ModItems.FLINT_HOE, ModItems.FLINT_SPEAR);
		//# [tier 2] Glass #
		offerPrimitiveShaftedToolRecipeSet(exporter, ModItems.GLASS_SHARD,
				ModItems.GLASS_DAGGER, ModItems.GLASS_HATCHET, ModItems.GLASS_HOE, ModItems.GLASS_SPEAR);
		//# [tier 2] Obsidian #
		offerPrimitiveShaftedToolRecipeSet(exporter, ModItems.OBSIDIAN_SHARD,
				ModItems.OBSIDIAN_DAGGER, ModItems.OBSIDIAN_HATCHET, ModItems.OBSIDIAN_HOE, ModItems.OBSIDIAN_SPEAR);
		//# [tier 3] Brass #
		offerMetalEquipmentRecipeSet(exporter, ModItems.BRASS_INGOT, ModItems.RAW_BRASS_NUGGET, "brass",
				ModItems.BRASS_BOOT_PAIR, ModItems.BRASS_CHESTPLATE,
				ModItems.BRASS_HELMET, ModItems.BRASS_LEGGING_PAIR,
				ModItems.BRASS_HORSE_ARMOR,
				ModItems.BRASS_AXE, ModItems.BRASS_DAGGER, ModItems.BRASS_HATCHET,
				ModItems.BRASS_HOE, ModItems.BRASS_MALLET, ModItems.BRASS_PICKAXE,
				ModItems.BRASS_SHOVEL, ModItems.BRASS_SPEAR, ModItems.BRASS_SWORD);
		//# [tier 3] Copper #
		offerMetalEquipmentRecipeSet(exporter, Items.COPPER_INGOT, ModItems.RAW_COPPER_NUGGET, "copper",
				ModItems.COPPER_BOOT_PAIR, ModItems.COPPER_CHESTPLATE,
				ModItems.COPPER_HELMET, ModItems.COPPER_LEGGING_PAIR,
				ModItems.COPPER_HORSE_ARMOR,
				ModItems.COPPER_AXE, ModItems.COPPER_DAGGER, ModItems.COPPER_HATCHET,
				ModItems.COPPER_HOE, ModItems.COPPER_MALLET, ModItems.COPPER_PICKAXE,
				ModItems.COPPER_SHOVEL, ModItems.COPPER_SPEAR, ModItems.COPPER_SWORD);
		//# [tier 3] Eiduril #
		offerMetalEquipmentRecipeSet(exporter, ModItems.EIDURIL_INGOT, ModItems.RAW_EIDURIL_NUGGET, "eiduril",
				ModItems.EIDURIL_BOOT_PAIR, ModItems.EIDURIL_CHESTPLATE,
				ModItems.EIDURIL_HELMET, ModItems.EIDURIL_LEGGING_PAIR,
				ModItems.EIDURIL_HORSE_ARMOR,
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
		offerBrushRecipe(exporter, Items.BRUSH);
		// Fishing Rod
		offerFishingRodRecipe(exporter, Items.FISHING_ROD);
		// Leather Horse Armor
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.LEATHER_HORSE_ARMOR)));
		// Pair of Shears
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.SHEARS)
				.input('#', ModItems.BRASS_GRAM)
				.input('X', ModItems.IRON_GRAM)
				.pattern("X X")
				.pattern("X#X")
				.pattern("###")
				.criterion(hasItem(ModItems.BRASS_GRAM), conditionsFromItem(ModItems.BRASS_GRAM))
				.criterion(hasItem(ModItems.IRON_GRAM), conditionsFromItem(ModItems.IRON_GRAM))
				.offerTo(exporter, new Identifier(getRecipeName(Items.SHEARS)));
		// Saddle
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.SADDLE)));
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
				.input('#', Tags.Item.ALL_BRICKS)
				.input('X', Items.IRON_INGOT)
				.input('@', ModItems.ASH_PILE)
				.pattern("XXX")
				.pattern("X@X")
				.pattern("###")
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
				.criterion(hasItem(ModItems.ASH_PILE), conditionsFromItem(ModItems.ASH_PILE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BLAST_FURNACE)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CAMPFIRE)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_CAMPFIRE)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.BREWING_STAND)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.CARTOGRAPHY_TABLE)));
		//# Crafting Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("##")
				.pattern("XX")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
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
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.STRING)
				.input('@', Items.ARROW)
				.pattern("X@X")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.FLETCHING_TABLE)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.GRINDSTONE)));
		//# Lectern #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.LECTERN)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.BOOK)
				.pattern("###")
				.pattern(" X ")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LECTERN)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LOOM)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.STONECUTTER)));
		//# Smithing Table #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SMITHING_TABLE)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', Items.IRON_INGOT)
				.pattern("XXX")
				.pattern("###")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
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
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.YELLOW_CHEESE_WEDGE) + "_from_cheese_wheel"));
		offerShapelessThreeIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLUE_CHEESE_WEDGE, 1,
				ModItems.YELLOW_CHEESE_WEDGE, Items.MAGMA_CREAM, Items.LAPIS_LAZULI, "", null);
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.BLUE_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		offerSmeltingRecipe(exporter, RecipeCategory.FOOD, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, 200,
				ModItems.YELLOW_CHEESE_WEDGE, 0.125F, "silky_smooth_cheese_wedge");
		//# Grassy Dirt Blocks (placeholder for other obtainment methods) #
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.GRASS_BLOCK, 1,
				Blocks.DIRT, Items.WHEAT_SEEDS, "", "grassy_dirt_blocks");
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.MYCELIUM, 1,
				Blocks.DIRT, Tags.Item.ALL_MUSHROOMS, "has_any_mushroom",
				"", "grassy_dirt_blocks");
		//# Nutrillarn (basic) #
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_NUTRILLARN_LUMP)
				.input(ModItems.CHERRY_JELLYBALL)
				.input(ModItems.MILKLEAF_PILE)
				.input(ModItems.CHULK_BERRY)
				.input(ModItems.STARCHCAP_MUSHROOM)
				.criterion(hasItem(ModItems.CHERRY_JELLYBALL), conditionsFromItem(ModItems.CHERRY_JELLYBALL))
				.criterion(hasItem(ModItems.MILKLEAF_PILE), conditionsFromItem(ModItems.MILKLEAF_PILE))
				.criterion(hasItem(ModItems.CHULK_BERRY), conditionsFromItem(ModItems.CHULK_BERRY))
				.criterion(hasItem(ModItems.STARCHCAP_MUSHROOM), conditionsFromItem(ModItems.STARCHCAP_MUSHROOM))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_NUTRILLARN_LUMP)));
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
		//# Nutrillarn (equipment) #
		offerMetalEquipmentRecipeSet(exporter, ModItems.NUTRILLARN_INGOT, ModItems.NUTRILLARN_GRAM, "nutrillarn",
				ModItems.NUTRILLARN_BOOT_PAIR, ModItems.NUTRILLARN_CHESTPLATE,
				ModItems.NUTRILLARN_HELMET, ModItems.NUTRILLARN_LEGGING_PAIR,
				ModItems.NUTRILLARN_HORSE_ARMOR,
				ModItems.NUTRILLARN_AXE, ModItems.NUTRILLARN_DAGGER, ModItems.NUTRILLARN_HATCHET,
				ModItems.NUTRILLARN_HOE, ModItems.NUTRILLARN_MALLET, ModItems.NUTRILLARN_PICKAXE,
				ModItems.NUTRILLARN_SHOVEL, ModItems.NUTRILLARN_SPEAR, ModItems.NUTRILLARN_SWORD);
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
		offerSmeltingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ULTRASMOOTH_STONE, 400,
				Blocks.SMOOTH_STONE, 0.125F, null);
		//endregion
		
		
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.ARMOR_STAND)));
		
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.ARROW)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.SPECTRAL_ARROW)));
		
		//# Ash Pile from cooking #
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				ModItems.WOODEN_STICK_BUNDLE, 0.125F);
		offerSmeltingAndBlastingRecipes(exporter,
				RecipeCategory.MISC, ModItems.ASH_PILE, 50,
				Tags.Item.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball",
				0.125F);
		
		//# Balls #
		// (balls) Cobweb Ball
		offerEightAroundOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.COBWEB_BALL, 1, Items.GUNPOWDER, ModItems.SILK_WAD, "", null);
		// (balls) Magma Cream
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_CREAM, 2)
				.input(Items.BLAZE_ROD).input(Items.SLIME_BALL)
				.input(Items.SLIME_BALL).input(ModItems.SULPHUR_LUMP)
				.criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
				.criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
				.criterion(hasItem(ModItems.SULPHUR_LUMP), conditionsFromItem(ModItems.SULPHUR_LUMP))
				.offerTo(exporter, new Identifier(getRecipeName(Items.MAGMA_CREAM)));
		// (balls) Yarnballs (dying)
		// TODO: Figure out how to use an arbitrary list as a recipe criterion,
		//  then remove the yarnball dying item tags, and refine this set of recipes.
		//  - .criterion("has_yarnball_which_dyes_to_black", conditionsFromItemPredicates(new ItemPredicate()))
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.BLACK_YARNBALL, 1,
				Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_BLACK, "has_any_yarnball_which_dyes_to_black",
				Items.BLACK_DYE, "", "yarnball_dying");
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
				RecipeCategory.MISC, ModItems.GRAY_YARNBALL, 1,
				ModItems.BLACK_YARNBALL, Items.WHITE_DYE, "_from_black_yarnball", "yarnball_dying");
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
				RecipeCategory.MISC, ModItems.LIGHT_GRAY_YARNBALL, 1,
				Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_LIGHT_GRAY, "has_any_yarnball_which_dyes_to_light_gray",
				Items.WHITE_DYE, "_from_yarnballs_which_lighten_to_light_gray", "yarnball_dying");
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
				ModItems.LIGHT_GRAY_YARNBALL, Items.WHITE_DYE, "", "yarnball_dying");
		offerTwoIntoOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.YELLOW_YARNBALL, 1,
				ModItems.WHITE_YARNBALL, Items.YELLOW_DYE, "", "yarnball_dying");
		// (balls) Yarnballs (miscellaneous) - Also string from silk.
		offerDoubleRowRecipe(exporter,
				RecipeCategory.MISC, ModItems.WHITE_YARNBALL, 1, Items.STRING, "_from_string", null);
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 4,
				Tags.Item.ALL_YARNBALLS, "has_any_yarnball", "_from_yarnball", null);
		offerSmallSquareRecipe(exporter,
				RecipeCategory.MISC, Items.STRING, 1,
				ModItems.SILK_WAD, "_from_silk", null);
		
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
				Tags.Item.ALL_PLANKS, "has_any_plank", "_from_plank", 0.125F);
		
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
		// NOTE: Doesn't work; bucket gets consumed, not leaving behind an Empty Bucket:
//		offerSmeltingRecipe(exporter,
//				RecipeCategory.FOOD, ModItems.CHEESE_WHEEL, 400,
//				Items.MILK_BUCKET, 0.125F, null);
		
		//# Clay Block #
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, 1, Items.CLAY_BALL, "", null);
		
		//# Compost Bin #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.COMPOSTER)
				.input('#', Tags.Item.ALL_PLANKS)
				.input('X', ModItems.WOODEN_STICK_BUNDLE)
				.pattern("# #")
				.pattern("#X#")
				.pattern("###")
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.criterion(hasItem(ModItems.WOODEN_STICK_BUNDLE), conditionsFromItem(ModItems.WOODEN_STICK_BUNDLE))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.COMPOSTER)));
		
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
		
		//# Dyes #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.RED_DYE, 200,
				Items.NETHER_WART, 0.125F, null); // Perhaps a "dyes_from_smelting" group?
		
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
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_paper"));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE_STICK)
				.input(Tags.Item.ALL_YARNBALLS)
				.input(Blocks.BAMBOO)
				.input(Items.GUNPOWDER)
				.group("dynamite_stick")
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO))
				.criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.DYNAMITE_STICK) + "_from_bamboo"));
		
		//# Elemental Blocks #
		// (EB) Ash
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BLOCK, 1, ModItems.ASH_PILE, "", null);
		
		// (EB) Bone
		offerCompactingEightRecipe(exporter,
				RecipeCategory.BUILDING_BLOCKS, Blocks.BONE_BLOCK, 1, Items.BONE, "", null);
		// (EB) Obsidian
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LANTERN)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SOUL_LANTERN)));
		
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LADDER)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.LEAD)));
		
		//# Leather #
		offerSmokingAndCampfireRecipes(exporter, RecipeCategory.MISC, Items.LEATHER,
				400, Items.ROTTEN_FLESH, 0.125F);
		
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
				ModItems.RAW_EIDURIL_LUMP, ModItems.RAW_EIDURIL_NUGGET, 150, 0.5F,
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
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_BRASS_LUMP)));
		// Metal Production (eiduril)
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_EIDURIL_LUMP, 1)
				.input(Items.DIAMOND).input(ModItems.COPPER_GRAM).input(Items.LAPIS_LAZULI)
				.input(ModItems.COPPER_GRAM).input(ModItems.COPPER_GRAM).input(ModItems.COPPER_GRAM)
				.input(Items.LAPIS_LAZULI).input(ModItems.COPPER_GRAM).input(Items.REDSTONE)
				.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
				.criterion(hasItem(ModItems.COPPER_GRAM), conditionsFromItem(ModItems.COPPER_GRAM))
				.criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_EIDURIL_LUMP)));
		
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.IRON_BARS)));
		// (M&WP) Metal (netherite)
		// (M&WP) Wooden
		
		//# Miniwizard #
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MINIWIZARD, 2)
				.input('#', ModItems.MINIWIZARD)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.input('X', Items.ROTTEN_FLESH)
				.input('@', Items.ENCHANTED_GOLDEN_APPLE)
				.pattern("O@O")
				.pattern("X#X")
				.pattern("OXO")
				.criterion(hasItem(ModItems.MINIWIZARD), conditionsFromItem(ModItems.MINIWIZARD))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
				.criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE), conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
				.offerTo(exporter, new Identifier(getRecipeName(ModItems.MINIWIZARD) + "_duplication"));
		
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DAYLIGHT_DETECTOR)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DISPENSER)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.DROPPER)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.LEVER)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.PISTON)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.COMPARATOR)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.REPEATER)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.TRIPWIRE_HOOK)));
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
				.offerTo(exporter, new Identifier(getRecipeName(Items.NAME_TAG)));
		
		//# Paper #
		offerLargeRowRecipe(exporter,
				RecipeCategory.MISC, Items.PAPER, 1, Items.SUGAR_CANE, "", null);
		
		//# Piles #
		// Blastpowder
		offerShapelessFourIntoOneRecipe(exporter,
				RecipeCategory.MISC, Items.GUNPOWDER, 3,
				ModItems.ASH_PILE, ModItems.SULPHUR_LUMP, Items.CHARCOAL,
				Tags.Item.ALL_GLASSY_SAND_PILES, "has_any_glassy_sand_pile", "", null);
		// Freeze Powder
		offerOneToOneRecipe(exporter,
				RecipeCategory.MISC, ModItems.FREEZE_POWDER_PILE, 2, ModItems.FREEZE_ROD, "", null);
		
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
				.input('X', Tags.Item.ALL_BRICKS)
				.input('@', Items.REDSTONE)
				.pattern("X")
				.pattern("#")
				.pattern("@")
				.criterion(hasItem(Blocks.RAIL), conditionsFromItem(Blocks.RAIL))
				.criterion("has_any_brick", conditionsFromTag(Tags.Item.ALL_BRICKS))
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
		
		//# Scaffolding *
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SCAFFOLDING)
				.input('#', Blocks.BAMBOO)
				.input('O', Tags.Item.ALL_YARNBALLS)
				.pattern("###")
				.pattern("#O#")
				.pattern("# #")
				.criterion(hasItem(Blocks.BAMBOO), conditionsFromItem(Blocks.BAMBOO))
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
				.offerTo(exporter, new Identifier(getRecipeName(Blocks.SCAFFOLDING)));
		
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
				.criterion("has_any_plank", conditionsFromTag(Tags.Item.ALL_PLANKS))
				.offerTo(exporter, new Identifier(getRecipeName(Items.STICK) + "_from_plank"));
		// Wooden Stick Bundle
		offerReversibleSmallSquareRecipes(exporter,
				RecipeCategory.MISC, ModItems.WOODEN_STICK_BUNDLE, "", null,
				RecipeCategory.MISC, Items.STICK, "_from_bundle", null);
		
		//# Sugar #
		offerSmeltingRecipe(exporter, RecipeCategory.MISC, Items.SUGAR, 200,
				Items.SUGAR_CANE, 0.125F, null);
		
		//# Torches #
		// Basic Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.TORCH, 1,
				Items.STICK, Tags.Item.BASIC_FLAME_MATERIALS, "has_basic_flame_material",
				"", null);
		// Erythrite Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.REDSTONE_TORCH, 1,
				Items.STICK, Items.REDSTONE, "", null);
		// Spirit Torch
		offerTorchRecipe(exporter,
				RecipeCategory.TOOLS, Items.SOUL_TORCH, 1,
				Items.STICK, Tags.Item.SPIRIT_FLAME_MATERIALS, "has_spirit_flame_material",
				"", null);
		
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
	public static void offerDoorAndHatchRecipeSet(
			RecipeExporter exporter, ItemConvertible doorItem, ItemConvertible hatchItem,
			ItemConvertible materialItem, String doorIdSuffix, String hatchIdSuffix,
			@Nullable String doorGroup, @Nullable String hatchGroup
	) {
		offerDoorRecipe(exporter, doorItem, materialItem, doorIdSuffix, doorGroup);
		offerHatchRecipe(exporter, hatchItem, materialItem, hatchIdSuffix, hatchGroup);
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
				.offerTo(exporter, new Identifier(getRecipeName(plankItem) + "_from_log"));
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
	
	
	public static void offerPrimitiveShaftedToolRecipeSet(
			RecipeExporter exporter, ItemConvertible shardItem,
			ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible spearItem
	) {
		offerStringedDaggerRecipe(exporter, daggerItem, shardItem, "", "shard_daggers");
		offerStringedHatchetRecipe(exporter, hatchetItem, shardItem, "", "shard_hatchets");
		offerStringedHoeRecipe(exporter, hoeItem, shardItem, "", "shard_hoes");
		offerStringedSpearRecipe(exporter, spearItem, shardItem, "", "shard_spears");
	}
	
	
	public static void offerStandardShaftedToolRecipeSet(
			RecipeExporter exporter, ItemConvertible ingotItem,
			ItemConvertible axeItem, ItemConvertible daggerItem, ItemConvertible hatchetItem,
			ItemConvertible hoeItem, ItemConvertible malletItem, ItemConvertible pickaxeItem,
			ItemConvertible shovelItem, ItemConvertible spearItem, ItemConvertible swordItem
	) {
		offerBasicAxeRecipe(exporter, axeItem, ingotItem, "");
		offerBasicDaggerRecipe(exporter, daggerItem, ingotItem, "");
		offerBasicHatchetRecipe(exporter, hatchetItem, ingotItem, "");
		offerBasicHoeRecipe(exporter, hoeItem, ingotItem, "");
		offerBasicMalletRecipe(exporter, malletItem, ingotItem, "");
		offerBasicPickaxeRecipe(exporter, pickaxeItem, ingotItem, "");
		offerBasicShovelRecipe(exporter, shovelItem, ingotItem, "");
		offerBasicSpearRecipe(exporter, spearItem, ingotItem, "");
		offerBasicSwordRecipe(exporter, swordItem, ingotItem, "");
	}
	
	
	public static void offerMetalArmorRecipeSet(
			RecipeExporter exporter, ItemConvertible ingotItem,
			ItemConvertible bootPairItem, ItemConvertible chestplateItem,
			ItemConvertible helmetItem, ItemConvertible leggingPairItem,
			ItemConvertible horseArmorItem
	) {
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, bootPairItem, 1,
				Items.LEATHER_BOOTS, ingotItem, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, chestplateItem, 1,
				Items.LEATHER_CHESTPLATE, ingotItem, "", null);
		offerFourOrthogonallyAroundOneRecipe(exporter, RecipeCategory.TOOLS, helmetItem, 1,
				Items.LEATHER_HELMET, ingotItem, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, leggingPairItem, 1,
				Items.LEATHER_LEGGINGS, ingotItem, "", null);
		offerEightAroundOneRecipe(exporter, RecipeCategory.TOOLS, horseArmorItem, 1,
				Items.LEATHER_HORSE_ARMOR, ingotItem, "", null);
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
		offerMetalArmorRecipeSet(exporter, ingotItem,
				bootPairItem, chestplateItem, helmetItem, leggingPairItem, horseArmorItem);
		offerStandardShaftedToolRecipeSet(exporter, ingotItem,
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
	
	
	//region ## Recipe Offers - Decoration & Utility ##
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstoneButtonRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstoneButtonFormat(category, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
	}
	
	
	public static void offerRedstonePressurePlateRecipe(
			RecipeExporter exporter, RecipeCategory category, ItemConvertible resultItem,
			ItemConvertible inputItem, String idSuffix, @Nullable String group
	) {
		createRedstonePressurePlateFormat(category, resultItem, 1, Ingredient.ofItems(inputItem))
				.group(group)
				.criterion(hasItem(inputItem), conditionsFromItem(inputItem))
				.criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
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
			TagKey<Item> baseItemTag, String hasTagString, String idSuffix
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', baseItemTag)
				.input('X', Items.STICK)
				.pattern("#")
				.pattern("X")
				.criterion(hasTagString, conditionsFromTag(baseItemTag))
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
	}
	
	
	public static void offerFishingRodRecipe(
			RecipeExporter exporter, ItemConvertible resultItem
	) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
				.input('#', Items.STICK)
				.input('X', Items.STRING)
				.input('@', Tags.Item.ALL_METAL_GRAMS)
				.pattern("  X")
				.pattern(" #X")
				.pattern("# @")
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
				.criterion("has_any_metal_gram", conditionsFromTag(Tags.Item.ALL_METAL_GRAMS))
				.offerTo(exporter, new Identifier(getRecipeName(resultItem)));
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
	
	
	//region ## Recipe Offers - Shapeless (miscellaneous) ##
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(bedResult) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(resultItem) + idSuffix));
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
				.offerTo(exporter, new Identifier(getRecipeName(concretePowderBlock)));
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
			ItemConvertible centralItem, TagKey<Item> orthogonalItemTag, String hasTagString,
			ItemConvertible diagonalItem, String idSuffix, @Nullable String group
	) {
		createFourAndFourCheckeredAroundOneFormat(category, resultItem, count,
				Ingredient.ofItems(centralItem), Ingredient.fromTag(orthogonalItemTag), Ingredient.ofItems(diagonalItem))
				.group(group)
				.criterion(hasItem(centralItem), conditionsFromItem(centralItem))
				.criterion(hasTagString, conditionsFromTag(orthogonalItemTag))
				.criterion(hasItem(diagonalItem), conditionsFromItem(diagonalItem))
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
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
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
				.criterion("has_any_yarnball", conditionsFromTag(Tags.Item.ALL_YARNBALLS))
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
				.input('@', Ingredient.fromTag(Tags.Item.ALL_YARNBALLS))
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
