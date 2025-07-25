package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.Main;
import net.minecraft.block.Block;
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

import javax.naming.Name;

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
	private static final String ANSI__BRIGHT_MAGENTA = "\u001B[95m";
	
	private static void printInfo(String message) {
		LOGGER.info(ANSI__BRIGHT_MAGENTA + "{}" + ANSI_RESET, message);
	}
	
	private static void printError(String message) {
		LOGGER.error(message);
	}

//	private static void logWithColor(String message, String color) {
//		LOGGER.info("{}{}" + ANSI_RESET, color, message);
//	}
	
	public static void log(String message) {
		if (Main.DEBUG) {
			printInfo(">>> " + message);
		}
	}
	
	public static void logError(String message) {
		if (Main.DEBUG) {
			printError(">>> " + message);
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
	
	public static class Tags {
		// NOTE: Tags allow for the grouping of block, entity, and item types.
		// This is useful for implementing logic based on the qualities of blocks, entities, and items,
		//  rather than have the logic be hardcoded to particular types.
		// E.g:
		// - Crafting recipes which can use one of multiple item types interchangeably, such as planks to make sticks.
		
		public static class Block {
//			public static final TagKey<net.minecraft.block.Block> REFERENCE_PLACEHOLDER = of("reference_placeholder");
			
			
			private static TagKey<net.minecraft.block.Block> of(String id) {
				return TagKey.of(RegistryKeys.BLOCK, identifier(id));
			}
			
			private static TagKey<net.minecraft.block.Block> ofCommon(String id) {
				return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", id));
			}
		}
		
		public static class Entity {
			public static final TagKey<EntityType<?>> ALL_NECROMANTOIDS = of("all_necromantoids");
			
			
			private static TagKey<EntityType<?>> of(String id) {
				return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(id));
			}
			
			private static TagKey<EntityType<?>> ofCommon(String id) {
				return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("c", id));
			}
		}
		
		public static class Item {
			//# Basic Materials #
			public static final TagKey<net.minecraft.item.Item> ALL_BRICKS = of("all_bricks");
			public static final TagKey<net.minecraft.item.Item> ALL_COBBLESTONES = of("all_cobblestones");
			public static final TagKey<net.minecraft.item.Item> ALL_GLASSY_SAND_PILES = of("all_glassy_sand_piles");
			public static final TagKey<net.minecraft.item.Item> ALL_METAL_GRAMS = of("all_metal_grams");
			public static final TagKey<net.minecraft.item.Item> ALL_MUSHROOMS = of("all_mushrooms");
			public static final TagKey<net.minecraft.item.Item> ALL_PLANKS = of("all_planks");
			public static final TagKey<net.minecraft.item.Item> ALL_YARNBALLS = of("all_yarnballs");
			public static final TagKey<net.minecraft.item.Item> ALL_YARNBALLS_WHICH_DYE_TO_BLACK = of("all_yarnballs_which_dye_to_black");
			public static final TagKey<net.minecraft.item.Item> ALL_YARNBALLS_WHICH_DYE_TO_LIGHT_GRAY = of("all_yarnballs_which_dye_to_light_gray");
			public static final TagKey<net.minecraft.item.Item> ARROWHEAD_MATERIALS = of("arrowhead_materials");
			public static final TagKey<net.minecraft.item.Item> BASIC_FLAME_MATERIALS = of("basic_flame_materials");
			public static final TagKey<net.minecraft.item.Item> SPIRIT_FLAME_MATERIALS = of("spirit_flame_materials");
			//# Equipment #
			public static final TagKey<net.minecraft.item.Item> ALL_CHOPPING_TOOLS = of("all_chopping_tools");
			public static final TagKey<net.minecraft.item.Item> ALL_POUNDING_TOOLS = of("all_pounding_tools");
			
			
			private static TagKey<net.minecraft.item.Item> of(String id) {
				return TagKey.of(RegistryKeys.ITEM, identifier(id));
			}
			
			private static TagKey<net.minecraft.item.Item> ofCommon(String id) {
				return TagKey.of(RegistryKeys.ITEM, new Identifier("c", id));
			}
		}
	}
	
}
