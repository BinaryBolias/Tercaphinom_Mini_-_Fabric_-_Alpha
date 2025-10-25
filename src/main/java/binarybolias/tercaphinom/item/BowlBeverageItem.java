package binarybolias.tercaphinom.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class BowlBeverageItem extends Item {
	private static final int MAX_USE_TIME = 20;
	
	
	public BowlBeverageItem(Settings settings) {
		super(settings);
	}
	
	
	public ItemStack getEmptyItem() {
		return new ItemStack(Items.BOWL);
	}
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		super.finishUsing(stack, world, user);
		
		// Decrement manually if not already a food item; decrement is automatic for food items.
		if (!stack.contains(DataComponentTypes.FOOD)) {
			stack.decrementUnlessCreative(1, user);
		}
		
		// Add a new Empty Bowl.
		if (stack.isEmpty()) {
			return getEmptyItem();
		} else {
			if (user instanceof PlayerEntity playerEntity && !playerEntity.isInCreativeMode()) {
				ItemStack itemStack = getEmptyItem();
				if (!playerEntity.getInventory().insertStack(itemStack)) {
					playerEntity.dropItem(itemStack, false);
				}
			}
			
			return stack;
		}
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
