package com.github.ycp.neoforge.mixin;

import net.neoforged.neoforge.data.loading.DatagenModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Architectury Loom wraps datagen's {@code main()} in its transformer runtime and never calls
 * {@link System#exit}. NeoForge's data generator also leaves non-daemon service threads alive, so the
 * JVM hangs forever once generation has finished. We force the process to exit so {@code runData}
 * terminates in CI. {@code begin} only runs in the datagen environment, so this is inert in production.
 * <a href="https://github.com/architectury/architectury-loom/issues/189">Original issue</a>
 */
@Mixin(DatagenModLoader.class)
public abstract class DatagenModLoaderMixin {

    @Inject(method = "begin", at = @At("TAIL"), remap = false)
    private static void yama$exitAfterDatagen(CallbackInfo ci) {
        System.exit(0);
    }
}
