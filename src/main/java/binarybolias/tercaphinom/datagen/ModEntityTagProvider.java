package binarybolias.tercaphinom.datagen;

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
		
		getOrCreateTagBuilder(EntityTypeTags.ARTHROPOD)
				.add(EntityType.SHULKER) // These guys seem like arthropods to me.
				.add(EntityType.WARDEN) // Seems like it has a shell-type thing going on; it could probably pass as an arthropod.
		;
		
		getOrCreateTagBuilder(EntityTypeTags.SENSITIVE_TO_BANE_OF_ARTHROPODS) // Huh... This is its own tag... (arthropods are included by default)
				.add(EntityType.CREEPER) // Just for game balance, and because I don't like these guys.
		;
		
		getOrCreateTagBuilder(EntityTypeTags.UNDEAD).addTag(Tags.Entity.ALL_NECROMANTOIDS); // Note: "necromantoid" to be a replacement term for "undead".
		getOrCreateTagBuilder(Tags.Entity.ALL_NECROMANTOIDS);
		
		getOrCreateTagBuilder(Tags.Entity.BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM)
				.add(EntityType.ENDER_DRAGON);
	}
}
