package neonader.ader_one.data.server;

import neonader.ader_one.AderOne;
import neonader.ader_one.common.AderBlockFamilies;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static neonader.ader_one.common.tag.AderBlockTags.*;
import static neonader.ader_one.registry.AderBlocks.*;
import static net.minecraft.tags.BlockTags.*;

public class AderBlockTagsProvider extends BlockTagsProvider {
    public AderBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
        super(output, provider, AderOne.MODID, helper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        // Ader block tags
        tag(SPIRIT_STEMS).add(
              SPIRIT_STEM.get(),
              SPIRIT_HYPHAE.get(),
              STRIPPED_SPIRIT_STEM.get(),
              STRIPPED_SPIRIT_HYPHAE.get()
        );

        // Vanilla block tags
        tag(ENDERMAN_HOLDABLE).add(
              SOUL_FUNGUS.get(),
              SOUL_NYLIUM.get(),
              SPIRIT_NYLIUM.get(),
              SOUL_TURF.get()
        );
        tag(MINEABLE_WITH_AXE).addTag(SPIRIT_STEMS);
        tag(MINEABLE_WITH_HOE).add(SOUL_WART_BLOCK.get());
        tag(MINEABLE_WITH_AXE).add(AderBlockFamilies.SPIRIT_PLANKS_FAMILY.getVariants().values().toArray(new Block[0]));
        tag(MINEABLE_WITH_PICKAXE).add(
              SOUL_NYLIUM.get(),
              SPIRIT_NYLIUM.get()
        );
        tag(MINEABLE_WITH_SHOVEL).add(SPIRIT_SOIL.get());
        tag(FENCE_GATES).add(SPIRIT_FENCE_GATE.get());
        tag(LOGS).addTag(SPIRIT_STEMS);
        tag(MUSHROOM_GROW_BLOCK).add(
              SOUL_NYLIUM.get(),
              SPIRIT_NYLIUM.get()
        );
        tag(NYLIUM).add(
              SOUL_NYLIUM.get(),
              SPIRIT_NYLIUM.get()
        );
        tag(PLANKS).add(SPIRIT_PLANKS.get());
        tag(STANDING_SIGNS).add(SPIRIT_SIGN.get());
        tag(WALL_SIGNS).add(SPIRIT_WALL_SIGN.get());
        tag(WART_BLOCKS).add(SOUL_WART_BLOCK.get());
        tag(WOODEN_BUTTONS).add(SPIRIT_BUTTON.get());
//        tag(WOODEN_DOORS).add(SPIRIT_DOOR.get());
        tag(WOODEN_FENCES).add(SPIRIT_FENCE.get());
        tag(WOODEN_PRESSURE_PLATES).add(SPIRIT_PRESSURE_PLATE.get());
        tag(WOODEN_SLABS).add(SPIRIT_SLAB.get());
        tag(WOODEN_STAIRS).add(SPIRIT_STAIRS.get());
//        tag(WOODEN_TRAPDOORS).add(SPIRIT_TRAPDOOR.get());
    }
    // TODO: Add all tags
}
