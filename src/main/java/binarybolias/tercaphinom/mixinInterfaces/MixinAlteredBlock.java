package binarybolias.tercaphinom.mixinInterfaces;


import binarybolias.tercaphinom.mixin.block.BlockMixin;
import net.minecraft.item.Item;


/**
 * An interface to be used with {@link BlockMixin MixinBlock}.<br>
 * If adding methods to be used by instances of {@link net.minecraft.block.Block Block} via the mixin,
 * those methods are to be implemented here, and the block instance to be cast to this class for method access.
 */
public interface MixinAlteredBlock {
	void assignItem(Item item);
}
