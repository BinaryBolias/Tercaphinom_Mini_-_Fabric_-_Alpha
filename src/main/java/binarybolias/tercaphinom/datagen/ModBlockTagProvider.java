package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating block tag data");
		
		/*
		* NOTE: 'getOrCreateTagBuilder' method calls which do not include an 'add' method call are included merely for reference; these calls effectively do nothing.
		*
		* NOTE: For an overhaul of Minecraft which uses only custom aspects (dimensions, block, items, entities, etc.), these (vanilla) tags are inappropriate; only custom tags would be used instead.
		 */
		
		getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).add(ModBlocks.ETERNALITH);
		getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE).add(ModBlocks.ETERNALITH);
		getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS).add(ModBlocks.ETERNALITH);
		getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).add(ModBlocks.ETERNALITH);
		
		// BlockTags.PICKAXE_MINEABLE: (I think) The blocks within this tag only drop loot if mined with a pickaxe.
		// - Intended to be used for blocks with the "requiresTool" setting.
		//  - This setting reduces mining speed and disallows loot drops by default.
		// - Allows for ordinary mining speed, and for the block to drop loot, when mined with a PickaxeItem.
		//  - Does not seem to have relation to the "pickaxes" item tag.
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
				.add(ModBlocks.STIEFANE_BRICK_BLOCK)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK)
				.add(ModBlocks.STIEFANE_BLOCK)
				.add(ModBlocks.POLISHED_STIEFANE_BLOCK)
				.add(ModBlocks.STIEFANE_LAPIS_ORE)
				.add(ModBlocks.STIEFANE_BUTTON)
				.add(ModBlocks.STIEFANE_PRESSURE_PLATE)
				.add(ModBlocks.STIEFANE_BRICK_WALL_POST)
				.add(ModBlocks.STIEFANE_BRICK_SLAB)
				.add(ModBlocks.STIEFANE_BRICK_STAIR)
				.add(ModBlocks.ULTRASMOOTH_STONE);
		getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
				.add(ModBlocks.VERDAK_LOG)
				.add(ModBlocks.VERDAK_TRUNK)
				.add(ModBlocks.VERDAK_PLANK_BLOCK)
				.add(ModBlocks.VERDAK_BUTTON)
				.add(ModBlocks.VERDAK_PRESSURE_PLATE)
				.add(ModBlocks.VERDAK_DOOR)
				.add(ModBlocks.VERDAK_HATCH)
				.add(ModBlocks.VERDAK_FENCE_GATE)
				.add(ModBlocks.VERDAK_FENCE_POST)
				.add(ModBlocks.VERDAK_PLANK_SLAB)
				.add(ModBlocks.VERDAK_PLANK_STAIR);
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
		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
				.add(ModBlocks.VERDAK_LOG)
				.add(ModBlocks.VERDAK_TRUNK);
		getOrCreateTagBuilder(BlockTags.WALLS)
				.add(ModBlocks.STIEFANE_BRICK_WALL_POST);
		getOrCreateTagBuilder(BlockTags.FENCES)
				.add(ModBlocks.VERDAK_FENCE_POST);
		getOrCreateTagBuilder(BlockTags.FENCE_GATES)
				.add(ModBlocks.VERDAK_FENCE_GATE);
		getOrCreateTagBuilder(BlockTags.STAIRS);
		getOrCreateTagBuilder(BlockTags.DOORS);
		getOrCreateTagBuilder(BlockTags.TRAPDOORS);
		
		getOrCreateTagBuilder(BlockTags.COAL_ORES);
		getOrCreateTagBuilder(BlockTags.COPPER_ORES);
		getOrCreateTagBuilder(BlockTags.DIAMOND_ORES);
		getOrCreateTagBuilder(BlockTags.EMERALD_ORES);
		getOrCreateTagBuilder(BlockTags.GOLD_ORES);
		getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
				.add(ModBlocks.STIEFANE_LAPIS_ORE);
	}
}
