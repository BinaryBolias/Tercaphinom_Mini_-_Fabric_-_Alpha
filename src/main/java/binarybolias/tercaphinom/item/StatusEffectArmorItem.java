package binarybolias.tercaphinom.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;


public class StatusEffectArmorItem extends ArmorItem {
	private static final int MIN_DURATION_UNTIL_RESET = 205;
	private static final int REFRESH_DURATION = MIN_DURATION_UNTIL_RESET + 5;
	
	protected final RegistryEntry<StatusEffect> statusEffect;
	protected final int amplifier;
	
	
	public StatusEffectArmorItem(
			RegistryEntry<ArmorMaterial> material, Type type,
			RegistryEntry<StatusEffect> statusEffect, int amplifier, Settings settings) {
		super(material, type, settings);
		this.statusEffect = statusEffect;
		this.amplifier = amplifier;
	}
	
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient() && entity instanceof LivingEntity livingEntity && shouldApplyEffect(stack, livingEntity)) {
			applyEffect(livingEntity);
		}
		super.inventoryTick(stack, world, entity, slot, selected);
	}
	
	
	private void applyEffect(LivingEntity livingEntity) {
		livingEntity.addStatusEffect(new StatusEffectInstance(
				statusEffect, REFRESH_DURATION, amplifier, false, false, true));
	}
	
	
	private boolean shouldApplyEffect(ItemStack stack, LivingEntity livingEntity) {
		// Check if item is equipped.
		switch (type) {
			case BOOTS -> {if (stack != livingEntity.getEquippedStack(EquipmentSlot.FEET)) {return false;}}
			case CHESTPLATE -> {if (stack != livingEntity.getEquippedStack(EquipmentSlot.CHEST)) {return false;}}
			case HELMET -> {if (stack != livingEntity.getEquippedStack(EquipmentSlot.HEAD)) {return false;}}
			case LEGGINGS -> {if (stack != livingEntity.getEquippedStack(EquipmentSlot.LEGS)) {return false;}}
		}
		
		// Check the status effect on the entity.
		StatusEffectInstance entityEffect = livingEntity.getStatusEffect(statusEffect);
		
		return entityEffect == null ||
				!livingEntity.hasStatusEffect(statusEffect) ||
				entityEffect.isDurationBelow(MIN_DURATION_UNTIL_RESET);
	}
}
