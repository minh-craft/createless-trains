package com.minhtyfresh.createlesstrains.mixin.block;

import com.simibubi.create.content.decoration.steamWhistle.WhistleBlockEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WhistleBlockEntity.class)
public abstract class WhistleBlockEntityMixin {

	@Shadow(remap = false)
	protected abstract boolean isPowered();

	@ModifyVariable(
			method = "tick",
			at = @At(value = "STORE", ordinal = 0),
			remap = false
	)
	// whistle powered state no longer relies on fluid tanks or heat sources underneath
	// NOTE: this version has animations that DO work
	private boolean ct$setAlwaysPowerable(boolean value) {
		return this.isPowered();
	}

//	@Inject(
//			method = "tick",
//			at = @At(
//					value = "INVOKE",
//					target = "Lnet/createmod/catnip/animation/LerpedFloat;chase(DDLnet/createmod/catnip/animation/LerpedFloat$Chaser;)Lnet/createmod/catnip/animation/LerpedFloat;"),
//			remap = false
//	)
//	// whistle powered state no longer relies on fluid tanks or heat sources underneath
//	// NOTE: this version has animations that DON'T work
//	private void ct$setAlwaysPowerable(CallbackInfo ci, @Local LocalBooleanRef localRef) {
//		localRef.set(this.isPowered());
//	}
}
