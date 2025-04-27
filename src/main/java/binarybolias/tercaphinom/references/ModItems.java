package binarybolias.tercaphinom.references;

import net.minecraft.block.DoorBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
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
	
	
	private static Item newMetalArmorItem(
			RegistryEntry<ArmorMaterial> armorMaterial, ArmorItem.Type armorType,
			int maxDamageMultiplier, Item.Settings settings
	) {
		return new ArmorItem(armorMaterial, armorType,
				settings.maxDamage(armorType.getMaxDamage(maxDamageMultiplier)).fireproof()
		);
	}
	
	
	private static Item newFireproofItem(int maxCount) {
		return newFireproofItem(itemSettings().maxCount(maxCount));
	}
	
	private static Item newFireproofItem(Item.Settings settings) {
		return newItem(settings.fireproof());
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
	public static final Item STIEFANE_BRICK = registerItem("stiefane_brick", newItem(brickSettings()));
	// # Cobblestone #
	public static final Item STIEFANE_COBBLESTONE = registerItem("stiefane_cobblestone", newItem(cobblestoneSettings()));
	// # Gram & Ingot #
	public static final Item BRASS_GRAM = registerItem("brass_gram", newFireproofItem(96));
	public static final Item BRASS_INGOT = registerItem("brass_ingot", newFireproofItem(64));
	public static final Item COPPER_GRAM = registerItem("copper_gram", newFireproofItem(96));
	public static final Item GOLD_GRAM = registerItem("gold_gram", newFireproofItem(96));
	public static final Item IRON_GRAM = registerItem("iron_gram", newFireproofItem(96));
	// # Jewel #
	// # Log & Trunk #
	public static final Item VERDAK_LOG = registerItem("verdak_log", new BlockItem(ModBlocks.VERDAK_LOG,
			new Item.Settings().maxCount(12)));
	public static final Item VERDAK_TRUNK = registerItem("verdak_trunk", new BlockItem(ModBlocks.VERDAK_TRUNK,
			new Item.Settings().maxCount(12)));
	// # Lump & Nugget #
	public static final Item RAW_BRASS_LUMP = registerItem("raw_brass_lump", newFireproofItem(64));
	public static final Item RAW_BRASS_NUGGET = registerItem("raw_brass_nugget", newFireproofItem(96));
	public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", newFireproofItem(96));
	public static final Item SULPHUR_LUMP = registerItem("sulphur_lump", newFireproofItem(64));
	// # Pile (seed) #
	// # Pile (miscellaneous) #
	public static final Item ASH_PILE = registerItem("ash_pile", new BoneMealItem(itemSettings().maxCount(96).fireproof()));
	public static final Item DIRT_PILE = registerItem("dirt_pile", newFireproofItem(64));
	public static final Item FELDSAND_PILE = registerItem("feldsand_pile", newFireproofItem(64));
	public static final Item FERROSAND_PILE = registerItem("ferrosand_pile", newFireproofItem(64));
	public static final Item FREEZE_POWDER_PILE = registerItem("freeze_powder_pile", newItem(96));
	public static final Item GRAVEL_PILE = registerItem("gravel_pile", newFireproofItem(64));
	public static final Item SKORSAND_PILE = registerItem("skorsand_pile", newFireproofItem(64));
	// # Plank #
	public static final Item ACACIA_PLANK = registerItem("acacia_plank", newItem(plankSettings()));
	public static final Item BIRCH_PLANK = registerItem("birch_plank", newItem(plankSettings()));
	public static final Item CHERRY_PLANK = registerItem("cherry_plank", newItem(plankSettings()));
	public static final Item CRIMSON_PLANK = registerItem("crimson_plank", newItem(plankSettings()));
	public static final Item DARK_OAK_PLANK = registerItem("dark_oak_plank", newItem(plankSettings()));
	public static final Item MAHOGANY_PLANK = registerItem("mahogany_plank", newItem(plankSettings()));
	public static final Item MANGROVE_PLANK = registerItem("mangrove_plank", newItem(plankSettings()));
	public static final Item OAK_PLANK = registerItem("oak_plank", newItem(plankSettings()));
	public static final Item SPRUCE_PLANK = registerItem("spruce_plank", newItem(plankSettings()));
	public static final Item VERDAK_PLANK = registerItem("verdak_plank", newItem(plankSettings()));
	public static final Item WARPED_PLANK = registerItem("warped_plank", newItem(plankSettings()));
	// # Bundle & Rod & Stick #
	public static final Item DYNAMITE_BUNDLE = registerItem("dynamite_bundle", newItem(64));
	public static final Item DYNAMITE_STICK = registerItem("dynamite_stick", newItem(96));
	public static final Item FREEZE_ROD = registerItem("freeze_rod", newItem(64));
	public static final Item WOODEN_STICK_BUNDLE = registerItem("wooden_stick_bundle", newItem(64));
	// # Shard #
	public static final Item GLASS_SHARD = registerItem("glass_shard", newFireproofItem(96));
	public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", newFireproofItem(96));
	// # Miscellaneous #
	public static final Item CHEESE_WHEEL = registerItem("cheese_wheel", newItem(itemSettings().maxCount(24).food(FoodComponents.BREAD))); // TODO: Make unique food component.
	public static final Item GRASS_TUFT = registerItem("grass_tuft", newItem(itemSettings().maxCount(96).food(FoodComponents.DRIED_KELP))); // TODO: Make unique food component.
	public static final Item SILK_WAD = registerItem("silk_wad", newItem(96));
	public static final Item STONE_PEBBLE = registerItem("stone_pebble", newFireproofItem(96));
	//endregion
	
	//region ## Containers ##
	//# Bottle #
	//# Bowl #
	//# Bucket #
	//endregion
	
	//region  ## Equipment ##
	// Equipment notes:
	//  - Tools have a base 4 attack speed.
	//# [Tier 0] Wooden Stick #
	public static final Item SHARP_WOODEN_STICK = registerItem("sharp_wooden_stick",
			new PickaxeItem(ModToolMaterials.WOODEN_STICK, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
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
							ModToolMaterials.FLINT, 5, -2.1F))
			));
	public static final Item FLINT_HOE = registerItem("flint_hoe",
			new HoeItem(ModToolMaterials.FLINT, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.FLINT, 2, -2.6F))
			));
	public static final Item FLINT_SPEAR = registerItem("flint_spear",
			new SwordItem(ModToolMaterials.FLINT, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.FLINT, 5, -2.3F))
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
							ModToolMaterials.GLASS, 5, -2.1F))
			));
	public static final Item GLASS_HOE = registerItem("glass_hoe",
			new HoeItem(ModToolMaterials.GLASS, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.GLASS, 2, -2.6F))
			));
	public static final Item GLASS_SPEAR = registerItem("glass_spear",
			new SwordItem(ModToolMaterials.GLASS, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.GLASS, 5, -2.3F))
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
							ModToolMaterials.OBSIDIAN, 5, -2.1F))
			));
	public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
			new HoeItem(ModToolMaterials.OBSIDIAN, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, 2, -2.6F))
			));
	public static final Item OBSIDIAN_SPEAR = registerItem("obsidian_spear",
			new SwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.OBSIDIAN, 5, -2.3F))
			));
	//# [Tier 3] Brass (armor) #
	public static final Item BRASS_BOOT_PAIR = registerItem("brass_boot_pair",
			newMetalArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.BOOTS, 16, itemSettings()
			));
	public static final Item BRASS_CHESTPLATE = registerItem("brass_chestplate",
			newMetalArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.CHESTPLATE, 16, itemSettings()
			));
	public static final Item BRASS_HELMET = registerItem("brass_helmet",
			newMetalArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.HELMET, 16, itemSettings()
			));
	public static final Item BRASS_LEGGING_PAIR = registerItem("brass_legging_pair",
			newMetalArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.LEGGINGS, 16, itemSettings()
			));
	//# [Tier 3] Brass (tools) #
	public static final Item BRASS_AXE = registerItem("brass_axe",
			new AxeItem(ModToolMaterials.BRASS, new Item.Settings()
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 6, -2.9F))
			));
	public static final Item BRASS_DAGGER = registerItem("brass_dagger",
			new SwordItem(ModToolMaterials.BRASS, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 3, -1.4F))
			));
	public static final Item BRASS_HATCHET = registerItem("brass_hatchet",
			new AxeItem(ModToolMaterials.BRASS, new Item.Settings() // TODO: Use a custom 'HatchetIem' class instead.
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 5, -2.1F))
			));
	public static final Item BRASS_HOE = registerItem("brass_hoe",
			new HoeItem(ModToolMaterials.BRASS, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 2, -2.6F))
			));
	public static final Item BRASS_MALLET = registerItem("brass_mallet",
			new PickaxeItem(ModToolMaterials.BRASS, new Item.Settings() // TODO: Use a custom 'MalletIem' class instead.
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 3, -3.0F))
			));
	public static final Item BRASS_PICKAXE = registerItem("brass_pickaxe",
			new PickaxeItem(ModToolMaterials.BRASS, new Item.Settings()
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 3, -3.0F))
			));
	public static final Item BRASS_SHOVEL = registerItem("brass_shovel",
			new ShovelItem(ModToolMaterials.BRASS, new Item.Settings()
					.attributeModifiers(ShovelItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 2, -2.8F))
			));
	public static final Item BRASS_SPEAR = registerItem("brass_spear",
			new SwordItem(ModToolMaterials.BRASS, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 5, -2.3F))
			));
	public static final Item BRASS_SWORD = registerItem("brass_sword",
			new SwordItem(ModToolMaterials.BRASS, new Item.Settings()
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.BRASS, 4, -2.2F))
			));
	//# [Tier 3] Copper (armor) #
	public static final Item COPPER_BOOT_PAIR = registerItem("copper_boot_pair",
			newMetalArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, 14, itemSettings()
			));
	public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
			newMetalArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, 14, itemSettings()
			));
	public static final Item COPPER_HELMET = registerItem("copper_helmet",
			newMetalArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, 14, itemSettings()
			));
	public static final Item COPPER_LEGGING_PAIR = registerItem("copper_legging_pair",
			newMetalArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, 14, itemSettings()
			));
	//# [Tier 3] Copper (tools) #
	public static final Item COPPER_AXE = registerItem("copper_axe",
			new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 6, -3.1F))
			));
	public static final Item COPPER_DAGGER = registerItem("copper_dagger",
			new SwordItem(ModToolMaterials.COPPER, new Item.Settings() // TODO: Use a custom 'DaggerIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 3, -1.6F))
			));
	public static final Item COPPER_HATCHET = registerItem("copper_hatchet",
			new AxeItem(ModToolMaterials.COPPER, new Item.Settings() // TODO: Use a custom 'HatchetIem' class instead.
					.attributeModifiers(AxeItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 5, -2.3F))
			));
	public static final Item COPPER_HOE = registerItem("copper_hoe",
			new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
					.attributeModifiers(HoeItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 2, -2.8F))
			));
	public static final Item COPPER_MALLET = registerItem("copper_mallet",
			new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings() // TODO: Use a custom 'MalletIem' class instead.
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 3, -3.2F))
			));
	public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
			new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 3, -3.2F))
			));
	public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
			new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
					.attributeModifiers(ShovelItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 2, -3.0F))
			));
	public static final Item COPPER_SPEAR = registerItem("copper_spear",
			new SwordItem(ModToolMaterials.COPPER, new Item.Settings() // TODO: Use a custom 'SpearIem' class instead.
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 5, -2.5F))
			));
	public static final Item COPPER_SWORD = registerItem("copper_sword",
			new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
					.attributeModifiers(SwordItem.createAttributeModifiers(
							ModToolMaterials.COPPER, 4, -2.4F))
			));
	//# [Tier 3] Eiduril #
	//# [Tier 3] Gold #
	//# [Tier 3] Iron #
	//# Miscellaneous #
	//endregion
	
	
	//region  ### Joke & Unserious Items ###
	
	//## (J&U) Basic Resources ##
	//# Ball #
	public static final Item CHERRY_JELLYBALL = registerItem("cherry_jellyball",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.SWEET_BERRIES))); // TODO: Make unique food component.
	//# Brick #
	//# Cobblestone #
	//# Gram & Ingot #
	// TODO: Add unique food components for nutrillarn gram and ingot.
	public static final Item NUTRILLARN_GRAM = registerItem("nutrillarn_gram",
			newFireproofItem(itemSettings().maxCount(96).food(FoodComponents.SWEET_BERRIES)));
	public static final Item NUTRILLARN_INGOT = registerItem("nutrillarn_ingot",
			newFireproofItem(itemSettings().maxCount(64).food(FoodComponents.COOKED_BEEF)));
	//# Jewel #
	//# Log & Trunk #
	//# Lump & Nugget #
	// TODO: Add unique food components for nutrillarn lump and nugget.
	public static final Item RAW_NUTRILLARN_LUMP = registerItem("raw_nutrillarn_lump",
			newFireproofItem(itemSettings().maxCount(96).food(FoodComponents.COOKED_CHICKEN)));
	public static final Item RAW_NUTRILLARN_NUGGET = registerItem("raw_nutrillarn_nugget",
			newFireproofItem(itemSettings().maxCount(64).food(FoodComponents.DRIED_KELP)));
	//# Pile (seed) #
	//# Pile (miscellaneous) #
	public static final Item MILKLEAF_PILE = registerItem("milkleaf_pile",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.DRIED_KELP))); // TODO: Make unique food component.
	//# Plank #
	//# Bundle & Rod & Stick #
	//# Shard #
	//# Miscellaneous (cheese) #
	public static final Item BLUE_CHEESE_WEDGE = registerItem("blue_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.CARROT))); // TODO: Make unique food component.
	public static final Item SILKY_SMOOTH_CHEESE_WEDGE = registerItem("silky_smooth_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.CARROT))); // TODO: Make unique food component.
	public static final Item YELLOW_CHEESE_WEDGE = registerItem("yellow_cheese_wedge",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.CARROT))); // TODO: Make unique food component.
	//# Miscellaneous (miscellaneous) #
	public static final Item CHULK_BERRY = registerItem("chulk_berry",
			newItem(new Item.Settings().maxCount(64).food(FoodComponents.GLOW_BERRIES))); // TODO: Make unique food component.
	public static final Item ENCHANTED_BRICK = registerItem("enchanted_brick",
			new Item(new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item MINIWIZARD = registerItem("miniwizard",
			new Item(new Item.Settings().maxCount(16).rarity(Rarity.RARE).fireproof()
					.food(FoodComponents.ENCHANTED_GOLDEN_APPLE))); // TODO: Create a new food type for Miniwizard.
	public static final Item STARCHCAP_MUSHROOM = registerItem("starchcap_mushroom", // TODO: Make unique food component.
			new BlockItem(ModBlocks.STARCHCAP_MUSHROOM, itemSettings().maxCount(64).food(FoodComponents.POTATO)));
	
	//## (J&U) Equipment ##
	//# Nutrillarn #
	//# Miscellaneous #
	
	//endregion
	
	
	private static Item.Settings itemSettings() {
		return new Item.Settings();
	}
	
	private static Item.Settings brickSettings() {
		return new Item.Settings().maxCount(32).fireproof();
	}
	private static Item.Settings cobblestoneSettings() {
		return new Item.Settings().maxCount(48).fireproof();
	}
	private static Item.Settings plankSettings() {
		return new Item.Settings().maxCount(64);
	}
}
