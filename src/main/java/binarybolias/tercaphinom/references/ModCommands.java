package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.LOGGER;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModCommands {
	public ModCommands() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering commands");
	}
}
