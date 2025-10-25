package binarybolias.tercaphinom.references;


import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static binarybolias.tercaphinom.references.ModBlocks.*;


/**
 * Re-registration for overwriting vanilla blocks.
 * @apiNote
 * Variable names here are to reflect those of vanilla blocks (found in {@link net.minecraft.block.Blocks}) for clarity.
 * @see ModBlocks
 */
public class VMOBlocks {
	public static void bootstrap() {
		Reference.logMainEvent("Registering vanilla block overrides");
	}
	
	
	/**
	 * Registers a new block with an existing identifier.
	 * @param oldBlock
	 * @param newBlock
	 */
	public static Block overwrite(Block oldBlock, Block newBlock) {
		return Registry.register(Registries.BLOCK, Registries.BLOCK.getId(oldBlock), newBlock);
	}
	
	
	@Deprecated
	public static Block overwriteOld(String id, Block block) {
		return Registry.register(Registries.BLOCK, new Identifier(id), block);
	}
	
	
	//### Blocks ###
	//region ## Crops & Foliage ##
	//# Crop (farmland) #
	public static final Block TORCHFLOWER_CROP = overwriteOld("torchflower_crop",
			new TorchflowerBlock(blockSettings(1.0F, 2.0F)
					.mapColor(MapColor.DARK_GREEN)
					.noCollision()
					.ticksRandomly()
					.sounds(BlockSoundGroup.CROP)
					.pistonBehavior(PistonBehavior.DESTROY)
			));
	//# Crop (flower) #
	public static final Block TORCHFLOWER = overwriteOld("torchflower",
			new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F,
					blockSettings(1.0F, 2.0F)
							.mapColor(MapColor.DARK_GREEN)
							.noCollision()
							.sounds(BlockSoundGroup.CROP)
							.offset(AbstractBlock.OffsetType.XZ)
							.pistonBehavior(PistonBehavior.DESTROY)
							.luminance(state -> 3)
			));
	//# Leaf #
	//# Log (stripped log/stem) #
	//# Trunk (unstripped log/stem) #
	//# Miscellaneous #
	//endregion
	
	//region ## Elemental ##
	//# Bale #
	//# Glass (clear) #
	public static final Block GLASS = overwriteOld("glass",
			// All glass blocks now have increased strength.
			new TransparentBlock(blockSettings(6.0F, 6.0F)
					.instrument(Instrument.HAT)
					.sounds(BlockSoundGroup.GLASS)
					.nonOpaque()
					.allowsSpawning(Blocks::never)
					.solidBlock(Blocks::never)
					.suffocates(Blocks::never)
					.blockVision(Blocks::never)
			));
	//# Glass (stained) #
	public static final Block BLACK_STAINED_GLASS = overwriteOld("black_stained_glass", newStainedGlassBlock(DyeColor.BLACK));
	public static final Block BLUE_STAINED_GLASS = overwriteOld("blue_stained_glass", newStainedGlassBlock(DyeColor.BLUE));
	public static final Block BROWN_STAINED_GLASS = overwriteOld("brown_stained_glass", newStainedGlassBlock(DyeColor.BROWN));
	public static final Block CYAN_STAINED_GLASS = overwriteOld("cyan_stained_glass", newStainedGlassBlock(DyeColor.CYAN));
	public static final Block GRAY_STAINED_GLASS = overwriteOld("gray_stained_glass", newStainedGlassBlock(DyeColor.GRAY));
	public static final Block GREEN_STAINED_GLASS = overwriteOld("green_stained_glass", newStainedGlassBlock(DyeColor.GREEN));
	public static final Block LIGHT_BLUE_STAINED_GLASS = overwriteOld("light_blue_stained_glass", newStainedGlassBlock(DyeColor.LIGHT_BLUE));
	public static final Block LIGHT_GRAY_STAINED_GLASS = overwriteOld("light_gray_stained_glass", newStainedGlassBlock(DyeColor.LIGHT_GRAY));
	public static final Block LIME_STAINED_GLASS = overwriteOld("lime_stained_glass", newStainedGlassBlock(DyeColor.LIME));
	public static final Block MAGENTA_STAINED_GLASS = overwriteOld("magenta_stained_glass", newStainedGlassBlock(DyeColor.MAGENTA));
	public static final Block ORANGE_STAINED_GLASS = overwriteOld("orange_stained_glass", newStainedGlassBlock(DyeColor.ORANGE));
	public static final Block PINK_STAINED_GLASS = overwriteOld("pink_stained_glass", newStainedGlassBlock(DyeColor.PINK));
	public static final Block PURPLE_STAINED_GLASS = overwriteOld("purple_stained_glass", newStainedGlassBlock(DyeColor.PURPLE));
	public static final Block RED_STAINED_GLASS = overwriteOld("red_stained_glass", newStainedGlassBlock(DyeColor.RED));
	public static final Block WHITE_STAINED_GLASS = overwriteOld("white_stained_glass", newStainedGlassBlock(DyeColor.WHITE));
	public static final Block YELLOW_STAINED_GLASS = overwriteOld("yellow_stained_glass", newStainedGlassBlock(DyeColor.YELLOW));
	//# Glass (tinted) #
	public static final Block TINTED_GLASS = overwriteOld("tinted_glass",
			new TintedGlassBlock(blockSettings(GLASS).mapColor(MapColor.GRAY)));
	//# Jewel #
	//# Metal #
	//# Mosaic & Plank #
	//# Sand & Soil #
	//# Stone (brick) #
	//# Stone (chiseled) #
	//# Stone (cobbled) #
	//# Stone (natural) #
	//# Stone (polished) #
	//# Miscellaneous #
	public static final Block OBSIDIAN = overwriteOld("obsidian",
			// Now no longer requires correct tool, and never allows mob spawning.
			newBlock(blockSettings(54.0F, 1200.0F)
					.mapColor(MapColor.BLACK)
					.instrument(Instrument.BASEDRUM)
					
					//Note: This probably removes the ability for Zombie Piglins to spawn from nether portals.
					// - This would be fixed upon changing the portal frame material to be Reinforced Obsidian, which could be made to allow spawning.
					// - Or, spawning from a portal could bypass the check for the block type spawned upon?
					
					// This is handy for preventing ambient mob spawns atop the new Nether ceiling, which is composed of obsidian.
					.allowsSpawning(Blocks::never)
			));
	//endregion
	
	//region ## Modified & Transitional ##
	//# Mound #
	//# Ore (netherrack) #
	//# Ore (shale) #
	//# Ore (slate) #
	//# Reinforced #
	public static final Block END_PORTAL_FRAME = overwriteOld("end_portal",
			// Now has significantly less (non-infinite) strength, and no longer drops nothing.
			new EndPortalBlock(blockSettings(60.0F, 2400.0F)
					.mapColor(MapColor.GREEN)
					.instrument(Instrument.BASEDRUM)
					.sounds(BlockSoundGroup.GLASS)
					.luminance(state -> 1)
			));
	//# Miscellaneous #
	//endregion
	
	//region ## Junction & Utility ##
	//# Button & Pressure Plate #
	//# Container & Workstation #
	//# Door & Hatch #
	//# Fence, Gate, & Wall #
	//# Ladder #
	//# Lantern & Torch #
	//# Pane (glass - clear) #
	public static final Block GLASS_PANE = overwriteOld("glass_pane",
			new PaneBlock(blockSettings(0.5F, 0.5F)
					.instrument(Instrument.HAT)
					.sounds(BlockSoundGroup.GLASS)
					.nonOpaque()
			));
	//# Pane (glass - stained) #
	public static final Block BLACK_STAINED_GLASS_PANE = overwriteOld("black_stained_glass_pane", newStainedGlassPane(DyeColor.BLACK));
	public static final Block BLUE_STAINED_GLASS_PANE = overwriteOld("blue_stained_glass_pane", newStainedGlassPane(DyeColor.BLUE));
	public static final Block BROWN_STAINED_GLASS_PANE = overwriteOld("brown_stained_glass_pane", newStainedGlassPane(DyeColor.BROWN));
	public static final Block CYAN_STAINED_GLASS_PANE = overwriteOld("cyan_stained_glass_pane", newStainedGlassPane(DyeColor.CYAN));
	public static final Block GRAY_STAINED_GLASS_PANE = overwriteOld("gray_stained_glass_pane", newStainedGlassPane(DyeColor.GRAY));
	public static final Block GREEN_STAINED_GLASS_PANE = overwriteOld("green_stained_glass_pane", newStainedGlassPane(DyeColor.GREEN));
	public static final Block LIGHT_BLUE_STAINED_GLASS_PANE = overwriteOld("light_blue_stained_glass_pane", newStainedGlassPane(DyeColor.LIGHT_BLUE));
	public static final Block LIGHT_GRAY_STAINED_GLASS_PANE = overwriteOld("light_gray_stained_glass_pane", newStainedGlassPane(DyeColor.LIGHT_GRAY));
	public static final Block LIME_STAINED_GLASS_PANE = overwriteOld("lime_stained_glass_pane", newStainedGlassPane(DyeColor.LIME));
	public static final Block MAGENTA_STAINED_GLASS_PANE = overwriteOld("magenta_stained_glass_pane", newStainedGlassPane(DyeColor.MAGENTA));
	public static final Block ORANGE_STAINED_GLASS_PANE = overwriteOld("orange_stained_glass_pane", newStainedGlassPane(DyeColor.ORANGE));
	public static final Block PINK_STAINED_GLASS_PANE = overwriteOld("pink_stained_glass_pane", newStainedGlassPane(DyeColor.PINK));
	public static final Block PURPLE_STAINED_GLASS_PANE = overwriteOld("purple_stained_glass_pane", newStainedGlassPane(DyeColor.PURPLE));
	public static final Block RED_STAINED_GLASS_PANE = overwriteOld("red_stained_glass_pane", newStainedGlassPane(DyeColor.RED));
	public static final Block WHITE_STAINED_GLASS_PANE = overwriteOld("white_stained_glass_pane", newStainedGlassPane(DyeColor.WHITE));
	public static final Block YELLOW_STAINED_GLASS_PANE = overwriteOld("yellow_stained_glass_pane", newStainedGlassPane(DyeColor.YELLOW));
	//# Pane (miscellaneous) #
	//# Sign #
	//# Slab #
	//# Stair #
	//# Miscellaneous #
	//endregion
	
	
	//region ### New Block Methods ###
	//# Glass #
	private static Block newStainedGlassBlock(DyeColor color) {
		return new StainedGlassBlock(color, blockSettings(GLASS).mapColor(color));
	}
	
	
	private static Block newStainedGlassPane(DyeColor color) {
		return new StainedGlassPaneBlock(color, blockSettings(GLASS_PANE).mapColor(color));
	}
	
	//# Miscellaneous #
	//endregion
}
