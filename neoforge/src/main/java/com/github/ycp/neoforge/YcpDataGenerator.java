package com.github.ycp.neoforge;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

public class YcpDataGenerator {

    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        event.createProvider(YcpDataMapProvider::new);
    }
}
