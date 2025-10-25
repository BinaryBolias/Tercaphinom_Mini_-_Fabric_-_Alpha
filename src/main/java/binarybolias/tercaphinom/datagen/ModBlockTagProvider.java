package binarybolias.tercaphinom.datagen;

import binarybolias.tercaphinom.references.JAUBlocks;
import binarybolias.tercaphinom.references.ModBlocks;
import binarybolias.tercaphinom.registry.tag.BlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static binarybolias.tercaphinom.references.Reference.logMainEvent;


/**
 * @see net.minecraft.data.server.tag.vanilla.VanillaBlockTagProvider
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		logMainEvent("Generating block tag data");
		
		/*
		* Note on 'getOrCreateTagBuilder' method calls:
		*  - Some may be included merely for reference.
		*  - It is necessary to call this method for a tag if the tag is used elsewhere in this script.
		*
		* NOTE: For an overhaul of Minecraft which uses only custom aspects (dimensions, block, items, entities, etc.),
		*  vanilla tags are inappropriate; only custom tags are to be used instead.
		 */
		
		getOrCreateTagBuilder(BlockTags.NIL); // Intentionally empty.
		
		getOrCreateTagBuilder(BlockTags.ALL_ETERNALITH_BLOCKS)
				.add(ModBlocks.CHISELED_ETERNALITH_BLOCK, ModBlocks.ETERNALITH_BLOCK);
		
		// Eternalith block properties.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.DRAGON_IMMUNE).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.FEATURES_CANNOT_REPLACE).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.GEODE_INVALID_BLOCKS).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INFINIBURN_END).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.OCCLUDES_VIBRATION_SIGNALS).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.WITHER_IMMUNE).addTag(BlockTags.ALL_ETERNALITH_BLOCKS);
		
		// Tool tier elitism removal for vanilla tool materials.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_WOODEN_TOOL).setReplace(true);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_STONE_TOOL).setReplace(true);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_GOLD_TOOL).setReplace(true);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_IRON_TOOL).setReplace(true);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_DIAMOND_TOOL).setReplace(true);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_NETHERITE_TOOL).setReplace(true);
		
		// BlockTags.PICKAXE_MINEABLE: (I think) The blocks within this tag only drop loot if mined with a pickaxe.
		// - Intended to be used for blocks with the "requiresTool" setting.
		//  - This setting reduces mining speed and disallows loot drops by default.
		// - Allows for ordinary mining speed, and for the block to drop loot, when mined with a PickaxeItem.
		//  - Does not seem to have relation to the "pickaxes" item tag.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE)
				//# Glass (clear) #
				.add(Blocks.GLASS)
				//# Glass (tinted) #
				.add(Blocks.TINTED_GLASS)
				//# Glass Block (stained) #
				.add(Blocks.BLACK_STAINED_GLASS)
				.add(Blocks.BLUE_STAINED_GLASS)
				.add(Blocks.BROWN_STAINED_GLASS)
				.add(Blocks.CYAN_STAINED_GLASS)
				.add(Blocks.GRAY_STAINED_GLASS)
				.add(Blocks.GREEN_STAINED_GLASS)
				.add(Blocks.LIGHT_BLUE_STAINED_GLASS)
				.add(Blocks.LIGHT_GRAY_STAINED_GLASS)
				.add(Blocks.LIME_STAINED_GLASS)
				.add(Blocks.MAGENTA_STAINED_GLASS)
				.add(Blocks.ORANGE_STAINED_GLASS)
				.add(Blocks.PINK_STAINED_GLASS)
				.add(Blocks.PURPLE_STAINED_GLASS)
				.add(Blocks.RED_STAINED_GLASS)
				.add(Blocks.WHITE_STAINED_GLASS)
				.add(Blocks.YELLOW_STAINED_GLASS)
				//# Glass Pane (clear) #
				.add(Blocks.GLASS_PANE)
				//# Glass Pane (stained) #
				.add(Blocks.BLACK_STAINED_GLASS_PANE)
				.add(Blocks.BLUE_STAINED_GLASS_PANE)
				.add(Blocks.BROWN_STAINED_GLASS_PANE)
				.add(Blocks.CYAN_STAINED_GLASS_PANE)
				.add(Blocks.GRAY_STAINED_GLASS_PANE)
				.add(Blocks.GREEN_STAINED_GLASS_PANE)
				.add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)
				.add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)
				.add(Blocks.LIME_STAINED_GLASS_PANE)
				.add(Blocks.MAGENTA_STAINED_GLASS_PANE)
				.add(Blocks.ORANGE_STAINED_GLASS_PANE)
				.add(Blocks.PINK_STAINED_GLASS_PANE)
				.add(Blocks.PURPLE_STAINED_GLASS_PANE)
				.add(Blocks.RED_STAINED_GLASS_PANE)
				.add(Blocks.WHITE_STAINED_GLASS_PANE)
				.add(Blocks.YELLOW_STAINED_GLASS_PANE)
				//# Stone (stiefane) #
				.add(ModBlocks.STIEFANE_BRICK_BLOCK)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK)
				.add(ModBlocks.NATURAL_STIEFANE_BLOCK)
				.add(ModBlocks.POLISHED_STIEFANE_BLOCK)
				.add(ModBlocks.STIEFANE_LAPIS_ORE)
				.add(ModBlocks.STIEFANE_BUTTON)
				.add(ModBlocks.STIEFANE_PRESSURE_PLATE)
				.add(ModBlocks.STIEFANE_BRICK_WALL_POST)
				.add(ModBlocks.STIEFANE_BRICK_SLAB)
				.add(ModBlocks.STIEFANE_BRICK_STAIR)
				//# Metal #
				.add(ModBlocks.RAW_BRASS_BLOCK)
				.add(ModBlocks.RAW_EIDURIL_BLOCK)
				.add(ModBlocks.REFINED_BRASS_BLOCK)
				.add(ModBlocks.REFINED_EIDURIL_BLOCK)
				//## Joke & Unserious ##
				//# (J&U) Metal #
				.add(JAUBlocks.RAW_NUTRILLARN_BLOCK)
				.add(JAUBlocks.REFINED_NUTRILLARN_BLOCK)
				//# (J&U) Miscellaneous #
				.add(JAUBlocks.ULTRASMOOTH_STONE);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.SHOVEL_MINEABLE)
				//# Stone (cobbled) #
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK) // TODO: Perhaps make a separate block tag for cobbled stone blocks.
				.add(Blocks.MOSSY_COBBLESTONE, Blocks.INFESTED_COBBLESTONE)
				.add(Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_WALL)
				.add(Blocks.COBBLESTONE, Blocks.COBBLESTONE_SLAB, Blocks.COBBLESTONE_STAIRS, Blocks.COBBLESTONE_WALL)
				.add(Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_WALL)
				//# Stone (natural) #
				.add(Blocks.NETHERRACK, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE)
				.add(Blocks.END_STONE)
				//# Sand & Soil #
				.add(ModBlocks.ASH_BLOCK)
				.add(ModBlocks.SKORSAND_BLOCK)
				
				//## Joke & Unserious ##
				//# (J&U) Cheese #
				.add(JAUBlocks.BLUE_CHEESE_BLOCK)
				.add(JAUBlocks.SILKY_SMOOTH_CHEESE_BLOCK)
				.add(JAUBlocks.YELLOW_CHEESE_BLOCK)
				//# (J&U) Miscellaneous #
				.add(JAUBlocks.CHERRY_JELLYBLOCK);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.AXE_MINEABLE)
				.add(ModBlocks.VERDAK_LOG)
				.add(ModBlocks.VERDAK_TRUNK)
				.add(ModBlocks.VERDAK_PLANK_BLOCK)
				.add(ModBlocks.VERDAK_BUTTON)
				.add(ModBlocks.VERDAK_PRESSURE_PLATE)
				.add(ModBlocks.VERDAK_DOOR)
				.add(ModBlocks.VERDAK_HATCH)
				.add(ModBlocks.VERDAK_GATE)
				.add(ModBlocks.VERDAK_FENCE_POST)
				.add(ModBlocks.VERDAK_PLANK_SLAB)
				.add(ModBlocks.VERDAK_PLANK_STAIR);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.HOE_MINEABLE);
		
		// In vanilla, this is copied as an item tag and only used for defining which logs can be cooked into charcoal.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.LOGS_THAT_BURN);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.WALLS)
				.add(ModBlocks.STIEFANE_BRICK_WALL_POST);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.FENCES)
				.add(ModBlocks.VERDAK_FENCE_POST);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.FENCE_GATES)
				.add(ModBlocks.VERDAK_GATE);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.STAIRS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.DOORS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.TRAPDOORS);
		
		// These are copied as item tags, but don't seem to actually be used for anything.
		// If these WERE used for something, it would probably just be for smelting ore blocks into resources,
		//  which in Tercaphinom is not only ILLEGAL, but also impossible (given that the ore blocks are unobtainable in survival)
		//  and ALSO just plain inefficient, since mining the ore blocks gives a minimum of more than one resource per block anyway.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.COAL_ORES);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.COPPER_ORES);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.DIAMOND_ORES);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.EMERALD_ORES);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.GOLD_ORES);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.LAPIS_ORES);
		
		// Used for transparent blocks which are intended to be solid.
		// Only includes glass blocks (clear, stained, and tinted) in vanilla (as of MC 1.20.6).
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.IMPERMEABLE);
		
		getOrCreateTagBuilder(BlockTags.BLACKLISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON)
				.add(Blocks.BARRIER)
		;
		getOrCreateTagBuilder(BlockTags.WHITELISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON)
				.add(JAUBlocks.CHERRY_JELLYBLOCK)
				.add(Blocks.HONEY_BLOCK, Blocks.SOUL_SAND, Blocks.MUD)
		;
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).setReplace(true)
				.addTag(BlockTags.WHITELISTED_FOR_LAYERED_MOUND_PLACEMENT_UPON);
		
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.ENCHANTMENT_POWER_PROVIDER).setReplace(true)
				.add(Blocks.BOOKSHELF) // "Oak Packed Bookshelf"
		;
		
		
		getOrCreateTagBuilder(BlockTags.ALL_COBBLED_STONE_BLOCKS)
				.add(Blocks.COBBLED_DEEPSLATE)
				.add(ModBlocks.COBBLED_STIEFANE_BLOCK)
				.add(Blocks.COBBLESTONE)
				.add(Blocks.INFESTED_COBBLESTONE)
				.add(Blocks.MOSSY_COBBLESTONE)
		;
		getOrCreateTagBuilder(BlockTags.ALL_NATURAL_STONE_BLOCKS)
				.add(Blocks.TERRACOTTA,
						Blocks.BLACK_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.CYAN_TERRACOTTA,
						Blocks.GRAY_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA,
						Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.PINK_TERRACOTTA,
						Blocks.PURPLE_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA)
				.add(Blocks.ANDESITE)
				.add(Blocks.BASALT)
				.add(Blocks.BLACKSTONE)
				.add(Blocks.CALCITE)
				.add(Blocks.CRYING_OBSIDIAN)
				.add(Blocks.DEEPSLATE)
				.add(Blocks.DIORITE)
				.add(Blocks.DRIPSTONE_BLOCK)
				.add(Blocks.END_STONE)
				.add(ModBlocks.NATURAL_STIEFANE_BLOCK)
				.add(Blocks.NETHERRACK)
				.add(ModBlocks.ASHY_NETHERRACK_BLOCK)
				.add(Blocks.OBSIDIAN)
				.add(Blocks.PRISMARINE)
				.add(Blocks.RED_SANDSTONE)
				.add(Blocks.SANDSTONE)
				.add(Blocks.STONE)
				.add(Blocks.TUFF)
		;
		getOrCreateTagBuilder(BlockTags.ALL_REFINED_STONE_BLOCKS)
				.add(Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA,
						Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA,
						Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA,
						Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA,
						Blocks.LIME_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA,
						Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA,
						Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA,
						Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA)
				.add(Blocks.BLACK_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.CYAN_CONCRETE,
						Blocks.GRAY_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE,
						Blocks.LIME_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.PINK_CONCRETE,
						Blocks.PURPLE_CONCRETE, Blocks.RED_CONCRETE, Blocks.WHITE_CONCRETE, Blocks.YELLOW_CONCRETE)
				.add(Blocks.CHISELED_DEEPSLATE)
				.add(Blocks.CHISELED_NETHER_BRICKS)
				.add(Blocks.CHISELED_POLISHED_BLACKSTONE)
				.add(Blocks.CHISELED_QUARTZ_BLOCK)
				.add(Blocks.CHISELED_RED_SANDSTONE)
				.add(Blocks.CHISELED_SANDSTONE)
				.add(Blocks.CHISELED_STONE_BRICKS)
				.add(Blocks.CHISELED_TUFF)
				.add(Blocks.CHISELED_TUFF_BRICKS)
				.add(Blocks.BRICKS)
				.add(Blocks.CRACKED_DEEPSLATE_BRICKS)
				.add(Blocks.CRACKED_NETHER_BRICKS)
				.add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
				.add(Blocks.CRACKED_STONE_BRICKS)
				.add(Blocks.DARK_PRISMARINE)
				.add(Blocks.DEEPSLATE_BRICKS)
				.add(Blocks.END_STONE_BRICKS)
				.add(Blocks.MOSSY_STONE_BRICKS)
				.add(Blocks.MUD_BRICKS)
				.add(Blocks.NETHER_BRICKS)
				.add(Blocks.POLISHED_BLACKSTONE_BRICKS)
				.add(Blocks.PRISMARINE_BRICKS)
				.add(Blocks.QUARTZ_BRICKS)
				.add(Blocks.RED_NETHER_BRICKS)
				.add(Blocks.STONE_BRICKS)
				.add(Blocks.TUFF_BRICKS)
				.add(Blocks.RED_SANDSTONE)
				.add(ModBlocks.STIEFANE_BRICK_BLOCK)
				.add(Blocks.POLISHED_ANDESITE)
				.add(Blocks.POLISHED_BASALT)
				.add(Blocks.POLISHED_BLACKSTONE)
				.add(Blocks.POLISHED_DEEPSLATE)
				.add(Blocks.POLISHED_DIORITE)
				.add(Blocks.POLISHED_GRANITE)
				.add(Blocks.POLISHED_TUFF)
		;
		getOrCreateTagBuilder(BlockTags.ALL_RAW_METAL_BLOCKS)
				.add(ModBlocks.RAW_BRASS_BLOCK)
				.add(Blocks.RAW_COPPER_BLOCK)
				.add(ModBlocks.RAW_EIDURIL_BLOCK)
				.add(Blocks.RAW_GOLD_BLOCK)
				.add(Blocks.RAW_IRON_BLOCK)
		;
		getOrCreateTagBuilder(BlockTags.ALL_REFINED_METAL_BLOCKS)
				.add(Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER,
						Blocks.OXIDIZED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER,
						Blocks.WAXED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER,
						Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER)
				.add(Blocks.CHISELED_COPPER, Blocks.EXPOSED_CHISELED_COPPER,
						Blocks.OXIDIZED_CHISELED_COPPER, Blocks.WEATHERED_CHISELED_COPPER,
						Blocks.WAXED_CHISELED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER,
						Blocks.WAXED_OXIDIZED_CHISELED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER)
				.add(Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER,
						Blocks.OXIDIZED_COPPER, Blocks.WEATHERED_COPPER,
						Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_EXPOSED_COPPER,
						Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_WEATHERED_COPPER)
				.add(Blocks.GOLD_BLOCK)
				.add(Blocks.IRON_BLOCK)
				.add(Blocks.NETHERITE_BLOCK)
				.add(ModBlocks.REFINED_BRASS_BLOCK)
		;
		
		getOrCreateTagBuilder(BlockTags.GEOLOGICALLY_COMPACTS_STRONGLY)
				.addTag(BlockTags.ALL_COBBLED_STONE_BLOCKS)
				.addTag(BlockTags.ALL_NATURAL_STONE_BLOCKS)
				.addTag(BlockTags.ALL_RAW_METAL_BLOCKS)
				.addTag(BlockTags.ALL_REFINED_METAL_BLOCKS)
				.add(Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.INFESTED_COBBLESTONE,
						Blocks.INFESTED_CRACKED_STONE_BRICKS, Blocks.INFESTED_DEEPSLATE,
						Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_STONE, Blocks.INFESTED_STONE_BRICKS)
				.add(ModBlocks.ETERNALITH_BLOCK, ModBlocks.CHISELED_ETERNALITH_BLOCK)
		;
		getOrCreateTagBuilder(BlockTags.GEOLOGICALLY_COMPACTS_WEAKLY)
				.addTag(BlockTags.GEOLOGICALLY_COMPACTS_STRONGLY)
				.add(Blocks.BLACK_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER,
						Blocks.BROWN_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER,
						Blocks.GRAY_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER,
						Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER,
						Blocks.LIME_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER,
						Blocks.ORANGE_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER,
						Blocks.PURPLE_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER,
						Blocks.WHITE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER)
				.add(Blocks.DIRT_PATH, Blocks.FARMLAND)
				.add(Blocks.SUSPICIOUS_GRAVEL, Blocks.SUSPICIOUS_SAND)
				.add(ModBlocks.ASH_BLOCK)
				.add(Blocks.CLAY)
				.add(Blocks.DIRT)
				.add(Blocks.GRAVEL)
				.add(Blocks.MUD)
				.add(Blocks.SAND)
				.add(Blocks.RED_SAND)
				.add(Blocks.SOUL_SAND)
				.add(Blocks.SOUL_SOIL)
		;
		
		getOrCreateTagBuilder(BlockTags.SPREADABLE_ATOP_ASHY_NETHERRACK)
				.add(Blocks.BROWN_MUSHROOM)
				.add(Blocks.CRIMSON_FUNGUS)
				.add(Blocks.CRIMSON_ROOTS)
				.add(Blocks.NETHER_SPROUTS)
				.add(Blocks.RED_MUSHROOM)
				.add(JAUBlocks.STARCHCAP_MUSHROOM)
				.add(Blocks.WARPED_FUNGUS)
				.add(Blocks.WARPED_ROOTS)
		;
		getOrCreateTagBuilder(BlockTags.SPREADABLE_INTO_ASHY_NETHERRACK)
				.add(Blocks.GLOWSTONE)
				.add(Blocks.NETHER_QUARTZ_ORE)
		;
		getOrCreateTagBuilder(BlockTags.SPREADABLE_ONTO_ASHY_NETHERRACK)
				.add(Blocks.CRIMSON_NYLIUM)
				.add(Blocks.WARPED_NYLIUM)
		;
		
		// Required for later tag builders.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.SAPLINGS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.SMALL_FLOWERS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.TALL_FLOWERS);
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.CROPS);
		
		// Blocks that Sporcreepers can destroy via explosion.
		getOrCreateTagBuilder(BlockTags.VULNERABLE_TO_CREEPER_EXPLOSION)
				//# Tags #
				.addTag(net.minecraft.registry.tag.BlockTags.SAPLINGS)
				.addTag(net.minecraft.registry.tag.BlockTags.SMALL_FLOWERS)
				.addTag(net.minecraft.registry.tag.BlockTags.TALL_FLOWERS)
				.addTag(net.minecraft.registry.tag.BlockTags.CROPS)
				// Bushes & Ferns
				.add(Blocks.DEAD_BUSH)
				.add(Blocks.FERN)
				.add(Blocks.SWEET_BERRY_BUSH)
				// Centralized Vines
				.add(Blocks.CAVE_VINES)
				.add(Blocks.CAVE_VINES_PLANT)
				.add(Blocks.TWISTING_VINES)
				.add(Blocks.TWISTING_VINES_PLANT)
				.add(Blocks.WEEPING_VINES)
				.add(Blocks.WEEPING_VINES_PLANT)
				// Edible Blocks
				.add(Blocks.CAKE)
				// Mushrooms
				.add(Blocks.BROWN_MUSHROOM)
				.add(Blocks.CRIMSON_FUNGUS)
				.add(Blocks.RED_MUSHROOM)
				.add(JAUBlocks.STARCHCAP_MUSHROOM)
				.add(Blocks.WARPED_FUNGUS)
				// Torches (basic)
				.add(Blocks.TORCH)
				.add(Blocks.WALL_TORCH)
				// Torches (spirit)
				.add(Blocks.SOUL_TORCH)
				.add(Blocks.SOUL_WALL_TORCH)
				// Torches (erythrite)
				.add(Blocks.REDSTONE_TORCH)
				.add(Blocks.REDSTONE_WALL_TORCH)
				// Wall Flora
				.add(Blocks.GLOW_LICHEN)
				.add(Blocks.VINE)
				// Wild Grass Crops
				.add(Blocks.CRIMSON_ROOTS)
				.add(Blocks.SHORT_GRASS)
				.add(Blocks.TALL_GRASS)
				.add(Blocks.WARPED_ROOTS)
				// Miscellaneous
				.add(Blocks.AMETHYST_CLUSTER)
				.add(Blocks.BAMBOO_SAPLING)
				.add(Blocks.COBWEB)
				.add(Blocks.COCOA)
				.add(Blocks.LILY_PAD)
				.add(Blocks.SCAFFOLDING)
				.add(Blocks.SUGAR_CANE)
		;
		
		// Everything Endermen can hold!
		// Notably, Enderman block holding mechanics do NOT respect wall torches;
		//  according to some testing, wall torches simply vanish when the Enderman attempts to place them.
		getOrCreateTagBuilder(net.minecraft.registry.tag.BlockTags.ENDERMAN_HOLDABLE)
				.setReplace(true)
				//# Tags #
				.addTag(net.minecraft.registry.tag.BlockTags.SAPLINGS)
				.addTag(net.minecraft.registry.tag.BlockTags.SMALL_FLOWERS)
				//# Individual Blocks #
				// Bales
				.add(Blocks.DRIED_KELP_BLOCK)
				.add(Blocks.HAY_BLOCK)
				// Bushes & Ferns
				.add(Blocks.DEAD_BUSH)
				.add(Blocks.FERN)
				.add(Blocks.SWEET_BERRY_BUSH)
				// Edible Blocks
				.add(Blocks.CAKE)
				// Gourds
				.add(Blocks.CARVED_PUMPKIN)
				.add(Blocks.MELON)
				.add(Blocks.PUMPKIN)
				// Mushrooms
				.add(Blocks.BROWN_MUSHROOM)
				.add(Blocks.CRIMSON_FUNGUS)
				.add(Blocks.RED_MUSHROOM)
				.add(JAUBlocks.STARCHCAP_MUSHROOM)
				.add(Blocks.WARPED_FUNGUS)
				// Wall Flora
				.add(Blocks.GLOW_LICHEN)
				.add(Blocks.VINE)
				// Wild Grass Crops
				.add(Blocks.CRIMSON_ROOTS)
				.add(Blocks.SHORT_GRASS)
				.add(Blocks.WARPED_ROOTS)
				// Miscellaneous
				.add(Blocks.AMETHYST_CLUSTER)
				.add(Blocks.ANCIENT_DEBRIS) // Ha.
				.add(Blocks.BAMBOO_SAPLING)
				.add(Blocks.CACTUS)
				.add(Blocks.COBWEB)
				.add(Blocks.COCOA)
				.add(Blocks.LILY_PAD) // Maybe not because water?
				.add(Blocks.SCAFFOLDING) // Tee hee.
				.add(Blocks.SUGAR_CANE) // Note: This might be finicky due to sugarcane placement restrictions; perhaps replace sugarcane with custom version "Sugarcane Crop" which can be placed without water adjacency.
				.add(Blocks.TNT) // Excellent.
				.add(Blocks.TORCH) // Basic Torch. Note: Cannot pick up wall torches; those are a separate block type.
				// - For Tercaphinom proper, standing torches and wall torches could be merged into a single block type.
				// - When a torch is supposed to be placed at a position (not through player placement):
				//  - If there is no solid block beneath the position, the torch will attempt to anchor itself to a wall, instead.
				//   - There could be a "Torch Bomb" item which attempts to place torches on all valid positions around itself, and wouldn't need to check for both torch types!
				;
	}
}
