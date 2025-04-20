package binarybolias.tercaphinom.references;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

/**
 * Relevant references:
 * {@link net.minecraft.item.ToolMaterials}
 */

public enum ModToolMaterials implements ToolMaterial {
	WOODEN_STICK(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 7, 2.0F, 0.0F, 0,
			() -> Ingredient.ofItems(Items.STICK)),
	//WOODEN_PLANK
	FLINT(BlockTags.INCORRECT_FOR_STONE_TOOL, 120, 3.0F, 2.0F, 5,
			() -> Ingredient.ofItems(Items.FLINT)),
	GLASS(BlockTags.INCORRECT_FOR_STONE_TOOL, 108, 4.0F, 2.0F, 0,
			() -> Ingredient.ofItems(ModItems.GLASS_SHARD)),
	OBSIDIAN(BlockTags.INCORRECT_FOR_STONE_TOOL, 96, 5.0F, 2.0F, 7,
			() -> Ingredient.ofItems(ModItems.OBSIDIAN_SHARD));
//	COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 228, 6.0F, 2.0F, 15,
//			() -> Ingredient.ofItems(Items.COPPER_INGOT)),
	//GOLD
	//IRON
//	BRASS(BlockTags.INCORRECT_FOR_IRON_TOOL, 276, 5.0F, 2.0F, 15,
//			() -> Ingredient.ofItems(Items.COPPER_INGOT));
	//EIDURIL
	//NETHERITE (placeholder name)
	
	private final TagKey<Block> inverseTag;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairIngredient;
	
	ModToolMaterials(
			final TagKey<Block> inverseTag,
			final int itemDurability,
			final float miningSpeed,
			final float attackDamage,
			final int enchantability,
			final Supplier<Ingredient> repairIngredient
	) {
		this.inverseTag = inverseTag;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = Suppliers.memoize(repairIngredient::get);
	}
	
	@Override
	public int getDurability() {
		return itemDurability;
	}
	
	@Override
	public float getMiningSpeedMultiplier() {
		return miningSpeed;
	}
	
	@Override
	public float getAttackDamage() {
		return attackDamage;
	}
	
	@Override
	public TagKey<Block> getInverseTag() {
		return inverseTag;
	}
	
	@Override
	public int getEnchantability() {
		return enchantability;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}
}
