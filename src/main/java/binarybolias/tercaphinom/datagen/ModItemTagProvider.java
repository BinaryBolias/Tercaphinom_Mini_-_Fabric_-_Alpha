package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating item tag data");
		
		// NOTE: These method calls are merely for reference; they effectively do nothing (without any extra "add" method call).
		getOrCreateTagBuilder(ItemTags.ARROWS);
		getOrCreateTagBuilder(ItemTags.AXES);
		getOrCreateTagBuilder(ItemTags.BEDS);
		getOrCreateTagBuilder(ItemTags.BOATS);
		
		// Used for furnace and brewing stand.
		getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK.asItem());
		// Used for stone axe, hoe, pickaxe, shovel, and sword.
		getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK.asItem());
	}
}
