package binarybolias.tercaphinom.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating entity tag data");
		
		getOrCreateTagBuilder(EntityTypeTags.ARROWS);
		
		getOrCreateTagBuilder(EntityTypeTags.UNDEAD).addTag(Tags.Entity.ALL_NECROMANTOIDS); // Note: "necromantoid" to be a replacement term for "undead".
		getOrCreateTagBuilder(Tags.Entity.ALL_NECROMANTOIDS);
		
		getOrCreateTagBuilder(Tags.Entity.BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM)
				.add(EntityType.ENDER_DRAGON);
	}
}
