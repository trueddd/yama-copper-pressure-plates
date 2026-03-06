package com.github.ycp.neoforge;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

class YcpDataMapProvider extends DataMapProvider {

    protected YcpDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookUpProvider) {
        super(packOutput, lookUpProvider);
    }

    @Override
    protected void gather(HolderLookup.@NotNull Provider arg) {
        var oxidizables = builder(NeoForgeDataMaps.OXIDIZABLES);
        var waxables = builder(NeoForgeDataMaps.WAXABLES);

        oxidizables.add(
                YcpInitializer.COPPER_PLATE_BLOCK.getKey(),
                new Oxidizable(YcpInitializer.EXPOSED_COPPER_PLATE_BLOCK.get()),
                false
        );
        oxidizables.add(
                YcpInitializer.EXPOSED_COPPER_PLATE_BLOCK.getKey(),
                new Oxidizable(YcpInitializer.WEATHERED_COPPER_PLATE_BLOCK.get()),
                false
        );
        oxidizables.add(
                YcpInitializer.WEATHERED_COPPER_PLATE_BLOCK.getKey(),
                new Oxidizable(YcpInitializer.OXIDIZED_COPPER_PLATE_BLOCK.get()),
                false
        );

        waxables.add(
                YcpInitializer.COPPER_PLATE_BLOCK.getKey(),
                new Waxable(YcpInitializer.WAXED_COPPER_PLATE_BLOCK.get()),
                false
        );
        waxables.add(
                YcpInitializer.EXPOSED_COPPER_PLATE_BLOCK.getKey(),
                new Waxable(YcpInitializer.WAXED_EXPOSED_COPPER_PLATE_BLOCK.get()),
                false
        );
        waxables.add(
                YcpInitializer.WEATHERED_COPPER_PLATE_BLOCK.getKey(),
                new Waxable(YcpInitializer.WAXED_WEATHERED_COPPER_PLATE_BLOCK.get()),
                false
        );
        waxables.add(
                YcpInitializer.OXIDIZED_COPPER_PLATE_BLOCK.getKey(),
                new Waxable(YcpInitializer.WAXED_OXIDIZED_COPPER_PLATE_BLOCK.get()),
                false
        );
    }
}
