package binarybolias.tercaphinom.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

// Note: With how this adds a potion status effect to a target on-hit, this could be a good base for a broom item class...
//  Brooms would be converted to one of any potion effect by combining them with the potion in basic crafting.?.
public class NutrillarnSwordItem extends SwordItem {
	public NutrillarnSwordItem(ToolMaterial toolMaterial, Settings settings) {
		super(toolMaterial, settings);
	}
	
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 160), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 35), attacker);
		target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 160, 1), attacker);
		return super.postHit(stack, target, attacker);
	}
}
