package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.world.ModWorldGeneration;
import binarybolias.tercaphinom.references.*;
import net.fabricmc.api.ModInitializer;

import static binarybolias.tercaphinom.references.Reference.*;


public class Main implements ModInitializer {
	public static final boolean DEBUG = true;
	
	@Override
	public void onInitialize() {
		logMainEvent("Initializing Tercaphinom");
		// Register vital classes for Tercaphinom content.
		ModItems.register();
		ModBlocks.register();
		ModItemGroups.register();
		ModCommands.register();
		ModBlockEntities.register();
		ModScreenHandlers.register();
		ModRecipes.register();
		ModWorldGeneration.register();
		ModMessages.registerC2SPackets();
		ModEffects.register();
		
		ModRegistries.register();
	}
}
