package neonader.ader_one;

import neonader.ader_one.data.client.AderBlockStateProvider;
import neonader.ader_one.data.server.AderBlockTagsProvider;
import neonader.ader_one.data.server.AderItemTagsProvider;
import neonader.ader_one.data.server.AderRecipeProvider;
import neonader.ader_one.registry.AderBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import neonader.ader_one.registry.AderItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(AderOne.MODID)
public class AderOne {
    public static final String MODID = "ader_one";

    public AderOne() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        AderItems.ITEMS.register(modEventBus);
        AderBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::buildContents);
    }

    // generate assets and data
    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean runClient = event.includeClient();
        generator.addProvider(runClient, new AderBlockStateProvider(output, helper));

        boolean runServer = event.includeServer();
        AderBlockTagsProvider blockTags = new AderBlockTagsProvider(output, provider, helper);
        generator.addProvider(runServer, blockTags);
        generator.addProvider(runServer, new AderItemTagsProvider(output, provider, blockTags, helper));
        generator.addProvider(runServer, new AderRecipeProvider(output));
    }

    // register the main creative mode tab
    private void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(
              new ResourceLocation(AderOne.MODID, "main"), (builder) -> builder
                    .title(Component.translatable(String.format("item_group.%s.main", AderOne.MODID)))
                    .icon(() -> new ItemStack(AderItems.SPIRIT_SPLINTER.get()))
                    .displayItems((enabledFlags, populator, hasPermissions) -> {
                        populator.accept(AderItems.SPIRIT_SPLINTER.get());
                        populator.accept(AderBlocks.SPIRIT_PLANKS.get());
                        populator.accept(AderBlocks.SOUL_NYLIUM.get());
                        populator.accept(AderBlocks.SPIRIT_NYLIUM.get());
                        populator.accept(AderBlocks.SPIRIT_SOIL.get());
                    })
        );
    }
}
