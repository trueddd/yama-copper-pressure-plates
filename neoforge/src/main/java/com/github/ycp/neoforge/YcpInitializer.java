package com.github.ycp.neoforge;

import com.github.ycp.CopperPressurePlate;
import com.github.ycp.YamaCopperPlates;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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

    public static final DeferredBlock<Block> COPPER_PLATE_BLOCK = BLOCKS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(YamaCopperPlates.COPPER_PLATE_BLOCK_KEY)
    );

    public static final DeferredItem<BlockItem> COPPER_PLATE_ITEM = ITEMS.register(
            YamaCopperPlates.COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    COPPER_PLATE_BLOCK.get(),
                    new Item.Properties().setId(YamaCopperPlates.COPPER_PLATE_ITEM_KEY)
            )
    );

    public YcpInitializer(@NotNull IEventBus eventBus) {
        eventBus.addListener(this::setup);
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
                    COPPER_PLATE_ITEM.toStack(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
