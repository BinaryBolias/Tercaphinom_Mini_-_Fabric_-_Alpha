package binarybolias.tercaphinom.item;

import binarybolias.tercaphinom.references.Reference;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static binarybolias.tercaphinom.references.Reference.*;

public class TargetTeleporterItem extends Item {
	public TargetTeleporterItem(Settings settings) {
		super(settings);
	}
	
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient()) {
			@Nullable var data = user.getStackInHand(hand).get(DataComponentTypes.CUSTOM_DATA);
			
			if (user.isSneaking() && data != null) {
				user.getStackInHand(hand).set(DataComponentTypes.CUSTOM_DATA, null);
			}
		}
		
		return super.use(world, user, hand);
	}
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		@Nullable var data = context.getStack().get(DataComponentTypes.CUSTOM_DATA);
		
		if (data != null) {
			return super.useOnBlock(context);
		}
		
		PlayerEntity player = context.getPlayer();
		BlockPos blockPos = context.getBlockPos();
		
		if (player != null) {
			if (!player.isSneaking()) {
				if (context.getWorld().isClient()) {
					// Get the dimension name, without the namespace or delimiter colon, and with underscores replaced with spaces.
					String dimension = player.getWorld().getRegistryKey().getValue().toString();
//					dimension = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
//					printCoordinatesToChat(player, blockPos, makeIdentifierTitleCase(dimension));
					printCoordinatesToChat(player, blockPos);
				} else {
					NbtCompound nbt = new NbtCompound();
					nbt.put("tercaphinom.tuner.pos", NbtHelper.fromBlockPos(blockPos));
					nbt.putString("tercaphinom.tuner.dimension", player.getWorld().getRegistryKey().getValue().toString());
					NbtComponent component = NbtComponent.of(nbt);
					context.getStack().set(DataComponentTypes.CUSTOM_DATA, component);
				}
			}
		}
		
		return super.useOnBlock(context);
	}
	
	
	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		@Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
		
		if (data == null || entity.isPlayer() || entity.getType().isIn(Tags.Entity.BLACKLISTED_FOR_TARGET_TELEPORTER_ITEM)) {
			return ActionResult.FAIL;
		}
		
		if (!user.isSneaking()) {
			NbtCompound nbt = data.copyNbt();
			BlockPos targetPos = NbtHelper.toBlockPos(nbt, "tercaphinom.tuner.pos").get();
			
			String targetDimension = nbt.getString("tercaphinom.tuner.dimension");
			String userDimension = user.getWorld().getRegistryKey().getValue().toString();
			
			if (!user.getWorld().isClient()) {
				if (targetDimension.equalsIgnoreCase(userDimension)) {
					entity.teleport(targetPos.getX(), targetPos.getY(), targetPos.getZ());
					entity.refreshPositionAfterTeleport(targetPos.getX(), targetPos.getY() + 1, targetPos.getZ());
					stack.damage(1, user, LivingEntity.getSlotForHand(hand));
					return ActionResult.SUCCESS;
				}
				return ActionResult.FAIL;
			}
			
//			String dimensionName = targetDimension.substring(targetDimension.indexOf(':') + 1).replace('_', ' ');
			String dimensionName = makeIdentifierTitleCase(targetDimension);
			
			if (targetDimension.equalsIgnoreCase(userDimension)) {
				user.sendMessage(translate("tuner.teleported", targetPos.getX(), targetPos.getY(), targetPos.getZ(), dimensionName));
				
				return ActionResult.SUCCESS;
			} else {
				user.sendMessage(translate("tuner.error", dimensionName));
				
				return ActionResult.FAIL;
			}
		}
		
		return super.useOnEntity(stack, user, entity, hand);
	}
	
	
	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		@Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
		if (data != null) {
			NbtCompound nbt = data.copyNbt();
			BlockPos targetPos = NbtHelper.toBlockPos(nbt, "tercaphinom.tuner.pos").get();
			
			String targetDimension = nbt.getString("tercaphinom.tuner.dimension");
			String dimensionName = makeIdentifierTitleCase(targetDimension);
			tooltip.add(translate("tuner.tooltip", targetPos.getX(), targetPos.getY(), targetPos.getZ()));
			tooltip.add(translate("tuner.dimension", dimensionName));
		}
		
		super.appendTooltip(stack, context, tooltip, type);
	}
	
	
	@Override
	public boolean hasGlint(ItemStack stack) {
		@Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
		return data != null;
	}
	
	
	private void printCoordinatesToChat(PlayerEntity player, BlockPos blockPos) {
		player.sendMessage(translate("tuner.bind_message", blockPos.getX(), blockPos.getY(), blockPos.getZ()), false);
	}
	
	
	private String makeIdentifierTitleCase(String string) {
		// Remove namespace and delimiter colon.
		string = string.substring(string.indexOf(':') + 1);
		// Replace underscores with spaces.
//		newString = newString.replace('_', ' ');
		
		// Iterate through character, replacing underscores with spaces, and capitalizing letters after spaces, as well as the first letter.
		StringBuilder stringBuilder = new StringBuilder(string);
		boolean shouldCapitalizeNext = true;
		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			if (character == '_') {
				shouldCapitalizeNext = true;
				stringBuilder.setCharAt(i, ' ');
			} else if (shouldCapitalizeNext) {
				shouldCapitalizeNext = false;
				stringBuilder.setCharAt(i, Character.toUpperCase(character));
			}
		}
		
		return stringBuilder.toString();
	}
	
}
