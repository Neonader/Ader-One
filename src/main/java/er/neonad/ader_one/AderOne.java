package er.neonad.ader_one;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import er.neonad.ader_one.registry.AderBlocks;
import er.neonad.ader_one.registry.AderItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static er.neonad.ader_one.AderOne.MODID;
import static er.neonad.ader_one.registry.AderBlocks.*;
import static er.neonad.ader_one.registry.AderItems.*;

@Mod(MODID)
public class AderOne {
    public static final String MODID = "ader_one";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public AderOne() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AderItems.register(modEventBus);
        AderBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::buildContents);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

//  Register the creative mode tab
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(
            new ResourceLocation(MODID, "main"),
            builder -> builder
                .title(Component.translatable(String.format("item_group.%s.main", MODID)))
                .icon(() -> new ItemStack(SPIRIT_SPLINTER.get()))
//              Add items to the CreativeModeTab
                .displayItems((enabledFlags, populator, hasPermissions) -> {
                    populator.accept(SPIRIT_SPLINTER.get());
//                    populator.accept(...);
                })
        );
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
