package binarybolias.tercaphinom.item;

import binarybolias.tercaphinom.references.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Note: Only one piece of each applicable armor set should use this class;
//  each armor item of this type checks all armor slots,
//   so multiple pieces of the set sharing this class would result in superfluous checks every tick while in inventory.
public class SetBonusArmorItem extends ArmorItem {
	private static final Map<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> MATERIAL_TO_EFFECT;
	private static final int MIN_DURATION_UNTIL_RESET = 205;
	private static final int REFRESH_DURATION = MIN_DURATION_UNTIL_RESET + 5;
	
	static {
		MATERIAL_TO_EFFECT = new HashMap<>();
		
		addValue(ModArmorMaterials.EIDURIL, StatusEffects.SPEED, 0);
		
		addValue(ModArmorMaterials.NUTRILLARN, StatusEffects.HASTE, 0);
		addValue(ModArmorMaterials.NUTRILLARN, StatusEffects.STRENGTH, 1);
	}
	
	public SetBonusArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
		super(material, type, settings);
	}
	
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient()) {
			if (entity instanceof PlayerEntity player && hasFullArmorSlots(player)) {
				evaluateArmorEffect(player);
			}
		}
		super.inventoryTick(stack, world, entity, slot, selected);
	}
	
	
	private boolean hasFullArmorSlots(PlayerEntity player) {
		ItemStack bootPairSlotStack = player.getInventory().getArmorStack(0);
		ItemStack leggingPairSlotStack = player.getInventory().getArmorStack(1);
		ItemStack chestplateSlotStack = player.getInventory().getArmorStack(2);
		ItemStack helmetSlotStack = player.getInventory().getArmorStack(3);
		
		return !bootPairSlotStack.isEmpty() &&
				!leggingPairSlotStack.isEmpty() &&
				!chestplateSlotStack.isEmpty() &&
				!helmetSlotStack.isEmpty();
	}
	
	
	private void evaluateArmorEffect(PlayerEntity player) {
		for (Map.Entry<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT.entrySet()) {
			ArmorMaterial material = entry.getKey().value();
			
			entry.getValue().forEach((effect) -> {
				if (wearsFullArmorSetOfMaterial(player, material) && statusEffectIsFading(player, effect)) {
					addStatus(player, effect);
				}
			});
		}
	}
	
	
	private boolean wearsFullArmorSetOfMaterial(PlayerEntity player, ArmorMaterial material) {
		// Check for any worn item which is not an armor item, such as Elytra or Pumpkin.
		for (ItemStack armor : player.getInventory().armor) {
			if (!(armor.getItem() instanceof ArmorItem)) {
				return false;
			}
		}
		// Check the materials of the worn armor items.
		ArmorItem bootPairItem = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
		ArmorItem leggingPairItem = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
		ArmorItem chestplateItem = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
		ArmorItem helmetItem = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
		
		return bootPairItem.getMaterial().value() == material &&
				leggingPairItem.getMaterial().value() == material &&
				chestplateItem.getMaterial().value() == material &&
				helmetItem.getMaterial().value() == material;
	}
	
	
	private boolean statusEffectIsFading(PlayerEntity player, StatusEffectInstance effect) {
		StatusEffectInstance playerEffect = player.getStatusEffect(effect.getEffectType());
		
		return playerEffect == null ||
				!player.hasStatusEffect(effect.getEffectType()) ||
				playerEffect.isDurationBelow(MIN_DURATION_UNTIL_RESET);
	}
	
	
	private void addStatus(PlayerEntity player, StatusEffectInstance effect) {
		player.addStatusEffect(new StatusEffectInstance(
				effect.getEffectType(),
				effect.getDuration(),
				effect.getAmplifier(),
				effect.isAmbient(),
				effect.shouldShowParticles(),
				effect.shouldShowIcon()));
	}
	
	
	private static void addValue(RegistryEntry<ArmorMaterial> material, RegistryEntry<StatusEffect> statusEffect, int amplifier) {
		ArrayList tempList;
		
		StatusEffectInstance newEffect = new StatusEffectInstance(statusEffect, REFRESH_DURATION, amplifier,
				false, false, true);
		
		if (MATERIAL_TO_EFFECT.containsKey(material)) {
			tempList = MATERIAL_TO_EFFECT.get(material);
			// Prevent game crash if the key somehow corresponds to a null value.
			if (tempList == null) {
				tempList = new ArrayList<>();
			}
		} else {
			tempList = new ArrayList<>();
		}
		tempList.add(newEffect);
		MATERIAL_TO_EFFECT.put(material, tempList);
	}
}
