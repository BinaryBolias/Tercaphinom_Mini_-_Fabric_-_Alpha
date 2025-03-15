package binarybolias.tercaphinom.references;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum ModArmorMaterials implements ArmorMaterial {
	; // This semicolon is necessary for an unknown reason.
	
	@Override
	public int getDurability(ArmorItem.Type type) {
		return 0;
	}
	
	@Override
	public int getProtection(ArmorItem.Type type) {
		return 0;
	}
	
	@Override
	public int getEnchantability() {
		return 0;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return null;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}
	
	@Override
	public String getName() {
		return "";
	}
	
	@Override
	public float getToughness() {
		return 0;
	}
	
	@Override
	public float getKnockbackResistance() {
		return 0;
	}
}
