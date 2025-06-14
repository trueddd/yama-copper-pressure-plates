package com.github.ycp;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CopperPressurePlate extends PressurePlateBlock {

    public CopperPressurePlate(RegistryKey<Block> key) {
        this(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                .mapColor(MapColor.ORANGE)
                .sounds(BlockSoundGroup.METAL)
                .registryKey(key));
    }

    public CopperPressurePlate(BlockSetType type, Settings settings) {
        super(type, settings);
    }

    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        Predicate<Entity> predicate = EntityPredicates.EXCEPT_SPECTATOR
                .and(it -> !it.canAvoidTraps() && it.isPlayer());
        return world.getEntitiesByClass(Entity.class, BOX.offset(pos), predicate).size();
    }

    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootWorldContext.Builder builder) {
        return Collections.singletonList(new ItemStack(this));
    }
}
