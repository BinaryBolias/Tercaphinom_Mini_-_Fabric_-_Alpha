package binarybolias.tercaphinom.references;

import net.minecraft.block.DoorBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

import static binarybolias.tercaphinom.references.Reference.identifier;
import static binarybolias.tercaphinom.references.Reference.log;


/**
 * Relevant references:
 * {@link net.minecraft.item.Items}
 */

public class ModItems {
	public ModItems() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering items");
	}
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, identifier(name), item);
	}
	
	private static Item newItem(int maxCount) {
		return new Item(new Item.Settings().maxCount(maxCount));
	}
	
	private static Item newItem(int maxCount, Item.Settings settings) {
		return new Item(new Item.Settings().maxCount(maxCount));
	}
	
	//### Items ###
	//region ## Basic Resources ##
	// # Ball (yarn) #
	public static final Item BLACK_YARNBALL = registerItem("black_yarnball", newItem(64));
	public static final Item BLUE_YARNBALL = registerItem("blue_yarnball", newItem(64));
	public static final Item BROWN_YARNBALL = registerItem("brown_yarnball", newItem(64));
	public static final Item CYAN_YARNBALL = registerItem("cyan_yarnball", newItem(64));
	public static final Item GRAY_YARNBALL = registerItem("gray_yarnball", newItem(64));
	public static final Item GREEN_YARNBALL = registerItem("green_yarnball", newItem(64));
	public static final Item LIGHT_BLUE_YARNBALL = registerItem("light_blue_yarnball", newItem(64));
	public static final Item LIGHT_GRAY_YARNBALL = registerItem("light_gray_yarnball", newItem(64));
	public static final Item LIME_YARNBALL = registerItem("lime_yarnball", newItem(64));
	public static final Item MAGENTA_YARNBALL = registerItem("magenta_yarnball", newItem(64));
	public static final Item ORANGE_YARNBALL = registerItem("orange_yarnball", newItem(64));
	public static final Item PINK_YARNBALL = registerItem("pink_yarnball", newItem(64));
	public static final Item PURPLE_YARNBALL = registerItem("purple_yarnball", newItem(64));
	public static final Item RED_YARNBALL = registerItem("red_yarnball", newItem(64));
	public static final Item WHITE_YARNBALL = registerItem("white_yarnball", newItem(64));
	public static final Item YELLOW_YARNBALL = registerItem("yellow_yarnball", newItem(64));
	// # Ball (miscellaneous) #
	public static final Item COBWEB_BALL = registerItem("cobweb_ball", newItem(64)); // TODO: Add projectile.
	// # Brick #
	public static final Item STIEFANE_BRICK = registerItem("stiefane_brick", new Item(brickSettings()));
	// # Cobblestone #
	public static final Item STIEFANE_COBBLESTONE = registerItem("stiefane_cobblestone", new Item(cobblestoneSettings()));
	// # Gram & Ingot #
	public static final Item COPPER_GRAM = registerItem("copper_gram", newItem(96));
	public static final Item GOLD_GRAM = registerItem("gold_gram", newItem(96));
	public static final Item IRON_GRAM = registerItem("iron_gram", newItem(96));
	// # Jewel #
	// # Log & Trunk #
	public static final Item VERDAK_LOG = registerItem("verdak_log", new BlockItem(ModBlocks.VERDAK_LOG,
			new Item.Settings().maxCount(12)));
	// # Lump & Nugget #
	public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", newItem(96));
	public static final Item SULPHUR_LUMP = registerItem("sulphur_lump", newItem(64));
	// # Pile (seed) #
	// # Pile (miscellaneous) #
	public static final Item ASH_PILE = registerItem("ash_pile", newItem(96));
	public static final Item DIRT_PILE = registerItem("dirt_pile", newItem(64));
	public static final Item FELDSAND_PILE = registerItem("feldsand_pile", newItem(64));
	public static final Item FERROSAND_PILE = registerItem("ferrosand_pile", newItem(64));
	public static final Item FREEZE_POWDER_PILE = registerItem("freeze_powder_pile", newItem(96));
	public static final Item GRAVEL_PILE = registerItem("gravel_pile", newItem(64));
	public static final Item SKORSAND_PILE = registerItem("skorsand_pile", newItem(64));
	// # Plank #
	public static final Item ACACIA_PLANK = registerItem("acacia_plank", new Item(plankSettings()));
	public static final Item BIRCH_PLANK = registerItem("birch_plank", new Item(plankSettings()));
	public static final Item CHERRY_PLANK = registerItem("cherry_plank", new Item(plankSettings()));
	public static final Item CRIMSON_PLANK = registerItem("crimson_plank", new Item(plankSettings()));
	public static final Item DARK_OAK_PLANK = registerItem("dark_oak_plank", new Item(plankSettings()));
	public static final Item MAHOGANY_PLANK = registerItem("mahogany_plank", new Item(plankSettings()));
	public static final Item MANGROVE_PLANK = registerItem("mangrove_plank", new Item(plankSettings()));
	public static final Item OAK_PLANK = registerItem("oak_plank", new Item(plankSettings()));
	public static final Item SPRUCE_PLANK = registerItem("spruce_plank", new Item(plankSettings()));
	public static final Item VERDAK_PLANK = registerItem("verdak_plank", new Item(plankSettings()));
	public static final Item WARPED_PLANK = registerItem("warped_plank", new Item(plankSettings()));
	// # Bundle & Rod & Stick #
	public static final Item DYNAMITE_BUNDLE = registerItem("dynamite_bundle", newItem(64));
	public static final Item DYNAMITE_STICK = registerItem("dynamite_stick", newItem(96));
	public static final Item FREEZE_ROD = registerItem("freeze_rod", newItem(64));
	public static final Item WOODEN_STICK_BUNDLE = registerItem("wooden_stick_bundle", newItem(64));
	// # Shard #
	public static final Item GLASS_SHARD = registerItem("glass_shard", newItem(96));
	public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", newItem(96));
	// # Miscellaneous #
	public static final Item CHEESE_WHEEL = registerItem("cheese_wheel", newItem(24)); // TODO: Add edibility.
	public static final Item GRASS_TUFT = registerItem("grass_tuft", newItem(96)); // TODO: Add edibility.
	public static final Item SILK_WAD = registerItem("silk_wad", newItem(96));
	public static final Item STONE_PEBBLE = registerItem("stone_pebble", newItem(96));
	//endregion
	
	// NOTE:
	//  - Tools have a base 4 attack speed.
	//region  ## Equipment ##
	//# [Tier 0] Wooden Stick #
	public static final Item SHARP_WOODEN_STICK = registerItem("sharp_wooden_stick",
			new PickaxeItem(ModToolMaterials.WOODEN_STICK, new Item.Settings()
//					.maxDamage(15) // Trying to use default instead...
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ModToolMaterials.WOODEN_STICK, 2, -1.4F))
			));
	//# [Tier 1] Wood #
	//# [Tier 2] Flint #
	public static final Item FLINT_DAGGER = registerItem("flint_dagger",
			new SwordItem(ModToolMaterials.FLINT, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.FLINT, 3, -1.4F))
			));
	public static final Item FLINT_HATCHET = registerItem("flint_hatchet",
			new AxeItem(ModToolMaterials.FLINT, new Item.Settings() // TODO: Use a custom 'HatchetIem' class instead.
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.FLINT, 6.0F, -2.1F))
			));
	public static final Item FLINT_HOE = registerItem("flint_hoe",
			new HoeItem(ModToolMaterials.FLINT, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.FLINT, -2.0F, -1.0F))
			));
	public static final Item FLINT_SPEAR = registerItem("flint_spear",
			new SwordItem(ModToolMaterials.FLINT, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.FLINT, 4, -2.0F))
			));
	//# [Tier 2] Glass #
	public static final Item GLASS_DAGGER = registerItem("glass_dagger",
			new SwordItem(ModToolMaterials.GLASS, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.GLASS, 3, -1.4F))
			));
	public static final Item GLASS_HATCHET = registerItem("glass_hatchet",
			new AxeItem(ModToolMaterials.GLASS, new Item.Settings() // TODO: Use a custom 'HatchetIem' class instead.
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.GLASS, 6.0F, -2.1F))
			));
	public static final Item GLASS_HOE = registerItem("glass_hoe",
			new HoeItem(ModToolMaterials.GLASS, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.GLASS, -2.0F, -1.0F))
			));
	public static final Item GLASS_SPEAR = registerItem("glass_spear",
			new SwordItem(ModToolMaterials.GLASS, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.GLASS, 4, -2.0F))
			));
	//# [Tier 2] Obsidian #
	public static final Item OBSIDIAN_DAGGER = registerItem("obsidian_dagger",
			new SwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, 3, -1.4F))
			));
	public static final Item OBSIDIAN_HATCHET = registerItem("obsidian_hatchet",
			new AxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings() // TODO: Use a custom 'HatchetIem' class instead.
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, 6.0F, -2.1F))
			));
	public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
			new HoeItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, -2.0F, -1.0F))
			));
	public static final Item OBSIDIAN_SPEAR = registerItem("obsidian_spear",
			new SwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, 4, -2.0F))
			));
	//# [Tier 3] Brass #
//	public static final Item BRASS_SWORD = registerItem("brass_sword",
//			new SwordItem(ModToolMaterials.BRASS, new Item.Settings()
//					.attributeModifiers(SwordItem.createAttributeModifiers(
//							ModToolMaterials.BRASS, 3, -2.2F))
//			));
//	public static final Item BRASS_SHOVEL = registerItem("brass_shovel",
//			new ShovelItem(ModToolMaterials.BRASS, new Item.Settings()
//					.attributeModifiers(ShovelItem.createAttributeModifiers(
//							ModToolMaterials.BRASS, 1.5F, -2.8F))
//			));
//	public static final Item BRASS_PICKAXE = registerItem("brass_pickaxe",
//			new PickaxeItem(ModToolMaterials.BRASS, new Item.Settings()
//					.attributeModifiers(PickaxeItem.createAttributeModifiers(
//							ModToolMaterials.BRASS, 1.0F, -2.6F))
//			));
//	public static final Item BRASS_AXE = registerItem("brass_axe",
//			new AxeItem(ModToolMaterials.BRASS, new Item.Settings()
//					.attributeModifiers(AxeItem.createAttributeModifiers(
//							ModToolMaterials.BRASS, 6.0F, -2.9F))
//			));
//	public static final Item BRASS_HOE = registerItem("brass_hoe",
//			new HoeItem(ModToolMaterials.BRASS, new Item.Settings()
//					.attributeModifiers(HoeItem.createAttributeModifiers(
//							ModToolMaterials.BRASS, -2.0F, -0.8F))
//			));
	//# [Tier 3] Copper #
//	public static final Item COPPER_SWORD = registerItem("copper_sword",
//			new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
//					.attributeModifiers(SwordItem.createAttributeModifiers(
//							ModToolMaterials.COPPER, 3, -2.4F))
//			));
//	public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
//			new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
//					.attributeModifiers(ShovelItem.createAttributeModifiers(
//							ModToolMaterials.COPPER, 1.5F, -3.0F))
//			));
//	public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
//			new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
//					.attributeModifiers(PickaxeItem.createAttributeModifiers(
//							ModToolMaterials.COPPER, 1.0F, -2.8F))
//			));
//	public static final Item COPPER_AXE = registerItem("copper_axe",
//			new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
//					.attributeModifiers(AxeItem.createAttributeModifiers(
//							ModToolMaterials.COPPER, 6.0F, -3.1F))
//			));
//	public static final Item COPPER_HOE = registerItem("copper_hoe",
//			new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
//					.attributeModifiers(HoeItem.createAttributeModifiers(
//							ModToolMaterials.COPPER, -2.0F, -1.0F))
//			));
	//# [Tier 3] Eiduril #
	//# [Tier 3] Gold #
	//# [Tier 3] Iron #
	//endregion
	
	//region  ## Joke & Unserious ##
	//# Cheese # // TODO: Add edibility for cheese wedges.
	public static final Item BLUE_CHEESE_WEDGE = registerItem("blue_cheese_wedge", newItem(64));
	public static final Item SILKY_SMOOTH_CHEESE_WEDGE = registerItem("silky_smooth_cheese_wedge", newItem(64));
	public static final Item YELLOW_CHEESE_WEDGE = registerItem("yellow_cheese_wedge", newItem(64));
	//# Miscellaneous #
	public static final Item ENCHANTED_BRICK = registerItem("enchanted_brick",
			new Item(new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item MINIWIZARD = registerItem("miniwizard",
			new Item(new Item.Settings().maxCount(16).rarity(Rarity.RARE).fireproof()
					.food(FoodComponents.ENCHANTED_GOLDEN_APPLE))); // TODO: Create a new food type for Miniwizard.
	//endregion
	
	
	private static Item.Settings brickSettings() {
		return new Item.Settings().maxCount(32);
	}
	private static Item.Settings cobblestoneSettings() {
		return new Item.Settings().maxCount(48);
	}
	private static Item.Settings plankSettings() {
		return new Item.Settings().maxCount(64);
	}
}
