package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModRegistries {
	public static void register() {
		registerFuels();
		registerCompostables();
		registerCommands();
		registerEvents();
		registerPotionRecipes();
		registerCustomTrades();
		registerStrippables();
		registerFlammables();
		registerAttributes();
		registerOxidizables();
		registerPortals();
	}
	
	/**
	 * Vanilla fuels reference:<br>
	 * {@link net.minecraft.block.entity.AbstractFurnaceBlockEntity}
	 */
	private static void registerFuels() {
		logMainEvent("Registering fuels");
		FuelRegistry registry = FuelRegistry.INSTANCE;
		
		//region Vanilla Removal
		//# Blocks #
		registry.remove(Blocks.AZALEA);
		registry.remove(Blocks.BAMBOO);
		registry.remove(Blocks.BAMBOO_MOSAIC);
		registry.remove(Blocks.BAMBOO_MOSAIC_SLAB);
		registry.remove(Blocks.BAMBOO_MOSAIC_STAIRS);
		registry.remove(Blocks.BARREL);
		registry.remove(Blocks.CARTOGRAPHY_TABLE);
		registry.remove(Blocks.CHEST);
		registry.remove(Blocks.CHISELED_BOOKSHELF);
		registry.remove(Blocks.COAL_BLOCK);
		registry.remove(Blocks.COMPOSTER);
		registry.remove(Blocks.CRAFTING_TABLE);
		registry.remove(Blocks.DAYLIGHT_DETECTOR);
		registry.remove(Blocks.DEAD_BUSH);
		registry.remove(Blocks.DRIED_KELP_BLOCK);
		registry.remove(Blocks.FLETCHING_TABLE);
		registry.remove(Blocks.FLOWERING_AZALEA);
		registry.remove(Blocks.JUKEBOX);
		registry.remove(Blocks.LADDER);
		registry.remove(Blocks.LECTERN);
		registry.remove(Blocks.LOOM);
		registry.remove(Blocks.MANGROVE_ROOTS);
		registry.remove(Blocks.NOTE_BLOCK);
		registry.remove(Blocks.SCAFFOLDING);
		registry.remove(Blocks.SMITHING_TABLE);
		registry.remove(Blocks.TRAPPED_CHEST);
		//# Basic Resources #
		registry.remove(Items.BLAZE_ROD);
		registry.remove(Items.CHARCOAL);
		registry.remove(Items.COAL);
		registry.remove(Items.STICK);
		//# Containers & Equipment #
		registry.remove(Items.BOW);
		registry.remove(Items.BOWL);
		registry.remove(Items.CROSSBOW);
		registry.remove(Items.FISHING_ROD);
		registry.remove(Items.LAVA_BUCKET);
		registry.remove(Items.WOODEN_AXE);
		registry.remove(Items.WOODEN_HOE);
		registry.remove(Items.WOODEN_PICKAXE);
		registry.remove(Items.WOODEN_SHOVEL);
		registry.remove(Items.WOODEN_SWORD);
		//# Tags #
		registry.remove(ItemTags.BAMBOO_BLOCKS);
		registry.remove(ItemTags.BANNERS);
		registry.remove(ItemTags.BOATS);
		registry.remove(ItemTags.FENCE_GATES);
		registry.remove(ItemTags.HANGING_SIGNS);
		registry.remove(ItemTags.LOGS);
		registry.remove(ItemTags.PLANKS);
		registry.remove(ItemTags.SAPLINGS);
		registry.remove(ItemTags.SIGNS);
		registry.remove(ItemTags.WOODEN_BUTTONS);
		registry.remove(ItemTags.WOODEN_DOORS);
		registry.remove(ItemTags.WOODEN_FENCES);
		registry.remove(ItemTags.WOODEN_PRESSURE_PLATES);
		registry.remove(ItemTags.WOODEN_SLABS);
		registry.remove(ItemTags.WOODEN_STAIRS);
		registry.remove(ItemTags.WOODEN_TRAPDOORS);
		registry.remove(ItemTags.WOOL);
		registry.remove(ItemTags.WOOL_CARPETS);
		// TODO: Remove remaining vanilla fuels.
		//endregion
		
		// TODO: Check the limitations of the furnace block entity.
		
		// Vanilla fuels:
		// - 100: Stick | [wool blocks] | [saplings]
		// - 300: [log blocks] | [plank blocks]
		// - 1600: Coal | Charcoal
		// - 2400: Blaze Rod
		// - 20000: Lava Bucket
		
		//# Basic Resources #
		registry.add(Items.BAMBOO, 100); // TODO: Perhaps rework with implementation of Dry Bamboo Stick.
		registry.add(Items.BLAZE_POWDER, 600);
		registry.add(Items.BLAZE_ROD, 2400);
		registry.add(Items.CHARCOAL, 1200);
		registry.add(Items.COAL, 1600);
		registry.add(ModItems.COBWEB_BALL, 100);
		registry.add(Items.DRIED_KELP, 300);
		registry.add(ModItems.DRY_GRASS_TUFT, 100);
		registry.add(ModItems.DRY_KELP_BUNDLE, 1200);
		// TODO: Add Dry Moss Wad upon implementation.
		registry.add(ModItems.INFERNOCOAL_LUMP, 6400);
		registry.add(ModItems.LEAF_PILE, 150);
		registry.add(Items.PAPER, 100);
		registry.add(ModItems.PINECONE, 800);
		registry.add(ModItems.SILK_WAD, 50);
		registry.add(Items.STICK, 100);
		registry.add(Items.STRING, 50);
		registry.add(ModItems.SULPHUR_LUMP, 1600);
		registry.add(ModItems.WOODEN_STICK_BUNDLE, 400);
		//# Books #
		registry.add(Items.BOOK, 900);
		registry.add(Items.ENCHANTED_BOOK, 1600);
		registry.add(Items.WRITABLE_BOOK, 1200);
		registry.add(Items.WRITTEN_BOOK, 1200);
		//# Containers & Equipment #
		// NOTE: Items with durability are intended to provide half the sum of their fuel ingredients.
		registry.add(Items.BOW, 150);
		registry.add(Items.BOWL, 450);
		registry.add(Items.CROSSBOW, 400);
		registry.add(Items.FISHING_ROD, 200);
		registry.add(Items.LAVA_BUCKET, 20000);
		registry.add(ModItems.SHARP_WOODEN_STICK, 50);
		registry.add(ModItems.WOODEN_DAGGER, 200);
		registry.add(ModItems.WOODEN_MALLET, 400);
		registry.add(ModItems.WOODEN_SHOVEL, 250);
		registry.add(ModItems.WOODEN_SPEAR, 250);
		registry.add(ModItems.WOODEN_SWORD, 350);
		//# Miscellaneous #
		registry.add(Items.AZALEA, 200);
		registry.add(Items.DEAD_BUSH, 200);
		registry.add(Items.FLOWERING_AZALEA, 200);
		//# Joke & Unserious #
		registry.add(Items.FLETCHING_TABLE, 16000); // Finally gave the Fletching Table a use, lol. (aside from villager assignment)
		registry.add(ModItems.MINIWIZARD, 25600);
		//# Tags #
		registry.add(Tags.Item.ALL_PLANKS, 300);
		registry.add(Tags.Item.ALL_YARNBALLS, 100);
		registry.add(ItemTags.SAPLINGS, 200);
		registry.add(ItemTags.WOOL_CARPETS, 400);
		registry.add(ItemTags.BANNERS, 1600); // Note: Not precisely calculated.
		// TODO: Add remaining fuels.
	}
	
	/**
	 * Vanilla compostables reference:<br>
	 * {@link net.minecraft.block.ComposterBlock}
	 */
	private static void registerCompostables() {
		logMainEvent("Registering compostables");
		CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
		
		//region Vanilla Removal
		//# Flowers #
		registry.remove(Items.ALLIUM);
		registry.remove(Items.AZURE_BLUET);
		registry.remove(Items.BLUE_ORCHID);
		registry.remove(Items.CORNFLOWER);
		registry.remove(Items.DANDELION);
		registry.remove(Items.LILAC);
		registry.remove(Items.LILY_OF_THE_VALLEY);
		registry.remove(Items.ORANGE_TULIP);
		registry.remove(Items.OXEYE_DAISY);
		registry.remove(Items.PEONY);
		registry.remove(Items.PINK_TULIP);
		registry.remove(Items.POPPY);
		registry.remove(Items.RED_TULIP);
		registry.remove(Items.ROSE_BUSH);
		registry.remove(Items.SPORE_BLOSSOM);
		registry.remove(Items.SUNFLOWER);
		registry.remove(Items.TORCHFLOWER);
		registry.remove(Items.WHITE_TULIP);
		registry.remove(Items.WITHER_ROSE);
		//# Food #
		registry.remove(Items.APPLE);
		registry.remove(Items.BAKED_POTATO);
		registry.remove(Items.BEETROOT);
		registry.remove(Items.BREAD);
		registry.remove(Items.CAKE);
		registry.remove(Items.CARROT);
		registry.remove(Items.COOKIE);
		registry.remove(Items.DRIED_KELP);
		registry.remove(Items.GLOW_BERRIES);
		registry.remove(Items.MELON_SLICE);
		registry.remove(Items.POTATO);
		registry.remove(Items.PUMPKIN_PIE);
		registry.remove(Items.SWEET_BERRIES);
		//# Leaf Blocks #
		registry.remove(Items.ACACIA_LEAVES);
		registry.remove(Items.AZALEA_LEAVES);
		registry.remove(Items.BIRCH_LEAVES);
		registry.remove(Items.CHERRY_LEAVES);
		registry.remove(Items.DARK_OAK_LEAVES);
		registry.remove(Items.FLOWERING_AZALEA_LEAVES);
		registry.remove(Items.JUNGLE_LEAVES);
		registry.remove(Items.MANGROVE_LEAVES);
		registry.remove(Items.OAK_LEAVES);
		registry.remove(Items.SPRUCE_LEAVES);
		//# Mushrooms #
		registry.remove(Items.BROWN_MUSHROOM);
		registry.remove(Items.CRIMSON_FUNGUS);
		registry.remove(Items.RED_MUSHROOM);
		registry.remove(Items.WARPED_FUNGUS);
		//# Opaque Blocks #
		registry.remove(Items.BROWN_MUSHROOM_BLOCK);
		registry.remove(Items.CARVED_PUMPKIN);
		registry.remove(Items.DRIED_KELP_BLOCK);
		registry.remove(Items.HAY_BLOCK);
		registry.remove(Items.MELON);
		registry.remove(Items.MOSS_BLOCK);
		registry.remove(Items.MUSHROOM_STEM);
		registry.remove(Items.NETHER_WART_BLOCK);
		registry.remove(Items.PUMPKIN);
		registry.remove(Items.RED_MUSHROOM_BLOCK);
		registry.remove(Items.SHROOMLIGHT);
		registry.remove(Items.WARPED_WART_BLOCK);
		//# Saplings #
		registry.remove(Items.ACACIA_SAPLING);
		registry.remove(Items.BIRCH_SAPLING);
		registry.remove(Items.CHERRY_SAPLING);
		registry.remove(Items.DARK_OAK_SAPLING);
		registry.remove(Items.JUNGLE_SAPLING);
		registry.remove(Items.MANGROVE_PROPAGULE);
		registry.remove(Items.OAK_SAPLING);
		registry.remove(Items.SPRUCE_SAPLING);
		//# Seed Piles #
		registry.remove(Items.BEETROOT_SEEDS);
		registry.remove(Items.MELON_SEEDS);
		registry.remove(Items.PUMPKIN_SEEDS);
		registry.remove(Items.TORCHFLOWER_SEEDS);
		registry.remove(Items.WHEAT_SEEDS);
		//# Miscellaneous #
		registry.remove(Items.AZALEA);
		registry.remove(Items.BIG_DRIPLEAF);
		registry.remove(Items.CACTUS);
		registry.remove(Items.COCOA_BEANS);
		registry.remove(Items.CRIMSON_ROOTS);
		registry.remove(Items.FERN);
		registry.remove(Items.FLOWERING_AZALEA);
		registry.remove(Items.GLOW_LICHEN);
		registry.remove(Items.HANGING_ROOTS);
		registry.remove(Items.KELP);
		registry.remove(Items.LARGE_FERN);
		registry.remove(Items.LILY_PAD);
		registry.remove(Items.MANGROVE_ROOTS);
		registry.remove(Items.MOSS_CARPET);
		registry.remove(Items.NETHER_SPROUTS);
		registry.remove(Items.NETHER_WART);
		registry.remove(Items.PINK_PETALS);
		registry.remove(Items.PITCHER_PLANT);
		registry.remove(Items.PITCHER_POD);
		registry.remove(Items.SEA_PICKLE);
		registry.remove(Items.SEAGRASS);
		registry.remove(Items.SHORT_GRASS);
		registry.remove(Items.SMALL_DRIPLEAF);
		registry.remove(Items.SUGAR_CANE);
		registry.remove(Items.TALL_GRASS);
		registry.remove(Items.TWISTING_VINES);
		registry.remove(Items.VINE);
		registry.remove(Items.WARPED_ROOTS);
		registry.remove(Items.WEEPING_VINES);
		registry.remove(Items.WHEAT);
		//endregion
		
		//# Flowers #
		registry.add(Items.ALLIUM, 0.5F);
		registry.add(Items.AZURE_BLUET, 0.5F);
		registry.add(Items.BLUE_ORCHID, 0.5F);
		registry.add(Items.CORNFLOWER, 0.5F);
		registry.add(Items.DANDELION, 0.5F);
		registry.add(Items.LILAC, 0.75F);
		registry.add(Items.LILY_OF_THE_VALLEY, 0.5F);
		registry.add(Items.ORANGE_TULIP, 0.5F);
		registry.add(Items.OXEYE_DAISY, 0.5F);
		registry.add(Items.PEONY, 0.75F);
		registry.add(Items.PINK_TULIP, 0.5F);
		registry.add(Items.POPPY, 0.5F);
		registry.add(Items.RED_TULIP, 0.5F);
		registry.add(Items.ROSE_BUSH, 0.75F);
		registry.add(Items.SPORE_BLOSSOM, 0.625F);
		registry.add(Items.SUNFLOWER, 0.625F);
		registry.add(Items.TORCHFLOWER, 0.5F);
		registry.add(Items.WHITE_TULIP, 0.5F);
		registry.add(Items.WITHER_ROSE, 0.5F);
		//# Foods #
		registry.add(Items.APPLE, 0.5F);
		registry.add(ModItems.APPLE_PIE, 1.0F);
		registry.add(ModItems.BAKED_CARROT, 0.625F);
		registry.add(ModItems.BAKED_MUSHROOM, 0.625F);
		registry.add(Items.BAKED_POTATO, 0.625F);
		registry.add(ModItems.BAKED_RADISH, 0.625F);
		registry.add(Items.BEETROOT, 0.5F);
		registry.add(Items.BREAD, 0.875F);
		registry.add(Items.CAKE, 1.0F);
		registry.add(Items.CARROT, 0.5F);
		registry.add(ModItems.CHERRY_BUNCH, 0.125F);
		registry.add(ModItems.CHERRY_JELLYBALL, 0.5F);
		registry.add(ModItems.CHERRY_PIE, 1.0F);
		registry.add(ModItems.CHOCOLATE_BAR, 0.25F);
		registry.add(ModItems.CHULK_BERRY_BUNCH, 0.25F);
		registry.add(Items.COOKIE, 0.375F);
		registry.add(Items.DRIED_KELP, 0.25F);
		registry.add(ModItems.DRY_KELP_BUNDLE, 1.0F);
		registry.add(Items.GLOW_BERRIES, 0.125F);
		registry.add(ModItems.GLOWBERRY_PIE, 1.0F);
		registry.add(ModItems.HONEYBUN, 0.375F);
		registry.add(ModItems.HONEYPOD, 0.625F);
		registry.add(ModItems.LIVE_GRASS_TUFT, 0.25F);
		registry.add(ModItems.MAGMABUN, 0.375F);
		registry.add(Items.MELON_SLICE, 0.375F);
		registry.add(ModItems.MILKLEAF_PILE, 0.875F);
		registry.add(ModItems.NUTRILLARN_GRAM, 0.1667F);
		registry.add(ModItems.NUTRILLARN_INGOT, 1.0F);
		registry.add(Items.POTATO, 0.5F);
		registry.add(ModItems.PUMPKIN_PIE, 1.0F);
		registry.add(ModItems.RAW_APPLE_PIE, 1.0F);
		registry.add(ModItems.RAW_CAKE, 1.0F);
		registry.add(ModItems.RAW_CHERRY_PIE, 1.0F);
		registry.add(ModItems.RAW_COOKIE_BALL, 0.375F);
		registry.add(ModItems.RAW_DOUGH_LUMP, 0.875F);
		registry.add(ModItems.RAW_GLOWBERRY_PIE, 1.0F);
		registry.add(ModItems.RAW_HONEYBUN_BALL, 0.375F);
		registry.add(ModItems.RAW_MAGMABUN_BALL, 0.375F);
		registry.add(ModItems.RAW_NUTRILLARN_LUMP, 1.0F);
		registry.add(ModItems.RAW_NUTRILLARN_NUGGET, 0.1667F);
		registry.add(ModItems.RAW_PUMPKIN_PIE, 1.0F);
		registry.add(ModItems.RAW_SLIMEBUN_BALL, 0.375F);
		registry.add(ModItems.RAW_SWEETBERRY_PIE, 1.0F);
		registry.add(Items.ROTTEN_FLESH, 0.0625F);
		registry.add(ModItems.SLIMEBUN, 0.375F);
		registry.add(Items.SWEET_BERRIES, 0.125F);
		registry.add(ModItems.SWEETBERRY_PIE, 1.0F);
		registry.add(ModItems.WARPED_FLESH_CHUNK, 0.0625F);
		//# Mushrooms #
		registry.add(Items.BROWN_MUSHROOM, 0.5F);
		registry.add(Items.CRIMSON_FUNGUS, 0.5F);
		registry.add(Items.RED_MUSHROOM, 0.5F);
		registry.add(ModItems.STARCHCAP_MUSHROOM, 0.5F);
		registry.add(Items.WARPED_FUNGUS, 0.5F);
		//# Saplings #
		registry.add(Items.ACACIA_SAPLING, 0.5F);
		registry.add(Items.BIRCH_SAPLING, 0.5F);
		registry.add(Items.CHERRY_SAPLING, 0.5F);
		registry.add(Items.DARK_OAK_SAPLING, 0.5F);
		registry.add(Items.JUNGLE_SAPLING, 0.5F);
		registry.add(Items.MANGROVE_PROPAGULE, 0.5F);
		registry.add(Items.OAK_SAPLING, 0.5F);
		registry.add(Items.SPRUCE_SAPLING, 0.5F);
		//# Seed Piles #
		registry.add(Items.BEETROOT_SEEDS, 0.0625F);
		registry.add(Items.MELON_SEEDS, 0.0625F);
		registry.add(Items.PUMPKIN_SEEDS, 0.0625F);
		registry.add(Items.TORCHFLOWER_SEEDS, 0.0625F);
		registry.add(Items.WHEAT_SEEDS, 0.0625F);
		//# Yarnballs #
		registry.add(ModItems.BLACK_YARNBALL, 0.375F);
		registry.add(ModItems.BLUE_YARNBALL, 0.375F);
		registry.add(ModItems.BROWN_YARNBALL, 0.375F);
		registry.add(ModItems.CYAN_YARNBALL, 0.375F);
		registry.add(ModItems.GRAY_YARNBALL, 0.375F);
		registry.add(ModItems.GREEN_YARNBALL, 0.375F);
		registry.add(ModItems.LIGHT_BLUE_YARNBALL, 0.375F);
		registry.add(ModItems.LIGHT_GRAY_YARNBALL, 0.375F);
		registry.add(ModItems.LIME_YARNBALL, 0.375F);
		registry.add(ModItems.MAGENTA_YARNBALL, 0.375F);
		registry.add(ModItems.ORANGE_YARNBALL, 0.375F);
		registry.add(ModItems.PINK_YARNBALL, 0.375F);
		registry.add(ModItems.PURPLE_YARNBALL, 0.375F);
		registry.add(ModItems.RED_YARNBALL, 0.375F);
		registry.add(ModItems.WHITE_YARNBALL, 0.375F);
		registry.add(ModItems.YELLOW_YARNBALL, 0.375F);
		//# Miscellaneous #
		registry.add(Items.AZALEA, 0.625F);
		registry.add(Items.BIG_DRIPLEAF, 0.625F);
		registry.add(Items.BOOK, 0.75F);
		registry.add(Items.CACTUS, 0.5F);
		registry.add(Items.CARVED_PUMPKIN, 0.5F);
		registry.add(Items.CHARCOAL, 0.5F);
		registry.add(ModItems.COBWEB_BALL, 0.5F);
		registry.add(Items.COCOA_BEANS, 0.5F);
		registry.add(ModItems.DRY_GRASS_TUFT, 0.875F);
		registry.add(Items.FERN, 0.5F);
		registry.add(Items.FLOWERING_AZALEA, 0.6875F);
		registry.add(Items.GLOW_LICHEN, 0.375F);
		registry.add(Items.KELP, 0.1875F);
		registry.add(ModItems.LEAF_PILE, 1.0F);
		registry.add(Items.LILY_PAD, 0.5F);
		registry.add(Items.MOSS_CARPET, 0.75F); // TODO: Replace with Dry Moss Wad & Live Moss Wad upon implementation.
		registry.add(Items.NETHER_SPROUTS, 0.625F);
		registry.add(Items.NETHER_WART, 0.625F);
		registry.add(Items.PAPER, 0.125F);
		registry.add(ModItems.PINECONE, 0.375F);
		registry.add(Items.PINK_PETALS, 0.375F);
		registry.add(Items.PITCHER_PLANT, 0.875F);
		registry.add(Items.PITCHER_POD, 0.125F);
		registry.add(Items.SEA_PICKLE, 0.5F);
		registry.add(Items.SEAGRASS, 0.25F);
		registry.add(ModItems.SHARP_WOODEN_STICK, 0.0625F);
		registry.add(ModItems.SILK_WAD, 0.25F);
		registry.add(Items.SMALL_DRIPLEAF, 0.375F);
		registry.add(Items.STICK, 0.125F);
		registry.add(Items.STRING, 0.0625F);
		registry.add(Items.SUGAR_CANE, 0.25F);
		registry.add(Items.TWISTING_VINES, 0.5F);
		registry.add(Items.VINE, 0.5F);
		registry.add(Items.WEEPING_VINES, 0.5F);
		registry.add(Items.WHEAT, 0.875F);
	}
	
	private static void registerCommands() {
		logMainEvent("Registering commands");
	}
	
	private static void registerEvents() {
		logMainEvent("Registering events");
	}
	
	private static void registerPotionRecipes() {
		logMainEvent("Registering potion recipes");
	}
	
	private static void registerCustomTrades() {
		logMainEvent("Registering trades");
	}
	
	private static void registerStrippables() {
		logMainEvent("Registering strippables");
	}
	
	private static void registerFlammables() {
		logMainEvent("Registering flammables");
	}
	
	private static void registerAttributes() {
		logMainEvent("Registering attributes");
	}
	
	private static void registerOxidizables() {
		logMainEvent("Registering oxidizables");
	}
	
	private static void registerPortals() {
		logMainEvent("Registering portals");
	}
}
