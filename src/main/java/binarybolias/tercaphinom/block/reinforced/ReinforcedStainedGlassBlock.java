package binarybolias.tercaphinom.block.reinforced;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;


//TODO:
// - Make a separate block type.
// - Convert this block into the other block type based on placement conditions.
// - Other block type converts back into this block type based on placement conditions.
// - Portal to Blendstain dimension.
/**
 *
 */
public class ReinforcedStainedGlassBlock extends Block {
	public static final MapCodec<ReinforcedStainedGlassBlock> CODEC = createCodec(ReinforcedStainedGlassBlock::new);
	
	
	@Override
	protected MapCodec<ReinforcedStainedGlassBlock> getCodec() {
		return CODEC;
	}
	
	
	public ReinforcedStainedGlassBlock(Settings settings) {
		super(settings);
	}
}
