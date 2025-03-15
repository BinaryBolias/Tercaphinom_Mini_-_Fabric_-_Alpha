package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.registry.FuelRegistry;

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
	
	private static void registerFuels() {
		Reference.log("Registering fuels");
		FuelRegistry registry = FuelRegistry.INSTANCE;
	}
	
	private static void registerCompostables() {
		Reference.log("Registering compostables");
	}
	
	private static void registerCommands() {
		Reference.log("Registering commands");
	}
	
	private static void registerEvents() {
		Reference.log("Registering events");
	}
	
	private static void registerPotionRecipes() {
		Reference.log("Registering potion recipes");
	}
	
	private static void registerCustomTrades() {
		Reference.log("Registering trades");
	}
	
	private static void registerStrippables() {
		Reference.log("Registering strippables");
	}
	
	private static void registerFlammables() {
		Reference.log("Registering flammables");
	}
	
	private static void registerAttributes() {
		Reference.log("Registering attributes");
	}
	
	private static void registerOxidizables() {
		Reference.log("Registering oxidizables");
	}
	
	private static void registerPortals() {
		Reference.log("Registering portals");
	}
}
