package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.JAUBlocks;
import binarybolias.tercaphinom.references.JAUItems;
import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;
import static binarybolias.tercaphinom.references.Reference.logError;


/**
 * @see net.minecraft.data.client.BlockStateModelGenerator
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
		logMainEvent("Generating block state model data");
		
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
		//# Bale #
		bSMG.registerSingleton(Blocks.TNT, TexturedModel.CUBE_BOTTOM_TOP);
		//# Metal #
		bSMG.registerSimpleCubeAll(ModBlocks.CORRODED_VILBIARN_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.RAW_BRASS_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.RAW_EIDURIL_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.REFINED_BRASS_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.REFINED_EIDURIL_BLOCK);
		bSMG.registerSingleton(ModBlocks.REFINED_VILBIARN_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
		//# Mosaic & Plank #
		// TODO: For using the new (non-cube-all) model, the corresponding block texture pool needs to be removed.
		//  This requires the corresponding button, pressure plate, stair, slab, fence post, and fence gate to have separate model registration methods.
//		bSMG.registerSingleton(ModBlocks.VERDAK_PLANK_BLOCK, TexturedModel.CUBE_TOP);
		//# Stone (brick) #
		//# Stone (cobbled) #
		bSMG.registerSimpleCubeAll(ModBlocks.COBBLED_STIEFANE_BLOCK);
		//# Stone (natural) #
		bSMG.registerSimpleCubeAll(ModBlocks.NATURAL_STIEFANE_BLOCK);
		//# Stone (polished) #
		bSMG.registerSimpleCubeAll(ModBlocks.POLISHED_STIEFANE_BLOCK);
		//# Miscellaneous #
//		bSMG.registerSimpleCubeAll(ModBlocks.ASH_BLOCK);
		registerAshBlockAndMound(bSMG);
		bSMG.registerSimpleCubeAll(ModBlocks.GLASS_SHARD_BLOCK);
		bSMG.registerSimpleCubeAll(ModBlocks.SKORSAND_BLOCK);
		//endregion
		
		//region ## Modified & Transitional ##
		//# Ore (slate) #
		bSMG.registerSingleton(Blocks.DEEPSLATE_IRON_ORE, TexturedModel.CUBE_TOP);
		//# Ore (stiefane) #
		bSMG.registerSimpleCubeAll(ModBlocks.STIEFANE_LAPIS_ORE);
		//# Reinforced #
		//# Miscellaneous #
		registerFullyRandomTextureRotationCube(bSMG, ModBlocks.ASHY_NETHERRACK_BLOCK);
		//endregion
		
		//region## Junction & Utility ##
		//# Button & Pressure Plate #
		stiefaneBrickPool.button(ModBlocks.STIEFANE_BUTTON);
		stiefaneBrickPool.pressurePlate(ModBlocks.STIEFANE_PRESSURE_PLATE);
		verdakPlankPool.button(ModBlocks.VERDAK_BUTTON);
		verdakPlankPool.pressurePlate(ModBlocks.VERDAK_PRESSURE_PLATE);
		//# Container & Workstation #
		registerCubeSideFrontTopBottom(bSMG, Blocks.CRAFTING_TABLE);
		//# Door & Hatch #
		bSMG.registerDoor(ModBlocks.VERDAK_DOOR);
		bSMG.registerTrapdoor(ModBlocks.VERDAK_HATCH);
		//# Fence Gate, Fence Post, & Wall #
		stiefaneBrickPool.wall(ModBlocks.STIEFANE_BRICK_WALL_POST);
		verdakPlankPool.fenceGate(ModBlocks.VERDAK_GATE);
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
		//# Eternalith - Basic #
		registerFullyRandomTextureRotationCube(bSMG, ModBlocks.ETERNALITH_BLOCK);
		//# Eternalith - Modified #
		registerFullyRandomTextureRotationCube(bSMG, ModBlocks.CHISELED_ETERNALITH_BLOCK);
		//# Miscellaneous #
		//endregion
		
		//### Joke & Unserious ###
		//## (J&U) Crops & Foliage ##
		//# Miscellaneous #
		bSMG.registerTintableCrossBlockState(JAUBlocks.STARCHCAP_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
		//## (J&U) Elemental ##
		//# Cheese #
		bSMG.registerSimpleCubeAll(JAUBlocks.BLUE_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
		bSMG.registerSimpleCubeAll(JAUBlocks.YELLOW_CHEESE_BLOCK);
		//# Metal #
		bSMG.registerSimpleCubeAll(JAUBlocks.RAW_NUTRILLARN_BLOCK);
		bSMG.registerSimpleCubeAll(JAUBlocks.REFINED_NUTRILLARN_BLOCK);
		//# Miscellaneous #
		bSMG.registerSimpleCubeAll(JAUBlocks.CANDESAND_BLOCK);
		bSMG.registerSimpleState(JAUBlocks.CHERRY_JELLYBLOCK);
		bSMG.registerSimpleCubeAll(JAUBlocks.HYPERSMOOTH_CREAMSTONE);
		bSMG.registerSimpleCubeAll(JAUBlocks.ULTRASMOOTH_STONE);
		//## (J&U) Modified & Transitional ##
		//# Reinforced #
		bSMG.registerSingleton(JAUBlocks.REINFORCED_STAINED_GLASS_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
	}
	
	
	
	private void registerCubeSideFrontTopBottom(BlockStateModelGenerator bSMG, Block block) {
		TextureMap textureMap = new TextureMap()
				.put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_front"))
				.put(TextureKey.DOWN, TextureMap.getSubId(block, "_bottom"))
				.put(TextureKey.UP, TextureMap.getSubId(block, "_top"))
				.put(TextureKey.NORTH, TextureMap.getSubId(block, "_front"))
				.put(TextureKey.SOUTH, TextureMap.getSubId(block, "_front"))
				.put(TextureKey.EAST, TextureMap.getSubId(block, "_side"))
				.put(TextureKey.WEST, TextureMap.getSubId(block, "_side"));
		bSMG.blockStateCollector.accept(
				createSingletonBlockState(block, Models.CUBE.upload(
						block, textureMap, bSMG.modelCollector
				))
		);
	}
	
	
	public static VariantsBlockStateSupplier createSingletonBlockState(Block block, Identifier modelId) {
		return VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, modelId));
	}
	
	
	private void registerAshBlockAndMound(BlockStateModelGenerator bSMG) {
		//Note: Parity with VMc snow model generator implementation:
		// - In vanilla, the Snow Mound is simply named "snow", and is given ownership of a texture map.
		//  - Because of this, the texture map used for both the mound and block uses "snow" as its identifier.
		// - Because neither the Ash Mound nor Ash Block are simply named "ash":
		//  - We would want to artificially inject "ash" as the identifier to use...
		//  - Or, we use "ash_block" as the identifier, which probably makes the next most sense...
		//TODO:
		// - Figure out how these methods actually function.
		//  - What does defining this 'textureMap' do?
		//  - What does defining this 'identifier' do?
		//  - What's the deal with 'blockStateCollector'?
		// - TO FIX: Models for individual Ash Mound heights not being generated.
		//  - Block state file is generated, and correctly uses the Ash Block model for height 16.
		//  - Ehh... Just generating the 7 layer files (heights 2-14) manually; doesn't seem to be an obvious way to generate them programmatically.
		//   - Perhaps even Mojang typed them out manually? Seems like it might have also been the case for the Honey and Slime blocks...
		TextureMap textureMap = TextureMap.all(ModBlocks.ASH_BLOCK);
		Identifier identifier = Models.CUBE_ALL.upload(ModBlocks.ASH_BLOCK, textureMap, bSMG.modelCollector);
		bSMG.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.ASH_MOUND)
				.coordinate(BlockStateVariantMap.create(Properties.LAYERS)
						.register(layers -> BlockStateVariant.create()
								.put(VariantSettings.MODEL, layers < 8 ? ModelIds.getBlockSubModelId(ModBlocks.ASH_MOUND, "-height_" + layers * 2) : identifier)
						)
				)
		);
		bSMG.blockStateCollector.accept(createSingletonBlockState(ModBlocks.ASH_BLOCK, identifier));
	}
	
	
	private void registerFullyRandomTextureRotationCube(BlockStateModelGenerator bSMG, Block block) {
		Identifier identifier = TexturedModel.CUBE_ALL.upload(block, bSMG.modelCollector);
		bSMG.blockStateCollector
				.accept(
						VariantsBlockStateSupplier.create(
								block,
								BlockStateVariant.create() // (0, 0)
										.put(VariantSettings.MODEL, identifier),
								BlockStateVariant.create() // (90, 0)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R90),
								BlockStateVariant.create() // (180, 0)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R180),
								BlockStateVariant.create() // (270, 0)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R270),
								BlockStateVariant.create() // (0, 90)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.Y, VariantSettings.Rotation.R90),
								BlockStateVariant.create() // (90, 90)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R90)
										.put(VariantSettings.Y, VariantSettings.Rotation.R90),
								BlockStateVariant.create() // (180, 90)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R180)
										.put(VariantSettings.Y, VariantSettings.Rotation.R90),
								BlockStateVariant.create() // (270, 90)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R270)
										.put(VariantSettings.Y, VariantSettings.Rotation.R90),
								BlockStateVariant.create() // (0, 180)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.Y, VariantSettings.Rotation.R180),
								BlockStateVariant.create() // (90, 180)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R90)
										.put(VariantSettings.Y, VariantSettings.Rotation.R180),
								BlockStateVariant.create() // (180, 180)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R180)
										.put(VariantSettings.Y, VariantSettings.Rotation.R180),
								BlockStateVariant.create() // (270, 180)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R270)
										.put(VariantSettings.Y, VariantSettings.Rotation.R180),
								BlockStateVariant.create() // (0, 270)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.Y, VariantSettings.Rotation.R270),
								BlockStateVariant.create() // (90, 270)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R90)
										.put(VariantSettings.Y, VariantSettings.Rotation.R270),
								BlockStateVariant.create() // (180, 270)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R180)
										.put(VariantSettings.Y, VariantSettings.Rotation.R270),
								BlockStateVariant.create() // (270, 270)
										.put(VariantSettings.MODEL, identifier)
										.put(VariantSettings.X, VariantSettings.Rotation.R270)
										.put(VariantSettings.Y, VariantSettings.Rotation.R270)
						)
				);
	}
	
	
	
	@Override
	public void generateItemModels(ItemModelGenerator iMG) {
		logMainEvent("Generating item model data data");
		
		//region ## Basic Resources ##
		//# Ball (yarn) #
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
		//# Ball (miscellaneous) #
		genItem(iMG, ModItems.COBWEB_BALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.MUDBALL, "ball", Models.GENERATED);
		//# Brick #
		genItem(iMG, ModItems.NETHERWART_BRICK, "brick", Models.GENERATED);
		genItem(iMG, ModItems.STIEFANE_BRICK, "brick", Models.GENERATED);
		//# Bundle & Rod & Stick #
		iMG.register(ModItems.DYNAMITE_BUNDLE, Models.GENERATED);
		iMG.register(ModItems.DYNAMITE_STICK, Models.GENERATED);
		genItem(iMG, ModItems.FREEZE_ROD, "rod", Models.GENERATED);
		iMG.register(ModItems.WOODEN_STICK_BUNDLE, Models.GENERATED);
		//# Chunk #
		genItem(iMG, ModItems.WARPED_FLESH_CHUNK, "chunk", Models.GENERATED);
		//# Clod #
		genItem(iMG, ModItems.SOULSOIL_CLOD, "clod", Models.GENERATED);
		//# Cobblestone #
		genItem(iMG, ModItems.STIEFANE_COBBLESTONE, "cobblestone", Models.GENERATED);
		//# Gram & Ingot #
		genItem(iMG, ModItems.BRASS_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.BRASS_INGOT, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.COPPER_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.EIDURIL_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.EIDURIL_INGOT, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.GOLD_GRAM, "ingot", Models.GENERATED);
		genItem(iMG, ModItems.IRON_GRAM, "ingot", Models.GENERATED);
		//# Jewel #
		//# Log & Trunk #
		genItem(iMG, ModItems.VERDAK_LOG, "log", Models.GENERATED);
		genItem(iMG, ModItems.VERDAK_TRUNK, "log", Models.GENERATED);
		//# Lump & Nugget (metal) #
		genItem(iMG, ModItems.CORRODED_VILBIARN_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_BRASS_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_BRASS_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_COPPER_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_EIDURIL_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_EIDURIL_NUGGET, "lump", Models.GENERATED);
		genItem(iMG, ModItems.REFINED_VILBIARN_LUMP, "lump", Models.GENERATED);
		//# Lump & Nugget (miscellaneous) #
		genItem(iMG, ModItems.INFERNOCOAL_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.SULPHUR_LUMP, "lump", Models.GENERATED);
		//# Pane (glass - clear) #
		genItem(iMG, ModItems.CLEAR_GLASS_PANE, "pane", Models.GENERATED);
		//# Pane (glass - stained) #
		genItem(iMG, ModItems.BLACK_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.BLUE_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.BROWN_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.CYAN_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.GRAY_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.GREEN_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_BLUE_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_GRAY_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.LIME_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.MAGENTA_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.ORANGE_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.PINK_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.PURPLE_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.RED_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.WHITE_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		genItem(iMG, ModItems.YELLOW_STAINED_GLASS_PANE, "pane", Models.GENERATED);
		//# Pane (metal) #
		//# Pane (miscellaneous) #
		//# Pile (seed) #
		//# Pile (miscellaneous) #
		genItem(iMG, ModItems.ASH_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.DIRT_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FELDSAND_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FERROSAND_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.FREEZE_POWDER_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.GRAVEL_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.LEAF_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.SKORSAND_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.SNOW_PILE, "pile", Models.GENERATED);
		genItem(iMG, ModItems.SOULSAND_PILE, "pile", Models.GENERATED);
		//# Plank #
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
		//# Roll #
		genItem(iMG, ModItems.BLACK_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.BLUE_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.BROWN_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.CYAN_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.GRAY_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.GREEN_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_BLUE_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.LIGHT_GRAY_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.LIME_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.MAGENTA_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.ORANGE_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.PINK_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.PURPLE_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.RED_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.WHITE_YARN_ROLL, "roll", Models.GENERATED);
		genItem(iMG, ModItems.YELLOW_YARN_ROLL, "roll", Models.GENERATED);
		//# Shard #
		genItem(iMG, ModItems.DARK_PRISMARINE_SHARD, "shard", Models.GENERATED);
		genItem(iMG, ModItems.GLASS_SHARD, "shard", Models.GENERATED);
		genItem(iMG, ModItems.OBSIDIAN_SHARD, "shard", Models.GENERATED);
		//# Skull #
		genItem(iMG, Items.SKELETON_SKULL, "skull", Models.GENERATED);
		genItem(iMG, Items.WITHER_SKELETON_SKULL, "skull", Models.GENERATED);
		//# Miscellaneous #
		iMG.register(ModItems.DRY_GRASS_TUFT, Models.GENERATED);
		iMG.register(ModItems.LIVE_GRASS_TUFT, Models.GENERATED);
		iMG.register(ModItems.PINECONE, Models.GENERATED);
		iMG.register(ModItems.SILK_WAD, Models.GENERATED);
		iMG.register(ModItems.STONE_PEBBLE, Models.GENERATED);
		//endregion
		
		//region ## Containers ##
		//# Bottle (empty) #
		//# Bottle (filled) #
		genItem(iMG, ModItems.BOTTLE_OF_BRIMWATER, "bottle", Models.GENERATED);
		genItem(iMG, ModItems.BOTTLE_OF_FREEZEWATER, "bottle", Models.GENERATED);
		genItem(iMG, ModItems.BOTTLE_OF_MILK, "bottle", Models.GENERATED);
		genItem(iMG, ModItems.BOTTLE_OF_STEAMING_WATER, "bottle", Models.GENERATED);
		//# Bowl (empty) #
		//# Bowl (filled - soup) #
		genItem(iMG, ModItems.BOWL_OF_CARROT_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_KELP_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_MUSHROOM_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_POISONOUS_POTATO_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_PORRIDGE, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_POTATO_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_PUMPKIN_SOUP, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_RADISH_SOUP, "bowl", Models.GENERATED);
		//# Bowl (filled - stew) #
		genItem(iMG, ModItems.BOWL_OF_BEEF_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_BUGMEAT_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_CHICKEN_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_COD_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_MORSEL_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_MUTTON_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_PORK_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_RABBIT_STEW, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_SALMON_STEW, "bowl", Models.GENERATED);
		//# Bowl (filled - miscellaneous) #
		genItem(iMG, ModItems.BOWL_OF_BRIMWATER, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_FREEZEWATER, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_HONEY, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_MILK, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_STEAMING_WATER, "bowl", Models.GENERATED);
		genItem(iMG, ModItems.BOWL_OF_WATER, "bowl", Models.GENERATED);
		//# Bucket (empty) #
		//# Bucket (filled) #
		genItem(iMG, ModItems.BUCKET_OF_BRIMWATER, "bucket", Models.GENERATED);
		genItem(iMG, ModItems.BUCKET_OF_FERTILIZER, "bucket", Models.GENERATED);
		genItem(iMG, ModItems.BUCKET_OF_FREEZEWATER, "bucket", Models.GENERATED);
		genItem(iMG, ModItems.BUCKET_OF_HONEY, "bucket", Models.GENERATED);
		genItem(iMG, ModItems.BUCKET_OF_STEAMING_WATER, "bucket", Models.GENERATED);
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
		genItem(iMG, ModItems.BRASS_HORSE_HARNESS, "equipment", Models.GENERATED);
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
		genItem(iMG, ModItems.COPPER_HORSE_HARNESS, "equipment", Models.GENERATED);
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
		genItem(iMG, ModItems.EIDURIL_HORSE_HARNESS, "equipment", Models.GENERATED);
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
		//# Miscellaneous #
		genItem(iMG, ModItems.SPATIAL_RECALL_STONE, "equipment", Models.GENERATED);
		genItem(iMG, ModItems.TARGET_TELEPORTATION_TUNER, "equipment", Models.HANDHELD);
		//endregion
		
		//region ## Foods ##
		//# Basic (cooked) #
		iMG.register(ModItems.BAKED_CARROT, Models.GENERATED);
		iMG.register(ModItems.BAKED_MUSHROOM, Models.GENERATED);
		iMG.register(ModItems.BAKED_RADISH, Models.GENERATED);
		iMG.register(ModItems.COOKED_BUGMEAT_STEAK, Models.GENERATED);
		iMG.register(ModItems.COOKED_MEAT_MORSEL, Models.GENERATED);
		//# Basic (raw) #
		iMG.register(ModItems.RAW_BUGMEAT_STEAK, Models.GENERATED);
		iMG.register(ModItems.RAW_MEAT_MORSEL, Models.GENERATED);
		//# Bread, Bun, Cake, & Cookie (cooked) #
		iMG.register(ModItems.HONEYBUN, Models.GENERATED);
		iMG.register(ModItems.MAGMABUN, Models.GENERATED);
		iMG.register(ModItems.SLIMEBUN, Models.GENERATED);
		//# Bread, Bun, Cake, & Cookie (raw) #
		iMG.register(ModItems.RAW_CAKE, Models.GENERATED);
		genItem(iMG, ModItems.RAW_COOKIE_BALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.RAW_DOUGH_LUMP, "lump", Models.GENERATED);
		genItem(iMG, ModItems.RAW_HONEYBUN_BALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.RAW_MAGMABUN_BALL, "ball", Models.GENERATED);
		genItem(iMG, ModItems.RAW_SLIMEBUN_BALL, "ball", Models.GENERATED);
		//# Pie (cooked) #
		genItem(iMG, ModItems.APPLE_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.CHERRY_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.GLOWBERRY_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.PUMPKIN_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.SWEETBERRY_PIE, "pie", Models.GENERATED);
		//# Pie (raw) #
		genItem(iMG, ModItems.RAW_APPLE_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.RAW_CHERRY_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.RAW_GLOWBERRY_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.RAW_PUMPKIN_PIE, "pie", Models.GENERATED);
		genItem(iMG, ModItems.RAW_SWEETBERRY_PIE, "pie", Models.GENERATED);
		//# Miscellaneous #
		iMG.register(ModItems.CHEESE_WHEEL, Models.GENERATED);
		iMG.register(ModItems.CHERRY_BUNCH, Models.GENERATED);
		iMG.register(ModItems.DRY_KELP_BUNDLE, Models.GENERATED);
		iMG.register(ModItems.FRIED_EGG, Models.GENERATED);
		//endregion
		
		
		//region  ## Joke & Unserious ##
		
		//## (J&U) Basic Resources ##
		//# Ball #
		genItem(iMG, JAUItems.CHERRY_JELLYBALL, "unserious", Models.GENERATED);
		//# Brick #
		//# Cobblestone #
		//# Gram & Ingot #
		genItem(iMG, JAUItems.NUTRILLARN_GRAM, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.NUTRILLARN_INGOT, "unserious", Models.GENERATED);
		//# Jewel #
		//# Log & Trunk #
		//# Lump & Nugget #
		genItem(iMG, JAUItems.RAW_NUTRILLARN_LUMP, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.RAW_NUTRILLARN_NUGGET, "unserious", Models.GENERATED);
		//# Pile (seed) #
		//# Pile (miscellaneous) #
		genItem(iMG, JAUItems.CANDESAND_PILE, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.MILKLEAF_PILE, "unserious", Models.GENERATED);
		//# Plank #
		//# Bundle & Rod & Stick #
		//# Shard #
		//# Wedge #
		genItem(iMG, JAUItems.BLUE_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.SILKY_SMOOTH_CHEESE_WEDGE, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.YELLOW_CHEESE_WEDGE, "unserious", Models.GENERATED);
		//# Miscellaneous #
		genItem(iMG, JAUItems.CHOCOLATE_BAR, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.CHULK_BERRY_BUNCH, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.ENCHANTED_BRICK, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.HONEYPOD, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.MINIWIZARD, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.STARCHCAP_MUSHROOM, "unserious", Models.GENERATED);
		
		//## (J&U) Containers ##
		//# Bottle #
		//# Bowl #
		genItem(iMG, JAUItems.BOWL_OF_OMNISTEW, "bowl", Models.GENERATED);
		genItem(iMG, JAUItems.BOWL_OF_STONE_SOUP, "bowl", Models.GENERATED);
		//# Bucket #
		
		//## (J&U) Equipment ##
		//# Nutrillarn (armor) #
		iMG.registerArmor((ArmorItem) JAUItems.NUTRILLARN_BOOT_PAIR);
		iMG.registerArmor((ArmorItem) JAUItems.NUTRILLARN_CHESTPLATE);
		iMG.registerArmor((ArmorItem) JAUItems.NUTRILLARN_HELMET);
		genItem(iMG, JAUItems.NUTRILLARN_HORSE_HARNESS, "equipment", Models.GENERATED);
		iMG.registerArmor((ArmorItem) JAUItems.NUTRILLARN_JELLYBOOT_PAIR); // TODO: Figure out how to override armor model texture.
		iMG.registerArmor((ArmorItem) JAUItems.NUTRILLARN_LEGGING_PAIR);
		//# Nutrillarn (tools) #
		genItem(iMG, JAUItems.NUTRILLARN_AXE, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_DAGGER, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_HATCHET, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_HOE, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_MALLET, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_PICKAXE, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_SHOVEL, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_SPEAR, "equipment", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_SWORD, "equipment", Models.HANDHELD);
		//# Miscellaneous #
		genItem(iMG, JAUItems.ENCHANTED_CHEESE_WHEEL, "unserious", Models.HANDHELD);
		genItem(iMG, JAUItems.NUTRILLARN_COMPASS, "unserious", Models.GENERATED);
		genItem(iMG, JAUItems.ORB_OF_ZOT, "unserious", Models.GENERATED);
		
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
	private static void genBlockStates(BlockStateModelGenerator blockStateModelGenerator, Block block, String path, Model model) {
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
//		model.upload(ModelIds.getBlockModelId(block), new TextureMap().put(TextureKey.LAYER0, identifier), blockStateModelGenerator.writer);
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
