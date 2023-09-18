package neonader.ader_one.data.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static neonader.ader_one.AderOne.MODID;

public class AderDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    public AderDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder) {
        super(output, registries, builder, Set.of(MODID));
    }
}
