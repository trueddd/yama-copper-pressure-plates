package com.github.ycp

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object YamaCopperPlates : ModInitializer {

	const val MOD_ID = "yama_copper_plates"

    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		ModItems.initialize()
	}
}
