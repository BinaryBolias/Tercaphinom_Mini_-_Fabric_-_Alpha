package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.*;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	// TODO: Replace the tag here with a custom one ("chopping tools"?).
	public static final LootCondition.Builder WITH_CHOPPING_TOOL = MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ItemTags.AXES));
	
	
	@Override
	public void generate() {
		log("Generating loot table data");
		
		//region ## Stone ##
		// Stiefane
		addStandardStoneBlockSetDrops(ModItems.STIEFANE_COBBLESTONE, ModItems.STIEFANE_BRICK,
				ModBlocks.STIEFANE_BRICK_BLOCK, ModBlocks.COBBLED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BLOCK, ModBlocks.POLISHED_STIEFANE_BLOCK,
				ModBlocks.STIEFANE_BUTTON, ModBlocks.STIEFANE_PRESSURE_PLATE,
				ModBlocks.STIEFANE_BRICK_WALL_POST,
				ModBlocks.STIEFANE_BRICK_SLAB, ModBlocks.STIEFANE_BRICK_STAIR);
		// Ore (stiefane)
		addOreBlockDrop(ModBlocks.STIEFANE_LAPIS_ORE,
				ModItems.STIEFANE_COBBLESTONE, Items.LAPIS_LAZULI, 5, 8);
		//endregion
		
		//region ## Wood ##
		// Verdak
		addStandardPlankBlockSetDrops(ModItems.VERDAK_PLANK,
				ModBlocks.VERDAK_PLANK_BLOCK,
				ModBlocks.VERDAK_BUTTON, ModBlocks.VERDAK_PRESSURE_PLATE,
				ModBlocks.VERDAK_DOOR, ModBlocks.VERDAK_HATCH,
				ModBlocks.VERDAK_FENCE_GATE, ModBlocks.VERDAK_FENCE_POST,
				ModBlocks.VERDAK_PLANK_SLAB, ModBlocks.VERDAK_PLANK_STAIR);
		// Log & Trunk
		addLogAndTrunkDrops(ModBlocks.VERDAK_LOG, ModBlocks.VERDAK_TRUNK);
		//endregion
		
		//region ## Miscellaneous ##
		//endregion
		
		//region ## Joke & Unserious ##
		addItemOrBlockWithSilkTouchDrop(ModBlocks.ULTRASMOOTH_STONE, Blocks.SMOOTH_STONE, 1);
		//endregion
	}
	
	//region ## Drop Adder Sets ##
	private void addLogAndTrunkDrops(Block log, Block trunk) {
		addLogDrop(log);
		addTrunkDrop(trunk, log);
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
		addPlankDoorDrop(door, plankItem, 6);
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
			ItemConvertible cobblestoneItem, ItemConvertible brickItem,
			Block brickBlock, Block cobbledBlock, Block naturalBlock, Block polishedBlock,
			Block button, Block pressurePlate,
			Block brickWallPost,
			Block brickSlab, Block brickStair
	) {
		// NOTE: For now, these stone block loot tables should not consider tool type, for the sake of simplicity.
		// Brick Block
		addBasicItemDrop(brickBlock, brickItem, 4);
		// Cobbled Block
		addBasicItemDrop(cobbledBlock, cobblestoneItem, 8);
		// Natural Block
		addNaturalStoneDrop(naturalBlock, cobblestoneItem, polishedBlock);
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
	//endregion
	
	//region ## Drop Adders ##
	private void addBasicItemDrop(Block block, ItemConvertible item, int amount) {
		addDrop(block, makeBasicItemDropLootTable(item, amount));
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
	
	private void addLogDrop(Block block) {
		addDrop(block, makeLogLootTable(block));
	}
	
	private void addTrunkDrop(Block trunk, Block log) {
		// TODO: Make this loot table link to the corresponding log loot table directly, dropping everything the log drops.
		addDrop(trunk, makeLogLootTable(log)
				.pool( // Drop some extra sticks (for the tree bark).
						LootPool.builder()
								.rolls(ConstantLootNumberProvider.create(1.0F))
								.with(ItemEntry.builder(Items.STICK)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
								)
				)
		);
	}
	
	private void addSlabItemDrop(Block slabBlock, ItemConvertible item, int amount) {
		addDrop(slabBlock, makeSlabItemDropLootTable(slabBlock, item, amount));
	}
	
	private void addBasicPlankBasedDrop(Block block, ItemConvertible plankItem, int plankAmount) {
		addDrop(block, makeBasicPlankBasedBlockLootTable(block, plankItem, plankAmount));
	}
	
	private void addPlankSlabDrop(Block slabBlock, ItemConvertible plankItem, int plankAmount) {
		addDrop(slabBlock, makePlankSlabLootTable(slabBlock, plankItem, plankAmount));
	}
	
	private void addPlankDoorDrop(Block block, ItemConvertible plankItem, int plankAmount) {
		addDrop(block, makePlankDoorLootTable(block, plankItem, plankAmount));
	}
	
	private void addPlankBasedBlockWithSecondaryItemDrop(
			Block block,
			ItemConvertible plankItem, int plankAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		addDrop(block, makePlankBasedBlockWithSecondaryItemLootTable(
				block, plankItem, plankAmount, secondaryItem, secondaryAmount));
	}
	
	private void addNaturalStoneDrop(
			Block naturalStoneBlock, ItemConvertible cobblestoneItem, ItemConvertible polishedStoneBlock
	) {
		addDrop(naturalStoneBlock, makeNaturalStoneBlockLootTable(cobblestoneItem, polishedStoneBlock));
	}
	
	private void addOreBlockDrop(
			Block oreBlock, ItemConvertible cobblestoneItem, ItemConvertible oreItem, int oreMin, int oreMax
	) {
		addDrop(oreBlock, makeOreBlockLootTable(cobblestoneItem, oreItem, oreMin, oreMax));
	}
	//endregion
	
	//region ## Loot Table Builders ##
	private static LootTable.Builder makeBasicItemDropLootTable(ItemConvertible item, int amount) {
		return new LootTable.Builder()
				.pool( // Drop the provided amount of the given item.
						LootPool.builder()
								.with(ItemEntry.builder(item)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(amount)))
								)
				);
	}
	
	private static LootTable.Builder makeSlabItemDropLootTable(Block slabBlock, ItemConvertible item, int amount) {
		return LootTable.builder()
				.pool(
						LootPool.builder()
								.with(ItemEntry.builder(item)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(amount)))
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(amount * 2))
												.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
										)
								)
				);
	}
	
	private static LootTable.Builder makeItemOrBlockWithSilkTouchLootTable(
			ItemConvertible block, ItemConvertible item, int itemAmount
	) {
		return new LootTable.Builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop block if mined with Silk Touch.
										ItemEntry.builder(block)
												.conditionally(WITH_SILK_TOUCH),
										// Drop item if mined without Silk Touch.
										ItemEntry.builder(item)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(itemAmount)))
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
								.conditionally(WITH_SILK_TOUCH.invert())
								.with(ItemEntry.builder(secondaryItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(secondaryAmount)))
								)
				);
	}
	
	private static LootTable.Builder makeLogLootTable(ItemConvertible log) {
		return new LootTable.Builder()
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
			ItemConvertible plankBlock, ItemConvertible plankItem, int plankAmount
	) {
		return new LootTable.Builder()
				.pool( // Drop planks if mined with a chopping tool.
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop self or raw materials if mined with appropriate tool.
										AlternativeEntry.builder(
												// Drop block if mined with appropriate tool and Silk Touch.
												ItemEntry.builder(plankBlock)
														.conditionally(WITH_SILK_TOUCH),
												// Drop planks if mined with appropriate tool and without Silk Touch.
												ItemEntry.builder(plankItem)
														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount)))
										).conditionally(WITH_CHOPPING_TOOL),
										// Drop raw materials with planks converted to sticks if mined without appropriate tool.
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
										// Drop self if mined with both proper tool and Silk Touch.
										ItemEntry.builder(slabBlock)
												.conditionally(WITH_CHOPPING_TOOL)
												.conditionally(WITH_SILK_TOUCH)
												// Drop 2 if double slab.
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))
														.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
												),
										// Drop planks if mined with proper tool and without Silk Touch.
										ItemEntry.builder(plankItem)
												.conditionally(WITH_CHOPPING_TOOL)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount)))
												// Drop twice as many planks if double slab.
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2))
														.conditionally(BlockStatePropertyLootCondition.builder(slabBlock).properties(StatePredicate.Builder.create().exactMatch(SlabBlock.TYPE, SlabType.DOUBLE)))
												),
										// Drop sticks if mined without proper tool.
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
			ItemConvertible plankBlock,
			ItemConvertible plankItem, int plankAmount,
			ItemConvertible secondaryItem, int secondaryAmount
	) {
		return makeBasicPlankBasedBlockLootTable(plankBlock, plankItem, plankAmount)
				.pool( // Drop sticks if mined without Silk Touch.
						LootPool.builder()
								.conditionally(WITH_SILK_TOUCH.invert())
								.with(ItemEntry.builder(secondaryItem)
										.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(secondaryAmount)))
								)
				);
	}
	
	private static LootTable.Builder makePlankDoorLootTable(
			Block plankBlock, ItemConvertible plankItem, int plankAmount
	) {
		// NOTE: Only the bottom half of the door drops resources.
		// BUG: If the top half of the door is mined, the bottom half treats itself as having been mined without a tool.
		//  - The bottom half is rather destroyed due to no longer having a top half, but the cause of destruction is not transferred from the top half.
		return new LootTable.Builder()
				.pool( // Drop planks if mined with a chopping tool.
						LootPool.builder()
								.conditionally(BlockStatePropertyLootCondition.builder(plankBlock).properties(StatePredicate.Builder.create().exactMatch(DoorBlock.HALF, DoubleBlockHalf.LOWER)))
								.with(AlternativeEntry.builder(
										// Drop self or raw materials if mined with appropriate tool.
										AlternativeEntry.builder(
												// Drop block if mined with appropriate tool and Silk Touch.
												ItemEntry.builder(plankBlock)
														.conditionally(WITH_SILK_TOUCH),
												// Drop planks if mined with appropriate tool and without Silk Touch.
												ItemEntry.builder(plankItem)
														.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount)))
										).conditionally(WITH_CHOPPING_TOOL),
										// Drop raw materials with planks converted to sticks if mined without appropriate tool.
										ItemEntry.builder(Items.STICK)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(plankAmount * 2)))
								))
				);
	}
	
	private static LootTable.Builder makeNaturalStoneBlockLootTable(ItemConvertible cobblestoneItem, ItemConvertible polishedStoneBlock) {
		return new LootTable.Builder()
				.pool(
						LootPool.builder()
								.with(AlternativeEntry.builder(
										// Drop polished stone block if mined with Silk Touch.
										ItemEntry.builder(polishedStoneBlock)
												.conditionally(WITH_SILK_TOUCH),
										// Drop cobblestones if mined without Silk Touch.
										ItemEntry.builder(cobblestoneItem)
												.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7)))
								))
				)
				.pool(
						LootPool.builder()
								// Drop flint if mined without Silk Touch.
								.conditionally(WITH_SILK_TOUCH.invert())
								.with(ItemEntry.builder(Items.FLINT))
				);
	}
	
	private static LootTable.Builder makeOreBlockLootTable(
			ItemConvertible cobblestoneItem,
			ItemConvertible oreItem, int oreMin, int oreMax
	) {
		return new LootTable.Builder()
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
								.with(makeUniformItemCountWithFortuneBonusEntry(oreItem, oreMin, oreMax))
				)
				.pool(
						LootPool.builder()
								// Drop an extra ore if mined with Silk Touch.
								.conditionally(WITH_SILK_TOUCH)
								.with(ItemEntry.builder(oreItem))
				);
	}
	//endregion
	
	//region ## Loot Pool Builders ##
	//endregion
	
	//region ## Loot Entry Builders ##
	private static LeafEntry.Builder<?> makeUniformItemCountWithFortuneBonusEntry(ItemConvertible item, int min, int max) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
				.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE));
	}
	//endregion
}
