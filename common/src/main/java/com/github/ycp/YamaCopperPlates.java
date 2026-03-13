package com.github.ycp;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import org.jetbrains.annotations.NotNull;

public class YamaCopperPlates {

    public static final String MOD_ID = "yama_copper_plates";

    public static final String COPPER_PRESSURE_PLATE_ID = "unwaxed_copper_pressure_plate";
    public static final String EXPOSED_COPPER_PRESSURE_PLATE_ID = "exposed_copper_pressure_plate";
    public static final String WEATHERED_COPPER_PRESSURE_PLATE_ID = "weathered_copper_pressure_plate";
    public static final String OXIDIZED_COPPER_PRESSURE_PLATE_ID = "oxidized_copper_pressure_plate";

    public static final String WAXED_COPPER_PRESSURE_PLATE_ID = "copper_pressure_plate";
    public static final String WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID = "waxed_exposed_copper_pressure_plate";
    public static final String WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID = "waxed_weathered_copper_pressure_plate";
    public static final String WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID = "waxed_oxidized_copper_pressure_plate";

    private static @NotNull ResourceLocation resourceLocationOf(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }

    private static @NotNull ResourceKey<Block> blockKeyOf(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.BLOCK, resourceLocation);
    }

    private static @NotNull ResourceKey<Item> itemKeyOf(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.ITEM, resourceLocation);
    }

    public static final ResourceLocation COPPER_PLATE_KEY = resourceLocationOf(COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation EXPOSED_COPPER_PLATE_KEY = resourceLocationOf(EXPOSED_COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation WEATHERED_COPPER_PLATE_KEY = resourceLocationOf(WEATHERED_COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation OXIDIZED_COPPER_PLATE_KEY = resourceLocationOf(OXIDIZED_COPPER_PRESSURE_PLATE_ID);

    public static final ResourceLocation WAXED_COPPER_PLATE_KEY = resourceLocationOf(WAXED_COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation WAXED_EXPOSED_COPPER_PLATE_KEY = resourceLocationOf(WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation WAXED_WEATHERED_COPPER_PLATE_KEY = resourceLocationOf(WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID);
    public static final ResourceLocation WAXED_OXIDIZED_COPPER_PLATE_KEY = resourceLocationOf(WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID);

    public static final ResourceKey<Block> COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.COPPER_PLATE_KEY);
    public static final ResourceKey<Block> EXPOSED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.EXPOSED_COPPER_PLATE_KEY);
    public static final ResourceKey<Block> WEATHERED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.WEATHERED_COPPER_PLATE_KEY);
    public static final ResourceKey<Block> OXIDIZED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.OXIDIZED_COPPER_PLATE_KEY);

    public static final ResourceKey<Block> WAXED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.WAXED_COPPER_PLATE_KEY);
    public static final ResourceKey<Block> WAXED_EXPOSED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_KEY);
    public static final ResourceKey<Block> WAXED_WEATHERED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_KEY);
    public static final ResourceKey<Block> WAXED_OXIDIZED_COPPER_PLATE_BLOCK_KEY = blockKeyOf(YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_KEY);

    public static final ResourceKey<Item> COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.COPPER_PLATE_KEY);
    public static final ResourceKey<Item> EXPOSED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.EXPOSED_COPPER_PLATE_KEY);
    public static final ResourceKey<Item> WEATHERED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.WEATHERED_COPPER_PLATE_KEY);
    public static final ResourceKey<Item> OXIDIZED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.OXIDIZED_COPPER_PLATE_KEY);

    public static final ResourceKey<Item> WAXED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.WAXED_COPPER_PLATE_KEY);
    public static final ResourceKey<Item> WAXED_EXPOSED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_KEY);
    public static final ResourceKey<Item> WAXED_WEATHERED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_KEY);
    public static final ResourceKey<Item> WAXED_OXIDIZED_COPPER_PLATE_ITEM_KEY = itemKeyOf(YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_KEY);

    private static ResourceKey<Block> blockKeyFor(boolean waxed, WeatheringCopper.@NotNull WeatherState weatherState) {
        return switch (weatherState) {
            case UNAFFECTED -> waxed ? WAXED_COPPER_PLATE_BLOCK_KEY : COPPER_PLATE_BLOCK_KEY;
            case EXPOSED -> waxed ? WAXED_EXPOSED_COPPER_PLATE_BLOCK_KEY : EXPOSED_COPPER_PLATE_BLOCK_KEY;
            case WEATHERED -> waxed ? WAXED_WEATHERED_COPPER_PLATE_BLOCK_KEY : WEATHERED_COPPER_PLATE_BLOCK_KEY;
            case OXIDIZED -> waxed ? WAXED_OXIDIZED_COPPER_PLATE_BLOCK_KEY : OXIDIZED_COPPER_PLATE_BLOCK_KEY;
        };
    }

    @NotNull
    public static Block createCopperPlateBlock(boolean waxed, WeatheringCopper.WeatherState weatherState) {
        var key = blockKeyFor(waxed, weatherState);
        if (waxed) {
            return new CopperPressurePlate(CopperPressurePlate.PropertiesFactory.apply(key), weatherState);
        } else {
            return new WeatheringCopperPressurePlate(WeatheringCopperPressurePlate.PropertiesFactory.apply(key), weatherState);
        }
    }
}
