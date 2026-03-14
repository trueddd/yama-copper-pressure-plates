package com.github.ycp.neoforge;

import com.github.ycp.YamaCopperPlates;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

@Mod(YamaCopperPlates.MOD_ID)
public class YcpInitializer {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YamaCopperPlates.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YamaCopperPlates.MOD_ID);

    // region blocks
    public static final DeferredBlock<Block> COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.UNAFFECTED)
    );
    public static final DeferredBlock<Block> EXPOSED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.EXPOSED)
    );
    public static final DeferredBlock<Block> WEATHERED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.WEATHERED)
    );
    public static final DeferredBlock<Block> OXIDIZED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ false, WeatheringCopper.WeatherState.OXIDIZED)
    );
    // endregion

    // region items
    public static final DeferredItem<BlockItem> COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    EXPOSED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WEATHERED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    // endregion

    // region waxed blocks
    public static final DeferredBlock<Block> WAXED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.UNAFFECTED)
    );
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.EXPOSED)
    );
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.WEATHERED)
    );
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> YamaCopperPlates.createCopperPlateBlock(/* waxed = */ true, WeatheringCopper.WeatherState.OXIDIZED)
    );
    // endregion

    // region waxed items
    public static final DeferredItem<BlockItem> WAXED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_EXPOSED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_WEATHERED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties()
            )
    );
    // endregion

    public YcpInitializer(@NotNull IEventBus eventBus) {
        eventBus.addListener(this::setup);
        eventBus.addListener(YcpDataGenerator::gatherData);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);

        NeoForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void setup(FMLCommonSetupEvent event) {
    }

    private void addCreative(@NotNull BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    WAXED_OXIDIZED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    WAXED_WEATHERED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    WAXED_EXPOSED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    WAXED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    OXIDIZED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    WEATHERED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    EXPOSED_COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.insertAfter(
                    Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                    COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
