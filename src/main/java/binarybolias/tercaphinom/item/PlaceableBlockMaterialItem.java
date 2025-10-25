package binarybolias.tercaphinom.item;


import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 * An item which can be used to place a block at the cost of multiple units of the item, and requiring some time to place.
 * <p>
 * Not designed for blocks which expect nbt data from the item upon placement.
 * @see IndirectBlockItem
 * @see net.minecraft.item.BlockItem
 */
public class PlaceableBlockMaterialItem extends Item {
	private static final int GENERIC_PLACEMENT_COST = 8;
	protected static final int LARGE_BRICK_PLACEMENT_COST = 4;
	//TODO: For different placement costs, use an extending class.
	// - Not many placement costs for this kind of item are expected.
	//  - Perhaps only 8 (for most materials) and 4 (for large bricks).
	// - For the large brick item class:
	//  - Override the method for getting placement cost to return 'LARGE_BRICK_PLACEMENT_COST'.
	
	//TODO:
	// - Ideally, the pick block function would search for an item of this class which corresponds to the block
	//  if a direct block item is not found.
	//  - E.g, pick block in survival gives a Dirt Pile instead of a Dirt Block if only Dirt Piles are in the inventory.
	// - We could modify MixinBlock to provide a secondary cached item to the Block class,
	//  alongside an extra method for accessing it.
	//  - New variable name ideas:
	//   - "secondaryCachedItem"
	//   - "materialItem"
	//   - "cachedMaterialItem"
	//  - Rename the existing assignment method to "assignPrimaryItem".
	//  - Then, we modify the pick block function to first try getting the primary cached item,
	//   and if that item cannot be given (e.g player is in survival mode and doesn't have the item in inventory),
	//   then we use the new method to try retrieving the secondary cached item.
	//   - Alternatively, we immediately get both the primary and secondary cached items, and, if in survival mode,
	//    return the first one found in the inventory.
	//    - In creative mode we would only ever need to retrieve the primary cached item,
	//     unless a primary cached item isn't found (Block#asItem() returns Items.AIR).
	
	private final Block block;
	
	
	public PlaceableBlockMaterialItem(Block block, Settings settings) {
		super(settings);
		this.block = block;
	}
	
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		//TODO:
		// - (DONE) Set up instantaneous block placement at the cost of items.
		// - After it's working, rework this class to place the block only after a warmup duration elapses.
		
		// Try placing the material as a block.
		ActionResult placementActionResult = tryPlacingBlock(new ItemPlacementContext(context));
		// If that doesn't work... Try eating the material!
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
	
	
	public ActionResult tryPlacingBlock(ItemPlacementContext context) {
		// Require that the held stack has enough for placement.
		ItemStack itemStack = context.getStack();
		if (itemStack.getCount() < getPlacementCost()) {
			return ActionResult.FAIL;
		}
		// Require that the target position is valid for placement.
		if (!context.canPlace()) {
			return ActionResult.FAIL;
		}
		// Require that the block... wants to be placed here, I guess?
		// TODO:
		//  - Consider how the placement state might realistically be different from the state after placement.
		//  - Consider how the placement state might be null.
		BlockState prePlacementState = getPlacementState(context);
		if (prePlacementState == null) {
			return ActionResult.FAIL;
		}
		// Require that the block is successfully added to the world.
		if (!addBlockToWorld(context, prePlacementState)) {
			return ActionResult.FAIL;
		}
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		PlayerEntity playerEntity = context.getPlayer();
		BlockState finalState = world.getBlockState(blockPos);
		if (finalState.isOf(prePlacementState.getBlock())) {
			finalState.getBlock().onPlaced(world, blockPos, finalState, playerEntity, itemStack);
			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
			}
		}
		// Play placement sound.
		BlockSoundGroup blockSoundGroup = finalState.getSoundGroup();
		world.playSound(
				playerEntity,
				blockPos,
				getPlaceSound(finalState),
				SoundCategory.BLOCKS,
				(blockSoundGroup.getVolume() + 1.0F) / 2.0F,
				blockSoundGroup.getPitch() * 0.8F
		);
		// Emit placement game event.
		world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(playerEntity, finalState));
		// Decrement held stack.
		itemStack.decrementUnlessCreative(getPlacementCost(), playerEntity);
		
		return ActionResult.success(world.isClient);
	}
	
	
	@Nullable
	protected BlockState getPlacementState(ItemPlacementContext context) {
		BlockState blockState = getBlock().getPlacementState(context);
		return blockState != null && canPlace(context, blockState) ? blockState : null;
	}
	
	
	protected boolean canPlace(ItemPlacementContext context, BlockState blockState) {
		PlayerEntity playerEntity = context.getPlayer();
		ShapeContext shapeContext = playerEntity == null ? ShapeContext.absent() : ShapeContext.of(playerEntity);
		return (blockState.canPlaceAt(context.getWorld(), context.getBlockPos())
				&& context.getWorld().canPlace(blockState, context.getBlockPos(), shapeContext));
	}
	
	
	protected boolean addBlockToWorld(ItemPlacementContext context, BlockState blockState) {
		return context.getWorld().setBlockState(context.getBlockPos(), blockState, Block.NOTIFY_ALL_AND_REDRAW);
	}
	
	
	protected SoundEvent getPlaceSound(BlockState state) {
		return state.getSoundGroup().getPlaceSound();
	}
	
	
	@Override
	public int getMaxUseTime(ItemStack stack) {
		return super.getMaxUseTime(stack); // TODO.
	}
	
	
	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(getTypeDescription().formatted(Formatting.GRAY));
		tooltip.add(getCostDescription().formatted(Formatting.GRAY));
	}
	
	
	public MutableText getTypeDescription() {
		return Text.translatable("item.material_of_block", block.getName());
	}
	
	
	public MutableText getCostDescription() {
		return Text.translatable("item.placement_cost", getPlacementCost());
	}
	
	
	//TODO:
	// - On use, make sure the location is valid for block placement, and of so, begin a continuous interaction.
	//  - Action duration of 8 ticks.
	// - During continuous interaction, check the location again for validity each tick, cancelling the interaction if the location becomes invalid.
	//  - Ideally, the location where the placement interaction was initiated would be remembered.
	//   - The location would also be required to be the same.
	// - At the end of continuous interaction, place the block if the location is still valid.
	
	//TODO: Perhaps use different classes for different placement costs?
	// - Generally, the placement cost would only ever be 4 (for large bricks) or 8 (for most materials).
	// - A class could extend from this one to override the return value of this function.
	// - 'placementCost' would thus be removed; each instance of this class needn't a separate integer value defined.
	protected int getPlacementCost() {
		return GENERIC_PLACEMENT_COST; // TODO: Use this for both the material cost, and the time (in ticks) to place the block.
	}
}
