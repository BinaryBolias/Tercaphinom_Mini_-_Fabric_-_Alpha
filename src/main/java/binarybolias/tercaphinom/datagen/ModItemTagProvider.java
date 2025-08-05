package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.references.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.*;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		log("Generating item tag data");
		
		//region ## Basic Materials ##
		// Arrowhead Materials
		getOrCreateTagBuilder(Tags.Item.ARROWHEAD_MATERIALS)
				.add(ModItems.BRASS_GRAM)
				.add(ModItems.COPPER_GRAM)
				.add(Items.FLINT)
				.add(ModItems.GLASS_SHARD)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM)
				.add(ModItems.OBSIDIAN_SHARD);
		// Cobblestones
		getOrCreateTagBuilder(Tags.Item.ALL_COBBLESTONES)
				.add(ModItems.STIEFANE_COBBLESTONE);
		// Bricks
		getOrCreateTagBuilder(Tags.Item.ALL_BRICKS)
				.add(ModItems.STIEFANE_BRICK);
		// Glassy Sand Piles
		getOrCreateTagBuilder(Tags.Item.ALL_GLASSY_SAND_PILES)
				.add(ModItems.FELDSAND_PILE)
				.add(ModItems.FERROSAND_PILE)
				.add(ModItems.SKORSAND_PILE);
		// Metal Grams
		getOrCreateTagBuilder(Tags.Item.ALL_METAL_GRAMS)
				.add(ModItems.BRASS_GRAM)
				.add(ModItems.COPPER_GRAM)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM);
		// Mushrooms
		getOrCreateTagBuilder(Tags.Item.ALL_MUSHROOMS)
				.add(Items.BROWN_MUSHROOM)
				.add(Items.RED_MUSHROOM)
				.add(ModItems.STARCHCAP_MUSHROOM)
				.add(Items.CRIMSON_FUNGUS)
				.add(Items.WARPED_FUNGUS);
		// Planks
		getOrCreateTagBuilder(Tags.Item.ALL_PLANKS)
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
		// Yarnballs
		getOrCreateTagBuilder(Tags.Item.ALL_YARNBALLS)
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
		// Flame materials
		getOrCreateTagBuilder(Tags.Item.BASIC_FLAME_MATERIALS)
				.add(Items.CHARCOAL)
				.add(Items.COAL);
		getOrCreateTagBuilder(Tags.Item.SPIRIT_FLAME_MATERIALS)
				.add(Items.SOUL_SAND) // TODO: Replace with new pile item.
				.add(Items.SOUL_SOIL) // TODO: Replace with new pile item.
				.add(ModItems.SULPHUR_LUMP);
		// Torch binders
		getOrCreateTagBuilder(Tags.Item.STRONG_TORCH_BINDERS)
				.addTag(Tags.Item.ALL_YARNBALLS);
		getOrCreateTagBuilder(Tags.Item.WEAK_TORCH_BINDERS)
				.add(ModItems.DRY_GRASS_TUFT);
		// Broom Materials
		getOrCreateTagBuilder(Tags.Item.BROOM_MATERIALS) // TODO: Add broom item.
				.add(Items.WHEAT)
				.add(ModItems.DRY_GRASS_TUFT);
		// Cookable Eggs
		getOrCreateTagBuilder(Tags.Item.COOKABLE_EGGS)
				.add(Items.EGG)
				.add(Items.SNIFFER_EGG)
				.add(Items.TURTLE_EGG);
		// Raw Cake Berries
		getOrCreateTagBuilder(Tags.Item.RAW_CAKE_BERRIES)
				.add(Items.GLOW_BERRIES)
				.add(Items.SWEET_BERRIES)
				.add(ModItems.CHERRY_BUNCH);
		getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS);
		//endregion
		
		//region # Decomposable Materials #
		getOrCreateTagBuilder(Tags.Item.DECOMPOSABLE_MATERIALS)
				.add(ModItems.ASH_PILE)
				.add(Items.BONE_MEAL)
				.add(Items.PINK_PETALS)
				.add(ModItems.LEAF_PILE);
		//endregion
		
		//region # Rottable Meats #
		getOrCreateTagBuilder(Tags.Item.LARGE_ROTTABLE_MEATS)
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
		getOrCreateTagBuilder(Tags.Item.SMALL_ROTTABLE_MEATS)
				.add(Items.COD)
				.add(Items.COOKED_COD)
				.add(ModItems.RAW_MEAT_MORSEL)
				.add(ModItems.COOKED_MEAT_MORSEL)
				.add(Items.PUFFERFISH)
				.add(Items.SALMON)
				.add(Items.COOKED_SALMON)
				.add(Items.TROPICAL_FISH);
		//endregion
		
		//region # Spawn Eggs #
		getOrCreateTagBuilder(Tags.Item.SPAWN_EGGS)
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
		
		//region ## Containers ##
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_BRIMWATER)
				.add(ModItems.BOTTLE_OF_BRIMWATER)
				.add(ModItems.BOWL_OF_BRIMWATER);
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_FREEZEWATER)
				.add(ModItems.BOTTLE_OF_FREEZEWATER)
				.add(ModItems.BOWL_OF_FREEZEWATER);
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_HONEY)
				.add(Items.HONEY_BOTTLE)
				.add(ModItems.BOWL_OF_HONEY);
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_MILK)
				.add(ModItems.BOTTLE_OF_MILK)
				.add(ModItems.BOWL_OF_MILK);
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_STEAMING_WATER)
				.add(ModItems.BOTTLE_OF_STEAMING_WATER)
				.add(ModItems.BOWL_OF_STEAMING_WATER);
		getOrCreateTagBuilder(Tags.Item.SMALL_CONTAINERS_OF_WATER)
				.add(Items.POTION)
				.add(ModItems.BOWL_OF_WATER);
		//endregion
		
		//region ## Equipment ##
		// Enable armor items to be trimmable.
		// Note: Custom armor textures might not be designed in a way that is visually compatible with vanilla trim textures.
		getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
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
		
		getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
				.add(ModItems.BRASS_CHESTPLATE)
				.add(ModItems.COPPER_CHESTPLATE)
				.add(ModItems.EIDURIL_CHESTPLATE)
				.add(ModItems.NUTRILLARN_CHESTPLATE);
		
		getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
				.add(ModItems.BRASS_BOOT_PAIR)
				.add(ModItems.COPPER_BOOT_PAIR)
				.add(ModItems.EIDURIL_BOOT_PAIR)
				.add(ModItems.NUTRILLARN_BOOT_PAIR);
		
		getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
				.add(ModItems.BRASS_HELMET)
				.add(ModItems.COPPER_HELMET)
				.add(ModItems.EIDURIL_HELMET)
				.add(ModItems.NUTRILLARN_HELMET);
		
		getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
				.add(ModItems.BRASS_LEGGING_PAIR)
				.add(ModItems.COPPER_LEGGING_PAIR)
				.add(ModItems.EIDURIL_LEGGING_PAIR)
				.add(ModItems.NUTRILLARN_LEGGING_PAIR);
		
		
		// Enable tools to allow for harvesting logs and wooden blocks without devolving them into sticks.
		getOrCreateTagBuilder(Tags.Item.ALL_CHOPPING_TOOLS)
				// [tier 2] Shard Tools
				.add(ModItems.FLINT_HATCHET)
				.add(ModItems.GLASS_HATCHET)
				.add(ModItems.OBSIDIAN_HATCHET)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_AXE)
				.add(ModItems.BRASS_HATCHET)
				.add(ModItems.COPPER_AXE)
				.add(ModItems.COPPER_HATCHET)
				.add(ModItems.EIDURIL_AXE)
				.add(ModItems.EIDURIL_HATCHET)
				.add(Items.GOLDEN_AXE)
				.add(ModItems.GOLDEN_HATCHET)
				.add(Items.IRON_AXE)
				.add(ModItems.IRON_HATCHET)
				.add(Items.NETHERITE_AXE)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_AXE)
				.add(ModItems.NUTRILLARN_HATCHET);
		// Enable tools to allow for harvesting wooden blocks without devolving them into sticks.
		getOrCreateTagBuilder(Tags.Item.ALL_POUNDING_TOOLS)
				// [tier 1] Wooden Tools
				.add(ModItems.WOODEN_MALLET)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_MALLET)
				.add(ModItems.COPPER_MALLET)
				.add(ModItems.EIDURIL_MALLET)
				.add(ModItems.GOLDEN_MALLET)
				.add(ModItems.IRON_MALLET)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_MALLET);
		//endregion
		
		//region Vanilla Tool Tags
		// Enable hatchets and (modded) axes to chop wood blocks... more quickly?
		getOrCreateTagBuilder(ItemTags.AXES)
				// [tier 2] Shard Tools
				.add(ModItems.FLINT_HATCHET)
				.add(ModItems.GLASS_HATCHET)
				.add(ModItems.OBSIDIAN_HATCHET)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_AXE)
				.add(ModItems.BRASS_HATCHET)
				.add(ModItems.COPPER_AXE)
				.add(ModItems.COPPER_HATCHET)
				.add(ModItems.EIDURIL_AXE)
				.add(ModItems.EIDURIL_HATCHET)
				.add(ModItems.GOLDEN_HATCHET)
				.add(ModItems.IRON_HATCHET)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_AXE)
				.add(ModItems.NUTRILLARN_HATCHET);
		
		getOrCreateTagBuilder(ItemTags.HOES)
				// [tier 2] Shard Tools
				.add(ModItems.FLINT_HOE)
				.add(ModItems.GLASS_HOE)
				.add(ModItems.OBSIDIAN_HOE)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_HOE)
				.add(ModItems.COPPER_HOE)
				.add(ModItems.EIDURIL_HOE)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_HOE);
		
		getOrCreateTagBuilder(ItemTags.PICKAXES)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_PICKAXE)
				.add(ModItems.COPPER_PICKAXE)
				.add(ModItems.EIDURIL_PICKAXE)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_PICKAXE);
		
		getOrCreateTagBuilder(ItemTags.SHOVELS)
				// [tier 1] Wooden Tools
				.add(ModItems.WOODEN_SHOVEL)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_SHOVEL)
				.add(ModItems.COPPER_SHOVEL)
				.add(ModItems.EIDURIL_SHOVEL)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_SHOVEL);
		
		getOrCreateTagBuilder(ItemTags.SWORDS)
				// [tier 1] Wooden Tools
				.add(ModItems.WOODEN_DAGGER)
				.add(ModItems.WOODEN_SWORD)
				// [tier 2] Shard Tools
				.add(ModItems.FLINT_DAGGER)
				.add(ModItems.GLASS_DAGGER)
				.add(ModItems.OBSIDIAN_DAGGER)
				// [tier 3] Metal Tools
				.add(ModItems.BRASS_DAGGER)
				.add(ModItems.BRASS_SWORD)
				.add(ModItems.COPPER_DAGGER)
				.add(ModItems.COPPER_SWORD)
				.add(ModItems.EIDURIL_DAGGER)
				.add(ModItems.EIDURIL_SWORD)
				.add(ModItems.GOLDEN_DAGGER)
				.add(ModItems.IRON_DAGGER)
				// [tier J] Nutrillarn Tools
				.add(ModItems.NUTRILLARN_DAGGER)
				.add(ModItems.NUTRILLARN_SWORD);
		//endregion
		
		// NOTE: These method calls are merely for reference; they effectively do nothing (without any extra "add" method call).
		getOrCreateTagBuilder(ItemTags.ARROWS);
		getOrCreateTagBuilder(ItemTags.BEDS);
		getOrCreateTagBuilder(ItemTags.BOATS);
		getOrCreateTagBuilder(ItemTags.DOORS);
		
		// Used for furnace and brewing stand.
		getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK.asItem());
		// Used for stone axe, hoe, pickaxe, shovel, and sword.
		getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK.asItem());
	}
}
