package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		log("Generating block state model data");
		
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETERNALITH);
		blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ULTRASMOOTH_STONE_BLOCK);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		log("Generating item model data data");
		
		// NOTE: We would ideally be able to execute the local "genItem" method's functionality without passing 'itemModelGenerator' as a parameter.
		genItem(itemModelGenerator, ModItems.SHARP_WOODEN_STICK, "equipment", Models.HANDHELD);
		genItem(itemModelGenerator, ModItems.OAK_PLANK, "plank", Models.GENERATED);
		
		itemModelGenerator.register(ModItems.GRASS_TUFT, Models.GENERATED);
		itemModelGenerator.register(ModItems.SILK_WAD, Models.GENERATED);
	}
	
	/**
	 * Register an item model while taking in a custom path.
	 * @param itemModelGenerator The item model generator. This would ideally not be necessary, as this method is only to be called from the "generateItemModels" method, which has an item model generator as a parameter.
	 * @param item The item for the model to be assigned to. The item's identifier is also assumed as the file name.
	 * @param path The folder path to the file, from the "textures/item/" folder. Should not begin or end with "/".
	 * @param model The model type to be generated.
	 */
	private static void genItem(ItemModelGenerator itemModelGenerator, Item item, String path, Model model) {
		Identifier identifier = Registries.ITEM.getId(item);
		
		if (Objects.equals(path, "")) {
			path = "item/";
		} else {
			if (!isValidPathOrLogError(path)) {
				return;
			}
			path = "item/" + path + "/";
		}
		identifier = identifier.withPrefixedPath(path);
		model.upload(ModelIds.getItemModelId(item), new TextureMap().put(TextureKey.LAYER0, identifier), itemModelGenerator.writer);
	}
	
	private static boolean isValidPathOrLogError(String path) {
		if (!Identifier.isPathValid(path)) {
			logError("Passed path '" + path + "' is not valid");
			return false;
		}
		if (path.charAt(0) == '/' || (path.charAt(path.length() - 1) == '/')) {
			logError("Passed path '" + path + "' begins or ends with a '/'");
			return false;
		}
		return true;
	}
}
