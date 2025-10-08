package binarybolias.tercaphinom.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import static binarybolias.tercaphinom.references.Reference.*;


public class LayeredMoundBlock extends Block {
	public static final MapCodec<LayeredMoundBlock> CODEC = createCodec(LayeredMoundBlock::new);
	public static final int MAX_LAYERS = 8;
	public static final IntProperty LAYERS = Properties.LAYERS;
	protected static final VoxelShape[] LAYERS_TO_SHAPE = new VoxelShape[]{
			VoxelShapes.empty(),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
			Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
	};
	public static final int TOO_MANY_LAYERS_FOR_AIR_PATHFINDING = 2;
	public static final int TOO_MANY_LAYERS_FOR_LAND_PATHFINDING = 5;
	
	
	
	@Override
	public MapCodec<? extends LayeredMoundBlock> getCodec() {
		return CODEC;
	}
	
	
	public LayeredMoundBlock(Settings settings) {
		super(settings);
	}
	
	
	@Override
	protected boolean canPathfindThrough(BlockState state, NavigationType type) {
		switch (type) {
			case LAND:
				return state.get(LAYERS) < TOO_MANY_LAYERS_FOR_LAND_PATHFINDING;
			case AIR:
				return state.get(LAYERS) < TOO_MANY_LAYERS_FOR_AIR_PATHFINDING;
			default:
				return false;
		}
	}
	
	
	@Override
	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return LAYERS_TO_SHAPE[state.get(LAYERS)];
	}
	
	
	@Override
	protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return LAYERS_TO_SHAPE[state.get(LAYERS) - 1];
	}
	
	
	@Override
	protected VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
		return LAYERS_TO_SHAPE[state.get(LAYERS)];
	}
	
	
	@Override
	protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return LAYERS_TO_SHAPE[state.get(LAYERS)];
	}
	
	
	@Override
	protected boolean hasSidedTransparency(BlockState state) {
		return true;
	}
	
	
	@Override
	protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
		return state.get(LAYERS) == 8 ? 0.2F : 1.0F;
	}
	
	
	@Override
	protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos.down());
		if (blockState.isIn(Tags.Block.BLACKLISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON)) {
			return false;
		} else {
			return blockState.isIn(Tags.Block.WHITELISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON)
					|| Block.isFaceFullSquare(blockState.getCollisionShape(world, pos.down()), Direction.UP)
					|| (blockState.isOf(this) && blockState.get(LAYERS) == 8);
		}
	}
	
	
	@Override
	protected BlockState getStateForNeighborUpdate(
			BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
	) {
		return state.canPlaceAt(world, pos)
				? super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos)
				: Blocks.AIR.getDefaultState();
	}
	
	
	@Override
	protected boolean canReplace(BlockState state, ItemPlacementContext context) {
		int i = state.get(LAYERS);
		if (!context.getStack().isOf(this.asItem()) || i >= MAX_LAYERS) {
			return i == 1;
		} else {
			return !context.canReplaceExisting() || context.getSide() == Direction.UP;
		}
	}
	
	
	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
		if (blockState.isOf(this)) {
			int i = blockState.get(LAYERS);
			return blockState.with(LAYERS, Math.min(MAX_LAYERS, i + 1));
		} else {
			return super.getPlacementState(ctx);
		}
	}
	
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(LAYERS);
	}
}
