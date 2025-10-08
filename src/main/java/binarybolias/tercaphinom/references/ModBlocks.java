package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.block.*;
import binarybolias.tercaphinom.block.reinforced.ReinforcedStainedGlassBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import static binarybolias.tercaphinom.references.Reference.*;

/**
 * Relevant references:
 * {@link net.minecraft.block.Blocks}
 */
public class ModBlocks {
	public ModBlocks() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		logMainEvent("Registering blocks");
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
				new BlockItem(block, new Item.Settings()));
	}
	
	
	private static final float BASE_SLIPPERINESS = 0.6F;
	//TODO:
	// - Use a custom class or something to store smallest increment values for use in defining slipperiness
	//  and velocity multipliers.
	
	
	// Method to get a slipperiness value from an integer.
	// Works in increments of 1/64.
	private static float slipperiness(int modifier) {
		if (modifier < 0) {
			Reference.logWarning("Attempted to retrieve a negative slipperiness value!");
			modifier = 0;
		}
		return BASE_SLIPPERINESS - (modifier * (1.0F / 64));
	}
	// Method to get a multiplier value from an integer.
	// Generally intended for getting a range from 0.0 to 1.0.
	// Works in increments of 1/64.
	private static float multiplier(int modifier) {
		return 1.0F + (modifier * (1.0F / 64));
	}
	
	
	//### Blocks ###
	//region  ## Crops & Foliage ##
	//# Crop #
	
	//# Leaf #
	
	//# Log #
	public static final Block VERDAK_LOG = registerBlock("verdak_log",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(MapColor.PALE_GREEN)
					.velocityMultiplier(0.96875F))); // TODO: Make unique.
	
	//# Trunk #
	public static final Block VERDAK_TRUNK = registerBlock("verdak_trunk",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ?
							MapColor.PALE_GREEN : /* top color */
							MapColor.DARK_GREEN /* side color */)
					.velocityMultiplier(0.96875F))); // TODO: Make unique.
	
	//# Miscellaneous #
	
	//endregion
	
	//region ## Elemental ##
	//# Bale #
	
	//# Jewel #
	
	//# Metal #
	public static final Block RAW_BRASS_BLOCK = registerBlockWithItem("raw_brass_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.DIRT_BROWN)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.STONE).instrument(Instrument.IRON_XYLOPHONE)));
	public static final Block RAW_EIDURIL_BLOCK = registerBlockWithItem("raw_eiduril_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.DARK_AQUA)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.STONE).instrument(Instrument.IRON_XYLOPHONE)));
	public static final Block REFINED_BRASS_BLOCK = registerBlockWithItem("refined_brass_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.OAK_TAN)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.METAL).instrument(Instrument.BASEDRUM)));
	public static final Block REFINED_EIDURIL_BLOCK = registerBlockWithItem("refined_eiduril_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.DARK_AQUA)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.METAL).instrument(Instrument.BASEDRUM)));
	
	//# Mosaic & Plank #
	public static final Block VERDAK_PLANK_BLOCK = registerBlockWithItem("verdak_plank_block",
			new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Sand & Soil #
	public static final Block ASH_BLOCK = registerBlockWithItem("ash_block",
			new GeologicallyCompactibleBlock(Blocks.TUFF, 2, 8,
					blockSettings(1.0F, 6.0F, true)
					.mapColor(MapColor.STONE_GRAY)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.SNOW).instrument(Instrument.HARP)
			));
	public static final Block SKORSAND_BLOCK = registerBlockWithItem("skorsand_block",
			new ColoredFallingBlock(
					new ColorCode(3093040),
					blockSettings(0.5F, 6.0F)
							.mapColor(MapColor.GRAY)
							.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
							.velocityMultiplier(0.96875F) // 31/32
							.sounds(BlockSoundGroup.SAND).instrument(Instrument.SNARE)
			));
	
	//# Stone (brick) #
	public static final Block STIEFANE_BRICK_BLOCK = registerBlockWithItem("stiefane_brick_block",
			newBlock(blockSettings(1.5F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)));
	
	//# Stone (chiseled) #
	
	//# Stone (cobbled) #
	public static final Block COBBLED_STIEFANE_BLOCK = registerBlockWithItem("cobbled_stiefane_block",
			newBlock(blockSettings(2.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)));
	
	//# Stone (natural) #
	public static final Block NATURAL_STIEFANE_BLOCK = registerBlockWithItem("natural_stiefane_block",
			new Block(blockSettings(Blocks.STONE))); // TODO: Make unique.
	
	//# Stone (polished) #
	public static final Block POLISHED_STIEFANE_BLOCK = registerBlockWithItem("polished_stiefane_block",
			new Block(blockSettings(Blocks.SMOOTH_STONE))); // TODO: Make unique.
	
	//# Miscellaneous #
	
	//endregion
	
	//region ## Modified & Transitional ##
	//# Bony #
	
	//# Covered #
	
	//# Mound #
	public static final Block ASH_MOUND = registerBlock("ash_mound",
			new AshMoundBlock(
					blockSettings(0.125F, 1.0F, true)
							.mapColor(MapColor.STONE_GRAY)
							.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
							.velocityMultiplier(0.96875F) // 31/32
							.replaceable()
							.sounds(BlockSoundGroup.SNOW)
							.blockVision((state, world, pos) -> state.get(LayeredMoundBlock.LAYERS) >= LayeredMoundBlock.MAX_LAYERS)
							.pistonBehavior(PistonBehavior.DESTROY)
			));
	
	//# Ore (netherrack) #
	
	//# Ore (stiefane) #
	public static final Block STIEFANE_LAPIS_ORE = registerBlockWithItem("stiefane_lapis_ore",
			new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), blockSettings(Blocks.LAPIS_ORE))); // TODO: Make unique.
	//# Ore (zygolith) #
	
	//# Reinforced #
	
	//# Stony #
	
	//# Miscellaneous #
	public static final Block ASHY_NETHERRACK_BLOCK = registerBlockWithItem("ashy_netherrack_block",
			new AshyNetherrackBlock(blockSettings(0.5F, 1.0F, true)
					.mapColor(MapColor.DARK_RED).instrument(Instrument.BASEDRUM)
					.slipperiness(0.6F).velocityMultiplier(0.96875F)
					.sounds(BlockSoundGroup.NETHERRACK)));
	
	//endregion
	
	//region ## Junction & Utility ##
	//# Button & Pressure Plate #
	public static final Block STIEFANE_BUTTON = registerBlockWithItem("stiefane_button",
			new ButtonBlock(BlockSetType.STONE, 30, blockSettings(Blocks.STONE_BUTTON))); // TODO: Make unique.
	public static final Block STIEFANE_PRESSURE_PLATE = registerBlockWithItem("stiefane_pressure_plate",
			new PressurePlateBlock(BlockSetType.STONE, blockSettings(Blocks.STONE_PRESSURE_PLATE))); // TODO: Make unique.
	public static final Block VERDAK_BUTTON = registerBlockWithItem("verdak_button",
			new ButtonBlock(BlockSetType.OAK, 30, blockSettings(Blocks.OAK_BUTTON))); // TODO: Make unique.
	public static final Block VERDAK_PRESSURE_PLATE = registerBlockWithItem("verdak_pressure_plate",
			new PressurePlateBlock(BlockSetType.OAK, blockSettings(Blocks.OAK_PRESSURE_PLATE))); // TODO: Make unique.
	
	//# Container & Workstation #
	
	//# Door & Hatch #
	// NOTE: No longer using custom door block, for loot table generation parity with vanilla doors.
	public static final Block VERDAK_DOOR = registerBlockWithItem("verdak_door",
			new DoorBlock(BlockSetType.OAK, blockSettings(Blocks.OAK_DOOR))); // TODO: Make unique.
//			new CustomDoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).pistonBehavior(PistonBehavior.BLOCK)));
	public static final Block VERDAK_HATCH = registerBlockWithItem("verdak_hatch",
			new TrapdoorBlock(BlockSetType.OAK, blockSettings(Blocks.OAK_TRAPDOOR))); // TODO: Make unique.
	
	//# Fence, Gate, & Wall #
	public static final Block STIEFANE_BRICK_WALL_POST = registerBlockWithItem("stiefane_brick_wall_post",
			new WallBlock(blockSettings(Blocks.STONE_BRICK_WALL))); // TODO: Make unique.
	public static final Block VERDAK_GATE = registerBlockWithItem("verdak_gate",
			new FenceGateBlock(WoodType.OAK, blockSettings(Blocks.OAK_FENCE_GATE))); // TODO: Make unique.
	public static final Block VERDAK_FENCE_POST = registerBlockWithItem("verdak_fence_post",
			new FenceBlock(blockSettings(Blocks.OAK_FENCE))); // TODO: Make unique.
	
	//# Ladder #
	
	//# Lantern & Torch #
	
	//# Pane #
	
	//# Sign #
	
	//# Slab #
	public static final Block STIEFANE_BRICK_SLAB = registerBlockWithItem("stiefane_brick_slab",
			new SlabBlock(blockSettings(Blocks.STONE_BRICK_SLAB))); // TODO: Make unique.
	public static final Block VERDAK_PLANK_SLAB = registerBlockWithItem("verdak_plank_slab",
			new SlabBlock(blockSettings(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Stair #
	public static final Block STIEFANE_BRICK_STAIR = registerBlockWithItem("stiefane_brick_stair",
			new StairsBlock(STIEFANE_BRICK_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS))); // TODO: Make unique.
	public static final Block VERDAK_PLANK_STAIR = registerBlockWithItem("verdak_plank_stair",
			new StairsBlock(VERDAK_PLANK_BLOCK.getDefaultState(), blockSettings(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Miscellaneous #
	
	//endregion
	
	//region ## Miscellaneous ##
	//# Eternalith - basic #
	public static final Block ETERNALITH_BLOCK = registerBlockWithItem("eternalith_block",
			new Block(
					blockSettings(-1.0F, 3600000.0F)
							.mapColor(MapColor.GRAY)
							.instrument(Instrument.BASEDRUM)
							.dropsNothing()
							.allowsSpawning(Blocks::never)
			)
	);
	//# Eternalith - modified #
	public static final Block CHISELED_ETERNALITH_BLOCK = registerBlockWithItem("chiseled_eternalith_block",
			new Block(blockSettings(ETERNALITH_BLOCK))
	);
	//# Miscellaneous #
	//endregion
	
	
	//region  ### Joke & Unserious Blocks ###
	//region ## (J&U) Crops & Foliage ##
	public static final Block STARCHCAP_MUSHROOM = registerBlock("starchcap_mushroom",
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
	//endregion
	
	//region ## (J&U) Elemental ##
	//# Cheese #
	public static final Block BLUE_CHEESE_BLOCK = registerBlockWithItem("blue_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.725F).velocityMultiplier(0.96875F)));
	public static final Block SILKY_SMOOTH_CHEESE_BLOCK = registerBlockWithItem("silky_smooth_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.85F).velocityMultiplier(0.96875F)));
	public static final Block YELLOW_CHEESE_BLOCK = registerBlockWithItem("yellow_cheese_block",
			new Block(blockSettings(3.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.725F).velocityMultiplier(0.96875F)));
	//# Metal(?) #
	public static final Block RAW_NUTRILLARN_BLOCK = registerBlockWithItem("raw_nutrillarn_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.RAW_IRON_PINK).instrument(Instrument.HARP)
					.slipperiness(0.6F).velocityMultiplier(0.96875F)
					.sounds(BlockSoundGroup.MUD)));
	public static final Block REFINED_NUTRILLARN_BLOCK = registerBlockWithItem("refined_nutrillarn_block",
			newBlock(blockSettings(6.0F, 8.0F)
					.mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM)
					.slipperiness(0.6F).velocityMultiplier(1.0F)
					.sounds(BlockSoundGroup.STONE)));
	//# Miscellaneous #
	public static final Block CHERRY_JELLYBLOCK = registerBlockWithItem("cherry_jellyblock",
			new CherryJellyblockBlock(blockSettings(2.0F, 8.0F)
					.mapColor(MapColor.RED).instrument(Instrument.BASEDRUM)
					.slipperiness(0.85F).velocityMultiplier(1.0F)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)
					.sounds(BlockSoundGroup.SLIME)
					.jumpVelocityMultiplier(1.5F)
					.nonOpaque()));
	public static final Block HYPERSMOOTH_CREAMSTONE = registerBlockWithItem("hypersmooth_creamstone",
			new Block(blockSettings(4.5F, 9.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(1.0375F) // Note: Slipperiness of Blue Ice is 0.989.
					.luminance(state -> 2)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)));
	public static final Block ULTRASMOOTH_STONE = registerBlockWithItem("ultrasmooth_stone",
			new Block(blockSettings(3.0F, 7.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
					.slipperiness(0.98F) // Note: Slipperiness of ice, packed ice, and frosted ice is 0.98.
					.pistonBehavior(PistonBehavior.PUSH_ONLY)));
	//endregion
	
	//region ## (J&U) Modified & Transitional ##
	//# Reinforced (stained glass) #
	public static final Block REINFORCED_STAINED_GLASS_BLOCK = registerBlockWithItem("reinforced_stained_glass_block",
			new ReinforcedStainedGlassBlock(blockSettings(48.0F, 1200.0F)
					.mapColor(MapColor.GRAY).instrument(Instrument.HARP)
					.slipperiness(0.6F).velocityMultiplier(0.96875F)
					.sounds(BlockSoundGroup.GLASS)));
	//endregion
	
	//endregion
	
	
	private static Block newBlock(AbstractBlock.Settings settings) {
		return new Block(settings);
	}
	
	private static Block newMetalBlock(AbstractBlock.Settings settings) {
		return new Block(settings.sounds(BlockSoundGroup.METAL));
	}
	
	
	private static AbstractBlock.Settings blockSettings() {
		return AbstractBlock.Settings.create();
	}
	
	private static AbstractBlock.Settings blockSettings(float hardness, float resistance) {
		return blockSettings().strength(hardness, resistance);
	}
	
	private static AbstractBlock.Settings blockSettings(float hardness, float resistance, boolean ticksRandomly) {
		if (ticksRandomly) {
			return blockSettings(hardness, resistance).ticksRandomly();
		}
		return blockSettings(hardness, resistance);
	}
	
	private static AbstractBlock.Settings blockSettings(AbstractBlock block) {
		return AbstractBlock.Settings.copy(block);
	}
}
