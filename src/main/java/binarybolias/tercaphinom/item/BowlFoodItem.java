package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BowlFoodItem extends Item {
	private static final int MAX_USE_TIME = 32;
	
	public BowlFoodItem(Settings settings) {
		super(settings.maxCount(1));
	}
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		// Return the original item for players in creative mode, else return an Empty Bowl.
		ItemStack itemStack = stack.copy();
		super.finishUsing(stack, world, user);
		if (user instanceof PlayerEntity playerEntity && playerEntity.isInCreativeMode()) {
			return itemStack;
		}
		return new ItemStack(Items.BOWL);
	}
	
	
	@Override
	public int getMaxUseTime(ItemStack stack) {
		return MAX_USE_TIME;
	}
}
