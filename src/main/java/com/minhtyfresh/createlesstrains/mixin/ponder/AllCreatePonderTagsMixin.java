package com.minhtyfresh.createlesstrains.mixin.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;

import com.tterrag.registrate.util.entry.RegistryEntry;

import net.createmod.catnip.platform.CatnipServices;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;

import net.minecraft.world.level.block.Blocks;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AllCreatePonderTags.class)
public abstract class AllCreatePonderTagsMixin {

	@Final
	@Mutable
	@Shadow(remap = false)
	public static ResourceLocation TRAIN_RELATED;

	@Final
	@Mutable
	@Shadow(remap = false)
	public static ResourceLocation DISPLAY_SOURCES;

	@Final
	@Mutable
	@Shadow(remap = false)
	public static ResourceLocation DISPLAY_TARGETS;

	@Inject(
			method = "register",
			at = @At("HEAD"),
			cancellable = true,
			remap = false
	)
	// register only the ponder indexes related to trains, skip registering other ponders
	private static void ct$registerOnlyTrainPonderTags(PonderTagRegistrationHelper<ResourceLocation> helper, CallbackInfo ci) {
		PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

		PonderTagRegistrationHelper<ItemLike> itemHelper = helper.withKeyFunction(
				CatnipServices.REGISTRIES::getKeyOrThrow);

		helper.registerTag(TRAIN_RELATED)
				.addToIndex()
				.item(AllBlocks.TRACK.get(), true, false)
				.title("Railway Equipment")
				.description("Components used in the construction or management of Trains")
				.register();

		helper.registerTag(DISPLAY_SOURCES)
				.item(AllBlocks.DISPLAY_LINK.get())
				.title("Sources for Display Links")
				.description("Components or Blocks which offer some data that can be read with a Display Link")
				.register();

		helper.registerTag(DISPLAY_TARGETS)
				.item(AllBlocks.DISPLAY_LINK.get())
				.title("Targets for Display Links")
				.description("Components or Blocks which can process and display the data received from a Display Link")
				.register();

		HELPER.addToTag(TRAIN_RELATED)
				.add(AllBlocks.RAILWAY_CASING)
				.add(AllBlocks.TRACK)
				.add(AllBlocks.TRACK_STATION)
				.add(AllItems.SUPER_GLUE)
				.add(AllBlocks.TRAIN_CONTROLS)
				.add(AllBlocks.STEAM_WHISTLE)
				.add(AllBlocks.TRAIN_DOOR)
				.add(AllItems.SCHEDULE)
				.add(AllBlocks.TRACK_SIGNAL)
				.add(AllBlocks.ORANGE_NIXIE_TUBE)
				.add(AllBlocks.TRACK_OBSERVER)
				.add(AllBlocks.DISPLAY_LINK)
				.add(AllBlocks.DISPLAY_BOARD);

		HELPER.addToTag(DISPLAY_SOURCES)
				.add(AllBlocks.SEATS.get(DyeColor.WHITE))
				.add(AllBlocks.ORANGE_NIXIE_TUBE)
				.add(AllBlocks.TRACK_OBSERVER)
				.add(AllBlocks.TRACK_STATION)
				.add(AllBlocks.DISPLAY_LINK);

		itemHelper.addToTag(DISPLAY_SOURCES)
				.add(Blocks.TARGET);

		HELPER.addToTag(DISPLAY_TARGETS)
				.add(AllBlocks.ORANGE_NIXIE_TUBE)
				.add(AllBlocks.DISPLAY_BOARD)
				.add(AllBlocks.DISPLAY_LINK);

		itemHelper.addToTag(DISPLAY_TARGETS)
				.add(Blocks.OAK_SIGN)
				.add(Blocks.LECTERN);

		ci.cancel();
	}

	@Unique
	private static ResourceLocation loc(String id) {
		return Create.asResource(id);
	}

	@Inject(
			method = "<clinit>",
			at = @At("HEAD"),
			cancellable = true,
			remap = false
	)
	private static void ct$clinitOverride(CallbackInfo ci){
		TRAIN_RELATED = loc("train_related");
		DISPLAY_SOURCES = loc("display_sources");
		DISPLAY_TARGETS = loc("display_targets");

		ci.cancel();
	}
}
