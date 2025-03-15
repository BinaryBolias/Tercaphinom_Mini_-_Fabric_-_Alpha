package binarybolias.tercaphinom.references;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {
	; // This semicolon is necessary for an unknown reason.
	
	@Override
	public int getDurability() {
		return 0;
	}
	
	@Override
	public float getMiningSpeedMultiplier() {
		return 0;
	}
	
	@Override
	public float getAttackDamage() {
		return 0;
	}
	
	@Override
	public int getMiningLevel() {
		return 0;
	}
	
	@Override
	public int getEnchantability() {
		return 0;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}
}
