package binarybolias.tercaphinom.mixin.block;


import binarybolias.tercaphinom.references.VMOItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CaveVinesHeadBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(CaveVinesHeadBlock.class)
public class CaveVinesHeadBlockMixin {
	/**
	 * @author BinaryBolias
	 * @reason Defining the overwritten seed item as this block's seed item.
	 */
	@Overwrite
	public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
		return new ItemStack(VMOItems.GLOW_BERRIES);
	}
}
