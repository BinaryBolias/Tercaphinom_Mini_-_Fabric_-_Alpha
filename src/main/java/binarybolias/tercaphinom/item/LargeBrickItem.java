package binarybolias.tercaphinom.item;


import net.minecraft.block.Block;


/**
 * A {@link PlaceableBlockMaterialItem} which has a placement cost of 4, rather than 8.
 */
public class LargeBrickItem extends PlaceableBlockMaterialItem {
	public LargeBrickItem(Block block, Settings settings) {
		super(block, settings);
	}
	
	
	@Override
	protected int getPlacementCost() {
		return LARGE_BRICK_PLACEMENT_COST;
	}
}
