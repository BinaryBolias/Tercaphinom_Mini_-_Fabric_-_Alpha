package binarybolias.tercaphinom.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantedCheeseWheelItem extends Item {
	public EnchantedCheeseWheelItem(Settings settings) {
		super(settings);
	}
	
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos blockUsedOnPos = context.getBlockPos();
		World world = context.getWorld();
		PlayerEntity player = context.getPlayer();
		assert player != null;
		// If the block is breakable, break it.
		if (world.getBlockState(blockUsedOnPos).getHardness(world, blockUsedOnPos) >= 0.0F) {
			// Damage the item if the block was successfully broken.
			if (world.breakBlock(blockUsedOnPos, true, player)) {
				context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
				player.getItemCooldownManager().set(this, 5);
				return ActionResult.SUCCESS;
			}
		}
		
		return super.useOnBlock(context);
	}
	
	
	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		// Set damage to 16 more than half of the target entity's current health.
		float damage = (entity.getHealth() / 4.0F) + 16.0F;
		if (entity.damage(user.getDamageSources().playerAttack(user), damage)) {
			stack.damage(1, user, EquipmentSlot.MAINHAND);
			user.getItemCooldownManager().set(this, 5);
			return ActionResult.SUCCESS;
			//TODO: Perhaps add a chance to drop a (random) cheese wedge on kill?
			// How to check for kill?
		}
		return super.useOnEntity(stack, user, entity, hand);
	}
	
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		// NOTE: Only for if this item is to deal bonus damage on normal attack.
//		stack.damage(1, attacker, EquipmentSlot.MAINHAND);
//		return true;
		return false;
	}
}
