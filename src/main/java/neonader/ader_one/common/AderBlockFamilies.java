package neonader.ader_one.common;

import net.minecraft.data.BlockFamily;

import static neonader.ader_one.registry.AderBlocks.SPIRIT_PLANKS;

public class AderBlockFamilies {
    public static final BlockFamily SPIRIT_PLANKS_FAMILY = new BlockFamily.Builder(
          SPIRIT_PLANKS.get()
    ).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
}
