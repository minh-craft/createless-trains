package com.minhcraft.createlesstrains.mixin.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.AllBlocks;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

import net.minecraft.resources.ResourceKey;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AllBlocks.class)
public abstract class AllBlocksMixin {
	@WrapOperation(
			method = "lambda$static$436(Lnet/minecraft/world/item/DyeColor;)Lcom/tterrag/registrate/util/entry/BlockEntry;",
			at = @At(
				value = "INVOKE",
					target = "Lcom/tterrag/registrate/builders/BlockBuilder;onRegisterAfter(Lnet/minecraft/resources/ResourceKey;Lcom/tterrag/registrate/util/nullness/NonNullConsumer;)Lcom/tterrag/registrate/builders/Builder;"
			)
	)
	// Don't register seat item tooltips
	private static Builder createless_trains$removeSeatItemTooltip(BlockBuilder instance, ResourceKey resourceKey, NonNullConsumer nonNullConsumer, Operation<Builder> original) {
		return original.call(instance, resourceKey, NonNullConsumer.noop());
	}
}
