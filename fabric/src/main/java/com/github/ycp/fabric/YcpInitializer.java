package com.github.ycp.fabric;

import com.github.ycp.CopperPressurePlate;
import com.github.ycp.YamaCopperPlates;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class YcpInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                YamaCopperPlates.COPPER_PLATE_KEY,
                new CopperPressurePlate(YamaCopperPlates.COPPER_PLATE_BLOCK_KEY)
        );
        Item item = Registry.register(
                BuiltInRegistries.ITEM,
                YamaCopperPlates.COPPER_PLATE_KEY,
                new BlockItem(block, new Item.Properties().setId(YamaCopperPlates.COPPER_PLATE_ITEM_KEY))
        );

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register(entries -> entries.addAfter(
                        Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                        item.getDefaultInstance()
                ));
    }
}
