package binarybolias.tercaphinom.references;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static binarybolias.tercaphinom.references.Reference.*;

/**
 * Relevant references:
 * {@link net.minecraft.item.ArmorMaterials}
 */

public class ModArmorMaterials {
	public static final RegistryEntry<ArmorMaterial> COPPER = register("copper",
			Util.make(new EnumMap(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 2);
				map.put(ArmorItem.Type.LEGGINGS, 5);
				map.put(ArmorItem.Type.CHESTPLATE, 6);
				map.put(ArmorItem.Type.HELMET, 2);
				map.put(ArmorItem.Type.BODY, 5);
			}),
			10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F,
			() -> Ingredient.ofItems(Items.COPPER_INGOT)
	);
	public static final RegistryEntry<ArmorMaterial> BRASS = register("brass",
			Util.make(new EnumMap(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 2);
				map.put(ArmorItem.Type.LEGGINGS, 4);
				map.put(ArmorItem.Type.CHESTPLATE, 5);
				map.put(ArmorItem.Type.HELMET, 2);
				map.put(ArmorItem.Type.BODY, 5);
			}),
			9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F,
			() -> Ingredient.ofItems(ModItems.BRASS_INGOT)
	);
	public static final RegistryEntry<ArmorMaterial> EIDURIL = register("eiduril",
			Util.make(new EnumMap(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 11);
			}),
			10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F,
			() -> Ingredient.ofItems(ModItems.EIDURIL_INGOT)
	);
	public static final RegistryEntry<ArmorMaterial> NUTRILLARN = register("nutrillarn",
			Util.make(new EnumMap(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 9);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 11);
			}),
			0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F,
			() -> Ingredient.ofItems(ModItems.NUTRILLARN_INGOT)
	);
	
	
	private static RegistryEntry<ArmorMaterial> register(
			String id,
			EnumMap<ArmorItem.Type, Integer> defense,
			int enchantability,
			RegistryEntry<SoundEvent> equipSound,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> repairIngredient
	) {
//		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier(id)));
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(identifier(id)));
		return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
	}
	
	public static RegistryEntry<ArmorMaterial> getDefault(Registry<ArmorMaterial> registry) {
		return ArmorMaterials.LEATHER;
	}
	
	private static RegistryEntry<ArmorMaterial> register(
			String id,
			EnumMap<ArmorItem.Type, Integer> defense,
			int enchantability,
			RegistryEntry<SoundEvent> equipSound,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> repairIngredient,
			List<ArmorMaterial.Layer> layers
	) {
		EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
		
		for (ArmorItem.Type type : ArmorItem.Type.values()) {
			enumMap.put(type, (Integer)defense.get(type));
		}
		
		return Registry.registerReference(
				Registries.ARMOR_MATERIAL,
//				new Identifier(id),
				identifier(id),
				new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
		);
	}
}
