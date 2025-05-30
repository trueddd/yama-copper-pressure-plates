package com.github.ycp;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class YamaCopperPlates {

    public static final String MOD_ID = "yama_copper_plates";

    public static final String COPPER_PRESSURE_PLATE_ID = "copper_pressure_plate";

    public static final ResourceLocation COPPER_PLATE_KEY = ResourceLocation
            .fromNamespaceAndPath(MOD_ID, COPPER_PRESSURE_PLATE_ID);

    public static final ResourceKey<Block> COPPER_PLATE_BLOCK_KEY = ResourceKey.create(
            Registries.BLOCK,
            YamaCopperPlates.COPPER_PLATE_KEY
    );

    public static final ResourceKey<Item> COPPER_PLATE_ITEM_KEY = ResourceKey.create(
            Registries.ITEM,
            YamaCopperPlates.COPPER_PLATE_KEY
    );
}
