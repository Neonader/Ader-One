package neonader.ader_one;

import com.mojang.logging.LogUtils;
import neonader.ader_one.registry.AderCreativeModeTab;
import neonader.ader_one.registry.AderBlocks;
import org.slf4j.Logger;
import neonader.ader_one.registry.AderItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AderOne.MODID)
public class AderOne {
    public static final String MODID = "ader_one";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AderOne() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AderItems.ITEMS.register(modEventBus);
        AderBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(AderCreativeModeTab::buildContents);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
