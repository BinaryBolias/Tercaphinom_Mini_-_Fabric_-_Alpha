package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.registry.tag.EntityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;
import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * @see net.minecraft.data.server.tag.vanilla.VanillaEntityTypeTagProvider
 */
public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		logMainEvent("Generating entity tag data");
		
		getOrCreateTagBuilder(EntityTypeTags.AQUATIC)
				.add(EntityType.DROWNED)
		;
		
		getOrCreateTagBuilder(EntityTypeTags.ARROWS);
		
		getOrCreateTagBuilder(EntityTags.ALL_GOLEMS)
				.add(EntityType.BLAZE)
				.add(EntityType.IRON_GOLEM)
				.add(EntityType.SNOW_GOLEM)
		;
		getOrCreateTagBuilder(EntityTypeTags.SKELETONS);
		getOrCreateTagBuilder(EntityTypeTags.ZOMBIES);
		// Note: "necromantoid" to be a replacement term for "undead".
		getOrCreateTagBuilder(EntityTypeTags.UNDEAD).setReplace(true).addTag(EntityTags.ALL_NECROMANTOIDS);
		getOrCreateTagBuilder(EntityTags.ALL_NECROMANTOIDS)
				.addTag(EntityTypeTags.SKELETONS)
				.addTag(EntityTypeTags.ZOMBIES)
				.add(EntityType.PHANTOM)
				.add(EntityType.WITHER)
		;
		getOrCreateTagBuilder(EntityTags.ALL_WISPRITES)
				.add(EntityType.ALLAY)
				.add(EntityType.VEX)
		;
		
		getOrCreateTagBuilder(EntityTypeTags.IGNORES_POISON_AND_REGEN).setReplace(true)
				.addTag(EntityTags.ALL_GOLEMS)
				.addTag(EntityTags.ALL_NECROMANTOIDS)
				.addTag(EntityTags.ALL_WISPRITES)
				.add(EntityType.WARDEN)
		;
		
		getOrCreateTagBuilder(EntityTypeTags.ARTHROPOD)
				.add(EntityType.SHULKER)
				.add(EntityType.WARDEN)
		;
		
		getOrCreateTagBuilder(EntityTypeTags.SENSITIVE_TO_BANE_OF_ARTHROPODS) // Note: Arthropods are included by default.
				.add(EntityType.CREEPER)
		;
		
		getOrCreateTagBuilder(EntityTags.BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM)
				.add(EntityType.ENDER_DRAGON);
		
		getOrCreateTagBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE)
				// TODO: Add rabbits if not immune already.
//				.add(EntityType.RABBIT)
		;
		
		getOrCreateTagBuilder(EntityTags.VILBIARN_GOLEM_ENEMIES)
				.addTag(EntityTypeTags.UNDEAD)
				// Golems
				.add(EntityType.BLAZE)
				// Ildubans
				.add(EntityType.EVOKER, EntityType.PILLAGER, EntityType.VINDICATOR, EntityType.ILLUSIONER)
				// Jellins
				.add(EntityType.SLIME, EntityType.MAGMA_CUBE)
				// Piglins
				.add(EntityType.PIGLIN, EntityType.PIGLIN_BRUTE)
				// Spiders
				.add(EntityType.SPIDER, EntityType.CAVE_SPIDER)
				
				.add(EntityType.CREEPER)
				.add(EntityType.ENDERMITE)
				.add(EntityType.GHAST)
				.add(EntityType.RAVAGER)
				.add(EntityType.SILVERFISH)
				.add(EntityType.VEX)
		// Notably not including:
		// - Endermen
		// - Witches
		// - [ocean monument guardians]
		;
	}
}
