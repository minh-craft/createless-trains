package com.minhcraft.createlesstrains.mixin.automatic_door;

import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorMovementBehaviour;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SlidingDoorMovementBehaviour.class)
public abstract class SlidingDoorMovementBehaviorMixin {

	@ModifyConstant(
			method = "tickOpen",
			constant = @Constant(floatValue = 0.125f),
			remap = false
	)
	private float createless_trains$modifyOpenDoorVolume(float constant) {

		return 1.0F;
	}
}
