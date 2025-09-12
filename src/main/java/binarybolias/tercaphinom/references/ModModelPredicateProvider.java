package binarybolias.tercaphinom.references;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;

public class ModModelPredicateProvider {
	public ModModelPredicateProvider() {
		// Disable instantiation.
		throw new AssertionError();
	}
	// NOTE: Model predicates allow for the conditional changing of item models.
	// E.g:
	// - Bow and crossbow animation.
	
	public static void register() {
		logMainEvent("Registering model predicates");
	}
}
