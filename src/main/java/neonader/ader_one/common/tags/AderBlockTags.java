package neonader.ader_one.common.tags;

import neonader.ader_one.AderOne;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class AderBlockTags {
    public static final TagKey<Block> SPIRIT_STEMS = blockTag("spirit_stems");

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(AderOne.MODID, name));
    }
}
