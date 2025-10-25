package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


public class ModCommands {
	public ModCommands() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static void register() {
		logMainEvent("Registering commands");
	}
}
