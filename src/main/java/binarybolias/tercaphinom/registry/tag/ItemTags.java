package binarybolias.tercaphinom.registry.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static binarybolias.tercaphinom.references.Reference.identifier;


/**
 * Provides code access to item tags.
 * @apiNote Tags defined here should be populated by {@link binarybolias.tercaphinom.datagen.ModItemTagProvider}.
 * @see net.minecraft.registry.tag.ItemTags
 */
public interface ItemTags {
	//region ## Crafting Materials ##
	//# Flame & Torch Materials #
	TagKey<Item> BASIC_FLAME_MATERIALS = of("basic_flame_materials");
	TagKey<Item> SPIRIT_FLAME_MATERIALS = of("spirit_flame_materials");
	TagKey<Item> STRONG_TORCH_BINDERS = of("strong_torch_binders");
	TagKey<Item> WEAK_TORCH_BINDERS = of("weak_torch_binders");
	//# Meat Rotting #
	TagKey<Item> LARGE_ROTTABLE_MEATS = of("large_rottable_meats");
	TagKey<Item> SMALL_ROTTABLE_MEATS = of("small_rottable_meats");
	//# Containers #
	//DEPRECATED: Container item tags
	// - Recipes to likely use either bowls or bottles instead (generally bowls).
	// - Basic grid crafting update required; remainder override functionality needed for various recipes.
	TagKey<Item> SMALL_CONTAINERS_OF_BRIMWATER = of("small_containers_of_brimwater");
	TagKey<Item> SMALL_CONTAINERS_OF_FREEZEWATER = of("small_containers_of_freezewater");
	TagKey<Item> SMALL_CONTAINERS_OF_HONEY = of("small_containers_of_honey");
	TagKey<Item> SMALL_CONTAINERS_OF_MILK = of("small_containers_of_milk");
	TagKey<Item> SMALL_CONTAINERS_OF_STEAMING_WATER = of("small_containers_of_steaming_water");
	TagKey<Item> SMALL_CONTAINERS_OF_WATER = of("small_containers_of_water");
	//# Miscellaneous #
	TagKey<Item> ARROWHEAD_MATERIALS = of("arrowhead_materials");
	TagKey<Item> BROOM_MATERIALS = of("broom_materials");
	TagKey<Item> DECOMPOSABLE_MATERIALS = of("decomposable_materials");
	TagKey<Item> PLACEABLE_BLOCK_MATERIAL_BINDERS = of("placeable_block_material_binders");
	TagKey<Item> RAW_CAKE_BERRIES = of("raw_cake_berries");
	//endregion
	
	//region ## Item Classification ##
	//# Miscellaneous #
	TagKey<Item> ALL_COBBLESTONES = of("all_cobblestones");
	TagKey<Item> ALL_GLASSY_SAND_PILES = of("all_glassy_sand_piles");
	TagKey<Item> ALL_LARGE_BRICKS = of("all_large_bricks");
	TagKey<Item> ALL_METAL_GRAMS = of("all_metal_grams");
	TagKey<Item> ALL_PLANKS = of("all_planks");
	TagKey<Item> ALL_SPAWN_EGGS = of("all_spawn_eggs");
	TagKey<Item> ALL_STAINED_GLASS_PANES = of("all_stained_glass_panes");
	TagKey<Item> ALL_YARN_ROLLS = of("all_yarn_rolls");
	TagKey<Item> ALL_YARNBALLS = of("all_yarnballs");
	//endregion
	
	//region ## Equipment ##
	//# By Classification #
	TagKey<Item> ALL_AXES = of("all_axes");
	TagKey<Item> ALL_DAGGERS = of("all_daggers");
	TagKey<Item> ALL_HATCHETS = of("all_hatchets");
	TagKey<Item> ALL_HOES = of("all_hoes");
	TagKey<Item> ALL_MALLETS = of("all_mallets");
	TagKey<Item> ALL_PICKAXES = of("all_pickaxes");
	TagKey<Item> ALL_SHOVELS = of("all_shovels");
	TagKey<Item> ALL_SPEARS = of("all_spears");
	TagKey<Item> ALL_SWORDS = of("all_swords");
	//# By Function #
	TagKey<Item> ALL_CHOPPING_TOOLS = of("all_chopping_tools");
	TagKey<Item> ALL_POUNDING_TOOLS = of("all_pounding_tools");
	TagKey<Item> ALL_SLICING_TOOLS = of("all_slicing_tools");
	//# Miscellaneous #
	//endregion
	
	//region ## Miscellaneous ##
	TagKey<Item> VILBIARN_GOLEM_REPAIR_MATERIALS = of("vilbiarn_golem_repair_materials");
	//endregion
	
	
	private static TagKey<Item> of(String id) {
		return TagKey.of(RegistryKeys.ITEM, identifier(id));
	}
	
	
	private static TagKey<Item> ofCommon(String id) {
		return TagKey.of(RegistryKeys.ITEM, new Identifier("c", id));
	}
}
