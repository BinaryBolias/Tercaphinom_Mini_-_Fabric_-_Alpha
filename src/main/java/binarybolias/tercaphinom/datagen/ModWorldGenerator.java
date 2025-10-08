package binarybolias.tercaphinom.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * @see binarybolias.tercaphinom.DataGenerator
 */
public class ModWorldGenerator extends FabricDynamicRegistryProvider {
	public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
		entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
		//TODO: Add biome registry here.
		entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DIMENSION_TYPE));
	}
	
	
	@Override
	public String getName() {
		return ModID;
	}
}
