package binarybolias.tercaphinom.mixin.entity.mob;


import binarybolias.tercaphinom.registry.tag.BlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.Collection;


/**
 * Grrr, Creepers make me so ANGRY!
 * I'm learning how to use mixins a little earlier than anticipated;
 * I simply cannot wait any longer to overhaul this!
 * <p>
 * Reduces entity damage and limits environmental destruction of explosions.<br>
 * Enforces an {@link AreaEffectCloudEntity} to always be produced on explosion,
 * with a default poison status effect when no status effects are active on self.<br>
 * Also makes this entity immune to the poison status effect.
 * <p>
 * Up-to-date for Minecraft version 1.20.6.
 */
@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin extends HostileEntity implements SkinOverlayOwner {
	@Shadow public abstract boolean shouldRenderOverlay();
	
	
	@Shadow private int explosionRadius;
	
	
	// Should this class need a constructor?
	// The compiler gives an error without it, but it doesn't seem necessary for a mixin...
	protected CreeperEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	
	@Override
	public boolean canHaveStatusEffect(StatusEffectInstance effect) {
		// Make immune to poison.
		return !effect.equals(StatusEffects.POISON) && super.canHaveStatusEffect(effect);
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Altering the produced explosion to remove entity damage
	 * and limit environmental destruction to blocks within a specific tag.
	 * <br><br>
	 * Explosion alteration references:<br>
	 * {@link net.minecraft.block.RespawnAnchorBlock}<br>
	 * {@link net.minecraft.entity.vehicle.TntMinecartEntity}
	 */
	@Overwrite
	private void explode() {
		if (!getWorld().isClient) {
			float powerMultiplier = shouldRenderOverlay() ? 2.0F : 1.0F;
			dead = true;
			
			//TODO:
			// - Upon implementation of the Creepvine Crop, the explosion should attempt to plant creepvine.
			//  - Perhaps try planting Creepvine Crops separately from the explosion itself?
			//  - Perhaps use a "Creepvine Spore" entity which floats around to plant a Creepvine Crop where it lands.
			// - Perhaps use a different sound for the explosion.
			
			// Default explosion.
//			getWorld().createExplosion(this, getX(), getY(), getZ(), explosionRadius * powerMultiplier, World.ExplosionSourceType.MOB);
			
			ExplosionBehavior explosionBehavior = getExplosionBehavior();
			// Instantiate an explosion.
			getWorld().createExplosion(
					this,
					Explosion.createDamageSource(getWorld(), this),
					explosionBehavior,
					new Vec3d(getX(), getY(), getZ()),
					explosionRadius * powerMultiplier,
					false,
					World.ExplosionSourceType.MOB
			);
			
			discard();
			spawnEffectsCloud();
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
			
			
//			@Override
//			public boolean shouldDamage(Explosion explosion, Entity entity) {
//				return false;
//			}
			
			//TODO: Override 'getKnockbackModifier' if desirable.
			
			
			@Override
			public float calculateDamage(Explosion explosion, Entity entity) {
				Vec3d origin = explosion.getPosition();
				// The damage dealt if exposure is maximized and distance is minimized.
				float baseDamage = explosion.getPower() * 2.0F;
				// Reduces explosion power. Minimum value of '1.0'.
				float distanceModifier = (float) (Math.sqrt(entity.squaredDistanceTo(origin)) + 1.0F);
				// Explosion power multiplier. Should be a value from '0.0' to '1.0'.
				float exposure = Explosion.getExposure(origin, entity);
				
				return exposure * (baseDamage / distanceModifier);
			}
		};
	}
	
	
	/**
	 * @author BinaryBolias
	 * @reason Making the status effect cloud always be produced, with a default status effect of poison.
	 */
	@Overwrite
	private void spawnEffectsCloud() {
		Collection<StatusEffectInstance> statusEffectsOnSelf = getStatusEffects();
		// Always create a status effect cloud, instead of only when afflicted with a status effect.
		AreaEffectCloudEntity areaEffectCloudEntity = getAreaEffectCloudEntity();
		
		// Populate the cloud with status effects.
		if (statusEffectsOnSelf.isEmpty()) {
			// No status effects on self; default to poison.
			StatusEffectInstance defaultEffect = new StatusEffectInstance(StatusEffects.POISON, 200);
			areaEffectCloudEntity.addEffect(defaultEffect);
		} else {
			// Apply all status effects which are on self.
			for (StatusEffectInstance statusEffectInstance : statusEffectsOnSelf) {
				areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
			}
		}
		
		//TODO:
		// - Perhaps only recognize some status effects as being transferable into the explosion cloud?
		//  - Poison needn't be non-transferable, as this entity is immune to receiving it.
		// - Perhaps fix the status effect duration at a small value?
		//  - Default poison status effect to have the same duration.
		
		getWorld().spawnEntity(areaEffectCloudEntity);
	}
	
	
	@Unique
	private @NotNull AreaEffectCloudEntity getAreaEffectCloudEntity() {
		AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(getWorld(), getX(), getY(), getZ());
//		areaEffectCloudEntity.setRadius(2.5F);
//		areaEffectCloudEntity.setRadius(1.5F * (float) explosionRadius);
		areaEffectCloudEntity.setRadius((float) explosionRadius);
		areaEffectCloudEntity.setRadiusOnUse(-0.5F);
		areaEffectCloudEntity.setWaitTime(10);
//		areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
//		areaEffectCloudEntity.setDuration(300);
		areaEffectCloudEntity.setDuration(480);
//		float growthValue = -areaEffectCloudEntity.getRadius() / ((float) areaEffectCloudEntity.getDuration());
		float growthValue = -(areaEffectCloudEntity.getRadius() / 360.0F);
		areaEffectCloudEntity.setRadiusGrowth(growthValue);
		return areaEffectCloudEntity;
	}
}
