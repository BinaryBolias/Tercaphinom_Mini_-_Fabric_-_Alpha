package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


public class ModScreenHandlers {
	public ModScreenHandlers() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static void register() {
		logMainEvent("Registering screen handlers");
	}
}
