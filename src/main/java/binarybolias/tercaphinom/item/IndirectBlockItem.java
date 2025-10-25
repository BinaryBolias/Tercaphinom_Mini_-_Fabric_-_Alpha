package binarybolias.tercaphinom.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BlockStateComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;


/**
 * An item which can be used to place a block, but which does not link the block back to itself.
 * {@link BlockItem}s and extending classes are automatically linked to blocks upon being registered.
 */
public class IndirectBlockItem extends Item {
	private final Block block;
	
	
	public IndirectBlockItem(Block block, Settings settings) {
		super(settings);
		this.block = block;
	}
	
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		// Attempt to place the block.
		ActionResult placementActionResult = place(new ItemPlacementContext(context));
		if (!placementActionResult.isAccepted() && context.getStack().contains(DataComponentTypes.FOOD)) {
			ActionResult ingestionActionResult = super.use(context.getWorld(), context.getPlayer(), context.getHand()).getResult();
			return (ingestionActionResult == ActionResult.CONSUME) ? ActionResult.CONSUME_PARTIAL : ingestionActionResult;
		} else {
			return placementActionResult;
		}
	}
	
	
	public Block getBlock() {
		return block;
	}
	
	
	public ActionResult place(ItemPlacementContext context) {
		if (!getBlock().isEnabled(context.getWorld().getEnabledFeatures())) {
			return ActionResult.FAIL;
		} else if (!context.canPlace()) {
			return ActionResult.FAIL;
		} else {
			BlockState blockState = getPlacementState(context);
			if (blockState == null) {
				return ActionResult.FAIL;
			} else if (!addBlockToWorld(context, blockState)) {
				return ActionResult.FAIL;
			} else {
				BlockPos blockPos = context.getBlockPos();
				World world = context.getWorld();
				PlayerEntity playerEntity = context.getPlayer();
				ItemStack itemStack = context.getStack();
				BlockState blockState2 = world.getBlockState(blockPos);
				if (blockState2.isOf(blockState.getBlock())) {
					blockState2 = placeFromNBT(blockPos, world, itemStack, blockState2);
					postPlacement(blockPos, world, playerEntity, itemStack, blockState2);
					copyComponentsToBlockEntity(world, blockPos, itemStack);
					blockState2.getBlock().onPlaced(world, blockPos, blockState2, playerEntity, itemStack);
					if (playerEntity instanceof ServerPlayerEntity) {
						Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
					}
				}
				
				BlockSoundGroup blockSoundGroup = blockState2.getSoundGroup();
				world.playSound(
						playerEntity,
						blockPos,
						getPlaceSound(blockState2),
						SoundCategory.BLOCKS,
						(blockSoundGroup.getVolume() + 1.0F) / 2.0F,
						blockSoundGroup.getPitch() * 0.8F
				);
				world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(playerEntity, blockState2));
				itemStack.decrementUnlessCreative(1, playerEntity);
				return ActionResult.success(world.isClient);
			}
		}
	}
	
	
	protected boolean addBlockToWorld(ItemPlacementContext context, BlockState blockState) {
		return context.getWorld().setBlockState(context.getBlockPos(), blockState, Block.NOTIFY_ALL_AND_REDRAW);
	}
	
	
	@Nullable
	protected BlockState getPlacementState(ItemPlacementContext context) {
		BlockState blockState = getBlock().getPlacementState(context);
		return blockState != null && canPlace(context, blockState) ? blockState : null;
	}
	
	
	private BlockState placeFromNBT(BlockPos pos, World world, ItemStack stack, BlockState state) {
		BlockStateComponent component = stack.getOrDefault(DataComponentTypes.BLOCK_STATE, BlockStateComponent.DEFAULT);
		if (component.isEmpty()) {
			return state;
		} else {
			BlockState blockState = component.applyToState(state);
			if (blockState != state) {
				world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
			}
			
			return blockState;
		}
	}
	
	
	protected boolean canPlace(ItemPlacementContext context, BlockState blockState) {
		PlayerEntity playerEntity = context.getPlayer();
		ShapeContext shapeContext = playerEntity == null ? ShapeContext.absent() : ShapeContext.of(playerEntity);
		return (blockState.canPlaceAt(context.getWorld(), context.getBlockPos())
				&& context.getWorld().canPlace(blockState, context.getBlockPos(), shapeContext));
	}
	
	
	protected boolean postPlacement(BlockPos pos, World world, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
		return writeNbtToBlockEntity(world, player, pos, stack);
	}
	
	
	public static boolean writeNbtToBlockEntity(World world, @Nullable PlayerEntity player, BlockPos pos, ItemStack stack) {
		MinecraftServer minecraftServer = world.getServer();
		if (minecraftServer == null) {
			return false;
		} else {
			NbtComponent nbtComponent = stack.getOrDefault(DataComponentTypes.BLOCK_ENTITY_DATA, NbtComponent.DEFAULT);
			if (!nbtComponent.isEmpty()) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null) {
					if (world.isClient || !blockEntity.copyItemDataRequiresOperator() || player != null && player.isCreativeLevelTwoOp()) {
						return nbtComponent.applyToBlockEntity(blockEntity, world.getRegistryManager());
					}
					
					return false;
				}
			}
			
			return false;
		}
	}
	
	
	protected SoundEvent getPlaceSound(BlockState state) {
		return state.getSoundGroup().getPlaceSound();
	}
	
	
	
	private static void copyComponentsToBlockEntity(World world, BlockPos pos, ItemStack stack) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null) {
			blockEntity.readComponents(stack);
			blockEntity.markDirty();
		}
	}
	
	
	@Override
	public FeatureSet getRequiredFeatures() {
		return this.getBlock().getRequiredFeatures();
	}
}