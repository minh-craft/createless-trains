package com.minhcraft.createlesstrains.mixin.schedule;

import com.simibubi.create.content.trains.schedule.Schedule;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Schedule.class, remap = false)
public class ScheduleMixin {

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void createless_trains$removePackageInstructions(CallbackInfo ci) {
		Schedule.INSTRUCTION_TYPES.removeIf(pair -> {
			String path = pair.getFirst().getPath();
			return path.equals("package_delivery") || path.equals("package_retrieval");
		});
	}
}
