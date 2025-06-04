package com.github.ycp;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModRegistryKeys {

    public static final String COPPER_PRESSURE_PLATE_ID = "copper_pressure_plate";

    public static final RegistryKey<Block> COPPER_PLATE_KEY = RegistryKey.of(
            /* registry = */ RegistryKeys.BLOCK,
            /* value = */ Identifier.of(YamaCopperPlates.MOD_ID, COPPER_PRESSURE_PLATE_ID)
    );
    public static final RegistryKey<Item> COPPER_PLATE_ITEM_KEY = RegistryKey.of(
            /* registry = */ RegistryKeys.ITEM,
            /* value = */ Identifier.of(YamaCopperPlates.MOD_ID, COPPER_PRESSURE_PLATE_ID)
    );
}
