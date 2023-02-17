package neonader.ader_one.data.server;

import neonader.ader_one.AderOne;
import neonader.ader_one.common.tags.AderBlockTags;
import neonader.ader_one.common.tags.AderItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AderItemTagsProvider extends ItemTagsProvider {
    public AderItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(output, provider, blockTags, AderOne.MODID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.copy(AderBlockTags.SPIRIT_STEMS, AderItemTags.SPIRIT_STEMS);
    }
}
