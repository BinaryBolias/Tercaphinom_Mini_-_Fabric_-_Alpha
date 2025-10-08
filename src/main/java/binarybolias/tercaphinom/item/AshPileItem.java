package binarybolias.tercaphinom.item;

import binarybolias.tercaphinom.references.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;


/**
 * @see BlockItem
 * @see net.minecraft.item.BoneMealItem
 */
public class AshPileItem extends AliasedBlockItem {
	public AshPileItem(Settings settings) {
		super(ModBlocks.ASH_MOUND, settings);
	}
	
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity playerEntity = context.getPlayer();
		// Try fertilizing or converting netherrack if not sneaking.
		if (playerEntity != null && !playerEntity.isSneaking()) {
			World world = context.getWorld();
			BlockPos targetPos = context.getBlockPos();
			ItemStack itemStack = context.getStack();
			// If targeting a Netherrack Block, convert it to an Ashy Netherrack Block.
			if (world.getBlockState(targetPos).getBlock() == Blocks.NETHERRACK) {
				world.setBlockState(targetPos, ModBlocks.ASHY_NETHERRACK_BLOCK.getDefaultState());
				itemStack.decrementUnlessCreative(1, playerEntity);
				return ActionResult.success(world.isClient);
			}
			// Try behaving as a BoneMealItem.
			if (BoneMealItem.useOnFertilizable(itemStack, world, targetPos)) {
				if (!world.isClient) {
					context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
					world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, targetPos, 15);
				}
				return ActionResult.success(world.isClient);
			} else {
				BlockState blockState = world.getBlockState(targetPos);
				Direction usageSide = context.getSide();
				boolean usingOnFullSide = blockState.isSideSolidFullSquare(world, targetPos, usageSide);
				BlockPos reflectedPos = targetPos.offset(usageSide);
				if (usingOnFullSide && BoneMealItem.useOnGround(itemStack, world, reflectedPos, usageSide)) {
					if (!world.isClient) {
						playerEntity.emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
						world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, targetPos, 15);
					}
					return ActionResult.success(world.isClient);
				}
			}
		}
		// Redirect to BlockItem functionality if netherrack conversion and fertilization fails.
		return super.useOnBlock(context);
	}
}
