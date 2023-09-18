package neonader.ader_one.common;

import neonader.ader_one.registry.AderBlocks;
import net.minecraft.data.BlockFamily;

public class AderBlockFamilies {
    public static final BlockFamily SPIRIT_PLANKS_FAMILY = new BlockFamily.Builder(AderBlocks.SPIRIT_PLANKS.get())
          .stairs(AderBlocks.SPIRIT_STAIRS.get())
          .slab(AderBlocks.SPIRIT_SLAB.get())
          .fence(AderBlocks.SPIRIT_FENCE.get())
          .fenceGate(AderBlocks.SPIRIT_FENCE_GATE.get())
          .button(AderBlocks.SPIRIT_BUTTON.get())
          .pressurePlate(AderBlocks.SPIRIT_PRESSURE_PLATE.get())
          .sign(AderBlocks.SPIRIT_SIGN.get(), AderBlocks.SPIRIT_WALL_SIGN.get())
//          .door(AderBlocks.SPIRIT_DOOR.get())
//          .trapdoor(AderBlocks.SPIRIT_TRAPDOOR.get())
          .recipeGroupPrefix("wooden")
          .recipeUnlockedBy("has_planks")
          .getFamily();
}
