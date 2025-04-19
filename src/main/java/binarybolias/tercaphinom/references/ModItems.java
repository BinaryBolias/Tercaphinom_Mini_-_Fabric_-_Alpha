package binarybolias.tercaphinom.references;

import net.minecraft.block.DoorBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

import static binarybolias.tercaphinom.references.Reference.identifier;
import static binarybolias.tercaphinom.references.Reference.log;

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
	
	/**
	 * Relevant references:
	 * {@link net.minecraft.item.Items}
	 */
	
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
	// # Lump & Nugget #
	public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", newItem(96));
	public static final Item SULPHUR_LUMP = registerItem("sulphur_lump", newItem(64));
	// # Pile (seed) #
	// # Pile (miscellaneous) #
	public static final Item ASH_PILE = registerItem("ash_pile", newItem(96));
	public static final Item DIRT_PILE = registerItem("dirt_pile", newItem(64));
	public static final Item GRAVEL_PILE = registerItem("gravel_pile", newItem(64));
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
	
	//region  ## Equipment ##
	//# [Tier 0] Wooden Stick #
	public static final Item SHARP_WOODEN_STICK = registerItem("sharp_wooden_stick",
			new PickaxeItem(ToolMaterials.WOOD, new Item.Settings().maxDamage(15)
					.attributeModifiers(PickaxeItem.createAttributeModifiers(
							ToolMaterials.WOOD, 2, -2.4F))
			));
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
