package binarybolias.tercaphinom.registry.tag;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static binarybolias.tercaphinom.references.Reference.identifier;


/**
 * Provides code access to entity type tags.
 * @apiNote Tags defined here should be populated by {@link binarybolias.tercaphinom.datagen.ModEntityTagProvider}.
 * @see net.minecraft.registry.tag.EntityTypeTags
 */
public interface EntityTags {
	//region ## Blacklists & Whitelists ##
	//# Miscellaneous #
	TagKey<EntityType<?>> BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM = of("blacklisted_for_target_teleporter_item");
	//endregion
	
	//region ## Entity Classification ##
	//# Miscellaneous #
	TagKey<EntityType<?>> ALL_GOLEMS = of("all_golems");
	TagKey<EntityType<?>> ALL_NECROMANTOIDS = of("all_necromantoids");
	TagKey<EntityType<?>> ALL_WISPRITES = of("all_wisprites");
	//endregion
	
	//region ## Hostility ##
	TagKey<EntityType<?>> VILBIARN_GOLEM_ENEMIES = of("vilbiarn_golem_enemies");
	//endregion
	
	
	private static TagKey<EntityType<?>> of(String id) {
		return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(id));
	}
	
	
	private static TagKey<EntityType<?>> ofCommon(String id) {
		return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("c", id));
	}
}
