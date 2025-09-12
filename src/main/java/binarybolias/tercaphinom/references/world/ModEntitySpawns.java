package binarybolias.tercaphinom.references.world;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;

public class ModEntitySpawns {
	public ModEntitySpawns() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void addSpawns() {
		logMainEvent("Registering entity spawn data");
	}
}
