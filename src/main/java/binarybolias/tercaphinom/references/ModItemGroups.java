package binarybolias.tercaphinom.references;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModItemGroups {
	public ModItemGroups() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void register() {
		log("Registering item groups");
	}
	
	private static Text displayName(String groupIdentifier) {
		return translate("item_group." + groupIdentifier);
	}
	// NOTE: There has to be a better way! TODO: Find a way to create item groups more easily.
	public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_blocks_group"),
			FabricItemGroup.builder().displayName(displayName("blocks"))
					.icon(() -> new ItemStack(ModBlocks.ETERNALITH))
					.entries(((displayContext, entries) -> {
						entries.add(ModBlocks.VERDAK_LOG);
						entries.add(ModBlocks.VERDAK_TRUNK);
						entries.add(ModBlocks.VERDAK_PLANK_BLOCK);
						entries.add(ModBlocks.STIEFANE_BRICK_BLOCK);
						entries.add(ModBlocks.COBBLED_STIEFANE_BLOCK);
						entries.add(ModBlocks.STIEFANE_BLOCK);
						entries.add(ModBlocks.POLISHED_STIEFANE_BLOCK);
						entries.add(ModBlocks.STIEFANE_LAPIS_ORE);
						entries.add(ModBlocks.STIEFANE_BUTTON);
						entries.add(ModBlocks.STIEFANE_PRESSURE_PLATE);
						entries.add(ModBlocks.VERDAK_BUTTON);
						entries.add(ModBlocks.VERDAK_PRESSURE_PLATE);
						entries.add(ModBlocks.VERDAK_DOOR);
						entries.add(ModBlocks.VERDAK_HATCH);
						entries.add(ModBlocks.STIEFANE_BRICK_WALL_POST);
						entries.add(ModBlocks.VERDAK_FENCE_GATE);
						entries.add(ModBlocks.VERDAK_FENCE_POST);
						entries.add(ModBlocks.STIEFANE_BRICK_SLAB);
						entries.add(ModBlocks.STIEFANE_BRICK_STAIR);
						entries.add(ModBlocks.VERDAK_PLANK_SLAB);
						entries.add(ModBlocks.VERDAK_PLANK_STAIR);
						entries.add(ModBlocks.ETERNALITH);
						entries.add(ModBlocks.ULTRASMOOTH_STONE);
					})).build());
	public static final ItemGroup EQUIPMENT = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "equipment_group"),
			FabricItemGroup.builder().displayName(displayName("equipment"))
					.icon(() -> new ItemStack(ModItems.SHARP_WOODEN_STICK))
					.entries(((displayContext, entries) -> {
						entries.add(ModItems.SHARP_WOODEN_STICK);
					})).build());
	public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
			identifier(ModID + "_ingredients_group"),
			FabricItemGroup.builder().displayName(displayName("ingredients"))
					.icon(() -> new ItemStack(ModItems.OAK_PLANK))
					.entries(((displayContext, entries) -> {
						entries.add(ModItems.STIEFANE_BRICK);
						entries.add(ModItems.STIEFANE_COBBLESTONE);
						entries.add(ModItems.OAK_PLANK);
						entries.add(ModItems.VERDAK_PLANK);
						entries.add(ModItems.GRASS_TUFT);
						entries.add(ModItems.SILK_WAD);
					})).build());
}
