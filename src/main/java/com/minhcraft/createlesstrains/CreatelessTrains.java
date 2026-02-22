package com.minhcraft.createlesstrains;

import com.simibubi.create.CreateBuildInfo;

import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorMovementBehaviour;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.block.Blocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatelessTrains implements ModInitializer {
	public static final String MOD_ID = "createless-trains";
	public static final String NAME = "Createless Trains";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, CreateBuildInfo.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);

		FabricLoader
				.getInstance()
				.getModContainer(MOD_ID)
				.ifPresent(
						modContainer ->
								ResourceManagerHelper.registerBuiltinResourcePack(CreatelessTrains.id(MOD_ID), modContainer, ResourcePackActivationType.ALWAYS_ENABLED));


		// Make it so vanilla doors open and close automatically on trains, just like create's train doors and framed glass doors
		MovementBehaviour.REGISTRY.register(
				Blocks.OAK_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.IRON_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.SPRUCE_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.BIRCH_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.JUNGLE_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.DARK_OAK_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.CRIMSON_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.ACACIA_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.BAMBOO_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.CHERRY_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.MANGROVE_DOOR, new SlidingDoorMovementBehaviour());
		MovementBehaviour.REGISTRY.register(
				Blocks.WARPED_DOOR, new SlidingDoorMovementBehaviour());
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
