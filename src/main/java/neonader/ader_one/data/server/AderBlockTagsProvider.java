package neonader.ader_one.data.server;

import neonader.ader_one.AderOne;
import neonader.ader_one.common.tag.AderBlockTags;
import neonader.ader_one.registry.AderBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AderBlockTagsProvider extends BlockTagsProvider {
    public AderBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, AderOne.MODID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(AderBlockTags.SPIRIT_STEMS).add(
              AderBlocks.SPIRIT_STEM.get(),
              AderBlocks.SPIRIT_HYPHAE.get(),
              AderBlocks.STRIPPED_SPIRIT_STEM.get(),
              AderBlocks.STRIPPED_SPIRIT_HYPHAE.get()
        );
    }
}
