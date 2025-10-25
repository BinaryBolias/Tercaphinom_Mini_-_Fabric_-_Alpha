package binarybolias.tercaphinom.mixin.block;


import binarybolias.tercaphinom.references.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Predicate;


/**
 * Modifies Iron Golem construction to require Refined Vilbiarn Blocks instead of Iron Blocks.
 * <p>
 * Up-to-date for Minecraft version 1.20.6.
 */
@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {
//	@Shadow @Final public static MapCodec<CarvedPumpkinBlock> CODEC;
	
	@Shadow private @Nullable BlockPattern ironGolemPattern;
	
	@Shadow @Final private static Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE;
	
	// TODO: Ensure that this mixin class works without extending 'HorizontalFacingBlock'.
//	/**
//	 * @author BinaryBolias
//	 * @reason The compiler demands this method to be implemented, so I'm just duplicating what the vanilla class does...
//	 */
//	@Overwrite
//	public MapCodec<? extends CarvedPumpkinBlock> getCodec() {
//		return CODEC;
//	}
	

//	// Seemingly superfluous constructor demanded by the compiler...
//	private MixinCarvedPumpkinBlock(Settings settings) {
//		super(settings);
//	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Modifying the returned pattern to check for Refined Vilbiarn Blocks instead of Iron Blocks.
	 */
	@Overwrite
	private BlockPattern getIronGolemPattern() {
		if (ironGolemPattern == null) {
			ironGolemPattern = BlockPatternBuilder.start()
					.aisle("~^~", "###", "~#~")
					.where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE))
					.where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.REFINED_VILBIARN_BLOCK)))
					.where('~', pos -> pos.getBlockState().isAir())
					.build();
		}
		
		return ironGolemPattern;
	}
}
