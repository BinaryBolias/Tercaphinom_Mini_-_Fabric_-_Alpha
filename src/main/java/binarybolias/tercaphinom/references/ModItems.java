package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Rarity;

import java.util.ArrayList;
import java.util.Arrays;

import static binarybolias.tercaphinom.references.Reference.identifier;
import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * Registration for Tercaphinom items.
 * @see JAUItems
 * @see VMOItems
 * @see net.minecraft.item.Items
 */
public class ModItems {
	private static final int BOTTLE_STACK_LIMIT = 24;
	private static final int SIMPLE_FILLED_BOWL_STACK_LIMIT = 12;
	
	//region # Status effect cure lists #
	public static final ArrayList<RegistryEntry<StatusEffect>> honeyCureStatusEffectList = newStatusEffectList(
			StatusEffects.BLINDNESS,
			StatusEffects.HUNGER,
			StatusEffects.MINING_FATIGUE,
			StatusEffects.NAUSEA,
			StatusEffects.POISON,
			StatusEffects.WITHER);
	public static final ArrayList<RegistryEntry<StatusEffect>> milkCureStatusEffectList = newStatusEffectList(
			StatusEffects.ABSORPTION,
			StatusEffects.BLINDNESS,
			StatusEffects.FIRE_RESISTANCE,
			StatusEffects.GLOWING,
			StatusEffects.HUNGER,
			StatusEffects.INFESTED,
			StatusEffects.INVISIBILITY,
			StatusEffects.JUMP_BOOST,
			StatusEffects.LEVITATION,
			StatusEffects.MINING_FATIGUE,
			StatusEffects.NAUSEA,
			StatusEffects.NIGHT_VISION,
			StatusEffects.OOZING,
			StatusEffects.POISON,
			StatusEffects.REGENERATION,
			StatusEffects.RESISTANCE,
			StatusEffects.SLOW_FALLING,
			StatusEffects.SLOWNESS,
			StatusEffects.SPEED,
			StatusEffects.STRENGTH,
			StatusEffects.WATER_BREATHING,
			StatusEffects.WEAVING,
			StatusEffects.WIND_CHARGED,
			StatusEffects.WITHER);
	//endregion
	
	
	public ModItems() {
		// Disable instantiation.
		// Note: Couldn't this constructor simply be made private?
		throw new AssertionError();
	}
	
	
	/**
	 * Intended for use only once; ensures items (as static variables) are loaded through the referencing of this class.
	 */
	public static void bootstrap() {
		logMainEvent("Registering items");
	}
	
	
	public static Item register(String id, Item item) {
		return Registry.register(Registries.ITEM, identifier(id), item);
	}
	
	
	//### Items ###
	//region ## Basic Resources ##
	//# Ball (yarn) #
	public static final Item BLACK_YARNBALL = register("black_yarnball", newYarnballItem());
	public static final Item BLUE_YARNBALL = register("blue_yarnball", newYarnballItem());
	public static final Item BROWN_YARNBALL = register("brown_yarnball", newYarnballItem());
	public static final Item CYAN_YARNBALL = register("cyan_yarnball", newYarnballItem());
	public static final Item GRAY_YARNBALL = register("gray_yarnball", newYarnballItem());
	public static final Item GREEN_YARNBALL = register("green_yarnball", newYarnballItem());
	public static final Item LIGHT_BLUE_YARNBALL = register("light_blue_yarnball", newYarnballItem());
	public static final Item LIGHT_GRAY_YARNBALL = register("light_gray_yarnball", newYarnballItem());
	public static final Item LIME_YARNBALL = register("lime_yarnball", newYarnballItem());
	public static final Item MAGENTA_YARNBALL = register("magenta_yarnball", newYarnballItem());
	public static final Item ORANGE_YARNBALL = register("orange_yarnball", newYarnballItem());
	public static final Item PINK_YARNBALL = register("pink_yarnball", newYarnballItem());
	public static final Item PURPLE_YARNBALL = register("purple_yarnball", newYarnballItem());
	public static final Item RED_YARNBALL = register("red_yarnball", newYarnballItem());
	public static final Item WHITE_YARNBALL = register("white_yarnball", newYarnballItem());
	public static final Item YELLOW_YARNBALL = register("yellow_yarnball", newYarnballItem());
	//# Ball (miscellaneous) #
	public static final Item COBWEB_BALL = register("cobweb_ball", newItem(64)); // TODO: Add projectile.
	public static final Item MUDBALL = register("mudball", newEarthenPileItem(Blocks.MUD));
	//# Brick #
	public static final Item NETHERWART_BRICK = register("netherwart_brick", newSmallBrickItem(Blocks.RED_NETHER_BRICKS));
	public static final Item STIEFANE_BRICK = register("stiefane_brick", newLargeBrickItem(ModBlocks.STIEFANE_BRICK_BLOCK));
	//# Bundle & Rod & Stick #
	public static final Item DYNAMITE_BUNDLE = register("dynamite_bundle", newItem(64));
	public static final Item DYNAMITE_STICK = register("dynamite_stick", newItem(96));
	public static final Item FREEZE_ROD = register("freeze_rod", newItem(64));
	public static final Item WOODEN_STICK_BUNDLE = register("wooden_stick_bundle", newItem(64));
	//# Chunk (ice) #
	//# Chunk (miscellaneous) #
	//# Clod #
	public static final Item SOULSOIL_CLOD = register("soulsoil_clod", newEarthenPileItem(Blocks.SOUL_SAND));
	//# Cobblestone #
	public static final Item STIEFANE_COBBLESTONE = register("stiefane_cobblestone", newItem(cobblestoneSettings()));
	//# Gram & Ingot #
	public static final Item BRASS_GRAM = register("brass_gram", newMetalGramItem());
	public static final Item BRASS_INGOT = register("brass_ingot", newMetalIngotItem(ModBlocks.REFINED_BRASS_BLOCK));
	public static final Item COPPER_GRAM = register("copper_gram", newMetalGramItem());
	public static final Item EIDURIL_GRAM = register("eiduril_gram", newMetalGramItem());
	public static final Item EIDURIL_INGOT = register("eiduril_ingot", newMetalIngotItem(ModBlocks.REFINED_EIDURIL_BLOCK));
	public static final Item GOLD_GRAM = register("gold_gram", newMetalGramItem());
	public static final Item IRON_GRAM = register("iron_gram", newMetalGramItem());
	//# Jewel #
	//# Log (wooden log) #
	public static final Item VERDAK_LOG = register("verdak_log", newLogItem(ModBlocks.VERDAK_LOG));
	//# Log (wooden trunk) #
	//TODO: Rename "Verdak Trunk"; don't use "verdak" for tree species, only for timber type.
	// - Tree species which would have verdak timber:
	//  - Azalea
	//  - [swamp oak]
	//  - [another?]
	public static final Item VERDAK_TRUNK = register("verdak_trunk", newLogItem(ModBlocks.VERDAK_TRUNK));
	//# Log (miscellaneous) #
	//TODO: Add "Bone Log", which corresponds to vanilla Bone Block.
	//# Lump & Nugget (metal) #
	public static final Item CORRODED_VILBIARN_LUMP = register("corroded_vilbiarn_lump", newMetalLumpItem(ModBlocks.CORRODED_VILBIARN_BLOCK));
	public static final Item RAW_BRASS_LUMP = register("raw_brass_lump", newMetalLumpItem(ModBlocks.RAW_BRASS_BLOCK));
	public static final Item RAW_BRASS_NUGGET = register("raw_brass_nugget", newMetalNuggetItem());
	public static final Item RAW_COPPER_NUGGET = register("raw_copper_nugget", newMetalNuggetItem());
	public static final Item RAW_EIDURIL_LUMP = register("raw_eiduril_lump", newMetalLumpItem(ModBlocks.RAW_EIDURIL_BLOCK));
	public static final Item RAW_EIDURIL_NUGGET = register("raw_eiduril_nugget", newMetalNuggetItem());
	public static final Item REFINED_VILBIARN_LUMP = register("refined_vilbiarn_lump", newMetalLumpItem(ModBlocks.REFINED_VILBIARN_BLOCK));
	//# Lump & Nugget (miscellaneous) #
	public static final Item INFERNOCOAL_LUMP = register("infernocoal_lump", newFireproofItem(64));
	public static final Item SULPHUR_LUMP = register("sulphur_lump", newFireproofItem(64));
	//# Pane (glass - clear) #
	public static final Item CLEAR_GLASS_PANE = register("clear_glass_pane", newGlassPaneItem(Blocks.GLASS_PANE));
	//# Pane (glass - stained) #
	public static final Item BLACK_STAINED_GLASS_PANE = register("black_stained_glass_pane", newGlassPaneItem(Blocks.BLACK_STAINED_GLASS_PANE));
	public static final Item BLUE_STAINED_GLASS_PANE = register("blue_stained_glass_pane", newGlassPaneItem(Blocks.BLUE_STAINED_GLASS_PANE));
	public static final Item BROWN_STAINED_GLASS_PANE = register("brown_stained_glass_pane", newGlassPaneItem(Blocks.BROWN_STAINED_GLASS_PANE));
	public static final Item CYAN_STAINED_GLASS_PANE = register("cyan_stained_glass_pane", newGlassPaneItem(Blocks.CYAN_STAINED_GLASS_PANE));
	public static final Item GRAY_STAINED_GLASS_PANE = register("gray_stained_glass_pane", newGlassPaneItem(Blocks.GRAY_STAINED_GLASS_PANE));
	public static final Item GREEN_STAINED_GLASS_PANE = register("green_stained_glass_pane", newGlassPaneItem(Blocks.GREEN_STAINED_GLASS_PANE));
	public static final Item LIGHT_BLUE_STAINED_GLASS_PANE = register("light_blue_stained_glass_pane", newGlassPaneItem(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE));
	public static final Item LIGHT_GRAY_STAINED_GLASS_PANE = register("light_gray_stained_glass_pane", newGlassPaneItem(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE));
	public static final Item LIME_STAINED_GLASS_PANE = register("lime_stained_glass_pane", newGlassPaneItem(Blocks.LIME_STAINED_GLASS_PANE));
	public static final Item MAGENTA_STAINED_GLASS_PANE = register("magenta_stained_glass_pane", newGlassPaneItem(Blocks.MAGENTA_STAINED_GLASS_PANE));
	public static final Item ORANGE_STAINED_GLASS_PANE = register("orange_stained_glass_pane", newGlassPaneItem(Blocks.ORANGE_STAINED_GLASS_PANE));
	public static final Item PINK_STAINED_GLASS_PANE = register("pink_stained_glass_pane", newGlassPaneItem(Blocks.PINK_STAINED_GLASS_PANE));
	public static final Item PURPLE_STAINED_GLASS_PANE = register("purple_stained_glass_pane", newGlassPaneItem(Blocks.PURPLE_STAINED_GLASS_PANE));
	public static final Item RED_STAINED_GLASS_PANE = register("red_stained_glass_pane", newGlassPaneItem(Blocks.RED_STAINED_GLASS_PANE));
	public static final Item WHITE_STAINED_GLASS_PANE = register("white_stained_glass_pane", newGlassPaneItem(Blocks.WHITE_STAINED_GLASS_PANE));
	public static final Item YELLOW_STAINED_GLASS_PANE = register("yellow_stained_glass_pane", newGlassPaneItem(Blocks.YELLOW_STAINED_GLASS_PANE));
	//# Pane (metal) #
	//TODO: Wait for implementation of metal rods.
	//# Pane (miscellaneous) #
	//TODO: Wooden Pane.
	//# Pile (seed) #
	//# Pile (miscellaneous) #
	public static final Item ASH_PILE = register("ash_pile", new AshPileItem(itemSettings().maxCount(96).fireproof()));
	public static final Item DIRT_PILE = register("dirt_pile", newEarthenPileItem(Blocks.DIRT));
	public static final Item FELDSAND_PILE = register("feldsand_pile", newEarthenPileItem(Blocks.SAND));
	public static final Item FERROSAND_PILE = register("ferrosand_pile", newEarthenPileItem(Blocks.RED_SAND));
	public static final Item FREEZE_POWDER_PILE = register("freeze_powder_pile", newItem(96));
	public static final Item GRAVEL_PILE = register("gravel_pile", newEarthenPileItem(Blocks.GRAVEL));
	public static final Item LEAF_PILE = register("leaf_pile", newItem(96));
	public static final Item SKORSAND_PILE = register("skorsand_pile", newEarthenPileItem(ModBlocks.SKORSAND_BLOCK));
	public static final Item SNOW_PILE = register("snow_pile", new AliasedBlockItem(Blocks.SNOW, itemSettings(64)));
	public static final Item SOULSAND_PILE = register("soulsand_pile", newEarthenPileItem(Blocks.SOUL_SOIL));
	//# Plank #
	public static final Item ACACIA_PLANK = register("acacia_plank", newPlankItem(Blocks.ACACIA_PLANKS));
	public static final Item BIRCH_PLANK = register("birch_plank", newPlankItem(Blocks.BIRCH_PLANKS));
	public static final Item CHERRY_PLANK = register("cherry_plank", newPlankItem(Blocks.CHERRY_PLANKS)); // TODO: Perhaps rename to "ROZAL_PLANK".
	public static final Item CRIMSON_PLANK = register("crimson_plank", newPlankItem(Blocks.CRIMSON_PLANKS));
	public static final Item DARK_OAK_PLANK = register("dark_oak_plank", newPlankItem(Blocks.DARK_OAK_PLANKS));
	public static final Item MAHOGANY_PLANK = register("mahogany_plank", newPlankItem(Blocks.JUNGLE_PLANKS));
	public static final Item MANGROVE_PLANK = register("mangrove_plank", newPlankItem(Blocks.MANGROVE_PLANKS));
	public static final Item OAK_PLANK = register("oak_plank", newPlankItem(Blocks.OAK_PLANKS));
	public static final Item SPRUCE_PLANK = register("spruce_plank", newPlankItem(Blocks.SPRUCE_PLANKS));
	public static final Item VERDAK_PLANK = register("verdak_plank", newPlankItem(ModBlocks.VERDAK_PLANK_BLOCK));
	public static final Item WARPED_PLANK = register("warped_plank", newPlankItem(Blocks.WARPED_PLANKS));
	//# Roll #
	public static final Item BLACK_YARN_ROLL = register("black_yarn_roll", newYarnRollItem(Blocks.BLACK_CARPET));
	public static final Item BLUE_YARN_ROLL = register("blue_yarn_roll", newYarnRollItem(Blocks.BLUE_CARPET));
	public static final Item BROWN_YARN_ROLL = register("brown_yarn_roll", newYarnRollItem(Blocks.BROWN_CARPET));
	public static final Item CYAN_YARN_ROLL = register("cyan_yarn_roll", newYarnRollItem(Blocks.CYAN_CARPET));
	public static final Item GRAY_YARN_ROLL = register("gray_yarn_roll", newYarnRollItem(Blocks.GRAY_CARPET));
	public static final Item GREEN_YARN_ROLL = register("green_yarn_roll", newYarnRollItem(Blocks.GREEN_CARPET));
	public static final Item LIGHT_BLUE_YARN_ROLL = register("light_blue_yarn_roll", newYarnRollItem(Blocks.LIGHT_BLUE_CARPET));
	public static final Item LIGHT_GRAY_YARN_ROLL = register("light_gray_yarn_roll", newYarnRollItem(Blocks.LIGHT_GRAY_CARPET));
	public static final Item LIME_YARN_ROLL = register("lime_yarn_roll", newYarnRollItem(Blocks.LIME_CARPET));
	public static final Item MAGENTA_YARN_ROLL = register("magenta_yarn_roll", newYarnRollItem(Blocks.MAGENTA_CARPET));
	public static final Item ORANGE_YARN_ROLL = register("orange_yarn_roll", newYarnRollItem(Blocks.ORANGE_CARPET));
	public static final Item PINK_YARN_ROLL = register("pink_yarn_roll", newYarnRollItem(Blocks.PINK_CARPET));
	public static final Item PURPLE_YARN_ROLL = register("purple_yarn_roll", newYarnRollItem(Blocks.PURPLE_CARPET));
	public static final Item RED_YARN_ROLL = register("red_yarn_roll", newYarnRollItem(Blocks.RED_CARPET));
	public static final Item WHITE_YARN_ROLL = register("white_yarn_roll", newYarnRollItem(Blocks.WHITE_CARPET));
	public static final Item YELLOW_YARN_ROLL = register("yellow_yarn_roll", newYarnRollItem(Blocks.YELLOW_CARPET));
	//# Shard #
	public static final Item DARK_PRISMARINE_SHARD = register("dark_prismarine_shard", newEarthenPileItem(Blocks.DARK_PRISMARINE));
	public static final Item GLASS_SHARD = register("glass_shard", newEarthenPileItem(ModBlocks.GLASS_SHARD_BLOCK));
	public static final Item OBSIDIAN_SHARD = register("obsidian_shard", newEarthenPileItem(Blocks.OBSIDIAN));
	//# Miscellaneous #
	public static final Item DRY_GRASS_TUFT = register("dry_grass_tuft", newItem(itemSettings().maxCount(96)));
//	public static final Item DRY_MOSS_WAD = registerItem("dry_moss_wad", newItem(96)); // TODO: Enable later.
	public static final Item LIVE_GRASS_TUFT = register("live_grass_tuft", newItem(96,
			itemSettings().food(FoodComponents.LIVE_GRASS_TUFT)));
//	public static final Item LIVE_MOSS_WAD = registerItem("live_moss_wad", new AliasedBlockItem( // TODO: Enable later.
//			Blocks.MOSS_CARPET, itemSettings(96)));
	public static final Item PINECONE = register("pinecone",
			new IndirectBlockItem(Blocks.SPRUCE_SAPLING, itemSettings(64)));
	public static final Item SILK_WAD = register("silk_wad", newItem(96));
	public static final Item STONE_PEBBLE = register("stone_pebble", newFireproofItem(96));
	//endregion
	
	//region ## Containers ##
	//# Bottle (empty) #
	//# Bottle (filled) #
	public static final Item BOTTLE_OF_BRIMWATER = register("bottle_of_brimwater",
			newBottleBeverageItem(itemSettings().food(FoodComponents.BOTTLE_OF_BRIMWATER)));
	public static final Item BOTTLE_OF_FREEZEWATER = register("bottle_of_freezewater",
			newBottleBeverageItem(itemSettings().food(FoodComponents.BOTTLE_OF_FREEZEWATER)));
	public static final Item BOTTLE_OF_MILK = register("bottle_of_milk",
			newBottleStatusEffectCureBeverageItem(milkCureStatusEffectList, itemSettings()));
	public static final Item BOTTLE_OF_STEAMING_WATER = register("bottle_of_steaming_water",
			newBottleStatusEffectCureBeverageItem(
					newStatusEffectList(StatusEffects.SLOWNESS), // TODO: Cure a "Freezing" status effect (upon implementation).
					itemSettings().food(FoodComponents.BOTTLE_OF_STEAMING_WATER)));
	//# Bowl (empty) #
	//# Bowl (filled - soup) #
	public static final Item BOWL_OF_CARROT_SOUP = register("bowl_of_carrot_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_CARROT_SOUP)));
	public static final Item BOWL_OF_KELP_SOUP = register("bowl_of_kelp_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_KELP_SOUP)));
	public static final Item BOWL_OF_MUSHROOM_SOUP = register("bowl_of_mushroom_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MUSHROOM_SOUP)));
	public static final Item BOWL_OF_POISONOUS_POTATO_SOUP = register("bowl_of_poisonous_potato_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_POISONOUS_POTATO_SOUP)));
	public static final Item BOWL_OF_PORRIDGE = register("bowl_of_porridge",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PORRIDGE)));
	public static final Item BOWL_OF_POTATO_SOUP = register("bowl_of_potato_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_POTATO_SOUP)));
	public static final Item BOWL_OF_PUMPKIN_SOUP = register("bowl_of_pumpkin_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PUMPKIN_SOUP)));
	public static final Item BOWL_OF_RADISH_SOUP = register("bowl_of_radish_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_RADISH_SOUP)));
	//# Bowl (filled - stew) #
	public static final Item BOWL_OF_BEEF_STEW = register("bowl_of_beef_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_BEEF_STEW)));
	public static final Item BOWL_OF_BUGMEAT_STEW = register("bowl_of_bugmeat_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_BUGMEAT_STEW)));
	public static final Item BOWL_OF_CHICKEN_STEW = register("bowl_of_chicken_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_CHICKEN_STEW)));
	public static final Item BOWL_OF_COD_STEW = register("bowl_of_cod_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_COD_STEW)));
	public static final Item BOWL_OF_MORSEL_STEW = register("bowl_of_morsel_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MORSEL_STEW)));
	public static final Item BOWL_OF_MUTTON_STEW = register("bowl_of_mutton_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MUTTON_STEW)));
	public static final Item BOWL_OF_PORK_STEW = register("bowl_of_pork_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PORK_STEW)));
	public static final Item BOWL_OF_RABBIT_STEW = register("bowl_of_rabbit_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_RABBIT_STEW)));
	public static final Item BOWL_OF_SALMON_STEW = register("bowl_of_salmon_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_SALMON_STEW)));
	//# Bowl (filled - miscellaneous) #
	public static final Item BOWL_OF_BRIMWATER = register("bowl_of_brimwater",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_BRIMWATER)));
	public static final Item BOWL_OF_FREEZEWATER = register("bowl_of_freezewater",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_FREEZEWATER)));
	public static final Item BOWL_OF_HONEY = register("bowl_of_honey",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_HONEY)));
	public static final Item BOWL_OF_MILK = register("bowl_of_milk",
			newBowlStatusEffectCureBeverageItem(milkCureStatusEffectList, itemSettings()));
	public static final Item BOWL_OF_STEAMING_WATER = register("bowl_of_steaming_water",
			newBowlStatusEffectCureBeverageItem(
					newStatusEffectList(StatusEffects.SLOWNESS), // TODO: Cure a "Freezing" status effect (upon implementation).
					itemSettings().food(FoodComponents.BOWL_OF_STEAMING_WATER)));
	public static final Item BOWL_OF_WATER = register("bowl_of_water",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_WATER)));
	//# Bucket (empty) #
	//# Bucket (filled) #
	public static final Item BUCKET_OF_BRIMWATER = register("bucket_of_brimwater",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_BRIMWATER)));
	public static final Item BUCKET_OF_FERTILIZER = register("bucket_of_fertilizer",
			new BucketOfFertilizerItem(itemSettings().maxDamage(15).recipeRemainder(Items.BUCKET)));
	public static final Item BUCKET_OF_FREEZEWATER = register("bucket_of_freezewater",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_FREEZEWATER)));
	public static final Item BUCKET_OF_HONEY = register("bucket_of_honey",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_HONEY)));
	public static final Item BUCKET_OF_STEAMING_WATER = register("bucket_of_steaming_water",
			newBucketStatusEffectCureBeverageItem(
					newStatusEffectList(StatusEffects.SLOWNESS), // TODO: Cure a "Freezing" status effect (upon implementation).
					itemSettings().food(FoodComponents.BUCKET_OF_STEAMING_WATER)));
	//endregion
	
	//region  ## Equipment ##
	//# Arrow #
	// Equipment notes:
	//  - Tools have a base 4 attack speed.
	//   E.g, a -2.0F attach speed as a tool attribute modifier would reduce the tool's attack speed to half of default.
	//# [Tier 0] Wooden Stick #
	public static final Item SHARP_WOODEN_STICK = register("sharp_wooden_stick",
			newDaggerItem(ModToolMaterials.WOODEN_STICK, 2, -1.4F, itemSettings()));
	//# [Tier 1] Wood #
	public static final Item WOODEN_DAGGER = register("wooden_dagger",
			newDaggerItem(ModToolMaterials.WOOD, 2, -1.4F, itemSettings()));
	public static final Item WOODEN_MALLET = register("wooden_mallet",
			newMalletItem(ModToolMaterials.WOOD, 3, -3.0F, itemSettings()));
	public static final Item WOODEN_SHOVEL = register("wooden_shovel",
			newShovelItem(ModToolMaterials.WOOD, 2, -2.8F, itemSettings()));
	public static final Item WOODEN_SPEAR = register("wooden_spear",
			newSpearItem(ModToolMaterials.WOOD, 3, -2.3F, itemSettings()));
	public static final Item WOODEN_SWORD = register("wooden_sword",
			newSwordItem(ModToolMaterials.WOOD, 3, -2.2F, itemSettings()));
	//# [Tier 2] Flint #
	public static final Item FLINT_DAGGER = register("flint_dagger",
			newDaggerItem(ModToolMaterials.FLINT, 3, -1.5F, itemSettings()));
	public static final Item FLINT_HATCHET = register("flint_hatchet",
			newHatchetItem(ModToolMaterials.FLINT, 5, -2.1F, itemSettings()));
	public static final Item FLINT_HOE = register("flint_hoe",
			newHoeItem(ModToolMaterials.FLINT, 2, -2.6F, itemSettings()));
	public static final Item FLINT_SPEAR = register("flint_spear",
			newSpearItem(ModToolMaterials.FLINT, 5, -2.3F, itemSettings()));
	//# [Tier 2] Glass #
	public static final Item GLASS_DAGGER = register("glass_dagger",
			newDaggerItem(ModToolMaterials.GLASS, 3, -1.5F, itemSettings()));
	public static final Item GLASS_HATCHET = register("glass_hatchet",
			  newHatchetItem(ModToolMaterials.GLASS, 5, -2.1F, itemSettings()));
	public static final Item GLASS_HOE = register("glass_hoe",
			newHoeItem(ModToolMaterials.GLASS, 2, -2.6F, itemSettings()));
	public static final Item GLASS_SPEAR = register("glass_spear",
			newSpearItem(ModToolMaterials.GLASS, 5, -2.3F, itemSettings()));
	//# [Tier 2] Obsidian #
	public static final Item OBSIDIAN_DAGGER = register("obsidian_dagger",
			newDaggerItem(ModToolMaterials.OBSIDIAN, 3, -1.5F, itemSettings()));
	public static final Item OBSIDIAN_HATCHET = register("obsidian_hatchet",
			  newHatchetItem(ModToolMaterials.OBSIDIAN, 5, -2.1F, itemSettings()));
	public static final Item OBSIDIAN_HOE = register("obsidian_hoe",
			newHoeItem(ModToolMaterials.OBSIDIAN, 2, -2.6F, itemSettings()));
	public static final Item OBSIDIAN_SPEAR = register("obsidian_spear",
			newSpearItem(ModToolMaterials.OBSIDIAN, 5, -2.3F, itemSettings()));
	//# [Tier 3] Brass (armor) #
	public static final Item BRASS_BOOT_PAIR = register("brass_boot_pair",
			newBootPairItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_CHESTPLATE = register("brass_chestplate",
			newChestplateItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_HELMET = register("brass_helmet",
			newHelmetItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_HORSE_HARNESS = register("brass_horse_harness",
			newHorseArmorItem(ModArmorMaterials.BRASS, itemSettings().fireproof()));
	public static final Item BRASS_LEGGING_PAIR = register("brass_legging_pair",
			newLeggingPairItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	//# [Tier 3] Brass (tools) #
	public static final Item BRASS_AXE = register("brass_axe",
			newAxeItem(ModToolMaterials.BRASS, 6, -2.9F, itemSettings().fireproof()));
	public static final Item BRASS_DAGGER = register("brass_dagger",
			newDaggerItem(ModToolMaterials.BRASS, 3, -1.4F, itemSettings().fireproof()));
	public static final Item BRASS_HATCHET = register("brass_hatchet",
			newHatchetItem(ModToolMaterials.BRASS, 5, -2.1F, itemSettings().fireproof()));
	public static final Item BRASS_HOE = register("brass_hoe",
			newHoeItem(ModToolMaterials.BRASS, 2, -2.6F, itemSettings().fireproof()));
	public static final Item BRASS_MALLET = register("brass_mallet",
			newMalletItem(ModToolMaterials.BRASS, 3, -3.0F, itemSettings().fireproof()));
	public static final Item BRASS_PICKAXE = register("brass_pickaxe",
			newPickaxeItem(ModToolMaterials.BRASS, 3, -3.0F, itemSettings().fireproof()));
	public static final Item BRASS_SHOVEL = register("brass_shovel",
			newShovelItem(ModToolMaterials.BRASS, 2, -2.8F, itemSettings().fireproof()));
	public static final Item BRASS_SPEAR = register("brass_spear",
			newSpearItem(ModToolMaterials.BRASS, 5, -2.3F, itemSettings().fireproof()));
	public static final Item BRASS_SWORD = register("brass_sword",
			newSwordItem(ModToolMaterials.BRASS, 4, -2.2F, itemSettings().fireproof()));
	//# [Tier 3] Copper (armor) #
	public static final Item COPPER_BOOT_PAIR = register("copper_boot_pair",
			newBootPairItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_CHESTPLATE = register("copper_chestplate",
			newChestplateItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_HELMET = register("copper_helmet",
			newHelmetItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_HORSE_HARNESS = register("copper_horse_harness",
			newHorseArmorItem(ModArmorMaterials.COPPER, itemSettings().fireproof()));
	public static final Item COPPER_LEGGING_PAIR = register("copper_legging_pair",
			newLeggingPairItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	//# [Tier 3] Copper (tools) #
	public static final Item COPPER_AXE = register("copper_axe",
			newAxeItem(ModToolMaterials.COPPER, 6, -3.1F, itemSettings().fireproof()));
	public static final Item COPPER_DAGGER = register("copper_dagger",
			newDaggerItem(ModToolMaterials.COPPER, 3, -1.6F, itemSettings().fireproof()));
	public static final Item COPPER_HATCHET = register("copper_hatchet",
			newHatchetItem(ModToolMaterials.COPPER, 5, -2.3F, itemSettings().fireproof()));
	public static final Item COPPER_HOE = register("copper_hoe",
			newHoeItem(ModToolMaterials.COPPER, 2, -2.8F, itemSettings().fireproof()));
	public static final Item COPPER_MALLET = register("copper_mallet",
			newMalletItem(ModToolMaterials.COPPER, 3, -3.2F, itemSettings().fireproof()));
	public static final Item COPPER_PICKAXE = register("copper_pickaxe",
			newPickaxeItem(ModToolMaterials.COPPER, 3, -3.2F, itemSettings().fireproof()));
	public static final Item COPPER_SHOVEL = register("copper_shovel",
			newShovelItem(ModToolMaterials.COPPER, 2, -3.0F, itemSettings().fireproof()));
	public static final Item COPPER_SPEAR = register("copper_spear",
			newSpearItem(ModToolMaterials.COPPER, 5, -2.5F, itemSettings().fireproof()));
	public static final Item COPPER_SWORD = register("copper_sword",
			newSwordItem(ModToolMaterials.COPPER, 4, -2.4F, itemSettings().fireproof()));
	//# [Tier 3] Eiduril (armor) #
	public static final Item EIDURIL_BOOT_PAIR = register("eiduril_boot_pair",
			newBootPairItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_CHESTPLATE = register("eiduril_chestplate",
			newChestplateItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_HELMET = register("eiduril_helmet",
			newHelmetItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_HORSE_HARNESS = register("eiduril_horse_harness",
			newHorseArmorItem(ModArmorMaterials.EIDURIL, itemSettings().fireproof()));
	public static final Item EIDURIL_LEGGING_PAIR = register("eiduril_legging_pair",
			newSetBonusLeggingPairItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	//# [Tier 3] Eiduril (tools) #
	public static final Item EIDURIL_AXE = register("eiduril_axe",
			newAxeItem(ModToolMaterials.EIDURIL, 6, -3.0F, itemSettings().fireproof()));
	public static final Item EIDURIL_DAGGER = register("eiduril_dagger",
			newDaggerItem(ModToolMaterials.EIDURIL, 3, -1.5F, itemSettings().fireproof()));
	public static final Item EIDURIL_HATCHET = register("eiduril_hatchet",
			newHatchetItem(ModToolMaterials.EIDURIL, 5, -2.2F, itemSettings().fireproof()));
	public static final Item EIDURIL_HOE = register("eiduril_hoe",
			newHoeItem(ModToolMaterials.EIDURIL, 2, -2.7F, itemSettings().fireproof()));
	public static final Item EIDURIL_MALLET = register("eiduril_mallet",
			newMalletItem(ModToolMaterials.EIDURIL, 3, -3.1F, itemSettings().fireproof()));
	public static final Item EIDURIL_PICKAXE = register("eiduril_pickaxe",
			newPickaxeItem(ModToolMaterials.EIDURIL, 3, -3.1F, itemSettings().fireproof()));
	public static final Item EIDURIL_SHOVEL = register("eiduril_shovel",
			newShovelItem(ModToolMaterials.EIDURIL, 2, -2.9F, itemSettings().fireproof()));
	public static final Item EIDURIL_SPEAR = register("eiduril_spear",
			newSwordItem(ModToolMaterials.EIDURIL, 5, -2.4F, itemSettings().fireproof()));
	public static final Item EIDURIL_SWORD = register("eiduril_sword",
			newSwordItem(ModToolMaterials.EIDURIL, 4, -2.3F, itemSettings().fireproof()));
	//# [Tier 3] Gold (armor) #
	//# [Tier 3] Gold (tools) #
	public static final Item GOLDEN_DAGGER = register("golden_dagger",
			newDaggerItem(ToolMaterials.GOLD, 3, -1.6F, itemSettings().fireproof()));
	public static final Item GOLDEN_HATCHET = register("golden_hatchet",
			newHatchetItem(ToolMaterials.GOLD, 5, -2.3F, itemSettings().fireproof()));
	public static final Item GOLDEN_MALLET = register("golden_mallet",
			newMalletItem(ToolMaterials.GOLD, 3, -3.2F, itemSettings().fireproof()));
	public static final Item GOLDEN_SPEAR = register("golden_spear",
			newSwordItem(ToolMaterials.GOLD, 5, -2.5F, itemSettings().fireproof()));
	//# [Tier 3] Iron (armor) #
	//# [Tier 3] Iron (tools) #
	public static final Item IRON_DAGGER = register("iron_dagger",
			newDaggerItem(ToolMaterials.IRON, 3, -1.6F, itemSettings().fireproof()));
	public static final Item IRON_HATCHET = register("iron_hatchet",
			newHatchetItem(ToolMaterials.IRON, 5, -2.3F, itemSettings().fireproof()));
	public static final Item IRON_MALLET = register("iron_mallet",
			newMalletItem(ToolMaterials.IRON, 3, -3.2F, itemSettings().fireproof()));
	public static final Item IRON_SPEAR = register("iron_spear",
			newSwordItem(ToolMaterials.IRON, 5, -2.5F, itemSettings().fireproof()));
	//# Miscellaneous #
	public static final Item SPATIAL_RECALL_STONE = register("spatial_recall_stone",
			new SelfTeleporterItem(itemSettings().fireproof().rarity(Rarity.RARE).maxDamage(7)));
	public static final Item TARGET_TELEPORTATION_TUNER = register("target_teleportation_tuner",
			new TargetTeleporterItem(itemSettings().fireproof().rarity(Rarity.RARE).maxDamage(60)));
	//endregion
	
	
	//region ## Foods ##
	//Note:
	// - Not for all edible items; only intended items with special "food" classification.
	//  - E.g, raw and cooked buns and meats, but NOT Live Grass Tuft.
	// - Not for food item stored in containers; those are kept within the "Containers" category.
	//# Basic (cooked) #
	public static final Item BAKED_CARROT = register("baked_carrot", newItem(64,
			itemSettings().food(FoodComponents.BAKED_CARROT)));
	public static final Item BAKED_MUSHROOM = register("baked_mushroom", newItem(64,
			itemSettings().food(FoodComponents.BAKED_MUSHROOM)));
	public static final Item BAKED_RADISH = register("baked_radish", newItem(64,
			itemSettings().food(FoodComponents.BAKED_RADISH)));
	public static final Item COOKED_BUGMEAT_STEAK = register("cooked_bugmeat_steak", newItem(24,
			itemSettings().food(FoodComponents.COOKED_BUGMEAT_STEAK)));
	public static final Item COOKED_MEAT_MORSEL = register("cooked_meat_morsel", newItem(96,
			itemSettings().food(FoodComponents.COOKED_MEAT_MORSEL)));
	//# Basic (raw) #
	public static final Item RAW_BUGMEAT_STEAK = register("raw_bugmeat_steak", newItem(24,
			itemSettings().food(FoodComponents.RAW_BUGMEAT_STEAK)));
	public static final Item RAW_MEAT_MORSEL = register("raw_meat_morsel", newItem(96,
			itemSettings().food(FoodComponents.RAW_MEAT_MORSEL)));
	//# Bread, Bun, Cake, & Cookie (cooked) #
	public static final Item HONEYBUN = register("honeybun",
			new StatusEffectCureFoodItem(honeyCureStatusEffectList,
					itemSettings(64).food(FoodComponents.HONEYBUN)));
	public static final Item MAGMABUN = register("magmabun", newItem(64,
			itemSettings().food(FoodComponents.MAGMABUN)));
	public static final Item SLIMEBUN = register("slimebun", newItem(64,
			itemSettings().food(FoodComponents.SLIMEBUN)));
	//# Bread, Bun, Cake, & Cookie (raw) #
	public static final Item RAW_CAKE = register("raw_cake", newItem(1,
			itemSettings().food(FoodComponents.RAW_CAKE)));
	public static final Item RAW_COOKIE_BALL = register("raw_cookie_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_COOKIE_BALL)));
	public static final Item RAW_DOUGH_LUMP = register("raw_dough_lump", newItem(64,
			itemSettings().food(FoodComponents.RAW_DOUGH_LUMP)));
	public static final Item RAW_HONEYBUN_BALL = register("raw_honeybun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_HONEYBUN_BALL)));
	public static final Item RAW_MAGMABUN_BALL = register("raw_magmabun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_MAGMABUN_BALL)));
	public static final Item RAW_SLIMEBUN_BALL = register("raw_slimebun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_SLIMEBUN_BALL)));
	//# Pie (cooked) #
	public static final Item APPLE_PIE = register("apple_pie", newItem(16,
			itemSettings().food(FoodComponents.APPLE_PIE)));
	public static final Item CHERRY_PIE = register("cherry_pie", newItem(16,
			itemSettings().food(FoodComponents.CHERRY_PIE)));
	public static final Item GLOWBERRY_PIE = register("glowberry_pie", newItem(16,
			itemSettings().food(FoodComponents.GLOWBERRY_PIE)));
	public static final Item PUMPKIN_PIE = register("pumpkin_pie", newItem(16,
			itemSettings().food(FoodComponents.PUMPKIN_PIE)));
	public static final Item SWEETBERRY_PIE = register("sweetberry_pie", newItem(16,
			itemSettings().food(FoodComponents.SWEETBERRY_PIE)));
	//# Pie (raw) #
	public static final Item RAW_APPLE_PIE = register("raw_apple_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_APPLE_PIE)));
	public static final Item RAW_CHERRY_PIE = register("raw_cherry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_CHERRY_PIE)));
	public static final Item RAW_GLOWBERRY_PIE = register("raw_glowberry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_GLOWBERRY_PIE)));
	public static final Item RAW_PUMPKIN_PIE = register("raw_pumpkin_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_PUMPKIN_PIE)));
	public static final Item RAW_SWEETBERRY_PIE = register("raw_sweetberry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_SWEETBERRY_PIE)));
	//# Miscellaneous #
	public static final Item CHEESE_WHEEL = register("cheese_wheel", newItem(16,
			itemSettings().food(FoodComponents.CHEESE_WHEEL)));
	public static final Item CHERRY_BUNCH = register("cherry_bunch", newItem(96,
			itemSettings().food(FoodComponents.CHERRY_BUNCH)));
	public static final Item DRY_KELP_BUNDLE = register("dry_kelp_bundle", newItem(64,
			itemSettings().food(FoodComponents.DRY_KELP_BUNDLE)));
	public static final Item FRIED_EGG = register("fried_egg", newItem(16,
			itemSettings().food(FoodComponents.FRIED_EGG)));
	public static final Item WARPED_FLESH_CHUNK = register("warped_flesh_chunk",
			new WarpedFleshChunkItem(itemSettings(64).food(FoodComponents.WARPED_FLESH_CHUNK)));
	//endregion
	
	
	//TODO: Migrate all joke and unserious items to the JAUItems class.
	//region  ### Joke & Unserious Items ###
	
	//## (J&U) Basic Resources ##
	//# Ball #
//	@Deprecated
//	public static final Item CHERRY_JELLYBALL = register("cherry_jellyball",
//			new PlaceableBlockMaterialItem(JAUBlocks.CHERRY_JELLYBLOCK,
//					itemSettings(64).food(FoodComponents.CHERRY_JELLYBALL)));
	//# Brick #
//	@Deprecated
//	public static final Item ENCHANTED_BRICK = register("enchanted_brick",
//			new Item(smallBrickSettings().rarity(Rarity.UNCOMMON)
//					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	//# Chunk #
	//# Cobblestone #
	//# Gram & Ingot #
//	@Deprecated
//	public static final Item NUTRILLARN_GRAM = register("nutrillarn_gram",
//			newItem(metalGramSettings().food(FoodComponents.NUTRILLARN_GRAM)));
//	@Deprecated
//	public static final Item NUTRILLARN_INGOT = register("nutrillarn_ingot",
//			new PlaceableBlockMaterialItem(JAUBlocks.REFINED_NUTRILLARN_BLOCK,
//					metalIngotSettings().food(FoodComponents.NUTRILLARN_INGOT)));
	//# Jewel #
	//# Log & Trunk #
	//# Lump & Nugget #
//	@Deprecated
//	public static final Item RAW_NUTRILLARN_LUMP = register("raw_nutrillarn_lump",
//			new PlaceableBlockMaterialItem(JAUBlocks.RAW_NUTRILLARN_BLOCK,
//					metalLumpSettings().food(FoodComponents.RAW_NUTRILLARN_LUMP)));
//	@Deprecated
//	public static final Item RAW_NUTRILLARN_NUGGET = register("raw_nutrillarn_nugget",
//			newItem(metalNuggetSettings().food(FoodComponents.RAW_NUTRILLARN_NUGGET)));
	//# Pile (seed) #
	//# Pile (miscellaneous) #
//	@Deprecated
//	public static final Item MILKLEAF_PILE = register("milkleaf_pile",
//			newItem(itemSettings(96).food(FoodComponents.MILKLEAF_PILE)));
	//# Plank #
	//# Bundle & Rod & Stick #
	//# Shard #
	//# Miscellaneous (cheese) #
//	@Deprecated
//	public static final Item BLUE_CHEESE_WEDGE = register("blue_cheese_wedge",
//			new PlaceableBlockMaterialItem(JAUBlocks.BLUE_CHEESE_BLOCK,
//					itemSettings(64).food(FoodComponents.BLUE_CHEESE_WEDGE)));
//	@Deprecated
//	public static final Item SILKY_SMOOTH_CHEESE_WEDGE = register("silky_smooth_cheese_wedge",
//			new PlaceableBlockMaterialItem(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK,
//					itemSettings(64).food(FoodComponents.SILKY_SMOOTH_CHEESE_WEDGE)));
//	@Deprecated
//	public static final Item YELLOW_CHEESE_WEDGE = register("yellow_cheese_wedge",
//			new PlaceableBlockMaterialItem(JAUBlocks.YELLOW_CHEESE_BLOCK,
//					itemSettings(64).food(FoodComponents.YELLOW_CHEESE_WEDGE)));
	//# Miscellaneous (miscellaneous) #
//	@Deprecated
//	public static final Item CHOCOLATE_BAR = register("chocolate_bar",
//			newItem(64, itemSettings().food(FoodComponents.CHOCOLATE_BAR)));
//	@Deprecated
//	public static final Item CHULK_BERRY_BUNCH = register("chulk_berry_bunch",
//			newItem(64, itemSettings().food(FoodComponents.CHULK_BERRY_BUNCH)));
//	@Deprecated
//	public static final Item HONEYPOD = register("honeypod",
//			newItem(64, itemSettings().food(FoodComponents.HONEYPOD)));
//	@Deprecated
//	public static final Item MINIWIZARD = register("miniwizard",
//			new Item(fireproofItemSettings(16).rarity(Rarity.RARE)
//					.food(FoodComponents.MINIWIZARD)));
//	@Deprecated
//	public static final Item STARCHCAP_MUSHROOM = register("starchcap_mushroom",
//			new AliasedBlockItem(JAUBlocks.STARCHCAP_MUSHROOM, itemSettings().maxCount(64).food(FoodComponents.STARCHCAP_MUSHROOM)));
	
	//## (J&U) Containers ##
	//# Bottle #
	//# Bowl #
//	@Deprecated
//	public static final Item BOWL_OF_OMNISTEW = register("bowl_of_omnistew",
//			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_OMNISTEW)));
//	@Deprecated
//	public static final Item BOWL_OF_STONE_SOUP = register("bowl_of_stone_soup",
//			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_STONE_SOUP)));
	//# Bucket #
	
	//## (J&U) Equipment ##
	//# Nutrillarn (armor) #
//	@Deprecated
//	public static final Item NUTRILLARN_BOOT_PAIR = register("nutrillarn_boot_pair",
//			newBootPairItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_CHESTPLATE = register("nutrillarn_chestplate",
//			newChestplateItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_HELMET = register("nutrillarn_helmet",
//			newHelmetItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_HORSE_HARNESS = register("nutrillarn_horse_harness",
//			newHorseArmorItem(ModArmorMaterials.NUTRILLARN, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_JELLYBOOT_PAIR = register("nutrillarn_jellyboot_pair",
//			new StatusEffectArmorItem(ModArmorMaterials.NUTRILLARN, ArmorItem.Type.BOOTS,
//					StatusEffects.JUMP_BOOST, 1,
//					itemSettings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(3)).fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_LEGGING_PAIR = register("nutrillarn_legging_pair",
//			newSetBonusLeggingPairItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
	//# Nutrillarn (tools) #
//	@Deprecated
//	public static final Item NUTRILLARN_AXE = register("nutrillarn_axe",
//			newAxeItem(ModToolMaterials.NUTRILLARN, 6, -2.9F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_DAGGER = register("nutrillarn_dagger",
//			newDaggerItem(ModToolMaterials.NUTRILLARN, 3, -1.4F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_HATCHET = register("nutrillarn_hatchet",
//			newHatchetItem(ModToolMaterials.NUTRILLARN, 5, -2.1F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_HOE = register("nutrillarn_hoe",
//			newHoeItem(ModToolMaterials.NUTRILLARN, 2, -2.6F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_MALLET = register("nutrillarn_mallet",
//			new NutrillarnMalletItem(ModToolMaterials.NUTRILLARN, itemSettings().attributeModifiers(
//					NutrillarnMalletItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 3, -3.0F)
//			).fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_PICKAXE = register("nutrillarn_pickaxe",
//			newPickaxeItem(ModToolMaterials.NUTRILLARN, 3, -3.0F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_SHOVEL = register("nutrillarn_shovel",
//			newShovelItem(ModToolMaterials.NUTRILLARN, 2, -2.8F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_SPEAR = register("nutrillarn_spear",
//			newSpearItem(ModToolMaterials.NUTRILLARN, 5, -2.3F, itemSettings().fireproof()));
//	@Deprecated
//	public static final Item NUTRILLARN_SWORD = register("nutrillarn_sword",
//			new NutrillarnSwordItem(ModToolMaterials.NUTRILLARN, itemSettings().attributeModifiers(
//					NutrillarnSwordItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 4, -2.2F)
//			).fireproof()));
	//# Miscellaneous #
//	@Deprecated
//	public static final Item ENCHANTED_CHEESE_WHEEL = register("enchanted_cheese_wheel",
//			new EnchantedCheeseWheelItem(itemSettings()
//					.maxDamage(72).fireproof().rarity(Rarity.UNCOMMON)
//					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
//	@Deprecated
//	public static final Item NUTRILLARN_COMPASS = register("nutrillarn_compass",
//			new NutrillarnCompassItem(itemSettings(64).fireproof().food(FoodComponents.NUTRILLARN_COMPASS)));
//	@Deprecated
//	public static final Item ORB_OF_ZOT = register("orb_of_zot",
//			new OrbOfZotItem(itemSettings()
//					.maxCount(1).fireproof().rarity(Rarity.EPIC)
//					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	//endregion
	
	
	//region ### New Item Methods ###
	//region ## Basic Items ##
	//# Generic #
	public static Item newItem(int maxCount) {
		return newItem(itemSettings().maxCount(maxCount));
	}
	
	public static Item newItem(int maxCount, Rarity rarity) {
		return newItem(itemSettings().maxCount(maxCount).rarity(rarity));
	}
	
	public static Item newItem(int maxCount, Item.Settings settings) {
		return newItem(settings.maxCount(maxCount));
	}
	
	public static Item newItem(Item.Settings settings) {
		return new Item(settings);
	}
	//endregion
	
	//region ## Container Items ##
	//# Bottle #
	private static Item newBottleBeverageItem(Item.Settings settings) {
		return new BottleBeverageItem(bottleSettings());
	}
	
	
	private static Item newBottleStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BottleStatusEffectCureBeverageItem(curedStatusEffects, bottleSettings(settings));
	}
	
	//# Bowl #
	private static Item newBowlBeverageItem(Item.Settings settings) {
		return new BowlBeverageItem(settings.maxCount(SIMPLE_FILLED_BOWL_STACK_LIMIT).recipeRemainder(Items.BOWL));
	}
	
	
	public static Item newBowlFoodItem(Item.Settings settings) {
		return new BowlFoodItem(settings.maxCount(1).recipeRemainder(Items.BOWL));
	}
	
	
	private static Item newBowlStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BowlStatusEffectCureBeverageItem(curedStatusEffects,
				settings.maxCount(SIMPLE_FILLED_BOWL_STACK_LIMIT).recipeRemainder(Items.BOWL));
	}
	
	//# Bucket #
	private static Item newBucketBeverageItem(Item.Settings settings) {
		return new BucketBeverageItem(settings.maxCount(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	private static Item newBucketFoodItem(Item.Settings settings) {
		return new BucketFoodItem(settings.maxCount(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	public static Item newBucketStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BucketStatusEffectCureBeverageItem(curedStatusEffects,
				settings.maxCount(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	public static Item newFilledBucketItem() {
		return newItem(itemSettings(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	public static Item newFilledBucketItem(FlowableFluid fluid) {
		return new BucketItem(fluid, itemSettings(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	//endregion
	
	//region ## Equipment Items ##
	//# Armor (generic) #
	@Deprecated
	private static Item newMetalArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, ArmorItem.Type armorType,
			int maxDamageMultiplier, Item.Settings settings
	) {
		return new ArmorItem(armorMaterial, armorType,
				settings.maxDamage(armorType.getMaxDamage(maxDamageMultiplier)).fireproof()
		);
	}
	
	
	private static Item newHumanoidArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, ArmorItem.Type armorType,
			int maxDamageMultiplier, Item.Settings settings
	) {
		return new ArmorItem(armorMaterial, armorType,
				settings.maxDamage(armorType.getMaxDamage(maxDamageMultiplier)).fireproof()
		);
	}
	
	
	private static Item newHumanoidSetBonusArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, ArmorItem.Type armorType,
			int maxDamageMultiplier, Item.Settings settings
	) {
		return new SetBonusArmorItem(armorMaterial, armorType,
				settings.maxDamage(armorType.getMaxDamage(maxDamageMultiplier)).fireproof()
		);
	}
	
	//# Armor (specific) #
	public static Item newBootPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.BOOTS, maxDamageMultiplier, settings);
	}
	
	
	public static Item newChestplateItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, maxDamageMultiplier, settings);
	}
	
	
	public static Item newHelmetItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.HELMET, maxDamageMultiplier, settings);
	}
	
	
	public static Item newHorseArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, Item.Settings settings
	) {
		return new AnimalArmorItem(armorMaterial, AnimalArmorItem.Type.EQUESTRIAN, false, settings.maxCount(1));
	}
	
	
	public static Item newLeggingPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, maxDamageMultiplier, settings);
	}
	
	
	public static Item newSetBonusLeggingPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidSetBonusArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, maxDamageMultiplier, settings);
	}
	
	// # Tools #
	public static Item newAxeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new AxeItem(material, settings.attributeModifiers(
				AxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newDaggerItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'DaggerIem' class instead of 'SwordItem'.
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newHatchetItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'HatchetIem' class instead of 'AxeItem'.
		return new AxeItem(material, settings.attributeModifiers(
				AxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newHoeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new HoeItem(material, settings.attributeModifiers(
				HoeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newMalletItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'MalletIem' class instead of 'PickaxeItem'.
		return new PickaxeItem(material, settings.attributeModifiers(
				PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newPickaxeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new PickaxeItem(material, settings.attributeModifiers(
				PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newShovelItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new ShovelItem(material, settings.attributeModifiers(
				ShovelItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newSpearItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'SpearIem' class instead of 'SwordItem'.
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	
	public static Item newSwordItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	//endregion
	
	//region ## Miscellaneous Items ##
	public static Item newFireproofItem(int maxCount) {
		return newItem(fireproofItemSettings(maxCount));
	}
	
	
	public static Item newEarthenPileItem(Block block) {
		return new PlaceableBlockMaterialItem(block, earthenPileSettings());
	}
	
	
	private static Item newGlassPaneItem(Block block) {
		return new AliasedBlockItem(block, fireproofItemSettings(64));
	}
	
	
	private static Item newLargeBrickItem(Block block) {
		return new LargeBrickItem(block, largeBrickSettings());
	}
	
	
	private static Item newLogItem(Block block) {
		return new BlockItem(block, logSettings());
	}
	
	
	private static Item newMetalGramItem() {
		return newItem(metalGramSettings());
	}
	
	
	public static Item newMetalIngotItem(Block block) {
		return new PlaceableBlockMaterialItem(block, metalIngotSettings());
	}
	
	
	public static Item newMetalLumpItem(Block block) {
		return new PlaceableBlockMaterialItem(block, metalLumpSettings());
	}
	
	
	public static Item newMetalNuggetItem() {
		return newItem(metalNuggetSettings());
	}
	
	
	private static Item newPlankItem(Block block) {
		return new PlaceableBlockMaterialItem(block, plankSettings());
	}
	
	
	public static Item newSmallBrickItem(Block block) {
		return new PlaceableBlockMaterialItem(block, smallBrickSettings());
	}
	
	
	private static Item newYarnballItem() {
		return newItem(yarnballSettings());
	}
	
	
	private static Item newYarnRollItem(Block block) {
		return new AliasedBlockItem(block, yarnRollSettings());
	}
	//endregion
	
	
	//region ### Item Settings Methods ###
	//region ## Basic Item Settings ##
	public static Item.Settings itemSettings() {
		return new Item.Settings();
	}
	
	
	public static Item.Settings itemSettings(int maxCount) {
		return itemSettings().maxCount(maxCount);
	}
	
	
	public static Item.Settings fireproofItemSettings() {
		return itemSettings().fireproof();
	}
	
	
	public static Item.Settings fireproofItemSettings(int maxCount) {
		return fireproofItemSettings().maxCount(maxCount);
	}
	//endregion
	
	//region ## Component-Adding Item Settings ##
	public static Item.Settings containerComponentItemSettings(int maxCount) {
		return itemSettings(maxCount).component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT);
	}
	//endregion
	
	//region ## Container Item Settings ##
	//# Bottle #
	public static Item.Settings bottleSettings() {
		return bottleSettings(itemSettings());
	}
	
	public static Item.Settings bottleSettings(Item.Settings settings) {
		return fireproofItemSettings(BOTTLE_STACK_LIMIT).recipeRemainder(Items.GLASS_BOTTLE);
	}
	
	
	public static Item.Settings emptyBottleSettings() {
		return fireproofItemSettings(BOTTLE_STACK_LIMIT);
	}
	
	//# Bowl #
	//# Bucket #
	public static Item.Settings entityBucketSettings() {
		return fireproofItemSettings(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT);
	}
	//endregion
	
	//region ## Equipment Item Settings ##
	public static Item.Settings metalEquipmentSettings() {
		return itemSettings().fireproof();
	}
	//endregion
	
	//region ## Miscellaneous Item Settings ##
	public static Item.Settings earthenPileSettings() {
		return fireproofItemSettings(64);
	}
	
	
	public static Item.Settings cobblestoneSettings() {
		return fireproofItemSettings(64);
	}
	
	
	public static Item.Settings filledBucketSettings() {
		return fireproofItemSettings(1).recipeRemainder(Items.BUCKET);
	}
	
	
	public static Item.Settings largeBrickSettings() {
		return fireproofItemSettings(32);
	}
	
	
	public static Item.Settings logSettings() {
		return fireproofItemSettings(12);
	}
	
	
	public static Item.Settings metalGramSettings() {
		return fireproofItemSettings(96);
	}
	
	
	public static Item.Settings metalIngotSettings() {
		return fireproofItemSettings(64);
	}
	
	
	public static Item.Settings metalLumpSettings() {
		return fireproofItemSettings(64);
	}
	
	
	public static Item.Settings metalNuggetSettings() {
		return fireproofItemSettings(96);
	}
	
	
	public static Item.Settings plankSettings() {
		return itemSettings(64);
	}
	
	
	public static Item.Settings smallBrickSettings() {
		return fireproofItemSettings(64);
	}
	
	
	public static Item.Settings yarnballSettings() {
		return itemSettings(96);
	}
	
	
	public static Item.Settings yarnRollSettings() {
		return itemSettings(64);
	}
	//endregion
	//endregion
	
	
	@SafeVarargs
	private static ArrayList<RegistryEntry<StatusEffect>> newStatusEffectList(RegistryEntry<StatusEffect>... effects) {
		return new ArrayList<>(Arrays.asList(effects));
	}
}
