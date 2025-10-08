package binarybolias.tercaphinom.block;

import binarybolias.tercaphinom.references.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class AshMoundBlock extends LayeredMoundBlock {
	public static final MapCodec<AshMoundBlock> CODEC = createCodec(AshMoundBlock::new);
	public static final List<BlockPos> WETNESS_PROVIDER_OFFSETS = BlockPos.stream(-1, -1, -1, 1, 0, 1)
			.filter(pos -> Math.abs(pos.getX()) == 1 || Math.abs(pos.getZ()) == 1)
			.map(BlockPos::toImmutable)
			.toList();
	
	
	@Override
	public MapCodec<AshMoundBlock> getCodec() {
		return CODEC;
	}
	
	
	public AshMoundBlock(AbstractBlock.Settings settings) {
		super(settings);
	}
	
	
	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//		if (world.getLightLevel(LightType.BLOCK, pos) > 11) { // NOTE: Taken from SnowBlock; this is how light level is checked.
		if (posIsWet(world, pos)) {
//			dropStacks(state, world, pos); // NOTE: Taken from SnowBlock; this is how the block's loot table is dropped.
			// Get the topmost Ash Mound Block and decay it.
			// Applicable when ash mounds are stacked more than 1 block high; ash mounds redirect decay upwards.
			BlockPos topmostAshMoundOffset = pos;
			while (world.getBlockState(topmostAshMoundOffset.up()).isOf(this)) {
				topmostAshMoundOffset = topmostAshMoundOffset.up();
			}
			decay(world, topmostAshMoundOffset);
		} else if (state.get(LAYERS) == MAX_LAYERS && !world.getBlockState(pos.down()).isOf(this)) {
			// Requires max (8) layers, and for the block below to not also be an Ash Mound Block.
			// Remove self.
			setToFullBlock(null, state, world, pos);
		}
	}
	
	
	public void decay(ServerWorld world, BlockPos pos) {
		// Reduce by 1 layer, or remove entirely if consisting of only 1 layer.
		BlockState blockState = world.getBlockState(pos);
		int layers = blockState.get(LAYERS);
		if (layers > 1) {
			world.setBlockState(pos, blockState.with(LAYERS, layers - 1), Block.NOTIFY_LISTENERS);
		} else {
			world.removeBlock(pos, false);
		}
	}
	
	
	private boolean posIsWet(ServerWorld world, BlockPos pos) {
		// Wet if rained upon.
		if (world.hasRain(pos)) {
			return true;
		}
		// Wet if water is nearby.
		for (BlockPos offsetPos : WETNESS_PROVIDER_OFFSETS) {
			if (world.getFluidState(pos.add(offsetPos)).isIn(FluidTags.WATER)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void setToFullBlock(@Nullable Entity entity, BlockState state, World world, BlockPos pos) {
		BlockState blockState = pushEntitiesUpBeforeBlockChange(state, ModBlocks.ASH_BLOCK.getDefaultState(), world, pos);
		world.setBlockState(pos, blockState);
		world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(entity, blockState));
	}
}
