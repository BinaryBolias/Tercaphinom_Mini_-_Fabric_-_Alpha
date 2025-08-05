package binarybolias.tercaphinom.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

//TODO:
// - Use custom projectile;
//  - Don't spawn endermites.
//  - Don't deal damage to the user.
//  - Add self back to user's possession, preferably to the inventory slot thrown from.
//   - Drop as item at user's location if inventory is full.
// - Use events or something to trigger constant passive effects, rather than using the 'inventoryTick' function.
public class OrbOfZotItem extends Item {
//	private static final int MIN_DURATION_UNTIL_RESET = 1728005; // 24 hours and 0.25 seconds.
	private static final int MIN_DURATION_UNTIL_RESET = 1728000; // 24 hours.
//	private static final int MIN_DURATION_UNTIL_RESET = 5; // 0.25 seconds.
//	private static final int REFRESH_DURATION = MIN_DURATION_UNTIL_RESET + 10; // + 0.5 seconds.
	private static final int REFRESH_DURATION = MIN_DURATION_UNTIL_RESET + 72000; // + 1 hour.
//	private static final int REFRESH_DURATION = MIN_DURATION_UNTIL_RESET + 20; // + 1 second.
	
	public OrbOfZotItem(Settings settings) {
		super(settings);
	}
	
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient() && entity instanceof LivingEntity livingEntity && shouldApplyEffect(stack, livingEntity)) {
			applyOrbOfZotEffects(livingEntity);
		}
		super.inventoryTick(stack, world, entity, slot, selected);
	}
	
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(
				null,
				user.getX(),
				user.getY(),
				user.getZ(),
				SoundEvents.ENTITY_ENDER_PEARL_THROW,
				SoundCategory.NEUTRAL,
				0.5F,
				0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
		);
		user.getItemCooldownManager().set(this, 30);
		if (!world.isClient) {
			EnderPearlEntity enderPearlEntity = new EnderPearlEntity(world, user);
			enderPearlEntity.setItem(itemStack);
			enderPearlEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
			world.spawnEntity(enderPearlEntity);
		}
		
//		itemStack.decrementUnlessCreative(1, user); // TODO: Make a custom projectile which returns the item; until then, just don't decrement the stack.
		return TypedActionResult.success(itemStack, world.isClient());
	}
	
	
	@Override
	public ItemStack getDefaultStack() {
		ItemStack itemStack = super.getDefaultStack();
		
		itemStack.set(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT); // TODO: Does this work?
		itemStack.addEnchantment(Enchantments.VANISHING_CURSE, 1);
		
		return itemStack;
	}
	
	
	private boolean shouldApplyEffect(ItemStack stack, LivingEntity livingEntity) {
		// Check if item is held.
		ItemStack mainhandItemStack = livingEntity.getEquippedStack(EquipmentSlot.MAINHAND);
		ItemStack offhandItemStack = livingEntity.getEquippedStack(EquipmentSlot.OFFHAND);
		if (stack != mainhandItemStack && stack != offhandItemStack) {
			return false;
		}
		return true; // Short-circuit the duration check; apply all status effects every frame.
		
		// Check the remaining status effect duration (only checks one, for performance).
		// NOTE: Only checking one status effect has the potential side effect:
		//  Other status effects are not applied when the given status effect is present with a larger duration from another source.
		//  We attempt to circumvent this by simply applying a large duration to the passive status effects.
//		StatusEffectInstance entityEffect = livingEntity.getStatusEffect(StatusEffects.HUNGER);
//
//		return entityEffect == null ||
//				!livingEntity.hasStatusEffect(StatusEffects.HUNGER) ||
//				entityEffect.isDurationBelow(MIN_DURATION_UNTIL_RESET);
	}
	
	private void applyOrbOfZotEffects(LivingEntity livingEntity) {
		// NOTE: Using simple method; applying all status effects every frame for 1 second each.
		// (haven't yet figured out how to check for when the item leaves the mainhand/offhand)
		applyEffect(livingEntity, StatusEffects.HUNGER, 35, 0);
//		applyPassiveEffect(livingEntity, StatusEffects.HUNGER, 0);
		applyEffect(livingEntity, StatusEffects.REGENERATION, 35, 0);
//		applyPassiveEffect(livingEntity, StatusEffects.REGENERATION, 0);
		applyEffect(livingEntity, StatusEffects.RESISTANCE, 35, 0);
//		applyPassiveEffect(livingEntity, StatusEffects.RESISTANCE, 0);
		applyEffect(livingEntity, StatusEffects.SPEED, 35, 1);
//		applyPassiveEffect(livingEntity, StatusEffects.SPEED, 0);
		applyEffect(livingEntity, StatusEffects.STRENGTH, 35, 2);
//		applyPassiveEffect(livingEntity, StatusEffects.STRENGTH, 2);
		applyEffect(livingEntity, StatusEffects.MINING_FATIGUE, 35, 3);
//		applyPassiveEffect(livingEntity, StatusEffects.MINING_FATIGUE, 4);
//		applyEffect(livingEntity, StatusEffects.FIRE_RESISTANCE, 30, 0);
//		applyPassiveEffect(livingEntity, StatusEffects.FIRE_RESISTANCE, 0);
//		applyEffect(livingEntity, StatusEffects.WATER_BREATHING, 30, 0);
//		applyPassiveEffect(livingEntity, StatusEffects.WATER_BREATHING, 0);
	}
	
	// TODO: Call this method when the item leaves the mainhand/offhand (though not when switching between mainhand and offhand).
	private void removeOrbOfZotEffects(LivingEntity livingEntity) {
		removeEffect(livingEntity, StatusEffects.HUNGER);
		removeEffect(livingEntity, StatusEffects.REGENERATION);
		removeEffect(livingEntity, StatusEffects.RESISTANCE);
		removeEffect(livingEntity, StatusEffects.SPEED);
		removeEffect(livingEntity, StatusEffects.STRENGTH);
		removeEffect(livingEntity, StatusEffects.MINING_FATIGUE);
//		removeEffect(livingEntity, StatusEffects.FIRE_RESISTANCE);
//		removeEffect(livingEntity, StatusEffects.WATER_BREATHING);
		// Apply residual effects.
		applyEffect(livingEntity, StatusEffects.HUNGER, 60, 0);
		applyEffect(livingEntity, StatusEffects.MINING_FATIGUE, 140, 2);
		applyEffect(livingEntity, StatusEffects.SLOWNESS, 140, 0);
	}
	
	
	private void applyPassiveEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> statusEffect, int amplifier) {
		applyEffect(livingEntity, statusEffect, REFRESH_DURATION, amplifier);
	}
	
	
	private void applyEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> statusEffect, int duration, int amplifier) {
		livingEntity.addStatusEffect(new StatusEffectInstance(
				statusEffect, duration, amplifier, false, false, true));
	}
	
	
	private void removeEffect(LivingEntity livingEntity, RegistryEntry<StatusEffect> statusEffect) {
		livingEntity.removeStatusEffect(statusEffect);
	}
}
