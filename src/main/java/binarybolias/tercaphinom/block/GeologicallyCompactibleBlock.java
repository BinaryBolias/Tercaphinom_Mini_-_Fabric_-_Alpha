package binarybolias.tercaphinom.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * For codec composition reference:<br>
 * {@link net.minecraft.block.AttachedStemBlock}<br>
 * {@link net.minecraft.block.ChestBlock}<br>
 * {@link net.minecraft.block.ColoredFallingBlock}<br>
 * {@link net.minecraft.component.type.ContainerComponent}<br>
 * {@link net.minecraft.block.ExperienceDroppingBlock}<br>
 * {@link net.minecraft.block.FlowerBlock}<br>
 * {@link net.minecraft.block.FluidBlock}<br>
 * {@link net.minecraft.block.InfestedBlock}<br>
 * {@link net.minecraft.item.Instrument}<br>
 * {@link net.minecraft.block.LeveledCauldronBlock}<br>
 * {@link net.minecraft.block.MushroomPlantBlock}<br>
 * {@link net.minecraft.block.SaplingBlock}<br>
 * {@link net.minecraft.block.SignBlock}<br>
 * {@link net.minecraft.datafixer.fix.StructureSeparationDataFix}<br>
 * {@link net.minecraft.block.TorchBlock}<br>
 * {@link net.minecraft.block.TrapdoorBlock}<br>
 * {@link net.minecraft.component.type.WrittenBookContentComponent}<br>
 */
public class GeologicallyCompactibleBlock extends Block {
	public static final MapCodec<GeologicallyCompactibleBlock> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					Registries.BLOCK.getCodec().fieldOf("compacted_form").forGetter(GeologicallyCompactibleBlock::getCompactedForm),
					// Using an arbitrary upper bounds of 4096; should be greater than necessary.
					Codecs.rangedInt(1, 4096).fieldOf("pressure_requirement").forGetter(GeologicallyCompactibleBlock::getPressureRequirementForCodecIGuess),
					Codecs.rangedInt(0, 4096).fieldOf("uncertainty_range").forGetter(GeologicallyCompactibleBlock::getUncertaintyRangeForCodecIGuess),
					createSettingsCodec()
			).apply(instance, GeologicallyCompactibleBlock::new));
	
	private final Block compactedForm;
	private final int pressureRequirement;
	private final int uncertaintyRange;
	
	
	@Override
	protected MapCodec<GeologicallyCompactibleBlock> getCodec() {
		return CODEC;
	}
	
	
	public GeologicallyCompactibleBlock(Block compactedForm, int pressureRequirement, int uncertaintyRange, Settings settings) {
		super(settings);
		// Initialize, or throw an exception for illegal parameters.
		if ((pressureRequirement >= 1 && uncertaintyRange >= 0) && (pressureRequirement <= 4096 && uncertaintyRange <= 4096)) {
			this.compactedForm = compactedForm;
			this.pressureRequirement = pressureRequirement;
			this.uncertaintyRange = uncertaintyRange;
		} else {
			if (pressureRequirement < 1) {
				logWarning("Pressure requirement was " + pressureRequirement + ", but must be between 1 and 4096.");
			}
			if (uncertaintyRange < 0) {
				logWarning("Uncertainty range was " + uncertaintyRange + ", but must be between 0 and 4096.");
			}
			throw new IllegalArgumentException("Geologically compactible block was defined with an invalid pressure requirement or uncertainty range");
		}
	}
	
	
	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		// Require a geological compacting support block below.
		if (!world.getBlockState(pos.down()).isIn(Tags.Block.GEOLOGICALLY_COMPACTS_FROM_BELOW)) {
			return;
		}
		int guaranteedCompactingPressure = pressureRequirement + uncertaintyRange;
		// Get compacting pressure from contiguous pillar of blocks directly above.
		int compactingPressure = 0;
		while (world.getBlockState(pos.up(compactingPressure + 1)).isIn(Tags.Block.GEOLOGICALLY_COMPACTS_FROM_ABOVE)) {
			compactingPressure++;
			// Instantly transform if pressure reaches the maximum threshold.
			if (compactingPressure == guaranteedCompactingPressure) {
				transformIntoCompactedForm(world, pos);
				return;
			}
		}
		// Require pressure to be no less than minimum requirement.
		if (compactingPressure < pressureRequirement) {
			return;
		}
		// Randomly choose to transform based on pressure relative to minimum anf maximum.
		// Note that 'guaranteedCompactingPressure' logically must be greater than 'pressureRequirement' at this point.
		// With 'pressureRequirement' as "min" and 'guaranteedCompactingPressure' as "max":
		//  - 'compactingPressure' cannot become greater than or equal to max; transformation would have already occurred.
		//  - 'compactingPressure' cannot be less than min; transformation would have already failed.
		//  - 'compactingPressure' must thus be equal to min, or between min and max, and max must be greater than min.
		if (compactingPressure > (random.nextBetween(pressureRequirement, guaranteedCompactingPressure)) ) {
			transformIntoCompactedForm(world, pos);
		}
	}
	
	
	public Block getCompactedForm() {
		return compactedForm;
	}
	
	
	// Need this here for the codec... Is there a way to make the codec work without it?
	// Making 'pressureRequirement' public instead of private does not work...
	public int getPressureRequirementForCodecIGuess() {
		return pressureRequirement;
	}
	
	
	// Need this here for the codec... Is there a way to make the codec work without it?
	// Making 'uncertaintyRange' public instead of private does not work...
	public int getUncertaintyRangeForCodecIGuess() {
		return uncertaintyRange;
	}
	
	
	private BlockState getCompactedBlockState() {
		return compactedForm.getDefaultState();
	}
	
	
	private void transformIntoCompactedForm(ServerWorld world, BlockPos pos) {
		world.setBlockState(pos, getCompactedBlockState());
	}
}
