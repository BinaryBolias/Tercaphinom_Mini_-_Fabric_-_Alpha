package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static binarybolias.tercaphinom.references.Reference.identifier;
import static binarybolias.tercaphinom.references.Reference.log;

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
	
	private static Item newItem(int maxCount) {
		return new Item(new FabricItemSettings().maxCount(maxCount));
	}
	
	private static Item newItem(int maxCount, FabricItemSettings settings) {
		return new Item(new FabricItemSettings().maxCount(maxCount));
	}
	
//	private static FabricItemSettings newSettings
	
	//### Items ###
	// ## Basic Resources ##
	// # Ball #
	
	// # Brick #
	public static final Item STIEFANE_BRICK = registerItem("stiefane_brick", new Item(new FabricItemSettings()));
	
	// # Cobblestone #
	public static final Item STIEFANE_COBBLESTONE = registerItem("stiefane_cobblestone", new Item(new FabricItemSettings()));
	
	// # Ingot #
	
	// # Jewel #
	
	// # Log & Trunk #
	
	// # Lump #
	
	// # Nugget #
	
	// # Pile (seed) #
	
	// # Pile (miscellaneous) #
	
	// # Plank #
	public static final Item OAK_PLANK = registerItem("oak_plank", new Item(new FabricItemSettings()));
	public static final Item VERDAK_PLANK = registerItem("verdak_plank", new Item(new FabricItemSettings()));
	
	// # Rod & Stick #
	
	// # Shard #
	
	// # Miscellaneous #
	public static final Item GRASS_TUFT = registerItem("grass_tuft", newItem(96));
	public static final Item SILK_WAD = registerItem("silk_wad", newItem(96));
	
	
	//region  ## Equipment ##
	
	//# [Tier 0] Wooden Stick #
	public static final Item SHARP_WOODEN_STICK = registerItem("sharp_wooden_stick",
//			new Item(new FabricItemSettings().maxDamage(15)))
			new PickaxeItem(ToolMaterials.WOOD, 2, 2.0F, new FabricItemSettings().maxDamage(15)));
	
	//# [Tier 1] Wood #
	
	//# [Tier 2] Flint #
	
	//# [Tier 2] Glass #
	
	//# [Tier 2] Obsidian #
	
	//# [Tier 3] Copper #
	
	//# [Tier 3] Eiduril #
	
	//# [Tier 3] Gold #
	
	//# [Tier 3] Iron #
	
	//endregion
	
	
	//## Joke ##
}
