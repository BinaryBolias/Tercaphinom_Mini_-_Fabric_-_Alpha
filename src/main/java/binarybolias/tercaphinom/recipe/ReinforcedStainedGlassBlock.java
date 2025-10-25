package binarybolias.tercaphinom.recipe;


import binarybolias.tercaphinom.recipe.remainderOverride.EmptyRemainderOverride;
import binarybolias.tercaphinom.references.*;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;


public class ReinforcedStainedGlassBlock extends SpecialCraftingRecipe {
	public ReinforcedStainedGlassBlock(CraftingRecipeCategory category) {
		super(category);
	}
	
	// Color bit flags
	private static final int NONE = 0;
	private static final int BLACK = 1; // -------- 0000000000000001
	private static final int BLUE = 2; // --------- 0000000000000010
	private static final int BROWN = 4; // -------- 0000000000000100
	private static final int CYAN = 8; // --------- 0000000000001000
	private static final int GRAY = 16; // -------- 0000000000010000
	private static final int GREEN = 32; // ------- 0000000000100000
	private static final int LIGHT_BLUE = 64; // -- 0000000001000000
	private static final int LIGHT_GRAY = 128; // - 0000000010000000
	private static final int LIME = 256; // ------- 0000000100000000
	private static final int MAGENTA = 512; // ---- 0000001000000000
	private static final int ORANGE = 1024; // ---- 0000010000000000
	private static final int PINK = 2048; // ------ 0000100000000000
	private static final int PURPLE = 4096; // ---- 0001000000000000
	private static final int RED = 8192; // ------- 0010000000000000
	private static final int WHITE = 16384; // ---- 0100000000000000
	private static final int YELLOW = 32768; // --- 1000000000000000
	
	
	private int getColorFlag(ItemStack itemStack) {
		// Get the color flag based on the glass pane type.
		// Return no color if a valid pane item isn't detected.
		//TODO: Make this more efficient, if possible...
		// - Note: The least computationally efficient version of this recipe uses
		//  Lime, Magenta, Orange, Pink, Purple, Red, White, and Yellow Stained Glass Panes.
		if (itemStack.isOf(ModItems.BLACK_STAINED_GLASS_PANE)) {
			return BLACK;
		} else if (itemStack.isOf(ModItems.BLUE_STAINED_GLASS_PANE)) {
			return BLUE;
		} else if (itemStack.isOf(ModItems.BROWN_STAINED_GLASS_PANE)) {
			return BROWN;
		} else if (itemStack.isOf(ModItems.CYAN_STAINED_GLASS_PANE)) {
			return CYAN;
		} else if (itemStack.isOf(ModItems.GRAY_STAINED_GLASS_PANE)) {
			return GRAY;
		} else if (itemStack.isOf(ModItems.GREEN_STAINED_GLASS_PANE)) {
			return GREEN;
		} else if (itemStack.isOf(ModItems.LIGHT_BLUE_STAINED_GLASS_PANE)) {
			return LIGHT_BLUE;
		} else if (itemStack.isOf(ModItems.LIGHT_GRAY_STAINED_GLASS_PANE)) {
			return LIGHT_GRAY;
		} else if (itemStack.isOf(ModItems.LIME_STAINED_GLASS_PANE)) {
			return LIME;
		} else if (itemStack.isOf(ModItems.MAGENTA_STAINED_GLASS_PANE)) {
			return MAGENTA;
		} else if (itemStack.isOf(ModItems.ORANGE_STAINED_GLASS_PANE)) {
			return ORANGE;
		} else if (itemStack.isOf(ModItems.PINK_STAINED_GLASS_PANE)) {
			return PINK;
		} else if (itemStack.isOf(ModItems.PURPLE_STAINED_GLASS_PANE)) {
			return PURPLE;
		} else if (itemStack.isOf(ModItems.RED_STAINED_GLASS_PANE)) {
			return RED;
		} else if (itemStack.isOf(ModItems.WHITE_STAINED_GLASS_PANE)) {
			return WHITE;
		} else if (itemStack.isOf(ModItems.YELLOW_STAINED_GLASS_PANE)) {
			return YELLOW;
		} else {
			return NONE;
		}
	}
	
	
	@Override
	public boolean matches(RecipeInputInventory inventory, World world) {
		// Assumes a 3x3 crafting grid; this method checks indecies 0 through 8.
		// Fail to match if the central slot is not a Dementhum Scrap.
		if (!inventory.getStack(4).isOf(Items.NETHERITE_SCRAP)) {
			return false;
		}
		
		// Check for items in the surrounding slot indecies.
		final int[] stainedGlassPaneIndecies = {0, 1, 2, 3, 5, 6, 7, 8};
		// Require each stained glass pane to be of a different color; remember detected colors while looping.
		int colorFlags = NONE;
		// Loop through the indecies to check for stained glass panes.
		for (int i : stainedGlassPaneIndecies) {
			int colorFlag = getColorFlag(inventory.getStack(i));
			// Fail to match if no color is found, or the color flag is already present.
			if (colorFlag == NONE || ((colorFlags & colorFlag) == colorFlag)) {
				return false;
			}
			// Remember this color flag.
			colorFlags += colorFlag;
		}
		
		return true;
	}
	
	
	@Override
	public ItemStack craft(RecipeInputInventory inventory, RegistryWrapper.WrapperLookup lookup) {
		return new ItemStack(JAUBlocks.REINFORCED_STAINED_GLASS_BLOCK);
	}
	
	
	@Override
	public boolean fits(int width, int height) {
		// Require a 3x3 grid, allowing for simplistic shape detection.
		return width == 3 && height == 3;
	}
	
	
	@Override
	public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
		return EmptyRemainderOverride.remainder(inventory);
	}
	
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.REINFORCED_STAINED_GLASS_BLOCK;
	}
}
