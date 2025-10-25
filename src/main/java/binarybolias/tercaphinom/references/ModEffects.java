package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


public class ModEffects {
	public ModEffects() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	
	public static void register() {
		logMainEvent("Registering effects");
	}
}
