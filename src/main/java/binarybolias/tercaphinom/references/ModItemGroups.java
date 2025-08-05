package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.SuspiciousStewIngredient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemStackSet;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Set;

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
	
	public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_blocks_group"),
			FabricItemGroup.builder().displayName(displayName("blocks"))
					.icon(() -> new ItemStack(ModBlocks.ETERNALITH_BLOCK))
					.entries(((displayContext, entries) -> {
						// ## Crops & Foliage ##
						//# Leaf #
						//# Log & Trunk #
						entries.add(ModItems.VERDAK_LOG);
						entries.add(ModItems.VERDAK_TRUNK);
						//# Miscellaneous #
						
						// ## Elemental ##
						//# Metal #
						entries.add(ModBlocks.RAW_BRASS_BLOCK);
						entries.add(ModBlocks.RAW_EIDURIL_BLOCK);
						entries.add(ModBlocks.REFINED_BRASS_BLOCK);
						entries.add(ModBlocks.REFINED_EIDURIL_BLOCK);
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
						entries.add(ModBlocks.SKORSAND_BLOCK);
						
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
						entries.add(ModBlocks.VERDAK_GATE);
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
						entries.add(ModBlocks.ETERNALITH_BLOCK);
						//# Miscellaneous #
						
						//### Joke & Unserious ###
						//## (J&U) Elemental #
						//# Cheese #
						entries.add(ModBlocks.BLUE_CHEESE_BLOCK);
						entries.add(ModBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
						entries.add(ModBlocks.YELLOW_CHEESE_BLOCK);
						//# Metal #
						entries.add(ModBlocks.RAW_NUTRILLARN_BLOCK);
						entries.add(ModBlocks.REFINED_NUTRILLARN_BLOCK);
						//# Miscellaneous #
						entries.add(ModBlocks.HYPERSMOOTH_CREAMSTONE);
						entries.add(ModBlocks.ULTRASMOOTH_STONE);
					})).build());
	public static final ItemGroup EQUIPMENT = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_equipment_group"),
			FabricItemGroup.builder().displayName(displayName("equipment"))
					.icon(() -> new ItemStack(ModItems.SHARP_WOODEN_STICK))
					.entries(((displayContext, entries) -> {
						//# [Tier 0] Wooden Stick #
						entries.add(ModItems.SHARP_WOODEN_STICK);
						//# [Tier 1] Wood #
						entries.add(ModItems.WOODEN_DAGGER);
						entries.add(ModItems.WOODEN_MALLET);
						entries.add(ModItems.WOODEN_SHOVEL);
						entries.add(ModItems.WOODEN_SPEAR);
						entries.add(ModItems.WOODEN_SWORD);
						//# [Tier 2] Flint #
						entries.add(ModItems.FLINT_DAGGER);
						entries.add(ModItems.FLINT_HATCHET);
						entries.add(ModItems.FLINT_HOE);
						entries.add(ModItems.FLINT_SPEAR);
						//# [Tier 2] Glass #
						entries.add(ModItems.GLASS_DAGGER);
						entries.add(ModItems.GLASS_HATCHET);
						entries.add(ModItems.GLASS_HOE);
						entries.add(ModItems.GLASS_SPEAR);
						//# [Tier 2] Obsidian #
						entries.add(ModItems.OBSIDIAN_DAGGER);
						entries.add(ModItems.OBSIDIAN_HATCHET);
						entries.add(ModItems.OBSIDIAN_HOE);
						entries.add(ModItems.OBSIDIAN_SPEAR);
						//# [Tier 3] Brass (armor) #
						entries.add(ModItems.BRASS_BOOT_PAIR);
						entries.add(ModItems.BRASS_CHESTPLATE);
						entries.add(ModItems.BRASS_HELMET);
						entries.add(ModItems.BRASS_HORSE_HARNESS);
						entries.add(ModItems.BRASS_LEGGING_PAIR);
						//# [Tier 3] Brass (tools) #
						entries.add(ModItems.BRASS_AXE);
						entries.add(ModItems.BRASS_DAGGER);
						entries.add(ModItems.BRASS_HATCHET);
						entries.add(ModItems.BRASS_HOE);
						entries.add(ModItems.BRASS_MALLET);
						entries.add(ModItems.BRASS_PICKAXE);
						entries.add(ModItems.BRASS_SHOVEL);
						entries.add(ModItems.BRASS_SPEAR);
						entries.add(ModItems.BRASS_SWORD);
						//# [Tier 3] Copper (armor) #
						entries.add(ModItems.COPPER_BOOT_PAIR);
						entries.add(ModItems.COPPER_CHESTPLATE);
						entries.add(ModItems.COPPER_HELMET);
						entries.add(ModItems.COPPER_HORSE_HARNESS);
						entries.add(ModItems.COPPER_LEGGING_PAIR);
						//# [Tier 3] Copper (tools) #
						entries.add(ModItems.COPPER_AXE);
						entries.add(ModItems.COPPER_DAGGER);
						entries.add(ModItems.COPPER_HATCHET);
						entries.add(ModItems.COPPER_HOE);
						entries.add(ModItems.COPPER_MALLET);
						entries.add(ModItems.COPPER_PICKAXE);
						entries.add(ModItems.COPPER_SHOVEL);
						entries.add(ModItems.COPPER_SPEAR);
						entries.add(ModItems.COPPER_SWORD);
						//# [Tier 3] Eiduril (armor) #
						entries.add(ModItems.EIDURIL_BOOT_PAIR);
						entries.add(ModItems.EIDURIL_CHESTPLATE);
						entries.add(ModItems.EIDURIL_HELMET);
						entries.add(ModItems.EIDURIL_HORSE_HARNESS);
						entries.add(ModItems.EIDURIL_LEGGING_PAIR);
						//# [Tier 3] Eiduril (tools) #
						entries.add(ModItems.EIDURIL_AXE);
						entries.add(ModItems.EIDURIL_DAGGER);
						entries.add(ModItems.EIDURIL_HATCHET);
						entries.add(ModItems.EIDURIL_HOE);
						entries.add(ModItems.EIDURIL_MALLET);
						entries.add(ModItems.EIDURIL_PICKAXE);
						entries.add(ModItems.EIDURIL_SHOVEL);
						entries.add(ModItems.EIDURIL_SPEAR);
						entries.add(ModItems.EIDURIL_SWORD);
						//# [Tier 3] Gold (armor) #
						//# [Tier 3] Gold (tools) #
						entries.add(ModItems.GOLDEN_DAGGER);
						entries.add(ModItems.GOLDEN_HATCHET);
						entries.add(ModItems.GOLDEN_MALLET);
						entries.add(ModItems.GOLDEN_SPEAR);
						//# [Tier 3] Iron (armor) #
						//# [Tier 3] Iron (tools) #
						entries.add(ModItems.IRON_DAGGER);
						entries.add(ModItems.IRON_HATCHET);
						entries.add(ModItems.IRON_MALLET);
						entries.add(ModItems.IRON_SPEAR);
						//# Miscellaneous #
						entries.add(ModItems.SPATIAL_RECALL_STONE);
						entries.add(ModItems.TARGET_TELEPORTATION_TUNER);
						
						//region ### Joke & Unserious ###
						//## (J&U) Equipment ##
						//# Nutrillarn Armor #
						entries.add(ModItems.NUTRILLARN_BOOT_PAIR);
						entries.add(ModItems.NUTRILLARN_CHESTPLATE);
						entries.add(ModItems.NUTRILLARN_HELMET);
						entries.add(ModItems.NUTRILLARN_HORSE_HARNESS);
						entries.add(ModItems.NUTRILLARN_JELLYBOOT_PAIR);
						entries.add(ModItems.NUTRILLARN_LEGGING_PAIR);
						//# Nutrillarn Tools #
						entries.add(ModItems.NUTRILLARN_AXE);
						entries.add(ModItems.NUTRILLARN_DAGGER);
						entries.add(ModItems.NUTRILLARN_HATCHET);
						entries.add(ModItems.NUTRILLARN_HOE);
						entries.add(ModItems.NUTRILLARN_MALLET);
						entries.add(ModItems.NUTRILLARN_PICKAXE);
						entries.add(ModItems.NUTRILLARN_SHOVEL);
						entries.add(ModItems.NUTRILLARN_SPEAR);
						entries.add(ModItems.NUTRILLARN_SWORD);
						//# Miscellaneous #
						entries.add(ModItems.ENCHANTED_CHEESE_WHEEL);
						entries.add(ModItems.NUTRILLARN_COMPASS);
						entries.add(ModItems.ORB_OF_ZOT);
						//endregion
					})).build());
	public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_ingredients_group"),
			FabricItemGroup.builder().displayName(displayName("ingredients"))
					.icon(() -> new ItemStack(ModItems.OAK_PLANK))
					.entries(((displayContext, entries) -> {
						//region ## Basic Resources ##
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
						entries.add(ModItems.RAW_COOKIE_BALL);
						entries.add(ModItems.RAW_HONEYBUN_BALL);
						entries.add(ModItems.RAW_MAGMABUN_BALL);
						entries.add(ModItems.RAW_SLIMEBUN_BALL);
						//# Brick #
						entries.add(ModItems.STIEFANE_BRICK);
						//# Chunk #
						entries.add(ModItems.WARPED_FLESH_CHUNK);
						//# Cobblestone #
						entries.add(ModItems.STIEFANE_COBBLESTONE);
						//# Gram & Ingot #
						entries.add(ModItems.BRASS_GRAM);
						entries.add(ModItems.BRASS_INGOT);
						entries.add(ModItems.COPPER_GRAM);
						entries.add(ModItems.EIDURIL_GRAM);
						entries.add(ModItems.EIDURIL_INGOT);
						entries.add(ModItems.GOLD_GRAM);
						entries.add(ModItems.IRON_GRAM);
						//# Lump & Nugget (metal) #
						entries.add(ModItems.RAW_BRASS_LUMP);
						entries.add(ModItems.RAW_BRASS_NUGGET);
						entries.add(ModItems.RAW_COPPER_NUGGET);
						entries.add(ModItems.RAW_EIDURIL_LUMP);
						entries.add(ModItems.RAW_EIDURIL_NUGGET);
						//# Lump & Nugget (miscellaneous) #
						entries.add(ModItems.INFERNOCOAL_LUMP);
						entries.add(ModItems.RAW_DOUGH_LUMP);
						entries.add(ModItems.SULPHUR_LUMP);
						//# Pie (cooked) #
						entries.add(ModItems.APPLE_PIE);
						entries.add(ModItems.CHERRY_PIE);
						entries.add(ModItems.GLOWBERRY_PIE);
						entries.add(ModItems.PUMPKIN_PIE);
						entries.add(ModItems.SWEETBERRY_PIE);
						//# Pie (raw) #
						entries.add(ModItems.RAW_APPLE_PIE);
						entries.add(ModItems.RAW_CHERRY_PIE);
						entries.add(ModItems.RAW_GLOWBERRY_PIE);
						entries.add(ModItems.RAW_PUMPKIN_PIE);
						entries.add(ModItems.RAW_SWEETBERRY_PIE);
						//# Pile (seed) #
						//# Pile (miscellaneous) #
						entries.add(ModItems.ASH_PILE);
						entries.add(ModItems.DIRT_PILE);
						entries.add(ModItems.FELDSAND_PILE);
						entries.add(ModItems.FERROSAND_PILE);
						entries.add(ModItems.FREEZE_POWDER_PILE);
						entries.add(ModItems.GRAVEL_PILE);
						entries.add(ModItems.LEAF_PILE);
						entries.add(ModItems.SKORSAND_PILE);
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
						entries.add(ModItems.FREEZE_ROD);
						entries.add(ModItems.WOODEN_STICK_BUNDLE);
						//# Shard #
						entries.add(ModItems.GLASS_SHARD);
						entries.add(ModItems.OBSIDIAN_SHARD);
						//# Miscellaneous #
						entries.add(ModItems.BAKED_CARROT);
						entries.add(ModItems.BAKED_MUSHROOM);
						entries.add(ModItems.BAKED_RADISH);
						entries.add(ModItems.CHEESE_WHEEL);
						entries.add(ModItems.CHERRY_BUNCH);
						entries.add(ModItems.COOKED_BUGMEAT_STEAK);
						entries.add(ModItems.COOKED_MEAT_MORSEL);
						entries.add(ModItems.DRY_GRASS_TUFT);
						entries.add(ModItems.DRY_KELP_BUNDLE);
						entries.add(ModItems.FRIED_EGG);
						entries.add(ModItems.HONEYBUN);
						entries.add(ModItems.LIVE_GRASS_TUFT);
						entries.add(ModItems.MAGMABUN);
						entries.add(ModItems.PINECONE);
						entries.add(ModItems.RAW_BUGMEAT_STEAK);
						entries.add(ModItems.RAW_CAKE);
						entries.add(ModItems.RAW_MEAT_MORSEL);
						entries.add(ModItems.SILK_WAD);
						entries.add(ModItems.SLIMEBUN);
						entries.add(ModItems.STONE_PEBBLE);
						//endregion
						
						//region ## Containers ##
						//# Bottle (empty) #
						//# Bottle (filled) #
						entries.add(ModItems.BOTTLE_OF_BRIMWATER);
						entries.add(ModItems.BOTTLE_OF_FREEZEWATER);
						entries.add(ModItems.BOTTLE_OF_MILK);
						entries.add(ModItems.BOTTLE_OF_STEAMING_WATER);
						//# Bowl (empty) #
						//# Bowl (filled - soup) #
						entries.add(ModItems.BOWL_OF_CARROT_SOUP);
						entries.add(ModItems.BOWL_OF_KELP_SOUP);
						entries.add(ModItems.BOWL_OF_MUSHROOM_SOUP);
						entries.add(ModItems.BOWL_OF_POISONOUS_POTATO_SOUP);
						entries.add(ModItems.BOWL_OF_PORRIDGE);
						entries.add(ModItems.BOWL_OF_POTATO_SOUP);
						entries.add(ModItems.BOWL_OF_RADISH_SOUP);
						//# Bowl (filled - stew) #
						entries.add(ModItems.BOWL_OF_BEEF_STEW);
						entries.add(ModItems.BOWL_OF_BUGMEAT_STEW);
						entries.add(ModItems.BOWL_OF_CHICKEN_STEW);
						entries.add(ModItems.BOWL_OF_COD_STEW);
						entries.add(ModItems.BOWL_OF_MORSEL_STEW);
						entries.add(ModItems.BOWL_OF_MUTTON_STEW);
						entries.add(ModItems.BOWL_OF_PORK_STEW);
						entries.add(ModItems.BOWL_OF_RABBIT_STEW);
						entries.add(ModItems.BOWL_OF_SALMON_STEW);
						//# Bowl (filled - miscellaneous) #
						entries.add(ModItems.BOWL_OF_BRIMWATER);
						entries.add(ModItems.BOWL_OF_FREEZEWATER);
						entries.add(ModItems.BOWL_OF_HONEY);
						entries.add(ModItems.BOWL_OF_MILK);
						entries.add(ModItems.BOWL_OF_STEAMING_WATER);
						entries.add(ModItems.BOWL_OF_WATER);
						//# Bucket (empty) #
						//# Bucket (filled) #
						entries.add(ModItems.BUCKET_OF_BRIMWATER);
						entries.add(ModItems.BUCKET_OF_FERTILIZER);
						entries.add(ModItems.BUCKET_OF_FREEZEWATER);
						entries.add(ModItems.BUCKET_OF_HONEY);
						entries.add(ModItems.BUCKET_OF_STEAMING_WATER);
						//endregion
						
						//region ### Joke & Unserious ###
						
						//## (J&U) Basic Resources ##
						//# Ball #
						entries.add(ModItems.CHERRY_JELLYBALL);
						//# Gram & Ingot #
						entries.add(ModItems.NUTRILLARN_GRAM);
						entries.add(ModItems.NUTRILLARN_INGOT);
						//# Lump & Nugget #
						entries.add(ModItems.RAW_NUTRILLARN_LUMP);
						entries.add(ModItems.RAW_NUTRILLARN_NUGGET);
						//# Pile (seed) #
						//# Pile (miscellaneous) #
						entries.add(ModItems.MILKLEAF_PILE);
						//# Miscellaneous (cheese) #
						entries.add(ModItems.BLUE_CHEESE_WEDGE);
						entries.add(ModItems.SILKY_SMOOTH_CHEESE_WEDGE);
						entries.add(ModItems.YELLOW_CHEESE_WEDGE);
						//# Miscellaneous (miscellaneous) #
						entries.add(ModItems.CHOCOLATE_BAR);
						entries.add(ModItems.CHULK_BERRY_BUNCH);
						entries.add(ModItems.ENCHANTED_BRICK);
						entries.add(ModItems.HONEYPOD);
						entries.add(ModItems.STARCHCAP_MUSHROOM);
						
						entries.add(ModItems.MINIWIZARD);
						
						//## (J&U) Containers ##
						//# Bottle #
						//# Bowl #
						entries.add(ModItems.BOWL_OF_STONE_SOUP);
						//# Bucket #
						//endregion
					})).build());
	public static final ItemGroup FUELS_AND_INGESTIBLES = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_fuels_and_ingestibles_group"),
			FabricItemGroup.builder().displayName(displayName("fuels_and_ingestibles"))
					.icon(() -> new ItemStack(ModItems.DRY_KELP_BUNDLE))
					.entries(((displayContext, entries) -> {
						//region ## Fuels ##
						//# [1] Coals & Sulphur #
						entries.add(Items.CHARCOAL);
						entries.add(Items.COAL);
						entries.add(ModItems.SULPHUR_LUMP);
						entries.add(ModItems.INFERNOCOAL_LUMP);
						//# [2] Planks #
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
						//# [3] Wooden Stick & Bundle #
						entries.add(Items.STICK);
						entries.add(ModItems.WOODEN_STICK_BUNDLE);
						//# [4] Yarnballs #
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
						//# [5] Yarn Rolls #
						entries.add(Items.WHITE_CARPET);
						entries.add(Items.LIGHT_GRAY_CARPET);
						entries.add(Items.GRAY_CARPET);
						entries.add(Items.BLACK_CARPET);
						entries.add(Items.BROWN_CARPET);
						entries.add(Items.RED_CARPET);
						entries.add(Items.ORANGE_CARPET);
						entries.add(Items.YELLOW_CARPET);
						entries.add(Items.LIME_CARPET);
						entries.add(Items.GREEN_CARPET);
						entries.add(Items.CYAN_CARPET);
						entries.add(Items.LIGHT_BLUE_CARPET);
						entries.add(Items.BLUE_CARPET);
						entries.add(Items.PURPLE_CARPET);
						entries.add(Items.MAGENTA_CARPET);
						entries.add(Items.PINK_CARPET);
						//# [6] Miscellaneous #
						entries.add(ModItems.COBWEB_BALL);
						entries.add(ModItems.DRY_GRASS_TUFT);
						// TODO: Add Dry Moss Wad upon implementation.
						entries.add(ModItems.LEAF_PILE);
						entries.add(Items.PAPER);
						entries.add(ModItems.PINECONE);
						entries.add(ModItems.SILK_WAD);
						entries.add(Items.STRING);
						entries.add(Items.WHEAT);
						//endregion
						
						//region ## Basic Foods ##
						//# [1] Fruit #
						entries.add(Items.APPLE);
						entries.add(Items.GOLDEN_APPLE);
						entries.add(Items.ENCHANTED_GOLDEN_APPLE);
						entries.add(ModItems.CHERRY_BUNCH);
						entries.add(Items.GLOW_BERRIES);
						entries.add(Items.SWEET_BERRIES);
						entries.add(Items.MELON_SLICE);
//						entries.add(Items.COCOA_BEANS);
						entries.add(Items.CHORUS_FRUIT);
						//# [2] Meats (morsel) #
						entries.add(ModItems.RAW_MEAT_MORSEL);
						entries.add(ModItems.COOKED_MEAT_MORSEL);
						//# [4] Meats (fish) #
						entries.add(Items.COD);
						entries.add(Items.COOKED_COD);
						entries.add(Items.SALMON);
						entries.add(Items.COOKED_SALMON);
						entries.add(Items.TROPICAL_FISH);
						entries.add(Items.PUFFERFISH);
						//# [3] Meats (steak) #
						entries.add(Items.BEEF);
						entries.add(Items.COOKED_BEEF);
						entries.add(ModItems.RAW_BUGMEAT_STEAK);
						entries.add(ModItems.COOKED_BUGMEAT_STEAK);
						entries.add(Items.CHICKEN);
						entries.add(Items.COOKED_CHICKEN);
						entries.add(Items.MUTTON);
						entries.add(Items.COOKED_MUTTON);
						entries.add(Items.PORKCHOP);
						entries.add(Items.COOKED_PORKCHOP);
						entries.add(Items.RABBIT);
						entries.add(Items.COOKED_RABBIT);
						//# [5] Meats (other) #
						entries.add(Items.ROTTEN_FLESH);
						entries.add(ModItems.WARPED_FLESH_CHUNK);
						entries.add(Items.SPIDER_EYE);
						//# [6] Vegetables #
						entries.add(Items.DRIED_KELP);
						entries.add(ModItems.DRY_KELP_BUNDLE);
						entries.add(Items.CARROT);
						entries.add(ModItems.BAKED_CARROT);
						entries.add(Items.GOLDEN_CARROT);
						entries.add(ModItems.BAKED_MUSHROOM);
						entries.add(Items.POTATO);
						entries.add(Items.BAKED_POTATO);
						entries.add(Items.POISONOUS_POTATO);
						entries.add(Items.BEETROOT);
						entries.add(ModItems.BAKED_RADISH);
						//# [7] Miscellaneous #
						entries.add(ModItems.CHEESE_WHEEL);
						entries.add(ModItems.FRIED_EGG);
						entries.add(ModItems.LIVE_GRASS_TUFT);
						// TODO: Add Live Moss Wad upon implementation.
						//endregion
						
						//region ## Dough & Pastries & such ##
						//# [1] Small Baked Goods #
						entries.add(ModItems.RAW_COOKIE_BALL);
						entries.add(Items.COOKIE);
						entries.add(ModItems.RAW_HONEYBUN_BALL);
						entries.add(ModItems.HONEYBUN);
						entries.add(ModItems.RAW_MAGMABUN_BALL);
						entries.add(ModItems.MAGMABUN);
						entries.add(ModItems.RAW_SLIMEBUN_BALL);
						entries.add(ModItems.SLIMEBUN);
						//# [2] Pies #
						entries.add(ModItems.RAW_APPLE_PIE);
						entries.add(ModItems.APPLE_PIE);
						entries.add(ModItems.RAW_CHERRY_PIE);
						entries.add(ModItems.CHERRY_PIE);
						entries.add(ModItems.RAW_GLOWBERRY_PIE);
						entries.add(ModItems.GLOWBERRY_PIE);
						entries.add(ModItems.RAW_PUMPKIN_PIE);
						entries.add(ModItems.PUMPKIN_PIE);
						entries.add(ModItems.RAW_SWEETBERRY_PIE);
						entries.add(ModItems.SWEETBERRY_PIE);
						//# [3] Miscellaneous #
						entries.add(ModItems.RAW_DOUGH_LUMP);
						entries.add(Items.BREAD);
						entries.add(ModItems.RAW_CAKE);
						entries.add(Items.CAKE);
						//endregion
						
						//region ## Containers ##
						//# Soups #
						entries.add(ModItems.BOWL_OF_CARROT_SOUP);
						entries.add(ModItems.BOWL_OF_KELP_SOUP);
						entries.add(ModItems.BOWL_OF_MUSHROOM_SOUP);
						entries.add(ModItems.BOWL_OF_POISONOUS_POTATO_SOUP);
						entries.add(ModItems.BOWL_OF_PORRIDGE);
						entries.add(ModItems.BOWL_OF_POTATO_SOUP);
						entries.add(ModItems.BOWL_OF_PUMPKIN_SOUP);
						entries.add(ModItems.BOWL_OF_RADISH_SOUP);
						//# Stews #
						entries.add(ModItems.BOWL_OF_BEEF_STEW);
						entries.add(ModItems.BOWL_OF_BUGMEAT_STEW);
						entries.add(ModItems.BOWL_OF_CHICKEN_STEW);
						entries.add(ModItems.BOWL_OF_COD_STEW);
						entries.add(ModItems.BOWL_OF_MORSEL_STEW);
						entries.add(ModItems.BOWL_OF_MUTTON_STEW);
						entries.add(ModItems.BOWL_OF_PORK_STEW);
						entries.add(ModItems.BOWL_OF_RABBIT_STEW);
						entries.add(ModItems.BOWL_OF_SALMON_STEW);
						//# Suspicious Stews #
						addSuspiciousStews(entries, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
						//# Miscellaneous Containers (water) #
						entries.add(PotionContentsComponent.createStack(Items.POTION, Potions.WATER));
						entries.add(ModItems.BOWL_OF_WATER);
//						entries.add(Items.WATER_BUCKET);
						//# Miscellaneous Containers (steaming water) #
						entries.add(ModItems.BOTTLE_OF_STEAMING_WATER);
						entries.add(ModItems.BOWL_OF_STEAMING_WATER);
						entries.add(ModItems.BUCKET_OF_STEAMING_WATER);
						//# Miscellaneous Containers (honey) #
						entries.add(Items.HONEY_BOTTLE);
						entries.add(ModItems.BOWL_OF_HONEY);
						entries.add(ModItems.BUCKET_OF_HONEY);
						//# Miscellaneous Containers (milk) #
						entries.add(ModItems.BOTTLE_OF_MILK);
						entries.add(ModItems.BOWL_OF_MILK);
						entries.add(Items.MILK_BUCKET);
						//# Miscellaneous Containers (brimwater) #
						entries.add(ModItems.BOTTLE_OF_BRIMWATER);
						entries.add(ModItems.BOWL_OF_BRIMWATER);
						entries.add(ModItems.BUCKET_OF_BRIMWATER);
						//# Miscellaneous Containers (freezewater) #
						entries.add(ModItems.BOTTLE_OF_FREEZEWATER);
						entries.add(ModItems.BOWL_OF_FREEZEWATER);
						entries.add(ModItems.BUCKET_OF_FREEZEWATER);
						//endregion
						
						//region ### Joke & Unserious ###
						
						//## [1] (J&U) Basic Foods ##
						entries.add(ModItems.MILKLEAF_PILE);
						entries.add(ModItems.CHERRY_JELLYBALL);
						entries.add(ModItems.CHOCOLATE_BAR);
						entries.add(ModItems.CHULK_BERRY_BUNCH);
						entries.add(ModItems.HONEYPOD);
						entries.add(ModItems.STARCHCAP_MUSHROOM);
						//## [2] (J&U) Cheese ##
						entries.add(ModItems.BLUE_CHEESE_WEDGE);
						entries.add(ModItems.SILKY_SMOOTH_CHEESE_WEDGE);
						entries.add(ModItems.YELLOW_CHEESE_WEDGE);
						//## [3] (J&U) Nutrillarn ##
						entries.add(ModItems.RAW_NUTRILLARN_NUGGET);
						entries.add(ModItems.NUTRILLARN_GRAM);
						entries.add(ModItems.RAW_NUTRILLARN_LUMP);
						entries.add(ModItems.NUTRILLARN_INGOT);
						//## [4] (J&U) Miniwizards ##
						entries.add(ModItems.MINIWIZARD);
						//## [5] (J&U) Containers ##
						//# Bottle #
						//# Bowl #
						entries.add(ModItems.BOWL_OF_OMNISTEW);
						entries.add(ModItems.BOWL_OF_STONE_SOUP);
						//# Bucket #
						//endregion
					})).build());
	public static final ItemGroup MISCELLANEOUS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_miscellaneous_group"),
			FabricItemGroup.builder().displayName(displayName("miscellaneous"))
					.icon(() -> new ItemStack(ModItems.BOWL_OF_OMNISTEW))
					.entries(((displayContext, entries) -> {
						entries.add(ModItems.BOWL_OF_OMNISTEW);
					})).build());
	
	
	private static void addSuspiciousStews(ItemGroup.Entries entries, ItemGroup.StackVisibility visibility) {
		List<SuspiciousStewIngredient> list = SuspiciousStewIngredient.getAll();
		Set<ItemStack> set = ItemStackSet.create();
		
		for (SuspiciousStewIngredient suspiciousStewIngredient : list) {
			ItemStack itemStack = new ItemStack(Items.SUSPICIOUS_STEW);
			itemStack.set(DataComponentTypes.SUSPICIOUS_STEW_EFFECTS, suspiciousStewIngredient.getStewEffects());
			set.add(itemStack);
		}
		
		entries.addAll(set, visibility);
	}
}
