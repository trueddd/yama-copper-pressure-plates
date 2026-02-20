package com.github.ycp;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public final class WeatheringCopperPressurePlate extends CopperPressurePlate implements WeatheringCopper {

    public static final MapCodec<WeatheringCopperFullBlock> CODEC = RecordCodecBuilder
            .mapCodec((instance) ->
                    instance.group(
                            WeatheringCopper.WeatherState.CODEC
                                    .fieldOf("weathering_state")
                                    .forGetter(ChangeOverTimeBlock::getAge),
                            propertiesCodec()
                    ).apply(instance, WeatheringCopperFullBlock::new));

    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperPressurePlate(ResourceKey<Block> key, WeatheringCopper.WeatherState weatherState) {
        super(key);
        this.weatherState = weatherState;
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
