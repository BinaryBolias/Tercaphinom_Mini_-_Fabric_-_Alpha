package binarybolias.tercaphinom.world.dimension;


import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * Dimension type provider:<br>
 * {@link DimensionTypeProvider}
 * <br><br>
 * Vanilla dimension types:<br>
 * {@link net.minecraft.world.dimension.DimensionTypes}<br>
 * {@link net.minecraft.world.dimension.DimensionTypeRegistrar}
 * <br><br>
 * Vanilla dimension options:<br>
 * {@link net.minecraft.world.dimension.DimensionOptions}
 * {@link net.minecraft.world.dimension.DimensionOptionsRegistryHolder}
 * <br><br>
 * Vanilla dimension worlds:<br>
 * {@link net.minecraft.world.World}
 */
public class Dimensions {
	public static final Identifier BLENDSTAIN_ID;
	public static final RegistryKey<DimensionOptions> BLENDSTAIN_OPTIONS;
	public static final RegistryKey<DimensionType> BLENDSTAIN_TYPE;
	public static final RegistryKey<World> BLENDSTAIN_WORLD;
	static {
		BLENDSTAIN_ID = identifier("blendstain");
		BLENDSTAIN_OPTIONS = newOptionsOf(BLENDSTAIN_ID);
		BLENDSTAIN_TYPE = newTypeOf(BLENDSTAIN_ID);
		BLENDSTAIN_WORLD = newWorldOf(BLENDSTAIN_ID);
	}
	
	public static final Identifier BUFFETOPIA_ID;
	public static final RegistryKey<DimensionOptions> BUFFETOPIA_OPTIONS;
	public static final RegistryKey<DimensionType> BUFFETOPIA_TYPE;
	public static final RegistryKey<World> BUFFETOPIA_WORLD;
	static {
		BUFFETOPIA_ID = identifier("buffetopia");
		BUFFETOPIA_OPTIONS = newOptionsOf(BUFFETOPIA_ID);
		BUFFETOPIA_TYPE = newTypeOf(BUFFETOPIA_ID);
		BUFFETOPIA_WORLD = newWorldOf(BUFFETOPIA_ID);
	}
	
	public static final Identifier PANDEMOPIA_ID;
	public static final RegistryKey<DimensionOptions> PANDEMOPIA_OPTIONS;
	public static final RegistryKey<DimensionType> PANDEMOPIA_TYPE;
	public static final RegistryKey<World> PANDEMOPIA_WORLD;
	static {
		PANDEMOPIA_ID = identifier("pandemopia");
		PANDEMOPIA_OPTIONS = newOptionsOf(PANDEMOPIA_ID);
		PANDEMOPIA_TYPE = newTypeOf(PANDEMOPIA_ID);
		PANDEMOPIA_WORLD = newWorldOf(PANDEMOPIA_ID);
	}
	
	public static final Identifier STARVED_EARTH_ID;
	public static final RegistryKey<DimensionOptions> STARVED_EARTH_OPTIONS;
	public static final RegistryKey<DimensionType> STARVED_EARTH_TYPE;
	public static final RegistryKey<World> STARVED_EARTH_WORLD;
	static {
		STARVED_EARTH_ID = identifier("starved_earth");
		STARVED_EARTH_OPTIONS = newOptionsOf(STARVED_EARTH_ID);
		STARVED_EARTH_TYPE = newTypeOf(STARVED_EARTH_ID);
		STARVED_EARTH_WORLD = newWorldOf(STARVED_EARTH_ID);
	}
	
	
	private static RegistryKey<DimensionOptions> newOptionsOf(Identifier id) {
		return RegistryKey.of(RegistryKeys.DIMENSION, id);
	}
	
	
	private static RegistryKey<DimensionType> newTypeOf(Identifier id) {
		return RegistryKey.of(RegistryKeys.DIMENSION_TYPE, id);
	}
	
	private static RegistryKey<World> newWorldOf(Identifier id) {
		return RegistryKey.of(RegistryKeys.WORLD, id);
	}
}
