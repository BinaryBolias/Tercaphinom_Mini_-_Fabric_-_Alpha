package binarybolias.tercaphinom.references.world;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModWorldGeneration {
	public ModWorldGeneration() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering world generation");
		// NOTE: These are called in a particular order.
		// - The purpose ot this ordering is not yet known to me.
		// - This is apparently (not confirmed for myself) the order vanilla Minecraft uses.
		ModGeodeGeneration.generate();
		ModOreGeneration.generate();
		ModTreeGeneration.generate();
		ModFlowerGeneration.generate();
		ModEntitySpawns.addSpawns();
	}
}
