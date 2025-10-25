package binarybolias.tercaphinom.mixin.block;


import binarybolias.tercaphinom.mixinInterfaces.MixinAlteredBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(Block.class)
public class BlockMixin implements MixinAlteredBlock {
	@Shadow private @Nullable Item cachedItem;
	
	
	/**
	 * Manually assigns an item to be returned when getting this block's corresponding item.<br>
	 * Created for use by {@link binarybolias.tercaphinom.references.VMOItems VMOItems}.
	 * @param item the item to set as the block's {@link #cachedItem}, returned by {@link Block#asItem()}
	 */
	public void assignItem(Item item) {
		cachedItem = item;
	}
}
