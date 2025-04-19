package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModItemGroups {
	public ModItemGroups() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering item groups");
	}
	
	private static Text displayName(String groupIdentifier) {
		return translate("item_group." + groupIdentifier);
	}
	// NOTE: There has to be a better way! TODO: Find a way to create item groups more easily.
	public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_blocks_group"),
			FabricItemGroup.builder().displayName(displayName("blocks"))
					.icon(() -> new ItemStack(ModBlocks.ETERNALITH))
					.entries(((displayContext, entries) -> {
						// ## Crops & Foliage ##
						//# Leaf #
						//# Log & Trunk #
						entries.add(ModBlocks.VERDAK_LOG);
						entries.add(ModBlocks.VERDAK_TRUNK);
						//# Miscellaneous #
						
						// ## Elemental ##
						//# Mosaic & Plank #
						entries.add(ModBlocks.VERDAK_PLANK_BLOCK);
						//# Stone (brick) #
						entries.add(ModBlocks.STIEFANE_BRICK_BLOCK);
						//# Stone (cobbled) #
						entries.add(ModBlocks.COBBLED_STIEFANE_BLOCK);
						//# Stone (natural) #
						entries.add(ModBlocks.STIEFANE_BLOCK);
						//# Stone (polished) #
						entries.add(ModBlocks.POLISHED_STIEFANE_BLOCK);
						//# Miscellaneous #
						entries.add(ModBlocks.ASH_BLOCK);
						
						// ## Modified & Transitional ##
						// # Ore (netherrack) #
						// # Ore (stiefane) #
						entries.add(ModBlocks.STIEFANE_LAPIS_ORE);
						// # Ore (zygolith) #
						
						// ## Junction & Utility ##
						//# Button & Pressure Plate #
						entries.add(ModBlocks.STIEFANE_BUTTON);
						entries.add(ModBlocks.STIEFANE_PRESSURE_PLATE);
						entries.add(ModBlocks.VERDAK_BUTTON);
						entries.add(ModBlocks.VERDAK_PRESSURE_PLATE);
						//# Container & Workstation #
						//# Door & Hatch #
						entries.add(ModBlocks.VERDAK_DOOR);
						entries.add(ModBlocks.VERDAK_HATCH);
						//# Fence, Gate, & Wall #
						entries.add(ModBlocks.STIEFANE_BRICK_WALL_POST);
						entries.add(ModBlocks.VERDAK_FENCE_GATE);
						entries.add(ModBlocks.VERDAK_FENCE_POST);
						//# Ladder #
						//# Pane #
						//# Sign #
						//# Slab & Stair #
						entries.add(ModBlocks.STIEFANE_BRICK_SLAB);
						entries.add(ModBlocks.STIEFANE_BRICK_STAIR);
						entries.add(ModBlocks.VERDAK_PLANK_SLAB);
						entries.add(ModBlocks.VERDAK_PLANK_STAIR);
						//# Torch #
						
						//## Miscellaneous ##
						entries.add(ModBlocks.ETERNALITH);
						//# Miscellaneous #
						
						// ## Joke & Unserious ##
						//# Cheese #
						entries.add(ModBlocks.BLUE_CHEESE_BLOCK);
						entries.add(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
						entries.add(ModBlocks.YELLOW_CHEESE_BLOCK);
						//# Miscellaneous #
						entries.add(ModBlocks.HYPERSMOOTH_CREAMSTONE);
						entries.add(ModBlocks.ULTRASMOOTH_STONE);
						
					})).build());
	public static final ItemGroup EQUIPMENT = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "equipment_group"),
			FabricItemGroup.builder().displayName(displayName("equipment"))
					.icon(() -> new ItemStack(ModItems.SHARP_WOODEN_STICK))
					.entries(((displayContext, entries) -> {
						entries.add(ModItems.SHARP_WOODEN_STICK);
					})).build());
	public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_ingredients_group"),
			FabricItemGroup.builder().displayName(displayName("ingredients"))
					.icon(() -> new ItemStack(ModItems.OAK_PLANK))
					.entries(((displayContext, entries) -> {
						// ## Basic Resources ##
						//# Ball (yarn) #
						entries.add(ModItems.WHITE_YARNBALL);
						entries.add(ModItems.LIGHT_GRAY_YARNBALL);
						entries.add(ModItems.GRAY_YARNBALL);
						entries.add(ModItems.BLACK_YARNBALL);
						entries.add(ModItems.BROWN_YARNBALL);
						entries.add(ModItems.RED_YARNBALL);
						entries.add(ModItems.ORANGE_YARNBALL);
						entries.add(ModItems.YELLOW_YARNBALL);
						entries.add(ModItems.LIME_YARNBALL);
						entries.add(ModItems.GREEN_YARNBALL);
						entries.add(ModItems.CYAN_YARNBALL);
						entries.add(ModItems.LIGHT_BLUE_YARNBALL);
						entries.add(ModItems.BLUE_YARNBALL);
						entries.add(ModItems.PURPLE_YARNBALL);
						entries.add(ModItems.MAGENTA_YARNBALL);
						entries.add(ModItems.PINK_YARNBALL);
						//# Ball (miscellaneous) #
						entries.add(ModItems.COBWEB_BALL);
						//# Brick #
						entries.add(ModItems.STIEFANE_BRICK);
						//# Cobblestone #
						entries.add(ModItems.STIEFANE_COBBLESTONE);
						//# Gram & Ingot #
						entries.add(ModItems.COPPER_GRAM);
						entries.add(ModItems.GOLD_GRAM);
						entries.add(ModItems.IRON_GRAM);
						//# Lump & Nugget #
						entries.add(ModItems.RAW_COPPER_NUGGET);
						entries.add(ModItems.SULPHUR_LUMP);
						//# Pile (miscellaneous) #
						entries.add(ModItems.ASH_PILE);
						entries.add(ModItems.DIRT_PILE);
						entries.add(ModItems.GRAVEL_PILE);
						//# Plank #
						entries.add(ModItems.ACACIA_PLANK);
						entries.add(ModItems.BIRCH_PLANK);
						entries.add(ModItems.CHERRY_PLANK);
						entries.add(ModItems.CRIMSON_PLANK);
						entries.add(ModItems.DARK_OAK_PLANK);
						entries.add(ModItems.MAHOGANY_PLANK);
						entries.add(ModItems.MANGROVE_PLANK);
						entries.add(ModItems.OAK_PLANK);
						entries.add(ModItems.SPRUCE_PLANK);
						entries.add(ModItems.VERDAK_PLANK);
						entries.add(ModItems.WARPED_PLANK);
						//# Bundle & Rod & Stick #
						entries.add(ModItems.DYNAMITE_BUNDLE);
						entries.add(ModItems.DYNAMITE_STICK);
						entries.add(ModItems.WOODEN_STICK_BUNDLE);
						//# Shard #
						entries.add(ModItems.GLASS_SHARD);
						entries.add(ModItems.OBSIDIAN_SHARD);
						//# Miscellaneous #
						entries.add(ModItems.CHEESE_WHEEL);
						entries.add(ModItems.GRASS_TUFT);
						entries.add(ModItems.SILK_WAD);
						entries.add(ModItems.STONE_PEBBLE);
						
						//## Joke & Unserious ##
						//# Cheese #
						entries.add(ModItems.BLUE_CHEESE_WEDGE);
						entries.add(ModItems.SILKY_SMOOTH_CHEESE_WEDGE);
						entries.add(ModItems.YELLOW_CHEESE_WEDGE);
						//# Miscellaneous #
						entries.add(ModItems.ENCHANTED_BRICK);
						entries.add(ModItems.MINIWIZARD);
					})).build());
}
