package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.LOGGER;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModEffects {
	public ModEffects() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering effects");
	}
}
