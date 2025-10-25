package binarybolias.tercaphinom.references;


import binarybolias.tercaphinom.mixin.block.BlockMixin;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import java.util.List;

import static binarybolias.tercaphinom.references.ModItems.*;


/**
 * Re-registration for overwriting vanilla items.
 * @apiNote
 * Variable names here are to reflect those of vanilla items (found in {@link net.minecraft.item.Items Items}) for clarity.<br><br>
 * Some direct external references to vanilla items must be updated to instead reference the corresponding items from this class.<br>
 * Ensure updates in: {@link ModRegistries}, {@link ModItemGroups}<br><br>
 * References to vanilla items used solely for generating JSON do not need to be modified.
 * @see ModItems
 */
public class VMOItems {
	public static void bootstrap() {
		Reference.logMainEvent("Registering vanilla item overrides");
	}
	
	
	/**
	 * Registers a new item with an existing identifier.
	 * @param oldItem the item to overwrite
	 * @param newItem the item to register with the overwritten item's identifier
	 */
	public static Item overwrite(Item oldItem, Item newItem) {
		return Registry.register(Registries.ITEM, Registries.ITEM.getId(oldItem), newItem);
	}
	
	
	@Deprecated
	public static Item overwriteOld(String id, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(id), item);
	}
	
	
	/**
	 * Registers an {@link AliasedBlockItem} with an existing identifier.<br>
	 * Uses functionality provided by {@link BlockMixin MixinBlock}
	 * to manually assign the new item as the item which the block returns via the "pick block" game function.<br>
	 * Effectively replicates the functionality of {@link Items#register(net.minecraft.registry.RegistryKey,Item) Items.register(RegistryKey, Item)}.
	 * @param oldItem the item to overwrite
	 * @param block the block to assign the new item to
	 * @param settings the new item's settings
	 */
	public static Item overwriteAliasedBlockItem(Item oldItem, Block block, Item.Settings settings) {
		// Enforce that the item being overwritten was already an aliased block item.
		if (!(oldItem instanceof AliasedBlockItem)) {
			throw new IllegalArgumentException("Attempted to overwrite item of id "
					+ Registries.ITEM.getId(oldItem) + " as an aliased block item");
		}
		AliasedBlockItem newItem = new AliasedBlockItem(block, settings);
		// Assign the item to the block.
		//TODO: Not this.
		// - The seed items weren't working because the crop blocks had hard references to their seed items.
//		((MixinAlteredBlock) block).assignItem(newItem); // TODO: This doesn't actually work... Make it work.
		//TODO: Figure out how the pick block feature actually works...
		// - (DONE) Find the code for picking blocks.
		// - Rework the block mixin to modify the 'getPickStack' method instead of adding that silly new one!
		//  - Modify the MinecraftClient via mixin to try getting a "materialItem" from the block
		//   if it can't give the player an item from 'getPickStack'.
		//   - 'getMaterialItem' as a new method added by the block mixin.
		
		//TODO: Override vanilla blocks such that these blocks return their proper (overwritten) items from pick stack:
		// - Carrot Crop
		// - (DONE) Cave Vines
		// - Melon Crop
		// - Potato Crop
		// - Pumpkin Crop
		// - Radish Crop
		// - Sweet Berry Bush
		// - Torchflower Crop
		// - (DONE) Wheat Crop
		
		return Registry.register(Registries.ITEM, Registries.ITEM.getId(oldItem), newItem);
	}
	
	
	/**
	 * Block picking feature:<br>
	 * Do item pick method: {@link MinecraftClient}<code>.doItemPick()</code> (private)<br>
	 * Ah, whoops; looks like I missed this method when searching earlier!<br>
	 * Get pick stack method: {@link Block#getPickStack(WorldView, BlockPos, BlockState)}<br>
	 * Wait a minute... crops are manually overridden to return their corresponding seed item?!?<br>
	 * Of course... so I'll just need to modify the blocks themselves to give my overwritten items!
	 */
	private void teeHeeJustHereForAHandyJavaDoc() {}
	
	
	/**
	 * TODO:<br>
	 * Modify {@link PlayerEntity#canResetTimeBySleeping()} to always return <code>false</code>; no magic beds!<br>
	 * Modify {@link net.minecraft.server.world.SleepManager} to SUPER disable magic beds!<br>
	 * - Or... Ugh... Use a gamerule for it? (disabled by default, of course)<br>
	 * Modify {@link PlayerEntity}<code>.sleepTimer</code> to manage whether the player gets a passive Regeneration effect.<br>
	 * Modify {@link net.minecraft.server.network.ServerPlayerEntity#trySleep(BlockPos)} to allow for sleeping at any time,
	 * and regardless of nearby monsters or the current dimension.<br>
	 * Modify {@link PlayerEntity#getXpToDrop()} and use a different gamerule from KEEP_INVENTORY to determine whether experience is lost.<br>
	 * Interaction range reference: {@link PlayerEntity#getBlockInteractionRange()}, {@link PlayerEntity#getEntityInteractionRange()}
	 */
	private void handyJavaDocMethodTwo() {}
	
	
	public static Item overwriteBlockItem(Block block, Item.Settings settings) {
		BlockItem item = new BlockItem(block, settings);
		//TODO: !!!!!!
		// - I need to use the same identifier!
		// - Block item overrides work properly, since I'm re-using the identifiers that vanilla blocks already have.
		// - When overriding an item, I need to pass in the vanilla item to overwrite and get its identifier!
		//  - I will also not need to manually pass in a new "id" string!
		// - ..Youch.
		//  - This plan might not be ENTIRELY perfect...
		//  - There still exist separate item instances...
		//  - The [pick block] function doesn't work with aliased block items defined here.
		//   - [pick block] works fine with ordinary block items here, though.
		return Registry.register(Registries.ITEM, Registries.BLOCK.getId(block), item);
	}
	
	public static Item overwriteBlockItem(Block block, int maxCount) {
		return overwriteBlockItem(block, itemSettings(maxCount));
	}
	
	
	//### Items ###
	//region ## Basic Resources ##
	//# Ball #
	public static final Item BONE_MEAL = overwrite(Items.BONE_MEAL, new BoneMealItem(itemSettings(96)));
	public static final Item CLAY_BALL = overwrite(Items.CLAY_BALL, newEarthenPileItem(Blocks.CLAY));
	public static final Item MAGMA_CREAM = overwrite(Items.MAGMA_CREAM, newFireproofItem(64));
	public static final Item SLIME_BALL = overwrite(Items.SLIME_BALL, newEarthenPileItem(Blocks.SLIME_BLOCK));
	public static final Item SNOWBALL = overwrite(Items.SNOWBALL, new SnowballItem(itemSettings(24)));
	//# Blobs (dye) #
	public static final Item BLACK_DYE = overwrite(Items.BLACK_DYE, new DyeItem(DyeColor.BLACK, itemSettings(96)));
	public static final Item BLUE_DYE = overwrite(Items.BLUE_DYE, new DyeItem(DyeColor.BLUE, itemSettings(96)));
	public static final Item BROWN_DYE = overwrite(Items.BROWN_DYE, new DyeItem(DyeColor.BROWN, itemSettings(96)));
	public static final Item CYAN_DYE = overwrite(Items.CYAN_DYE, new DyeItem(DyeColor.CYAN, itemSettings(96)));
	public static final Item GRAY_DYE = overwrite(Items.GRAY_DYE, new DyeItem(DyeColor.GRAY, itemSettings(96)));
	public static final Item GREEN_DYE = overwrite(Items.GREEN_DYE, new DyeItem(DyeColor.GREEN, itemSettings(96)));
	public static final Item LIGHT_BLUE_DYE = overwrite(Items.LIGHT_BLUE_DYE, new DyeItem(DyeColor.LIGHT_BLUE, itemSettings(96)));
	public static final Item LIGHT_GRAY_DYE = overwrite(Items.LIGHT_GRAY_DYE, new DyeItem(DyeColor.LIGHT_GRAY, itemSettings(96)));
	public static final Item LIME_DYE = overwrite(Items.LIME_DYE, new DyeItem(DyeColor.LIME, itemSettings(96)));
	public static final Item MAGENTA_DYE = overwrite(Items.MAGENTA_DYE, new DyeItem(DyeColor.MAGENTA, itemSettings(96)));
	public static final Item ORANGE_DYE = overwrite(Items.ORANGE_DYE, new DyeItem(DyeColor.ORANGE, itemSettings(96)));
	public static final Item PINK_DYE = overwrite(Items.PINK_DYE, new DyeItem(DyeColor.PINK, itemSettings(96)));
	public static final Item PURPLE_DYE = overwrite(Items.PURPLE_DYE, new DyeItem(DyeColor.PURPLE, itemSettings(96)));
	public static final Item RED_DYE = overwrite(Items.RED_DYE, new DyeItem(DyeColor.RED, itemSettings(96)));
	public static final Item WHITE_DYE = overwrite(Items.WHITE_DYE, new DyeItem(DyeColor.WHITE, itemSettings(96)));
	public static final Item YELLOW_DYE = overwrite(Items.YELLOW_DYE, new DyeItem(DyeColor.YELLOW, itemSettings(96)));
	//# Brick #
	public static final Item BRICK = overwrite(Items.BRICK, newSmallBrickItem(Blocks.BRICKS));
	public static final Item NETHER_BRICK = overwrite(Items.NETHER_BRICK, newSmallBrickItem(Blocks.NETHER_BRICKS));
	//# Bundle & Rod & Stick #
	public static final Item BAMBOO = overwriteBlockItem(Blocks.BAMBOO, 96);
	public static final Item BLAZE_ROD = overwrite(Items.BLAZE_ROD, newFireproofItem(64));
	public static final Item STICK = overwrite(Items.STICK, newItem(96));
	//# Crystal & Jewel #
	public static final Item AMETHYST_SHARD = overwrite(Items.AMETHYST_SHARD, newEarthenPileItem(Blocks.AMETHYST_BLOCK));
	public static final Item DIAMOND = overwrite(Items.DIAMOND, newEarthenPileItem(Blocks.DIAMOND_BLOCK));
	public static final Item EMERALD = overwrite(Items.EMERALD, newEarthenPileItem(Blocks.EMERALD_BLOCK));
	public static final Item LAPIS_LAZULI = overwrite(Items.LAPIS_LAZULI, newEarthenPileItem(Blocks.LAPIS_BLOCK));
	public static final Item PRISMARINE_CRYSTALS = overwrite(Items.PRISMARINE_CRYSTALS, newItem(96));
	public static final Item QUARTZ = overwrite(Items.QUARTZ, newEarthenPileItem(Blocks.QUARTZ_BLOCK));
	//# Ingot #
	public static final Item COPPER_INGOT = overwrite(Items.COPPER_INGOT, newMetalIngotItem(Blocks.COPPER_BLOCK));
	//TODO: Make this new gold ingot tradeable with piglins...
	/**
	 * Reference needs to be updated in {@link net.minecraft.entity.mob.PiglinBrain PiglinBrain}.
	 */
	public static final Item GOLD_INGOT = overwrite(Items.GOLD_INGOT, newMetalIngotItem(Blocks.GOLD_BLOCK));
	public static final Item IRON_INGOT = overwrite(Items.IRON_INGOT, newMetalIngotItem(Blocks.IRON_BLOCK));
	public static final Item NETHERITE_INGOT = overwrite(Items.NETHERITE_INGOT, newMetalIngotItem(Blocks.NETHERITE_BLOCK));
	//# Lump & Nugget #
	//TODO: Add Charcoal Block in firestarting update.
//	public static final Item CHARCOAL = overwrite("charcoal", newEarthenPileItem(Blocks.COAL_BLOCK));
	public static final Item COAL = overwrite(Items.COAL, newEarthenPileItem(Blocks.COAL_BLOCK));
	public static final Item GOLD_NUGGET = overwrite(Items.GOLD_NUGGET, newMetalNuggetItem());
	public static final Item IRON_NUGGET = overwrite(Items.IRON_NUGGET, newMetalNuggetItem());
	public static final Item RAW_COPPER = overwrite(Items.RAW_COPPER, newMetalLumpItem(Blocks.RAW_COPPER_BLOCK));
	public static final Item RAW_GOLD = overwrite(Items.RAW_GOLD, newMetalLumpItem(Blocks.RAW_GOLD_BLOCK));
	public static final Item RAW_IRON = overwrite(Items.RAW_IRON, newMetalLumpItem(Blocks.RAW_IRON_BLOCK));
	//# Pile (seed) #
	public static final Item BEETROOT_SEEDS = overwriteAliasedBlockItem(
			Items.BEETROOT_SEEDS, Blocks.BEETROOTS, itemSettings(96));
	public static final Item MELON_SEEDS = overwriteAliasedBlockItem(
			Items.MELON_SEEDS, Blocks.MELON_STEM, itemSettings(96));
	public static final Item PUMPKIN_SEEDS = overwriteAliasedBlockItem(
			Items.PUMPKIN_SEEDS, Blocks.PUMPKIN_STEM, itemSettings(96));
	public static final Item TORCHFLOWER_SEEDS = overwriteAliasedBlockItem(
			Items.TORCHFLOWER_SEEDS, Blocks.TORCHFLOWER_CROP, itemSettings(96));
	public static final Item WHEAT_SEEDS = overwriteAliasedBlockItem(
			Items.WHEAT_SEEDS, Blocks.WHEAT, itemSettings(96));
	//# Pile (miscellaneous) #
	public static final Item BLAZE_POWDER = overwrite(Items.BLAZE_POWDER, newItem(96));
	public static final Item GLOWSTONE_DUST = overwrite(Items.GLOWSTONE_DUST, newFireproofItem(96));
	public static final Item GUNPOWDER = overwrite(Items.GUNPOWDER, newItem(96));
	public static final Item NETHER_SPROUTS = overwriteBlockItem(Blocks.NETHER_SPROUTS,
			itemSettings(96).food(FoodComponents.NETHERWART_PILE)); // TODO: Make a "WARPSPROUT_PILE" food component.
	public static final Item NETHER_WART = overwriteBlockItem(Blocks.NETHER_WART,
			itemSettings(96).food(FoodComponents.NETHERWART_PILE));
	public static final Item REDSTONE = overwrite(Items.REDSTONE,
			new AliasedBlockItem(Blocks.REDSTONE_WIRE, itemSettings(96)));
	public static final Item SUGAR = overwrite(Items.SUGAR, newFireproofItem(96));
	//# Shard #
	public static final Item FLINT = overwrite(Items.FLINT, newFireproofItem(64));
	public static final Item PRISMARINE_SHARD = overwrite(Items.PRISMARINE_SHARD, newEarthenPileItem(Blocks.PRISMARINE));
	//# Miscellaneous #
	public static final Item ARMADILLO_SCUTE = overwrite(Items.ARMADILLO_SCUTE, newItem(96));
	public static final Item ECHO_SHARD = overwrite(Items.ECHO_SHARD, newFireproofItem(64));
	public static final Item EGG = overwrite(Items.EGG, new EggItem(itemSettings(24)));
	public static final Item ENDER_EYE = overwrite(Items.ENDER_EYE, new EnderEyeItem(itemSettings(24)));
	public static final Item ENDER_PEARL = overwrite(Items.ENDER_PEARL, new EnderPearlItem(itemSettings(24)));
	public static final Item FEATHER = overwrite(Items.FEATHER, newItem(96));
	public static final Item FERMENTED_SPIDER_EYE = overwrite(Items.FERMENTED_SPIDER_EYE,
			newItem(96, itemSettings().food(FoodComponents.FERMENTED_SPIDER_EYE)));
	public static final Item GHAST_TEAR = overwrite(Items.GHAST_TEAR, newFireproofItem(96));
	public static final Item GLOW_INK_SAC = overwrite(Items.GLOW_INK_SAC, new GlowInkSacItem(itemSettings(96)));
	//NOTE: Honeycomb already has its own item type;
	// can't simply redefine as a placeable block material item without losing existing functionality.
	public static final Item INK_SAC = overwrite(Items.INK_SAC, new InkSacItem(itemSettings(96)));
	public static final Item KELP = overwriteBlockItem(Blocks.KELP, 96);
	public static final Item NETHER_STAR = overwrite(Items.NETHER_STAR,
			newItem(fireproofItemSettings(64).rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item NETHERITE_SCRAP = overwrite(Items.NETHERITE_SCRAP, newFireproofItem(96));
	public static final Item PAPER = overwrite(Items.PAPER, newItem(96));
	public static final Item PHANTOM_MEMBRANE = overwrite(Items.PHANTOM_MEMBRANE, newItem(96));
	public static final Item POPPED_CHORUS_FRUIT = overwrite(Items.POPPED_CHORUS_FRUIT, newEarthenPileItem(Blocks.PURPUR_BLOCK));
	public static final Item RABBIT_HIDE = overwrite(Items.RABBIT_HIDE, newItem(96));
	public static final Item SPIDER_EYE = overwrite(Items.SPIDER_EYE,
			newItem(96, itemSettings().food(FoodComponents.SPIDER_EYE)));
	public static final Item STRING = overwrite(Items.STRING, new AliasedBlockItem(Blocks.TRIPWIRE, itemSettings(96)));
	public static final Item TURTLE_SCUTE = overwrite(Items.TURTLE_SCUTE, newItem(96));
	//endregion
	
	//region ## Block Items ##
	//# Anvils #
	public static final Item ANVIL = overwriteBlockItem(Blocks.ANVIL, 1);
	public static final Item CHIPPED_ANVIL = overwriteBlockItem(Blocks.CHIPPED_ANVIL, 1);
	public static final Item DAMAGED_ANVIL = overwriteBlockItem(Blocks.DAMAGED_ANVIL, 1);
	//# Bee Houses #
	public static final Item BEE_NEST = overwriteBlockItem(Blocks.BEE_NEST, itemSettings(1)
			.component(DataComponentTypes.BEES, List.of()));
	public static final Item BEEHIVE = overwriteBlockItem(Blocks.BEEHIVE, itemSettings(1)
			.component(DataComponentTypes.BEES, List.of()));
	//# Bookshelves #
	public static final Item BOOKSHELF = overwriteBlockItem(Blocks.BOOKSHELF, 12);
	public static final Item CHISELED_BOOKSHELF = overwriteBlockItem(Blocks.CHISELED_BOOKSHELF, containerComponentItemSettings(12));
	//# Campfires #
	public static final Item CAMPFIRE = overwriteBlockItem(Blocks.CAMPFIRE, containerComponentItemSettings(1));
	public static final Item SOUL_CAMPFIRE = overwriteBlockItem(Blocks.SOUL_CAMPFIRE, containerComponentItemSettings(1));
	//# Furnaces #
	public static final Item BLAST_FURNACE = overwriteBlockItem(Blocks.BLAST_FURNACE, containerComponentItemSettings(1));
	public static final Item FURNACE = overwriteBlockItem(Blocks.FURNACE, containerComponentItemSettings(1));
	public static final Item SMOKER = overwriteBlockItem(Blocks.SMOKER, containerComponentItemSettings(1));
	//# Inert Containers #
	public static final Item BARREL = overwriteBlockItem(Blocks.BARREL, containerComponentItemSettings(1));
	public static final Item CHEST = overwriteBlockItem(Blocks.CHEST, containerComponentItemSettings(1));
	public static final Item ENDER_CHEST = overwriteBlockItem(Blocks.ENDER_CHEST, containerComponentItemSettings(1));
	public static final Item TRAPPED_CHEST = overwriteBlockItem(Blocks.TRAPPED_CHEST, containerComponentItemSettings(1));
	//# Inert Crafting Stations #
	public static final Item CARTOGRAPHY_TABLE = overwriteBlockItem(Blocks.CARTOGRAPHY_TABLE, 1);
	public static final Item COMPOSTER = overwriteBlockItem(Blocks.COMPOSTER, 1);
	public static final Item CRAFTING_TABLE = overwriteBlockItem(Blocks.CRAFTING_TABLE, 1);
	public static final Item FLETCHING_TABLE = overwriteBlockItem(Blocks.FLETCHING_TABLE, 1);
	public static final Item GRINDSTONE = overwriteBlockItem(Blocks.GRINDSTONE, 1);
	public static final Item LOOM = overwriteBlockItem(Blocks.LOOM, 1);
	public static final Item SMITHING_TABLE = overwriteBlockItem(Blocks.SMITHING_TABLE, 1);
	public static final Item STONECUTTER = overwriteBlockItem(Blocks.STONECUTTER, 1);
	//# Miscellaneous #
	public static final Item CRAFTER = overwriteBlockItem(Blocks.CRAFTER, containerComponentItemSettings(1));
	public static final Item JUKEBOX = overwriteBlockItem(Blocks.JUKEBOX, 1);
	public static final Item LODESTONE = overwriteBlockItem(Blocks.LODESTONE, 1);
	public static final Item NOTE_BLOCK = overwriteBlockItem(Blocks.NOTE_BLOCK, 12);
	public static final Item RESPAWN_ANCHOR = overwriteBlockItem(Blocks.RESPAWN_ANCHOR, 1);
	//endregion
	
	//region ## Containers ##
	//# Bottle (empty) #
	public static final Item GLASS_BOTTLE = overwrite(Items.GLASS_BOTTLE, new GlassBottleItem(emptyBottleSettings()));
	//# Bottle (potion) #
	public static final Item LINGERING_POTION = overwrite(Items.LINGERING_POTION,
			new LingeringPotionItem(emptyBottleSettings()
					.component(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT)));
	public static final Item POTION = overwrite(Items.POTION,
			//TODO: Ensure that stacking potions works properly.
			// - Potions should stack (obviously), and only stack with others of similar type.
			//  - Ensure that potions of the same status effect but different duration/power still don't stack.
			// - The potion slots of the Brewing Stand should not accept more than 1 item each.
			// - Looking at the PotionItem code, it seems to account for a stack size greater than 1.
			//  - Nonetheless, it should still be tested that Empty Bottles are properly returned when potions are drunk,
			//   and extra potions are not destroyed when drinking a potion stack of size greater than 1.
			//TODO: Fix problems:
			// - Brewing Stand SUPER doesn't work.
			//  - Needs to accept items in potion slots, fuel slot, and for recipes from this class (VMOItems).
			// - Potions don't have color?
			// - Empty Bottle needs to become a potion item of custom type (from this class) when filled with water.
			new PotionItem(bottleSettings()
					.component(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT)));
	public static final Item SPLASH_POTION = overwrite(Items.SPLASH_POTION,
			new SplashPotionItem(emptyBottleSettings()
					.component(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT)));
	//# Bottle (filled) #
	public static final Item DRAGON_BREATH = overwrite(Items.DRAGON_BREATH,
			newItem(bottleSettings().rarity(Rarity.UNCOMMON)));
	public static final Item EXPERIENCE_BOTTLE = overwrite(Items.EXPERIENCE_BOTTLE,
			new ExperienceBottleItem(emptyBottleSettings().rarity(Rarity.UNCOMMON)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item HONEY_BOTTLE = overwrite(Items.HONEY_BOTTLE,
			new HoneyBottleItem(bottleSettings().food(FoodComponents.BOTTLE_OF_HONEY)));
	//# Bowl (empty) #
	public static final Item BOWL = overwrite(Items.BOWL, newItem(24));
	//# Bowl (filled) #
	//# Bucket (empty) #
	//TODO: Enable and update references to this... later.
//	public static final Item BUCKET = overwrite(Items.BUCKET, new BucketItem(Fluids.EMPTY, fireproofItemSettings(16)));
	//# Bucket (filled - basic) #
	public static final Item LAVA_BUCKET = overwrite(Items.LAVA_BUCKET, newFilledBucketItem(Fluids.LAVA));
	public static final Item MILK_BUCKET = overwrite(Items.MILK_BUCKET,
			newBucketStatusEffectCureBeverageItem(milkCureStatusEffectList, itemSettings(1)));
	public static final Item POWDER_SNOW_BUCKET = overwrite(Items.POWDER_SNOW_BUCKET,
			new PowderSnowBucketItem(Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, filledBucketSettings()));
	public static final Item WATER_BUCKET = overwrite(Items.WATER_BUCKET, newFilledBucketItem(Fluids.WATER));
	//# Bucket (filled - entity) #
	public static final Item AXOLOTL_BUCKET = overwrite(Items.AXOLOTL_BUCKET,
			new EntityBucketItem(EntityType.AXOLOTL, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_AXOLOTL, entityBucketSettings()));
	public static final Item COD_BUCKET = overwrite(Items.COD_BUCKET,
			new EntityBucketItem(EntityType.COD, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_FISH, entityBucketSettings()));
	public static final Item PUFFERFISH_BUCKET = overwrite(Items.PUFFERFISH_BUCKET,
			new EntityBucketItem(EntityType.PUFFERFISH, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_FISH, entityBucketSettings()));
	public static final Item SALMON_BUCKET = overwrite(Items.SALMON_BUCKET,
			new EntityBucketItem(EntityType.SALMON, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_FISH, entityBucketSettings()));
	public static final Item TADPOLE_BUCKET = overwrite(Items.TADPOLE_BUCKET,
			new EntityBucketItem(EntityType.TADPOLE, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_TADPOLE, entityBucketSettings()));
	public static final Item TROPICAL_FISH_BUCKET = overwrite(Items.TROPICAL_FISH_BUCKET,
			new EntityBucketItem(EntityType.TROPICAL_FISH, Fluids.WATER,
					SoundEvents.ITEM_BUCKET_EMPTY_FISH, entityBucketSettings()));
	//endregion
	
	//region  ## Equipment ##
	//endregion
	
	//region ## Foods ##
	//# Basic (cooked) #
	public static final Item BAKED_POTATO = overwrite(Items.BAKED_POTATO,
			newItem(64, itemSettings().food(FoodComponents.BAKED_POTATO)));
	public static final Item COOKED_BEEF = overwrite(Items.COOKED_BEEF,
			newItem(24, itemSettings().food(FoodComponents.COOKED_BEEF_STEAK)));
	public static final Item COOKED_CHICKEN = overwrite(Items.COOKED_CHICKEN,
			newItem(24, itemSettings().food(FoodComponents.COOKED_CHICKEN)));
	public static final Item COOKED_COD = overwrite(Items.COOKED_COD,
			newItem(64, itemSettings().food(FoodComponents.COOKED_COD)));
	public static final Item COOKED_MUTTON = overwrite(Items.COOKED_MUTTON,
			newItem(24, itemSettings().food(FoodComponents.COOKED_MUTTON_STEAK)));
	public static final Item COOKED_PORKCHOP = overwrite(Items.COOKED_PORKCHOP,
			newItem(24, itemSettings().food(FoodComponents.COOKED_PORKCHOP)));
	public static final Item COOKED_RABBIT = overwrite(Items.COOKED_RABBIT,
			newItem(24, itemSettings().food(FoodComponents.COOKED_RABBIT)));
	public static final Item COOKED_SALMON = overwrite(Items.COOKED_SALMON,
			newItem(64, itemSettings().food(FoodComponents.COOKED_SALMON)));
	//# Basic (raw) #
	public static final Item BEEF = overwrite(Items.BEEF,
			newItem(24, itemSettings().food(FoodComponents.RAW_BEEF_STEAK)));
	public static final Item BEETROOT = overwrite(Items.BEETROOT,
			newItem(64, itemSettings().food(FoodComponents.RAW_RADISH)));
	public static final Item CARROT = overwrite(Items.CARROT,
			new AliasedBlockItem(Blocks.CARROTS, itemSettings().food(FoodComponents.RAW_CARROT)));
	public static final Item CHICKEN = overwrite(Items.CHICKEN,
			newItem(24, itemSettings().food(FoodComponents.RAW_CHICKEN)));
	public static final Item COD = overwrite(Items.COD,
			newItem(64, itemSettings().food(FoodComponents.RAW_COD)));
	public static final Item MUTTON = overwrite(Items.MUTTON,
			newItem(24, itemSettings().food(FoodComponents.RAW_MUTTON_STEAK)));
	public static final Item PORKCHOP = overwrite(Items.PORKCHOP,
			newItem(24, itemSettings().food(FoodComponents.RAW_PORKCHOP)));
	public static final Item POTATO = overwrite(Items.POTATO,
			new AliasedBlockItem(Blocks.POTATOES, itemSettings().food(FoodComponents.RAW_POTATO)));
	public static final Item PUFFERFISH = overwrite(Items.PUFFERFISH,
			newItem(64, itemSettings().food(FoodComponents.RAW_PUFFERFISH)));
	public static final Item RABBIT = overwrite(Items.RABBIT,
			newItem(24, itemSettings().food(FoodComponents.RAW_RABBIT)));
	public static final Item SALMON = overwrite(Items.SALMON,
			newItem(64, itemSettings().food(FoodComponents.RAW_SALMON)));
	public static final Item TROPICAL_FISH = overwrite(Items.TROPICAL_FISH,
			newItem(64, itemSettings().food(FoodComponents.RAW_TROPICAL_FISH)));
	//# Bread, Cake, & Cookie #
	public static final Item BREAD = overwrite(Items.BREAD,
			newItem(24, itemSettings().food(FoodComponents.BREAD_LOAF)));
	public static final Item CAKE = Items.register(new BlockItem(Blocks.CAKE, itemSettings(12)));
	public static final Item COOKIE = overwrite(Items.COOKIE,
			newItem(96, itemSettings().food(FoodComponents.COOKIE)));
	//# Miscellaneous #
	public static final Item APPLE = overwrite(Items.APPLE,
			newItem(24, itemSettings().food(FoodComponents.RIPE_APPLE)));
	public static final Item CHORUS_FRUIT = overwrite(Items.CHORUS_FRUIT,
			new ChorusFruitItem(itemSettings(64).food(FoodComponents.CHORUS_FRUIT)));
	public static final Item DRIED_KELP = overwrite(Items.DRIED_KELP,
			newItem(96, itemSettings().food(FoodComponents.DRY_KELP_LEAF)));
	public static final Item ENCHANTED_GOLDEN_APPLE = overwrite(Items.ENCHANTED_GOLDEN_APPLE,
			newItem(24, itemSettings()
					.rarity(Rarity.EPIC)
					.food(FoodComponents.ENCHANTED_GOLDEN_APPLE)
					.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)));
	public static final Item GLISTERING_MELON_SLICE = overwrite(Items.GLISTERING_MELON_SLICE,
			newItem(64, itemSettings().food(FoodComponents.GLISTERING_MELON_SLICE)));
	public static final Item GLOW_BERRIES = overwrite(Items.GLOW_BERRIES,
			new AliasedBlockItem(Blocks.CAVE_VINES, itemSettings(96).food(FoodComponents.GLOWBERRY_BUNCH)));
	public static final Item GOLDEN_APPLE = overwrite(Items.GOLDEN_APPLE,
			newItem(24, itemSettings().rarity(Rarity.RARE).food(FoodComponents.GOLDEN_APPLE)));
	public static final Item GOLDEN_CARROT = overwrite(Items.GOLDEN_CARROT,
			newItem(64, itemSettings().food(FoodComponents.GOLDEN_CARROT)));
	public static final Item MELON_SLICE = overwrite(Items.MELON_SLICE,
			newItem(64, itemSettings().food(FoodComponents.MELON_SLICE)));
	public static final Item POISONOUS_POTATO = overwrite(Items.POISONOUS_POTATO,
			newItem(64, itemSettings().food(FoodComponents.POISONOUS_POTATO)));
	public static final Item ROTTEN_FLESH = overwrite(Items.ROTTEN_FLESH,
			newItem(64, itemSettings().food(FoodComponents.ROTTEN_FLESH_CHUNK)));
	public static final Item SUSPICIOUS_STEW = overwrite(Items.SUSPICIOUS_STEW,
			new SuspiciousStewItem(itemSettings(1).food(FoodComponents.BOWL_OF_SUSPICIOUS_STEW)
					.component(DataComponentTypes.SUSPICIOUS_STEW_EFFECTS, SuspiciousStewEffectsComponent.DEFAULT)));
	public static final Item SWEET_BERRIES = overwrite(Items.SWEET_BERRIES,
			new AliasedBlockItem(Blocks.SWEET_BERRY_BUSH, itemSettings(96).food(FoodComponents.SWEETBERRY_BUNCH)));
	//endregion
	
	//region ## Miscellaneous Items ##
	//# Miscellaneous #
	public static final Item ARMOR_STAND = overwrite(Items.ARMOR_STAND, new ArmorStandItem(itemSettings(1)));
	//endregion
}
