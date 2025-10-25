package binarybolias.tercaphinom.references;


import binarybolias.tercaphinom.block.CherryJellyblockBlock;
import binarybolias.tercaphinom.block.reinforced.ReinforcedStainedGlassBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import static binarybolias.tercaphinom.references.ModBlocks.*;


/**
 * Registration for joke & unserious blocks.
 * @see ModBlocks
 */
public class JAUBlocks {
	public static void bootstrap() {
		Reference.logMainEvent("Registering joke & unserious blocks");
	}
	
	
	//### Blocks ###
	//region ## Crops & Foliage ##
	//# Crop #
	//# Leaf #
	//# Log #
	//# Mushroom #
	public static final Block STARCHCAP_MUSHROOM = register("starchcap_mushroom",
			new MushroomPlantBlock(
					TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM,
					blockSettings(0.8F, 3.0F)
							.mapColor(MapColor.OAK_TAN).instrument(Instrument.HARP)
							.slipperiness(0.6F).velocityMultiplier(1.0F)
							.noCollision()
							.ticksRandomly()
							.sounds(BlockSoundGroup.GRASS)
							.postProcess(Blocks::always)
							.pistonBehavior(PistonBehavior.DESTROY)
			));
	//# Trunk #
	//# Miscellaneous #
	//endregion
	
	//region ## Elemental ##
	//# Bale #
	//# Cheese #
	public static final Block BLUE_CHEESE_BLOCK = registerWithItem("blue_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.725F).velocityMultiplier(0.96875F)));
	public static final Block SILKY_SMOOTH_CHEESE_BLOCK = registerWithItem("silky_smooth_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.85F).velocityMultiplier(0.96875F)));
	public static final Block YELLOW_CHEESE_BLOCK = registerWithItem("yellow_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.725F).velocityMultiplier(0.96875F)));
	//# Jewel #
	//# Metalloid (raw) #
	public static final Block RAW_NUTRILLARN_BLOCK = registerWithItem("raw_nutrillarn_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.HARP)
					.slipperiness(0.6F).velocityMultiplier(0.96875F)
					.sounds(BlockSoundGroup.MUD)));
	//# Metalloid (refined) #
	public static final Block REFINED_NUTRILLARN_BLOCK = registerWithItem("refined_nutrillarn_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM)
					.slipperiness(0.6F).velocityMultiplier(1.0F)
					.sounds(BlockSoundGroup.STONE)));
	//# Mosaic & Plank #
	//# Sand & Soil #
	public static final Block CANDESAND_BLOCK = registerWithItem("candesand_block",
			new ColoredFallingBlock(
					new ColorCode(12770768),
					blockSettings(0.75F, 6.0F)
							.mapColor(MapColor.LICHEN_GREEN)
							.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
							.velocityMultiplier(0.96875F) // 31/32
							.sounds(BlockSoundGroup.SAND).instrument(Instrument.SNARE)
			));
	//# Stone (brick) #
	//# Stone (chiseled) #
	//# Stone (cobbled) #
	//# Stone (natural) #
	//# Stone (polished) #
	//# Miscellaneous #
	public static final Block CHERRY_JELLYBLOCK = registerWithItem("cherry_jellyblock",
			new CherryJellyblockBlock(blockSettings(2.0F, 8.0F)
					.mapColor(MapColor.RED).instrument(Instrument.BASEDRUM)
					.slipperiness(0.85F).velocityMultiplier(1.0F)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)
					.sounds(BlockSoundGroup.SLIME)
					.jumpVelocityMultiplier(1.5F)
					.nonOpaque()));
	//endregion
	
	//region ## Modified & Transitional ##
	//# Bony #
	//# Covered #
	//# Mound #
	//# Ore (cheese) #
	//# Ore (deepchok) #
	//# Reinforced #
	public static final Block REINFORCED_STAINED_GLASS_BLOCK = registerWithItem("reinforced_stained_glass_block",
			new ReinforcedStainedGlassBlock(blockSettings(48.0F, 1200.0F)
					.mapColor(MapColor.GRAY).instrument(Instrument.HARP)
					.slipperiness(0.6F).velocityMultiplier(0.96875F)
					.sounds(BlockSoundGroup.GLASS)));
	//# Stony #
	//# Miscellaneous #
	//endregion
	
	//region ## Junction & Utility ##
	//# Button & Pressure Plate #
	//# Container & Workstation #
	//# Door & Hatch #
	//# Fence, Gate, & Wall #
	//# Ladder #
	//# Lantern & Torch #
	//# Pane #
	//# Sign #
	//# Slab #
	//# Stair #
	//# Miscellaneous #
	//endregion
	
	//region ## Miscellaneous ##
	//# Smoothest Stones #
	public static final Block HYPERSMOOTH_CREAMSTONE = registerWithItem("hypersmooth_creamstone",
			new Block(blockSettings(4.5F, 9.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(1.0375F) // Note: Slipperiness of Blue Ice is 0.989.
					.luminance(state -> 2)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)));
	public static final Block ULTRASMOOTH_STONE = registerWithItem("ultrasmooth_stone",
			new Block(blockSettings(3.0F, 7.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.98F) // Note: Slipperiness of ice, packed ice, and frosted ice is 0.98.
					.pistonBehavior(PistonBehavior.PUSH_ONLY)));
	//# Miscellaneous #
	//endregion
}
