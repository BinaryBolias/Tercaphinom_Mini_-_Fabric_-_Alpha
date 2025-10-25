package binarybolias.tercaphinom.mixin.entity.projectile;


import binarybolias.tercaphinom.registry.tag.BlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;


/**
 * Limits the environmental destruction of explosions.
 * <p>
 * Up-to-date for Minecraft version 1.20.6.
 */
@Mixin(FireballEntity.class)
public class FireballEntityMixin extends AbstractFireballEntity {
	@Shadow private int explosionPower;
	
	
	// Seemingly superfluous constructor...
	public FireballEntityMixin(EntityType<? extends AbstractFireballEntity> entityType, World world) {
		super(entityType, world);
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Reducing terrain destruction of explosion. To only affect the same block types as Creepers.
	 */
	@Overwrite
	public void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!getWorld().isClient) {
			// Use modified explosion behavior to limit which blocks are susceptible to being destroyed.
			// Otherwise designed to be identical to original.
			//TODO: Not spreading fire? Fix.
			// - Due to lack of block destruction?
			// - Test: Do fireball explosions which destroy blocks within the whitelist (e.g flowers) create fire?
			// - Perhaps will work with increased explosion power?
			getWorld().createExplosion(
					this,
					Explosion.createDamageSource(getWorld(), this),
					getExplosionBehavior(),
					getX(),
					getY(),
					getZ(),
					(float) explosionPower,
					true,
					World.ExplosionSourceType.MOB,
					ParticleTypes.EXPLOSION,
					ParticleTypes.EXPLOSION_EMITTER,
					SoundEvents.ENTITY_GENERIC_EXPLODE
			);
			discard();
		}
	}
	
	
	@Unique
	private @NotNull ExplosionBehavior getExplosionBehavior() {
		// Custom explosion behavior with an anonymous class.
		return new ExplosionBehavior() {
			@Override
			public boolean canDestroyBlock(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float power) {
				return world.getBlockState(pos).isIn(BlockTags.VULNERABLE_TO_CREEPER_EXPLOSION);
			}
		};
	}
}
