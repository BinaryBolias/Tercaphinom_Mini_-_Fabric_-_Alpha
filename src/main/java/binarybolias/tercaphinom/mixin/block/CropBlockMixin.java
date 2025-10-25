package binarybolias.tercaphinom.mixin.block;


import binarybolias.tercaphinom.references.VMOItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(CropBlock.class)
public class CropBlockMixin {
	/**
	 * @author BinaryBolias
	 * @reason Defining the overwritten seed item as this block's seed item.
	 */
	@Overwrite
	public ItemConvertible getSeedsItem() {
		return VMOItems.WHEAT_SEEDS;
	}
}
