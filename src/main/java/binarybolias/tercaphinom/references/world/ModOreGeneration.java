package binarybolias.tercaphinom.references.world;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;

public class ModOreGeneration {
	public ModOreGeneration() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void generate() {
		logMainEvent("Registering ore generation data");
	}
}
