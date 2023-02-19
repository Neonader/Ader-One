package neonader.ader_one.common.tag;

import neonader.ader_one.AderOne;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AderItemTags {
    public static final TagKey<Item> SPIRIT_STEMS = itemTag("spirit_stems");

    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(AderOne.MODID, name));
    }
}
