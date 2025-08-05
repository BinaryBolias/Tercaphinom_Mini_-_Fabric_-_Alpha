package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;

public class NutrillarnMalletItem extends PickaxeItem {
	public NutrillarnMalletItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}
	
	
	private static final double PUSHBACK_MULTIPLIER = 0.5;
	private static final double HORIZONTAL_PUSHBACK_MULTIPLIER = PUSHBACK_MULTIPLIER * 2;
	
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 160), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 35), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 160, 1), attacker);
		// Define the push vector.
		// The effective target position is increased to skew the push direction slightly upward.
		Vec3d pushVector = target.getPos().add(0, 0.25, 0).subtract(attacker.getPos()).normalize()
				.multiply(HORIZONTAL_PUSHBACK_MULTIPLIER, PUSHBACK_MULTIPLIER, HORIZONTAL_PUSHBACK_MULTIPLIER);
		target.addVelocity(pushVector);
		
		return super.postHit(stack, target, attacker);
	}
}
