package neonader.ader_one.registry;

import neonader.ader_one.AderOne;
import neonader.ader_one.registry.block.AderBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

import static neonader.ader_one.registry.AderItems.*;

public class AderCreativeModeTab {
    // Register the creative mode tab
    public static void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(
              new ResourceLocation(AderOne.MODID, "main"), (builder) -> builder
                    .title(Component.translatable(String.format("item_group.%s.main", AderOne.MODID)))
                    .icon(() -> new ItemStack(SPIRIT_SPLINTER.get()))
                    .displayItems((enabledFlags, populator, hasPermissions) -> {
                        populator.accept(SPIRIT_SPLINTER.get());
                        /*populator.accept(AderBlocks.SPIRIT_PLANKS.get());
                        populator.accept(AderBlocks.SOUL_NYLIUM.get());
                        populator.accept(AderBlocks.SPIRIT_NYLIUM.get());*/
                        populator.accept(AderBlocks.SPIRIT_SOIL.get());
                    })
        );
    }
}
