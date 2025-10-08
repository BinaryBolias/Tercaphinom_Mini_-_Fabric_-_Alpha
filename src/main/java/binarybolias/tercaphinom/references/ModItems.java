package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
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
 * Relevant references:
 * {@link net.minecraft.item.Items}
 */
public class ModItems {
	private static final ArrayList<RegistryEntry<StatusEffect>> honeyCureStatusEffectList = newStatusEffectList(
			StatusEffects.BLINDNESS,
			StatusEffects.HUNGER,
			StatusEffects.MINING_FATIGUE,
			StatusEffects.NAUSEA,
			StatusEffects.POISON,
			StatusEffects.WITHER);
	private static final ArrayList<RegistryEntry<StatusEffect>> milkCureStatusEffectList = newStatusEffectList(
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
	
	
	public ModItems() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static void register() {
		logMainEvent("Registering items");
	}
	
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, identifier(name), item);
	}
	
	
	//### Items ###
	//region ## Basic Resources ##
	//# Ball (yarn) #
	public static final Item BLACK_YARNBALL = registerItem("black_yarnball", newItem(96));
	public static final Item BLUE_YARNBALL = registerItem("blue_yarnball", newItem(96));
	public static final Item BROWN_YARNBALL = registerItem("brown_yarnball", newItem(96));
	public static final Item CYAN_YARNBALL = registerItem("cyan_yarnball", newItem(96));
	public static final Item GRAY_YARNBALL = registerItem("gray_yarnball", newItem(96));
	public static final Item GREEN_YARNBALL = registerItem("green_yarnball", newItem(96));
	public static final Item LIGHT_BLUE_YARNBALL = registerItem("light_blue_yarnball", newItem(96));
	public static final Item LIGHT_GRAY_YARNBALL = registerItem("light_gray_yarnball", newItem(96));
	public static final Item LIME_YARNBALL = registerItem("lime_yarnball", newItem(96));
	public static final Item MAGENTA_YARNBALL = registerItem("magenta_yarnball", newItem(96));
	public static final Item ORANGE_YARNBALL = registerItem("orange_yarnball", newItem(96));
	public static final Item PINK_YARNBALL = registerItem("pink_yarnball", newItem(96));
	public static final Item PURPLE_YARNBALL = registerItem("purple_yarnball", newItem(96));
	public static final Item RED_YARNBALL = registerItem("red_yarnball", newItem(96));
	public static final Item WHITE_YARNBALL = registerItem("white_yarnball", newItem(96));
	public static final Item YELLOW_YARNBALL = registerItem("yellow_yarnball", newItem(96));
	//# Ball (miscellaneous) #
	public static final Item COBWEB_BALL = registerItem("cobweb_ball", newItem(64)); // TODO: Add projectile.
	public static final Item MUDBALL = registerItem("mudball", newItem(96));
	//# Brick #
	public static final Item NETHERWART_BRICK = registerItem("netherwart_brick", newItem(smallBrickSettings()));
	public static final Item STIEFANE_BRICK = registerItem("stiefane_brick", newItem(largeBrickSettings()));
	//# Bundle & Rod & Stick #
	public static final Item DYNAMITE_BUNDLE = registerItem("dynamite_bundle", newItem(64));
	public static final Item DYNAMITE_STICK = registerItem("dynamite_stick", newItem(96));
	public static final Item FREEZE_ROD = registerItem("freeze_rod", newItem(64));
	public static final Item WOODEN_STICK_BUNDLE = registerItem("wooden_stick_bundle", newItem(64));
	//# Chunk (ice) #
	//# Chunk (miscellaneous) #
	public static final Item WARPED_FLESH_CHUNK = registerItem("warped_flesh_chunk",
			new WarpedFleshChunkItem(itemSettings(64).food(FoodComponents.WARPED_FLESH_CHUNK)));
	//# Cobblestone #
	public static final Item STIEFANE_COBBLESTONE = registerItem("stiefane_cobblestone", newItem(cobblestoneSettings()));
	//# Gram & Ingot #
	public static final Item BRASS_GRAM = registerItem("brass_gram", newFireproofItem(96));
	public static final Item BRASS_INGOT = registerItem("brass_ingot", newFireproofItem(64));
	public static final Item COPPER_GRAM = registerItem("copper_gram", newFireproofItem(96));
	public static final Item EIDURIL_GRAM = registerItem("eiduril_gram", newFireproofItem(96));
	public static final Item EIDURIL_INGOT = registerItem("eiduril_ingot", newFireproofItem(64));
	public static final Item GOLD_GRAM = registerItem("gold_gram", newFireproofItem(96));
	public static final Item IRON_GRAM = registerItem("iron_gram", newFireproofItem(96));
	//# Jewel #
	//# Log (wooden log) #
	public static final Item VERDAK_LOG = registerItem("verdak_log", new BlockItem(ModBlocks.VERDAK_LOG,
			new Item.Settings().maxCount(12)));
	//# Log (wooden trunk) #
	public static final Item VERDAK_TRUNK = registerItem("verdak_trunk", new BlockItem(ModBlocks.VERDAK_TRUNK, // TODO: Rename; don't use "verdak" for tree species, only for timber type.
			new Item.Settings().maxCount(12)));
	//# Log (miscellaneous) #
	//TODO: Add "Bone Log", which corresponds to vanilla Bone Block.
	//# Lump & Nugget (metal) #
	public static final Item RAW_BRASS_LUMP = registerItem("raw_brass_lump", newFireproofItem(64));
	public static final Item RAW_BRASS_NUGGET = registerItem("raw_brass_nugget", newFireproofItem(96));
	public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", newFireproofItem(96));
	public static final Item RAW_EIDURIL_LUMP = registerItem("raw_eiduril_lump", newFireproofItem(64));
	public static final Item RAW_EIDURIL_NUGGET = registerItem("raw_eiduril_nugget", newFireproofItem(96));
	//# Lump & Nugget (miscellaneous) #
	public static final Item INFERNOCOAL_LUMP = registerItem("infernocoal_lump", newFireproofItem(64));
	public static final Item SULPHUR_LUMP = registerItem("sulphur_lump", newFireproofItem(64));
	//# Pane (glass - clear) #
	public static final Item CLEAR_GLASS_PANE = registerItem("clear_glass_pane", newGlassPaneItem(Blocks.GLASS_PANE));
	//# Pane (glass - stained) #
	public static final Item BLACK_STAINED_GLASS_PANE = registerItem("black_stained_glass_pane", newGlassPaneItem(Blocks.BLACK_STAINED_GLASS_PANE));
	public static final Item BLUE_STAINED_GLASS_PANE = registerItem("blue_stained_glass_pane", newGlassPaneItem(Blocks.BLUE_STAINED_GLASS_PANE));
	public static final Item BROWN_STAINED_GLASS_PANE = registerItem("brown_stained_glass_pane", newGlassPaneItem(Blocks.BROWN_STAINED_GLASS_PANE));
	public static final Item CYAN_STAINED_GLASS_PANE = registerItem("cyan_stained_glass_pane", newGlassPaneItem(Blocks.CYAN_STAINED_GLASS_PANE));
	public static final Item GRAY_STAINED_GLASS_PANE = registerItem("gray_stained_glass_pane", newGlassPaneItem(Blocks.GRAY_STAINED_GLASS_PANE));
	public static final Item GREEN_STAINED_GLASS_PANE = registerItem("green_stained_glass_pane", newGlassPaneItem(Blocks.GREEN_STAINED_GLASS_PANE));
	public static final Item LIGHT_BLUE_STAINED_GLASS_PANE = registerItem("light_blue_stained_glass_pane", newGlassPaneItem(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE));
	public static final Item LIGHT_GRAY_STAINED_GLASS_PANE = registerItem("light_gray_stained_glass_pane", newGlassPaneItem(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE));
	public static final Item LIME_STAINED_GLASS_PANE = registerItem("lime_stained_glass_pane", newGlassPaneItem(Blocks.LIME_STAINED_GLASS_PANE));
	public static final Item MAGENTA_STAINED_GLASS_PANE = registerItem("magenta_stained_glass_pane", newGlassPaneItem(Blocks.MAGENTA_STAINED_GLASS_PANE));
	public static final Item ORANGE_STAINED_GLASS_PANE = registerItem("orange_stained_glass_pane", newGlassPaneItem(Blocks.ORANGE_STAINED_GLASS_PANE));
	public static final Item PINK_STAINED_GLASS_PANE = registerItem("pink_stained_glass_pane", newGlassPaneItem(Blocks.PINK_STAINED_GLASS_PANE));
	public static final Item PURPLE_STAINED_GLASS_PANE = registerItem("purple_stained_glass_pane", newGlassPaneItem(Blocks.PURPLE_STAINED_GLASS_PANE));
	public static final Item RED_STAINED_GLASS_PANE = registerItem("red_stained_glass_pane", newGlassPaneItem(Blocks.RED_STAINED_GLASS_PANE));
	public static final Item WHITE_STAINED_GLASS_PANE = registerItem("white_stained_glass_pane", newGlassPaneItem(Blocks.WHITE_STAINED_GLASS_PANE));
	public static final Item YELLOW_STAINED_GLASS_PANE = registerItem("yellow_stained_glass_pane", newGlassPaneItem(Blocks.YELLOW_STAINED_GLASS_PANE));
	//# Pane (metal) #
	//TODO: Wait for implementation of metal rods.
	//# Pane (miscellaneous) #
	//TODO: Wooden Pane.
	//# Pile (seed) #
	//# Pile (miscellaneous) #
	public static final Item ASH_PILE = registerItem("ash_pile", new AshPileItem(itemSettings().maxCount(96).fireproof()));
	public static final Item DIRT_PILE = registerItem("dirt_pile", newFireproofItem(64));
	public static final Item FELDSAND_PILE = registerItem("feldsand_pile", newFireproofItem(64));
	public static final Item FERROSAND_PILE = registerItem("ferrosand_pile", newFireproofItem(64));
	public static final Item FREEZE_POWDER_PILE = registerItem("freeze_powder_pile", newItem(96));
	public static final Item GRAVEL_PILE = registerItem("gravel_pile", newFireproofItem(64));
	public static final Item LEAF_PILE = registerItem("leaf_pile", newItem(96));
	public static final Item SKORSAND_PILE = registerItem("skorsand_pile", newFireproofItem(64));
	public static final Item SNOW_PILE = registerItem("snow_pile", new AliasedBlockItem(Blocks.SNOW, itemSettings(64)));
	//# Plank #
	public static final Item ACACIA_PLANK = registerItem("acacia_plank", newItem(plankSettings()));
	public static final Item BIRCH_PLANK = registerItem("birch_plank", newItem(plankSettings()));
	public static final Item CHERRY_PLANK = registerItem("cherry_plank", newItem(plankSettings())); // TODO: Perhaps rename to "ROZAL_PLANK".
	public static final Item CRIMSON_PLANK = registerItem("crimson_plank", newItem(plankSettings()));
	public static final Item DARK_OAK_PLANK = registerItem("dark_oak_plank", newItem(plankSettings()));
	public static final Item MAHOGANY_PLANK = registerItem("mahogany_plank", newItem(plankSettings()));
	public static final Item MANGROVE_PLANK = registerItem("mangrove_plank", newItem(plankSettings()));
	public static final Item OAK_PLANK = registerItem("oak_plank", newItem(plankSettings()));
	public static final Item SPRUCE_PLANK = registerItem("spruce_plank", newItem(plankSettings()));
	public static final Item VERDAK_PLANK = registerItem("verdak_plank", newItem(plankSettings()));
	public static final Item WARPED_PLANK = registerItem("warped_plank", newItem(plankSettings()));
	//# Roll #
	public static final Item BLACK_YARN_ROLL = registerItem("black_yarn_roll", newYarnRollItem(Blocks.BLACK_CARPET));
	public static final Item BLUE_YARN_ROLL = registerItem("blue_yarn_roll", newYarnRollItem(Blocks.BLUE_CARPET));
	public static final Item BROWN_YARN_ROLL = registerItem("brown_yarn_roll", newYarnRollItem(Blocks.BROWN_CARPET));
	public static final Item CYAN_YARN_ROLL = registerItem("cyan_yarn_roll", newYarnRollItem(Blocks.CYAN_CARPET));
	public static final Item GRAY_YARN_ROLL = registerItem("gray_yarn_roll", newYarnRollItem(Blocks.GRAY_CARPET));
	public static final Item GREEN_YARN_ROLL = registerItem("green_yarn_roll", newYarnRollItem(Blocks.GREEN_CARPET));
	public static final Item LIGHT_BLUE_YARN_ROLL = registerItem("light_blue_yarn_roll", newYarnRollItem(Blocks.LIGHT_BLUE_CARPET));
	public static final Item LIGHT_GRAY_YARN_ROLL = registerItem("light_gray_yarn_roll", newYarnRollItem(Blocks.LIGHT_GRAY_CARPET));
	public static final Item LIME_YARN_ROLL = registerItem("lime_yarn_roll", newYarnRollItem(Blocks.LIME_CARPET));
	public static final Item MAGENTA_YARN_ROLL = registerItem("magenta_yarn_roll", newYarnRollItem(Blocks.MAGENTA_CARPET));
	public static final Item ORANGE_YARN_ROLL = registerItem("orange_yarn_roll", newYarnRollItem(Blocks.ORANGE_CARPET));
	public static final Item PINK_YARN_ROLL = registerItem("pink_yarn_roll", newYarnRollItem(Blocks.PINK_CARPET));
	public static final Item PURPLE_YARN_ROLL = registerItem("purple_yarn_roll", newYarnRollItem(Blocks.PURPLE_CARPET));
	public static final Item RED_YARN_ROLL = registerItem("red_yarn_roll", newYarnRollItem(Blocks.RED_CARPET));
	public static final Item WHITE_YARN_ROLL = registerItem("white_yarn_roll", newYarnRollItem(Blocks.WHITE_CARPET));
	public static final Item YELLOW_YARN_ROLL = registerItem("yellow_yarn_roll", newYarnRollItem(Blocks.YELLOW_CARPET));
	//# Shard #
	public static final Item DARK_PRISMARINE_SHARD = registerItem("dark_prismarine_shard", newFireproofItem(64));
	public static final Item GLASS_SHARD = registerItem("glass_shard", newFireproofItem(96));
	public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", newFireproofItem(96));
	//# Miscellaneous #
	public static final Item DRY_GRASS_TUFT = registerItem("dry_grass_tuft", newItem(itemSettings().maxCount(96)));
//	public static final Item DRY_MOSS_WAD = registerItem("dry_moss_wad", newItem(96)); // TODO: Enable later.
	public static final Item LIVE_GRASS_TUFT = registerItem("live_grass_tuft", newItem(96,
			itemSettings().food(FoodComponents.LIVE_GRASS_TUFT)));
//	public static final Item LIVE_MOSS_WAD = registerItem("live_moss_wad", new AliasedBlockItem( // TODO: Enable later.
//			Blocks.MOSS_CARPET, itemSettings(96)));
	public static final Item PINECONE = registerItem("pinecone",
			new IndirectBlockItem(Blocks.SPRUCE_SAPLING, itemSettings(64)));
	public static final Item SILK_WAD = registerItem("silk_wad", newItem(96));
	public static final Item STONE_PEBBLE = registerItem("stone_pebble", newFireproofItem(96));
	//endregion
	
	//region ## Containers ##
	//# Bottle (empty) #
	//# Bottle (filled) #
	public static final Item BOTTLE_OF_BRIMWATER = registerItem("bottle_of_brimwater",
			newBottleBeverageItem(itemSettings().food(FoodComponents.BOTTLE_OF_BRIMWATER)));
	public static final Item BOTTLE_OF_FREEZEWATER = registerItem("bottle_of_freezewater",
			newBottleBeverageItem(itemSettings().food(FoodComponents.BOTTLE_OF_FREEZEWATER)));
	public static final Item BOTTLE_OF_MILK = registerItem("bottle_of_milk",
			newBottleStatusEffectCureBeverageItem(milkCureStatusEffectList, itemSettings()));
	public static final Item BOTTLE_OF_STEAMING_WATER = registerItem("bottle_of_steaming_water",
			newBottleStatusEffectCureBeverageItem(
					newStatusEffectList(StatusEffects.SLOWNESS), // TODO: Cure a "Freezing" status effect (upon implementation).
					itemSettings().food(FoodComponents.BOTTLE_OF_STEAMING_WATER)));
	//# Bowl (empty) #
	//# Bowl (filled - soup) #
	public static final Item BOWL_OF_CARROT_SOUP = registerItem("bowl_of_carrot_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_CARROT_SOUP)));
	public static final Item BOWL_OF_KELP_SOUP = registerItem("bowl_of_kelp_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_KELP_SOUP)));
	public static final Item BOWL_OF_MUSHROOM_SOUP = registerItem("bowl_of_mushroom_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MUSHROOM_SOUP)));
	public static final Item BOWL_OF_POISONOUS_POTATO_SOUP = registerItem("bowl_of_poisonous_potato_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_POISONOUS_POTATO_SOUP)));
	public static final Item BOWL_OF_PORRIDGE = registerItem("bowl_of_porridge",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PORRIDGE)));
	public static final Item BOWL_OF_POTATO_SOUP = registerItem("bowl_of_potato_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_POTATO_SOUP)));
	public static final Item BOWL_OF_PUMPKIN_SOUP = registerItem("bowl_of_pumpkin_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PUMPKIN_SOUP)));
	public static final Item BOWL_OF_RADISH_SOUP = registerItem("bowl_of_radish_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_RADISH_SOUP)));
	//# Bowl (filled - stew) #
	public static final Item BOWL_OF_BEEF_STEW = registerItem("bowl_of_beef_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_BEEF_STEW)));
	public static final Item BOWL_OF_BUGMEAT_STEW = registerItem("bowl_of_bugmeat_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_BUGMEAT_STEW)));
	public static final Item BOWL_OF_CHICKEN_STEW = registerItem("bowl_of_chicken_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_CHICKEN_STEW)));
	public static final Item BOWL_OF_COD_STEW = registerItem("bowl_of_cod_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_COD_STEW)));
	public static final Item BOWL_OF_MORSEL_STEW = registerItem("bowl_of_morsel_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MORSEL_STEW)));
	public static final Item BOWL_OF_MUTTON_STEW = registerItem("bowl_of_mutton_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_MUTTON_STEW)));
	public static final Item BOWL_OF_PORK_STEW = registerItem("bowl_of_pork_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_PORK_STEW)));
	public static final Item BOWL_OF_RABBIT_STEW = registerItem("bowl_of_rabbit_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_RABBIT_STEW)));
	public static final Item BOWL_OF_SALMON_STEW = registerItem("bowl_of_salmon_stew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_SALMON_STEW)));
	//# Bowl (filled - miscellaneous) #
	public static final Item BOWL_OF_BRIMWATER = registerItem("bowl_of_brimwater",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_BRIMWATER)));
	public static final Item BOWL_OF_FREEZEWATER = registerItem("bowl_of_freezewater",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_FREEZEWATER)));
	public static final Item BOWL_OF_HONEY = registerItem("bowl_of_honey",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_HONEY)));
	public static final Item BOWL_OF_MILK = registerItem("bowl_of_milk",
			newBowlStatusEffectCureBeverageItem(milkCureStatusEffectList, itemSettings()));
	public static final Item BOWL_OF_STEAMING_WATER = registerItem("bowl_of_steaming_water",
			newBowlStatusEffectCureBeverageItem(
					newStatusEffectList(StatusEffects.SLOWNESS), // TODO: Cure a "Freezing" status effect (upon implementation).
					itemSettings().food(FoodComponents.BOWL_OF_STEAMING_WATER)));
	public static final Item BOWL_OF_WATER = registerItem("bowl_of_water",
			newBowlBeverageItem(itemSettings().food(FoodComponents.BOWL_OF_WATER)));
	//# Bucket (empty) #
	//# Bucket (filled) #
	public static final Item BUCKET_OF_BRIMWATER = registerItem("bucket_of_brimwater",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_BRIMWATER)));
	public static final Item BUCKET_OF_FERTILIZER = registerItem("bucket_of_fertilizer",
			new BucketOfFertilizerItem(itemSettings().maxDamage(15).recipeRemainder(Items.BUCKET)));
	public static final Item BUCKET_OF_FREEZEWATER = registerItem("bucket_of_freezewater",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_FREEZEWATER)));
	public static final Item BUCKET_OF_HONEY = registerItem("bucket_of_honey",
			newBucketBeverageItem(itemSettings().food(FoodComponents.BUCKET_OF_HONEY)));
	public static final Item BUCKET_OF_STEAMING_WATER = registerItem("bucket_of_steaming_water",
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
	public static final Item SHARP_WOODEN_STICK = registerItem("sharp_wooden_stick",
			newDaggerItem(ModToolMaterials.WOODEN_STICK, 2, -1.4F, itemSettings()));
	//# [Tier 1] Wood #
	public static final Item WOODEN_DAGGER = registerItem("wooden_dagger",
			newDaggerItem(ModToolMaterials.WOOD, 2, -1.4F, itemSettings()));
	public static final Item WOODEN_MALLET = registerItem("wooden_mallet",
			newMalletItem(ModToolMaterials.WOOD, 3, -3.0F, itemSettings()));
	public static final Item WOODEN_SHOVEL = registerItem("wooden_shovel",
			newShovelItem(ModToolMaterials.WOOD, 2, -2.8F, itemSettings()));
	public static final Item WOODEN_SPEAR = registerItem("wooden_spear",
			newSpearItem(ModToolMaterials.WOOD, 3, -2.3F, itemSettings()));
	public static final Item WOODEN_SWORD = registerItem("wooden_sword",
			newSwordItem(ModToolMaterials.WOOD, 3, -2.2F, itemSettings()));
	//# [Tier 2] Flint #
	public static final Item FLINT_DAGGER = registerItem("flint_dagger",
			newDaggerItem(ModToolMaterials.FLINT, 3, -1.5F, itemSettings()));
	public static final Item FLINT_HATCHET = registerItem("flint_hatchet",
			newHatchetItem(ModToolMaterials.FLINT, 5, -2.1F, itemSettings()));
	public static final Item FLINT_HOE = registerItem("flint_hoe",
			newHoeItem(ModToolMaterials.FLINT, 2, -2.6F, itemSettings()));
	public static final Item FLINT_SPEAR = registerItem("flint_spear",
			newSpearItem(ModToolMaterials.FLINT, 5, -2.3F, itemSettings()));
	//# [Tier 2] Glass #
	public static final Item GLASS_DAGGER = registerItem("glass_dagger",
			newDaggerItem(ModToolMaterials.GLASS, 3, -1.5F, itemSettings()));
	public static final Item GLASS_HATCHET = registerItem("glass_hatchet",
			  newHatchetItem(ModToolMaterials.GLASS, 5, -2.1F, itemSettings()));
	public static final Item GLASS_HOE = registerItem("glass_hoe",
			newHoeItem(ModToolMaterials.GLASS, 2, -2.6F, itemSettings()));
	public static final Item GLASS_SPEAR = registerItem("glass_spear",
			newSpearItem(ModToolMaterials.GLASS, 5, -2.3F, itemSettings()));
	//# [Tier 2] Obsidian #
	public static final Item OBSIDIAN_DAGGER = registerItem("obsidian_dagger",
			newDaggerItem(ModToolMaterials.OBSIDIAN, 3, -1.5F, itemSettings()));
	public static final Item OBSIDIAN_HATCHET = registerItem("obsidian_hatchet",
			  newHatchetItem(ModToolMaterials.OBSIDIAN, 5, -2.1F, itemSettings()));
	public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
			newHoeItem(ModToolMaterials.OBSIDIAN, 2, -2.6F, itemSettings()));
	public static final Item OBSIDIAN_SPEAR = registerItem("obsidian_spear",
			newSpearItem(ModToolMaterials.OBSIDIAN, 5, -2.3F, itemSettings()));
	//# [Tier 3] Brass (armor) #
	public static final Item BRASS_BOOT_PAIR = registerItem("brass_boot_pair",
			newBootPairItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_CHESTPLATE = registerItem("brass_chestplate",
			newChestplateItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_HELMET = registerItem("brass_helmet",
			newHelmetItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	public static final Item BRASS_HORSE_HARNESS = registerItem("brass_horse_harness",
			newHorseArmorItem(ModArmorMaterials.BRASS, itemSettings().fireproof()));
	public static final Item BRASS_LEGGING_PAIR = registerItem("brass_legging_pair",
			newLeggingPairItem(ModArmorMaterials.BRASS, 16, itemSettings().fireproof()));
	//# [Tier 3] Brass (tools) #
	public static final Item BRASS_AXE = registerItem("brass_axe",
			newAxeItem(ModToolMaterials.BRASS, 6, -2.9F, itemSettings().fireproof()));
	public static final Item BRASS_DAGGER = registerItem("brass_dagger",
			newDaggerItem(ModToolMaterials.BRASS, 3, -1.4F, itemSettings().fireproof()));
	public static final Item BRASS_HATCHET = registerItem("brass_hatchet",
			newHatchetItem(ModToolMaterials.BRASS, 5, -2.1F, itemSettings().fireproof()));
	public static final Item BRASS_HOE = registerItem("brass_hoe",
			newHoeItem(ModToolMaterials.BRASS, 2, -2.6F, itemSettings().fireproof()));
	public static final Item BRASS_MALLET = registerItem("brass_mallet",
			newMalletItem(ModToolMaterials.BRASS, 3, -3.0F, itemSettings().fireproof()));
	public static final Item BRASS_PICKAXE = registerItem("brass_pickaxe",
			newPickaxeItem(ModToolMaterials.BRASS, 3, -3.0F, itemSettings().fireproof()));
	public static final Item BRASS_SHOVEL = registerItem("brass_shovel",
			newShovelItem(ModToolMaterials.BRASS, 2, -2.8F, itemSettings().fireproof()));
	public static final Item BRASS_SPEAR = registerItem("brass_spear",
			newSpearItem(ModToolMaterials.BRASS, 5, -2.3F, itemSettings().fireproof()));
	public static final Item BRASS_SWORD = registerItem("brass_sword",
			newSwordItem(ModToolMaterials.BRASS, 4, -2.2F, itemSettings().fireproof()));
	//# [Tier 3] Copper (armor) #
	public static final Item COPPER_BOOT_PAIR = registerItem("copper_boot_pair",
			newBootPairItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
			newChestplateItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_HELMET = registerItem("copper_helmet",
			newHelmetItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	public static final Item COPPER_HORSE_HARNESS = registerItem("copper_horse_harness",
			newHorseArmorItem(ModArmorMaterials.COPPER, itemSettings().fireproof()));
	public static final Item COPPER_LEGGING_PAIR = registerItem("copper_legging_pair",
			newLeggingPairItem(ModArmorMaterials.COPPER, 14, itemSettings().fireproof()));
	//# [Tier 3] Copper (tools) #
	public static final Item COPPER_AXE = registerItem("copper_axe",
			newAxeItem(ModToolMaterials.COPPER, 6, -3.1F, itemSettings().fireproof()));
	public static final Item COPPER_DAGGER = registerItem("copper_dagger",
			newDaggerItem(ModToolMaterials.COPPER, 3, -1.6F, itemSettings().fireproof()));
	public static final Item COPPER_HATCHET = registerItem("copper_hatchet",
			newHatchetItem(ModToolMaterials.COPPER, 5, -2.3F, itemSettings().fireproof()));
	public static final Item COPPER_HOE = registerItem("copper_hoe",
			newHoeItem(ModToolMaterials.COPPER, 2, -2.8F, itemSettings().fireproof()));
	public static final Item COPPER_MALLET = registerItem("copper_mallet",
			newMalletItem(ModToolMaterials.COPPER, 3, -3.2F, itemSettings().fireproof()));
	public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
			newPickaxeItem(ModToolMaterials.COPPER, 3, -3.2F, itemSettings().fireproof()));
	public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
			newShovelItem(ModToolMaterials.COPPER, 2, -3.0F, itemSettings().fireproof()));
	public static final Item COPPER_SPEAR = registerItem("copper_spear",
			newSpearItem(ModToolMaterials.COPPER, 5, -2.5F, itemSettings().fireproof()));
	public static final Item COPPER_SWORD = registerItem("copper_sword",
			newSwordItem(ModToolMaterials.COPPER, 4, -2.4F, itemSettings().fireproof()));
	//# [Tier 3] Eiduril (armor) #
	public static final Item EIDURIL_BOOT_PAIR = registerItem("eiduril_boot_pair",
			newBootPairItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_CHESTPLATE = registerItem("eiduril_chestplate",
			newChestplateItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_HELMET = registerItem("eiduril_helmet",
			newHelmetItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	public static final Item EIDURIL_HORSE_HARNESS = registerItem("eiduril_horse_harness",
			newHorseArmorItem(ModArmorMaterials.EIDURIL, itemSettings().fireproof()));
	public static final Item EIDURIL_LEGGING_PAIR = registerItem("eiduril_legging_pair",
			newSetBonusLeggingPairItem(ModArmorMaterials.EIDURIL, 31, itemSettings().fireproof()));
	//# [Tier 3] Eiduril (tools) #
	public static final Item EIDURIL_AXE = registerItem("eiduril_axe",
			newAxeItem(ModToolMaterials.EIDURIL, 6, -3.0F, itemSettings().fireproof()));
	public static final Item EIDURIL_DAGGER = registerItem("eiduril_dagger",
			newDaggerItem(ModToolMaterials.EIDURIL, 3, -1.5F, itemSettings().fireproof()));
	public static final Item EIDURIL_HATCHET = registerItem("eiduril_hatchet",
			newHatchetItem(ModToolMaterials.EIDURIL, 5, -2.2F, itemSettings().fireproof()));
	public static final Item EIDURIL_HOE = registerItem("eiduril_hoe",
			newHoeItem(ModToolMaterials.EIDURIL, 2, -2.7F, itemSettings().fireproof()));
	public static final Item EIDURIL_MALLET = registerItem("eiduril_mallet",
			newMalletItem(ModToolMaterials.EIDURIL, 3, -3.1F, itemSettings().fireproof()));
	public static final Item EIDURIL_PICKAXE = registerItem("eiduril_pickaxe",
			newPickaxeItem(ModToolMaterials.EIDURIL, 3, -3.1F, itemSettings().fireproof()));
	public static final Item EIDURIL_SHOVEL = registerItem("eiduril_shovel",
			newShovelItem(ModToolMaterials.EIDURIL, 2, -2.9F, itemSettings().fireproof()));
	public static final Item EIDURIL_SPEAR = registerItem("eiduril_spear",
			newSwordItem(ModToolMaterials.EIDURIL, 5, -2.4F, itemSettings().fireproof()));
	public static final Item EIDURIL_SWORD = registerItem("eiduril_sword",
			newSwordItem(ModToolMaterials.EIDURIL, 4, -2.3F, itemSettings().fireproof()));
	//# [Tier 3] Gold (armor) #
	//# [Tier 3] Gold (tools) #
	public static final Item GOLDEN_DAGGER = registerItem("golden_dagger",
			newDaggerItem(ToolMaterials.GOLD, 3, -1.6F, itemSettings().fireproof()));
	public static final Item GOLDEN_HATCHET = registerItem("golden_hatchet",
			newHatchetItem(ToolMaterials.GOLD, 5, -2.3F, itemSettings().fireproof()));
	public static final Item GOLDEN_MALLET = registerItem("golden_mallet",
			newMalletItem(ToolMaterials.GOLD, 3, -3.2F, itemSettings().fireproof()));
	public static final Item GOLDEN_SPEAR = registerItem("golden_spear",
			newSwordItem(ToolMaterials.GOLD, 5, -2.5F, itemSettings().fireproof()));
	//# [Tier 3] Iron (armor) #
	//# [Tier 3] Iron (tools) #
	public static final Item IRON_DAGGER = registerItem("iron_dagger",
			newDaggerItem(ToolMaterials.IRON, 3, -1.6F, itemSettings().fireproof()));
	public static final Item IRON_HATCHET = registerItem("iron_hatchet",
			newHatchetItem(ToolMaterials.IRON, 5, -2.3F, itemSettings().fireproof()));
	public static final Item IRON_MALLET = registerItem("iron_mallet",
			newMalletItem(ToolMaterials.IRON, 3, -3.2F, itemSettings().fireproof()));
	public static final Item IRON_SPEAR = registerItem("iron_spear",
			newSwordItem(ToolMaterials.IRON, 5, -2.5F, itemSettings().fireproof()));
	//# Miscellaneous #
	public static final Item SPATIAL_RECALL_STONE = registerItem("spatial_recall_stone",
			new SelfTeleporterItem(itemSettings().fireproof().rarity(Rarity.RARE).maxDamage(7)));
	public static final Item TARGET_TELEPORTATION_TUNER = registerItem("target_teleportation_tuner",
			new TargetTeleporterItem(itemSettings().fireproof().rarity(Rarity.RARE).maxDamage(60)));
	//endregion
	
	
	//region ## Foods ##
	//TODO: Put food items here.
	// - Not all edible items; only items with special "food" classification.
	//  - E.g, raw and cooked buns, but NOT Live Grass Tuft.
	//# Basic (cooked) #
	public static final Item BAKED_CARROT = registerItem("baked_carrot", newItem(64,
			itemSettings().food(FoodComponents.BAKED_CARROT)));
	public static final Item BAKED_MUSHROOM = registerItem("baked_mushroom", newItem(64,
			itemSettings().food(FoodComponents.BAKED_MUSHROOM)));
	public static final Item BAKED_RADISH = registerItem("baked_radish", newItem(64,
			itemSettings().food(FoodComponents.BAKED_RADISH)));
	public static final Item COOKED_BUGMEAT_STEAK = registerItem("cooked_bugmeat_steak", newItem(64,
			itemSettings().food(FoodComponents.COOKED_BUGMEAT_STEAK)));
	public static final Item COOKED_MEAT_MORSEL = registerItem("cooked_meat_morsel", newItem(96,
			itemSettings().food(FoodComponents.COOKED_MEAT_MORSEL)));
	//# Basic (raw) #
	public static final Item RAW_BUGMEAT_STEAK = registerItem("raw_bugmeat_steak", newItem(64,
			itemSettings().food(FoodComponents.RAW_BUGMEAT_STEAK)));
	public static final Item RAW_MEAT_MORSEL = registerItem("raw_meat_morsel", newItem(96,
			itemSettings().food(FoodComponents.RAW_MEAT_MORSEL)));
	//# Bread, Bun, Cake, & Cookie (cooked) #
	public static final Item HONEYBUN = registerItem("honeybun",
			new StatusEffectCureFoodItem(honeyCureStatusEffectList,
					itemSettings(64).food(FoodComponents.HONEYBUN)));
	public static final Item MAGMABUN = registerItem("magmabun", newItem(64,
			itemSettings().food(FoodComponents.MAGMABUN)));
	public static final Item SLIMEBUN = registerItem("slimebun", newItem(64,
			itemSettings().food(FoodComponents.SLIMEBUN)));
	//# Bread, Bun, Cake, & Cookie (raw) #
	public static final Item RAW_CAKE = registerItem("raw_cake", newItem(1,
			itemSettings().food(FoodComponents.RAW_CAKE)));
	public static final Item RAW_COOKIE_BALL = registerItem("raw_cookie_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_COOKIE_BALL)));
	public static final Item RAW_DOUGH_LUMP = registerItem("raw_dough_lump", newItem(64,
			itemSettings().food(FoodComponents.RAW_DOUGH_LUMP)));
	public static final Item RAW_HONEYBUN_BALL = registerItem("raw_honeybun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_HONEYBUN_BALL)));
	public static final Item RAW_MAGMABUN_BALL = registerItem("raw_magmabun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_MAGMABUN_BALL)));
	public static final Item RAW_SLIMEBUN_BALL = registerItem("raw_slimebun_ball", newItem(96,
			itemSettings().food(FoodComponents.RAW_SLIMEBUN_BALL)));
	//# Pie (cooked) #
	public static final Item APPLE_PIE = registerItem("apple_pie", newItem(16,
			itemSettings().food(FoodComponents.APPLE_PIE)));
	public static final Item CHERRY_PIE = registerItem("cherry_pie", newItem(16,
			itemSettings().food(FoodComponents.CHERRY_PIE)));
	public static final Item GLOWBERRY_PIE = registerItem("glowberry_pie", newItem(16,
			itemSettings().food(FoodComponents.GLOWBERRY_PIE)));
	public static final Item PUMPKIN_PIE = registerItem("pumpkin_pie", newItem(16,
			itemSettings().food(FoodComponents.PUMPKIN_PIE)));
	public static final Item SWEETBERRY_PIE = registerItem("sweetberry_pie", newItem(16,
			itemSettings().food(FoodComponents.SWEETBERRY_PIE)));
	//# Pie (raw) #
	public static final Item RAW_APPLE_PIE = registerItem("raw_apple_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_APPLE_PIE)));
	public static final Item RAW_CHERRY_PIE = registerItem("raw_cherry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_CHERRY_PIE)));
	public static final Item RAW_GLOWBERRY_PIE = registerItem("raw_glowberry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_GLOWBERRY_PIE)));
	public static final Item RAW_PUMPKIN_PIE = registerItem("raw_pumpkin_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_PUMPKIN_PIE)));
	public static final Item RAW_SWEETBERRY_PIE = registerItem("raw_sweetberry_pie", newItem(16,
			itemSettings().food(FoodComponents.RAW_SWEETBERRY_PIE)));
	//# Miscellaneous #
	public static final Item CHEESE_WHEEL = registerItem("cheese_wheel", newItem(16,
			itemSettings().food(FoodComponents.CHEESE_WHEEL)));
	public static final Item CHERRY_BUNCH = registerItem("cherry_bunch", newItem(96,
			itemSettings().food(FoodComponents.CHERRY_BUNCH)));
	public static final Item DRY_KELP_BUNDLE = registerItem("dry_kelp_bundle", newItem(64,
			itemSettings().food(FoodComponents.DRY_KELP_BUNDLE)));
	public static final Item FRIED_EGG = registerItem("fried_egg", newItem(16,
			itemSettings().food(FoodComponents.FRIED_EGG)));
	//endregion
	
	
	//region  ### Joke & Unserious Items ###
	
	//## (J&U) Basic Resources ##
	//# Ball #
	public static final Item CHERRY_JELLYBALL = registerItem("cherry_jellyball",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.CHERRY_JELLYBALL)));
	//# Brick #
	public static final Item ENCHANTED_BRICK = registerItem("enchanted_brick",
			new Item(new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	//# Chunk #
	//# Cobblestone #
	//# Gram & Ingot #
	public static final Item NUTRILLARN_GRAM = registerItem("nutrillarn_gram",
			newFireproofItem(itemSettings().maxCount(96).food(FoodComponents.NUTRILLARN_GRAM)));
	public static final Item NUTRILLARN_INGOT = registerItem("nutrillarn_ingot",
			newFireproofItem(itemSettings().maxCount(64).food(FoodComponents.NUTRILLARN_INGOT)));
	//# Jewel #
	//# Log & Trunk #
	//# Lump & Nugget #
	public static final Item RAW_NUTRILLARN_LUMP = registerItem("raw_nutrillarn_lump",
			newFireproofItem(itemSettings().maxCount(64).food(FoodComponents.RAW_NUTRILLARN_LUMP)));
	public static final Item RAW_NUTRILLARN_NUGGET = registerItem("raw_nutrillarn_nugget",
			newFireproofItem(itemSettings().maxCount(96).food(FoodComponents.RAW_NUTRILLARN_NUGGET)));
	//# Pile (seed) #
	//# Pile (miscellaneous) #
	public static final Item MILKLEAF_PILE = registerItem("milkleaf_pile",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.MILKLEAF_PILE)));
	//# Plank #
	//# Bundle & Rod & Stick #
	//# Shard #
	//# Miscellaneous (cheese) #
	public static final Item BLUE_CHEESE_WEDGE = registerItem("blue_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.BLUE_CHEESE_WEDGE)));
	public static final Item SILKY_SMOOTH_CHEESE_WEDGE = registerItem("silky_smooth_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.SILKY_SMOOTH_CHEESE_WEDGE)));
	public static final Item YELLOW_CHEESE_WEDGE = registerItem("yellow_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.YELLOW_CHEESE_WEDGE)));
	//# Miscellaneous (miscellaneous) #
	public static final Item CHOCOLATE_BAR = registerItem("chocolate_bar",
			newItem(64, itemSettings().food(FoodComponents.CHOCOLATE_BAR)));
	public static final Item CHULK_BERRY_BUNCH = registerItem("chulk_berry_bunch",
			newItem(64, new Item.Settings().food(FoodComponents.CHULK_BERRY_BUNCH)));
	public static final Item HONEYPOD = registerItem("honeypod",
			newItem(64, itemSettings().food(FoodComponents.HONEYPOD)));
	public static final Item MINIWIZARD = registerItem("miniwizard",
			new Item(new Item.Settings().maxCount(16).rarity(Rarity.RARE).fireproof()
					.food(FoodComponents.MINIWIZARD)));
	public static final Item STARCHCAP_MUSHROOM = registerItem("starchcap_mushroom",
			new AliasedBlockItem(ModBlocks.STARCHCAP_MUSHROOM, itemSettings().maxCount(64).food(FoodComponents.STARCHCAP_MUSHROOM)));
	
	//## (J&U) Containers ##
	//# Bottle #
	//# Bowl #
	public static final Item BOWL_OF_OMNISTEW = registerItem("bowl_of_omnistew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_OMNISTEW)));
	public static final Item BOWL_OF_STONE_SOUP = registerItem("bowl_of_stone_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_STONE_SOUP)));
	//# Bucket #
	
	//## (J&U) Equipment ##
	//# Nutrillarn (armor) #
	public static final Item NUTRILLARN_BOOT_PAIR = registerItem("nutrillarn_boot_pair",
			newBootPairItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
	public static final Item NUTRILLARN_CHESTPLATE = registerItem("nutrillarn_chestplate",
			newChestplateItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
	public static final Item NUTRILLARN_HELMET = registerItem("nutrillarn_helmet",
			newHelmetItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
	public static final Item NUTRILLARN_HORSE_HARNESS = registerItem("nutrillarn_horse_harness",
			newHorseArmorItem(ModArmorMaterials.NUTRILLARN, itemSettings().fireproof()));
	public static final Item NUTRILLARN_JELLYBOOT_PAIR = registerItem("nutrillarn_jellyboot_pair",
			new StatusEffectArmorItem(ModArmorMaterials.NUTRILLARN, ArmorItem.Type.BOOTS,
					StatusEffects.JUMP_BOOST, 1,
					itemSettings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(3)).fireproof()));
	public static final Item NUTRILLARN_LEGGING_PAIR = registerItem("nutrillarn_legging_pair",
			newSetBonusLeggingPairItem(ModArmorMaterials.NUTRILLARN, 3, itemSettings().fireproof()));
	//# Nutrillarn (tools) #
	public static final Item NUTRILLARN_AXE = registerItem("nutrillarn_axe",
			newAxeItem(ModToolMaterials.NUTRILLARN, 6, -2.9F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_DAGGER = registerItem("nutrillarn_dagger",
			newDaggerItem(ModToolMaterials.NUTRILLARN, 3, -1.4F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_HATCHET = registerItem("nutrillarn_hatchet",
			newHatchetItem(ModToolMaterials.NUTRILLARN, 5, -2.1F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_HOE = registerItem("nutrillarn_hoe",
			newHoeItem(ModToolMaterials.NUTRILLARN, 2, -2.6F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_MALLET = registerItem("nutrillarn_mallet",
			new NutrillarnMalletItem(ModToolMaterials.NUTRILLARN, itemSettings().attributeModifiers(
					NutrillarnMalletItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 3, -3.0F)
			).fireproof()));
	public static final Item NUTRILLARN_PICKAXE = registerItem("nutrillarn_pickaxe",
			newPickaxeItem(ModToolMaterials.NUTRILLARN, 3, -3.0F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_SHOVEL = registerItem("nutrillarn_shovel",
			newShovelItem(ModToolMaterials.NUTRILLARN, 2, -2.8F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_SPEAR = registerItem("nutrillarn_spear",
			newSpearItem(ModToolMaterials.NUTRILLARN, 5, -2.3F, itemSettings().fireproof()));
	public static final Item NUTRILLARN_SWORD = registerItem("nutrillarn_sword",
			new NutrillarnSwordItem(ModToolMaterials.NUTRILLARN, itemSettings().attributeModifiers(
					NutrillarnSwordItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 4, -2.2F)
			).fireproof()));
	//# Miscellaneous #
	public static final Item ENCHANTED_CHEESE_WHEEL = registerItem("enchanted_cheese_wheel",
			new EnchantedCheeseWheelItem(itemSettings()
					.maxDamage(72).fireproof().rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item NUTRILLARN_COMPASS = registerItem("nutrillarn_compass",
			new NutrillarnCompassItem(itemSettings(64).fireproof().food(FoodComponents.NUTRILLARN_COMPASS)));
	public static final Item ORB_OF_ZOT = registerItem("orb_of_zot",
			new OrbOfZotItem(itemSettings()
					.maxCount(1).fireproof().rarity(Rarity.EPIC)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	//endregion
	
	
	private static Item newItem(int maxCount) {
		return newItem(new Item.Settings().maxCount(maxCount));
	}
	
	private static Item newItem(int maxCount, Rarity rarity) {
		return newItem(new Item.Settings().maxCount(maxCount).rarity(rarity));
	}
	
	private static Item newItem(int maxCount, Item.Settings settings) {
		return newItem(settings.maxCount(maxCount));
	}
	
	private static Item newItem(Item.Settings settings) {
		return new Item(settings);
	}
	
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
	
	
	private static Item newFireproofItem(int maxCount) {
		return newFireproofItem(itemSettings().maxCount(maxCount));
	}
	
	private static Item newFireproofItem(Item.Settings settings) {
		return newItem(settings.fireproof());
	}
	
	
	private static Item newGlassPaneItem(Block block) {
		return new AliasedBlockItem(block, itemSettings().maxCount(64).fireproof());
	}
	
	
	private static Item newYarnRollItem(Block block) {
		return new AliasedBlockItem(block, itemSettings().maxCount(64));
	}
	
	
	//region ## New Container Item Methods ##
	//# Bottle #
	private static Item newBottleBeverageItem(Item.Settings settings) {
		return new BottleBeverageItem(settings.maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).fireproof());
	}
	
	
	private static Item newBottleStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BottleStatusEffectCureBeverageItem(curedStatusEffects,
				settings.maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).fireproof());
	}
	
	
	//# Bowl #
	private static Item newBowlBeverageItem(Item.Settings settings) {
		return new BowlBeverageItem(settings.maxCount(12).recipeRemainder(Items.BOWL));
	}
	
	
	private static Item newBowlFoodItem(Item.Settings settings) {
		return new BowlFoodItem(settings.maxCount(1).recipeRemainder(Items.BOWL));
	}
	
	
	private static Item newBowlStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BowlStatusEffectCureBeverageItem(curedStatusEffects,
				settings.maxCount(12).recipeRemainder(Items.BOWL));
	}
	
	
	//# Bucket #
	private static Item newBucketBeverageItem(Item.Settings settings) {
		return new BucketBeverageItem(settings.maxCount(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	private static Item newBucketFoodItem(Item.Settings settings) {
		return new BucketFoodItem(settings.maxCount(1).recipeRemainder(Items.BUCKET).fireproof());
	}
	
	
	private static Item newBucketStatusEffectCureBeverageItem(
			ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Item.Settings settings
	) {
		return new BucketStatusEffectCureBeverageItem(curedStatusEffects,
				settings.maxCount(1).recipeRemainder(Items.BOWL).fireproof());
	}
	//endregion
	
	//region ## New Equipment Item Methods ##
	// # Armor #
	private static Item newBootPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.BOOTS, maxDamageMultiplier, settings);
	}
	
	private static Item newChestplateItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, maxDamageMultiplier, settings);
	}
	
	private static Item newHelmetItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.HELMET, maxDamageMultiplier, settings);
	}
	
	private static Item newHorseArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, Item.Settings settings
	) {
		return new AnimalArmorItem(armorMaterial, AnimalArmorItem.Type.EQUESTRIAN, false, settings.maxCount(1));
	}
	
	private static Item newLeggingPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, maxDamageMultiplier, settings);
	}
	
	private static Item newSetBonusLeggingPairItem(
			RegistryEntry<ArmorMaterial> armorMaterial, int maxDamageMultiplier, Item.Settings settings
	) {
		return newHumanoidSetBonusArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, maxDamageMultiplier, settings);
	}
	
	// # Tools #
	private static Item newAxeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new AxeItem(material, settings.attributeModifiers(
				AxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newDaggerItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'DaggerIem' class instead of 'SwordItem'.
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newHatchetItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'HatchetIem' class instead of 'AxeItem'.
		return new AxeItem(material, settings.attributeModifiers(
				AxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newHoeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new HoeItem(material, settings.attributeModifiers(
				HoeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newMalletItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'MalletIem' class instead of 'PickaxeItem'.
		return new PickaxeItem(material, settings.attributeModifiers(
				PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newPickaxeItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new PickaxeItem(material, settings.attributeModifiers(
				PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newShovelItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new ShovelItem(material, settings.attributeModifiers(
				ShovelItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newSpearItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		// TODO: Use a custom 'SpearIem' class instead of 'SwordItem'.
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	
	private static Item newSwordItem(ToolMaterial material, int baseAttackDamage, float attackSpeed, Item.Settings settings) {
		return new SwordItem(material, settings.attributeModifiers(
				SwordItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed)
		));
	}
	//endregion
	
	
	private static Item.Settings itemSettings() {
		return new Item.Settings();
	}
	
	
	private static Item.Settings itemSettings(int maxCount) {
		return new Item.Settings().maxCount(maxCount);
	}
	
	private static Item.Settings largeBrickSettings() {
		return new Item.Settings().maxCount(32).fireproof();
	}
	private static Item.Settings smallBrickSettings() {
		return new Item.Settings().maxCount(64).fireproof();
	}
	private static Item.Settings cobblestoneSettings() {
		return new Item.Settings().maxCount(48).fireproof();
	}
	private static Item.Settings plankSettings() {
		return new Item.Settings().maxCount(64);
	}
	
	
	@SafeVarargs
	private static ArrayList<RegistryEntry<StatusEffect>> newStatusEffectList(RegistryEntry<StatusEffect>... effects) {
		return new ArrayList<>(Arrays.asList(effects));
	}
}
