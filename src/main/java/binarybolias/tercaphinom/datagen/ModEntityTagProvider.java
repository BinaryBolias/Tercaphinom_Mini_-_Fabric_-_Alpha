package binarybolias.tercaphinom.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.log;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating entity tag data");
		
		getOrCreateTagBuilder(EntityTypeTags.ARROWS);
		getOrCreateTagBuilder(EntityTypeTags.UNDEAD); // In tercaphinom, this is replaced with "necromantoids".
	}
}
