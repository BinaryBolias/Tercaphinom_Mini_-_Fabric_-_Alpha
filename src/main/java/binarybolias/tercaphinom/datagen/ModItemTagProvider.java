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
		// Yarnballs (which dye to black)
		getOrCreateTagBuilder(Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_BLACK)
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
		// Yarnballs (which dye to light gray)
		getOrCreateTagBuilder(Tags.Item.ALL_YARNBALLS_WHICH_DYE_TO_LIGHT_GRAY)
				.add(ModItems.BLUE_YARNBALL)
				.add(ModItems.BROWN_YARNBALL)
				.add(ModItems.CYAN_YARNBALL)
				.add(ModItems.GRAY_YARNBALL)
				.add(ModItems.GREEN_YARNBALL)
				.add(ModItems.LIGHT_BLUE_YARNBALL)
				.add(ModItems.LIME_YARNBALL)
				.add(ModItems.MAGENTA_YARNBALL)
				.add(ModItems.ORANGE_YARNBALL)
				.add(ModItems.PINK_YARNBALL)
				.add(ModItems.PURPLE_YARNBALL)
				.add(ModItems.RED_YARNBALL)
				.add(ModItems.YELLOW_YARNBALL);
		getOrCreateTagBuilder(Tags.Item.BASIC_FLAME_MATERIALS)
				.add(Items.CHARCOAL)
				.add(Items.COAL);
		getOrCreateTagBuilder(Tags.Item.SPIRIT_FLAME_MATERIALS)
				.add(Items.SOUL_SAND) // TODO: Replace with new pile item.
				.add(Items.SOUL_SOIL) // TODO: Replace with new pile item.
				.add(ModItems.SULPHUR_LUMP);
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
