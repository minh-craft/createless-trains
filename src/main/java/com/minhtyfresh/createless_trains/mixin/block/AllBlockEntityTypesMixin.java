package com.minhtyfresh.createless_trains.mixin.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.AllBlockEntityTypes;

import com.simibubi.create.foundation.data.CreateBlockEntityBuilder;

import com.simibubi.create.infrastructure.fabric.SimpleBlockEntityVisualFactory;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.world.level.block.entity.BlockEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;


@Mixin(AllBlockEntityTypes.class)
public abstract class AllBlockEntityTypesMixin {

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lcom/simibubi/create/foundation/data/CreateBlockEntityBuilder;visual(Lcom/tterrag/registrate/util/nullness/NonNullSupplier;)Lcom/simibubi/create/foundation/data/CreateBlockEntityBuilder;"),
			slice = @Slice(
					from = @At(
							value = "FIELD",
							target = "Lcom/simibubi/create/AllBlockEntityTypes;COPYCAT:Lcom/tterrag/registrate/util/entry/BlockEntityEntry;"),
					to = @At(
							value = "FIELD",
							target = "Lcom/simibubi/create/AllBlockEntityTypes;FLAP_DISPLAY:Lcom/tterrag/registrate/util/entry/BlockEntityEntry;")
			),
			remap = false
	)
	// Remove cogs from Display Board by removing ".instance(() -> { return ShaftlessCogwheelInstance::new; })"
	private static <T extends BlockEntity, P> CreateBlockEntityBuilder<T, P> ct$removeCogFromDisplayBoard(CreateBlockEntityBuilder instance, NonNullSupplier<SimpleBlockEntityVisualFactory<T>> visualFactory, Operation<CreateBlockEntityBuilder<T, P>> original) {
		return instance;
	}
}
