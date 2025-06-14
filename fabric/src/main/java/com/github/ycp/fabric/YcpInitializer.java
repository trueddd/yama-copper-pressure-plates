package com.github.ycp.fabric;

import com.github.ycp.CopperPressurePlate;
import com.github.ycp.YamaCopperPlates;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.NotNull;

public class YcpInitializer implements ModInitializer {

    public static final Block COPPER_PLATE = registerBlock(
            new CopperPressurePlate(YamaCopperPlates.COPPER_PLATE_KEY),
            YamaCopperPlates.COPPER_PLATE_KEY
    );

    private static Block registerBlock(Block block, @NotNull RegistryKey<Block> registryKey) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue());
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);
        return Registry.register(Registries.BLOCK, registryKey.getValue(), block);
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
                .register(entries -> entries.add(COPPER_PLATE.asItem()));
    }
}
