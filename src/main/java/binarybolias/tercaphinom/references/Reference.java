package binarybolias.tercaphinom.references;

import binarybolias.tercaphinom.Main;
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
	
	public static class ModTags {
		// NOTE: Tags allow for the grouping of block, entity, and item types.
		// This is useful for implementing logic based on the qualities of blocks, entities, and items,
		//  rather than have the logic be hardcoded to particular types.
		// E.g:
		// - Crafting recipes which can use one of multiple item types interchangeably, such as planks to make sticks.
		
		public static class Blocks {
		
		}
		
		public static class Items {
		
		}
		
		public static class Entities {
		
		}
	}
	
}
