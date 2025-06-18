package binarybolias.tercaphinom.references;

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
				new BlockItem(block, new Item.Settings()));
	}
	
	
	private static final float BASE_SLIPPERINESS = 0.6F;
	
	
	//### Blocks ###
	//region  ## Crops & Foliage ##
	//# Leaf #
	
	//# Log & Trunk #
	public static final Block VERDAK_LOG = registerBlock("verdak_log",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(MapColor.PALE_GREEN)
					.velocityMultiplier(0.96875F))); // TODO: Make unique.
	public static final Block VERDAK_TRUNK = registerBlock("verdak_trunk",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ?
							MapColor.PALE_GREEN : /* top color */
							MapColor.DARK_GREEN /* side color */)
					.velocityMultiplier(0.96875F))); // TODO: Make unique.
	
	//# Miscellaneous #
	//endregion
	
	//region  ## Elemental ##
	//# Bale #
	//# Metal #
	public static final Block RAW_BRASS_BLOCK = registerBlockWithItem("raw_brass_block",
			newBlock(blockSettings().strength(6.0F, 8.0F)
					.mapColor(MapColor.DIRT_BROWN)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.STONE).instrument(Instrument.IRON_XYLOPHONE)));
	public static final Block RAW_EIDURIL_BLOCK = registerBlockWithItem("raw_eiduril_block",
			newBlock(blockSettings().strength(6.0F, 8.0F)
					.mapColor(MapColor.DARK_AQUA)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.STONE).instrument(Instrument.IRON_XYLOPHONE)));
	public static final Block REFINED_BRASS_BLOCK = registerBlockWithItem("refined_brass_block",
			newBlock(blockSettings().strength(6.0F, 8.0F)
					.mapColor(MapColor.OAK_TAN)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.METAL).instrument(Instrument.BASEDRUM)));
	public static final Block REFINED_EIDURIL_BLOCK = registerBlockWithItem("refined_eiduril_block",
			newBlock(blockSettings().strength(6.0F, 8.0F)
					.mapColor(MapColor.DARK_AQUA)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.METAL).instrument(Instrument.BASEDRUM)));
	
	//# Mosaic & Plank #
	public static final Block VERDAK_PLANK_BLOCK = registerBlockWithItem("verdak_plank_block",
			new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Stone (brick) #
	public static final Block STIEFANE_BRICK_BLOCK = registerBlockWithItem("stiefane_brick_block",
			newBlock(blockSettings().strength(1.5F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)));
	
	//# Stone (cobbled) #
	public static final Block COBBLED_STIEFANE_BLOCK = registerBlockWithItem("cobbled_stiefane_block",
			newBlock(blockSettings().strength(2.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)));
	
	//# Stone (natural) #
	public static final Block STIEFANE_BLOCK = registerBlockWithItem("stiefane_block",
			new Block(AbstractBlock.Settings.copy(Blocks.STONE))); // TODO: Make unique.
	
	//# Stone (polished) #
	public static final Block POLISHED_STIEFANE_BLOCK = registerBlockWithItem("polished_stiefane_block",
			new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE))); // TODO: Make unique.
	
	//# Miscellaneous #
	public static final Block ASH_BLOCK = registerBlockWithItem("ash_block",
			new Block(blockSettings().strength(1.0F, 6.0F)
					.mapColor(MapColor.STONE_GRAY)
					.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
					.velocityMultiplier(0.96875F) // 31/32
					.sounds(BlockSoundGroup.SNOW).instrument(Instrument.HARP)
			)); // 31/32
	public static final Block SKORSAND_BLOCK = registerBlockWithItem("skorsand_block",
			new ColoredFallingBlock(
					new ColorCode(11098145),
					blockSettings().strength(0.5F, 6.0F)
							.mapColor(MapColor.GRAY)
							.slipperiness(BASE_SLIPPERINESS + 0.0625F) // 1/16
							.velocityMultiplier(0.96875F) // 31/32
							.sounds(BlockSoundGroup.SAND).instrument(Instrument.SNARE)
			));
	//endregion
	
	//region  ## Modified & Transitional ##
	//# Ore (netherrack) #
	
	//# Ore (stiefane) #
	public static final Block STIEFANE_LAPIS_ORE = registerBlockWithItem("stiefane_lapis_ore",
			new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.LAPIS_ORE))); // TODO: Make unique.
	
	//# Ore (zygolith) #
	//endregion
	
	//region  ## Junction & Utility ##
	//# Button & Pressure Plate #
	public static final Block STIEFANE_BUTTON = registerBlockWithItem("stiefane_button",
			new ButtonBlock(BlockSetType.STONE, 30, AbstractBlock.Settings.copy(Blocks.STONE_BUTTON))); // TODO: Make unique.
	public static final Block STIEFANE_PRESSURE_PLATE = registerBlockWithItem("stiefane_pressure_plate",
			new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE))); // TODO: Make unique.
	public static final Block VERDAK_BUTTON = registerBlockWithItem("verdak_button",
			new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON))); // TODO: Make unique.
	public static final Block VERDAK_PRESSURE_PLATE = registerBlockWithItem("verdak_pressure_plate",
			new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE))); // TODO: Make unique.
	
	//# Container & Workstation #
	
	//# Door & Hatch #
	// NOTE: No longer using custom door block, for loot table generation parity with vanilla doors.
	public static final Block VERDAK_DOOR = registerBlockWithItem("verdak_door",
			new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR))); // TODO: Make unique.
//			new CustomDoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).pistonBehavior(PistonBehavior.BLOCK)));
	public static final Block VERDAK_HATCH = registerBlockWithItem("verdak_hatch",
			new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR))); // TODO: Make unique.
	
	//# Fence, Gate, & Wall #
	public static final Block STIEFANE_BRICK_WALL_POST = registerBlockWithItem("stiefane_brick_wall_post",
			new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL))); // TODO: Make unique.
	public static final Block VERDAK_FENCE_GATE = registerBlockWithItem("verdak_fence_gate",
			new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE))); // TODO: Make unique.
	public static final Block VERDAK_FENCE_POST = registerBlockWithItem("verdak_fence_post",
			new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE))); // TODO: Make unique.
	
	//# Ladder #
	
	//# Pane #
	
	//# Sign #
	
	//# Slab & Stair #
	public static final Block STIEFANE_BRICK_SLAB = registerBlockWithItem("stiefane_brick_slab",
			new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB))); // TODO: Make unique.
	public static final Block STIEFANE_BRICK_STAIR = registerBlockWithItem("stiefane_brick_stair",
			new StairsBlock(STIEFANE_BRICK_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS))); // TODO: Make unique.
	public static final Block VERDAK_PLANK_SLAB = registerBlockWithItem("verdak_plank_slab",
			new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS))); // TODO: Make unique.
	public static final Block VERDAK_PLANK_STAIR = registerBlockWithItem("verdak_plank_stair",
			new StairsBlock(VERDAK_PLANK_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Torch #
	//endregion
	
	//region  ## Miscellaneous ##
	//# Miscellaneous #
	public static final Block ETERNALITH_BLOCK = registerBlockWithItem("eternalith_block",
			new Block(
					AbstractBlock.Settings.create()
							.mapColor(MapColor.GRAY)
							.instrument(Instrument.BASEDRUM)
							.strength(-1.0F, 3600000.0F)
							.dropsNothing()
							.allowsSpawning(Blocks::never)
			)
	);
	//endregion
	
	//region  ### Joke & Unserious Blocks ###
	//## (J&U) Crops & Foliage ##
	public static final Block STARCHCAP_MUSHROOM = registerBlock("starchcap_mushroom",
			new MushroomPlantBlock(
					TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM,
					AbstractBlock.Settings.create()
							.mapColor(MapColor.OAK_TAN)
							.noCollision()
							.ticksRandomly()
							.strength(0.8F, 3.0F)
							.sounds(BlockSoundGroup.GRASS)
							.postProcess(Blocks::always)
							.pistonBehavior(PistonBehavior.DESTROY)
			));
	//## (J&U) Elemental ##
	//# Cheese #
	public static final Block BLUE_CHEESE_BLOCK = registerBlockWithItem("blue_cheese_block",
			new Block(AbstractBlock.Settings.create()
					.mapColor(MapColor.STONE_GRAY)
					.instrument(Instrument.BASEDRUM).strength(3.0F, 6.0F)
					.slipperiness(0.725F)));
	public static final Block SILKY_SMOOTH_CHEESE_BLOCK = registerBlockWithItem("silky_smooth_cheese_block",
			new Block(AbstractBlock.Settings.create()
					.mapColor(MapColor.STONE_GRAY)
					.instrument(Instrument.BASEDRUM).strength(3.0F, 6.0F)
					.slipperiness(0.85F)));
	public static final Block YELLOW_CHEESE_BLOCK = registerBlockWithItem("yellow_cheese_block",
			new Block(AbstractBlock.Settings.create()
					.mapColor(MapColor.STONE_GRAY)
					.instrument(Instrument.BASEDRUM).strength(3.0F, 6.0F)
					.slipperiness(0.725F)));
	//# Metal(?) #
	public static final Block RAW_NUTRILLARN_BLOCK = registerBlockWithItem("raw_nutrillarn_block",
			newBlock(blockSettings()
					.mapColor(MapColor.RAW_IRON_PINK)
					.instrument(Instrument.HARP)
					.strength(6.0F, 8.0F)
					.sounds(BlockSoundGroup.MUD)));
	public static final Block REFINED_NUTRILLARN_BLOCK = registerBlockWithItem("refined_nutrillarn_block",
			newBlock(blockSettings()
					.mapColor(MapColor.DIRT_BROWN)
					.instrument(Instrument.BASEDRUM)
					.strength(6.0F, 8.0F)
					.sounds(BlockSoundGroup.STONE)));
	//# Miscellaneous #
	public static final Block HYPERSMOOTH_CREAMSTONE = registerBlockWithItem("hypersmooth_creamstone",
			new Block(AbstractBlock.Settings.create()
					.mapColor(MapColor.STONE_GRAY)
					.instrument(Instrument.BASEDRUM).strength(3.6F, 8.0F)
					.luminance(state -> 2)
					.strength(4.5F, 9.0F)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)
					.slipperiness(1.0375F))); // Note: Slipperiness of Blue Ice is 0.989.
	public static final Block ULTRASMOOTH_STONE = registerBlockWithItem("ultrasmooth_stone",
			new Block(AbstractBlock.Settings.create()
					.mapColor(MapColor.STONE_GRAY)
					.instrument(Instrument.BASEDRUM).strength(2.4F, 6.0F)
					.strength(3.0F, 7.0F)
					.pistonBehavior(PistonBehavior.PUSH_ONLY)
					.slipperiness(0.98F))); // Note: Same slipperiness as ice, packed ice, and frosted ice.
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
}
