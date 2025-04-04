package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;

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
				new BlockItem(block, new Item.Settings()));
	}
	
	//### Blocks ###
	//region  ## Crops & Foliage ##
	//# Leaf #
	
	//# Log & Trunk #
	public static final Block VERDAK_LOG = registerBlockWithItem("verdak_log",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(MapColor.PALE_GREEN))); // TODO: Make unique.
	public static final Block VERDAK_TRUNK = registerBlockWithItem("verdak_trunk",
			new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
					.mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ?
							MapColor.PALE_GREEN : /* top color */
							MapColor.DARK_GREEN /* side color */))); // TODO: Make unique.
	
	//# Miscellaneous #
	//endregion
	
	//region  ## Elemental ##
	//# Mosaic & Plank #
	public static final Block VERDAK_PLANK_BLOCK = registerBlockWithItem("verdak_plank_block",
			new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS))); // TODO: Make unique.
	
	//# Stone (brick) #
	public static final Block STIEFANE_BRICK_BLOCK = registerBlockWithItem("stiefane_brick_block",
			new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS))); // TODO: Make unique.
	
	//# Stone (cobbled) #
	public static final Block COBBLED_STIEFANE_BLOCK = registerBlockWithItem("cobbled_stiefane_block",
			new Block(AbstractBlock.Settings.copy(Blocks.COBBLESTONE))); // TODO: Make unique.
	
	//# Stone (natural) #
	public static final Block STIEFANE_BLOCK = registerBlockWithItem("stiefane_block",
			new Block(AbstractBlock.Settings.copy(Blocks.STONE))); // TODO: Make unique.
	
	//# Stone (polished) #
	public static final Block POLISHED_STIEFANE_BLOCK = registerBlockWithItem("polished_stiefane_block",
			new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE))); // TODO: Make unique.
	
	//# Miscellaneous #
	//endregion
	
	//region  ## Modified & Transitional ##
	//# Ore (netherrack) #
	
	//# Ore (stiefane) #
	public static final Block STIEFANE_LAPIS_ORE = registerBlockWithItem("stiefane_lapis_ore",
			new Block(AbstractBlock.Settings.copy(Blocks.LAPIS_ORE))); // TODO: Make unique.
	
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
	public static final Block VERDAK_DOOR = registerBlockWithItem("verdak_door",
			new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR))); // TODO: Make unique.
	public static final Block VERDAK_HATCH = registerBlockWithItem("verdak_hatch",
			new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR))); // TODO: Make unique.
	
	//# Fence Gate, Fence Post, & Wall #
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
	public static final Block ETERNALITH = registerBlockWithItem("eternalith", // Rename to "eternalith_block"?
			new Block(AbstractBlock.Settings.copy(Blocks.BEDROCK))); // TODO: Make unique.
	//endregion
	
	//region  ## Joke & Unserious ##
	//# Miscellaneous #
	public static final Block ULTRASMOOTH_STONE = registerBlockWithItem("ultrasmooth_stone",
			new Block(AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE).slipperiness(0.98F))); // Same slipperiness as ice, packed ice, and frosted ice.
	// NOTE: Slipperiness of Blue Ice is 0.989.
	// TODO: Add Hypersmooth Creamstone, slipperiness of 0.995!
	//endregion
}
