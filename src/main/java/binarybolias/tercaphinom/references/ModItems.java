package binarybolias.tercaphinom.references;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModItems {
	public ModItems() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering items");
	}
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, identifier(name), item);
	}
}
