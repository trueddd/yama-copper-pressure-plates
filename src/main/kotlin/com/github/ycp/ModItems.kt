package com.github.ycp

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockSetType
import net.minecraft.block.Blocks
import net.minecraft.block.PressurePlateBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {

    val COPPER_PLATE_KEY = RegistryKey.of(
        /* registry = */ RegistryKeys.BLOCK,
        /* value = */ Identifier.of(YamaCopperPlates.MOD_ID, "copper_pressure_plate")
    )
    val COPPER_PLATE = registerBlock(
        block = CopperPressurePlate(
            type = BlockSetType.COPPER,
            settings = AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                .registryKey(COPPER_PLATE_KEY),
        ),
        registryKey = COPPER_PLATE_KEY,
    )

    private fun registerBlock(block: Block, registryKey: RegistryKey<Block>): Block {
        val itemKey = RegistryKey.of(RegistryKeys.ITEM, registryKey.value)
        val blockItem = BlockItem(block, Item.Settings().registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, blockItem)
        return Registry.register(Registries.BLOCK, registryKey.value, block)
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
            .register(ItemGroupEvents.ModifyEntries { it.add(COPPER_PLATE.asItem()) })
    }
}
