package com.github.ycp.fabric;

import com.github.ycp.YamaCopperPlates;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import org.jetbrains.annotations.NotNull;

public class YcpInitializer implements ModInitializer {

    private @NotNull Block registerBlock(Identifier resourceLocation, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
    }

    private @NotNull Item registerBlockItem(Identifier resourceLocation, ResourceKey<Item> key, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, resourceLocation, new BlockItem(block, new Item.Properties().setId(key)));
    }

    private void registerBlocks() {
        // regular block and items
        Block copperPlateBlock = registerBlock(
                YamaCopperPlates.COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.UNAFFECTED)
        );
        Item copperPlateItem = registerBlockItem(
                YamaCopperPlates.COPPER_PLATE_KEY,
                YamaCopperPlates.COPPER_PLATE_ITEM_KEY,
                copperPlateBlock
        );
        Block exposedCopperPlateBlock = registerBlock(
                YamaCopperPlates.EXPOSED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.EXPOSED)
        );
        Item exposedCopperPlateItem = registerBlockItem(
                YamaCopperPlates.EXPOSED_COPPER_PLATE_KEY,
                YamaCopperPlates.EXPOSED_COPPER_PLATE_ITEM_KEY,
                exposedCopperPlateBlock
        );
        Block weatheredCopperPlateBlock = registerBlock(
                YamaCopperPlates.WEATHERED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.WEATHERED)
        );
        Item weatheredCopperPlateItem = registerBlockItem(
                YamaCopperPlates.WEATHERED_COPPER_PLATE_KEY,
                YamaCopperPlates.WEATHERED_COPPER_PLATE_ITEM_KEY,
                weatheredCopperPlateBlock
        );
        Block oxidizedCopperPlateBlock = registerBlock(
                YamaCopperPlates.OXIDIZED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.OXIDIZED)
        );
        Item oxidizedCopperPlateItem = registerBlockItem(
                YamaCopperPlates.OXIDIZED_COPPER_PLATE_KEY,
                YamaCopperPlates.OXIDIZED_COPPER_PLATE_ITEM_KEY,
                oxidizedCopperPlateBlock
        );

        // waxed blocks and items
        Block waxedCopperPlateBlock = registerBlock(
                YamaCopperPlates.WAXED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.UNAFFECTED)
        );
        Item waxedCopperPlateItem = registerBlockItem(
                YamaCopperPlates.WAXED_COPPER_PLATE_KEY,
                YamaCopperPlates.WAXED_COPPER_PLATE_ITEM_KEY,
                waxedCopperPlateBlock
        );
        Block waxedExposedCopperPlateBlock = registerBlock(
                YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.EXPOSED)
        );
        Item waxedExposedCopperPlateItem = registerBlockItem(
                YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_KEY,
                YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_ITEM_KEY,
                waxedExposedCopperPlateBlock
        );
        Block waxedWeatheredCopperPlateBlock = registerBlock(
                YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.WEATHERED)
        );
        Item waxedWeatheredCopperPlateItem = registerBlockItem(
                YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_KEY,
                YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_ITEM_KEY,
                waxedWeatheredCopperPlateBlock
        );
        Block waxedOxidizedCopperPlateBlock = registerBlock(
                YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_KEY,
                YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.OXIDIZED)
        );
        Item waxedOxidizedCopperPlateItem = registerBlockItem(
                YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_KEY,
                YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_ITEM_KEY,
                waxedOxidizedCopperPlateBlock
        );

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register(entries -> entries.insertAfter(
                        Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                        copperPlateItem.getDefaultInstance(),
                        exposedCopperPlateItem.getDefaultInstance(),
                        weatheredCopperPlateItem.getDefaultInstance(),
                        oxidizedCopperPlateItem.getDefaultInstance(),
                        waxedCopperPlateItem.getDefaultInstance(),
                        waxedExposedCopperPlateItem.getDefaultInstance(),
                        waxedWeatheredCopperPlateItem.getDefaultInstance(),
                        waxedOxidizedCopperPlateItem.getDefaultInstance()
                ));

        OxidizableBlocksRegistry.registerWaxable(copperPlateBlock, waxedCopperPlateBlock);
        OxidizableBlocksRegistry.registerWaxable(exposedCopperPlateBlock, waxedExposedCopperPlateBlock);
        OxidizableBlocksRegistry.registerWaxable(weatheredCopperPlateBlock, waxedWeatheredCopperPlateBlock);
        OxidizableBlocksRegistry.registerWaxable(oxidizedCopperPlateBlock, waxedOxidizedCopperPlateBlock);

        OxidizableBlocksRegistry.registerNextStage(copperPlateBlock, exposedCopperPlateBlock);
        OxidizableBlocksRegistry.registerNextStage(exposedCopperPlateBlock, weatheredCopperPlateBlock);
        OxidizableBlocksRegistry.registerNextStage(weatheredCopperPlateBlock, oxidizedCopperPlateBlock);
    }

    @Override
    public void onInitialize() {
        registerBlocks();
    }
}
