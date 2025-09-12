package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
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
import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * @see net.minecraft.data.server.tag.vanilla.VanillaBlockTagProvider
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		logMainEvent("Generating block tag data");
		
		/*
		* Note on 'getOrCreateTagBuilder' method calls:
		*  - Some may be included merely for reference.
		*  - It is necessary to call this method for a tag if the tag is used elsewhere in this script.
		*
		* NOTE: For an overhaul of Minecraft which uses only custom aspects (dimensions, block, items, entities, etc.),
		*  vanilla tags are inappropriate; only custom tags are to be used instead.
		 */
		
		getOrCreateTagBuilder(Tags.Block.NIL); // Intentionally empty.
		
		getOrCreateTagBuilder(Tags.Block.ALL_ETERNALITH_BLOCKS)
				.add(ModBlocks.CHISELED_ETERNALITH_BLOCK, ModBlocks.ETERNALITH_BLOCK);
		
		// Eternalith block properties.
		getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(BlockTags.INFINIBURN_END).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).addTag(Tags.Block.ALL_ETERNALITH_BLOCKS);
		
		// Tool tier elitism removal for vanilla tool materials.
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
				.add(ModBlocks.NATURAL_STIEFANE_BLOCK)
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
				//# Stone (cobbled) #
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK) // TODO: Perhaps make a separate block tag for cobbled stone blocks.
				//# Sand & Soil #
				.add(ModBlocks.ASH_BLOCK)
				.add(ModBlocks.SKORSAND_BLOCK)
				
				//## Joke & Unserious ##
				//# (J&U) Cheese #
				.add(ModBlocks.BLUE_CHEESE_BLOCK)
				.add(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK)
				.add(ModBlocks.YELLOW_CHEESE_BLOCK)
				//# (J&U) Miscellaneous #
				.add(ModBlocks.CHERRY_JELLYBLOCK);
		
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
		
		// In vanilla, this is copied as an item tag and only used for defining which logs can be cooked into charcoal.
		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN);
		
		getOrCreateTagBuilder(BlockTags.WALLS)
				.add(ModBlocks.STIEFANE_BRICK_WALL_POST);
		getOrCreateTagBuilder(BlockTags.FENCES)
				.add(ModBlocks.VERDAK_FENCE_POST);
		getOrCreateTagBuilder(BlockTags.FENCE_GATES)
				.add(ModBlocks.VERDAK_GATE);
		getOrCreateTagBuilder(BlockTags.STAIRS);
		getOrCreateTagBuilder(BlockTags.DOORS);
		getOrCreateTagBuilder(BlockTags.TRAPDOORS);
		
		// These are copied as item tags, but don't seem to actually be used for anything.
		// If these WERE used for something, it would probably just be for smelting ore blocks into resources,
		//  which in Tercaphinom is not only ILLEGAL, but also impossible (given that the ore blocks are unobtainable in survival)
		//  and ALSO just plain inefficient, since mining the ore blocks gives a minimum of more than one resource per block anyway.
		getOrCreateTagBuilder(BlockTags.COAL_ORES);
		getOrCreateTagBuilder(BlockTags.COPPER_ORES);
		getOrCreateTagBuilder(BlockTags.DIAMOND_ORES);
		getOrCreateTagBuilder(BlockTags.EMERALD_ORES);
		getOrCreateTagBuilder(BlockTags.GOLD_ORES);
		getOrCreateTagBuilder(BlockTags.LAPIS_ORES);
		
		// Used for transparent blocks which are intended to be solid.
		// Only includes glass blocks (clear, stained, and tinted) in vanilla (as of MC 1.20.6).
		getOrCreateTagBuilder(BlockTags.IMPERMEABLE);
		
		getOrCreateTagBuilder(BlockTags.SAPLINGS);
		getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS);
		
		// Everything Endermen can hold!
		// Notably, Enderman block holding mechanics do NOT respect wall torches;
		//  according to some testing, wall torches simply vanish when the Enderman attempts to place them.
		getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
				.setReplace(true)
				//# Tags #
				.addTag(BlockTags.SAPLINGS)
				.addTag(BlockTags.SMALL_FLOWERS)
				//# Individual Blocks #
				// Bales
				.add(Blocks.DRIED_KELP_BLOCK)
				.add(Blocks.HAY_BLOCK)
				// Bushes & Ferns
				.add(Blocks.DEAD_BUSH)
				.add(Blocks.FERN)
				.add(Blocks.SWEET_BERRY_BUSH)
				// Edible Blocks
				.add(Blocks.CAKE)
				// Gourds
				.add(Blocks.CARVED_PUMPKIN)
				.add(Blocks.MELON)
				.add(Blocks.PUMPKIN)
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
				// Wall Flora
				.add(Blocks.GLOW_LICHEN)
				.add(Blocks.VINE)
				// Miscellaneous
				.add(Blocks.AMETHYST_CLUSTER)
				.add(Blocks.ANCIENT_DEBRIS) // Ha.
				.add(Blocks.BAMBOO_SAPLING)
				.add(Blocks.CACTUS)
				.add(Blocks.COBWEB)
				.add(Blocks.COCOA)
				.add(Blocks.LILY_PAD) // Maybe not because water?
				.add(Blocks.SCAFFOLDING) // Tee hee.
				.add(Blocks.SUGAR_CANE) // Note: This might be finicky due to sugarcane placement restrictions; perhaps replace sugarcane with custom version "Sugarcane Crop" which can be placed without water adjacency.
				.add(Blocks.TNT) // Excellent.
				.add(Blocks.TORCH) // Basic Torch. Note: Cannot pick up wall torches; those are a separate block type.
				// - For Tercaphinom proper, standing torches and wall torches could be merged into a single block type.
				// - When a torch is supposed to be placed at a position (not through player placement):
				//  - If there is no solid block beneath the position, the torch will attempt to anchor itself to a wall, instead.
				//   - There could be a "Torch Bomb" item which attempts to place torches on all valid positions around itself, and wouldn't need to check for both torch types!
				;
	}
}
