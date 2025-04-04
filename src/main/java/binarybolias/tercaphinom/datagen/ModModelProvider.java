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
//		bSMG.registerAxisRotated(ModBlocks.VERDAK_LOG, ModelIds.getBlockModelId(ModBlocks.VERDAK_LOG));
//		bSMG.registerAxisRotated(ModBlocks.VERDAK_TRUNK, ModelIds.getBlockModelId(ModBlocks.VERDAK_TRUNK));
//		bSMG.registerSingleton(ModBlocks.VERDAK_LOG, TexturedModel.ORIENTABLE);
//		bSMG.registerSingleton(ModBlocks.VERDAK_TRUNK, TexturedModel.CUBE_COLUMN);
		
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
		//# Miscellaneous #
		bSMG.registerSimpleCubeAll(ModBlocks.ULTRASMOOTH_STONE);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator iMG) {
		log("Generating item model data data");
		
		// NOTE: We would ideally be able to execute the local "genItem" method's functionality without passing 'iMG' as a parameter.
		genItem(iMG, ModItems.STIEFANE_BRICK, "brick", Models.GENERATED);
		genItem(iMG, ModItems.STIEFANE_COBBLESTONE, "cobblestone", Models.GENERATED);
		genItem(iMG, ModItems.OAK_PLANK, "plank", Models.GENERATED);
		genItem(iMG, ModItems.VERDAK_PLANK, "plank", Models.GENERATED);
		//# Equipment #
		genItem(iMG, ModItems.SHARP_WOODEN_STICK, "equipment", Models.HANDHELD);
		
		iMG.register(ModItems.GRASS_TUFT, Models.GENERATED);
		iMG.register(ModItems.SILK_WAD, Models.GENERATED);
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
