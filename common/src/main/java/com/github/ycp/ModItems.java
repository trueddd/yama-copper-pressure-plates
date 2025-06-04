package com.github.ycp;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ModItems {

    @Contract(" -> new")
    public static @NotNull Block createCopperPressurePlate() {
        return new CopperPressurePlate(
                BlockSetType.COPPER,
                AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                        .registryKey(ModRegistryKeys.COPPER_PLATE_KEY)
        );
    }

    public static final Block COPPER_PLATE = registerBlock(
            createCopperPressurePlate(),
            ModRegistryKeys.COPPER_PLATE_KEY
    );

    private static Block registerBlock(Block block, @NotNull RegistryKey<Block> registryKey) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, registryKey.getValue());
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);
        return Registry.register(Registries.BLOCK, registryKey.getValue(), block);
    }

    public static void init() {}
}
