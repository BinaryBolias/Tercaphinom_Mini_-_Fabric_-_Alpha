package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}
	
	@Override
	public void generate() {
		log("Generating loot table data");
		
//		addDrop(ModBlocks.ULTRASMOOTH_STONE_BLOCK); // Simply drops self.
		addItemOrBlockWithSilkTouchDrop(ModBlocks.ULTRASMOOTH_STONE_BLOCK, Blocks.SMOOTH_STONE);
	}
	
	// NOTE: This method was initially constructed through following an example.
	// This would not make an ideal Tercaphinom ore block loot table on its own, as only one type of loot material
	//  can be specified here, whereas ore blocks would always drop at least two (one ore material, one base material)
	// TODO: Figure out how to drop multiple item types simultaneously through data generation.
	//  - E.g, a "cobblestone item" and an "ore item".
	private LootTable.Builder customOreDrops(Block drop, Item item, float min, float max) {
		return dropsWithSilkTouch(
				drop,
				(LootPoolEntry.Builder<?>)this.applyExplosionDecay(
						drop,
						ItemEntry.builder(item)
								.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
								.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
				)
		);
	}
	
	private LeafEntry.Builder<?> buildCountEntryForOre(Item item, int min, int max) {
		return ItemEntry.builder(item)
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
				.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE));
	}
	
	private void addItemOrBlockWithSilkTouchDrop(Block block, ItemConvertible item) {
		addDrop(block, dropsItemOrBlockWithSilkTouch(block, item));
	}
	
	private LootTable.Builder dropsItemOrBlockWithSilkTouch(Block block, ItemConvertible item) {
		return dropsWithSilkTouch(
				block,
				ItemEntry.builder(item)
		);
	}
	
}
