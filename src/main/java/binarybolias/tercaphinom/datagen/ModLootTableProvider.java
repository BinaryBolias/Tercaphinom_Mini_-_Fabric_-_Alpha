package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.*;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.CopyComponentsLootFunction;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.BlockPos;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	// TODO: Replace the tag here with a custom one ("chopping tools"?).
	public static final LootCondition.Builder WITH_CHOPPING_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.AXES));
	public static final LootCondition.Builder WITHOUT_CHOPPING_TOOL = WITH_CHOPPING_TOOL.invert();
	public static final LootCondition.Builder WITH_CHOPPING_TOOL_OR_SILK_TOUCH = WITH_CHOPPING_TOOL.or(WITH_SILK_TOUCH);
	public static final LootCondition.Builder WITH_SHOVEL_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.SHOVELS));
	
	
	@Override
	public void generate() {
		log("Generating loot table data");
		
		//region ## Material Set - Stone ##
		//# Deepslate #
		//# Netherrack #
		//# Slate #
		//# Stiefane #
		addStandardStoneBlockSetDrops(
				ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK, ModItems.GRAVEL_PILE,
				ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.COBBLED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		//# Zygolith #
		//# Ore (stiefane) #
		addOreBlockDrop(ModBlocks.STIEFANE_LAPIS_ORE,
				ModItems.STIEFANE_COBBLESTONE, Items.LAPIS_LAZULI, 5, 8);
		//endregion
		
		//region ## Material Set - Wood ##
		//# Acacia #
		addStandardPlankBlockSetDrops(ModItems.ACACIA_PLANK,
				Blocks.ACACIA_PLANKS,
				Blocks.ACACIA_BUTTON, Blocks.ACACIA_PRESSURE_PLATE,
				Blocks.ACACIA_DOOR, Blocks.ACACIA_TRAPDOOR,
				Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_FENCE,
				Blocks.ACACIA_SLAB, Blocks.ACACIA_STAIRS);
		addSignDrops(ModItems.ACACIA_PLANK, Blocks.ACACIA_SIGN, Blocks.ACACIA_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_ACACIA_LOG, ModItems.ACACIA_PLANK, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD);
		//# Birch #
		addStandardPlankBlockSetDrops(ModItems.BIRCH_PLANK,
				Blocks.BIRCH_PLANKS,
				Blocks.BIRCH_BUTTON, Blocks.BIRCH_PRESSURE_PLATE,
				Blocks.BIRCH_DOOR, Blocks.BIRCH_TRAPDOOR,
				Blocks.BIRCH_FENCE_GATE, Blocks.BIRCH_FENCE,
				Blocks.BIRCH_SLAB, Blocks.BIRCH_STAIRS);
		addSignDrops(ModItems.BIRCH_PLANK, Blocks.BIRCH_SIGN, Blocks.BIRCH_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_BIRCH_LOG, ModItems.BIRCH_PLANK, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD);
		//# Cherry #
		addStandardPlankBlockSetDrops(ModItems.CHERRY_PLANK,
				Blocks.CHERRY_PLANKS,
				Blocks.CHERRY_BUTTON, Blocks.CHERRY_PRESSURE_PLATE,
				Blocks.CHERRY_DOOR, Blocks.CHERRY_TRAPDOOR,
				Blocks.CHERRY_FENCE_GATE, Blocks.CHERRY_FENCE,
				Blocks.CHERRY_SLAB, Blocks.CHERRY_STAIRS);
		addSignDrops(ModItems.CHERRY_PLANK, Blocks.CHERRY_SIGN, Blocks.CHERRY_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_CHERRY_LOG, ModItems.CHERRY_PLANK, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD);
		//# Crimson #
		addStandardPlankBlockSetDrops(ModItems.CRIMSON_PLANK,
				Blocks.CRIMSON_PLANKS,
				Blocks.CRIMSON_BUTTON, Blocks.CRIMSON_PRESSURE_PLATE,
				Blocks.CRIMSON_DOOR, Blocks.CRIMSON_TRAPDOOR,
				Blocks.CRIMSON_FENCE_GATE, Blocks.CRIMSON_FENCE,
				Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STAIRS);
		addSignDrops(ModItems.CRIMSON_PLANK, Blocks.CRIMSON_SIGN, Blocks.CRIMSON_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_STEM);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_CRIMSON_STEM, ModItems.CRIMSON_PLANK, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE);
		//# Dark Oak #
		addStandardPlankBlockSetDrops(ModItems.DARK_OAK_PLANK,
				Blocks.DARK_OAK_PLANKS,
				Blocks.DARK_OAK_BUTTON, Blocks.DARK_OAK_PRESSURE_PLATE,
				Blocks.DARK_OAK_DOOR, Blocks.DARK_OAK_TRAPDOOR,
				Blocks.DARK_OAK_FENCE_GATE, Blocks.DARK_OAK_FENCE,
				Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_STAIRS);
		addSignDrops(ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_SIGN, Blocks.DARK_OAK_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_DARK_OAK_LOG, ModItems.DARK_OAK_PLANK, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD);
		//# Mahogany #
		addStandardPlankBlockSetDrops(ModItems.MAHOGANY_PLANK,
				Blocks.JUNGLE_PLANKS,
				Blocks.JUNGLE_BUTTON, Blocks.JUNGLE_PRESSURE_PLATE,
				Blocks.JUNGLE_DOOR, Blocks.JUNGLE_TRAPDOOR,
				Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_FENCE,
				Blocks.JUNGLE_SLAB, Blocks.JUNGLE_STAIRS);
		addSignDrops(ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_SIGN, Blocks.JUNGLE_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_JUNGLE_LOG, ModItems.MAHOGANY_PLANK, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD);
		//# Mangrove #
		addStandardPlankBlockSetDrops(ModItems.MANGROVE_PLANK,
				Blocks.MANGROVE_PLANKS,
				Blocks.MANGROVE_BUTTON, Blocks.MANGROVE_PRESSURE_PLATE,
				Blocks.MANGROVE_DOOR, Blocks.MANGROVE_TRAPDOOR,
				Blocks.MANGROVE_FENCE_GATE, Blocks.MANGROVE_FENCE,
				Blocks.MANGROVE_SLAB, Blocks.MANGROVE_STAIRS);
		addSignDrops(ModItems.MANGROVE_PLANK, Blocks.MANGROVE_SIGN, Blocks.MANGROVE_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_MANGROVE_LOG, ModItems.MANGROVE_PLANK, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD);
		//# Oak #
		addStandardPlankBlockSetDrops(ModItems.OAK_PLANK,
				Blocks.OAK_PLANKS,
				Blocks.OAK_BUTTON, Blocks.OAK_PRESSURE_PLATE,
				Blocks.OAK_DOOR, Blocks.OAK_TRAPDOOR,
				Blocks.OAK_FENCE_GATE, Blocks.OAK_FENCE,
				Blocks.OAK_SLAB, Blocks.OAK_STAIRS);
		addSignDrops(ModItems.OAK_PLANK, Blocks.OAK_SIGN, Blocks.OAK_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_OAK_LOG, ModItems.OAK_PLANK, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD);
		//# Spruce #
		addStandardPlankBlockSetDrops(ModItems.SPRUCE_PLANK,
				Blocks.SPRUCE_PLANKS,
				Blocks.SPRUCE_BUTTON, Blocks.SPRUCE_PRESSURE_PLATE,
				Blocks.SPRUCE_DOOR, Blocks.SPRUCE_TRAPDOOR,
				Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_FENCE,
				Blocks.SPRUCE_SLAB, Blocks.SPRUCE_STAIRS);
		addSignDrops(ModItems.SPRUCE_PLANK, Blocks.SPRUCE_SIGN, Blocks.SPRUCE_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_SPRUCE_LOG, ModItems.SPRUCE_PLANK, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD);
		//# Verdak #
		addStandardPlankBlockSetDrops(ModItems.VERDAK_PLANK,
				ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_FENCE_GATE, ModBlocks.VERDAK_FENCE_POST,
				ModBlocks.VERDAK_PLANK_SLAB, ModBlocks.VERDAK_PLANK_STAIR);
		// TODO: Add Standing Verdak Sign and Hanging Verdak Sign.
		addLogAndTrunkDrops(ModBlocks.VERDAK_LOG, ModBlocks.VERDAK_TRUNK);
		// Note: No "Wood" blocks for verdak;
		//  - The "Wood"/"Hyphae" and "Stripped Wood"/"Stripped Hyphae" blocks are not canonical to Tercaphinom.
		//# Warped #
		addStandardPlankBlockSetDrops(ModItems.WARPED_PLANK,
				Blocks.WARPED_PLANKS,
				Blocks.WARPED_BUTTON, Blocks.WARPED_PRESSURE_PLATE,
				Blocks.WARPED_DOOR, Blocks.WARPED_TRAPDOOR,
				Blocks.WARPED_FENCE_GATE, Blocks.WARPED_FENCE,
				Blocks.WARPED_SLAB, Blocks.WARPED_STAIRS);
		addSignDrops(ModItems.WARPED_PLANK, Blocks.WARPED_SIGN, Blocks.WARPED_HANGING_SIGN);
		addLogAndTrunkDrops(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_STEM);
		addWoodAndStrippedWoodDrops(
				Blocks.STRIPPED_WARPED_STEM, ModItems.WARPED_PLANK, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
		//endregion
		
		//region ## Storage ##
		// Chest
		// NOTE: Dropping oak as placeholder for alternative chest variants.
		addItemPairAOrItemPairBWithConditionDrop(
				Blocks.CHEST, WITH_CHOPPING_TOOL_OR_SILK_TOUCH,
				ModItems.WOODEN_STICK_BUNDLE, 4, Items.IRON_NUGGET, 1,
				ModItems.OAK_PLANK, 8, ModItems.IRON_GRAM, 1);
//		addItemOrBlockWithSilkTouchDrop(Blocks.CHEST, ModItems.OAK_PLANK, 8);
		// Ender Chest
		addItemOrBlockWithSilkTouchDrop(Blocks.ENDER_CHEST, ModItems.OBSIDIAN_SHARD, 8);
		
		//region ## Workstations ##
		// Crafting Table
		// NOTE: Dropping Oak Plank as a placeholder; there may rather be different crafting table variants for different plank types.
		addBasicDoubleItemDrop(Blocks.CRAFTING_TABLE, ModItems.OAK_PLANK, 2, ModItems.WOODEN_STICK_BUNDLE, 2);
		
		//region ## Miscellaneous ##
		addBasicItemDrop(ModBlocks.ASH_BLOCK, ModItems.ASH_PILE, 8);
		//endregion
		
		//region ## Various Vanilla Overrides ##
		// Beds
		addBedOfPigmentDrop(Blocks.BLACK_BED, Blocks.BLACK_CARPET);
		addBedOfPigmentDrop(Blocks.BLUE_BED, Blocks.BLUE_CARPET);
		addBedOfPigmentDrop(Blocks.BROWN_BED, Blocks.BROWN_CARPET);
		addBedOfPigmentDrop(Blocks.CYAN_BED, Blocks.CYAN_CARPET);
		addBedOfPigmentDrop(Blocks.GRAY_BED, Blocks.GRAY_CARPET);
		addBedOfPigmentDrop(Blocks.GREEN_BED, Blocks.GREEN_CARPET);
		addBedOfPigmentDrop(Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_BLUE_CARPET);
		addBedOfPigmentDrop(Blocks.LIGHT_GRAY_BED, Blocks.LIGHT_GRAY_CARPET);
		addBedOfPigmentDrop(Blocks.LIME_BED, Blocks.LIME_CARPET);
		addBedOfPigmentDrop(Blocks.MAGENTA_BED, Blocks.MAGENTA_CARPET);
		addBedOfPigmentDrop(Blocks.ORANGE_BED, Blocks.ORANGE_CARPET);
		addBedOfPigmentDrop(Blocks.PINK_BED, Blocks.PINK_CARPET);
		addBedOfPigmentDrop(Blocks.PURPLE_BED, Blocks.PURPLE_CARPET);
		addBedOfPigmentDrop(Blocks.RED_BED, Blocks.RED_CARPET);
		addBedOfWhiteDrop(Blocks.WHITE_BED);
		addBedOfPigmentDrop(Blocks.YELLOW_BED, Blocks.YELLOW_CARPET);
		// Bone Block
		//  - With Silk Touch, 8 Bones.
		//  - Without Silk Touch, 6 Bones and 4-6 Bonemeal.
		addDrop(Blocks.BONE_BLOCK, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
								makeConstantCountWithConditionItemEntry(WITH_SILK_TOUCH, Items.BONE, 8),
								makeConstantCountItemEntry(Items.BONE, 6)
						)
				)
				.pool(makeSingleEntryPool(
						makeUniformCountWithConditionItemEntry(WITHOUT_SILK_TOUCH, Items.BONE_MEAL, 4, 6)
				))
		);
		// Brick Block (clay bricks)
		addDrop(Blocks.BRICKS, LootTable.builder()
				.pool(makeSingleEntryPool(
						makeConstantCountItemEntry(Items.BRICK, 8)
				))
				.pool(makeSingleEntryPool(
						makeConstantCountWithConditionItemEntry(WITH_SILK_TOUCH, Items.CLAY_BALL, 1)
				))
		);
		// Clay Block
		addDrop(Blocks.CLAY, LootTable.builder()
				.pool(makeDoubleEntryAlternativePool(
								makeConstantCountWithConditionItemEntry(WITH_SILK_TOUCH, Items.CLAY_BALL, 8),
								makeUniformCountWithFortuneBonusItemEntry(Items.CLAY_BALL, 6, 8)
										.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(8)))
						)
				)
		);
		// Coarse Dirt
		addCoarseDirtDrop(Blocks.COARSE_DIRT, ModItems.DIRT_PILE, ModItems.GRAVEL_PILE, Items.FLINT);
		// Dirt
		addBasicItemDrop(Blocks.DIRT, ModItems.DIRT_PILE,8);
		// Glass
		addItemAOrItemBWithSilkTouchDrop(Blocks.GLASS, ModItems.GLASS_SHARD, 8, Blocks.GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.BLACK_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.BLACK_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.BLUE_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.BLUE_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.BROWN_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.BROWN_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.CYAN_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.CYAN_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.GRAY_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.GRAY_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.GREEN_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.GREEN_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.LIGHT_BLUE_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.LIGHT_GRAY_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.LIME_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.LIME_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.MAGENTA_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.MAGENTA_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.ORANGE_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.ORANGE_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.PINK_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.PINK_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.PURPLE_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.PURPLE_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.RED_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.RED_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.WHITE_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.WHITE_STAINED_GLASS_PANE, 8);
		addItemAOrItemBWithSilkTouchDrop(Blocks.YELLOW_STAINED_GLASS, ModItems.GLASS_SHARD, 8,
				Blocks.YELLOW_STAINED_GLASS_PANE, 8);
		addItemOrBlockWithSilkTouchDrop(Blocks.GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.BLACK_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.BLUE_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.BROWN_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.CYAN_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.GRAY_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.GREEN_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.LIME_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.MAGENTA_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.ORANGE_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.PINK_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.PURPLE_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.RED_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.WHITE_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		addItemOrBlockWithSilkTouchDrop(Blocks.YELLOW_STAINED_GLASS_PANE, ModItems.GLASS_SHARD, 1);
		// Grass
		addShortGrassAndTallGrassDrops(Blocks.SHORT_GRASS, Blocks.TALL_GRASS);
		// Gravel
		addGravelDrop(Blocks.GRAVEL, ModItems.GRAVEL_PILE, Items.FLINT);
		// Iron
		addLegacyDoorItemAOrItemBWithSilkTouchDrop(Blocks.IRON_DOOR, Items.RAW_IRON, 6, Items.IRON_INGOT, 6);
		addItemAOrItemBWithSilkTouchDrop(Blocks.IRON_TRAPDOOR, Items.RAW_IRON, 3, Items.IRON_INGOT, 3);
		// Moss
		addBasicItemDrop(Blocks.MOSS_BLOCK, Blocks.MOSS_CARPET, 8);
		// Obsidian
		addBasicItemDrop(Blocks.OBSIDIAN, ModItems.OBSIDIAN_SHARD, 8);
		// Snow Block & Snow Mound
		addPowderSnowBlockDrop(Blocks.POWDER_SNOW, Items.SNOWBALL, Items.SUGAR); // TODO: Replace Sugar with Freeze Powder Pile.
		addSnowBlockDrop(Blocks.SNOW_BLOCK, Items.SNOWBALL, Items.SUGAR); // TODO: Replace Sugar with Freeze Powder Pile.
		addSnowMoundDrop(Blocks.SNOW, Items.SNOWBALL, Items.SUGAR); // TODO: Replace Sugar with Freeze Powder Pile.
		// Spawner
		addDrop(Blocks.SPAWNER, LootTable.builder()
				.pool(
						LootPool.builder() // Newest; just having an empty spawner drop. Spawn eggs could be craftable in survival via the Miniwizard.
								.with(ItemEntry.builder(Blocks.SPAWNER)
								)
//						LootPool.builder() // New.
//								.with(ItemEntry.builder(Blocks.SPAWNER)
//										.apply(CopyComponentsLootFunction.builder(CopyComponentsLootFunction.Source.BLOCK_ENTITY)
//												.include(DataComponentTypes.ENTITY_DATA))
//								)
//						LootPool.builder() // Old. TODO: Doesn't work; fix this to retain block entity data.
//								.with(ItemEntry.builder(Blocks.SPAWNER)
//										.apply(CopyComponentsLootFunction.builder(CopyComponentsLootFunction.Source.BLOCK_ENTITY))
//								)
				));
		// Wool
		addBasicItemDrop(Blocks.BLACK_WOOL, Blocks.BLACK_CARPET, 8);
		addBasicItemDrop(Blocks.BLUE_WOOL, Blocks.BLUE_CARPET, 8);
		addBasicItemDrop(Blocks.BROWN_WOOL, Blocks.BROWN_CARPET, 8);
		addBasicItemDrop(Blocks.CYAN_WOOL, Blocks.CYAN_CARPET, 8);
		addBasicItemDrop(Blocks.GRAY_WOOL, Blocks.GRAY_CARPET, 8);
		addBasicItemDrop(Blocks.GREEN_WOOL, Blocks.GREEN_CARPET, 8);
		addBasicItemDrop(Blocks.LIGHT_BLUE_WOOL, Blocks.LIGHT_BLUE_CARPET, 8);
		addBasicItemDrop(Blocks.LIGHT_GRAY_WOOL, Blocks.LIGHT_GRAY_CARPET, 8);
		addBasicItemDrop(Blocks.LIME_WOOL, Blocks.LIME_CARPET, 8);
		addBasicItemDrop(Blocks.MAGENTA_WOOL, Blocks.MAGENTA_CARPET, 8);
		addBasicItemDrop(Blocks.ORANGE_WOOL, Blocks.ORANGE_CARPET, 8);
		addBasicItemDrop(Blocks.PINK_WOOL, Blocks.PINK_CARPET, 8);
		addBasicItemDrop(Blocks.PURPLE_WOOL, Blocks.PURPLE_CARPET, 8);
		addBasicItemDrop(Blocks.RED_WOOL, Blocks.RED_CARPET, 8);
		addBasicItemDrop(Blocks.WHITE_WOOL, Blocks.WHITE_CARPET, 8);
		addBasicItemDrop(Blocks.YELLOW_WOOL, Blocks.YELLOW_CARPET, 8);
		//endregion
		
		//region ## Joke & Unserious ##
		// Cheese
		addDrop(ModBlocks.BLUE_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 7 blue cheese wedges with Silk Touch, or 8 without.
										ItemEntry.builder(ModItems.BLUE_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
										ItemEntry.builder(ModItems.BLUE_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 silky smooth cheese wedge with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.SILKY_SMOOTH_CHEESE_WEDGE))
				));
		addDrop(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 8 silky smooth cheese wedges with Silk Touch, or 7 without.
										ItemEntry.builder(ModItems.SILKY_SMOOTH_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8))),
										ItemEntry.builder(ModItems.SILKY_SMOOTH_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 yellow cheese wedge without Silk Touch.
								.conditionally(WITHOUT_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.YELLOW_CHEESE_WEDGE))
				));
		addDrop(ModBlocks.YELLOW_CHEESE_BLOCK, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop 7 yellow cheese wedges with Silk Touch, or 8 without.
										ItemEntry.builder(ModItems.YELLOW_CHEESE_WEDGE)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
										ItemEntry.builder(ModItems.YELLOW_CHEESE_WEDGE)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop 1 silky smooth cheese wedge with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(ModItems.SILKY_SMOOTH_CHEESE_WEDGE))
				));
		// Miscellaneous
		addItemOrBlockWithSilkTouchDrop(ModBlocks.HYPERSMOOTH_CREAMSTONE, ModBlocks.ULTRASMOOTH_STONE, 1);
		addItemOrBlockWithSilkTouchDrop(ModBlocks.ULTRASMOOTH_STONE, Blocks.SMOOTH_STONE, 1);
		//endregion
	}
	
	//region ## Drop Adder Sets ##
	private void addShortGrassAndTallGrassDrops(Block shortGrassBlock, Block tallGrassBlock) {
		addDrop(shortGrassBlock, makeGrassCropLootTable());
		addDrop(tallGrassBlock, makeTallGrassLootTable(tallGrassBlock));
	}
	
	
	private void addLogAndTrunkDrops(Block log, Block trunk) {
		addDrop(log, makeLogLootTable(log));
		// TODO: Make this loot table link to the corresponding log loot table directly, dropping everything the log drops.
		//  - Same technique as sheep color variants.
		addDrop(trunk, makeLogLootTable(log).pool(LootPool.builder().with(
						ItemEntry.builder(Items.STICK)
								.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
								.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
				)
		));
	}
	
	
	private void addSignDrops(ItemConvertible plankItem, Block standingSign, Block hangingSign) {
		addDrop(standingSign, makePlankStandingSignLootTable(plankItem));
		addDrop(hangingSign, makePlankHangingSignLootTable(plankItem));
	}
	
	
	private void addStandardPlankBlockSetDrops(
			ItemConvertible plankItem,
			Block plankBlock,
			Block button, Block pressurePlate,
			Block door, Block hatch,
			Block fenceGate, Block fencePost,
			Block slab, Block stair
	) {
		// Plank Block
		addBasicPlankBasedDrop(plankBlock, plankItem, 8);
		// Button
		addPlankBasedBlockWithSecondaryItemDrop(button, plankItem, 1, Items.REDSTONE, 1);
		// Pressure Plate
		addPlankBasedBlockWithSecondaryItemDrop(pressurePlate, plankItem, 2, Items.REDSTONE, 1);
		// Door
		addLegacyDoorItemAOrItemBWithSilkTouchDrop(door, Items.STICK, 12, plankItem, 6);
		// Hatch
		addBasicPlankBasedDrop(hatch, plankItem, 3);
		// Fence Gate
		addPlankBasedBlockWithSecondaryItemDrop(fenceGate, plankItem, 1, Items.STICK, 4);
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
	
	//region ## Generic Drop Adders ##
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
	
	
	private void addItemOrBlockWithSilkTouchDrop(Block block, ItemConvertible item, int amount) {
		addDrop(block, makeItemOrBlockWithSilkTouchLootTable(block, item, amount));
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
	private void addBedOfPigmentDrop(Block block, ItemConvertible pigmentedCarpetItem) {
		addDrop(block, makeBedOfPigmentLootTable(block, pigmentedCarpetItem));
	}
	
	
	private void addBedOfWhiteDrop(Block block) {
		addDrop(block, makeBedOfWhiteLootTable(block));
	}
	
	
	private void addCoarseDirtDrop(Block coarseDirtBlock, ItemConvertible dirtPileItem, ItemConvertible gravelPileItem, ItemConvertible flintItem) {
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
		);
	}
	
	
	private void addGravelDrop(Block gravelBlock, ItemConvertible pileItem, ItemConvertible flintItem) {
		addDrop(gravelBlock, LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(pileItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
								)
						// Doesn't Work; group entry only drops 1 item entry per group instead of all item entries.
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
	
	
	private void addPowderSnowBlockDrop(
			Block powderSnowBlock, ItemConvertible snowballItem, ItemConvertible freezePowderPileItem) {
		addDrop(powderSnowBlock, LootTable.builder()
				.pool( // Drop 'snowballItem'.
						LootPool.builder()
								// TODO: Require that the block was mined by hand or (any) tool.
								.with(AlternativeEntry.builder(
										ItemEntry.builder(snowballItem)
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
	}
	
	
	private void addSnowBlockDrop(Block snowBlock, ItemConvertible snowballItem, ItemConvertible freezePowderPileItem) {
		addDrop(snowBlock, LootTable.builder()
				.pool( // Up to 32 of 'snowballItem'.
						LootPool.builder()
								// TODO: Require that the block was mined by hand or (any) tool.
								.with(AlternativeEntry.builder(
										ItemEntry.builder(snowballItem)
												.conditionally(WITH_SHOVEL_TOOL)
												.conditionally(WITH_SILK_TOUCH)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(24, 36)))
												.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 6))
												.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(32))),
										ItemEntry.builder(snowballItem)
												.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8, 16)))
												.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 6))
												.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(32)))
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
	}
	
	
	private void addSnowMoundDrop(Block snowMound, ItemConvertible snowballItem, ItemConvertible freezePowderPileItem) {
		// Original.
//		addDrop(snowMound, LootTable.builder()
//						.pool( // Up to 4 of 'snowballItem'.
//								LootPool.builder()
//										// TODO: Require that the block was mined by hand or (any) tool.
//										.with(AlternativeEntry.builder(
//												ItemEntry.builder(snowballItem)
//														.conditionally(WITH_SHOVEL_TOOL)
//														.conditionally(WITH_SILK_TOUCH)
//														.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 5)))
//											        	.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 3))
//														.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(4))),
//												ItemEntry.builder(snowballItem)
//														.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
//											        	.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 3))
//														.apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.createMax(4)))
//										))
//						)
//						.pool( // Chance of 1 bonus of 'freezePowderPileItem', only with Silk Touch shovel.
//								LootPool.builder()
//										.with(ItemEntry.builder(freezePowderPileItem)
//												.conditionally(WITH_SHOVEL_TOOL)
//												.conditionally(WITH_SILK_TOUCH)
//												.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE,
//														0.015625F, 0.03125F, 0.0625F, 0.125F, 0.25F))
//										)
//						)
//		);
		addDrop(snowMound, LootTable.builder()
//				.pool( // WIP; would ideally provide up to 4 Snowballs per layer, affected by Silk Touch and Fortune.
//						LootPool.builder()
//								.conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
//								.with(
//										AlternativeEntry.builder(
//												AlternativeEntry.builder(
//																SnowBlock.LAYERS.getValues(),
//																integer -> ItemEntry.builder(Items.SNOWBALL)
//																		.conditionally(BlockStatePropertyLootCondition.builder(snowMound).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, integer)))
//																		.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)integer.intValue())))
//														)
//														.conditionally(WITH_SILK_TOUCH),
//												AlternativeEntry.builder(
//														SnowBlock.LAYERS.getValues(),
//														integer -> ItemEntry.builder(Items.SNOWBALL)
//																.conditionally(BlockStatePropertyLootCondition.builder(snowMound).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, integer)))
//																.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)integer.intValue())))
//												)
//										)
//								)
//				)
				.pool( // Simplified version; only 1 Snowball per layer.
						LootPool.builder()
								.conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS))
								.with(
										AlternativeEntry.builder(
												SnowBlock.LAYERS.getValues(),
												integer -> ItemEntry.builder(Items.SNOWBALL)
														.conditionally(BlockStatePropertyLootCondition.builder(snowMound).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, integer)))
														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)integer.intValue())))
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
	
	//region ## Loot Table Builders ##
	private static LootTable.Builder makeBasicItemDropLootTable(ItemConvertible item, int count) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(item)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
								)
				);
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
	
	
	private static LootTable.Builder makeBedOfPigmentLootTable(Block bedBlock, ItemConvertible pigmentedCarpetItem) {
		return LootTable.builder()
				.pool( // Drop sticks.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(bedBlock).properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
								)
				)
				.pool( // Drop White Carpets.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(bedBlock).properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
								.with(ItemEntry.builder(Blocks.WHITE_CARPET)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4)))
								)
				)
				.pool( // Drop pigmented carpets.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(bedBlock).properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
								.with(ItemEntry.builder(pigmentedCarpetItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
								)
				);
	}
	
	
	private static LootTable.Builder makeBedOfWhiteLootTable(Block bedBlock) {
		return LootTable.builder()
				.pool( // Drop sticks.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(bedBlock).properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
								)
				)
				.pool( // Drop White Carpets.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(bedBlock).properties(StatePredicate.Builder.create().exactMatch(BedBlock.PART, BedPart.HEAD)))
								.with(ItemEntry.builder(Blocks.WHITE_CARPET)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
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
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(item)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count * 2))
												.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
										)
								)
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
	
	private static LootTable.Builder makeLogLootTable(ItemConvertible log) {
		return LootTable.builder()
				.pool( // Drop self if mined with a chopping tool.
						LootPool.builder()
								.conditionally(WITH_CHOPPING_TOOL)
								.with(ItemEntry.builder(log))
				)
				.pool( // Drop 12 to 14 sticks if mined without a chopping tool (plank potential is converted to sticks).
						// NOTE: 6 planks from log via workbench crafting, 7 planks via sawmill crafting.
						LootPool.builder()
								.conditionally(WITH_CHOPPING_TOOL.invert())
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(12.0F, 14.0F)))
								)
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
												.conditionally(WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount))),
										// Drop raw materials with planks converted to sticks if mined without proper tool or Silk touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2)))
								))
				);
	}
	
	// Old.
//	private static LootTable.Builder makeBasicPlankBasedBlockLootTable(
//			ItemConvertible plankBlock, ItemConvertible plankItem, int plankAmount
//	) {
//		return LootTable.builder()
//				.pool( // Drop planks if mined with a chopping tool.
//						LootPool.builder()
//								.with(AlternativeEntry.builder(
//										// Drop self or raw materials if mined with appropriate tool.
//										AlternativeEntry.builder(
//												// Drop block if mined with appropriate tool and Silk Touch.
//												ItemEntry.builder(plankBlock)
//														.conditionally(WITH_SILK_TOUCH),
//												// Drop planks if mined with appropriate tool and without Silk Touch.
//												ItemEntry.builder(plankItem)
//														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount)))
//										).conditionally(WITH_CHOPPING_TOOL),
//										// Drop raw materials with planks converted to sticks if mined without appropriate tool.
//										ItemEntry.builder(Items.STICK)
//												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2)))
//								))
//				);
//	}
	
	
	private static LootTable.Builder makePlankSlabLootTable(
			Block slabBlock, ItemConvertible plankItem, int plankAmount
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop planks if mined with proper tool or Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL))
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
												.conditionally(WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL))
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
												.conditionally(WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL))
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))),
										// Drop raw materials with planks converted to sticks if mined without proper tool or Silk touch.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(13)))
								))
				)
				.pool( // Drop an extra stick if mined with proper tool or Silk Touch.
						LootPool.builder()
								.with(ItemEntry.builder(Items.STICK)
										.conditionally(WITH_SILK_TOUCH.or(WITH_CHOPPING_TOOL))
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
	
	private static LootTable.Builder makeOreBlockLootTable(
			ItemConvertible cobblestoneItem,
			ItemConvertible oreItem, int oreMin, int oreMax
	) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								// Drop 7 cobblestones.
								.with(ItemEntry.builder(cobblestoneItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
								)
				)
				.pool(
						LootPool.builder()
								// Drop ore.
								.with(makeUniformCountWithFortuneBonusItemEntry(oreItem, oreMin, oreMax))
				)
				.pool(
						LootPool.builder()
								// Drop an extra ore if mined with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(oreItem))
				);
	}
	
	public LootTable.Builder makeGrassCropLootTable() {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								// Drop grass tuft.
								.with(ItemEntry.builder(ModItems.GRASS_TUFT)
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
								.with(ItemEntry.builder(ModItems.GRASS_TUFT))
				);
	}
	
	public LootTable.Builder makeTallGrassLootTable(Block tallCrop) {
		// Potentially drop wheat seeds, with Fortune bonus.
		LootPoolEntry.Builder<?> seedEntry = ItemEntry.builder(Items.WHEAT_SEEDS)
				.conditionally(RandomChanceLootCondition.builder(0.125F))
				.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2));
		// Drop 2 grass tufts, or 3 with silk touch or shears.
		LootPoolEntry.Builder<?> tuftEntry = ItemEntry.builder(ModItems.GRASS_TUFT)
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
	
	
	private static LootPool.Builder makeDoubleEntryPool(
			LootPoolEntry.Builder<?> entryA, LootPoolEntry.Builder<?> entryB) {
		return LootPool.builder().with(entryA).with(entryB);
	}
	//endregion
	
	//region ## Loot Pool Builders (alternative) ##
	private static LootPool.Builder makeDoubleEntryAlternativePool(
			LootPoolEntry.Builder<?> entryA, LootPoolEntry.Builder<?> entryB) {
		return LootPool.builder().with(AlternativeEntry.builder(entryA, entryB));
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
	private static LeafEntry.Builder<?> makeConstantCountItemEntry(ItemConvertible item, int count) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)));
	}
	
	
	private static LeafEntry.Builder<?> makeConstantCountWithConditionItemEntry(
			LootCondition.Builder condition, ItemConvertible item, int count
	) {
		return ItemEntry.builder(item)
				.conditionally(condition)
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
