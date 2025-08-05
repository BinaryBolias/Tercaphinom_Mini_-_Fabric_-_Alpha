package binarybolias.tercaphinom.references;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.entry.RegistryEntry;


/**
 * Contains all the default food components used in tercaphinom's food items.
 * @see net.minecraft.component.type.FoodComponents
 */
public class FoodComponents {
	// Note: Vanilla food component definitions are included (and commented out) for reference.
	
	// Note: On the 'saturationModifier' parameter of the food component builder:
	// - Final saturation provision is ((2 * saturationModifier) * nutrition).
	// - Thus:
	//  - A saturationModifier of '0.5' produces a final saturation equal to nutrition.
	//  - A saturationModifier of '0.6' produces a final saturation equal to 1.2 times (20% greater than) nutrition.
	//  - A saturationModifier of '1.0' produces a final saturation with twice the value of nutrition.
	//  - A saturationModifier of '1.5' produces a final saturation with three times the value of nutrition.
	
	
	//region ## Basic Food Components ##
	//# Fruit #
//	public static final FoodComponent APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
	public static final FoodComponent CHERRY_BUNCH = foodComponentBuilder(2, 0.125F).build();
//	public static final FoodComponent CHORUS_FRUIT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).alwaysEdible().build();
//	public static final FoodComponent GLOW_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
//	public static final FoodComponent MELON_SLICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
//	public static final FoodComponent SWEET_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
	
	//# Golden #
//	public static final FoodComponent ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0F)
//			.alwaysEdible()
//			.build();
//	public static final FoodComponent GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F)
//			.alwaysEdible()
//			.build();
//	public static final FoodComponent GOLDEN_CARROT = new FoodComponent.Builder().nutrition(6).saturationModifier(1.2F).build();
	
	//# Meat (cooked) #
//	public static final FoodComponent COOKED_BEEF = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
	public static final FoodComponent COOKED_BUGMEAT_STEAK = foodComponentBuilder(4, 0.5F).build();
//	public static final FoodComponent COOKED_CHICKEN = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
//	public static final FoodComponent COOKED_COD = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6F).build();
	public static final FoodComponent COOKED_MEAT_MORSEL = foodComponentBuilder(3, 0.5F).snack().build();
//	public static final FoodComponent COOKED_MUTTON = new FoodComponent.Builder().nutrition(6).saturationModifier(0.8F).build();
//	public static final FoodComponent COOKED_PORKCHOP = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
//	public static final FoodComponent COOKED_RABBIT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6F).build();
//	public static final FoodComponent COOKED_SALMON = new FoodComponent.Builder().nutrition(6).saturationModifier(0.8F).build();
	
	//# Meat (raw) #
//	public static final FoodComponent BEEF = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();
//	public static final FoodComponent CHICKEN = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F)
//			.build();
//	public static final FoodComponent COD = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
//	public static final FoodComponent MUTTON = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
//	public static final FoodComponent PORKCHOP = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();
//	public static final FoodComponent PUFFERFISH = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 1), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 2), 1.0F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0F)
//			.build();
//	public static final FoodComponent RABBIT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();
	public static final FoodComponent RAW_BUGMEAT_STEAK = foodComponentBuilder(3, 0.2F)
			.statusEffect(statusEffectInstance(StatusEffects.HUNGER, 120, 0), 0.3125F)
			.statusEffect(statusEffectInstance(StatusEffects.POISON, 75, 0), 0.75F)
			.build();
	public static final FoodComponent RAW_MEAT_MORSEL = foodComponentBuilder(2, 0.2F).snack()
			.statusEffect(statusEffectInstance(StatusEffects.HUNGER, 100, 0), 0.25F)
			.build();
//	public static final FoodComponent SALMON = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
//	public static final FoodComponent TROPICAL_FISH = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).build();
	
	//# Vegetable (baked) #
	public static final FoodComponent BAKED_CARROT = foodComponentBuilder(4, 0.6F).build();
	public static final FoodComponent BAKED_MUSHROOM = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5F).build();
//	public static final FoodComponent BAKED_POTATO = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6F).build();
	public static final FoodComponent BAKED_RADISH = new FoodComponent.Builder().nutrition(2).saturationModifier(0.6F).build();
	
	//# Vegetable (raw) #
//	public static final FoodComponent BEETROOT = new FoodComponent.Builder().nutrition(1).saturationModifier(0.6F).build();
//	public static final FoodComponent CARROT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6F).build();
//	public static final FoodComponent POISONOUS_POTATO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.6F)
//			.build();
//	public static final FoodComponent POTATO = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F).build();
	
	//# Miscellaneous #
	public static final FoodComponent CHEESE_WHEEL = foodComponentBuilder(5, 0.6F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 210, 0), 1.0F)
			.build();
//	public static final FoodComponent DRIED_KELP = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F).snack().build();
	public static final FoodComponent DRY_KELP_BUNDLE = foodComponentBuilder(4, 0.25F)
			.build();
	public static final FoodComponent FRIED_EGG = foodComponentBuilder(4, 0.5F)
			.build();
	public static final FoodComponent LIVE_GRASS_TUFT = foodComponentBuilder(1, 0.125F)
			.build();
//	public static final FoodComponent ROTTEN_FLESH = new FoodComponent.Builder().nutrition(4).saturationModifier(0.1F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.8F)
//			.build();
//	public static final FoodComponent SPIDER_EYE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.8F)
//			.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F)
//			.build();
	public static final FoodComponent WARPED_FLESH_CHUNK = foodComponentBuilder(3, 0.2F)
			.statusEffect(statusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.78125F)
			.build();
	//endregion
	
	
	//region ## Dough & Pastry Food Components ##
	//# Bun & Cookie - Cooked #
//	public static final FoodComponent COOKIE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
	public static final FoodComponent HONEYBUN = foodComponentBuilder(6, 0.5F).build();
	public static final FoodComponent MAGMABUN = foodComponentBuilder(3, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 160, 0), 1.0F)
			.build();
	public static final FoodComponent SLIMEBUN = foodComponentBuilder(3, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.WATER_BREATHING, 160, 0), 1.0F)
			.build();
	//# Bun & Cookie - Raw #
	public static final FoodComponent RAW_COOKIE_BALL = foodComponentBuilder(1, 0.125F)
			.build();
	public static final FoodComponent RAW_HONEYBUN_BALL = foodComponentBuilder(3, 0.125F)
			.build();
	public static final FoodComponent RAW_MAGMABUN_BALL = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.POISON, 100, 0), 0.75F)
			.build();
	public static final FoodComponent RAW_SLIMEBUN_BALL = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.POISON, 100, 0), 0.75F)
			.build();
	//# Pie - Cooked #
	public static final FoodComponent APPLE_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 60, 0), 1.0F)
			.build();
	public static final FoodComponent CHERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 60, 0), 1.0F)
			.build();
	public static final FoodComponent GLOWBERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 60, 0), 1.0F)
			.build();
//	public static final FoodComponent PUMPKIN_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3F).build();
	public static final FoodComponent PUMPKIN_PIE = foodComponentBuilder(10, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.RESISTANCE, 400, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 80, 0), 1.0F)
			.build();
	public static final FoodComponent SWEETBERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 60, 0), 1.0F)
			.build();
	//# Pie - Raw #
	public static final FoodComponent RAW_APPLE_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F)
			.build();
	public static final FoodComponent RAW_CHERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F)
			.build();
	public static final FoodComponent RAW_GLOWBERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F)
			.build();
	public static final FoodComponent RAW_PUMPKIN_PIE = foodComponentBuilder(10, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F)
			.build();
	public static final FoodComponent RAW_SWEETBERRY_PIE = foodComponentBuilder(12, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F)
			.build();
	//# Miscellaneous - Cooked #
//	public static final FoodComponent BREAD = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6F).build();
	//# Miscellaneous - Raw #
	public static final FoodComponent RAW_CAKE = foodComponentBuilder(6, 0.125F).build();
	public static final FoodComponent RAW_DOUGH_LUMP = foodComponentBuilder(3, 0.125F).build();
	//endregion
	
	
	//region ## Bottle Food Components ##
	public static final FoodComponent BOTTLE_OF_BRIMWATER = foodComponentBuilder(3, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.WITHER, 160, 1), 1.0F)
			.build();
	public static final FoodComponent BOTTLE_OF_FREEZEWATER = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 160, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 160, 0), 1.0F)
			.build();
	public static final FoodComponent BOTTLE_OF_STEAMING_WATER = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 60, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 480, 0), 1.0F)
			.build();
//	public static final FoodComponent HONEY_BOTTLE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.1F).build();
//	public static final FoodComponent OMINOUS_BOTTLE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1F).build();
	//endregion
	
	
	//region ## Bowl Food Components ##
	//# Soup #
//	public static final FoodComponent BEETROOT_SOUP = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
	public static final FoodComponent BOWL_OF_CARROT_SOUP = foodComponentBuilder(14, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_KELP_SOUP = foodComponentBuilder(14, 0.25F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_MUSHROOM_SOUP = foodComponentBuilder(8, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_POISONOUS_POTATO_SOUP = foodComponentBuilder(17, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.HUNGER, 100, 0), 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.POISON, 100, 0), 0.125F)
			.build();
	public static final FoodComponent BOWL_OF_PORRIDGE = foodComponentBuilder(6, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_POTATO_SOUP = foodComponentBuilder(17, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_PUMPKIN_SOUP = foodComponentBuilder(6, 0.375F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.RESISTANCE, 400, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_RADISH_SOUP = foodComponentBuilder(8, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 250, 0), 1.0F)
			.build();
	
	//# Stew #
	public static final FoodComponent BOWL_OF_BEEF_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_BEEF, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_BUGMEAT_STEW = stewBuilder(COOKED_BUGMEAT_STEAK, 2, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_CHICKEN_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_CHICKEN, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_COD_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_COD, 2, 0.625F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_MORSEL_STEW = stewBuilder(COOKED_MEAT_MORSEL, 1, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 400, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_MUTTON_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_MUTTON, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_PORK_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_PORKCHOP, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_RABBIT_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_RABBIT, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_SALMON_STEW = stewBuilder(net.minecraft.component.type.FoodComponents.COOKED_SALMON, 2, 0.75F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 500, 0), 1.0F)
			.build();
//	public static final FoodComponent MUSHROOM_STEW = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
//	public static final FoodComponent RABBIT_STEW = new FoodComponent.Builder().nutrition(10).saturationModifier(0.6F).build();
//	public static final FoodComponent SUSPICIOUS_STEW = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
	
	//# Miscellaneous #
	public static final FoodComponent BOWL_OF_BRIMWATER = foodComponentBuilder(3, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.WITHER, 160, 1), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_FREEZEWATER = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 160, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 160, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_HONEY = foodComponentBuilder(6, 0.125F)
			.build();
	public static final FoodComponent BOWL_OF_STEAMING_WATER = foodComponentBuilder(1, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 50, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 480, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_WATER = new FoodComponent.Builder().nutrition(0).saturationModifier(0.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 300, 0), 1.0F)
			.build();
	//endregion
	
	
	//region ## Bucket Food Components ##
	public static final FoodComponent BUCKET_OF_BRIMWATER = foodComponentBuilder(9, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.WITHER, 480, 1), 1.0F)
			.build();
	public static final FoodComponent BUCKET_OF_FREEZEWATER = foodComponentBuilder(3, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 400, 0), 1.0F)
			.build();
	public static final FoodComponent BUCKET_OF_HONEY = foodComponentBuilder(18, 0.125F)
			.build();
	public static final FoodComponent BUCKET_OF_STEAMING_WATER = foodComponentBuilder(3, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 135, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 1200, 0), 1.0F)
			.build();
	//endregion
	
	
	//region ## Joke & Unserious Food Components ##
	//# Bowl #
	public static final FoodComponent BOWL_OF_OMNISTEW = foodComponentBuilder(48, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 1200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SLOWNESS, 600, 0), 1.0F)
			.build();
	public static final FoodComponent BOWL_OF_STONE_SOUP = foodComponentBuilder(4, 0.125F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 600, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 600, 0), 1.0F)
			.build();
	
	//# Cheese #
	public static final FoodComponent BLUE_CHEESE_WEDGE = foodComponentBuilder(2, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 300, 0), 1.0F)
			.build();
	public static final FoodComponent SILKY_SMOOTH_CHEESE_WEDGE = foodComponentBuilder(2, 0.5F)
			.snack().build();
	public static final FoodComponent YELLOW_CHEESE_WEDGE = foodComponentBuilder(2, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 160, 0), 1.0F)
			.build();
	
	//# Nutrillarn #
	public static final FoodComponent NUTRILLARN_COMPASS = foodComponentBuilder(24, 0.5F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 240, 2), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 240, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.WATER_BREATHING, 240, 0), 1.0F)
			.alwaysEdible().build();
	public static final FoodComponent NUTRILLARN_GRAM = foodComponentBuilder(3, 0.5F)
			.snack().build();
	public static final FoodComponent NUTRILLARN_INGOT = foodComponentBuilder(18, 0.5F)
			.build();
	public static final FoodComponent RAW_NUTRILLARN_LUMP = foodComponentBuilder(12, 0.5F)
			.build();
	public static final FoodComponent RAW_NUTRILLARN_NUGGET = foodComponentBuilder(2, 0.5F)
			.snack().build();
	
	//# Miscellaneous #
	public static final FoodComponent CHERRY_JELLYBALL = foodComponentBuilder(2, 0.5F)
			.build();
	public static final FoodComponent CHOCOLATE_BAR = foodComponentBuilder(4, 0.5F)
			.build();
	public static final FoodComponent CHULK_BERRY_BUNCH = foodComponentBuilder(2, 0.75F)
			.build();
	public static final FoodComponent HONEYPOD = foodComponentBuilder(4, 0.5F)
			.build();
	public static final FoodComponent MILKLEAF_PILE = foodComponentBuilder(1, 0.5F)
			.snack().build();
	public static final FoodComponent MINIWIZARD = foodComponentBuilder(2, 1.5F)
			.statusEffect(statusEffectInstance(StatusEffects.ABSORPTION, 3600, 4), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.FIRE_RESISTANCE, 240, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.HASTE, 1200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.HUNGER, 1200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.RESISTANCE, 4800, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.SPEED, 1200, 0), 1.0F)
			.statusEffect(statusEffectInstance(StatusEffects.WATER_BREATHING, 240, 0), 1.0F)
			.alwaysEdible().build();
	public static final FoodComponent STARCHCAP_MUSHROOM = new FoodComponent.Builder().nutrition(1).saturationModifier(0.125F).build();
	//endregion
	
	// --END OF FOOD COMPONENT DEFINITION--
	
	
	//region # Food Component Builder Methods #
	private static FoodComponent.Builder foodComponentBuilder(int nutrition, float saturationModifier) {
		return new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturationModifier);
	}
	
	
	private static FoodComponent.Builder stewBuilder(FoodComponent baseFood, int bonusNutrition, float saturationModifier) {
		// Set nutrition to the sum of the stew ingredients, plus the given bonus.
		int bakedCarrotNutrition = BAKED_CARROT.nutrition();
		int bakedMushroomNutrition = BAKED_MUSHROOM.nutrition();
		int bakedPotatoNutrition = net.minecraft.component.type.FoodComponents.BAKED_POTATO.nutrition();
		int nutrition = baseFood.nutrition() + bakedCarrotNutrition + bakedMushroomNutrition + bakedPotatoNutrition;
		nutrition += bonusNutrition;
		
		return new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturationModifier);
	}
	//endregion
	
	
	//region # Miscellaneous Utility Methods #
	private static StatusEffectInstance statusEffectInstance(RegistryEntry<StatusEffect> effect, int duration, int amplifier) {
		return new StatusEffectInstance(effect, duration, amplifier, false, false, true);
	}
	//endregion
}
