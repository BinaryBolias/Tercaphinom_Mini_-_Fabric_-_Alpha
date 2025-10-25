package binarybolias.tercaphinom.mixin.block;


import net.minecraft.block.BlockState;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


/**
 * @see EnchantmentScreenHandler
 * @see binarybolias.tercaphinom.screen.handler.EnchantmentScreenHandler
 * @see net.minecraft.client.gui.screen.ingame.EnchantmentScreen
 */
@Mixin(EnchantingTableBlock.class)
public class EnchantingTableBlockMixin {
	/**
	 * @author BinaryBolias
	 * @reason Returning a custom version of the enchantment screen handler instead.
	 */
	@Overwrite
	public @Nullable NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof EnchantingTableBlockEntity) {
			Text text = ((Nameable)blockEntity).getDisplayName();
			//TODO: See if this works (it probably doesn't).
			// - This new enchantment screen handler would likely also need
			//  a corresponding enchantment screen which extends HandledScreen<>.
			// - Not sure how this whole system works, yet...
			// - Uhh... Oddly enough... It seems to work perfectly fine!
			//  - The vanilla handled screen is naturally compatible with my custom screen handler?
			//  - Presumably it will start NOT working if I make major modifications.
			//   - E.g, adding new slots, changing the amount the enchantment options...
			//    - Perhaps even changing the positions of slots.
			return new SimpleNamedScreenHandlerFactory(
					(syncId, inventory, player) -> new binarybolias.tercaphinom.screen.handler.EnchantmentScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), text
			);
		} else {
			return null;
		}
	}
}
