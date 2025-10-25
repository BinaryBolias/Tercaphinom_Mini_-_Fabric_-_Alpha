package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.JAUItems;
import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import binarybolias.tercaphinom.registry.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;


/**
 * @see net.minecraft.data.server.tag.vanilla.VanillaItemTagProvider
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		logMainEvent("Generating item tag data");
		
		//region ## Crafting Materials ##
		//region # Flame & Torch Materials #
		// Flame materials
		getOrCreateTagBuilder(ItemTags.BASIC_FLAME_MATERIALS)
				.add(Items.CHARCOAL)
				.add(Items.COAL);
		getOrCreateTagBuilder(ItemTags.SPIRIT_FLAME_MATERIALS)
				.add(ModItems.SOULSAND_PILE)
				.add(ModItems.SOULSOIL_CLOD)
				.add(ModItems.SULPHUR_LUMP);
		// Torch binders
		getOrCreateTagBuilder(ItemTags.STRONG_TORCH_BINDERS)
				.addTag(ItemTags.ALL_YARNBALLS);
		getOrCreateTagBuilder(ItemTags.WEAK_TORCH_BINDERS)
				.add(ModItems.DRY_GRASS_TUFT);
		//endregion
		//region # Meat Rotting #
		// Large Rottable Meats
		getOrCreateTagBuilder(ItemTags.LARGE_ROTTABLE_MEATS)
				.add(Items.BEEF)
				.add(Items.COOKED_BEEF)
				.add(ModItems.RAW_BUGMEAT_STEAK)
				.add(ModItems.COOKED_BUGMEAT_STEAK)
				.add(Items.CHICKEN)
				.add(Items.COOKED_CHICKEN)
				.add(Items.MUTTON)
				.add(Items.COOKED_MUTTON)
				.add(Items.PORKCHOP)
				.add(Items.COOKED_PORKCHOP)
				.add(Items.RABBIT)
				.add(Items.COOKED_RABBIT);
		// Small Rottable Meats
		getOrCreateTagBuilder(ItemTags.SMALL_ROTTABLE_MEATS)
				.add(Items.COD)
				.add(Items.COOKED_COD)
				.add(ModItems.RAW_MEAT_MORSEL)
				.add(ModItems.COOKED_MEAT_MORSEL)
				.add(Items.PUFFERFISH)
				.add(Items.SALMON)
				.add(Items.COOKED_SALMON)
				.add(Items.TROPICAL_FISH);
		//endregion
		//region # Miscellaneous #
		// Arrowhead Materials
		getOrCreateTagBuilder(ItemTags.ARROWHEAD_MATERIALS)
				.add(ModItems.BRASS_GRAM)
				.add(ModItems.COPPER_GRAM)
				.add(Items.FLINT)
				.add(ModItems.GLASS_SHARD)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM)
				.add(ModItems.OBSIDIAN_SHARD);
		// Broom Materials
		getOrCreateTagBuilder(ItemTags.BROOM_MATERIALS) // TODO: Add broom item.
				.add(Items.WHEAT)
				.add(ModItems.DRY_GRASS_TUFT);
		// Decomposable Materials
		getOrCreateTagBuilder(ItemTags.DECOMPOSABLE_MATERIALS)
				.add(ModItems.ASH_PILE)
				.add(Items.BONE_MEAL)
				.add(Items.PINK_PETALS)
				.add(ModItems.LEAF_PILE);
		// Placeable Block Material Binders
		getOrCreateTagBuilder(ItemTags.PLACEABLE_BLOCK_MATERIAL_BINDERS)
				.add(Items.EMERALD)
				.add(ModItems.SILK_WAD)
				.add(Items.SLIME_BALL);
		// Raw Cake Berries
		getOrCreateTagBuilder(ItemTags.RAW_CAKE_BERRIES)
				.add(Items.GLOW_BERRIES)
				.add(Items.SWEET_BERRIES)
				.add(ModItems.CHERRY_BUNCH);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.DECORATED_POT_SHERDS);
		//endregion
		//endregion
		
		
		//region ## Containers ##
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_BRIMWATER)
				.add(ModItems.BOTTLE_OF_BRIMWATER)
				.add(ModItems.BOWL_OF_BRIMWATER);
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_FREEZEWATER)
				.add(ModItems.BOTTLE_OF_FREEZEWATER)
				.add(ModItems.BOWL_OF_FREEZEWATER);
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_HONEY)
				.add(Items.HONEY_BOTTLE)
				.add(ModItems.BOWL_OF_HONEY);
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_MILK)
				.add(ModItems.BOTTLE_OF_MILK)
				.add(ModItems.BOWL_OF_MILK);
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.add(ModItems.BOTTLE_OF_STEAMING_WATER)
				.add(ModItems.BOWL_OF_STEAMING_WATER);
		getOrCreateTagBuilder(ItemTags.SMALL_CONTAINERS_OF_WATER)
				.add(Items.POTION)
				.add(ModItems.BOWL_OF_WATER);
		//endregion
		
		//region ## Item Classification ##
		//region # Cobblestones #
		getOrCreateTagBuilder(ItemTags.ALL_COBBLESTONES)
				.add(ModItems.STIEFANE_COBBLESTONE)
				// Temporary inclusions for playtesting.
				.add(Items.COBBLED_DEEPSLATE, Items.COBBLESTONE, Items.MOSSY_COBBLESTONE,
						Items.BASALT, Items.SMOOTH_BASALT, Items.BLACKSTONE,
						Items.ANDESITE, Items.DIORITE, Items.GRANITE, Items.DRIPSTONE_BLOCK)
		;
		//endregion
		//region # Glassy Sand Piles #
		getOrCreateTagBuilder(ItemTags.ALL_GLASSY_SAND_PILES)
				.add(ModItems.FELDSAND_PILE)
				.add(ModItems.FERROSAND_PILE)
				.add(ModItems.SKORSAND_PILE);
		//endregion
		//region # Large Bricks #
		getOrCreateTagBuilder(ItemTags.ALL_LARGE_BRICKS)
				.add(ModItems.STIEFANE_BRICK);
		//endregion
		//region # Metal Grams #
		getOrCreateTagBuilder(ItemTags.ALL_METAL_GRAMS)
				.add(ModItems.BRASS_GRAM)
				.add(ModItems.COPPER_GRAM)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM);
		//endregion
		//region # Planks #
		getOrCreateTagBuilder(ItemTags.ALL_PLANKS)
				.add(ModItems.ACACIA_PLANK)
				.add(ModItems.BIRCH_PLANK)
				.add(ModItems.CHERRY_PLANK)
				.add(ModItems.CRIMSON_PLANK)
				.add(ModItems.DARK_OAK_PLANK)
				.add(ModItems.MAHOGANY_PLANK)
				.add(ModItems.MANGROVE_PLANK)
				.add(ModItems.OAK_PLANK)
				.add(ModItems.SPRUCE_PLANK)
				.add(ModItems.VERDAK_PLANK)
				.add(ModItems.WARPED_PLANK);
		//endregion
		//region # Spawn Eggs #
		getOrCreateTagBuilder(ItemTags.ALL_SPAWN_EGGS)
				.add(Items.ALLAY_SPAWN_EGG)
				.add(Items.ARMADILLO_SPAWN_EGG)
				.add(Items.AXOLOTL_SPAWN_EGG)
				.add(Items.BAT_SPAWN_EGG)
				.add(Items.BEE_SPAWN_EGG)
				.add(Items.BLAZE_SPAWN_EGG)
				.add(Items.BOGGED_SPAWN_EGG)
				.add(Items.BREEZE_SPAWN_EGG)
				.add(Items.CAMEL_SPAWN_EGG)
				.add(Items.CAT_SPAWN_EGG)
				.add(Items.CAVE_SPIDER_SPAWN_EGG)
				.add(Items.CHICKEN_SPAWN_EGG)
				.add(Items.COD_SPAWN_EGG)
				.add(Items.COW_SPAWN_EGG)
				.add(Items.CREEPER_SPAWN_EGG)
				.add(Items.DOLPHIN_SPAWN_EGG)
				.add(Items.DONKEY_SPAWN_EGG)
				.add(Items.DROWNED_SPAWN_EGG)
				.add(Items.ELDER_GUARDIAN_SPAWN_EGG)
				.add(Items.ENDER_DRAGON_SPAWN_EGG)
				.add(Items.ENDERMAN_SPAWN_EGG)
				.add(Items.ENDERMITE_SPAWN_EGG)
				.add(Items.EVOKER_SPAWN_EGG)
				.add(Items.FOX_SPAWN_EGG)
				.add(Items.FROG_SPAWN_EGG)
				.add(Items.GHAST_SPAWN_EGG)
				.add(Items.GLOW_SQUID_SPAWN_EGG)
				.add(Items.GOAT_SPAWN_EGG)
				.add(Items.GUARDIAN_SPAWN_EGG)
				.add(Items.HOGLIN_SPAWN_EGG)
				.add(Items.HORSE_SPAWN_EGG)
				.add(Items.HUSK_SPAWN_EGG)
				.add(Items.IRON_GOLEM_SPAWN_EGG)
				.add(Items.LLAMA_SPAWN_EGG)
				.add(Items.MAGMA_CUBE_SPAWN_EGG)
				.add(Items.MOOSHROOM_SPAWN_EGG)
				.add(Items.MULE_SPAWN_EGG)
				.add(Items.OCELOT_SPAWN_EGG)
				.add(Items.PANDA_SPAWN_EGG)
				.add(Items.PARROT_SPAWN_EGG)
				.add(Items.PHANTOM_SPAWN_EGG)
				.add(Items.PIG_SPAWN_EGG)
				.add(Items.PIGLIN_BRUTE_SPAWN_EGG)
				.add(Items.PILLAGER_SPAWN_EGG)
				.add(Items.POLAR_BEAR_SPAWN_EGG)
				.add(Items.PUFFERFISH_SPAWN_EGG)
				.add(Items.RABBIT_SPAWN_EGG)
				.add(Items.RAVAGER_SPAWN_EGG)
				.add(Items.SALMON_SPAWN_EGG)
				.add(Items.SHEEP_SPAWN_EGG)
				.add(Items.SHULKER_SPAWN_EGG)
				.add(Items.SILVERFISH_SPAWN_EGG)
				.add(Items.SKELETON_HORSE_SPAWN_EGG)
				.add(Items.SKELETON_SPAWN_EGG)
				.add(Items.SLIME_SPAWN_EGG)
				.add(Items.SNIFFER_SPAWN_EGG)
				.add(Items.SNOW_GOLEM_SPAWN_EGG)
				.add(Items.SPIDER_SPAWN_EGG)
				.add(Items.SQUID_SPAWN_EGG)
				.add(Items.STRAY_SPAWN_EGG)
				.add(Items.STRIDER_SPAWN_EGG)
				.add(Items.TADPOLE_SPAWN_EGG)
				.add(Items.TRADER_LLAMA_SPAWN_EGG)
				.add(Items.TROPICAL_FISH_SPAWN_EGG)
				.add(Items.TURTLE_SPAWN_EGG)
				.add(Items.VEX_SPAWN_EGG)
				.add(Items.VILLAGER_SPAWN_EGG)
				.add(Items.VINDICATOR_SPAWN_EGG)
				.add(Items.WANDERING_TRADER_SPAWN_EGG)
				.add(Items.WARDEN_SPAWN_EGG)
				.add(Items.WITCH_SPAWN_EGG)
				.add(Items.WITHER_SKELETON_SPAWN_EGG)
				.add(Items.WITHER_SPAWN_EGG)
				.add(Items.WOLF_SPAWN_EGG)
				.add(Items.ZOGLIN_SPAWN_EGG)
				.add(Items.ZOMBIE_HORSE_SPAWN_EGG)
				.add(Items.ZOMBIE_SPAWN_EGG)
				.add(Items.ZOMBIE_VILLAGER_SPAWN_EGG)
				.add(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
		//endregion
		//region # Stained Glass Panes #
		getOrCreateTagBuilder(ItemTags.ALL_STAINED_GLASS_PANES)
				.add(ModItems.BLACK_STAINED_GLASS_PANE)
				.add(ModItems.BLUE_STAINED_GLASS_PANE)
				.add(ModItems.BROWN_STAINED_GLASS_PANE)
				.add(ModItems.CYAN_STAINED_GLASS_PANE)
				.add(ModItems.GRAY_STAINED_GLASS_PANE)
				.add(ModItems.GREEN_STAINED_GLASS_PANE)
				.add(ModItems.LIGHT_BLUE_STAINED_GLASS_PANE)
				.add(ModItems.LIGHT_GRAY_STAINED_GLASS_PANE)
				.add(ModItems.LIME_STAINED_GLASS_PANE)
				.add(ModItems.MAGENTA_STAINED_GLASS_PANE)
				.add(ModItems.ORANGE_STAINED_GLASS_PANE)
				.add(ModItems.PINK_STAINED_GLASS_PANE)
				.add(ModItems.PURPLE_STAINED_GLASS_PANE)
				.add(ModItems.RED_STAINED_GLASS_PANE)
				.add(ModItems.WHITE_STAINED_GLASS_PANE)
				.add(ModItems.YELLOW_STAINED_GLASS_PANE);
		//endregion
		//region # Yarn Rolls #
		getOrCreateTagBuilder(ItemTags.ALL_YARN_ROLLS)
				.add(ModItems.BLACK_YARN_ROLL)
				.add(ModItems.BLUE_YARN_ROLL)
				.add(ModItems.BROWN_YARN_ROLL)
				.add(ModItems.CYAN_YARN_ROLL)
				.add(ModItems.GRAY_YARN_ROLL)
				.add(ModItems.GREEN_YARN_ROLL)
				.add(ModItems.LIGHT_BLUE_YARN_ROLL)
				.add(ModItems.LIGHT_GRAY_YARN_ROLL)
				.add(ModItems.LIME_YARN_ROLL)
				.add(ModItems.MAGENTA_YARN_ROLL)
				.add(ModItems.ORANGE_YARN_ROLL)
				.add(ModItems.PINK_YARN_ROLL)
				.add(ModItems.PURPLE_YARN_ROLL)
				.add(ModItems.RED_YARN_ROLL)
				.add(ModItems.WHITE_YARN_ROLL)
				.add(ModItems.YELLOW_YARN_ROLL);
		//endregion
		//region # Yarnballs #
		getOrCreateTagBuilder(ItemTags.ALL_YARNBALLS)
				.add(ModItems.BLACK_YARNBALL)
				.add(ModItems.BLUE_YARNBALL)
				.add(ModItems.BROWN_YARNBALL)
				.add(ModItems.CYAN_YARNBALL)
				.add(ModItems.GRAY_YARNBALL)
				.add(ModItems.GREEN_YARNBALL)
				.add(ModItems.LIGHT_BLUE_YARNBALL)
				.add(ModItems.LIGHT_GRAY_YARNBALL)
				.add(ModItems.LIME_YARNBALL)
				.add(ModItems.MAGENTA_YARNBALL)
				.add(ModItems.ORANGE_YARNBALL)
				.add(ModItems.PINK_YARNBALL)
				.add(ModItems.PURPLE_YARNBALL)
				.add(ModItems.RED_YARNBALL)
				.add(ModItems.WHITE_YARNBALL)
				.add(ModItems.YELLOW_YARNBALL);
		//endregion
		//endregion
		
		//region ## Equipment ##
		//region # By Classification #
		// Axes
		getOrCreateTagBuilder(ItemTags.ALL_AXES)
				.add(ModItems.BRASS_AXE)
				.add(ModItems.COPPER_AXE)
				.add(ModItems.EIDURIL_AXE)
				.add(Items.GOLDEN_AXE) // TODO: Replace with custom version.
				.add(Items.IRON_AXE) // TODO: Replace with custom version.
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_AXE)
		;
		// Daggers
		getOrCreateTagBuilder(ItemTags.ALL_DAGGERS)
				// Tier 1 - Wood
				.add(ModItems.WOODEN_DAGGER)
				// Tier 2 - Shard
				.add(ModItems.FLINT_DAGGER)
				.add(ModItems.GLASS_DAGGER)
				.add(ModItems.OBSIDIAN_DAGGER)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_DAGGER)
				.add(ModItems.COPPER_DAGGER)
				.add(ModItems.EIDURIL_DAGGER)
				.add(ModItems.GOLDEN_DAGGER)
				.add(ModItems.IRON_DAGGER)
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_DAGGER)
		;
		// Hatchets
		getOrCreateTagBuilder(ItemTags.ALL_HATCHETS)
				// Tier 2 - Shard
				.add(ModItems.FLINT_HATCHET)
				.add(ModItems.GLASS_HATCHET)
				.add(ModItems.OBSIDIAN_HATCHET)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_HATCHET)
				.add(ModItems.COPPER_HATCHET)
				.add(ModItems.EIDURIL_HATCHET)
				.add(ModItems.GOLDEN_HATCHET)
				.add(ModItems.IRON_HATCHET)
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_HATCHET)
		;
		// Hoes
		getOrCreateTagBuilder(ItemTags.ALL_HOES)
				// Tier 2 - Shard
				.add(ModItems.FLINT_HOE)
				.add(ModItems.GLASS_HOE)
				.add(ModItems.OBSIDIAN_HOE)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_HOE)
				.add(ModItems.COPPER_HOE)
				.add(ModItems.EIDURIL_HOE)
				.add(Items.GOLDEN_HOE) // TODO: Replace with custom version.
				.add(Items.IRON_HOE) // TODO: Replace with custom version.
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_HOE)
		;
		// Mallets
		getOrCreateTagBuilder(ItemTags.ALL_MALLETS)
				// Tier 1 - Wood
				.add(ModItems.WOODEN_MALLET)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_MALLET)
				.add(ModItems.COPPER_MALLET)
				.add(ModItems.EIDURIL_MALLET)
				.add(ModItems.GOLDEN_MALLET)
				.add(ModItems.IRON_MALLET)
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_MALLET)
		;
		// Pickaxes
		getOrCreateTagBuilder(ItemTags.ALL_PICKAXES)
				.add(ModItems.BRASS_PICKAXE)
				.add(ModItems.COPPER_PICKAXE)
				.add(ModItems.EIDURIL_PICKAXE)
				.add(Items.GOLDEN_PICKAXE) // TODO: Replace with custom version.
				.add(Items.IRON_PICKAXE) // TODO: Replace with custom version.
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_PICKAXE)
		;
		// Shovels
		getOrCreateTagBuilder(ItemTags.ALL_SHOVELS)
				// Tier 1 - Wood
				.add(ModItems.WOODEN_SHOVEL)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_SHOVEL)
				.add(ModItems.COPPER_SHOVEL)
				.add(ModItems.EIDURIL_SHOVEL)
				.add(Items.GOLDEN_SHOVEL) // TODO: Replace with custom version.
				.add(Items.IRON_SHOVEL) // TODO: Replace with custom version.
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_SHOVEL)
		;
		// Spears
		getOrCreateTagBuilder(ItemTags.ALL_SPEARS)
				// Tier 1 - Wood
				.add(ModItems.WOODEN_SPEAR)
				// Tier 2 - Shard
				.add(ModItems.FLINT_SPEAR)
				.add(ModItems.GLASS_SPEAR)
				.add(ModItems.OBSIDIAN_SPEAR)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_SPEAR)
				.add(ModItems.COPPER_SPEAR)
				.add(ModItems.EIDURIL_SPEAR)
				.add(ModItems.GOLDEN_SPEAR)
				.add(ModItems.IRON_SPEAR)
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_SPEAR)
		;
		// Swords
		getOrCreateTagBuilder(ItemTags.ALL_SWORDS)
				// Tier 1 - Wood
				.add(ModItems.WOODEN_SWORD)
				// Tier 3 - Metalloid
				.add(ModItems.BRASS_SWORD)
				.add(ModItems.COPPER_SWORD)
				.add(ModItems.EIDURIL_SWORD)
				.add(Items.GOLDEN_SWORD) // TODO: Replace with custom version.
				.add(Items.IRON_SWORD) // TODO: Replace with custom version.
				// Joke & Unserious
				.add(JAUItems.NUTRILLARN_SWORD)
		;
		//endregion
		//region # By Function #
		// Enable armor items to be trimmable.
		// Note: Custom armor textures might not be designed in a way that is visually compatible with vanilla trim textures.
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.TRIMMABLE_ARMOR)
				.add(ModItems.BRASS_BOOT_PAIR)
				.add(ModItems.BRASS_CHESTPLATE)
				.add(ModItems.BRASS_HELMET)
				.add(ModItems.BRASS_LEGGING_PAIR)
				.add(ModItems.COPPER_BOOT_PAIR)
				.add(ModItems.COPPER_CHESTPLATE)
				.add(ModItems.COPPER_HELMET)
				.add(ModItems.COPPER_LEGGING_PAIR)
				.add(ModItems.EIDURIL_BOOT_PAIR)
				.add(ModItems.EIDURIL_CHESTPLATE)
				.add(ModItems.EIDURIL_HELMET)
				.add(ModItems.EIDURIL_LEGGING_PAIR);
		// Note: Intentionally not allowing Nutrillarn to be trimmable.
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.CHEST_ARMOR)
				.add(ModItems.BRASS_CHESTPLATE)
				.add(ModItems.COPPER_CHESTPLATE)
				.add(ModItems.EIDURIL_CHESTPLATE)
				.add(JAUItems.NUTRILLARN_CHESTPLATE);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.FOOT_ARMOR)
				.add(ModItems.BRASS_BOOT_PAIR)
				.add(ModItems.COPPER_BOOT_PAIR)
				.add(ModItems.EIDURIL_BOOT_PAIR)
				.add(JAUItems.NUTRILLARN_BOOT_PAIR);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.HEAD_ARMOR)
				.add(ModItems.BRASS_HELMET)
				.add(ModItems.COPPER_HELMET)
				.add(ModItems.EIDURIL_HELMET)
				.add(JAUItems.NUTRILLARN_HELMET);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.LEG_ARMOR)
				.add(ModItems.BRASS_LEGGING_PAIR)
				.add(ModItems.COPPER_LEGGING_PAIR)
				.add(ModItems.EIDURIL_LEGGING_PAIR)
				.add(JAUItems.NUTRILLARN_LEGGING_PAIR);
		
		
		getOrCreateTagBuilder(ItemTags.ALL_CHOPPING_TOOLS)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_HATCHETS)
		;
		getOrCreateTagBuilder(ItemTags.ALL_POUNDING_TOOLS)
				.addTag(ItemTags.ALL_MALLETS)
		;
		getOrCreateTagBuilder(ItemTags.ALL_SLICING_TOOLS)
				.addTag(ItemTags.ALL_DAGGERS)
				.addTag(ItemTags.ALL_SWORDS)
		;
		//endregion
		
		//region Vanilla Tool Tags
		//NOTE: Haven't yet fully investigated what these are used for.
		// - Perhaps for breaking blocks more quickly?
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.AXES)
				.addTag(ItemTags.ALL_CHOPPING_TOOLS);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.HOES)
				.addTag(ItemTags.ALL_HOES);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PICKAXES)
				.addTag(ItemTags.ALL_PICKAXES);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SHOVELS)
				.addTag(ItemTags.ALL_SHOVELS);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SWORDS)
				.addTag(ItemTags.ALL_SWORDS);
		//endregion
		//endregion
		
		//region ## Miscellaneous ##
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PIGLIN_LOVED).setReplace(true)
				.add( // Miscellaneous
						Items.GOLD_INGOT,
						ModItems.GOLD_GRAM,
						Items.RAW_GOLD,
						Items.GOLD_NUGGET,
//						Items.GOLD_BLOCK,
//						Items.RAW_GOLD_BLOCK,
//						Items.LIGHT_WEIGHTED_PRESSURE_PLATE,
						Items.BELL,
						Items.CLOCK,
						Items.GOLDEN_CARROT,
						Items.GLISTERING_MELON_SLICE,
						Items.GOLDEN_APPLE,
						Items.ENCHANTED_GOLDEN_APPLE
				)
				.add( // Equipment
						// Armor
						Items.GOLDEN_BOOTS,
						Items.GOLDEN_CHESTPLATE,
						Items.GOLDEN_HELMET,
						Items.GOLDEN_HORSE_ARMOR,
						Items.GOLDEN_LEGGINGS,
						// Tools
						Items.GOLDEN_SWORD,
						Items.GOLDEN_PICKAXE,
						Items.GOLDEN_SHOVEL,
						Items.GOLDEN_AXE,
						Items.GOLDEN_HOE,
						ModItems.GOLDEN_DAGGER,
						ModItems.GOLDEN_HATCHET,
						ModItems.GOLDEN_MALLET,
						ModItems.GOLDEN_SPEAR
				);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PIGLIN_FOOD).setReplace(true)
				.add(Items.BEEF, Items.COOKED_BEEF)
				.add(Items.CHICKEN, Items.COOKED_CHICKEN)
				.add(Items.MUTTON, Items.COOKED_MUTTON)
				.add(Items.PORKCHOP, Items.COOKED_PORKCHOP)
				.add(Items.RABBIT, Items.COOKED_RABBIT);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.MEAT).setReplace(true)
				.add(
						Items.BEEF,
						Items.CHICKEN,
						Items.COOKED_BEEF,
						ModItems.COOKED_BUGMEAT_STEAK,
						Items.COOKED_CHICKEN,
						ModItems.COOKED_MEAT_MORSEL,
						Items.COOKED_MUTTON,
						Items.COOKED_PORKCHOP,
						Items.COOKED_RABBIT,
						Items.MUTTON,
						Items.PORKCHOP,
						Items.RABBIT,
						ModItems.RAW_BUGMEAT_STEAK,
						ModItems.RAW_MEAT_MORSEL,
						Items.ROTTEN_FLESH
				);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.ARMADILLO_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_GRAM)
				.add(Items.SPIDER_EYE);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.AXOLOTL_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.BEE_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.CAMEL_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.CAT_FOOD).setReplace(true)
				.add(ModItems.RAW_MEAT_MORSEL, ModItems.COOKED_MEAT_MORSEL)
				.add(Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.CHICKEN_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.COW_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_INGOT)
				.add(Items.WHEAT);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.FOX_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.FROG_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_GRAM)
				.add(Items.SLIME_BALL);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.GOAT_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_INGOT)
				.add(Items.WHEAT);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.HOGLIN_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.HORSE_FOOD).setReplace(true)
				.add(
						Items.APPLE, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE,
						Items.CARROT, Items.GOLDEN_CARROT,
						Items.SUGAR,
						Items.WHEAT
				);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.LLAMA_FOOD).setReplace(true)
				.add(Items.WHEAT);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.OCELOT_FOOD).setReplace(true)
				.add(ModItems.RAW_MEAT_MORSEL, ModItems.COOKED_MEAT_MORSEL)
				.add(Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PANDA_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PARROT_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_GRAM)
				.add(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.TORCHFLOWER_SEEDS, Items.PITCHER_POD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PARROT_POISONOUS_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.PIG_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_INGOT)
				.add(Items.APPLE, Items.BEETROOT, Items.CARROT, Items.POTATO, Items.POISONOUS_POTATO);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.RABBIT_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SHEEP_FOOD).setReplace(true)
				.add(JAUItems.NUTRILLARN_INGOT)
				.add(Items.WHEAT);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SNIFFER_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.STRIDER_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.TURTLE_FOOD);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.WOLF_FOOD);
		
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.VANISHING_ENCHANTABLE)
				.add(JAUItems.ORB_OF_ZOT);
		
		//TODO: Perhaps add a tag for any shafted tool.
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.BREAKS_DECORATED_POTS)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_DAGGERS)
				.addTag(ItemTags.ALL_HATCHETS)
				.addTag(ItemTags.ALL_HOES)
				.addTag(ItemTags.ALL_MALLETS)
				.addTag(ItemTags.ALL_PICKAXES)
				.addTag(ItemTags.ALL_SHOVELS)
				.addTag(ItemTags.ALL_SPEARS)
				.addTag(ItemTags.ALL_SWORDS)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.DURABILITY_ENCHANTABLE)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_DAGGERS)
				.addTag(ItemTags.ALL_HATCHETS)
				.addTag(ItemTags.ALL_HOES)
				.addTag(ItemTags.ALL_MALLETS)
				.addTag(ItemTags.ALL_PICKAXES)
				.addTag(ItemTags.ALL_SHOVELS)
				.addTag(ItemTags.ALL_SPEARS)
				.addTag(ItemTags.ALL_SWORDS)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.MINING_ENCHANTABLE)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_HATCHETS)
				.addTag(ItemTags.ALL_HOES)
				.addTag(ItemTags.ALL_MALLETS)
				.addTag(ItemTags.ALL_PICKAXES)
				.addTag(ItemTags.ALL_SHOVELS)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.MINING_LOOT_ENCHANTABLE)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_HATCHETS)
				.addTag(ItemTags.ALL_HOES)
				.addTag(ItemTags.ALL_MALLETS)
				.addTag(ItemTags.ALL_PICKAXES)
				.addTag(ItemTags.ALL_SHOVELS)
		;
		//TODO: Ensure some particular aspects of enchantability:
		// - Daggers to be enchantable with Looting and Diamond Edge (VMc "Sharpness").
		// - Dagger to NOT be enchantable with Sweeping Edge, Fire Aspect, or Gust Aspect (VMc "Knockback").
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.WEAPON_ENCHANTABLE); // Already contains 'SHARP_WEAPON_ENCHANTABLE' by default.
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SWORD_ENCHANTABLE)
				//TODO: Make looting use its own tag for enchantability.
				.addTag(ItemTags.ALL_DAGGERS) // Might be necessary for looting on daggers? Actually not if daggers are counted within the vanilla 'SWORDS' tag.
				.addTag(ItemTags.ALL_SWORDS)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.SHARP_WEAPON_ENCHANTABLE)
				.addTag(ItemTags.ALL_AXES)
				.addTag(ItemTags.ALL_DAGGERS)
				.addTag(ItemTags.ALL_HATCHETS)
				.addTag(ItemTags.ALL_SWORDS)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.FIRE_ASPECT_ENCHANTABLE)
				.addTag(ItemTags.ALL_SWORDS)
		;
		
		// NOTE: These method calls are merely for reference; they effectively do nothing (without any extra "add" method call).
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.ANVIL);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.ARROWS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.BEDS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.BOATS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.ItemTags.DOORS);
		
		getOrCreateTagBuilder(ItemTags.VILBIARN_GOLEM_REPAIR_MATERIALS)
				.add(ModItems.BRASS_INGOT)
				.add(Items.COPPER_INGOT)
				.add(Items.IRON_INGOT)
				.add(ModItems.REFINED_VILBIARN_LUMP)
		;
		//endregion
	}
}
