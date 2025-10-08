package binarybolias.tercaphinom.block;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import java.util.List;


public class LivingObsidianBlock extends Block {
	public static final MapCodec<LivingObsidianBlock> CODEC = createCodec(LivingObsidianBlock::new);
	
	private final Block transformationTarget;
	private final int transformationPressure;
	//TODO: Create a public collection of block offset lists to be used by block classes ans such.
	// - Handy for not needing to redefine these when the same offset list would be used in multiple classes.
	// - This offset list could be used for a bunch of other types of things, especially blocks that can spread.
	public static final List<BlockPos> NEIGHBOR_DETECTION_OFFSETS = BlockPos.stream(-1, 0, -1, 1, 0, 1)
			.filter(pos -> Math.abs(pos.getX()) == 1 || Math.abs(pos.getZ()) == 1)
			.map(BlockPos::toImmutable)
			.toList();
	
	
	@Override
	protected MapCodec<LivingObsidianBlock> getCodec() {
		return CODEC;
	}
	
	
	// TODO: Check to see if vanilla block classes use a private constructor like this, or if there's a better way to accommodate the codec.
	private LivingObsidianBlock(Settings settings) {
		super(settings);
		this.transformationTarget = Blocks.AIR;
		this.transformationPressure = 0;
	}
	
	public LivingObsidianBlock(Block transformationTarget, int transformationPressure, Settings settings) {
		super(settings);
		//TODO: Add new "living obsidian" blocks.
		// - Transformation targets for new blocks:
		//  - Living Obsidian Block -> Crying Living Obsidian Block
		//  - Crying Living Obsidian Block -> Living Obsidian Block
		// - Transformation pressures for new blocks:
		//  - Living Obsidian Block: -1 (only able to transform with 2 or more similar neighbors, guaranteed at 8)
		//  - Crying Living Obsidian Block: 3 (minimum chance to transform of 1/2, guaranteed at 4 similar neighbors)
		this.transformationTarget = transformationTarget;
		this.transformationPressure = transformationPressure;
	}
	
	
	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		// Modify the transformation pressure by the amount of similar neighbors.
		int transformationPressure = this.transformationPressure;
		for (BlockPos offset : NEIGHBOR_DETECTION_OFFSETS) {
			if (world.getBlockState(pos.add(offset)).isOf(this)) {
				transformationPressure += 1;
			}
		}
		// Transform into target block if a random value from 0 to 7 is less than the transformation pressure.
		if (random.nextInt(8) < transformationPressure) {
			world.setBlockState(pos, transformationTarget.getDefaultState());
			return; // TODO: Continue this method upon Living Obsidian Bud implementation; perhaps upon addition of Starved Earth dimension.
		}
		
		//TODO: If transformation does not occur, look at the four orthogonally horizontally adjacent block positions
		// in random order, and attempt to place a new Living Obsidian Bud at the first replaceable spot.
		// Don't place multiple on the same random tick; return upon placing one successfully.
	}
}
