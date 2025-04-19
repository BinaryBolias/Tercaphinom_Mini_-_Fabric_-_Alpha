package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static binarybolias.tercaphinom.references.Reference.log;
import static binarybolias.tercaphinom.references.Reference.logError;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}
	
	public static TextureMap sideFrontTop(Block block) {
		return new TextureMap()
				.put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
				.put(TextureKey.FRONT, TextureMap.getSubId(block, "_front"))
				.put(TextureKey.TOP, TextureMap.getSubId(block, "_top"));
	}
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator bSMG) {
		log("Generating block state model data");
		
		// Texture pools
		// NOTE: Each of these also provides a model for the block type used as a base.
		BlockStateModelGenerator.BlockTexturePool stiefaneBrickPool = bSMG.registerCubeAllModelTexturePool(ModBlocks.STIEFANE_BRICK_BLOCK);
		BlockStateModelGenerator.BlockTexturePool verdakPlankPool = bSMG.registerCubeAllModelTexturePool(ModBlocks.VERDAK_PLANK_BLOCK);
		
		//### Block Models ###
		//region  ## Crops & Foliage ##
		//# Leaf #
		
		//# Log & Trunk #
		bSMG.registerAxisRotated(ModBlocks.VERDAK_LOG, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
		bSMG.registerAxisRotated(ModBlocks.VERDAK_TRUNK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
		
		//# Miscellaneous #
		//endregion
		
		
		//## Elemental ##
		//# Mosaic & Plank #
		
		//# Stone (brick) #
		
		//# Stone (cobbled) #
		bSMG.registerSimpleCubeAll(ModBlocks.COBBLED_STIEFANE_BLOCK);
		
		//# Stone (natural) #
		bSMG.registerSimpleCubeAll(ModBlocks.STIEFANE_BLOCK);
		
		//# Stone (polished) #
		bSMG.registerSimpleCubeAll(ModBlocks.POLISHED_STIEFANE_BLOCK);
		
		//# Miscellaneous #
		bSMG.registerSimpleCubeAll(ModBlocks.ASH_BLOCK);
		
		//## Modified & Transitional ##
		//# Ore (stiefane) #
		bSMG.registerSimpleCubeAll(ModBlocks.STIEFANE_LAPIS_ORE);
		
		
		//## Junction & Utility ##
		//# Button & Pressure Plate #
		stiefaneBrickPool.button(ModBlocks.STIEFANE_BUTTON);
		stiefaneBrickPool.pressurePlate(ModBlocks.STIEFANE_PRESSURE_PLATE);
		verdakPlankPool.button(ModBlocks.VERDAK_BUTTON);
		verdakPlankPool.pressurePlate(ModBlocks.VERDAK_PRESSURE_PLATE);
		
		//# Container & Workstation #
		
		//# Door & Hatch #
		bSMG.registerDoor(ModBlocks.VERDAK_DOOR);
		bSMG.registerTrapdoor(ModBlocks.VERDAK_HATCH);
		
		//# Fence Gate, Fence Post, & Wall #
		stiefaneBrickPool.wall(ModBlocks.STIEFANE_BRICK_WALL_POST);
		verdakPlankPool.fenceGate(ModBlocks.VERDAK_FENCE_GATE);
		verdakPlankPool.fence(ModBlocks.VERDAK_FENCE_POST);
		
		//# Ladder #
		
		//# Pane #
		
		//# Sign #
		
		//# Slab & Stair #
		stiefaneBrickPool.slab(ModBlocks.STIEFANE_BRICK_SLAB);
		stiefaneBrickPool.stairs(ModBlocks.STIEFANE_BRICK_STAIR);
		verdakPlankPool.slab(ModBlocks.VERDAK_PLANK_SLAB);
		verdakPlankPool.stairs(ModBlocks.VERDAK_PLANK_STAIR);
		
		//# Torch #
		
		
		//## Miscellaneous ##
		//# Miscellaneous #
//		bSMG.registerSimpleCubeAll(ModBlocks.ETERNALITH);
		bSMG.registerRotatable(ModBlocks.ETERNALITH);
		
		
		//## Joke & Unserious ##
		//# Cheese #
		bSMG.registerSimpleCubeAll(ModBlocks.BLUE_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.YELLOW_CHEESE_BLOCK);
		//# Miscellaneous #
		bSMG.registerSimpleCubeAll(ModBlocks.HYPERSMOOTH_CREAMSTONE);
		bSMG.registerSimpleCubeAll(ModBlocks.ULTRASMOOTH_STONE);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator iMG) {
		log("Generating item model data data");
		
		//region ## Basic Resources ##
		// # Ball (yarn) #
		genItem(iMG, ModItems.BLACK_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.BLUE_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.BROWN_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.CYAN_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.GRAY_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.GREEN_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_BLUE_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_GRAY_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.LIME_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.MAGENTA_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.ORANGE_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.PINK_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.PURPLE_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.RED_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.WHITE_YARNBALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.YELLOW_YARNBALL, "ball", Models.GENERATED);
		// # Ball (miscellaneous) #
		genItem(iMG, ModItems.COBWEB_BALL, "ball", Models.GENERATED);
		// # Brick #
		genItem(iMG, ModItems.STIEFANE_BRICK, "brick", Models.GENERATED);
		// # Cobblestone #
		genItem(iMG, ModItems.STIEFANE_COBBLESTONE, "cobblestone", Models.GENERATED);
		// # Gram & Ingot #
		genItem(iMG, ModItems.COPPER_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.GOLD_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.IRON_GRAM, "ingot", Models.GENERATED);
		// # Jewel #
		// # Log & Trunk #
		// # Lump & Nugget #
		genItem(iMG, ModItems.RAW_COPPER_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.SULPHUR_LUMP, "lump", Models.GENERATED);
		// # Pile (seed) #
		// # Pile (miscellaneous) #
		genItem(iMG, ModItems.ASH_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.DIRT_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.GRAVEL_PILE, "pile", Models.GENERATED);
		// # Plank #
		genItem(iMG, ModItems.ACACIA_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.BIRCH_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.CHERRY_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.CRIMSON_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.DARK_OAK_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.MAHOGANY_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.MANGROVE_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.OAK_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.SPRUCE_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.VERDAK_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.WARPED_PLANK, "plank", Models.GENERATED);
		// # Bundle & Rod & Stick #
		iMG.register(ModItems.DYNAMITE_BUNDLE, Models.GENERATED);
		iMG.register(ModItems.DYNAMITE_STICK, Models.GENERATED);
		iMG.register(ModItems.WOODEN_STICK_BUNDLE, Models.GENERATED);
		// # Shard #
		genItem(iMG, ModItems.GLASS_SHARD, "shard", Models.GENERATED);
		genItem(iMG, ModItems.OBSIDIAN_SHARD, "shard", Models.GENERATED);
		// # Miscellaneous #
		iMG.register(ModItems.CHEESE_WHEEL, Models.GENERATED);
		iMG.register(ModItems.GRASS_TUFT, Models.GENERATED);
		iMG.register(ModItems.SILK_WAD, Models.GENERATED);
		iMG.register(ModItems.STONE_PEBBLE, Models.GENERATED);
		//endregion
		
		//region ## Equipment ##
		//# [Tier 0] Wooden Stick #
		genItem(iMG, ModItems.SHARP_WOODEN_STICK, "equipment", Models.HANDHELD);
		//# [Tier 1] Wood #
		//# [Tier 2] Flint #
		//# [Tier 2] Glass #
		//# [Tier 2] Obsidian #
		//# [Tier 3] Copper #
		//# [Tier 3] Eiduril #
		//# [Tier 3] Gold #
		//# [Tier 3] Iron #
		//endregion
		
		//region  ## Joke & Unserious ##
		//# Cheese #
		genItem(iMG, ModItems.BLUE_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.YELLOW_CHEESE_WEDGE, "unserious", Models.GENERATED);
		//# Miscellaneous #
		genItem(iMG, ModItems.ENCHANTED_BRICK, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.MINIWIZARD, "unserious", Models.GENERATED);
		//endregion
		
		
	}
	
	/**
	 * Register an item model while taking in a custom path. Useful for texture organization in the file system.
	 * @param itemModelGenerator The item model generator.
	 * @param item The item for the model to be assigned to. The item's identifier is also assumed as the file name.
	 * @param path The folder path to the file, from the "textures/item/" folder. Should not begin or end with "/".
	 * @param model The model type to be generated.
	 */
	private static void genItem(ItemModelGenerator itemModelGenerator, Item item, String path, Model model) {
		Identifier identifier = Registries.ITEM.getId(item);
		
		if (Objects.equals(path, "")) {
			path = "item/";
		} else {
			if (isInvalidPathWithError(path)) {
				return;
			}
			path = "item/" + path + "/";
		}
		identifier = identifier.withPrefixedPath(path);
		model.upload(ModelIds.getItemModelId(item), new TextureMap().put(TextureKey.LAYER0, identifier), itemModelGenerator.writer);
	}
	
	/**
	 * Register a block state model while taking in a custom path. Useful for texture organization in the file system.
	 * @param blockStateModelGenerator The block state model generator.
	 * @param block The item for the model to be assigned to. The item's identifier is also assumed as the file name.
	 * @param path The folder path to the file, from the "textures/block/" folder. Should not begin or end with "/".
	 * @param model The model type to be generated.
	 */
	private static void genBlockStates(ItemModelGenerator blockStateModelGenerator, Block block, String path, Model model) {
		Identifier identifier = Registries.BLOCK.getId(block);
		
		if (Objects.equals(path, "")) {
			path = "item/";
		} else {
			if (isInvalidPathWithError(path)) {
				return;
			}
			path = "item/" + path + "/";
		}
		identifier = identifier.withPrefixedPath(path);
		// TODO: Refactor this to work for block states (this method was derived from 'genItem').
		model.upload(ModelIds.getBlockModelId(block), new TextureMap().put(TextureKey.LAYER0, identifier), blockStateModelGenerator.writer);
	}
	
	private static boolean isInvalidPathWithError(String path) {
		if (!Identifier.isPathValid(path)) {
			logError("Passed path '" + path + "' is not valid");
			return true;
		}
		if (path.charAt(0) == '/' || (path.charAt(path.length() - 1) == '/')) {
			logError("Passed path '" + path + "' begins or ends with a '/'");
			return true;
		}
		return false;
	}
}
