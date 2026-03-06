package com.github.ycp.neoforge;

import com.github.ycp.CopperPressurePlate;
import com.github.ycp.WeatheringCopperPressurePlate;
import com.github.ycp.YamaCopperPlates;
import net.minecraft.world.item.*;
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
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable;
import net.neoforged.neoforge.registries.datamaps.builtin.Waxable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

@Mod(YamaCopperPlates.MOD_ID)
public class YcpInitializer {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YamaCopperPlates.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YamaCopperPlates.MOD_ID);

//    public static final Function<WeatheringCopper.WeatherState, Block> CopperPlateBlockFactory = (weatherState ->
//            new CopperPressurePlate(YamaCopperPlates.COPPER_PLATE_BLOCK_KEY, weatherState)
//    );

//    public static final Function<WeatheringCopper.WeatherState, Block> WeatheringCopperPlateBlockFactory = (weatherState ->
//            new WeatheringCopperPressurePlate(YamaCopperPlates.WEATHERING_COPPER_PLATE_BLOCK_KEY, weatherState)
//    );

    // region blocks
    public static final DeferredBlock<Block> COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> new WeatheringCopperPressurePlate(
                    WeatheringCopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.UNAFFECTED
            )
    );
    public static final DeferredBlock<Block> EXPOSED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new WeatheringCopperPressurePlate(
                    WeatheringCopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.EXPOSED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.EXPOSED
            )
    );
    public static final DeferredBlock<Block> WEATHERED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new WeatheringCopperPressurePlate(
                    WeatheringCopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.WEATHERED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.WEATHERED
            )
    );
    public static final DeferredBlock<Block> OXIDIZED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new WeatheringCopperPressurePlate(
                    WeatheringCopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.OXIDIZED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.OXIDIZED
            )
    );
    // endregion

    // region items
    public static final DeferredItem<BlockItem> COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> EXPOSED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    EXPOSED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.EXPOSED_COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> WEATHERED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WEATHERED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.WEATHERED_COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> OXIDIZED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.OXIDIZED_COPPER_PLATE_ITEM_KEY)
            )
    );
    // endregion

    // region waxed blocks
    public static final DeferredBlock<Block> WAXED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(
                    CopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.WAXED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.UNAFFECTED
            )
    );
    public static final DeferredBlock<Block> WAXED_EXPOSED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(
                    CopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.EXPOSED
            )
    );
    public static final DeferredBlock<Block> WAXED_WEATHERED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(
                    CopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.WEATHERED
            )
    );
    public static final DeferredBlock<Block> WAXED_OXIDIZED_COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(
                    CopperPressurePlate.PropertiesFactory.apply(YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_BLOCK_KEY),
                    WeatheringCopper.WeatherState.OXIDIZED
            )
    );
    // endregion

    // region waxed items
    public static final DeferredItem<BlockItem> WAXED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.WAXED_COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> WAXED_EXPOSED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_EXPOSED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_EXPOSED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.WAXED_EXPOSED_COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> WAXED_WEATHERED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_WEATHERED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_WEATHERED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.WAXED_WEATHERED_COPPER_PLATE_ITEM_KEY)
            )
    );
    public static final DeferredItem<BlockItem> WAXED_OXIDIZED_COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.WAXED_OXIDIZED_COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    WAXED_OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.WAXED_OXIDIZED_COPPER_PLATE_ITEM_KEY)
            )
    );
    // endregion

    public YcpInitializer(@NotNull IEventBus eventBus) {
        eventBus.addListener(this::setup);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);

//        eventBus.addListener(this::registerWaxing);

        NeoForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void setup(FMLCommonSetupEvent event) {
    }

    private void registerWaxing(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            HoneycombItem.WAXABLES.get().put(
                    COPPER_PLATE_BLOCK.get(),
                    WAXED_COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAXABLES.get().put(
                    EXPOSED_COPPER_PLATE_BLOCK.get(),
                    WAXED_EXPOSED_COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAXABLES.get().put(
                    WEATHERED_COPPER_PLATE_BLOCK.get(),
                    WAXED_WEATHERED_COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAXABLES.get().put(
                    OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    WAXED_OXIDIZED_COPPER_PLATE_BLOCK.get()
            );

            HoneycombItem.WAX_OFF_BY_BLOCK.get().put(
                    WAXED_COPPER_PLATE_BLOCK.get(),
                    COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAX_OFF_BY_BLOCK.get().put(
                    WAXED_EXPOSED_COPPER_PLATE_BLOCK.get(),
                    EXPOSED_COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAX_OFF_BY_BLOCK.get().put(
                    WAXED_WEATHERED_COPPER_PLATE_BLOCK.get(),
                    WEATHERED_COPPER_PLATE_BLOCK.get()
            );
            HoneycombItem.WAX_OFF_BY_BLOCK.get().put(
                    WAXED_OXIDIZED_COPPER_PLATE_BLOCK.get(),
                    OXIDIZED_COPPER_PLATE_BLOCK.get()
            );
        });
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
