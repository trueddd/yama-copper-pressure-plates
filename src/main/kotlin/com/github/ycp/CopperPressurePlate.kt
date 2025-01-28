package com.github.ycp

import net.minecraft.block.BlockSetType
import net.minecraft.block.PressurePlateBlock
import net.minecraft.entity.Entity
import net.minecraft.predicate.entity.EntityPredicates
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class CopperPressurePlate(
    type: BlockSetType,
    settings: Settings
) : PressurePlateBlock(type, settings) {

    override fun getRedstoneOutput(world: World, pos: BlockPos): Int {
        return world.getEntitiesByClass(
            Entity::class.java,
            BOX.offset(pos),
            EntityPredicates.EXCEPT_SPECTATOR
                .and { !it.canAvoidTraps() }
                .and { it.isPlayer }
        ).size
    }
}
