package er.neonad.ader_one.registry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

import static er.neonad.ader_one.AderOne.MODID;
import static er.neonad.ader_one.registry.AderBlocks.*;
import static er.neonad.ader_one.registry.AderItems.*;

public class AderCreativeModeTab {
// Register the creative mode tab
   public static void buildContents(CreativeModeTabEvent.Register event) {
      event.registerCreativeModeTab(
            new ResourceLocation(MODID, "main"),
            (builder) -> builder
                  .title(Component.translatable(String.format("item_group.%s.main", MODID)))
                  .icon(() -> new ItemStack(SPIRIT_SPLINTER.get()))
                  .displayItems((enabledFlags, populator, hasPermissions) -> {
                     populator.accept(SPIRIT_SPLINTER.get());
                     populator.accept(SPIRIT_PLANKS.get());
                     populator.accept(SPIRIT_STAIRS.get());
                     populator.accept(SPIRIT_SLAB.get());
                     populator.accept(SPIRIT_FENCE.get());
                     populator.accept(SPIRIT_FENCE_GATE.get());
                     populator.accept(SOUL_NYLIUM.get());
                     populator.accept(SPIRIT_NYLIUM.get());
                     populator.accept(SPIRIT_SOIL.get());
                  })
      );
   }
}
