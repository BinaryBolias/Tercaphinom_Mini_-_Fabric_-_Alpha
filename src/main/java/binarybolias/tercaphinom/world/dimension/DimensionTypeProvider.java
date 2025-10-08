package binarybolias.tercaphinom.world.dimension;


import net.minecraft.registry.Registerable;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.dimension.DimensionType;

import java.util.OptionalLong;


/**
 * @see Dimensions
 * @see net.minecraft.world.dimension.DimensionTypeRegistrar
 */
public class DimensionTypeProvider {
	public static void bootstrap(Registerable<DimensionType> context) {
		context.register(
				Dimensions.BLENDSTAIN_TYPE,
				new DimensionType(
						OptionalLong.empty(),
						true,
						false,
						false,
						true,
						0.125,
						true,
						true,
						0,
						384,
						384,
						BlockTags.INFINIBURN_OVERWORLD,
						Dimensions.BLENDSTAIN_ID,
						0.0F,
						new DimensionType.MonsterSettings(true, true,
								UniformIntProvider.create(0, 7), 0)
				)
		);
		context.register(
				Dimensions.BUFFETOPIA_TYPE,
				new DimensionType(
						OptionalLong.empty(),
						true,
						false,
						false,
						true,
						1.0,
						true,
						true,
						0,
						384,
						384,
						BlockTags.INFINIBURN_OVERWORLD,
						Dimensions.BUFFETOPIA_ID,
						0.0F,
						new DimensionType.MonsterSettings(true, true,
								UniformIntProvider.create(0, 7), 0)
				)
		);
		context.register(
				Dimensions.PANDEMOPIA_TYPE,
				new DimensionType(
						OptionalLong.empty(),
						true,
						false,
						false,
						true,
						0.0625,
						true,
						true,
						0,
						384,
						384,
						BlockTags.INFINIBURN_OVERWORLD,
						Dimensions.PANDEMOPIA_ID,
						0.0F,
						new DimensionType.MonsterSettings(true, true,
								UniformIntProvider.create(0, 7), 0)
				)
		);
		context.register(
				Dimensions.STARVED_EARTH_TYPE,
				new DimensionType(
						OptionalLong.empty(),
						true,
						false,
						false,
						true,
						1.0,
						true,
						true,
						0,
						384,
						320,
						BlockTags.INFINIBURN_OVERWORLD,
						Dimensions.STARVED_EARTH_ID,
						0.0F,
						new DimensionType.MonsterSettings(true, true,
								UniformIntProvider.create(0, 7), 0)
				)
		);
	}
}
