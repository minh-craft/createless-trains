package com.minhcraft.createlesstrains;

import com.simibubi.create.CreateBuildInfo;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

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

	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
