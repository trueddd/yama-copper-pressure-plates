package com.github.ycp.fabric;

import com.github.ycp.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class YcpInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItems.init();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
                .register(entries -> entries.add(ModItems.COPPER_PLATE.asItem()));
    }
}
