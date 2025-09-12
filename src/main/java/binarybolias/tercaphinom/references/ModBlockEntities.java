package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;

public class ModBlockEntities {
	public ModBlockEntities() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		logMainEvent("Registering block entities");
	}
}
