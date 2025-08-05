package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.Reference;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;
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
		
		getOrCreateTagBuilder(Tags.Block.NIL); // Intentionally empty.
		
		getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).add(ModBlocks.ETERNALITH_BLOCK);
		getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE).add(ModBlocks.ETERNALITH_BLOCK);
		getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS).add(ModBlocks.ETERNALITH_BLOCK);
		getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).add(ModBlocks.ETERNALITH_BLOCK);
		
		// Remove tool tier elitism.
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL).setReplace(true);
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL).setReplace(true);
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL).setReplace(true);
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL).setReplace(true);
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).setReplace(true);
		getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).setReplace(true);
		
		// BlockTags.PICKAXE_MINEABLE: (I think) The blocks within this tag only drop loot if mined with a pickaxe.
		// - Intended to be used for blocks with the "requiresTool" setting.
		//  - This setting reduces mining speed and disallows loot drops by default.
		// - Allows for ordinary mining speed, and for the block to drop loot, when mined with a PickaxeItem.
		//  - Does not seem to have relation to the "pickaxes" item tag.
		getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
				//# Stone (stiefane) #
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
				//# Metal #
				.add(ModBlocks.RAW_BRASS_BLOCK)
				.add(ModBlocks.RAW_EIDURIL_BLOCK)
				.add(ModBlocks.REFINED_BRASS_BLOCK)
				.add(ModBlocks.REFINED_EIDURIL_BLOCK)
				//## Joke & Unserious ##
				//# (J&U) Metal #
				.add(ModBlocks.RAW_NUTRILLARN_BLOCK)
				.add(ModBlocks.REFINED_NUTRILLARN_BLOCK)
				//# (J&U) Miscellaneous #
				.add(ModBlocks.ULTRASMOOTH_STONE);
		
		getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
				.add(ModBlocks.ASH_BLOCK)
				.add(ModBlocks.SKORSAND_BLOCK)
				//# Joke & Unserious #
				.add(ModBlocks.BLUE_CHEESE_BLOCK)
				.add(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK)
				.add(ModBlocks.YELLOW_CHEESE_BLOCK);
		
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
				.add(ModBlocks.VERDAK_LOG)
				.add(ModBlocks.VERDAK_TRUNK)
				.add(ModBlocks.VERDAK_PLANK_BLOCK)
				.add(ModBlocks.VERDAK_BUTTON)
				.add(ModBlocks.VERDAK_PRESSURE_PLATE)
				.add(ModBlocks.VERDAK_DOOR)
				.add(ModBlocks.VERDAK_HATCH)
				.add(ModBlocks.VERDAK_GATE)
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
				.add(ModBlocks.VERDAK_GATE);
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
		
		getOrCreateTagBuilder(BlockTags.SAPLINGS);
		getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS);
		getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
				.setReplace(true)
				//# Tags #
				.addTag(BlockTags.SAPLINGS)
				.addTag(BlockTags.SMALL_FLOWERS)
				//# Individual Blocks #
				// Bales
				.add(Blocks.DRIED_KELP_BLOCK)
				.add(Blocks.HAY_BLOCK)
				// Grass Crops
				.add(Blocks.CRIMSON_ROOTS)
				.add(Blocks.SHORT_GRASS)
				.add(Blocks.WARPED_ROOTS)
				// Mushrooms
				.add(Blocks.BROWN_MUSHROOM)
				.add(Blocks.CRIMSON_FUNGUS)
				.add(Blocks.RED_MUSHROOM)
				.add(ModBlocks.STARCHCAP_MUSHROOM)
				.add(Blocks.WARPED_FUNGUS)
				// Miscellaneous
				.add(Blocks.AMETHYST_CLUSTER)
				.add(Blocks.ANCIENT_DEBRIS)
				.add(Blocks.BAMBOO_SAPLING)
				.add(Blocks.CACTUS)
				.add(Blocks.CAKE)
				.add(Blocks.CARVED_PUMPKIN)
				.add(Blocks.COBWEB)
				.add(Blocks.COCOA)
				.add(Blocks.DEAD_BUSH)
				.add(Blocks.FERN)
				.add(Blocks.GLOW_LICHEN)
				.add(Blocks.LILY_PAD)
				.add(Blocks.MELON)
				.add(Blocks.PUMPKIN)
				.add(Blocks.SCAFFOLDING)
				.add(Blocks.SUGAR_CANE)
				.add(Blocks.SWEET_BERRY_BUSH)
				.add(Blocks.TNT)
				.add(Blocks.TORCH) // Note: Cannot pick up wall torches.
				// - For Tercaphinom proper, standing torches and wall torches could be merged into a single block type.
				// - When a torch is supposed to be placed at a position (not through player placement):
				//  - If there is no solid block beneath the position, the torch will attempt to anchor itself to a wall, instead.
				.add(Blocks.VINE);
	}
}
