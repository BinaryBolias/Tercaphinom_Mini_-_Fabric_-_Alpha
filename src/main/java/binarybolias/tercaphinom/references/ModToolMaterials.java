package binarybolias.tercaphinom.references;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * Provides the default {@link ToolMaterial}s used by Tercaphinom's tools.
 * @see net.minecraft.item.ToolMaterials
 */
public enum ModToolMaterials implements ToolMaterial {
	//TODO: The repair material for metal tools (and armor; see ModArmorMaterials) could be the corresponding gram, rather than ingot.
	// Without also modifying the anvil's repair algorithm, this would make repair cheaper, rewarding the player for interacting with the mechanic.
	// This would also justify making vanilla iron, gold, and netherite tool/armor sets unobtainable, and replacing them with custom sets.
	// Replacing the remaining vanilla tool/armor sets (aside from leather) would allow for an overhaul to stat scaling (notably durability).
	// - Copper, Gold, Iron, and Brass should all have higher durability.
	
	// NOTE: Tool tiers no longer matter for block destruction; the "INCORRECT_FOR" tags are deprecated.
	// "INCORRECT_FOR" tags replaced with 'Tags.Block.NIL' for brevity.
	WOODEN_STICK(Tags.Block.NIL, 7, 2.0F, 0.0F, 0,
			() -> Ingredient.ofItems(Items.STICK)),
	WOOD(Tags.Block.NIL, 59, 2.0F, 1.0F, 15,
			() -> Ingredient.fromTag(Tags.Item.ALL_PLANKS)),
	FLINT(Tags.Block.NIL, 120, 3.0F, 2.0F, 5,
			() -> Ingredient.ofItems(Items.FLINT)),
	GLASS(Tags.Block.NIL, 108, 4.0F, 2.0F, 0,
			() -> Ingredient.ofItems(ModItems.GLASS_SHARD)),
	OBSIDIAN(Tags.Block.NIL, 96, 5.0F, 3.0F, 7,
			() -> Ingredient.ofItems(ModItems.OBSIDIAN_SHARD)),
	COPPER(Tags.Block.NIL, 228, 6.0F, 2.0F, 15,
			() -> Ingredient.ofItems(Items.COPPER_INGOT)),
	// (gold and iron here are presently just quick references for vanilla)
	//GOLD(Tags.Block.NIL,  32, 12.0F, 0.0F, 22,
	//			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT));
	//IRON(Tags.Block.NIL,  250, 6.0F, 2.0F, 14,
	//			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT));
	BRASS(Tags.Block.NIL, 276, 5.0F, 2.0F, 14,
			() -> Ingredient.ofItems(ModItems.BRASS_INGOT)),
	EIDURIL(Tags.Block.NIL, 1561, 8.0F, 3.0F, 12,
			() -> Ingredient.ofItems(ModItems.EIDURIL_INGOT)),
	// ("Netherite" as placeholder name)
	//NETHERITE(Tags.Block.NIL,  2031, 9.0F, 4.0F, 15,
	//			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT));
	NUTRILLARN(Tags.Block.NIL, 96, 12.0F, 7.0F, 0,
			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT));
	
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
