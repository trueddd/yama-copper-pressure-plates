package com.github.ycp;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class CopperPressurePlate extends PressurePlateBlock {

    public CopperPressurePlate(BlockSetType type, Settings settings) {
        super(type, settings);
    }

    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        Predicate<Entity> predicate = EntityPredicates.EXCEPT_SPECTATOR
                .and(it -> !it.canAvoidTraps() && it.isPlayer());
        return world.getEntitiesByClass(Entity.class, BOX.offset(pos), predicate).size();
    }
}
