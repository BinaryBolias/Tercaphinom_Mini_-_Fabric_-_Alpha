package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.block.AshMoundBlock;
import binarybolias.tercaphinom.references.JAUBlocks;
import binarybolias.tercaphinom.references.JAUItems;
import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import binarybolias.tercaphinom.registry.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.*;
import net.minecraft.loot.function.*;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * @see net.minecraft.data.server.loottable.BlockLootTableGenerator
 * @see net.minecraft.data.server.loottable.EntityLootTableGenerator
 * @see net.minecraft.data.server.loottable.vanilla.VanillaLootTableProviders
 * @see net.minecraft.loot.LootTables
 */
public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	//region Conditions
	public static final LootCondition.Builder WITH_CHOPPING_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ALL_CHOPPING_TOOLS));
	public static final LootCondition.Builder WITH_POUNDING_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ALL_POUNDING_TOOLS));
	
	public static final LootCondition.Builder WITH_SILK_TOUCH_OR_POUNDING_TOOL = WITH_SILK_TOUCH.or(WITH_POUNDING_TOOL);
	
	public static final LootCondition.Builder WITHOUT_POUNDING_TOOL = WITH_POUNDING_TOOL.invert();
	public static final LootCondition.Builder WITHOUT_CHOPPING_TOOL = WITH_CHOPPING_TOOL.invert();
	
	public static final LootCondition.Builder WITHOUT_SILK_TOUCH_NOR_POUNDING_TOOL = WITHOUT_SILK_TOUCH.and(WITHOUT_POUNDING_TOOL);
	
	public static final LootCondition.Builder WITH_REFINED_WOOD_HARVESTING_TOOL = WITH_CHOPPING_TOOL.or(WITH_POUNDING_TOOL);
	
	public static final LootCondition.Builder WITH_HOE_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ALL_HOES));
	public static final LootCondition.Builder WITH_SHEAR_PAIR_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS));
	public static final LootCondition.Builder WITH_SHOVEL_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.ALL_SHOVELS));
	
	public static final LootCondition.Builder WITHOUT_SHEAR_PAIR_TOOL = WITH_SHEAR_PAIR_TOOL.invert();
	public static final LootCondition.Builder WITHOUT_SHOVEL_TOOL = WITH_SHOVEL_TOOL.invert();
	
	public static final LootCondition.Builder WITH_STONE_PEBBLE = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(ModItems.STONE_PEBBLE));
	public static final LootCondition.Builder WITH_CACTUS = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(Items.CACTUS));
	public static final LootCondition.Builder WITH_CAKE = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(Items.CAKE));
	public static final LootCondition.Builder WITH_COOKIE = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(Items.COOKIE));
	public static final LootCondition.Builder WITH_EIDURIL_GRAM = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(ModItems.EIDURIL_GRAM));
	public static final LootCondition.Builder WITH_REFINED_VILBIARN_LUMP = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(ModItems.REFINED_VILBIARN_LUMP));
	public static final LootCondition.Builder WITH_ENCHANTED_BRICK = MatchToolLootCondition.builder(
			ItemPredicate.Builder.create().items(JAUItems.ENCHANTED_BRICK)); // TODO: Get something special from breaking clear glass with this?
	//endregion
	
	
	@Override
	public void generate() {
		logMainEvent("Generating loot table data");
		
		//region ## Material Sets - Stone ##
		//# Netherrack #
		//# Shale #
		addRudimentaryPlaceholderNaturalStoneDrop(Blocks.STONE, Items.COBBLESTONE, ModItems.GRAVEL_PILE, Items.FLINT);
		//# Slate #
		addRudimentaryPlaceholderNaturalStoneDrop(Blocks.DEEPSLATE, Items.COBBLED_DEEPSLATE, ModItems.GRAVEL_PILE, Items.FLINT);
		//# Stiefane #
		addStandardStoneBlockSetDrops(
				ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK, ModItems.GRAVEL_PILE,
				ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.COBBLED_STIEFANE_BLOCK,
				ModBlocks.NATURAL_STIEFANE_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//# Zygolith #
		//# Ore (netherrack) #
		addRudimentaryPlaceholderOreBlockDrop(Blocks.NETHER_GOLD_ORE, Items.NETHERRACK, Items.GOLD_NUGGET, 5, 7);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.NETHER_QUARTZ_ORE, Items.NETHERRACK, Items.QUARTZ, 2, 3);
		//# Ore (shale) #
		addRudimentaryPlaceholderOreBlockDrop(Blocks.COAL_ORE, Items.COBBLESTONE, Items.COAL, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.COPPER_ORE, Items.COBBLESTONE, Items.RAW_COPPER, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DIAMOND_ORE, Items.COBBLESTONE, Items.DIAMOND, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.EMERALD_ORE, Items.COBBLESTONE, Items.EMERALD, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.GOLD_ORE, Items.COBBLESTONE, Items.RAW_GOLD, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.IRON_ORE, Items.COBBLESTONE, Items.RAW_IRON, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.LAPIS_ORE, Items.COBBLESTONE, Items.LAPIS_LAZULI, 3, 4);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.REDSTONE_ORE, Items.COBBLESTONE, Items.REDSTONE, 4, 5);
		//# Ore (slate) #
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_COAL_ORE, Items.COBBLED_DEEPSLATE, Items.COAL, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_COPPER_ORE, Items.COBBLED_DEEPSLATE, Items.RAW_COPPER, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_DIAMOND_ORE, Items.COBBLED_DEEPSLATE, Items.DIAMOND, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_EMERALD_ORE, Items.COBBLED_DEEPSLATE, Items.EMERALD, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_GOLD_ORE, Items.COBBLED_DEEPSLATE, Items.RAW_GOLD, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_IRON_ORE, Items.COBBLED_DEEPSLATE, Items.RAW_IRON, 2, 3);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_LAPIS_ORE, Items.COBBLED_DEEPSLATE, Items.LAPIS_LAZULI, 3, 4);
		addRudimentaryPlaceholderOreBlockDrop(Blocks.DEEPSLATE_REDSTONE_ORE, Items.COBBLED_DEEPSLATE, Items.REDSTONE, 4, 5);
		//# Ore (stiefane) #
		addOreBlockDrop(ModBlocks.STIEFANE_LAPIS_ORE, ModItems.STIEFANE_COBBLESTONE, Items.LAPIS_LAZULI, 5, 8);
		//endregion
		
		//region ## Material Sets - Wood ##
		//# Acacia #
		addStandardPlankBlockSetDrops(ModItems.ACACIA_PLANK,
				Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_PLANKS,
				Blocks.ACACIA_BUTTON, Blocks.ACACIA_PRESSURE_PLATE,
				Blocks.ACACIA_DOOR, Blocks.ACACIA_TRAPDOOR,
				Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_FENCE,
				Blocks.ACACIA_SLAB, Blocks.ACACIA_STAIRS);
		addSignDrops(ModItems.ACACIA_PLANK, Blocks.ACACIA_SIGN, Blocks.ACACIA_HANGING_SIGN);
		addTrunkDrop(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_ACACIA_LOG, ModItems.ACACIA_PLANK, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD);
		//# Birch #
		addStandardPlankBlockSetDrops(ModItems.BIRCH_PLANK,
				Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_PLANKS,
				Blocks.BIRCH_BUTTON, Blocks.BIRCH_PRESSURE_PLATE,
				Blocks.BIRCH_DOOR, Blocks.BIRCH_TRAPDOOR,
				Blocks.BIRCH_FENCE_GATE, Blocks.BIRCH_FENCE,
				Blocks.BIRCH_SLAB, Blocks.BIRCH_STAIRS);
		addSignDrops(ModItems.BIRCH_PLANK, Blocks.BIRCH_SIGN, Blocks.BIRCH_HANGING_SIGN);
		addTrunkDrop(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_BIRCH_LOG, ModItems.BIRCH_PLANK, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD);
		//# Cherry #
		addStandardPlankBlockSetDrops(ModItems.CHERRY_PLANK,
				Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_PLANKS,
				Blocks.CHERRY_BUTTON, Blocks.CHERRY_PRESSURE_PLATE,
				Blocks.CHERRY_DOOR, Blocks.CHERRY_TRAPDOOR,
				Blocks.CHERRY_FENCE_GATE, Blocks.CHERRY_FENCE,
				Blocks.CHERRY_SLAB, Blocks.CHERRY_STAIRS);
		addSignDrops(ModItems.CHERRY_PLANK, Blocks.CHERRY_SIGN, Blocks.CHERRY_HANGING_SIGN);
		addTrunkDrop(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_CHERRY_LOG, ModItems.CHERRY_PLANK, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD);
		//# Crimson #
		addStandardPlankBlockSetDrops(ModItems.CRIMSON_PLANK,
				Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_PLANKS,
				Blocks.CRIMSON_BUTTON, Blocks.CRIMSON_PRESSURE_PLATE,
				Blocks.CRIMSON_DOOR, Blocks.CRIMSON_TRAPDOOR,
				Blocks.CRIMSON_FENCE_GATE, Blocks.CRIMSON_FENCE,
				Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STAIRS);
		addSignDrops(ModItems.CRIMSON_PLANK, Blocks.CRIMSON_SIGN, Blocks.CRIMSON_HANGING_SIGN);
		addTrunkDrop(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_CRIMSON_STEM, ModItems.CRIMSON_PLANK, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE);
		//# Dark Oak #
		addStandardPlankBlockSetDrops(ModItems.DARK_OAK_PLANK,
				Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS,
				Blocks.DARK_OAK_BUTTON, Blocks.DARK_OAK_PRESSURE_PLATE,
				Blocks.DARK_OAK_DOOR, Blocks.DARK_OAK_TRAPDOOR,
				Blocks.DARK_OAK_FENCE_GATE, Blocks.DARK_OAK_FENCE,
				Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_STAIRS);
		addSignDrops(ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_SIGN, Blocks.DARK_OAK_HANGING_SIGN);
		addTrunkDrop(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_DARK_OAK_LOG, ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD);
		//# Mahogany #
		addStandardPlankBlockSetDrops(ModItems.MAHOGANY_PLANK,
				Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_PLANKS,
				Blocks.JUNGLE_BUTTON, Blocks.JUNGLE_PRESSURE_PLATE,
				Blocks.JUNGLE_DOOR, Blocks.JUNGLE_TRAPDOOR,
				Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_FENCE,
				Blocks.JUNGLE_SLAB, Blocks.JUNGLE_STAIRS);
		addSignDrops(ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_SIGN, Blocks.JUNGLE_HANGING_SIGN);
		addTrunkDrop(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_JUNGLE_LOG, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD);
		//# Mangrove #
		addStandardPlankBlockSetDrops(ModItems.MANGROVE_PLANK,
				Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_PLANKS,
				Blocks.MANGROVE_BUTTON, Blocks.MANGROVE_PRESSURE_PLATE,
				Blocks.MANGROVE_DOOR, Blocks.MANGROVE_TRAPDOOR,
				Blocks.MANGROVE_FENCE_GATE, Blocks.MANGROVE_FENCE,
				Blocks.MANGROVE_SLAB, Blocks.MANGROVE_STAIRS);
		addSignDrops(ModItems.MANGROVE_PLANK, Blocks.MANGROVE_SIGN, Blocks.MANGROVE_HANGING_SIGN);
		addTrunkDrop(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_MANGROVE_LOG, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD);
		//# Oak #
		addStandardPlankBlockSetDrops(ModItems.OAK_PLANK,
				Blocks.STRIPPED_OAK_LOG, Blocks.OAK_PLANKS,
				Blocks.OAK_BUTTON, Blocks.OAK_PRESSURE_PLATE,
				Blocks.OAK_DOOR, Blocks.OAK_TRAPDOOR,
				Blocks.OAK_FENCE_GATE, Blocks.OAK_FENCE,
				Blocks.OAK_SLAB, Blocks.OAK_STAIRS);
		addSignDrops(ModItems.OAK_PLANK, Blocks.OAK_SIGN, Blocks.OAK_HANGING_SIGN);
		addTrunkDrop(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_OAK_LOG, ModItems.OAK_PLANK, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD);
		//# Spruce #
		addStandardPlankBlockSetDrops(ModItems.SPRUCE_PLANK,
				Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_PLANKS,
				Blocks.SPRUCE_BUTTON, Blocks.SPRUCE_PRESSURE_PLATE,
				Blocks.SPRUCE_DOOR, Blocks.SPRUCE_TRAPDOOR,
				Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_FENCE,
				Blocks.SPRUCE_SLAB, Blocks.SPRUCE_STAIRS);
		addSignDrops(ModItems.SPRUCE_PLANK, Blocks.SPRUCE_SIGN, Blocks.SPRUCE_HANGING_SIGN);
		addTrunkDrop(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_SPRUCE_LOG, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD);
		//# Verdak #
		addStandardPlankBlockSetDrops(ModItems.VERDAK_PLANK,
				ModBlocks.VERDAK_LOG, ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_GATE, ModBlocks.VERDAK_FENCE_POST,
				ModBlocks.VERDAK_PLANK_SLAB, ModBlocks.VERDAK_PLANK_STAIR);
		// TODO: Add Standing Verdak Sign and Hanging Verdak Sign.
		addTrunkDrop(ModBlocks.VERDAK_TRUNK, ModBlocks.VERDAK_LOG);
		// Note: No "Wood" blocks for verdak;
		//  - The "Wood"/"Hyphae" and "Stripped Wood"/"Stripped Hyphae" blocks are not canonical to Tercaphinom.
		//# Warped #
		addStandardPlankBlockSetDrops(ModItems.WARPED_PLANK,
				Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_PLANKS,
				Blocks.WARPED_BUTTON, Blocks.WARPED_PRESSURE_PLATE,
				Blocks.WARPED_DOOR, Blocks.WARPED_TRAPDOOR,
				Blocks.WARPED_FENCE_GATE, Blocks.WARPED_FENCE,
				Blocks.WARPED_SLAB, Blocks.WARPED_STAIRS);
		addSignDrops(ModItems.WARPED_PLANK, Blocks.WARPED_SIGN, Blocks.WARPED_HANGING_SIGN);
		addTrunkDrop(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_WARPED_STEM, ModItems.WARPED_PLANK, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
		//endregion
		//region ## Miscellaneous Wood-Type Blocks ##
		//# Cactus #
		addDrop(Blocks.CACTUS, LootTable.builder()
				.pool(LootPool.builder().with(AlternativeEntry.builder(
						// Drop planks with chopping tool without Silk Touch.
						makeConstantCountWithConditionItemEntry(
								WITH_CHOPPING_TOOL.and(WITHOUT_SILK_TOUCH), ModItems.BIRCH_PLANK, 4),
						// Drop cactus by default.
						ItemEntry.builder(Items.CACTUS)
				))));
		//# Mushroom #
		addBasicItemDrop(Blocks.MUSHROOM_STEM, Items.STICK, 12);
		addMushroomBlockDrop(Blocks.RED_MUSHROOM_BLOCK, Items.RED_MUSHROOM);
		addMushroomBlockDrop(Blocks.BROWN_MUSHROOM_BLOCK, Items.BROWN_MUSHROOM);
		//endregion
		
		
		//region ## Crops ##
		//TODO:
		// - Make Wheat Crop and Radish Crop only drop seeds at maximum stage.
		// - Make Wheat Crop drop Live Grass Tufts at less than maximum stage.
		// - Make Carrot Crop, Potato Crop, and Radish Crop drop Live Grass Tufts at any stage.
		//endregion
		
		//region ## Saplings ##
		addSaplingDrop(Blocks.ACACIA_SAPLING);
		addSaplingDrop(Blocks.BIRCH_SAPLING);
		addSaplingDrop(Blocks.CHERRY_SAPLING);
		addSaplingDrop(Blocks.DARK_OAK_SAPLING);
		addSaplingDrop(Blocks.JUNGLE_SAPLING);
		addSaplingDrop(Blocks.MANGROVE_PROPAGULE);
		addSaplingDrop(Blocks.OAK_SAPLING);
		addSaplingDrop(Blocks.SPRUCE_SAPLING);
		//endregion
		
		//region ## Storage ##
		// Barrel
		addItemOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.BARREL, ModItems.WOODEN_STICK_BUNDLE, 5);
		// Basic Chest
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.CHEST, ModItems.WOODEN_STICK_BUNDLE, 4, ModItems.IRON_GRAM, 6);
		// Ender Chest
		addItemOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.ENDER_CHEST, ModItems.OBSIDIAN_SHARD, 8);
		// Trapped Chest
		// TODO: Add a separate, globally accessible loot table reference for broken basic chest?
		//  (4 Wooden Stick Bundles & 6 Iron Grams)
		//  (may also be applicable to other loot tables)
		addDrop(Blocks.TRAPPED_CHEST, LootTable.builder()
				.pool(makeAlternativePool(
						makeConstantCountWithConditionItemEntry(Items.TRAPPED_CHEST, WITH_SILK_TOUCH_OR_POUNDING_TOOL),
						makeConstantCountItemEntry(ModItems.WOODEN_STICK_BUNDLE, 4)))
				.pool(makeSingleEntryPool(
						makeConstantCountWithConditionItemEntry(WITHOUT_SILK_TOUCH_NOR_POUNDING_TOOL, ModItems.IRON_GRAM, 6)))
				.pool(makeSingleEntryPool(
						makeConstantCountWithConditionItemEntry(Items.TRIPWIRE_HOOK, WITHOUT_SILK_TOUCH_NOR_POUNDING_TOOL))));
		//endregion
		
		//region ## Workstations ##
		// Crafting Table
		addWorkbenchDrop(Blocks.CRAFTING_TABLE, ModItems.WOODEN_STICK_BUNDLE, 3);
		// TODO: Add other workstations.
		//  - Blast Furnace
		//  - Enchanting Table
		//  - Furnace
		//  - Loom
		//  - Smoker
		//  - (others)
		//endregion
		
		//region ## Miscellaneous Decoration & Utility Blocks ##
		//# Bookshelf (Chiseled) #
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.CHISELED_BOOKSHELF, ModItems.WOODEN_STICK_BUNDLE, 3, Items.STICK, 3);
		//# Bookshelf (Packed) #
		addDrop(Blocks.BOOKSHELF, LootTable.builder() // Drop self with Silk touch or pounding tool, else drop crafting ingredients with planks converted to sticks.
				.pool(makeDoubleEntryAlternativePool(
						makeConstantCountWithConditionItemEntry(Blocks.BOOKSHELF, WITH_SILK_TOUCH_OR_POUNDING_TOOL),
						makeConstantCountItemEntry(ModItems.WOODEN_STICK_BUNDLE, 3))
				)
				.pool(makeSingleItemConditionalPool(Items.BOOK, 3, WITHOUT_SILK_TOUCH_NOR_POUNDING_TOOL))
		);
		//# Ladder (wooden) #
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.LADDER, Items.STICK, 7, Items.STRING, 1);
		//# Lectern #
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.LECTERN, ModItems.WOODEN_STICK_BUNDLE, 2, Items.BOOK, 1);
		//endregion
		
		//region ## Miscellaneous Elemental Blocks ##
		//# Bale #
		addBasicDoubleItemDrop(Blocks.DRIED_KELP_BLOCK, ModItems.DRY_KELP_BUNDLE, 8, Items.STRING, 1);
		addBasicDoubleItemDrop(Blocks.HAY_BLOCK, Items.WHEAT, 8, Items.STRING, 1);
		//# Crystal & Jewel #
		addBasicItemDrop(Blocks.AMETHYST_BLOCK, Items.AMETHYST_SHARD, 8);
		addBasicItemDrop(Blocks.BUDDING_AMETHYST, Items.AMETHYST_SHARD, 12);
		addBasicItemDrop(Blocks.DIAMOND_BLOCK, Items.DIAMOND, 8);
		addBasicItemDrop(Blocks.EMERALD_BLOCK, Items.EMERALD, 8);
		addBasicItemDrop(Blocks.LAPIS_BLOCK, Items.LAPIS_LAZULI, 8);
		//# Metal (raw) #
		addBasicItemDrop(ModBlocks.CORRODED_VILBIARN_BLOCK, ModItems.CORRODED_VILBIARN_LUMP, 8);
		addBasicItemDrop(ModBlocks.RAW_BRASS_BLOCK, ModItems.RAW_BRASS_LUMP, 8);
		addBasicItemDrop(Blocks.RAW_COPPER_BLOCK, Items.RAW_COPPER, 8);
		addBasicItemDrop(ModBlocks.RAW_EIDURIL_BLOCK, ModItems.RAW_EIDURIL_LUMP, 8);
		addBasicItemDrop(Blocks.RAW_GOLD_BLOCK, Items.RAW_GOLD, 8);
		addBasicItemDrop(Blocks.RAW_IRON_BLOCK, Items.RAW_IRON, 8);
		addBasicItemDrop(ModBlocks.REFINED_VILBIARN_BLOCK, ModItems.REFINED_VILBIARN_LUMP, 8);
		//# Metal (refined) #
		addBasicItemDrop(ModBlocks.REFINED_BRASS_BLOCK, ModItems.BRASS_INGOT, 8);
		addBasicItemDrop(Blocks.COPPER_BLOCK, Items.COPPER_INGOT, 8); // Note: Other copper blocks are accounted for elsewhere.
		addBasicItemDrop(ModBlocks.REFINED_EIDURIL_BLOCK, ModItems.EIDURIL_INGOT, 8);
		addBasicItemDrop(Blocks.GOLD_BLOCK, Items.GOLD_INGOT, 8);
		addBasicItemDrop(Blocks.IRON_BLOCK, Items.IRON_INGOT, 8);
		addBasicItemDrop(Blocks.NETHERITE_BLOCK, Items.NETHERITE_INGOT, 8);
		//# Metal (modified) #
		//region Copper
		// -- Basic Block (not including unoxidized unwaxed)
		addBasicItemDrop(Blocks.EXPOSED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.OXIDIZED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_COPPER_BLOCK, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_EXPOSED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_OXIDIZED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_WEATHERED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WEATHERED_COPPER, Items.COPPER_INGOT, 8);
		
		// -- Bulb
		addBulbDrop(Blocks.COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.EXPOSED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.OXIDIZED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.WAXED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.WAXED_EXPOSED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.WAXED_OXIDIZED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.WAXED_WEATHERED_COPPER_BULB, Items.COPPER_INGOT);
		addBulbDrop(Blocks.WEATHERED_COPPER_BULB, Items.COPPER_INGOT);
		
		// -- Chiseled Block
		addBasicItemDrop(Blocks.CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.EXPOSED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.OXIDIZED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_EXPOSED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_OXIDIZED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_WEATHERED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WEATHERED_CHISELED_COPPER, Items.COPPER_INGOT, 8);
		
		// -- Cut Block
		addBasicItemDrop(Blocks.CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.EXPOSED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.OXIDIZED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_EXPOSED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_OXIDIZED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WAXED_WEATHERED_CUT_COPPER, Items.COPPER_INGOT, 8);
		addBasicItemDrop(Blocks.WEATHERED_CUT_COPPER, Items.COPPER_INGOT, 8);
		
		// -- Grate
		addBasicItemDrop(Blocks.COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.EXPOSED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.OXIDIZED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.WAXED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.WAXED_EXPOSED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.WAXED_OXIDIZED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.WAXED_WEATHERED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		addBasicItemDrop(Blocks.WEATHERED_COPPER_GRATE, Items.COPPER_INGOT, 5);
		
		// -- Slab
		addSlabItemDrop(Blocks.CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.EXPOSED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.OXIDIZED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.WAXED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		addSlabItemDrop(Blocks.WEATHERED_CUT_COPPER_SLAB, Items.COPPER_INGOT, 4);
		
		// -- Stair
		addBasicItemDrop(Blocks.CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.EXPOSED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.OXIDIZED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.WAXED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		addBasicItemDrop(Blocks.WEATHERED_CUT_COPPER_STAIRS, Items.COPPER_INGOT, 6);
		//endregion
		//region Iron
		addBulbDrop(Blocks.REDSTONE_LAMP, Items.IRON_INGOT);
 		//endregion
		//# Miscellaneous #
		addDementhumScrapBlockDrop(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP);
		addBasicItemDrop(Blocks.REDSTONE_BLOCK, Items.REDSTONE, 8);
		addBasicItemDrop(ModBlocks.GLASS_SHARD_BLOCK, ModItems.GLASS_SHARD, 8);
		addBasicItemDrop(ModBlocks.SKORSAND_BLOCK, ModItems.SKORSAND_PILE, 8);
		addBasicItemDrop(Blocks.SLIME_BLOCK, Items.SLIME_BALL, 8);
		//endregion
		
		//region ## Modified & Transitional Blocks ##
		//# Bony #
		
		//# Covered #
		
		//# Mound #
		addAshBlockDrops();
		addSnowBlockDrops();
		
		//# Ore (netherrack) #
		//# Ore (stiefane) #
		//# Ore (zygolith) #
		//# Reinforced #
		//# Stony #
		//# Miscellaneous #
		addDrop(ModBlocks.ASHY_NETHERRACK_BLOCK, LootTable.builder()
				.pool(makeSingleItemPool(Blocks.NETHERRACK))
				.pool(makeSingleItemConditionalPool(ModItems.ASH_PILE, WITH_SILK_TOUCH)));
		//endregion
		
		//region ## Miscellaneous Foliage Blocks ##
		//# Leaf #
		addDrop(Blocks.ACACIA_LEAVES, makeAcaciaLeafBlockLootTable());
		addDrop(Blocks.AZALEA_LEAVES, makeAzaleaLeafBlockLootTable(Items.AZALEA));
		addDrop(Blocks.BIRCH_LEAVES, makeBirchLeafBlockLootTable());
		addDrop(Blocks.CHERRY_LEAVES, makeCherryLeafBlockLootTable());
		addDrop(Blocks.DARK_OAK_LEAVES, makeDarkOakLeafBlockLootTable());
		addDrop(Blocks.FLOWERING_AZALEA_LEAVES, makeAzaleaLeafBlockLootTable(Items.FLOWERING_AZALEA));
		addDrop(Blocks.JUNGLE_LEAVES, makeJungleLeafBlockLootTable());
		addDrop(Blocks.MANGROVE_LEAVES, makeLeafBlockBaseDropsLootTable());
		addDrop(Blocks.OAK_LEAVES, makeOakLeafBlockLootTable());
		addDrop(Blocks.SPRUCE_LEAVES, makeSpruceLeafBlockLootTable());
		//# Wart #
		addDrop(Blocks.NETHER_WART_BLOCK, makeWartBlockDropLootTable(Items.NETHER_WART));
		addDrop(Blocks.WARPED_WART_BLOCK, makeWartBlockDropLootTable(Items.NETHER_SPROUTS));
		//endregion
		
		//# Metal & Wooden Panes #
		addItemAOrItemBWithSilkTouchDrop(Blocks.IRON_BARS, ModItems.IRON_GRAM, 16, Items.IRON_BARS, 1);
		
		//region ## Various Vanilla Overrides ##
		//# (VVO) Beds #
		addBedOfPigmentDrop(Blocks.BLACK_BED, ModItems.BLACK_YARNBALL);
		addBedOfPigmentDrop(Blocks.BLUE_BED, ModItems.BLUE_YARNBALL);
		addBedOfPigmentDrop(Blocks.BROWN_BED, ModItems.BROWN_YARNBALL);
		addBedOfPigmentDrop(Blocks.CYAN_BED, ModItems.CYAN_YARNBALL);
		addBedOfPigmentDrop(Blocks.GRAY_BED, ModItems.GRAY_YARNBALL);
		addBedOfPigmentDrop(Blocks.GREEN_BED, ModItems.GREEN_YARNBALL);
		addBedOfPigmentDrop(Blocks.LIGHT_BLUE_BED, ModItems.LIGHT_BLUE_YARNBALL);
		addBedOfPigmentDrop(Blocks.LIGHT_GRAY_BED, ModItems.LIGHT_GRAY_YARNBALL);
		addBedOfPigmentDrop(Blocks.LIME_BED, ModItems.LIME_YARNBALL);
		addBedOfPigmentDrop(Blocks.MAGENTA_BED, ModItems.MAGENTA_YARNBALL);
		addBedOfPigmentDrop(Blocks.ORANGE_BED, ModItems.ORANGE_YARNBALL);
		addBedOfPigmentDrop(Blocks.PINK_BED, ModItems.PINK_YARNBALL);
		addBedOfPigmentDrop(Blocks.PURPLE_BED, ModItems.PURPLE_YARNBALL);
		addBedOfPigmentDrop(Blocks.RED_BED, ModItems.RED_YARNBALL);
		addBedOfWhiteDrop(Blocks.WHITE_BED);
		addBedOfPigmentDrop(Blocks.YELLOW_BED, ModItems.YELLOW_YARNBALL);
		//# (VVO) Bone Block #
		addDrop(Blocks.BONE_BLOCK, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
						makeConstantCountWithConditionItemEntry(Blocks.BONE_BLOCK, WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL)),
						ItemEntry.builder(Items.BONE_MEAL)
								.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(12)))
								.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
				))
		);
		// Old; kept for reference.
		//  - With Silk Touch, 8 Bones.
		//  - Without Silk Touch, 6 Bones and 4-6 Bonemeal.
//		addDrop(Blocks.BONE_BLOCK, LootTable.builder()
//				.pool(makeDoubleEntryAlternativePool(
//								makeConstantCountWithConditionItemEntry(WITH_SILK_TOUCH, Items.BONE, 8),
//								makeConstantCountItemEntry(Items.BONE, 6)
//						)
//				)
//				.pool(makeSingleEntryPool(
//						makeUniformCountWithConditionItemEntry(WITHOUT_SILK_TOUCH, Items.BONE_MEAL, 4, 6)
//				))
//		);
		//# (VVO) Beehive #
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.BEEHIVE, ModItems.WOODEN_STICK_BUNDLE, 3, Items.HONEYCOMB, 3);
		addItemOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.BEE_NEST, Items.HONEYCOMB, 3);
		//# (VVO) Clay Block #
		addDrop(Blocks.CLAY, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
								makeConstantCountWithConditionItemEntry(WITH_SILK_TOUCH, Items.CLAY_BALL, 8),
								makeUniformCountWithFortuneBonusItemEntry(Items.CLAY_BALL, 6, 9)
										.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(9)))
						)
				)
		);
		//# (VVO) Clay Brick #
		addBrickAndMortarBlockDrop(Blocks.BRICKS, Items.BRICK, 8, Items.CLAY_BALL);
		addBrickAndMortarSlabDrop(Blocks.BRICK_SLAB, Items.BRICK, 4, Items.CLAY_BALL);
		addBrickAndMortarBlockDrop(Blocks.BRICK_STAIRS, Items.BRICK, 6, Items.CLAY_BALL);
		addBrickAndMortarBlockDrop(Blocks.BRICK_WALL, Items.BRICK, 4, Items.CLAY_BALL);
		//# (VVO) Coal Block #
		addBasicItemDrop(Blocks.COAL_BLOCK, Items.COAL, 8);
		//# (VVO) Cobweb Block #
		addDrop(Blocks.COBWEB, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
								makeUniformCountWithConditionItemEntry(WITH_SILK_TOUCH, ModItems.SILK_WAD, 5, 12)
										.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(9))),
								makeUniformCountWithFortuneBonusItemEntry(ModItems.SILK_WAD, 3, 7)
						)
				)
		);
		//# (VVO) Dirt, Coarse Dirt, Gravel, & Dirt Variants #
		addGenericDirtDrop(Blocks.DIRT, ModItems.DIRT_PILE, ModItems.STONE_PEBBLE);
		addBasicItemDrop(Blocks.DIRT_PATH, ModItems.DIRT_PILE,8);
		addBasicItemDrop(Blocks.FARMLAND, ModItems.DIRT_PILE,8);
		addPodzolDirtDrop(Blocks.PODZOL,
				ModItems.DIRT_PILE, Items.BONE_MEAL, Items.CLAY_BALL, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM);
		addBasicDoubleItemDrop(Blocks.ROOTED_DIRT, ModItems.DIRT_PILE,8, Items.STICK, 1);
		addRyeGrassyDirtDrop(Blocks.GRASS_BLOCK, ModItems.DIRT_PILE, ModItems.LIVE_GRASS_TUFT, Items.WHEAT_SEEDS);
		addMyceliumGrassyDirtDrop(Blocks.MYCELIUM, ModItems.DIRT_PILE, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM);
		addCoarseDirtDrop(Blocks.COARSE_DIRT, ModItems.DIRT_PILE, ModItems.GRAVEL_PILE, Items.FLINT, ModItems.STONE_PEBBLE);
		addGravelDrop(Blocks.GRAVEL, ModItems.GRAVEL_PILE, Items.FLINT);
		//# (VVO) Fern #
		addShortFernAndTallFernDrops(Blocks.FERN, Blocks.LARGE_FERN);
		//# (VVO) Fire #
		addFireDrop(Blocks.FIRE, Items.BLAZE_POWDER);
		addFireDrop(Blocks.SOUL_FIRE, Items.BLAZE_POWDER);
		//# (VVO) Glass #
		// Glass - Clear
		addGlassBlockAndPaneDrops(Blocks.GLASS, Blocks.GLASS_PANE, ModItems.CLEAR_GLASS_PANE);
		// Glass - Stained
		addGlassBlockAndPaneDrops(Blocks.BLACK_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS_PANE, ModItems.BLACK_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.BLUE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS_PANE, ModItems.BLUE_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.BROWN_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS_PANE, ModItems.BROWN_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.CYAN_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS_PANE, ModItems.CYAN_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.GRAY_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS_PANE, ModItems.GRAY_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.GREEN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS_PANE, ModItems.GREEN_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, ModItems.LIGHT_BLUE_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, ModItems.LIGHT_GRAY_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.LIME_STAINED_GLASS, Blocks.LIME_STAINED_GLASS_PANE, ModItems.LIME_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.MAGENTA_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS_PANE, ModItems.MAGENTA_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.ORANGE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS_PANE, ModItems.ORANGE_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.PINK_STAINED_GLASS, Blocks.PINK_STAINED_GLASS_PANE, ModItems.PINK_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.PURPLE_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS_PANE, ModItems.PURPLE_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.RED_STAINED_GLASS, Blocks.RED_STAINED_GLASS_PANE, ModItems.RED_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.WHITE_STAINED_GLASS, Blocks.WHITE_STAINED_GLASS_PANE, ModItems.WHITE_STAINED_GLASS_PANE);
		addGlassBlockAndPaneDrops(Blocks.YELLOW_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS_PANE, ModItems.YELLOW_STAINED_GLASS_PANE);
		// Glass - Tinted
		addDrop(Blocks.TINTED_GLASS, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop self with Silk Touch, or 3 Glass Shards without.
										ItemEntry.builder(Blocks.TINTED_GLASS)
												.conditionally(WITH_SILK_TOUCH),
										ItemEntry.builder(ModItems.GLASS_SHARD)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 4 Skorsand Piles without Silk Touch.
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.SKORSAND_PILE)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
								)
				));
		//# (VVO) Grass #
		addShortGrassAndTallGrassDrops(Blocks.SHORT_GRASS, Blocks.TALL_GRASS);
		//# (VVO) Honeycomb #
		addBasicItemDrop(Blocks.HONEYCOMB_BLOCK, Items.HONEYCOMB, 8);
		//# (VVO) Mangrove Root Block #
		addDrop(Blocks.MANGROVE_ROOTS, LootTable.builder()
				.pool(makeAlternativePool( //NOTE: Duplicated in Muddy Mangrove Root Block loot table.
						makeConstantCountWithConditionItemEntry(Items.MANGROVE_ROOTS, WITH_SILK_TOUCH_OR_SHEARS),
						makeUniformCountItemEntry(Items.STICK, 3, 4))));
		//# (VVO) Metal Doors & Hatches - Copper #
		addDoorAndHatchDrops(Blocks.COPPER_DOOR, Blocks.COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.EXPOSED_COPPER_DOOR, Blocks.EXPOSED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.OXIDIZED_COPPER_DOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.WAXED_COPPER_DOOR, Blocks.WAXED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.WAXED_EXPOSED_COPPER_DOOR, Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.WAXED_OXIDIZED_COPPER_DOOR, Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.WAXED_WEATHERED_COPPER_DOOR, Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		addDoorAndHatchDrops(Blocks.WEATHERED_COPPER_DOOR, Blocks.WEATHERED_COPPER_TRAPDOOR, Items.COPPER_INGOT);
		//# (VVO) Metal Doors & Hatches - Iron #
		addDoorAndHatchDrops(Blocks.IRON_DOOR, Blocks.IRON_TRAPDOOR, Items.IRON_INGOT);
		//# (VVO) Moss #
		addBasicItemDrop(Blocks.MOSS_BLOCK, Blocks.MOSS_CARPET, 8);
		//# (VVO) Mud Block #
		// NOTE: Creating a variable as a test. (does work as expected)
		addDrop(Blocks.MUD, LootTable.builder()
				.pool(makeSingleEntryPool( //NOTE: Duplicated in Muddy Mangrove Root Block loot table.
						makeConstantCountItemEntry(ModItems.MUDBALL, 8))));
		//# (VVO) Muddy Mangrove Root Block #
		addDrop(Blocks.MUDDY_MANGROVE_ROOTS, LootTable.builder()
				.pool(makeSingleEntryPool( //NOTE: Duplicated in Mud Block loot table.
						makeConstantCountItemEntry(ModItems.MUDBALL, 8)))
				.pool(makeAlternativePool( //NOTE: Duplicated in Mangrove Root Block loot table.
						makeConstantCountWithConditionItemEntry(Items.MANGROVE_ROOTS, WITH_SILK_TOUCH_OR_SHEARS),
						makeUniformCountItemEntry(Items.STICK, 3, 4))));
		//# Nether Brick #
		addBrickAndMortarBlockDrop(Blocks.NETHER_BRICKS, Items.NETHER_BRICK, 8, Items.NETHER_WART);
		addBrickAndMortarSlabDrop(Blocks.NETHER_BRICK_SLAB, Items.NETHER_BRICK, 4, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.NETHER_BRICK_STAIRS, Items.NETHER_BRICK, 6, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.NETHER_BRICK_FENCE, Items.NETHER_BRICK, 4, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.NETHER_BRICK_WALL, Items.NETHER_BRICK, 4, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.CHISELED_NETHER_BRICKS, Items.NETHER_BRICK, 8, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.CRACKED_NETHER_BRICKS, Items.NETHER_BRICK, 8, Items.NETHER_WART);
		//# Netherwart Brick #
		addBrickAndMortarBlockDrop(Blocks.RED_NETHER_BRICKS, ModItems.NETHERWART_BRICK, 8, Items.NETHER_WART);
		addBrickAndMortarSlabDrop(Blocks.RED_NETHER_BRICK_SLAB, ModItems.NETHERWART_BRICK, 4, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.RED_NETHER_BRICK_STAIRS, ModItems.NETHERWART_BRICK, 6, Items.NETHER_WART);
		addBrickAndMortarBlockDrop(Blocks.RED_NETHER_BRICK_WALL, ModItems.NETHERWART_BRICK, 4, Items.NETHER_WART);
		//# (VVO) Obsidian #
		addBasicItemDrop(Blocks.OBSIDIAN, ModItems.OBSIDIAN_SHARD, 8);
		//# (VVO) Prismarine (Dark) #
		addBasicItemDrop(Blocks.DARK_PRISMARINE, ModItems.DARK_PRISMARINE_SHARD, 8);
		addSlabItemDrop(Blocks.DARK_PRISMARINE_SLAB, ModItems.DARK_PRISMARINE_SHARD, 4);
		addBasicItemDrop(Blocks.DARK_PRISMARINE_STAIRS, ModItems.DARK_PRISMARINE_SHARD, 6);
		//# (VVO) Prismarine (Pale) #
		addBasicItemDrop(Blocks.PRISMARINE, Items.PRISMARINE_SHARD, 8);
		addSlabItemDrop(Blocks.PRISMARINE_SLAB, Items.PRISMARINE_SHARD, 4);
		addBasicItemDrop(Blocks.PRISMARINE_STAIRS, Items.PRISMARINE_SHARD, 6);
		addBasicItemDrop(Blocks.PRISMARINE_WALL, Items.PRISMARINE_SHARD, 4);
		addBasicItemDrop(Blocks.PRISMARINE_BRICKS, Items.PRISMARINE_SHARD, 8);
		addSlabItemDrop(Blocks.PRISMARINE_BRICK_SLAB, Items.PRISMARINE_SHARD, 4);
		addBasicItemDrop(Blocks.PRISMARINE_BRICK_STAIRS, Items.PRISMARINE_SHARD, 6);
		//# (VVO) Purpur #
		addBasicItemDrop(Blocks.PURPUR_BLOCK, Items.POPPED_CHORUS_FRUIT, 8);
		addBasicItemDrop(Blocks.PURPUR_PILLAR, Items.POPPED_CHORUS_FRUIT, 8);
		addSlabItemDrop(Blocks.PURPUR_SLAB, Items.POPPED_CHORUS_FRUIT, 4);
		addBasicItemDrop(Blocks.PURPUR_STAIRS, Items.POPPED_CHORUS_FRUIT, 6);
		//# (VVO) Quartz #
		addBasicItemDrop(Blocks.QUARTZ_BLOCK, Items.QUARTZ, 8);
		addSlabItemDrop(Blocks.QUARTZ_SLAB, Items.QUARTZ, 4);
		addBasicItemDrop(Blocks.QUARTZ_STAIRS, Items.QUARTZ, 6);
		addBasicItemDrop(Blocks.QUARTZ_BRICKS, Items.QUARTZ, 8);
		addBasicItemDrop(Blocks.QUARTZ_PILLAR, Items.QUARTZ, 8);
		addBasicItemDrop(Blocks.CHISELED_QUARTZ_BLOCK, Items.QUARTZ, 8);
		addBasicItemDrop(Blocks.SMOOTH_QUARTZ, Items.QUARTZ, 8);
		addSlabItemDrop(Blocks.SMOOTH_QUARTZ_SLAB, Items.QUARTZ, 4);
		addBasicItemDrop(Blocks.SMOOTH_QUARTZ_STAIRS, Items.QUARTZ, 6);
		//# (VVO) Sands #
		// Feldsand
		addBasicItemDrop(Blocks.SAND, ModItems.FELDSAND_PILE, 8);
		// Ferrosand
		addBasicItemDrop(Blocks.RED_SAND, ModItems.FERROSAND_PILE, 8);
		// Soulsoil
		addBasicItemDrop(Blocks.SOUL_SAND, ModItems.SOULSOIL_CLOD, 8);
		// Soulsand
		addBasicItemDrop(Blocks.SOUL_SOIL, ModItems.SOULSAND_PILE, 8);
		//# (VVO) Sea Lantern #
		addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Blocks.SEA_LANTERN, Items.PRISMARINE_SHARD, 4, Items.PRISMARINE_CRYSTALS, 5);
		//# (VVO) Spawn Cage #
		addDrop(Blocks.SPAWNER, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
						ItemEntry.builder(Blocks.SPAWNER)
								.conditionally(WITH_SILK_TOUCH.and(WITH_POUNDING_TOOL)),
						makeConstantCountItemEntry(ModItems.IRON_GRAM, 96)
				))
				.pool(LootPool.builder()
						.with(makeConstantCountWithConditionItemEntry(
								WITHOUT_SILK_TOUCH.or(WITHOUT_POUNDING_TOOL), Items.REDSTONE, 4))
				));
		//# (VVO) Warpsprout Crop #
		addDrop(Blocks.NETHER_SPROUTS);
		//# (VVO) Yarn Blocks #
		addBasicItemDrop(Blocks.BLACK_WOOL, ModItems.BLACK_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.BLUE_WOOL, ModItems.BLUE_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.BROWN_WOOL, ModItems.BROWN_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.CYAN_WOOL, ModItems.CYAN_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.GRAY_WOOL, ModItems.GRAY_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.GREEN_WOOL, ModItems.GREEN_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.LIGHT_BLUE_WOOL, ModItems.LIGHT_BLUE_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.LIGHT_GRAY_WOOL, ModItems.LIGHT_GRAY_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.LIME_WOOL, ModItems.LIME_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.MAGENTA_WOOL, ModItems.MAGENTA_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.ORANGE_WOOL, ModItems.ORANGE_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.PINK_WOOL, ModItems.PINK_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.PURPLE_WOOL, ModItems.PURPLE_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.RED_WOOL, ModItems.RED_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.WHITE_WOOL, ModItems.WHITE_YARN_ROLL, 8);
		addBasicItemDrop(Blocks.YELLOW_WOOL, ModItems.YELLOW_YARN_ROLL, 8);
		//# (VVO) Yarn Carpets #
		addBasicItemDrop(Blocks.BLACK_CARPET, ModItems.BLACK_YARN_ROLL);
		addBasicItemDrop(Blocks.BLUE_CARPET, ModItems.BLUE_YARN_ROLL);
		addBasicItemDrop(Blocks.BROWN_CARPET, ModItems.BROWN_YARN_ROLL);
		addBasicItemDrop(Blocks.CYAN_CARPET, ModItems.CYAN_YARN_ROLL);
		addBasicItemDrop(Blocks.GRAY_CARPET, ModItems.GRAY_YARN_ROLL);
		addBasicItemDrop(Blocks.GREEN_CARPET, ModItems.GREEN_YARN_ROLL);
		addBasicItemDrop(Blocks.LIGHT_BLUE_CARPET, ModItems.LIGHT_BLUE_YARN_ROLL);
		addBasicItemDrop(Blocks.LIGHT_GRAY_CARPET, ModItems.LIGHT_GRAY_YARN_ROLL);
		addBasicItemDrop(Blocks.LIME_CARPET, ModItems.LIME_YARN_ROLL);
		addBasicItemDrop(Blocks.MAGENTA_CARPET, ModItems.MAGENTA_YARN_ROLL);
		addBasicItemDrop(Blocks.ORANGE_CARPET, ModItems.ORANGE_YARN_ROLL);
		addBasicItemDrop(Blocks.PINK_CARPET, ModItems.PINK_YARN_ROLL);
		addBasicItemDrop(Blocks.PURPLE_CARPET, ModItems.PURPLE_YARN_ROLL);
		addBasicItemDrop(Blocks.RED_CARPET, ModItems.RED_YARN_ROLL);
		addBasicItemDrop(Blocks.WHITE_CARPET, ModItems.WHITE_YARN_ROLL);
		addBasicItemDrop(Blocks.YELLOW_CARPET, ModItems.YELLOW_YARN_ROLL);
		//# (VVO) Zygolith Portal Frame Block #
		addDrop(Blocks.END_PORTAL_FRAME, LootTable.builder()
				.pool(
						LootPool.builder()
								// Drop self with Silk Touch or pounding tool, or Zygolith elsewize.
								.with(AlternativeEntry.builder(
										ItemEntry.builder(Items.END_PORTAL_FRAME)
												.conditionally(WITH_SILK_TOUCH_OR_POUNDING_TOOL),
										ItemEntry.builder(Items.END_STONE)
								))
				)
				.pool(
						LootPool.builder()
								// Drop eiduril without Silk Touch or pounding tool.
								.conditionally(WITHOUT_SILK_TOUCH_NOR_POUNDING_TOOL)
								.with(ItemEntry.builder(ModItems.EIDURIL_GRAM)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(24))))
				));
		//endregion
		
		//region ### Joke & Unserious ###
		//## (J&U) Crops & Foliage ##
		//# Miscellaneous #
		addDrop(JAUBlocks.STARCHCAP_MUSHROOM);
		//## (J&U) Elemental ##
		//# Cheese #
		addDrop(JAUBlocks.BLUE_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 7 blue cheese wedges with Silk Touch, or 8 without.
										ItemEntry.builder(JAUItems.BLUE_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
										ItemEntry.builder(JAUItems.BLUE_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 silky smooth cheese wedge with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE))
				));
		addDrop(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 8 silky smooth cheese wedges with Silk Touch, or 7 without.
										ItemEntry.builder(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8))),
										ItemEntry.builder(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 yellow cheese wedge without Silk Touch.
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(JAUItems.YELLOW_CHEESE_WEDGE))
				));
		addDrop(JAUBlocks.YELLOW_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 7 yellow cheese wedges with Silk Touch, or 8 without.
										ItemEntry.builder(JAUItems.YELLOW_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
										ItemEntry.builder(JAUItems.YELLOW_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 silky smooth cheese wedge with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE))
				));
		//# Metal #
		addBasicItemDrop(JAUBlocks.RAW_NUTRILLARN_BLOCK, JAUItems.RAW_NUTRILLARN_LUMP, 8);
		addBasicItemDrop(JAUBlocks.REFINED_NUTRILLARN_BLOCK, JAUItems.NUTRILLARN_INGOT, 8);
		//# Miscellaneous #
		addBasicItemDrop(JAUBlocks.CANDESAND_BLOCK, JAUItems.CANDESAND_PILE, 8);
		addBasicItemDrop(JAUBlocks.CHERRY_JELLYBLOCK, JAUItems.CHERRY_JELLYBALL, 8);
		addItemOrBlockWithSilkTouchDrop(JAUBlocks.HYPERSMOOTH_CREAMSTONE, JAUBlocks.ULTRASMOOTH_STONE, 1);
		addItemOrBlockWithSilkTouchDrop(JAUBlocks.ULTRASMOOTH_STONE, Blocks.SMOOTH_STONE, 1);
		//## (J&U) Modified & Transitional ##
		//# Reinforced #
		addDrop(JAUBlocks.REINFORCED_STAINED_GLASS_BLOCK, makeReinforcedStainedGlassBlockLootTable());
		//endregion
	}
	
	//region ## Drop Adder Sets ##
	private void addDoorAndHatchDrops(Block door, Block hatch, ItemConvertible materialItem) {
		addDoorDrop(door, materialItem);
		addHatchDrop(hatch, materialItem);
	}
	
	
	private void addShortFernAndTallFernDrops(Block shortFernBlock, Block tallFernBlock) {
		addDrop(shortFernBlock, makeFernCropLootTable());
		addDrop(tallFernBlock, makeFernCropLootTable());
	}
	
	
	private void addShortGrassAndTallGrassDrops(Block shortGrassBlock, Block tallGrassBlock) {
		addDrop(shortGrassBlock, makeGrassCropLootTable());
		addDrop(tallGrassBlock, makeTallGrassLootTable(tallGrassBlock));
	}
	
	
	private void addTrunkDrop(Block trunk, Block log) {
		addDrop(trunk, makeTrunkLootTable(trunk, log));
	}
	
	
	private void addSignDrops(ItemConvertible plankItem, Block standingSign, Block hangingSign) {
		addDrop(standingSign, makePlankStandingSignLootTable(plankItem));
		addDrop(hangingSign, makePlankHangingSignLootTable(plankItem));
	}
	
	
	private void addStandardPlankBlockSetDrops(
			Item plankItem,
			Block logBlock, Block plankBlock,
			Block button, Block pressurePlate,
			Block door, Block hatch,
			Block fenceGate, Block fencePost,
			Block slab, Block stair
	) {
		// Log Block
		addDrop(logBlock, makeLogLootTable(logBlock, plankItem));
		// Plank Block
		addBasicPlankBasedDrop(plankBlock, plankItem, 8);
		// Button
		addPlankBasedBlockWithSecondaryItemDrop(button, plankItem, 1, Items.REDSTONE, 1);
		// Pressure Plate
		addPlankBasedBlockWithSecondaryItemDrop(pressurePlate, plankItem, 2, Items.REDSTONE, 1);
		// Door & Hatch
		addDoorAndHatchDrops(door, hatch, plankItem);
		// Fence Gate
		addPlankBasedBlockWithSecondaryItemDrop(fenceGate, plankItem, 2, ModItems.IRON_GRAM, 2);
		// Fence Post
		addBasicPlankBasedDrop(fencePost, plankItem, 2);
		// Slab
		addPlankSlabDrop(slab, plankItem, 4);
		// Stair
		addBasicPlankBasedDrop(stair, plankItem, 6);
	}
	
	
	private void addStandardStoneBlockSetDrops(
			ItemConvertible cobblestoneItem, ItemConvertible brickItem, ItemConvertible pileItem,
			Block brickBlock, Block cobbledBlock, Block naturalBlock, Block polishedBlock,
			Block button, Block pressurePlate,
			Block brickWallPost,
			Block brickSlab, Block brickStair
	) {
		// NOTE: For now, these stone block loot tables do not consider tool type, for the sake of simplicity.
		// Brick Block
		addBasicItemDrop(brickBlock, brickItem, 4);
		// Cobbled Block
		addBasicItemDrop(cobbledBlock, cobblestoneItem, 8);
		// Natural Block
		addNaturalStoneDrop(naturalBlock, cobblestoneItem, pileItem, Items.FLINT);
		// Polished Block
		addItemOrBlockWithSilkTouchDrop(polishedBlock, cobblestoneItem, 8);
		// Button
		addItemWithSecondaryItemOrBlockWithSilkTouchDrop(button,
				brickItem, 1,
				Items.REDSTONE, 1);
		// Pressure Plate
		addItemWithSecondaryItemOrBlockWithSilkTouchDrop(pressurePlate,
				brickItem, 2,
				Items.REDSTONE, 1);
		// Brick Wall Post
		addBasicItemDrop(brickWallPost, brickItem, 2);
		// Brick Slab
		addSlabItemDrop(brickSlab, brickItem, 2);
		// Brick Stair
		addBasicItemDrop(brickStair, brickItem, 3);
	}
	
	
	private void addWoodAndStrippedWoodDrops(
			ItemConvertible log, ItemConvertible plank, Block wood, Block strippedWood) {
		addDrop(strippedWood, makeStrippedWoodLootTable(log, plank));
		addDrop(wood, makeStrippedWoodLootTable(log, plank).pool(LootPool.builder().with(
				ItemEntry.builder(Items.STICK)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
						.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
				)
		));
	}
	//endregion
	
	//region ## Drop Adders (decoration & utility) ##
	private void addBulbDrop(Block bulbBlock, ItemConvertible ingotItem) {
		addDrop(bulbBlock, makeBulbLootTable(ingotItem));
	}
	
	
	private void addDoorDrop(Block doorBlock, ItemConvertible materialItem) {
		addDrop(doorBlock, makeDoorLootTable(doorBlock, materialItem));
	}
	
	
	private void addHatchDrop(Block Block, ItemConvertible materialItem) {
		addDrop(Block, makeHatchLootTable(materialItem));
	}
	
	
	private void addWorkbenchDrop(Block block, ItemConvertible item, int amount) {
		addDrop(block, makeWorkbenchLootTable(block, item, amount));
	}
	//endregion
	
	//region ## Drop Adders (miscellaneous) ##
	//endregion
	
	//region ## Generic Drop Adders ##
	private void addBasicItemDrop(Block block, ItemConvertible item) {
		addDrop(block, makeBasicItemDropLootTable(item));
	}
	
	private void addBasicItemDrop(Block block, ItemConvertible item, int count) {
		addDrop(block, makeBasicItemDropLootTable(item, count));
	}
	
	
	private void addBasicDoubleItemDrop(
			Block block, ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		addDrop(block, makeBasicDoubleItemDropLootTable(itemA, countA, itemB, countB));
	}
	
	
	private void addItemAOrItemBWithSilkTouchDrop(
			Block block, ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		addDrop(block, makeItemAOrItemBWithSilkTouchLootTable(itemA, countA, itemB, countB));
	}
	
	
	private void addItemPairAOrItemPairBWithConditionDrop(
			Block block, LootCondition.Builder condition,
			ItemConvertible itemAA, int countAA, ItemConvertible itemAB, int countAB,
			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
		addDrop(block, makeItemPairAOrItemPairBWithConditionLootTable(
				condition, itemAA, countAA, itemAB, countAB, itemBA, countBA, itemBB, countBB));
	}
	
	
	private void addItemPairAOrItemPairBWithSilkTouchDrop(
			Block block,
			ItemConvertible itemAA, int countAA, ItemConvertible itemAB, int countAB,
			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
		addDrop(block, makeItemPairAOrItemPairBWithSilkTouchLootTable(
				itemAA, countAA, itemAB, countAB, itemBA, countBA, itemBB, countBB));
	}
	
	
	private void addItemPairOrBlockWithSilkTouchDrop(Block block, ItemConvertible itemA, int amountA, ItemConvertible itemB, int amountB) {
		addDrop(block, makeItemPairOrBlockWithSilkTouchLootTable(block, itemA, amountA, itemB, amountB));
	}
	
	
	private void addItemPairOrBlockWithSilkTouchOrPoundingToolDrop(Block block, ItemConvertible itemA, int amountA, ItemConvertible itemB, int amountB) {
		addDrop(block, makeItemPairOrBlockWithSilkTouchOrPoundingToolLootTable(block, itemA, amountA, itemB, amountB));
	}
	
	
	private void addItemOrBlockWithSilkTouchDrop(Block block, ItemConvertible item, int amount) {
		addDrop(block, makeItemOrBlockWithSilkTouchLootTable(block, item, amount));
	}
	
	
	private void addItemOrBlockWithSilkTouchOrPoundingToolDrop(Block block, ItemConvertible item, int amount) {
		addDrop(block, makeItemOrBlockWithSilkTouchOrPoundingToolLootTable(block, item, amount));
	}
	
	
	private void addItemWithSecondaryItemOrBlockWithSilkTouchDrop(
			Block block,
			ItemConvertible primaryItem, int primaryAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		addDrop(block, makeItemWithSecondaryItemOrBlockWithSilkTouchLootTable(block, primaryItem, primaryAmount, secondaryItem, secondaryAmount));
	}
	
	
	private void addLegacyDoorItemAOrItemBWithSilkTouchDrop(
			Block block, ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		addDrop(block, makeLegacyDoorItemAOrItemBWithSilkTouchLootTable(block, itemA, countA, itemB, countB));
	}
	
	
	private void addSlabItemDrop(Block slabBlock, ItemConvertible item, int count) {
		addDrop(slabBlock, makeSlabItemDropLootTable(slabBlock, item, count));
	}
	
	
//	private void addSingleItemAOrItemPairBWithConditionDrop(
//			Block block, LootCondition.Builder condition,
//			ItemConvertible itemA, int countA,
//			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
//		addDrop(block, makeItemPairAOrItemPairBWithConditionLootTable(
//				condition, itemA, countA, itemBA, countBA, itemBB, countBB));
//	}
	//endregion
	
	//region ## Modular Drop Adders ##
//	private void addModularDrop( // TODO.
//			Block naturalStoneBlock,
//			ItemConvertible cobblestoneItem, ItemConvertible pileItem, ItemConvertible shardItem
//	) {
//		addDrop(naturalStoneBlock, makeNaturalStoneBlockLootTable(
//				cobblestoneItem, pileItem, shardItem));
//	}
	//endregion
	
	//region ## Specialized Drop Adders (stone) ##
	private void addNaturalStoneDrop(
			Block naturalStoneBlock,
			ItemConvertible cobblestoneItem, ItemConvertible pileItem, ItemConvertible shardItem
	) {
		addDrop(naturalStoneBlock, makeNaturalStoneBlockLootTable(
				cobblestoneItem, pileItem, shardItem));
	}
	
	
	private void addOreBlockDrop(
			Block oreBlock, ItemConvertible cobblestoneItem, ItemConvertible oreItem, int oreMin, int oreMax
	) {
		addDrop(oreBlock, makeOreBlockLootTable(cobblestoneItem, oreItem, oreMin, oreMax));
	}
	
	
	private void addRudimentaryPlaceholderNaturalStoneDrop(
			Block naturalStoneBlock,
			ItemConvertible cobblestoneItem, ItemConvertible pileItem, ItemConvertible shardItem
	) {
		addDrop(naturalStoneBlock, makeRudimentaryPlaceholderNaturalStoneBlockLootTable(
				cobblestoneItem, pileItem, shardItem));
	}
	
	
	private void addRudimentaryPlaceholderOreBlockDrop(
			Block oreBlock, ItemConvertible cobblestoneItem, ItemConvertible oreItem, int oreMin, int oreMax
	) {
		addDrop(oreBlock, makeRudimentaryPlaceholderOreBlockLootTable(cobblestoneItem, oreItem, oreMin, oreMax));
	}
	//endregion
	
	//region ## Specialized Drop Adders (wood) ##
	private void addBasicPlankBasedDrop(Block block, ItemConvertible plankItem, int plankAmount) {
		addDrop(block, makeBasicPlankBasedBlockLootTable(plankItem, plankAmount));
	}
	
	
	private void addPlankBasedBlockWithSecondaryItemDrop(
			Block block,
			ItemConvertible plankItem, int plankAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		addDrop(block, makePlankBasedBlockWithSecondaryItemLootTable(
				plankItem, plankAmount, secondaryItem, secondaryAmount));
	}
	
	
	private void addPlankSlabDrop(Block slabBlock, ItemConvertible plankItem, int plankAmount) {
		addDrop(slabBlock, makePlankSlabLootTable(slabBlock, plankItem, plankAmount));
	}
	//endregion
	
	
	//region ## Specialized Drop Adders (miscellaneous) ##
	private void addAshBlockDrops() {
		Item ashPileItem = ModItems.ASH_PILE;
		// Ash Block
		addBasicItemDrop(ModBlocks.ASH_BLOCK, ModItems.ASH_PILE, 8);
		// Ash Mound
		addDrop(ModBlocks.ASH_MOUND, LootTable.builder()
				.pool( // Drop 1 Ash Pile per layer.
						LootPool.builder()
								.conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
								.with(
										AlternativeEntry.builder(
												AshMoundBlock.LAYERS.getValues(),
												integer -> ItemEntry.builder(ashPileItem)
														.conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.ASH_MOUND).properties(StatePredicate.Builder.create().exactMatch(AshMoundBlock.LAYERS, integer)))
														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer)))
										)
								)
				)
		);
	}
	
	
	private void addBedOfPigmentDrop(Block block, ItemConvertible pigmentedYarnballItem) {
		addDrop(block, makeBedOfPigmentLootTable(block, pigmentedYarnballItem));
	}
	
	
	private void addBedOfWhiteDrop(Block block) {
		addDrop(block, makeBedOfWhiteLootTable(block));
	}
	
	
	private void addBrickAndMortarBlockDrop(
			Block block, ItemConvertible brickItem, int brickCount, ItemConvertible mortarItem
	) {
		addDrop(block, LootTable.builder()
				.pool(makeSingleItemPool(brickItem, brickCount))
				.pool(makeSingleItemConditionalPool(mortarItem, WITH_SILK_TOUCH))
		);
	}
	
	
	private void addBrickAndMortarSlabDrop(
			Block slabBlock, ItemConvertible brickItem, int brickCount, ItemConvertible mortarItem
	) {
		addDrop(slabBlock, LootTable.builder()
				.pool(makeSlabLootPool(slabBlock, brickItem, brickCount))
				.pool(makeSlabLootPool(slabBlock, mortarItem, WITH_SILK_TOUCH))
		);
	}
	
	
	private void addCoarseDirtDrop(
			Block coarseDirtBlock, ItemConvertible dirtPileItem, ItemConvertible gravelPileItem,
			ItemConvertible flintItem, ItemConvertible stonePebbleItem
	) {
		addDrop(coarseDirtBlock, LootTable.builder()
				.pool( // 4 dirt piles.
						LootPool.builder()
								.with(ItemEntry.builder(dirtPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
								)
				)
				.pool( // 4 gravel piles.
						LootPool.builder()
								.with(ItemEntry.builder(gravelPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
								)
				)
				.pool( // Chance of 1 bonus flint based on Fortune, requiring being mined with a shovel.
						LootPool.builder()
								.with(ItemEntry.builder(flintItem)
										.conditionally(WITH_SHOVEL_TOOL.and(TableBonusLootCondition.builder(
												Enchantments.FORTUNE,
												0.00390625F, 0.0078125F, 0.015625F, 0.03125F, 0.0625F)
										))
								)
				)
				.pool( // Sometimes drop a bonus stone pebble, increased chance with Fortune.
						LootPool.builder()
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
										0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
								.with(ItemEntry.builder(stonePebbleItem))
				)
		);
	}
	
	
	private void addDementhumScrapBlockDrop(
			Block dementhumScrapBlock, ItemConvertible dementhumScrapItem
	) {
		addDrop(dementhumScrapBlock, LootTable.builder()
				.pool( // 8-12 items, increased by Fortune and Silk Touch.
						LootPool.builder()
								.with(ItemEntry.builder(dementhumScrapItem)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5, 12)))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4), true).conditionally(WITH_SILK_TOUCH))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), true).conditionally(WITH_POUNDING_TOOL))
										.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(8, 12)))
										.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 3))
										.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(14)))
								)
				)
		);
	}
	
	
	private void addGenericDirtDrop(Block dirtBlock, ItemConvertible dirtPileItem, ItemConvertible stonePebbleItem) {
		addDrop(dirtBlock, LootTable.builder()
				.pool( // Drop 'dirtPileItem'.
						LootPool.builder()
								.with(ItemEntry.builder(dirtPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
				)
				.pool( // Sometimes drop a bonus stone pebble, increased chance with Fortune.
						LootPool.builder()
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
										0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
								.with(ItemEntry.builder(stonePebbleItem))
				)
		);
	}
	
	
	private void addGlassBlockAndPaneDrops(Block glassBlock, Block glassPaneBlock, ItemConvertible paneItem) {
		// Block
		addDrop(glassBlock, makeItemAOrItemBWithSilkTouchLootTable(ModItems.GLASS_SHARD, 8, paneItem, 8));
		// Pane
		addDrop(glassPaneBlock, makeItemOrBlockWithSilkTouchLootTable(glassPaneBlock, ModItems.GLASS_SHARD));
	}
	
	
	private void addGravelDrop(Block gravelBlock, ItemConvertible pileItem, ItemConvertible flintItem) {
		addDrop(gravelBlock, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(pileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
						// Doesn't Work; group entry only drops 1 item entry per group instead of all item entries.
								// TODO: Get this to drop one of two loot tables instead?
								//  (we need to figure out how to drop a loot table as a pool entry)
//								.with(AlternativeEntry.builder(
//										// 8 piles, from Silk Touch or 63/64 chance.
//										ItemEntry.builder(pileItem)
//												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
//												.conditionally(
//														WITH_SILK_TOUCH
//														.or(RandomChanceLootCondition.builder(0.984375F))
//												),
//										// 7 piles, 1 guaranteed flint, and a chance of 1 bonus flint based on Fortune.
//										GroupEntry.create(
//												ItemEntry.builder(pileItem)
//														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
//												ItemEntry.builder(flintItem),
//												ItemEntry.builder(flintItem)
//														.conditionally(TableBonusLootCondition.builder(
//																Enchantments.FORTUNE,
//																0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F)
//														)
//										)
//								))
				)
				.pool( // Chance of 1 bonus flint based on Fortune, requiring being mined with a shovel.
						LootPool.builder()
								.with(ItemEntry.builder(flintItem)
										.conditionally(WITH_SHOVEL_TOOL.and(TableBonusLootCondition.builder(
												Enchantments.FORTUNE,
												0.0078125F, 0.015625F, 0.03125F, 0.0625F, 0.125F)
										))
								)
				)
		);
	}
	
	
	private void addPodzolDirtDrop(
			Block podzolDirtBlock, ItemConvertible dirtPileItem,
			ItemConvertible bonemealBallItem, ItemConvertible clayBallItem,
			ItemConvertible brownMushroomItem, ItemConvertible redMushroomItem) {
		addDrop(podzolDirtBlock, LootTable.builder()
				.pool( // Drop 'dirtPileItem'.
						LootPool.builder()
								.with(ItemEntry.builder(dirtPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
				)
				.pool( // Sometimes drop a bonus item, increased chance with Fortune.
						LootPool.builder()
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
										0.0625F, 0.125F, 0.25F, 0.5F, 1.0F))
								.with(ItemEntry.builder(bonemealBallItem)
										.weight(27)
								)
								.with(ItemEntry.builder(clayBallItem)
										.weight(21)
								)
								.with(ItemEntry.builder(redMushroomItem)
										.weight(9)
								)
								.with(ItemEntry.builder(brownMushroomItem)
										.weight(7)
								)
				)
		);
	}
	
	
	private void addRyeGrassyDirtDrop(
			Block grassyDirtBlock, ItemConvertible dirtPileItem,
			ItemConvertible grassTuftItem, ItemConvertible seedPileItem) {
		addDrop(grassyDirtBlock, LootTable.builder()
				.pool( // Drop 'dirtPileItem'.
						LootPool.builder()
								.with(ItemEntry.builder(dirtPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
				)
				.pool( // Sometimes drop 'grassTuftItem', increased chance with Fortune.
						LootPool.builder()
								.with(ItemEntry.builder(grassTuftItem)
										.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
												0.0625F, 0.125F, 0.25F, 0.5F, 1.0F))
								)
				)
				.pool( // Sometimes drop 'seedPileItem', increased chance with Fortune.
						LootPool.builder()
								.with(ItemEntry.builder(seedPileItem)
										.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
												0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
								)
				)
		);
	}
	
	
	private void addSaplingDrop(Block sapling) {
		addDrop(sapling, makeSaplingLootTable(sapling));
	}
	
	
	private void addMushroomBlockDrop(Block block, Item item) {
		addDrop(block, makeMushroomBlockLootTable(item));
	}
	
	
	private void addMyceliumGrassyDirtDrop(
			Block grassyDirtBlock, ItemConvertible dirtPileItem,
			ItemConvertible brownMushroomItem, ItemConvertible redMushroomItem) {
		addDrop(grassyDirtBlock, LootTable.builder()
				.pool( // Drop 'dirtPileItem'.
						LootPool.builder()
								.with(ItemEntry.builder(dirtPileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
				)
				.pool( // Sometimes drop 'brownMushroomItem' or 'redMushroomItem', increased chance with Fortune.
						LootPool.builder()
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
										0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
								.with(GroupEntry.create(
										ItemEntry.builder(brownMushroomItem).weight(5),
										ItemEntry.builder(redMushroomItem).weight(7)
								))
				)
		);
	}
	
	
	private void addFireDrop(
			Block fireBlock, ItemConvertible blazePowderPileItem) {
		addDrop(fireBlock, LootTable.builder()
				.pool( // Drop 1 'blazePowderPileItem', only with Silk Touch shovel.
						LootPool.builder()
								.with(ItemEntry.builder(blazePowderPileItem)
										.conditionally(WITH_SHOVEL_TOOL)
										.conditionally(WITH_SILK_TOUCH)
								)
				)
		);
	}
	
	
	private void addSnowBlockDrops() {
		Item snowPileItem = ModItems.SNOW_PILE;
		Item freezePowderPileItem = ModItems.FREEZE_POWDER_PILE;
		// Powder Snow Block
		addDrop(Blocks.POWDER_SNOW, LootTable.builder()
				.pool( // Drop Snow Piles.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(snowPileItem)
												.conditionally(WITH_SHOVEL_TOOL)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
												.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
								))
				)
				.pool( // Drop 1 'freezePowderPileItem', only with Silk Touch shovel.
						LootPool.builder()
								.with(ItemEntry.builder(freezePowderPileItem)
										.conditionally(WITH_SHOVEL_TOOL)
										.conditionally(WITH_SILK_TOUCH)
								)
				)
		);
		// Snow Block
		addDrop(Blocks.SNOW_BLOCK, LootTable.builder()
				.pool( // Drop 8 Snow Piles.
						LootPool.builder()
								//TODO:
								// - Perhaps drop Snowballs if mined by hand.
								// - Only drop Snow Piles if mined with a proper tool.
								.with(AlternativeEntry.builder(
										ItemEntry.builder(snowPileItem)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								))
				)
				.pool( // Chance of 1 bonus of 'freezePowderPileItem', only with Silk Touch shovel.
						LootPool.builder()
								.with(ItemEntry.builder(freezePowderPileItem)
										.conditionally(WITH_SHOVEL_TOOL)
										.conditionally(WITH_SILK_TOUCH)
										.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
												0.0625F, 0.125F, 0.25F, 0.5F, 1.0F))
								)
				)
		);
		// Snow Mound
		addDrop(Blocks.SNOW, LootTable.builder()
				.pool( // Drop 1 Snow Pile per layer.
						LootPool.builder()
								.conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
								.with(
										AlternativeEntry.builder(
												SnowBlock.LAYERS.getValues(),
												integer -> ItemEntry.builder(snowPileItem)
														.conditionally(BlockStatePropertyLootCondition.builder(Blocks.SNOW).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, integer)))
														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer)))
										)
								)
				)
				.pool( // Chance of 1 bonus of 'freezePowderPileItem', only with Silk Touch shovel.
						// TODO: Reduce chances, and roll once for each layer.
						LootPool.builder()
								.with(ItemEntry.builder(freezePowderPileItem)
										.conditionally(WITH_SHOVEL_TOOL)
										.conditionally(WITH_SILK_TOUCH)
										.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
												0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
								)
				)
		);
	}
	//endregion
	
	
	//region ## Loot Table Builders (decoration & utility) ##
	private static LootTable.Builder makeBulbLootTable(ItemConvertible ingotItem) {
		return LootTable.builder()
				.pool(makeSingleItemPool(ingotItem, 4))
				.pool(makeSingleItemPool(Items.REDSTONE, 4))
				.pool(LootPool.builder().with(ItemEntry.builder(Blocks.GLOWSTONE))
						// TODO: Drop a Lumithite Chunk instead upon implementation.
				);
	}
	
	
	private static LootTable.Builder makeDoorLootTable(Block doorBlock, ItemConvertible materialItem) {
		return LootTable.builder()
				.pool( // Drop 3 material items from each half of the door.
						LootPool.builder()
								.with(ItemEntry.builder(materialItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
								)
				)
				.pool( // Drop 2 iron grams from the bottom half of the door, and 1 from the top half.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(ModItems.IRON_GRAM)
												.conditionally(BlockStatePropertyLootCondition.builder(doorBlock).properties(StatePredicate.Builder.create().exactMatch(DoorBlock.HALF, DoubleBlockHalf.LOWER)))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))),
										ItemEntry.builder(ModItems.IRON_GRAM)
								))
				);
	}
	
	
	private static LootTable.Builder makeHatchLootTable(ItemConvertible materialItem) {
		return LootTable.builder()
				.pool( // Drop 3 material items.
						LootPool.builder()
								.with(ItemEntry.builder(materialItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
								)
				)
				.pool( // Drop 2 iron grams.
						LootPool.builder()
								.with(ItemEntry.builder(ModItems.IRON_GRAM)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
								)
				);
	}
	
	
	private static LootTable.Builder makeWorkbenchLootTable(
			ItemConvertible block, ItemConvertible item, int itemCount
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch or pounding tool.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH.or(WITH_POUNDING_TOOL)),
										// Drop item if mined without Silk Touch or pounding tool.
										ItemEntry.builder(item)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCount)))
								))
				)
				.pool( // Drop a funny little bonus item if mined with particular items.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop Zombie Villager Spawn Egg if mined with a Cactus.
										ItemEntry.builder(Items.ZOMBIE_VILLAGER_SPAWN_EGG)
												.conditionally(WITH_CACTUS),
										// Drop randomly enchanted Book if mined with a Cake.
										ItemEntry.builder(Items.BOOK)
												.apply(new EnchantRandomlyLootFunction.Builder())
												.conditionally(WITH_CAKE),
										// Drop Nutrillarn Ingot if mined with a Cookie.
										ItemEntry.builder(JAUItems.NUTRILLARN_INGOT)
												.conditionally(WITH_COOKIE),
										// Drop Iron Golem Spawn Egg if mined with an Eiduril Gram.
										ItemEntry.builder(Items.IRON_GOLEM_SPAWN_EGG)
												.conditionally(WITH_REFINED_VILBIARN_LUMP),
										// Drop Enchanted Brick if mined with a Stone Pebble.
										ItemEntry.builder(JAUItems.ENCHANTED_BRICK)
												.conditionally(WITH_STONE_PEBBLE)
								))
				);
	}
	//endregion
	
	//region ## Loot Table Builders (leaf & wart blocks) ##
	private static LootTable.Builder makeLeafBlockBaseDropsLootTable() {
		return LootTable.builder()
				.pool(makeLeafBlockStickDropLootPool())
				.pool(makeLeafBlockLeafDropLootPool());
	}
	
	
	private static LootTable.Builder makeAcaciaLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.ACACIA_SAPLING, -60.0F, 3.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeAzaleaLeafBlockLootTable(ItemConvertible azaleaItem) {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						azaleaItem, -60.0F, 3.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeBirchLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.BIRCH_SAPLING, -60.0F, 3.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeCherryLeafBlockLootTable() {
		return LootTable.builder()
				.pool(makeLeafBlockStickDropLootPool())
				.pool(makeCherryLeafBlockLeafDropLootPool())
				.pool(makeCherryLeafBlockPetalDropLootPool())
				.pool(makeLeafBlockBonusDropLootPool(
						Items.CHERRY_SAPLING, -62.0F, 1.0F, 1.0F, 2.0F))
				.pool(makeLeafBlockBonusDropLootPool(
						ModItems.CHERRY_BUNCH, -14.0F, 1.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeDarkOakLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.DARK_OAK_SAPLING, -58.0F, 5.0F, 2.0F, 3.0F))
				.pool(makeLeafBlockBonusDropLootPool(
						Items.APPLE, -253.0F, 2.0F, 2.0F, 4.0F))
				.pool(makeLeafBlockBonusDropLootPool(
						Items.GOLDEN_APPLE, -254.0F, 1.0F, 3.0F, 5.0F));
	}
	
	
	private static LootTable.Builder makeJungleLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.JUNGLE_SAPLING, -124.0F, 3.0F, 1.0F, 2.0F))
				.pool(makeLeafBlockBonusDropLootPool(
						Items.COCOA_BEANS, -124.0F, 3.0F, 1.0F, 3.0F));
	}
	
	
	private static LootTable.Builder makeOakLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.OAK_SAPLING, -60.0F, 3.0F, 1.0F, 2.0F))
				.pool(makeLeafBlockBonusDropLootPool(
						Items.APPLE, -126.0F, 1.0F, 3.0F, 10.0F));
	}
	
	
	private static LootTable.Builder makePaleOakLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						Items.OAK_SAPLING, -58.0F, 5.0F, 2.0F, 3.0F)) // TODO: Use Pale Oak Sapling instead in later Minecraft version.
				.pool(makeLeafBlockBonusDropLootPool(
						ModItems.ASH_PILE, -61.0F, 2.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeSpruceLeafBlockLootTable() {
		return makeLeafBlockBaseDropsLootTable()
				.pool(makeLeafBlockBonusDropLootPool(
						ModItems.PINECONE, -60.0F, 3.0F, 1.0F, 2.0F));
	}
	
	
	private static LootTable.Builder makeWartBlockDropLootTable(ItemConvertible item) {
		// TODO:
		//  - Ensure that the bonus from fortune is 0-2 per level.
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(item)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 3)))
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), true))
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2), true)
														.conditionally(WITH_HOE_TOOL))
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 4), true)
														.conditionally(WITH_SILK_TOUCH))
												.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
												.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(8)))
								))
				);
	}
	//endregion
	
	
	//region ## Loot Table Builders (small plants) ##
	private static LootTable.Builder makeSaplingLootTable(ItemConvertible sapling) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.conditionally(WITH_SHOVEL_TOOL.or(WITH_SILK_TOUCH))
								.with(ItemEntry.builder(sapling))
				)
				.pool(
						LootPool.builder()
								.conditionally(WITH_SHOVEL_TOOL.or(WITH_SILK_TOUCH).invert())
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
								)
				);
	}
	//endregion
	
	
	//region ## Loot Table Builders (miscellaneous) ##
	private static LootTable.Builder makeBasicItemDropLootTable(ItemConvertible item) {
		return LootTable.builder()
				.pool(LootPool.builder().with(ItemEntry.builder(item)));
	}
	
	private static LootTable.Builder makeBasicItemDropLootTable(ItemConvertible item, int count) {
		return LootTable.builder()
				.pool(LootPool.builder().with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))));
	}
	
	
	private static LootTable.Builder makeBasicDoubleItemDropLootTable(
			ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(itemA)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countA)))
								)
				)
				.pool(
				LootPool.builder()
						.with(ItemEntry.builder(itemB)
								.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countB)))
						)
		);
	}
	
	
	private static LootTable.Builder makeBedOfPigmentLootTable(Block bedBlock, ItemConvertible pigmentedYarnballItem) {
		return LootTable.builder()
				.pool( // Drop 3 sticks at each half of the bed.
						LootPool.builder()
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
								)
				)
				.pool( // Drop 2 & 1/2 rolls worth of White Yarnballs at the head of the bed, and 1 & 1/2 at the foot.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(ModItems.WHITE_YARNBALL)
												.conditionally(BlockStatePropertyLootCondition.builder(bedBlock)
														.properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(10))),
										ItemEntry.builder(ModItems.WHITE_YARNBALL)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
								))
				)
				.pool( // Drop 1/2 rolls worth of pigmented yarnballs at the head of the bed, and 1 & 1/2 at the foot.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(pigmentedYarnballItem)
												.conditionally(BlockStatePropertyLootCondition.builder(bedBlock)
														.properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))),
										ItemEntry.builder(pigmentedYarnballItem)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
								))
				);
	}
	
	
	private static LootTable.Builder makeBedOfWhiteLootTable(Block bedBlock) {
		return LootTable.builder()
				.pool( // Drop 3 sticks at each half of the bed.
						LootPool.builder()
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
								)
				)
				.pool( // Drop 12 White Yarnballs at each half of the bed.
						LootPool.builder()
								.with(ItemEntry.builder(ModItems.WHITE_YARNBALL)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(12)))
								)
				);
	}
	
	
	private static LootTable.Builder makeItemAOrItemBWithSilkTouchLootTable(
			ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		return LootTable.builder()
				.pool( // Drop the provided amount of the given item.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										ItemEntry.builder(itemB)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countB))),
										ItemEntry.builder(itemA)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countA)))
								))
				);
	}
	
	
	private static LootTable.Builder makeItemPairAOrItemPairBWithConditionLootTable(
			LootCondition.Builder condition,
			ItemConvertible itemAA, int countAA, ItemConvertible itemAB, int countAB,
			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
		return LootTable.builder()
				.pool( // Drop itemAA, or item BA with condition.
						LootPool.builder()
								.with(makeItemAOrItemBWithConditionAlternativeEntry(condition, itemAA, countAA, itemBA, countBA))
				)
				.pool( // Drop itemAB, or item BB with condition.
						LootPool.builder()
								.with(makeItemAOrItemBWithConditionAlternativeEntry(condition, itemAB, countAB, itemBB, countBB))
				);
	}
	
	
	private static LootTable.Builder makeItemPairAOrItemPairBWithSilkTouchLootTable(
			ItemConvertible itemAA, int countAA, ItemConvertible itemAB, int countAB,
			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
		return LootTable.builder()
				.pool( // Drop itemAA, or item BA with Silk Touch.
						LootPool.builder()
								.with(makeItemAOrItemBWithSilkTouchAlternativeEntry(itemAA, countAA, itemBA, countBA))
				)
				.pool( // Drop itemAB, or item BB with Silk Touch.
						LootPool.builder()
								.with(makeItemAOrItemBWithSilkTouchAlternativeEntry(itemAB, countAB, itemBB, countBB))
				);
	}
	
	
	private static LootTable.Builder makeLegacyDoorItemAOrItemBWithSilkTouchLootTable(
			Block doorBlock, ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		return LootTable.builder()
				.pool( // Drop the provided amount of the given item.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(doorBlock).properties(StatePredicate.Builder.create().exactMatch(DoorBlock.HALF, DoubleBlockHalf.LOWER)))
								.with(AlternativeEntry.builder(
										ItemEntry.builder(itemB)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countB))),
										ItemEntry.builder(itemA)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(countA)))
								))
				);
	}
	
	
	private static LootTable.Builder makeSingleItemAOrItemPairBWithConditionLootTable(
			LootCondition.Builder condition, ItemConvertible itemA, int countA,
			ItemConvertible itemBA, int countBA, ItemConvertible itemBB, int countBB) {
		return LootTable.builder()
				.pool( // Drop itemA, or item BA with condition.
						LootPool.builder()
								.with(makeConstantCountWithConditionItemEntry(condition, itemBA, countBA))
								.with(makeConstantCountItemEntry(itemA, countA))
				)
				.pool( // Drop item BB with condition.
						LootPool.builder()
								.with(makeConstantCountWithConditionItemEntry(condition, itemBB, countBB))
				);
	}
	
	
	private static LootTable.Builder makeSlabItemDropLootTable(Block slabBlock, ItemConvertible item, int count) {
		return LootTable.builder()
				.pool(makeSlabLootPool(slabBlock, item, count));
	}
	
	
	private static LootTable.Builder makeItemOrBlockWithSilkTouchLootTable(ItemConvertible block, ItemConvertible item) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH),
										// Drop item if mined without Silk Touch.
										ItemEntry.builder(item)
								))
				);
	}
	
	private static LootTable.Builder makeItemOrBlockWithSilkTouchLootTable(
			ItemConvertible block, ItemConvertible item, int itemCount
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH),
										// Drop item if mined without Silk Touch.
										ItemEntry.builder(item)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCount)))
								))
				);
	}
	
	
	private static LootTable.Builder makeItemOrBlockWithSilkTouchOrPoundingToolLootTable(
			ItemConvertible block, ItemConvertible item, int itemCount
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch or pounding tool.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH.or(WITH_POUNDING_TOOL)),
										// Drop item if mined without Silk Touch or pounding tool.
										ItemEntry.builder(item)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCount)))
								))
				);
	}
	
	
	private static LootTable.Builder makeItemPairOrBlockWithSilkTouchLootTable(
			ItemConvertible block, ItemConvertible itemA, int itemCountA, ItemConvertible itemB, int itemCountB
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH),
										// Drop item if mined without Silk Touch.
										ItemEntry.builder(itemA)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCountA)))
								))
				)
				.pool(
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(itemB)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCountB)))
								)
				);
	}
	
	
	private static LootTable.Builder makeItemPairOrBlockWithSilkTouchOrPoundingToolLootTable(
			ItemConvertible block, ItemConvertible itemA, int itemCountA, ItemConvertible itemB, int itemCountB
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH.or(WITH_POUNDING_TOOL)),
										// Drop item if mined without Silk Touch.
										ItemEntry.builder(itemA)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCountA)))
								))
				)
				.pool(
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH.and(WITHOUT_POUNDING_TOOL))
								.with(ItemEntry.builder(itemB)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemCountB)))
								)
				);
	}
	
	
	private static LootTable.Builder makeItemWithSecondaryItemOrBlockWithSilkTouchLootTable(
			ItemConvertible block,
			ItemConvertible primaryItem, int primaryAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		return makeItemOrBlockWithSilkTouchLootTable(block, primaryItem, primaryAmount)
				.pool( // Drop sticks if mined without Silk Touch.
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(secondaryItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(secondaryAmount)))
								)
				);
	}
	
	
	private static LootTable.Builder makeLogLootTable(ItemConvertible log, Item plank) {
		return LootTable.builder()
				.pool(LootPool.builder()
						// Drop log or trunk with chopping tool or Silk Touch.
						.conditionally(WITH_CHOPPING_TOOL.or(WITH_SILK_TOUCH))
						.with(AlternativeEntry.builder(
								// Drop log if mined with a Silk Touch chopping tool.
								ItemEntry.builder(log).conditionally(WITH_CHOPPING_TOOL.and(WITH_SILK_TOUCH)),
								// Drop planks if mined with either a chopping tool or a Silk Touch non-chopping tool.
								ItemEntry.builder(plank).conditionally(WITH_CHOPPING_TOOL.or(WITH_SILK_TOUCH))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6.0F))),
								// Not chopping tool nor Silk Touch; convert into sticks, with variance.
								ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0F, 12.0F)))
										.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
						))
				);
	}
	
	
	private static LootTable.Builder makeMushroomBlockLootTable(Item item) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(item)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-2, 1)))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2), true)
												.conditionally(WITH_SILK_TOUCH))
										.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
								)
				);
	}
	
	
	private static LootTable.Builder makeReinforcedStainedGlassBlockLootTable() {
		return LootTable.builder()
				.pool(makeSingleItemPool(Items.NETHERITE_SCRAP))
				.pool( // Drop 8 Glass Shards if mined without Silk Touch.
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.GLASS_SHARD)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
				)
				.pool( // Drop 8 random stained glass panes if mined with Silk Touch.
						LootPool.builder()
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.BLACK_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.BLUE_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.BROWN_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.CYAN_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.GRAY_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.GREEN_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.LIGHT_BLUE_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.LIGHT_GRAY_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.LIME_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.MAGENTA_STAINED_GLASS_PANE ))
								.with(ItemEntry.builder(ModItems.ORANGE_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.PINK_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.PURPLE_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.RED_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.WHITE_STAINED_GLASS_PANE))
								.with(ItemEntry.builder(ModItems.YELLOW_STAINED_GLASS_PANE))
								.rolls(ConstantLootNumberProvider.create(8))
				);
	}
	
	
	private static LootTable.Builder makeTrunkLootTable(ItemConvertible trunk, ItemConvertible log) {
		return LootTable.builder()
				.pool(LootPool.builder()
						// Drop log or trunk with chopping tool or Silk Touch.
						.conditionally(WITH_CHOPPING_TOOL.or(WITH_SILK_TOUCH))
						.with(AlternativeEntry.builder(
								// Drop trunk if mined with a Silk Touch chopping tool.
								ItemEntry.builder(trunk).conditionally(WITH_CHOPPING_TOOL.and(WITH_SILK_TOUCH)),
								// Drop log if mined with either a chopping tool or a Silk Touch non-chopping tool.
								ItemEntry.builder(log)
						))
				)
				.pool(LootPool.builder()
						// Drop sticks only without a Silk Touch chopping tool.
						.conditionally(WITHOUT_CHOPPING_TOOL.or(WITHOUT_SILK_TOUCH))
						.with(AlternativeEntry.builder(
								// Not chopping tool nor Silk Touch; convert entirety into sticks.
								ItemEntry.builder(Items.STICK).conditionally(WITHOUT_CHOPPING_TOOL.and(WITHOUT_SILK_TOUCH))
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(13.0F, 15.0F)))
										.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)),
								// Only provide sticks representing the bark material.
								ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
										.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
						))
				);
	}
	
	
	private static LootTable.Builder makeBasicPlankBasedBlockLootTable(
			ItemConvertible plankItem, int plankAmount
	) {
		return LootTable.builder()
				.pool( // Drop planks if mined with a chopping tool.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop unaltered raw materials if mined with proper tool or Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_SILK_TOUCH.or(WITH_REFINED_WOOD_HARVESTING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount))),
										// Drop raw materials with planks converted to sticks if mined without proper tool or Silk touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2)))
								))
				);
	}
	
	
	private static LootTable.Builder makePlankSlabLootTable(
			Block slabBlock, ItemConvertible plankItem, int plankAmount
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop planks if mined with proper tool or Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_SILK_TOUCH.or(WITH_REFINED_WOOD_HARVESTING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount)))
												// Drop twice as many planks if double slab.
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2))
														.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
												),
										// Drop sticks if mined without proper tool or Silk Touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2)))
												// Drop twice as many sticks if double slab.
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 4))
														.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
												)
								))
				);
	}
	
	
	private static LootTable.Builder makePlankBasedBlockWithSecondaryItemLootTable(
			ItemConvertible plankItem, int plankAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		return makeBasicPlankBasedBlockLootTable(plankItem, plankAmount)
				.pool( // Drop sticks if mined without Silk Touch.
						LootPool.builder()
								.with(ItemEntry.builder(secondaryItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(secondaryAmount)))
								)
				);
	}
	
	
	private static LootTable.Builder makePlankHangingSignLootTable(ItemConvertible plankItem) {
		return LootTable.builder()
				.pool( // Drop planks or sticks.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop unaltered raw materials if mined with proper tool or Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_SILK_TOUCH.or(WITH_REFINED_WOOD_HARVESTING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))),
										// Drop raw materials with planks converted to sticks if mined without proper tool or Silk touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(12)))
								))
				)
				.pool( // Drop chains.
						LootPool.builder()
								.with(ItemEntry.builder(Items.CHAIN)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
								)
				);
	}
	
	
	private static LootTable.Builder makePlankStandingSignLootTable(ItemConvertible plankItem) {
		return LootTable.builder()
				.pool( // Drop planks or sticks.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop unaltered raw materials if mined with proper tool or Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_SILK_TOUCH.or(WITH_REFINED_WOOD_HARVESTING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))),
										// Drop raw materials with planks converted to sticks if mined without proper tool or Silk touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(13)))
								))
				)
				.pool( // Drop an extra stick if mined with proper tool or Silk Touch.
						LootPool.builder()
								.with(ItemEntry.builder(Items.STICK)
										.conditionally(WITH_SILK_TOUCH.or(WITH_REFINED_WOOD_HARVESTING_TOOL))
								)
				);
	}
	
	
	private static LootTable.Builder makeNaturalStoneBlockLootTable(
			ItemConvertible cobblestoneItem, ItemConvertible pileItem, ItemConvertible shardItem
	) {
		return LootTable.builder()
				.pool( // Drop 7 or 8 cobblestones.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 8 cobblestones if mined with Silk Touch.
										ItemEntry.builder(cobblestoneItem)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8))),
										// Drop 7 cobblestones if mined without Silk Touch.
										ItemEntry.builder(cobblestoneItem)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
								))
				)
				.pool( // Drop 1 pile if mined without Silk Touch.
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(pileItem))
				)
				.pool( // Drop up to 1 shard if mined without Silk Touch, and based on Fortune level.
				LootPool.builder()
						.conditionally(WITHOUT_SILK_TOUCH)
						.conditionally(TableBonusLootCondition.builder(
								Enchantments.FORTUNE,
								0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F)
						)
						.with(ItemEntry.builder(shardItem))
				);
	}
	
	
	
	private static LootTable.Builder makeRudimentaryPlaceholderNaturalStoneBlockLootTable(
			ItemConvertible cobblestoneItem, ItemConvertible pileItem, ItemConvertible shardItem
	) {
		return LootTable.builder()
				.pool(LootPool.builder().with(AlternativeEntry.builder(ItemEntry.builder(cobblestoneItem))))
				.pool( // Drop 1 pile if mined without Silk Touch.
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(pileItem))
				)
				.pool( // Drop up to 1 shard if mined without Silk Touch, and based on Fortune level.
						LootPool.builder()
								.conditionally(WITHOUT_SILK_TOUCH)
								.conditionally(TableBonusLootCondition.builder(
										Enchantments.FORTUNE,
										0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F)
								)
								.with(ItemEntry.builder(shardItem))
				);
	}
	
	
	private static LootTable.Builder makeRudimentaryPlaceholderOreBlockLootTable(
			ItemConvertible cobblestoneItem,
			ItemConvertible oreItem, int oreMin, int oreMax
	) {
		return LootTable.builder()
				.pool(LootPool.builder().with(ItemEntry.builder(cobblestoneItem)))
				.pool(LootPool.builder()
						// Drop ore.
						.with(makeUniformCountWithFortuneBonusItemEntry(oreItem, oreMin, oreMax))
				)
				.pool(LootPool.builder()
						// Drop an extra ore if mined with Silk Touch.
						.conditionally(WITH_SILK_TOUCH)
						.with(ItemEntry.builder(oreItem))
				);
	}
	
	
	private static LootTable.Builder makeOreBlockLootTable(
			ItemConvertible cobblestoneItem,
			ItemConvertible oreItem, int oreMin, int oreMax
	) {
		return LootTable.builder()
				.pool(LootPool.builder()
						// Drop 7 cobblestones.
						.with(ItemEntry.builder(cobblestoneItem)
								.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
						)
				)
				.pool(LootPool.builder()
						// Drop ore.
						.with(makeUniformCountWithFortuneBonusItemEntry(oreItem, oreMin, oreMax))
				)
				.pool(LootPool.builder()
						// Drop an extra ore if mined with Silk Touch.
						.conditionally(WITH_SILK_TOUCH)
						.with(ItemEntry.builder(oreItem))
				);
	}
	
	
	public LootTable.Builder makeFernCropLootTable() {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								// Drop fern via Shear Pair, shovel, or Silk Touch, else drop 1-2 Live Grass Tufts.
								.with(AlternativeEntry.builder(
										ItemEntry.builder(Blocks.FERN)
												.conditionally(WITH_SHEAR_PAIR_TOOL.or(WITH_SHOVEL_TOOL).or(WITH_SILK_TOUCH)),
										ItemEntry.builder(ModItems.LIVE_GRASS_TUFT)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
								))
				);
	}
	
	
	public LootTable.Builder makeGrassCropLootTable() {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								// Drop grass tuft.
								.with(ItemEntry.builder(ModItems.LIVE_GRASS_TUFT)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
								)
				)
				.pool(
						LootPool.builder()
								// Drop wheat seeds.
								.with(ItemEntry.builder(Items.WHEAT_SEEDS))
								.conditionally(RandomChanceLootCondition.builder(0.125F))
								.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
				)
				.pool(
						LootPool.builder()
								// Drop an extra grass tuft if mined with Silk Touch or shears.
								.conditionally(WITH_SILK_TOUCH_OR_SHEARS)
								.with(ItemEntry.builder(ModItems.LIVE_GRASS_TUFT))
				);
	}
	
	public LootTable.Builder makeTallGrassLootTable(Block tallCrop) {
		// Potentially drop wheat seeds, with Fortune bonus.
		LootPoolEntry.Builder<?> seedEntry = ItemEntry.builder(Items.WHEAT_SEEDS)
				.conditionally(RandomChanceLootCondition.builder(0.125F))
				.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2));
		// Drop 2 grass tufts, or 3 with silk touch or shears.
		LootPoolEntry.Builder<?> tuftEntry = ItemEntry.builder(ModItems.LIVE_GRASS_TUFT)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))
						.conditionally(WITH_SILK_TOUCH_OR_SHEARS)
				);
		// Set up checks to only allow drops for the first tall grass block of the block pair to drop loot.
		LootCondition.Builder isBottom = BlockStatePropertyLootCondition.builder(tallCrop)
				.properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
		LootCondition.Builder hasTop = LocationCheckLootCondition.builder(
				LocationPredicate.Builder.create()
						.block(BlockPredicate.Builder.create()
								.blocks(tallCrop)
								.state(StatePredicate.Builder.create()
										.exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER))),
				new BlockPos(0, 1, 0)
		);
		LootCondition.Builder isTop = BlockStatePropertyLootCondition.builder(tallCrop)
				.properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER));
		LootCondition.Builder hasBottom = LocationCheckLootCondition.builder(
				LocationPredicate.Builder.create()
						.block(BlockPredicate.Builder.create()
								.blocks(tallCrop)
								.state(StatePredicate.Builder.create()
										.exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER))),
				new BlockPos(0, -1, 0)
		);
		LootCondition.Builder isBottomAndHasTop = isBottom.and(hasTop);
		LootCondition.Builder isTopAndHasBottom = isTop.and(hasBottom);
		
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(seedEntry)
								.conditionally(isBottomAndHasTop)
				)
				.pool(
						LootPool.builder()
								.with(tuftEntry)
								.conditionally(isBottomAndHasTop)
				)
				.pool(
						LootPool.builder()
								.with(seedEntry)
								.conditionally(isTopAndHasBottom)
				)
				.pool(
						LootPool.builder()
								.with(tuftEntry)
								.conditionally(isTopAndHasBottom)
				);
	}
	
	
	private static LootTable.Builder makeStrippedWoodLootTable(ItemConvertible log, ItemConvertible plank) {
		return LootTable.builder()
				.pool( // Drop log if mined with a chopping tool.
						LootPool.builder()
								.conditionally(WITH_CHOPPING_TOOL)
								.with(ItemEntry.builder(log))
				)
				.pool( // Drop 2 planks if mined with a chopping tool.
						LootPool.builder()
								.conditionally(WITH_CHOPPING_TOOL)
								.with(ItemEntry.builder(plank)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
								)
				)
				.pool( // Drop 15 to 18 sticks if mined without a chopping tool (plank potential is converted to sticks).
						LootPool.builder()
								.conditionally(WITH_CHOPPING_TOOL.invert())
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(15, 18)))
								)
				);
	}
	//endregion
	
	//region ## Loot Pool Builders (basic) ##
	private static LootPool.Builder makeSingleEntryPool(LootPoolEntry.Builder<?> entry) {
		return LootPool.builder().with(entry);
	}
	
	
	private static LootPool.Builder makeSingleEntryConditionalPool(LootPoolEntry.Builder<?> entry, LootCondition.Builder condition) {
		return LootPool.builder().conditionally(condition).with(entry);
	}
	
	
	private static LootPool.Builder makeSingleItemPool(ItemConvertible item, int count) {
		if (count < 2) {
			return makeSingleItemPool(item);
		}
		return LootPool.builder().with(ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
		);
	}
	
	private static LootPool.Builder makeSingleItemPool(ItemConvertible item) {
		return LootPool.builder().with(ItemEntry.builder(item));
	}
	
	
	private static LootPool.Builder makeSingleItemConditionalPool(ItemConvertible item, int count, LootCondition.Builder condition) {
		if (count < 2) {
			return makeSingleItemConditionalPool(item, condition);
		}
		return LootPool.builder().conditionally(condition).with(ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
		);
	}
	
	private static LootPool.Builder makeSingleItemConditionalPool(ItemConvertible item, LootCondition.Builder condition) {
		return LootPool.builder().conditionally(condition).with(ItemEntry.builder(item));
	}
	
	
	private static LootPool.Builder makeDoubleEntryPool(
			LootPoolEntry.Builder<?> entryA, LootPoolEntry.Builder<?> entryB) {
		return LootPool.builder().with(entryA).with(entryB);
	}
	//endregion
	
	//region ## Loot Pool Builders (alternative) ##
	private static LootPool.Builder makeAlternativePool(LootPoolEntry.Builder<?>... entries) {
		return LootPool.builder().with(AlternativeEntry.builder(entries));
	}
	
	
	private static LootPool.Builder makeDoubleEntryAlternativePool(
			LootPoolEntry.Builder<?> entryA, LootPoolEntry.Builder<?> entryB) {
		return LootPool.builder().with(AlternativeEntry.builder(entryA, entryB));
	}
	//endregion
	
	//region ## Loot Pool Builders (slab) ##
	private static LootPool.Builder makeSlabLootPool(Block slabBlock, ItemConvertible item, LootCondition.Builder condition) {
		return LootPool.builder()
				.conditionally(condition)
				.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))
								.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
						)
				);
	}
	
	private static LootPool.Builder makeSlabLootPool(Block slabBlock, ItemConvertible item, int count, LootCondition.Builder condition) {
		return LootPool.builder()
				.conditionally(condition)
				.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count * 2))
								.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
						)
				);
	}
	
	private static LootPool.Builder makeSlabLootPool(Block slabBlock, ItemConvertible item) {
		return LootPool.builder()
				.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))
								.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
						)
				);
	}
	
	private static LootPool.Builder makeSlabLootPool(Block slabBlock, ItemConvertible item, int count) {
		return LootPool.builder()
				.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
						.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count * 2))
								.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
						)
				);
	}
	//endregion
	
	//region ## Loot Pool Builders (miscellaneous) ##
	private static LootPool.Builder makeCherryLeafBlockLeafDropLootPool() {
		return LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(
				ItemEntry.builder(ModItems.LEAF_PILE)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-62.0F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F))
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.0F, 0.25F, 0.5F, 0.75F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 4.0F))
								.conditionally(WITH_SILK_TOUCH))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 4.0F))
								.conditionally(WITH_SHEARS))
						.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(1)))
		);
	}
	
	
	private static LootPool.Builder makeCherryLeafBlockPetalDropLootPool() {
		return LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(
				ItemEntry.builder(Items.PINK_PETALS)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-28.0F, 3.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F))
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.0F, 0.25F, 0.5F, 0.75F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))
								.conditionally(WITH_SILK_TOUCH))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))
								.conditionally(WITH_SHEARS))
						.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(1)))
		);
	}
	
	
	private static LootPool.Builder makeLeafBlockBonusDropLootPool(
			ItemConvertible item, float baseMin, float baseMax, float fortuneMin, float fortuneMax
	) {
		return LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(
				ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(baseMin, baseMax)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(fortuneMin, fortuneMax))
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.0F, 0.25F, 0.5F, 0.75F, 1.0F)))
						.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(1)))
		);
	}
	
	
	private static LootPool.Builder makeLeafBlockLeafDropLootPool() {
		return LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(
				ItemEntry.builder(ModItems.LEAF_PILE)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-6.0F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F))
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.0F, 0.25F, 0.5F, 0.75F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))
								.conditionally(WITH_SILK_TOUCH))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))
								.conditionally(WITH_SHEARS))
						.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(1)))
		);
	}
	
	
	private static LootPool.Builder makeLeafBlockStickDropLootPool() {
		return LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F)).with(
				ItemEntry.builder(Items.STICK)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(-62.0F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 4.0F))
								.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.0F, 0.25F, 0.5F, 0.75F, 1.0F)))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0F, 8.0F))
								.conditionally(WITH_SILK_TOUCH))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 4.0F))
								.conditionally(WITH_SHEARS))
						.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(1)))
		);
	}
	//endregion
	
	//region ## Loot Entry Builders - Alternative Entries ##
	private static AlternativeEntry.Builder makeDoubleAlternativeEntry(
			LootPoolEntry.Builder<?> entryA, LootPoolEntry.Builder<?> entryB) {
		return AlternativeEntry.builder(entryA, entryB);
	}
	
	
	private static AlternativeEntry.Builder makeItemAOrItemBWithConditionAlternativeEntry(
			LootCondition.Builder condition, ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		return AlternativeEntry.builder(
				makeConstantCountWithConditionItemEntry(condition, itemB, countB),
				makeConstantCountItemEntry(itemA, countA));
	}
	
	
	private static AlternativeEntry.Builder makeItemAOrItemBWithSilkTouchAlternativeEntry(
			ItemConvertible itemA, int countA, ItemConvertible itemB, int countB) {
		return AlternativeEntry.builder(
				makeConstantCountWithSilkTouchItemEntry(itemB, countB),
				makeConstantCountItemEntry(itemA, countA));
	}
	//endregion
	
	//region ## Loot Entry Builders - Item Entries ##
	private static LeafEntry.Builder<?> makeConstantCountItemEntry(ItemConvertible item) {
		return ItemEntry.builder(item);
	}
	
	private static LeafEntry.Builder<?> makeConstantCountItemEntry(ItemConvertible item, int count) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)));
	}
	
	
	
	private static LeafEntry.Builder<?> makeConstantCountWithConditionItemEntry(
			ItemConvertible item, LootCondition.Builder condition
	) {
		return ItemEntry.builder(item).conditionally(condition);
	}
	
	private static LeafEntry.Builder<?> makeConstantCountWithConditionItemEntry(
			LootCondition.Builder condition, ItemConvertible item, int count
	) {
		return ItemEntry.builder(item).conditionally(condition)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)));
	}
	
	
	private static LeafEntry.Builder<?> makeConstantCountWithSilkTouchItemEntry(ItemConvertible item, int count) {
		return ItemEntry.builder(item)
				.conditionally(WITH_SILK_TOUCH)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)));
	}
	
	
	private static LeafEntry.Builder<?> makeConstantCountWithFortuneBonusItemEntry(ItemConvertible item, int count) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
				.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE));
	}
	
	
	private static LeafEntry.Builder<?> makeUniformCountItemEntry(ItemConvertible item, int min, int max
	) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)));
	}
	
	
	private static LeafEntry.Builder<?> makeUniformCountWithConditionItemEntry(
			LootCondition.Builder condition, ItemConvertible item, int min, int max
	) {
		return ItemEntry.builder(item)
				.conditionally(condition)
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)));
	}
	
	
	private static LeafEntry.Builder<?> makeUniformCountWithFortuneBonusItemEntry(ItemConvertible item, int min, int max) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
				.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE));
	}
	//endregion
}
