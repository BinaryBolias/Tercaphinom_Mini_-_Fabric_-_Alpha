package binarybolias.tercaphinom.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BowlStatusEffectCureBeverageItem extends BowlBeverageItem {
	private final ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects;
	
	public BowlStatusEffectCureBeverageItem(ArrayList<RegistryEntry<StatusEffect>> curedStatusEffects, Settings settings) {
		super(settings);
		this.curedStatusEffects = curedStatusEffects;
	}
	
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		stack = super.finishUsing(stack, world, user);
		
		if (!world.isClient) {
			// Cure all status effects assigned to this item.
			for (RegistryEntry<StatusEffect> curedStatusEffect : curedStatusEffects) {
				user.removeStatusEffect(curedStatusEffect);
			}
		}
		
		return stack;
	}
	
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
		if (foodComponent != null) {
			// Item has a food component; defer consumability to the food component.
			if (user.canConsume(foodComponent.canAlwaysEat())) {
				user.setCurrentHand(hand);
				return TypedActionResult.consume(itemStack);
			} else {
				return TypedActionResult.fail(itemStack);
			}
		} else {
			// Item has no food component; always allow consumption.
			return ItemUsage.consumeHeldItem(world, user, hand);
		}
	}
}
