package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModBlocks {
	public ModBlocks() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering blocks");
	}
	
	private static Block registerBlock(String name, Block block) {
		return Registry.register(Registries.BLOCK, identifier(name), block);
	}
	
	private static Block registerBlockWithItem(String name, Block block) {
		registerBlockItem(name, block);
		return registerBlock(name, block);
	}
	
	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, identifier(name),
				new BlockItem(block, new FabricItemSettings()));
	}
}
