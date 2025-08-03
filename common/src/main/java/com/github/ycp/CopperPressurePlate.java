package com.github.ycp;

import net.minecraft.core.BlockBox;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CopperPressurePlate extends PressurePlateBlock {

    public CopperPressurePlate(ResourceKey<Block> key) {
        super(
                BlockSetType.COPPER,
                Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE)
                        .mapColor(MapColor.COLOR_ORANGE)
                        .sound(SoundType.METAL)
                        .setId(key)
        );
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos blockPos) {
        Predicate<Entity> predicate = entity -> !entity.isSpectator();
        return level.getEntitiesOfClass(Player.class, BlockBox.of(blockPos).aabb(), predicate).size();
    }

    @Override
    protected @NotNull List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        return Collections.singletonList(new ItemStack(this));
    }
}
