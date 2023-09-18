package neonader.ader_one.data.server;

import neonader.ader_one.AderOne;
import neonader.ader_one.common.tag.AderBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static neonader.ader_one.common.tag.AderItemTags.*;
import static neonader.ader_one.registry.AderBlocks.*;
import static net.minecraft.tags.ItemTags.*;

public class AderItemTagsProvider extends ItemTagsProvider {
    public AderItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(output, provider, blockTags, AderOne.MODID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        // Ader item tags
        copy(AderBlockTags.SPIRIT_STEMS, SPIRIT_STEMS);

        // Vanilla item tags
//        tag(FENCE_GATES).add(SPIRIT_FENCE_GATE.get());
        tag(LOGS).addTag(SPIRIT_STEMS);
        tag(NON_FLAMMABLE_WOOD)
              .add(
                    SPIRIT_STEM.get().asItem(),
                    SPIRIT_HYPHAE.get().asItem(),
                    STRIPPED_SPIRIT_STEM.get().asItem(),
                    STRIPPED_SPIRIT_HYPHAE.get().asItem(),
                    SPIRIT_PLANKS.get().asItem(),
                    SPIRIT_SLAB.get().asItem(),
//                    SPIRIT_PRESSURE_PLATE.get().asItem(),
                    SPIRIT_FENCE.get().asItem(),
//                    SPIRIT_TRAPDOOR.get().asItem(),
//                    SPIRIT_FENCE_GATE.get().asItem(),
                    SPIRIT_STAIRS.get().asItem()//,
//                    SPIRIT_BUTTON.get().asItem(),
//                    SPIRIT_DOOR.get().asItem()
//                    sign
              );
        tag(PLANKS).add(SPIRIT_PLANKS.get().asItem());
        tag(SIGNS).add(SPIRIT_SIGN.get().asItem());
        tag(WART_BLOCKS).add(SOUL_WART_BLOCK.get().asItem());
//        tag(WOODEN_BUTTONS).add(SPIRIT_BUTTON.get().asItem());
//        tag(WOODEN_DOORS).add(SPIRIT_DOOR.get().asItem());
        tag(WOODEN_FENCES).add(SPIRIT_FENCE.get().asItem());
//        tag(WOODEN_PRESSURE_PLATES).add(SPIRIT_PRESSURE_PLATE.get().asItem());
        tag(WOODEN_SLABS).add(SPIRIT_SLAB.get().asItem());
        tag(WOODEN_STAIRS).add(SPIRIT_STAIRS.get().asItem());
//        tag(WOODEN_TRAPDOORS).add(SPIRIT_TRAPDOOR.get().asItem());
    }
    // TODO: Add all tags
}
