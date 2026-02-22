package com.minhcraft.createlesstrains.feature.automatic_door;

import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlockEntity;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorMovementBehaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class VanillaDoorMovementBehavior extends SlidingDoorMovementBehaviour {

	@Override
	public void tick(MovementContext context) {
		StructureTemplate.StructureBlockInfo info = context.contraption.getBlocks().get(context.localPos);
		if (info == null) return;

		boolean wasOpen = SlidingDoorBlockEntity.isOpen(info.state());

		if (!context.world.isClientSide())
			tickOpen(context, wasOpen);

		// Re-read state after tickOpen may have toggled it
		info = context.contraption.getBlocks().get(context.localPos);
		if (info == null) return;
		boolean nowOpen = SlidingDoorBlockEntity.isOpen(info.state());

		if (wasOpen && !nowOpen) {
			context.world.playSound(null, BlockPos.containing(context.position),
					SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1.0f, 1f);
		}
	}
}
