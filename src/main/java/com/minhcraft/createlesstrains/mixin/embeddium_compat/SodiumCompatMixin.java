package com.minhcraft.createlesstrains.mixin.embeddium_compat;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.simibubi.create.compat.sodium.SodiumCompat;

import net.fabricmc.fabric.api.event.Event;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SodiumCompat.class)
public abstract class SodiumCompatMixin {

	@WrapWithCondition(
			method = "init",
			at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/event/Event;register(Ljava/lang/Object;)V", ordinal = 1),
			remap = false
	)
	// Disable Sodium compatibility fix for texture atlas saw sprite
	// This feature is only available in the latest Sodium, and this causes a crash when Embeddium is being used instead of Sodium
	// The saw block isn't intended to be used with this mod, so disabling this allows for Embeddium compatibility
	// Flywheel marking itself as breaking with embeddium still needs to be overridden in config/fabric_loader_dependencies.json
	private static <T> boolean ct$disableSodiumTextureAtlasFixSawSprite(Event instance, T t) {
		return false;
	}
}
