package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Objects;

import static binarybolias.tercaphinom.references.Reference.log;
import static binarybolias.tercaphinom.references.Reference.logError;

/**
 * Relevant references:
 * {@link net.minecraft.data.client.BlockStateModelGenerator}
 */

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
		
		
		//region## Elemental ##
		//# Metal #
		bSMG.registerSimpleCubeAll(ModBlocks.RAW_BRASS_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.RAW_EIDURIL_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.REFINED_BRASS_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.REFINED_EIDURIL_BLOCK);
		//# Mosaic & Plank #
		// TODO: For using the new (non-cube-all) model, the corresponding block texture pool needs to be removed.
		//  This requires the corresponding button, pressure plate, stair, slab, fence post, and fence gate to have separate model registration methods.
//		bSMG.registerSingleton(ModBlocks.VERDAK_PLANK_BLOCK, TexturedModel.CUBE_TOP);
		//# Stone (brick) #
		//# Stone (cobbled) #
		bSMG.registerSimpleCubeAll(ModBlocks.COBBLED_STIEFANE_BLOCK);
		//# Stone (natural) #
		bSMG.registerSimpleCubeAll(ModBlocks.STIEFANE_BLOCK);
		//# Stone (polished) #
		bSMG.registerSimpleCubeAll(ModBlocks.POLISHED_STIEFANE_BLOCK);
		//# Miscellaneous #
		bSMG.registerSimpleCubeAll(ModBlocks.ASH_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.SKORSAND_BLOCK);
		//endregion
		
		//region ## Modified & Transitional ##
		//# Ore (stiefane) #
		bSMG.registerSimpleCubeAll(ModBlocks.STIEFANE_LAPIS_ORE);
		//endregion
		
		//region## Junction & Utility ##
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
		//endregion
		
		//region ## Miscellaneous ##
		//# Miscellaneous #
//		bSMG.registerSimpleCubeAll(ModBlocks.ETERNALITH);
		bSMG.registerRotatable(ModBlocks.ETERNALITH_BLOCK);
		//endregion
		
		//### Joke & Unserious ###
		//## (J&U) Crops & Foliage ##
		//# Miscellaneous #
		bSMG.registerTintableCross(ModBlocks.STARCHCAP_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
		//## (J&U) Elemental ##
		//# Cheese #
		bSMG.registerSimpleCubeAll(ModBlocks.BLUE_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.YELLOW_CHEESE_BLOCK);
		//# Metal #
		bSMG.registerSimpleCubeAll(ModBlocks.RAW_NUTRILLARN_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.REFINED_NUTRILLARN_BLOCK);
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
		genItem(iMG, ModItems.BRASS_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.BRASS_INGOT, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.COPPER_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.EIDURIL_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.EIDURIL_INGOT, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.GOLD_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.IRON_GRAM, "ingot", Models.GENERATED);
		// # Jewel #
		// # Log & Trunk #
		genItem(iMG, ModItems.VERDAK_LOG, "log", Models.GENERATED);
		genItem(iMG, ModItems.VERDAK_TRUNK, "log", Models.GENERATED);
		// # Lump & Nugget #
		genItem(iMG, ModItems.RAW_BRASS_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_BRASS_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_COPPER_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_EIDURIL_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_EIDURIL_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.SULPHUR_LUMP, "lump", Models.GENERATED);
		// # Pile (seed) #
		// # Pile (miscellaneous) #
		genItem(iMG, ModItems.ASH_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.DIRT_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FELDSAND_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FERROSAND_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FREEZE_POWDER_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.GRAVEL_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.SKORSAND_PILE, "pile", Models.GENERATED);
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
		genItem(iMG, ModItems.FREEZE_ROD, "rod", Models.GENERATED);
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
		genItem(iMG, ModItems.WOODEN_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.WOODEN_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.WOODEN_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.WOODEN_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.WOODEN_SWORD, "equipment", Models.HANDHELD);
		//# [Tier 2] Flint #
		genItem(iMG, ModItems.FLINT_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.FLINT_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.FLINT_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.FLINT_SPEAR, "equipment", Models.HANDHELD);
		//# [Tier 2] Glass #
		genItem(iMG, ModItems.GLASS_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GLASS_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GLASS_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GLASS_SPEAR, "equipment", Models.HANDHELD);
		//# [Tier 2] Obsidian #
		genItem(iMG, ModItems.OBSIDIAN_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.OBSIDIAN_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.OBSIDIAN_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.OBSIDIAN_SPEAR, "equipment", Models.HANDHELD);
		//# [Tier 3] Brass (armor) #
		// Note: Assimilating the entire vanilla armor generation scheme is tedious,
		//  so we're just using the vanilla generator, and thus we need to keep armor item textures
		//  in the base directory, rather than under "/item/equipment/" like a civilized individual.
		iMG.registerArmor((ArmorItem) ModItems.BRASS_BOOT_PAIR);
		iMG.registerArmor((ArmorItem) ModItems.BRASS_CHESTPLATE);
		iMG.registerArmor((ArmorItem) ModItems.BRASS_HELMET);
		genItem(iMG, ModItems.BRASS_HORSE_ARMOR, "equipment", Models.GENERATED);
		iMG.registerArmor((ArmorItem) ModItems.BRASS_LEGGING_PAIR);
		//# [Tier 3] Brass (tools) #
		genItem(iMG, ModItems.BRASS_AXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_PICKAXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.BRASS_SWORD, "equipment", Models.HANDHELD);
		//# [Tier 3] Copper (armor) #
		iMG.registerArmor((ArmorItem) ModItems.COPPER_BOOT_PAIR);
		iMG.registerArmor((ArmorItem) ModItems.COPPER_CHESTPLATE);
		iMG.registerArmor((ArmorItem) ModItems.COPPER_HELMET);
		genItem(iMG, ModItems.COPPER_HORSE_ARMOR, "equipment", Models.GENERATED);
		iMG.registerArmor((ArmorItem) ModItems.COPPER_LEGGING_PAIR);
		//# [Tier 3] Copper (tools) #
		genItem(iMG, ModItems.COPPER_AXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_PICKAXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.COPPER_SWORD, "equipment", Models.HANDHELD);
		//# [Tier 3] Eiduril (armor) #
		iMG.registerArmor((ArmorItem) ModItems.EIDURIL_BOOT_PAIR);
		iMG.registerArmor((ArmorItem) ModItems.EIDURIL_CHESTPLATE);
		iMG.registerArmor((ArmorItem) ModItems.EIDURIL_HELMET);
		genItem(iMG, ModItems.EIDURIL_HORSE_ARMOR, "equipment", Models.GENERATED);
		iMG.registerArmor((ArmorItem) ModItems.EIDURIL_LEGGING_PAIR);
		//# [Tier 3] Eiduril (tools) #
		genItem(iMG, ModItems.EIDURIL_AXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_PICKAXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.EIDURIL_SWORD, "equipment", Models.HANDHELD);
		//# [Tier 3] Gold (armor) #
		//# [Tier 3] Gold (tools) #
		genItem(iMG, ModItems.GOLDEN_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GOLDEN_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GOLDEN_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.GOLDEN_SPEAR, "equipment", Models.HANDHELD);
		//# [Tier 3] Iron (armor) #
		//# [Tier 3] Iron (tools) #
		genItem(iMG, ModItems.IRON_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.IRON_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.IRON_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.IRON_SPEAR, "equipment", Models.HANDHELD);
		//endregion
		
		
		//region  ## Joke & Unserious ##
		
		//## (J&U) Basic Resources ##
		//# Ball #
		genItem(iMG, ModItems.CHERRY_JELLYBALL, "unserious", Models.GENERATED);
		//# Brick #
		//# Cobblestone #
		//# Gram & Ingot #
		genItem(iMG, ModItems.NUTRILLARN_GRAM, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.NUTRILLARN_INGOT, "unserious", Models.GENERATED);
		//# Jewel #
		//# Log & Trunk #
		//# Lump & Nugget #
		genItem(iMG, ModItems.RAW_NUTRILLARN_LUMP, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.RAW_NUTRILLARN_NUGGET, "unserious", Models.GENERATED);
		//# Pile (seed) #
		//# Pile (miscellaneous) #
		genItem(iMG, ModItems.MILKLEAF_PILE, "unserious", Models.GENERATED);
		//# Plank #
		//# Bundle & Rod & Stick #
		//# Shard #
		//# Wedge #
		genItem(iMG, ModItems.BLUE_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.SILKY_SMOOTH_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.YELLOW_CHEESE_WEDGE, "unserious", Models.GENERATED);
		//# Miscellaneous #
		genItem(iMG, ModItems.CHULK_BERRY, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.ENCHANTED_BRICK, "unserious", Models.GENERATED);
		genItem(iMG, ModItems.MINIWIZARD, "unserious", Models.GENERATED);
//		genItem(iMG, ModItems.STARCHCAP_MUSHROOM, "unserious", Models.GENERATED); // TODO: Use separate item model generation.
		
		//## (J&U) Equipment ##
		//# Nutrillarn (armor) #
		iMG.registerArmor((ArmorItem) ModItems.NUTRILLARN_BOOT_PAIR);
		iMG.registerArmor((ArmorItem) ModItems.NUTRILLARN_CHESTPLATE);
		iMG.registerArmor((ArmorItem) ModItems.NUTRILLARN_HELMET);
		genItem(iMG, ModItems.NUTRILLARN_HORSE_ARMOR, "equipment", Models.GENERATED);
		iMG.registerArmor((ArmorItem) ModItems.NUTRILLARN_LEGGING_PAIR);
		//# Nutrillarn (tools) #
		genItem(iMG, ModItems.NUTRILLARN_AXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_PICKAXE, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, ModItems.NUTRILLARN_SWORD, "equipment", Models.HANDHELD);
		//# Miscellaneous #
		
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
