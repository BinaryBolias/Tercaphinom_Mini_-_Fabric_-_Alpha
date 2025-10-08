package binarybolias.tercaphinom;

import binarybolias.tercaphinom.datagen.*;
import binarybolias.tercaphinom.datagen.world.ModConfiguredFeatures;
import binarybolias.tercaphinom.datagen.world.ModPlacedFeatures;
import binarybolias.tercaphinom.world.dimension.DimensionTypeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * @see ModWorldGenerator
 */
public class DataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		logMainEvent("Generating data");
		// The pack for implementing Tercaphinom's assets and JSON files.
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModEntityTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}
	
	
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		//TODO: Add biome registry here.
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, DimensionTypeProvider::bootstrap);
	}
}
