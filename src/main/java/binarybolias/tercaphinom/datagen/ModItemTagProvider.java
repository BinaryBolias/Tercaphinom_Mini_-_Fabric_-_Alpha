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
		
		// Arrowhead Materials
		getOrCreateTagBuilder(ModTags.Items.ARROWHEAD_MATERIALS)
				.add(ModItems.COPPER_GRAM)
				.add(Items.FLINT)
				.add(ModItems.GLASS_SHARD)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM)
				.add(ModItems.OBSIDIAN_SHARD);
		// Cobblestones
		getOrCreateTagBuilder(ModTags.Items.ALL_COBBLESTONES)
				.add(ModItems.STIEFANE_COBBLESTONE);
		// Bricks
		getOrCreateTagBuilder(ModTags.Items.ALL_BRICKS)
				.add(ModItems.STIEFANE_BRICK);
		// Glassy Sand Piles
		getOrCreateTagBuilder(ModTags.Items.ALL_GLASSY_SAND_PILES)
				.add(ModItems.FELDSAND_PILE)
				.add(ModItems.FERROSAND_PILE)
				.add(ModItems.SKORSAND_PILE);
		// Metal Grams
		getOrCreateTagBuilder(ModTags.Items.ALL_METAL_GRAMS)
				.add(ModItems.COPPER_GRAM)
				.add(ModItems.GOLD_GRAM)
				.add(ModItems.IRON_GRAM);
		// Mushrooms
		getOrCreateTagBuilder(ModTags.Items.ALL_MUSHROOMS)
				.add(Items.BROWN_MUSHROOM)
				.add(Items.RED_MUSHROOM)
				.add(Items.CRIMSON_FUNGUS)
				.add(Items.WARPED_FUNGUS);
		// Planks
		getOrCreateTagBuilder(ModTags.Items.ALL_PLANKS)
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
		getOrCreateTagBuilder(ModTags.Items.ALL_YARNBALLS)
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
		// Yarnballs except white
		getOrCreateTagBuilder(ModTags.Items.ALL_YARNBALLS_EXCEPT_WHITE)
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
				.add(ModItems.YELLOW_YARNBALL);
		getOrCreateTagBuilder(ModTags.Items.BASIC_FLAME_MATERIALS)
				.add(Items.CHARCOAL)
				.add(Items.COAL);
		getOrCreateTagBuilder(ModTags.Items.SPIRIT_FLAME_MATERIALS)
				.add(Items.SOUL_SAND) // TODO: Replace with new pile item.
				.add(Items.SOUL_SOIL) // TODO: Replace with new pile item.
				.add(ModItems.SULPHUR_LUMP);
		// Enable hatchets to properly chop wood blocks.
		getOrCreateTagBuilder(ItemTags.AXES)
				.add(ModItems.FLINT_HATCHET)
				.add(ModItems.GLASS_HATCHET)
				.add(ModItems.OBSIDIAN_HATCHET);
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
