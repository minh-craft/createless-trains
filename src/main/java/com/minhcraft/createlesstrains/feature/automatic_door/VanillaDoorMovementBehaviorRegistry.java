package com.minhcraft.createlesstrains.feature.automatic_door;

import com.simibubi.create.api.behaviour.movement.MovementBehaviour;

import net.minecraft.world.level.block.Blocks;

public class VanillaDoorMovementBehaviorRegistry {

	// Make it so vanilla doors open and close automatically on trains, just like Create's train doors and framed glass doors
	public static void init() {
		MovementBehaviour.REGISTRY.register(
				Blocks.OAK_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.IRON_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.SPRUCE_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.BIRCH_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.JUNGLE_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.DARK_OAK_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.CRIMSON_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.ACACIA_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.BAMBOO_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.CHERRY_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.MANGROVE_DOOR, new VanillaDoorMovementBehavior());
		MovementBehaviour.REGISTRY.register(
				Blocks.WARPED_DOOR, new VanillaDoorMovementBehavior());
	}
}
