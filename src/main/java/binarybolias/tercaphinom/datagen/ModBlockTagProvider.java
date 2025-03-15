package binarybolias.tercaphinom.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.LOGGER;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating block tag data");
		
		/*
		* NOTE: All the following method calls are included merely for reference; these calls effectively do nothing.
		*
		* NOTE: For an overhaul of Minecraft which uses only custom aspects (dimensions, block, items, entities, etc.), these (vanilla) tags are inappropriate; only custom tags would be used instead.
		 */
		
		// BlockTags.PICKAXE_MINEABLE: (I think) The blocks within this tag only drop loot if mined with a pickaxe.
		// Or perhaps these "_MINEABLE" tags just influence mining speed; the blocks within are mined faster with a corresponding type of tool.
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE);
		getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
		getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);
		// NOTE: I don't appreciate the vanilla functionality of the "needs X tool" tags;
		//  linear material tiers of tools for mining/harvesting feels inelegant to me.
		// BlockTags.NEEDS_STONE_TOOL: (I think) The blocks within this tag only drop loot if mined with a tool of
		//  stone tier or higher.
		getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
		// BlockTags.NEEDS_IRON_TOOL: (I think) The blocks within this tag only drop loot if mined with a tool of
		//  iron tier or higher.
		getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
		// BlockTags.NEEDS_DIAMOND_TOOL: (I think) The blocks within this tag only drop loot if mined with a tool of
		//  diamond tier or higher.
		getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
		
		// I think this defines a new tag with name "needs_tool_level_4".
		// This tag would logically be associated with the block requiring a Netherite tool to mine while dropping loot.
		getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
		
		// BlockTags.LOGS_THAT_BURN: Defines the blocks (intended to be logs) which can be used as fuel.
		// Probably defines the logs that can be converted into charcoal via smelting?
		// Does it also affect fire spread at all?
		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN);
		getOrCreateTagBuilder(BlockTags.WALLS);
		getOrCreateTagBuilder(BlockTags.FENCES);
		getOrCreateTagBuilder(BlockTags.FENCE_GATES);
		getOrCreateTagBuilder(BlockTags.STAIRS);
		getOrCreateTagBuilder(BlockTags.DOORS);
		getOrCreateTagBuilder(BlockTags.TRAPDOORS);
		
		getOrCreateTagBuilder(BlockTags.COAL_ORES);
		getOrCreateTagBuilder(BlockTags.COPPER_ORES);
		getOrCreateTagBuilder(BlockTags.DIAMOND_ORES);
		getOrCreateTagBuilder(BlockTags.EMERALD_ORES);
		getOrCreateTagBuilder(BlockTags.GOLD_ORES);
	}
}
