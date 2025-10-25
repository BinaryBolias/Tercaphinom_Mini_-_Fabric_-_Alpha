package binarybolias.tercaphinom;

import binarybolias.tercaphinom.references.world.ModWorldGeneration;
import binarybolias.tercaphinom.references.*;
import net.fabricmc.api.ModInitializer;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * TODO: Put this elsewhere:<br>
 * {@link net.minecraft.data.server.advancement.vanilla.VanillaAdvancementProviders}
 */
public class Main implements ModInitializer {
	public static final boolean DEBUG = true;
	
	
	@Override
	public void onInitialize() {
		logMainEvent("Initializing Tercaphinom");
		// Register vital classes for Tercaphinom content.
		//TODO: Determine how this actually works.
		// - Most of these 'register' methods don't actually have any function except to print a log message.
		//  - Does calling these methods enforce their classes to load their member variables?
		//   - This would thus still enforce a loading order, perhaps?
		//    - Item definitions require block data, but items are "registered" prior to blocks...
		//  - Perhaps it is a basic Java feature that a class is not initialized until a member variable or method is accessed?
		//   - Thus, items and blocks and such are only registered when the classes defining them have a method called.
		//    - Perhaps also when a block or item is accessed through its internal reference variable for the first time.
		// - According to online research:
		//  - The static variables of a class are initialized when the class is loaded.
		//  - A class is loaded when it is referenced in any way for the first time.
		
		// Item registration
		ModItems.bootstrap();
		JAUItems.bootstrap();
		VMOItems.bootstrap();
		// Block registration
		ModBlocks.bootstrap();
		JAUBlocks.bootstrap();
		VMOBlocks.bootstrap();
		
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
