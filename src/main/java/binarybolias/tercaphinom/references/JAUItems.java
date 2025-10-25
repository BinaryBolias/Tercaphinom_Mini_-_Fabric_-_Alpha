package binarybolias.tercaphinom.references;


import binarybolias.tercaphinom.item.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static binarybolias.tercaphinom.references.ModItems.*;


/**
 * Registration for joke & unserious items.
 * @see ModItems
 */
public class JAUItems {
	public static void bootstrap() {
		Reference.logMainEvent("Registering joke & unserious items");
	}
	
	
	//### Items ###
	//region ## Basic Resources ##
	//# Ball #
	public static final Item CHERRY_JELLYBALL = register("cherry_jellyball",
			new PlaceableBlockMaterialItem(JAUBlocks.CHERRY_JELLYBLOCK,
					itemSettings(64).food(FoodComponents.CHERRY_JELLYBALL)));
	//# Brick #
	//# Bundle & Rod & Stick #
	//# Chunk (ice) #
	//# Chunk (miscellaneous) #
	//# Clod #
	//# Cobblestone #
	//# Gram & Ingot #
	public static final Item NUTRILLARN_GRAM = register("nutrillarn_gram",
			newItem(metalGramSettings().food(FoodComponents.NUTRILLARN_GRAM)));
	public static final Item NUTRILLARN_INGOT = register("nutrillarn_ingot",
			new PlaceableBlockMaterialItem(JAUBlocks.REFINED_NUTRILLARN_BLOCK,
					metalIngotSettings().food(FoodComponents.NUTRILLARN_INGOT)));
	//# Jewel #
	//# Log (wooden log) #
	//# Log (wooden trunk) #
	//# Log (miscellaneous) #
	//# Lump & Nugget (metalloid) #
	public static final Item RAW_NUTRILLARN_LUMP = register("raw_nutrillarn_lump",
			new PlaceableBlockMaterialItem(JAUBlocks.RAW_NUTRILLARN_BLOCK,
					metalLumpSettings().food(FoodComponents.RAW_NUTRILLARN_LUMP)));
	public static final Item RAW_NUTRILLARN_NUGGET = register("raw_nutrillarn_nugget",
			newItem(metalNuggetSettings().food(FoodComponents.RAW_NUTRILLARN_NUGGET)));
	//# Lump & Nugget (miscellaneous) #
	//# Pane #
	//# Pile (seed) #
	//# Pile (miscellaneous) #
	public static final Item CANDESAND_PILE = ModItems.register("candesand_pile",
			new PlaceableBlockMaterialItem(JAUBlocks.CANDESAND_BLOCK,
					earthenPileSettings().food(FoodComponents.CANDESAND_PILE)));
	public static final Item MILKLEAF_PILE = register("milkleaf_pile",
			newItem(itemSettings(96).food(FoodComponents.MILKLEAF_PILE)));
	//# Plank #
	//# Roll #
	//# Shard #
	//# Wedge #
	public static final Item BLUE_CHEESE_WEDGE = register("blue_cheese_wedge",
			new PlaceableBlockMaterialItem(JAUBlocks.BLUE_CHEESE_BLOCK,
					itemSettings(64).food(FoodComponents.BLUE_CHEESE_WEDGE)));
	public static final Item SILKY_SMOOTH_CHEESE_WEDGE = register("silky_smooth_cheese_wedge",
			new PlaceableBlockMaterialItem(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK,
					itemSettings(64).food(FoodComponents.SILKY_SMOOTH_CHEESE_WEDGE)));
	public static final Item YELLOW_CHEESE_WEDGE = register("yellow_cheese_wedge",
			new PlaceableBlockMaterialItem(JAUBlocks.YELLOW_CHEESE_BLOCK,
					itemSettings(64).food(FoodComponents.YELLOW_CHEESE_WEDGE)));
	//# Miscellaneous #
	public static final Item CHULK_BERRY_BUNCH = register("chulk_berry_bunch",
			newItem(64, itemSettings().food(FoodComponents.CHULK_BERRY_BUNCH)));
	public static final Item ENCHANTED_BRICK = register("enchanted_brick",
			new Item(smallBrickSettings().rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item HONEYPOD = register("honeypod",
			newItem(64, itemSettings().food(FoodComponents.HONEYPOD)));
	public static final Item MINIWIZARD = register("miniwizard",
			new Item(fireproofItemSettings(16).rarity(Rarity.RARE)
					.food(FoodComponents.MINIWIZARD)));
	public static final Item STARCHCAP_MUSHROOM = register("starchcap_mushroom",
			new AliasedBlockItem(JAUBlocks.STARCHCAP_MUSHROOM,
					itemSettings().maxCount(64).food(FoodComponents.STARCHCAP_MUSHROOM)));
	//endregion
	
	//region ## Containers ##
	//# Bottle #
	//# Bowl #
	public static final Item BOWL_OF_OMNISTEW = register("bowl_of_omnistew",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_OMNISTEW)));
	public static final Item BOWL_OF_STONE_SOUP = register("bowl_of_stone_soup",
			newBowlFoodItem(itemSettings().food(FoodComponents.BOWL_OF_STONE_SOUP)));
	//# Bucket #
	//endregion
	
	//region  ## Equipment ##
	//# [Tier 3] Nutrillarn (armor) #
	public static final Item NUTRILLARN_BOOT_PAIR = register("nutrillarn_boot_pair",
			newBootPairItem(ModArmorMaterials.NUTRILLARN, 3, metalEquipmentSettings()));
	public static final Item NUTRILLARN_CHESTPLATE = register("nutrillarn_chestplate",
			newChestplateItem(ModArmorMaterials.NUTRILLARN, 3, metalEquipmentSettings()));
	public static final Item NUTRILLARN_HELMET = register("nutrillarn_helmet",
			newHelmetItem(ModArmorMaterials.NUTRILLARN, 3, metalEquipmentSettings()));
	public static final Item NUTRILLARN_HORSE_HARNESS = register("nutrillarn_horse_harness",
			newHorseArmorItem(ModArmorMaterials.NUTRILLARN, metalEquipmentSettings()));
	public static final Item NUTRILLARN_JELLYBOOT_PAIR = register("nutrillarn_jellyboot_pair",
			new StatusEffectArmorItem(ModArmorMaterials.NUTRILLARN, ArmorItem.Type.BOOTS,
					StatusEffects.JUMP_BOOST, 1,
					metalEquipmentSettings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(3))));
	public static final Item NUTRILLARN_LEGGING_PAIR = register("nutrillarn_legging_pair",
			newSetBonusLeggingPairItem(ModArmorMaterials.NUTRILLARN, 3, metalEquipmentSettings()));
	//# [Tier 3] Nutrillarn (tools) #
	public static final Item NUTRILLARN_AXE = register("nutrillarn_axe",
			newAxeItem(ModToolMaterials.NUTRILLARN, 6, -2.9F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_DAGGER = register("nutrillarn_dagger",
			newDaggerItem(ModToolMaterials.NUTRILLARN, 3, -1.4F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_HATCHET = register("nutrillarn_hatchet",
			newHatchetItem(ModToolMaterials.NUTRILLARN, 5, -2.1F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_HOE = register("nutrillarn_hoe",
			newHoeItem(ModToolMaterials.NUTRILLARN, 2, -2.6F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_MALLET = register("nutrillarn_mallet",
			new NutrillarnMalletItem(ModToolMaterials.NUTRILLARN, metalEquipmentSettings().attributeModifiers(
					NutrillarnMalletItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 3, -3.0F)
			)));
	public static final Item NUTRILLARN_PICKAXE = register("nutrillarn_pickaxe",
			newPickaxeItem(ModToolMaterials.NUTRILLARN, 3, -3.0F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_SHOVEL = register("nutrillarn_shovel",
			newShovelItem(ModToolMaterials.NUTRILLARN, 2, -2.8F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_SPEAR = register("nutrillarn_spear",
			newSpearItem(ModToolMaterials.NUTRILLARN, 5, -2.3F, metalEquipmentSettings()));
	public static final Item NUTRILLARN_SWORD = register("nutrillarn_sword",
			new NutrillarnSwordItem(ModToolMaterials.NUTRILLARN, metalEquipmentSettings().attributeModifiers(
					NutrillarnSwordItem.createAttributeModifiers(ModToolMaterials.NUTRILLARN, 4, -2.2F)
			)));
	//# Miscellaneous #
	public static final Item ENCHANTED_CHEESE_WHEEL = register("enchanted_cheese_wheel",
			new EnchantedCheeseWheelItem(fireproofItemSettings()
					.maxDamage(72).rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item NUTRILLARN_COMPASS = register("nutrillarn_compass",
			new NutrillarnCompassItem(fireproofItemSettings(64).food(FoodComponents.NUTRILLARN_COMPASS)));
	public static final Item ORB_OF_ZOT = register("orb_of_zot",
			new OrbOfZotItem(fireproofItemSettings(1).rarity(Rarity.EPIC)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	//endregion
	
	//region ## Foods ##
	//# Basic (cooked) #
	//# Basic (raw) #
	//# Miscellaneous #
	public static final Item CHOCOLATE_BAR = register("chocolate_bar",
			newItem(64, itemSettings().food(FoodComponents.CHOCOLATE_BAR)));
	//endregion
}
