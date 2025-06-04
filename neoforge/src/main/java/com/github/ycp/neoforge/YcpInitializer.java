package com.github.ycp.neoforge;

import com.github.ycp.CopperPressurePlate;
import com.github.ycp.ModRegistryKeys;
import com.github.ycp.YamaCopperPlates;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

@Mod(YamaCopperPlates.MOD_ID)
public class YcpInitializer {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(YamaCopperPlates.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(YamaCopperPlates.MOD_ID);

    public static final DeferredBlock<Block> COPPER_PLATE_BLOCK = BLOCKS.register(
            ModRegistryKeys.COPPER_PRESSURE_PLATE_ID,
            () -> new CopperPressurePlate(
                    BlockSetType.COPPER,
                    AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                            .registryKey(ModRegistryKeys.COPPER_PLATE_KEY)
            )
    );

    public static final DeferredItem<BlockItem> COPPER_PLATE_ITEM = ITEMS.register(
            ModRegistryKeys.COPPER_PRESSURE_PLATE_ID,
            () -> new BlockItem(
                    COPPER_PLATE_BLOCK.get(),
                    new Item.Settings()
                            .registryKey(ModRegistryKeys.COPPER_PLATE_ITEM_KEY)
            )
    );

    public YcpInitializer(@NotNull IEventBus eventBus) {
        eventBus.addListener(this::setup);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        NeoForge.EVENT_BUS.register(this);
        eventBus.addListener(this::onRegister);
        eventBus.addListener(this::addCreative);
    }

    private void setup(FMLCommonSetupEvent event) {
    }

    private void onRegister(RegisterEvent event) {
        System.out.println("Registered blocks: " + BLOCKS.getEntries());
        System.out.println("Registered items: " + ITEMS.getEntries());
    }

    private void addCreative(@NotNull BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ItemGroups.REDSTONE) {
            event.add(COPPER_PLATE_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = YamaCopperPlates.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
