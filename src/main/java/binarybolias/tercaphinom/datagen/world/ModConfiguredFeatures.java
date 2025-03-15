package binarybolias.tercaphinom.datagen.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import static binarybolias.tercaphinom.references.Reference.LOGGER;
import static binarybolias.tercaphinom.references.Reference.log;

public class ModConfiguredFeatures {
	public ModConfiguredFeatures() {
		// Disable instantiation.
		throw new AssertionError();
	}
	
	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
		log("Generating configured feature data");
	}
	
	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
	                                                                               RegistryKey<ConfiguredFeature<?, ?>> key,
	                                                                               F feature, FC configuration) {
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}
