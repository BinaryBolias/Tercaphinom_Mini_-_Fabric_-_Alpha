package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
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


/**
 * @see net.minecraft.item.ItemGroups
 */
public class ModItemGroups {
	public ModItemGroups() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static void register() {
		logMainEvent("Registering item groups");
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
						entries.add(Blocks.RAW_COPPER_BLOCK);
						entries.add(ModBlocks.RAW_BRASS_BLOCK);
						entries.add(Blocks.RAW_IRON_BLOCK);
						entries.add(Blocks.RAW_GOLD_BLOCK);
						entries.add(ModBlocks.RAW_EIDURIL_BLOCK);
						entries.add(Blocks.COPPER_BLOCK);
						entries.add(ModBlocks.REFINED_BRASS_BLOCK);
						entries.add(Blocks.IRON_BLOCK);
						entries.add(Blocks.GOLD_BLOCK);
						entries.add(Blocks.NETHERITE_BLOCK);
						entries.add(ModBlocks.REFINED_EIDURIL_BLOCK);
						entries.add(ModBlocks.CORRODED_VILBIARN_BLOCK);
						entries.add(ModBlocks.REFINED_VILBIARN_BLOCK);
						//# Mosaic & Plank #
						entries.add(Blocks.ACACIA_PLANKS);
						entries.add(Blocks.BAMBOO_PLANKS);
						entries.add(Blocks.BIRCH_PLANKS);
						entries.add(Blocks.CHERRY_PLANKS);
						entries.add(Blocks.CRIMSON_PLANKS);
						entries.add(Blocks.DARK_OAK_PLANKS);
						entries.add(Blocks.JUNGLE_PLANKS);
						entries.add(Blocks.MANGROVE_PLANKS);
						entries.add(Blocks.OAK_PLANKS);
						entries.add(Blocks.SPRUCE_PLANKS);
						entries.add(ModBlocks.VERDAK_PLANK_BLOCK);
						entries.add(Blocks.WARPED_PLANKS);
						//# Stone (brick) #
						entries.add(ModBlocks.STIEFANE_BRICK_BLOCK);
						//# Stone (cobbled) #
						entries.add(ModBlocks.COBBLED_STIEFANE_BLOCK);
						//# Stone (natural) #
						entries.add(ModBlocks.NATURAL_STIEFANE_BLOCK);
						//# Stone (polished) #
						entries.add(ModBlocks.POLISHED_STIEFANE_BLOCK);
						//# Miscellaneous #
						entries.add(ModBlocks.ASH_BLOCK);
						entries.add(Blocks.DIRT);
						entries.add(Blocks.COARSE_DIRT);
						entries.add(Blocks.CLAY);
						entries.add(ModBlocks.GLASS_SHARD_BLOCK);
						entries.add(Blocks.SAND);
						entries.add(Blocks.RED_SAND);
						entries.add(ModBlocks.SKORSAND_BLOCK);
						entries.add(Blocks.NETHERRACK);
						entries.add(Blocks.END_STONE);
						
						// ## Modified & Transitional ##
						//# Bony #
						//# Covered #
						// # Ore (netherrack) #
						// # Ore (stiefane) #
						entries.add(ModBlocks.STIEFANE_LAPIS_ORE);
						// # Ore (zygolith) #
						//# Reinforced #
						//# Stony #
						//# Miscellaneous #
						entries.add(ModBlocks.ASHY_NETHERRACK_BLOCK);
						
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
						entries.add(ModBlocks.CHISELED_ETERNALITH_BLOCK);
						//# Miscellaneous #
						
						//### Joke & Unserious ###
						//## (J&U) Elemental ##
						//# Cheese #
						entries.add(JAUBlocks.BLUE_CHEESE_BLOCK);
						entries.add(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK);
						entries.add(JAUBlocks.YELLOW_CHEESE_BLOCK);
						//# Metal #
						entries.add(JAUBlocks.RAW_NUTRILLARN_BLOCK);
						entries.add(JAUBlocks.REFINED_NUTRILLARN_BLOCK);
						//# Miscellaneous #
						entries.add(JAUBlocks.CANDESAND_BLOCK);
						entries.add(JAUBlocks.CHERRY_JELLYBLOCK);
						entries.add(JAUBlocks.HYPERSMOOTH_CREAMSTONE);
						entries.add(JAUBlocks.ULTRASMOOTH_STONE);
						//## (J&U) Modified & Transitional ##
						//# Reinforced #
						entries.add(JAUBlocks.REINFORCED_STAINED_GLASS_BLOCK);
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
						entries.add(ModItems.BRASS_HELMET);
						entries.add(ModItems.BRASS_CHESTPLATE);
						entries.add(ModItems.BRASS_LEGGING_PAIR);
						entries.add(ModItems.BRASS_BOOT_PAIR);
						entries.add(ModItems.BRASS_HORSE_HARNESS);
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
						entries.add(ModItems.COPPER_HELMET);
						entries.add(ModItems.COPPER_CHESTPLATE);
						entries.add(ModItems.COPPER_LEGGING_PAIR);
						entries.add(ModItems.COPPER_BOOT_PAIR);
						entries.add(ModItems.COPPER_HORSE_HARNESS);
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
						//# [Tier 3] Dementhum (armor) #
						// NOTE: No horse harness.
						entries.add(Items.NETHERITE_HELMET);
						entries.add(Items.NETHERITE_CHESTPLATE);
						entries.add(Items.NETHERITE_LEGGINGS);
						entries.add(Items.NETHERITE_BOOTS);
						//# [Tier 3] Dementhum (tools) #
						// NOTE: No custom tool types (dagger, hatchet, mallet, spear).
						entries.add(Items.NETHERITE_AXE);
						entries.add(Items.NETHERITE_HOE);
						entries.add(Items.NETHERITE_PICKAXE);
						entries.add(Items.NETHERITE_SHOVEL);
						entries.add(Items.NETHERITE_SWORD);
						//# [Tier 3] Eiduril (armor) #
						entries.add(ModItems.EIDURIL_HELMET);
						entries.add(ModItems.EIDURIL_CHESTPLATE);
						entries.add(ModItems.EIDURIL_LEGGING_PAIR);
						entries.add(ModItems.EIDURIL_BOOT_PAIR);
						entries.add(ModItems.EIDURIL_HORSE_HARNESS);
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
						entries.add(Items.GOLDEN_HELMET);
						entries.add(Items.GOLDEN_CHESTPLATE);
						entries.add(Items.GOLDEN_LEGGINGS);
						entries.add(Items.GOLDEN_BOOTS);
						entries.add(Items.GOLDEN_HORSE_ARMOR);
						//# [Tier 3] Gold (tools) #
						entries.add(Items.GOLDEN_AXE);
						entries.add(ModItems.GOLDEN_DAGGER);
						entries.add(ModItems.GOLDEN_HATCHET);
						entries.add(Items.GOLDEN_HOE);
						entries.add(ModItems.GOLDEN_MALLET);
						entries.add(Items.GOLDEN_PICKAXE);
						entries.add(Items.GOLDEN_SHOVEL);
						entries.add(ModItems.GOLDEN_SPEAR);
						entries.add(Items.GOLDEN_SWORD);
						//# [Tier 3] Iron (armor) #
						entries.add(Items.IRON_HELMET);
						entries.add(Items.IRON_CHESTPLATE);
						entries.add(Items.IRON_LEGGINGS);
						entries.add(Items.IRON_BOOTS);
						entries.add(Items.IRON_HORSE_ARMOR);
						//# [Tier 3] Iron (tools) #
						entries.add(Items.IRON_AXE);
						entries.add(ModItems.IRON_DAGGER);
						entries.add(ModItems.IRON_HATCHET);
						entries.add(Items.IRON_HOE);
						entries.add(ModItems.IRON_MALLET);
						entries.add(Items.IRON_PICKAXE);
						entries.add(Items.IRON_SHOVEL);
						entries.add(ModItems.IRON_SPEAR);
						entries.add(Items.IRON_SWORD);
						//# Miscellaneous #
						entries.add(ModItems.SPATIAL_RECALL_STONE);
						entries.add(ModItems.TARGET_TELEPORTATION_TUNER);
						
						//region ### Joke & Unserious ###
						//## (J&U) Equipment ##
						//# Nutrillarn Armor #
						entries.add(JAUItems.NUTRILLARN_HELMET);
						entries.add(JAUItems.NUTRILLARN_CHESTPLATE);
						entries.add(JAUItems.NUTRILLARN_LEGGING_PAIR);
						entries.add(JAUItems.NUTRILLARN_BOOT_PAIR);
						entries.add(JAUItems.NUTRILLARN_JELLYBOOT_PAIR);
						entries.add(JAUItems.NUTRILLARN_HORSE_HARNESS);
						//# Nutrillarn Tools #
						entries.add(JAUItems.NUTRILLARN_AXE);
						entries.add(JAUItems.NUTRILLARN_DAGGER);
						entries.add(JAUItems.NUTRILLARN_HATCHET);
						entries.add(JAUItems.NUTRILLARN_HOE);
						entries.add(JAUItems.NUTRILLARN_MALLET);
						entries.add(JAUItems.NUTRILLARN_PICKAXE);
						entries.add(JAUItems.NUTRILLARN_SHOVEL);
						entries.add(JAUItems.NUTRILLARN_SPEAR);
						entries.add(JAUItems.NUTRILLARN_SWORD);
						//# Miscellaneous #
						entries.add(JAUItems.ENCHANTED_CHEESE_WHEEL);
						entries.add(JAUItems.NUTRILLARN_COMPASS);
						entries.add(JAUItems.ORB_OF_ZOT);
						//endregion
					})).build());
	public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_ingredients_group"),
			FabricItemGroup.builder().displayName(displayName("ingredients"))
					.icon(() -> new ItemStack(ModItems.OAK_PLANK))
					.entries(((displayContext, entries) -> {
						//region ## Basic Resources ##
						//# Wooden Stick & Plank #
						entries.add(VMOItems.STICK);
						entries.add(ModItems.WOODEN_STICK_BUNDLE);
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
						//# Ball (miscellaneous) #
						entries.add(VMOItems.BONE_MEAL);
						entries.add(ModItems.COBWEB_BALL);
						entries.add(ModItems.MUDBALL);
						entries.add(VMOItems.SLIME_BALL);
						//# Miscellaneous Bundle & Rod & Stick #
						entries.add(VMOItems.BAMBOO);
						entries.add(ModItems.DYNAMITE_BUNDLE);
						entries.add(ModItems.DYNAMITE_STICK);
						//# Brick (small) #
						entries.add(VMOItems.BRICK);
						entries.add(VMOItems.NETHER_BRICK);
						entries.add(ModItems.NETHERWART_BRICK);
						//# Brick (large) #
						entries.add(ModItems.STIEFANE_BRICK);
						//# Chunk #
						//# Clod #
						entries.add(ModItems.SOULSOIL_CLOD);
						//# Cobblestone #
						entries.add(ModItems.STIEFANE_COBBLESTONE);
						//# Gram & Ingot #
						entries.add(VMOItems.COPPER_INGOT);
						entries.add(ModItems.COPPER_GRAM);
						entries.add(ModItems.BRASS_INGOT);
						entries.add(ModItems.BRASS_GRAM);
						entries.add(VMOItems.IRON_INGOT);
						entries.add(ModItems.IRON_GRAM);
						entries.add(VMOItems.GOLD_INGOT);
						entries.add(ModItems.GOLD_GRAM);
						entries.add(VMOItems.NETHERITE_INGOT);
						entries.add(ModItems.EIDURIL_INGOT);
						entries.add(ModItems.EIDURIL_GRAM);
						//# Lump & Nugget (metal) #
						entries.add(VMOItems.RAW_COPPER);
						entries.add(ModItems.RAW_COPPER_NUGGET);
						entries.add(ModItems.RAW_BRASS_LUMP);
						entries.add(ModItems.RAW_BRASS_NUGGET);
						entries.add(VMOItems.RAW_IRON);
						entries.add(VMOItems.IRON_NUGGET);
						entries.add(VMOItems.RAW_GOLD);
						entries.add(VMOItems.GOLD_NUGGET);
						entries.add(ModItems.RAW_EIDURIL_LUMP);
						entries.add(ModItems.RAW_EIDURIL_NUGGET);
						entries.add(ModItems.CORRODED_VILBIARN_LUMP);
						entries.add(ModItems.REFINED_VILBIARN_LUMP);
						//# Lump & Nugget (miscellaneous) #
						entries.add(VMOItems.COAL);
						entries.add(Items.CHARCOAL);
						entries.add(ModItems.INFERNOCOAL_LUMP);
						entries.add(ModItems.RAW_DOUGH_LUMP);
						entries.add(ModItems.SULPHUR_LUMP);
						//# Dye Blob #
						entries.add(VMOItems.WHITE_DYE);
						entries.add(VMOItems.LIGHT_GRAY_DYE);
						entries.add(VMOItems.GRAY_DYE);
						entries.add(VMOItems.BLACK_DYE);
						entries.add(VMOItems.BROWN_DYE);
						entries.add(VMOItems.RED_DYE);
						entries.add(VMOItems.ORANGE_DYE);
						entries.add(VMOItems.YELLOW_DYE);
						entries.add(VMOItems.LIME_DYE);
						entries.add(VMOItems.GREEN_DYE);
						entries.add(VMOItems.CYAN_DYE);
						entries.add(VMOItems.LIGHT_BLUE_DYE);
						entries.add(VMOItems.BLUE_DYE);
						entries.add(VMOItems.PURPLE_DYE);
						entries.add(VMOItems.MAGENTA_DYE);
						entries.add(VMOItems.PINK_DYE);
						//# Yarn #
						entries.add(ModItems.WHITE_YARNBALL);
						entries.add(ModItems.WHITE_YARN_ROLL);
						entries.add(ModItems.LIGHT_GRAY_YARNBALL);
						entries.add(ModItems.LIGHT_GRAY_YARN_ROLL);
						entries.add(ModItems.GRAY_YARNBALL);
						entries.add(ModItems.GRAY_YARN_ROLL);
						entries.add(ModItems.BLACK_YARNBALL);
						entries.add(ModItems.BLACK_YARN_ROLL);
						entries.add(ModItems.BROWN_YARNBALL);
						entries.add(ModItems.BROWN_YARN_ROLL);
						entries.add(ModItems.RED_YARNBALL);
						entries.add(ModItems.RED_YARN_ROLL);
						entries.add(ModItems.ORANGE_YARNBALL);
						entries.add(ModItems.ORANGE_YARN_ROLL);
						entries.add(ModItems.YELLOW_YARNBALL);
						entries.add(ModItems.YELLOW_YARN_ROLL);
						entries.add(ModItems.LIME_YARNBALL);
						entries.add(ModItems.LIME_YARN_ROLL);
						entries.add(ModItems.GREEN_YARNBALL);
						entries.add(ModItems.GREEN_YARN_ROLL);
						entries.add(ModItems.CYAN_YARNBALL);
						entries.add(ModItems.CYAN_YARN_ROLL);
						entries.add(ModItems.LIGHT_BLUE_YARNBALL);
						entries.add(ModItems.LIGHT_BLUE_YARN_ROLL);
						entries.add(ModItems.BLUE_YARNBALL);
						entries.add(ModItems.BLUE_YARN_ROLL);
						entries.add(ModItems.PURPLE_YARNBALL);
						entries.add(ModItems.PURPLE_YARN_ROLL);
						entries.add(ModItems.MAGENTA_YARNBALL);
						entries.add(ModItems.MAGENTA_YARN_ROLL);
						entries.add(ModItems.PINK_YARNBALL);
						entries.add(ModItems.PINK_YARN_ROLL);
						//# Pane (glass - clear) #
						entries.add(ModItems.CLEAR_GLASS_PANE);
						//# Pane (glass - stained) #
						entries.add(ModItems.WHITE_STAINED_GLASS_PANE);
						entries.add(ModItems.LIGHT_GRAY_STAINED_GLASS_PANE);
						entries.add(ModItems.GRAY_STAINED_GLASS_PANE);
						entries.add(ModItems.BLACK_STAINED_GLASS_PANE);
						entries.add(ModItems.BROWN_STAINED_GLASS_PANE);
						entries.add(ModItems.RED_STAINED_GLASS_PANE);
						entries.add(ModItems.ORANGE_STAINED_GLASS_PANE);
						entries.add(ModItems.YELLOW_STAINED_GLASS_PANE);
						entries.add(ModItems.LIME_STAINED_GLASS_PANE);
						entries.add(ModItems.GREEN_STAINED_GLASS_PANE);
						entries.add(ModItems.CYAN_STAINED_GLASS_PANE);
						entries.add(ModItems.LIGHT_BLUE_STAINED_GLASS_PANE);
						entries.add(ModItems.BLUE_STAINED_GLASS_PANE);
						entries.add(ModItems.PURPLE_STAINED_GLASS_PANE);
						entries.add(ModItems.MAGENTA_STAINED_GLASS_PANE);
						entries.add(ModItems.PINK_STAINED_GLASS_PANE);
						//# Pane (metal) #
						//# Pane (miscellaneous) #
						//# Pie #
						entries.add(ModItems.RAW_APPLE_PIE);
						entries.add(ModItems.RAW_CHERRY_PIE);
						entries.add(ModItems.RAW_GLOWBERRY_PIE);
						entries.add(ModItems.RAW_PUMPKIN_PIE);
						entries.add(ModItems.RAW_SWEETBERRY_PIE);
						//# Pile (seed) #
						//# Pile (miscellaneous) #
						entries.add(ModItems.ASH_PILE);
						entries.add(VMOItems.GUNPOWDER);
						entries.add(ModItems.DIRT_PILE);
						entries.add(VMOItems.REDSTONE);
						entries.add(ModItems.GRAVEL_PILE);
						entries.add(ModItems.LEAF_PILE);
						entries.add(ModItems.FELDSAND_PILE); // Sand
						entries.add(ModItems.FERROSAND_PILE); // Sand
						entries.add(ModItems.SKORSAND_PILE); // Sand
						entries.add(ModItems.SNOW_PILE);
						entries.add(ModItems.SOULSAND_PILE);
						//# Elemental Rods & Powders #
						entries.add(VMOItems.BLAZE_ROD);
						entries.add(VMOItems.BLAZE_POWDER);
						entries.add(ModItems.FREEZE_ROD);
						entries.add(ModItems.FREEZE_POWDER_PILE);
						//# Miscellaneous Shards #
						entries.add(VMOItems.FLINT);
						entries.add(ModItems.GLASS_SHARD);
						entries.add(ModItems.OBSIDIAN_SHARD);
						//# Prismarine #
						entries.add(ModItems.DARK_PRISMARINE_SHARD);
						entries.add(VMOItems.PRISMARINE_SHARD);
						entries.add(VMOItems.PRISMARINE_CRYSTALS);
						//# Miscellaneous #
						entries.add(Items.BOOK);
						entries.add(VMOItems.EGG);
						entries.add(VMOItems.FEATHER);
						entries.add(ModItems.DRY_GRASS_TUFT);
						entries.add(ModItems.LIVE_GRASS_TUFT);
						entries.add(VMOItems.INK_SAC);
						entries.add(VMOItems.GLOW_INK_SAC);
						entries.add(Items.HONEYCOMB);
						entries.add(Items.LEATHER);
						entries.add(VMOItems.NETHERITE_SCRAP);
						entries.add(VMOItems.PAPER);
						entries.add(ModItems.PINECONE);
						entries.add(VMOItems.RABBIT_HIDE);
						entries.add(VMOItems.GHAST_TEAR);
						entries.add(VMOItems.SPIDER_EYE);
						entries.add(VMOItems.FERMENTED_SPIDER_EYE);
						entries.add(ModItems.SILK_WAD);
						entries.add(VMOItems.STRING);
						entries.add(ModItems.STONE_PEBBLE);
						//endregion
						
						//region ## Containers ##
						//# Bottle (empty) #
						entries.add(VMOItems.GLASS_BOTTLE);
						//# Bottle (filled) #
						entries.add(ModItems.BOTTLE_OF_BRIMWATER);
						entries.add(ModItems.BOTTLE_OF_FREEZEWATER);
						entries.add(VMOItems.HONEY_BOTTLE);
						entries.add(ModItems.BOTTLE_OF_MILK);
						entries.add(ModItems.BOTTLE_OF_STEAMING_WATER);
						entries.add(PotionContentsComponent.createStack(VMOItems.POTION, Potions.WATER));
						entries.add(VMOItems.EXPERIENCE_BOTTLE);
						//# Bowl (empty) #
						entries.add(VMOItems.BOWL);
						//# Bowl (filled - miscellaneous) #
						entries.add(ModItems.BOWL_OF_BRIMWATER);
						entries.add(ModItems.BOWL_OF_FREEZEWATER);
						entries.add(ModItems.BOWL_OF_HONEY);
						entries.add(ModItems.BOWL_OF_MILK);
						entries.add(ModItems.BOWL_OF_STEAMING_WATER);
						entries.add(ModItems.BOWL_OF_WATER);
						//# Bucket (empty) #
						entries.add(Items.BUCKET);
						//# Bucket (filled) #
						entries.add(ModItems.BUCKET_OF_BRIMWATER);
						entries.add(ModItems.BUCKET_OF_FERTILIZER);
						entries.add(ModItems.BUCKET_OF_FREEZEWATER);
						entries.add(ModItems.BUCKET_OF_HONEY);
						entries.add(ModItems.BUCKET_OF_STEAMING_WATER);
						entries.add(VMOItems.WATER_BUCKET);
						//endregion
						
						//region ### Joke & Unserious ###
						
						//## (J&U) Basic Resources ##
						//# Ball #
						entries.add(JAUItems.CHERRY_JELLYBALL);
						//# Gram & Ingot #
						entries.add(JAUItems.NUTRILLARN_GRAM);
						entries.add(JAUItems.NUTRILLARN_INGOT);
						//# Lump & Nugget #
						entries.add(JAUItems.RAW_NUTRILLARN_LUMP);
						entries.add(JAUItems.RAW_NUTRILLARN_NUGGET);
						//# Pile (seed) #
						//# Pile (miscellaneous) #
						entries.add(JAUItems.MILKLEAF_PILE);
						//# Miscellaneous (cheese) #
						entries.add(JAUItems.BLUE_CHEESE_WEDGE);
						entries.add(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE);
						entries.add(JAUItems.YELLOW_CHEESE_WEDGE);
						//# Miscellaneous (miscellaneous) #
						entries.add(JAUItems.CHOCOLATE_BAR);
						entries.add(JAUItems.CHULK_BERRY_BUNCH);
						entries.add(JAUItems.ENCHANTED_BRICK);
						entries.add(JAUItems.HONEYPOD);
						entries.add(JAUItems.STARCHCAP_MUSHROOM);
						
						entries.add(JAUItems.MINIWIZARD);
						
						//## (J&U) Containers ##
						//# Bottle #
						//# Bowl #
						entries.add(JAUItems.BOWL_OF_STONE_SOUP);
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
						entries.add(VMOItems.COAL);
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
						entries.add(VMOItems.STICK);
						entries.add(ModItems.WOODEN_STICK_BUNDLE);
						//# Yarn #
						entries.add(ModItems.WHITE_YARNBALL);
						entries.add(ModItems.WHITE_YARN_ROLL);
						entries.add(ModItems.LIGHT_GRAY_YARNBALL);
						entries.add(ModItems.LIGHT_GRAY_YARN_ROLL);
						entries.add(ModItems.GRAY_YARNBALL);
						entries.add(ModItems.GRAY_YARN_ROLL);
						entries.add(ModItems.BLACK_YARNBALL);
						entries.add(ModItems.BLACK_YARN_ROLL);
						entries.add(ModItems.BROWN_YARNBALL);
						entries.add(ModItems.BROWN_YARN_ROLL);
						entries.add(ModItems.RED_YARNBALL);
						entries.add(ModItems.RED_YARN_ROLL);
						entries.add(ModItems.ORANGE_YARNBALL);
						entries.add(ModItems.ORANGE_YARN_ROLL);
						entries.add(ModItems.YELLOW_YARNBALL);
						entries.add(ModItems.YELLOW_YARN_ROLL);
						entries.add(ModItems.LIME_YARNBALL);
						entries.add(ModItems.LIME_YARN_ROLL);
						entries.add(ModItems.GREEN_YARNBALL);
						entries.add(ModItems.GREEN_YARN_ROLL);
						entries.add(ModItems.CYAN_YARNBALL);
						entries.add(ModItems.CYAN_YARN_ROLL);
						entries.add(ModItems.LIGHT_BLUE_YARNBALL);
						entries.add(ModItems.LIGHT_BLUE_YARN_ROLL);
						entries.add(ModItems.BLUE_YARNBALL);
						entries.add(ModItems.BLUE_YARN_ROLL);
						entries.add(ModItems.PURPLE_YARNBALL);
						entries.add(ModItems.PURPLE_YARN_ROLL);
						entries.add(ModItems.MAGENTA_YARNBALL);
						entries.add(ModItems.MAGENTA_YARN_ROLL);
						entries.add(ModItems.PINK_YARNBALL);
						entries.add(ModItems.PINK_YARN_ROLL);
						//# [6] Miscellaneous #
						entries.add(ModItems.COBWEB_BALL);
						entries.add(ModItems.DRY_GRASS_TUFT);
						// TODO: Add Dry Moss Wad upon implementation.
						entries.add(ModItems.LEAF_PILE);
						entries.add(VMOItems.PAPER);
						entries.add(ModItems.PINECONE);
						entries.add(ModItems.SILK_WAD);
						entries.add(VMOItems.STRING);
						entries.add(Items.WHEAT);
						//endregion
						
						//region ## Basic Foods ##
						//# [1] Fruit #
						entries.add(VMOItems.APPLE);
						entries.add(VMOItems.GOLDEN_APPLE);
						entries.add(VMOItems.ENCHANTED_GOLDEN_APPLE);
						entries.add(ModItems.CHERRY_BUNCH);
						entries.add(VMOItems.GLOW_BERRIES);
						entries.add(VMOItems.SWEET_BERRIES);
						entries.add(VMOItems.MELON_SLICE);
//						entries.add(Items.COCOA_BEANS);
						entries.add(VMOItems.CHORUS_FRUIT);
						//# [2] Meats (morsel) #
						entries.add(ModItems.RAW_MEAT_MORSEL);
						entries.add(ModItems.COOKED_MEAT_MORSEL);
						//# [4] Meats (fish) #
						entries.add(VMOItems.COD);
						entries.add(VMOItems.COOKED_COD);
						entries.add(VMOItems.SALMON);
						entries.add(VMOItems.COOKED_SALMON);
						entries.add(VMOItems.TROPICAL_FISH);
						entries.add(VMOItems.PUFFERFISH);
						//# [3] Meats (steak) #
						entries.add(VMOItems.BEEF);
						entries.add(VMOItems.COOKED_BEEF);
						entries.add(ModItems.RAW_BUGMEAT_STEAK);
						entries.add(ModItems.COOKED_BUGMEAT_STEAK);
						entries.add(VMOItems.CHICKEN);
						entries.add(VMOItems.COOKED_CHICKEN);
						entries.add(VMOItems.MUTTON);
						entries.add(VMOItems.COOKED_MUTTON);
						entries.add(VMOItems.PORKCHOP);
						entries.add(VMOItems.COOKED_PORKCHOP);
						entries.add(VMOItems.RABBIT);
						entries.add(VMOItems.COOKED_RABBIT);
						//# [5] Meats (other) #
						entries.add(VMOItems.ROTTEN_FLESH);
						entries.add(ModItems.WARPED_FLESH_CHUNK);
						entries.add(VMOItems.SPIDER_EYE);
						//# [6] Vegetables #
						entries.add(VMOItems.DRIED_KELP);
						entries.add(ModItems.DRY_KELP_BUNDLE);
						entries.add(VMOItems.CARROT);
						entries.add(ModItems.BAKED_CARROT);
						entries.add(VMOItems.GOLDEN_CARROT);
						entries.add(ModItems.BAKED_MUSHROOM);
						entries.add(VMOItems.POTATO);
						entries.add(VMOItems.BAKED_POTATO);
						entries.add(VMOItems.POISONOUS_POTATO);
						entries.add(VMOItems.BEETROOT);
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
						entries.add(VMOItems.COOKIE);
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
						entries.add(VMOItems.BREAD);
						entries.add(ModItems.RAW_CAKE);
						entries.add(VMOItems.CAKE);
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
						entries.add(PotionContentsComponent.createStack(VMOItems.POTION, Potions.WATER));
						entries.add(ModItems.BOWL_OF_WATER);
//						entries.add(Items.WATER_BUCKET);
						//# Miscellaneous Containers (steaming water) #
						entries.add(ModItems.BOTTLE_OF_STEAMING_WATER);
						entries.add(ModItems.BOWL_OF_STEAMING_WATER);
						entries.add(ModItems.BUCKET_OF_STEAMING_WATER);
						//# Miscellaneous Containers (honey) #
						entries.add(VMOItems.HONEY_BOTTLE);
						entries.add(ModItems.BOWL_OF_HONEY);
						entries.add(ModItems.BUCKET_OF_HONEY);
						//# Miscellaneous Containers (milk) #
						entries.add(ModItems.BOTTLE_OF_MILK);
						entries.add(ModItems.BOWL_OF_MILK);
						entries.add(VMOItems.MILK_BUCKET);
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
						entries.add(JAUItems.CANDESAND_PILE);
						entries.add(JAUItems.MILKLEAF_PILE);
						entries.add(JAUItems.CHERRY_JELLYBALL);
						entries.add(JAUItems.CHOCOLATE_BAR);
						entries.add(JAUItems.CHULK_BERRY_BUNCH);
						entries.add(JAUItems.HONEYPOD);
						entries.add(JAUItems.STARCHCAP_MUSHROOM);
						//## [2] (J&U) Cheese ##
						entries.add(JAUItems.BLUE_CHEESE_WEDGE);
						entries.add(JAUItems.SILKY_SMOOTH_CHEESE_WEDGE);
						entries.add(JAUItems.YELLOW_CHEESE_WEDGE);
						//## [3] (J&U) Nutrillarn ##
						entries.add(JAUItems.RAW_NUTRILLARN_NUGGET);
						entries.add(JAUItems.NUTRILLARN_GRAM);
						entries.add(JAUItems.RAW_NUTRILLARN_LUMP);
						entries.add(JAUItems.NUTRILLARN_INGOT);
						//## [4] (J&U) Miniwizards ##
						entries.add(JAUItems.MINIWIZARD);
						//## [5] (J&U) Containers ##
						//# Bottle #
						//# Bowl #
						entries.add(JAUItems.BOWL_OF_OMNISTEW);
						entries.add(JAUItems.BOWL_OF_STONE_SOUP);
						//# Bucket #
						//endregion
					})).build());
	public static final ItemGroup MISCELLANEOUS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_miscellaneous_group"),
			FabricItemGroup.builder().displayName(displayName("miscellaneous"))
					.icon(() -> new ItemStack(JAUItems.BOWL_OF_OMNISTEW))
					.entries(((displayContext, entries) -> {
						entries.add(JAUItems.BOWL_OF_OMNISTEW);
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
