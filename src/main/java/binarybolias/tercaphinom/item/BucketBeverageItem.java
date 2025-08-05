package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BucketBeverageItem extends Item {
	private static final int MAX_USE_TIME = 32;
	
	public BucketBeverageItem(Settings settings) {
		super(settings.maxCount(1));
	}
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		// Return the original item for players in creative mode, else return an Empty Bucket.
		ItemStack itemStack = stack.copy();
		super.finishUsing(stack, world, user);
		if (user instanceof PlayerEntity playerEntity && playerEntity.isInCreativeMode()) {
			return itemStack;
		}
		return new ItemStack(Items.BUCKET);
	}
	
	
	@Override
	public int getMaxUseTime(ItemStack stack) {
		return MAX_USE_TIME;
	}
	
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}
}
