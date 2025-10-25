package binarybolias.tercaphinom.block;


import binarybolias.tercaphinom.registry.tag.BlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @see net.minecraft.block.NetherrackBlock
 */
public class AshyNetherrackBlock extends Block {
	public static final MapCodec<AshyNetherrackBlock> CODEC = createCodec(AshyNetherrackBlock::new);
	
	//TODO: Create a public collection of block offset lists to be used by block classes and such.
	// - Handy for not needing to redefine these when the same offset list would be used in multiple classes.
	// - This offset list could be used for a bunch of other types of things, especially blocks that can spread.
	// - It could contain a built-in method for getting a shuffled copy of any list.
//	public static final List<BlockPos> HORIZONTAL_IMMEDIATE_NEIGHBORS = BlockPos.stream(-1, 0, -1, 1, 0, 1)
//			.filter(pos -> Math.abs(pos.getX()) == 1 || Math.abs(pos.getZ()) == 1) // Note: This logic taken from vanilla. Not sure why is uses absolute value...
//			.map(BlockPos::toImmutable)
//			.toList();
	public static final List<BlockPos> NON_VERTICAL_IMMEDIATE_NEIGHBORS = BlockPos.stream(-1, -1, -1, 1, 1, 1)
			.filter(pos -> pos.getX() != 0 || pos.getZ() != 0)
			.map(BlockPos::toImmutable)
			.toList();
	public static final List<BlockPos> ALL_IMMEDIATE_NEIGHBORS = BlockPos.stream(-1, -1, -1, 1, 1, 1)
			.filter(pos -> pos.getX() != 0 || pos.getY() != 0 || pos.getZ() != 0)
			.map(BlockPos::toImmutable)
			.toList();
	
	
	@Override
	protected MapCodec<AshyNetherrackBlock> getCodec() {
		return CODEC;
	}
	
	
	public AshyNetherrackBlock(Settings settings) {
		super(settings);
	}
	
	
	public static BlockState getBaseBlockState() {
		return Blocks.NETHERRACK.getDefaultState();
	}
	
	
	public static boolean canSpreadAtopSelf(BlockState blockState) {
		return blockState.isIn(BlockTags.SPREADABLE_ATOP_ASHY_NETHERRACK);
	}
	
	
	public static boolean canSpreadIntoSelf(BlockState blockState) {
		return blockState.isIn(BlockTags.SPREADABLE_INTO_ASHY_NETHERRACK);
	}
	
	
	public static boolean canSpreadOntoSelf(BlockState blockState) {
		return blockState.isIn(BlockTags.SPREADABLE_ONTO_ASHY_NETHERRACK);
	}
	
	
	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		boolean spreadHasOccurred = false;
		// Define a random order of offsets for checking surrounding positions.
		ArrayList<BlockPos> offsets = new ArrayList<>(NON_VERTICAL_IMMEDIATE_NEIGHBORS);
		Collections.shuffle(offsets);
		//TODO: Uhh, does this not break anything? (untested; just disabling for safety)
		// - I'm guessing it doesn't work...
		// - Perhaps create my own implementation for shuffling lists, with a net.minecraft.util.math.Random parameter?
//		Collections.shuffle(offsets, (java.util.Random) random);
		// Try spreading onto self. Require the block above to allow spreading upon.
		if (blockAboveAllowsSpreadingUpon(world, pos) && trySpreadingOntoSelf(world, pos, offsets)) {
			spreadHasOccurred = true;
		}
		// 3 in 8 chance to not try spreading atop self if spreading onto self has succeeded.
		if (spreadHasOccurred && random.nextInt(8) < 3) {
			return;
		} else {
			// If continuing onwards to spreading atop self, randomize the order for checking neighbors.
			//TODO:
			// - Note: Because we're doing this, now, it may just be better to get an entirely new list of offsets
			//  within both of the 'trySpreadingOntoSelf' and 'trySpreadingAtopSelf' functions,
			//  and not bother with offset lists here in this function.
			//  - This would mean not needing to pass the offset list as an argument.
			//  - With a centralized location/class for accessing block position offsets, and getting a
			//   random offset list using Minecraft's internal net.minecraft.util.math.random.Random,
			//   we'll need to pass the 'random' parameter in to each method instead.
			Collections.shuffle(offsets);
		}
		// Try propagating atop self.
		if (trySpreadingAtopSelf(world, pos, offsets)) {
			// Convert self to base (non-ashy) form if conversion onto self has not succeeded.
			if (!spreadHasOccurred) {
				spreadHasOccurred = true;
				// Transform self into base block state.
				world.setBlockState(pos, getBaseBlockState(), Block.NOTIFY_ALL);
			}
		}
		// When no other spreading behaviors succeed, try spreading into self.
		// Only a 1 in 4 chance of success.
		if (!spreadHasOccurred && random.nextInt(4) < 1) {
			trySpreadingIntoSelf(world, pos);
		}
	}
	
	
	private void trySpreadingIntoSelf(
			ServerWorld world, BlockPos pos
//			, Random random
	) {
		// Define a random order of offsets for checking surrounding positions.
		ArrayList<BlockPos> offsets = new ArrayList<>(ALL_IMMEDIATE_NEIGHBORS);
		Collections.shuffle(offsets);
		//TODO: Not sure if this works (untested; just disabling for safety)
		// - I'm guessing it doesn't...
//		Collections.shuffle(offsets, (java.util.Random) random);
		
		// Check positions around self, in the defined random order.
		for (BlockPos offset : offsets) {
			// If the block can spread into self, convert self into the same block type and return 'true'.
			BlockState blockState = world.getBlockState(pos.add(offset));
			if (canSpreadIntoSelf(blockState)) {
				world.setBlockState(pos, blockState.getBlock().getDefaultState(), Block.NOTIFY_ALL);
				// Don't keep trying to convert self upon successfully converting self.
				return;
			}
		}
	}
	
	
	private boolean trySpreadingOntoSelf(ServerWorld world, BlockPos pos, ArrayList<BlockPos> offsets) {
		// Check offsets around own position, and convert self into the first block found that can spread onto self.
		for (BlockPos offset : offsets) {
			BlockState blockState = world.getBlockState(pos.add(offset));
			if (canSpreadOntoSelf(blockState)) {
				world.setBlockState(pos, blockState.getBlock().getDefaultState(), Block.NOTIFY_ALL);
				return true;
			}
		}
		return false;
	}
	
	
	private boolean trySpreadingAtopSelf(ServerWorld world, BlockPos pos, ArrayList<BlockPos> offsets) {
		// Try to either spread the block above self to somewhere else, or spread to atop self from a different position.
		BlockState blockAbove = world.getBlockState(pos.up());
		// Check if the block above can spread atop self.
		if (canSpreadAtopSelf(blockAbove)) {
			// Propagate the block atop self to the first valid offset location.
			for (BlockPos offset : offsets) {
				BlockPos targetPos = pos.add(offset).up(); // Shifted 1 unit upwards.
				BlockState blockState = world.getBlockState(targetPos);
				if (blockState.isAir() && blockAbove.canPlaceAt(world, targetPos)) {
					// Place the block above self at the target position.
					world.setBlockState(targetPos, blockAbove.getBlock().getDefaultState(), Block.NOTIFY_ALL);
					return true;
				}
			}
		} else if (blockAbove.isAir()) {
			// Propagate the first block found via offsets to atop self.
			for (BlockPos offset : offsets) {
				BlockState blockState = world.getBlockState(pos.add(offset).up()); // Shifted 1 unit upwards.
				if (canSpreadAtopSelf(blockState) && blockState.canPlaceAt(world, pos.up())) {
					// Place the block found atop self.
					world.setBlockState(pos.up(), blockState.getBlock().getDefaultState(), Block.NOTIFY_ALL);
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private boolean blockAboveAllowsSpreadingUpon(ServerWorld world, BlockPos pos) {
		BlockPos posAbove = pos.up();
		BlockState stateAbove = world.getBlockState(posAbove);
		return stateAbove.isAir() || !stateAbove.isSolidBlock(world, posAbove);
	}
}
