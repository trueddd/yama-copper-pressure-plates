package com.github.ycp;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class WeatheringCopperPressurePlate extends CopperPressurePlate implements WeatheringCopper {

    public static final Function<ResourceKey<Block>, Properties> PropertiesFactory = (key) -> Properties
            .ofFullCopy(Blocks.STONE_PRESSURE_PLATE)
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.METAL)
            .randomTicks()
            .setId(key);

    public WeatheringCopperPressurePlate(Properties properties, WeatheringCopper.WeatherState weatherState) {
        super(properties, weatherState);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        this.changeOverTime(blockState, serverLevel, blockPos, randomSource);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopper.getNext(blockState.getBlock()).isPresent();
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}
