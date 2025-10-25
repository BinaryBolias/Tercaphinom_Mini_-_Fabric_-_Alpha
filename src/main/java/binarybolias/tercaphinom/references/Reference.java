package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Reference {
	// The namespace used for the entire mod.
	public static String ModID = "tercaphinom";
	// The logger for this mod. Shows the mod namespace for every message.
	public static final Logger LOGGER = LoggerFactory.getLogger("Tercaphinom");
	
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_MAGENTA = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";
	private static final String ANSI_BRIGHT_MAGENTA = "\u001B[95m";
	
	
//	private static void printInfo(String message) {
//		LOGGER.info(ANSI_CYAN + "{}" + ANSI_RESET, message);
//	}
	
	
//	private static void printMainEvent(String message) {
//		LOGGER.info(ANSI_BRIGHT_MAGENTA + "{}" + ANSI_RESET, message);
//	}
	
	
	private static void printWarning(String message) {
		LOGGER.warn(message);
	}
	
	
	private static void printError(String message) {
		LOGGER.error(message);
	}
	
	
	private static void printWithColor(String message, String color) {
		LOGGER.info("{}{}" + ANSI_RESET, color, message);
	}
	
	
	public static void log(String message) {
		if (Main.DEBUG) {
//			printInfo(message);
			printWithColor("> " + message, ANSI_CYAN);
		}
	}
	
	
	public static void logMainEvent(String message) {
		if (Main.DEBUG) {
//			printMainEvent(">>> " + message);
			printWithColor(">>> " + message, ANSI_BRIGHT_MAGENTA);
		}
	}
	
	
	public static void logWarning(String message) {
		if (Main.DEBUG) {
			printWarning(message);
		}
	}
	
	
	public static void logError(String message) {
		if (Main.DEBUG) {
			printError(message);
		}
	}
	
//	public static void logMajor(String message) {
//		if (Main.DEBUG) {
//			printInfo(">>>" + message);
//		}
//	}
	
//	public static void logFor(String message) {
//		if (Main.DEBUG) {
//			logWithColor(message, ANSI_CYAN);
//		}
//	}
	
	@NotNull
	public static Identifier identifier(@NotNull String path) {
		return new Identifier(ModID, path);
	}
	
	
	public static MutableText translate(String key, Object ... params) {
		return Text.translatable(ModID + "." + key, params);
	}
	
	
	public static MutableText translate(Item item, String key, Object ... params) {
		return Text.translatable(item.getTranslationKey() + "." + key, params);
	}
	
	
	public static MutableText itemTooltip(Item item, String key, Object ... params) {
		return translate(item, "tooltip." + key, params);
	}
	
	
	public static class Tags {
		// NOTE: Tags allow for the grouping of block, entity, and item types.
		// This is useful for implementing logic based on the qualities of blocks, entities, and items,
		//  rather than have the logic be hardcoded to particular types.
		// E.g:
		// - Crafting recipes which can use one of multiple item types interchangeably, such as planks to make sticks.
		
		// DEPRECATED; using binarybolias.tercaphinom.registry.tag.BlockTags instead.
		@Deprecated
		public static class Block {
			// This "nil" block tag to be intentionally left empty.
			// Used for situations where defining a block tag is necessary, but undesired.
//			public static final TagKey<net.minecraft.block.Block> NIL = of("nil");
			
			//# Blacklists & Whitelists
//			public static final TagKey<net.minecraft.block.Block> BLACKLISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON = of("blacklisted_for_layered_mound_placement_upon");
//			public static final TagKey<net.minecraft.block.Block> WHITELISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON = of("whitelisted_for_layered_mound_placement_upon");
			//# Block Types #
//			public static final TagKey<net.minecraft.block.Block> ALL_ETERNALITH_BLOCKS = of("all_eternalith_blocks");
//			public static final TagKey<net.minecraft.block.Block> ALL_COBBLED_STONE_BLOCKS = of("all_cobbled_stone_blocks");
//			public static final TagKey<net.minecraft.block.Block> ALL_NATURAL_STONE_BLOCKS = of("all_natural_stone_blocks");
//			public static final TagKey<net.minecraft.block.Block> ALL_REFINED_STONE_BLOCKS = of("all_refined_stone_blocks");
//			public static final TagKey<net.minecraft.block.Block> ALL_RAW_METAL_BLOCKS = of("all_raw_metal_blocks");
//			public static final TagKey<net.minecraft.block.Block> ALL_REFINED_METAL_BLOCKS = of("all_refined_metal_blocks");
			//# Geological #
//			public static final TagKey<net.minecraft.block.Block> GEOLOGICALLY_COMPACTS_STRONGLY = of("geologically_compacts_strongly");
//			public static final TagKey<net.minecraft.block.Block> GEOLOGICALLY_COMPACTS_WEAKLY = of("geologically_compacts_weakly");
			//# Other Behaviors #
//			public static final TagKey<net.minecraft.block.Block> SPREADABLE_ATOP_ASHY_NETHERRACK = of("spreadable_atop_ashy_netherrack");
//			public static final TagKey<net.minecraft.block.Block> SPREADABLE_INTO_ASHY_NETHERRACK = of("spreadable_into_ashy_netherrack");
//			public static final TagKey<net.minecraft.block.Block> SPREADABLE_ONTO_ASHY_NETHERRACK = of("spreadable_onto_ashy_netherrack");
			
			
			private static TagKey<net.minecraft.block.Block> of(String id) {
				return TagKey.of(RegistryKeys.BLOCK, identifier(id));
			}
			
			private static TagKey<net.minecraft.block.Block> ofCommon(String id) {
				return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", id));
			}
		}
		
		
		// DEPRECATED; using binarybolias.tercaphinom.registry.tag.EntityTags instead.
		@Deprecated
		public static class Entity {
//			public static final TagKey<EntityType<?>> ALL_NECROMANTOIDS = of("all_necromantoids");
//			public static final TagKey<EntityType<?>> BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM = of("blacklisted_for_target_teleporter_item");
			
			
			private static TagKey<EntityType<?>> of(String id) {
				return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(id));
			}
			
			private static TagKey<EntityType<?>> ofCommon(String id) {
				return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("c", id));
			}
		}
		
		
		// DEPRECATED; using binarybolias.tercaphinom.registry.tag.ItemTags instead.
		@Deprecated
		public static class Item {
			//# Basic Materials #
//			public static final TagKey<net.minecraft.item.Item> ALL_COBBLESTONES = of("all_cobblestones");
//			public static final TagKey<net.minecraft.item.Item> ALL_GLASSY_SAND_PILES = of("all_glassy_sand_piles");
//			public static final TagKey<net.minecraft.item.Item> ALL_LARGE_BRICKS = of("all_large_bricks");
//			public static final TagKey<net.minecraft.item.Item> ALL_METAL_GRAMS = of("all_metal_grams");
//			public static final TagKey<net.minecraft.item.Item> ALL_MUSHROOMS = of("all_mushrooms");
//			public static final TagKey<net.minecraft.item.Item> ALL_PLANKS = of("all_planks");
//			public static final TagKey<net.minecraft.item.Item> ALL_STAINED_GLASS_PANES = of("all_stained_glass_panes");
//			public static final TagKey<net.minecraft.item.Item> ALL_YARN_ROLLS = of("all_yarn_rolls");
//			public static final TagKey<net.minecraft.item.Item> ALL_YARNBALLS = of("all_yarnballs");
//			public static final TagKey<net.minecraft.item.Item> ARROWHEAD_MATERIALS = of("arrowhead_materials");
//			public static final TagKey<net.minecraft.item.Item> BROOM_MATERIALS = of("broom_materials");
//			public static final TagKey<net.minecraft.item.Item> RAW_CAKE_BERRIES = of("raw_cake_berries");
			//# Decomposable Materials #
//			public static final TagKey<net.minecraft.item.Item> DECOMPOSABLE_MATERIALS = of("decomposable_materials");
			//# Rottable Meats #
//			public static final TagKey<net.minecraft.item.Item> SMALL_ROTTABLE_MEATS = of("small_rottable_meats");
//			public static final TagKey<net.minecraft.item.Item> LARGE_ROTTABLE_MEATS = of("large_rottable_meats");
			//# Containers # // NOTE: These tags probably to be deprecated.
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_BRIMWATER = of("small_containers_of_brimwater");
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_FREEZEWATER = of("small_containers_of_freezewater");
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_HONEY = of("small_containers_of_honey");
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_MILK = of("small_containers_of_milk");
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_STEAMING_WATER = of("small_containers_of_steaming_water");
//			public static final TagKey<net.minecraft.item.Item> SMALL_CONTAINERS_OF_WATER = of("small_containers_of_water");
			//# Equipment #
//			public static final TagKey<net.minecraft.item.Item> ALL_CHOPPING_TOOLS = of("all_chopping_tools");
//			public static final TagKey<net.minecraft.item.Item> ALL_POUNDING_TOOLS = of("all_pounding_tools");
			//# Flame & Torch Materials #
//			public static final TagKey<net.minecraft.item.Item> BASIC_FLAME_MATERIALS = of("basic_flame_materials");
//			public static final TagKey<net.minecraft.item.Item> SPIRIT_FLAME_MATERIALS = of("spirit_flame_materials");
//			public static final TagKey<net.minecraft.item.Item> STRONG_TORCH_BINDERS = of("strong_torch_binders");
//			public static final TagKey<net.minecraft.item.Item> WEAK_TORCH_BINDERS = of("weak_torch_binders");
			//# Spawn Eggs #
//			public static final TagKey<net.minecraft.item.Item> ALL_SPAWN_EGGS = of("all_spawn_eggs");
			
			
			private static TagKey<net.minecraft.item.Item> of(String id) {
				return TagKey.of(RegistryKeys.ITEM, identifier(id));
			}
			
			private static TagKey<net.minecraft.item.Item> ofCommon(String id) {
				return TagKey.of(RegistryKeys.ITEM, new Identifier("c", id));
			}
		}
	}
	
}
