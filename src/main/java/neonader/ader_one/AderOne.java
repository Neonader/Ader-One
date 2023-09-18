package neonader.ader_one;

import neonader.ader_one.common.AderWoodTypes;
import neonader.ader_one.data.client.AderBlockStateProvider;
import neonader.ader_one.data.client.AderItemModelProvider;
import neonader.ader_one.data.server.*;
import neonader.ader_one.registry.AderBlockEntities;
import neonader.ader_one.registry.AderBlocks;
import neonader.ader_one.registry.AderFeatures;
import neonader.ader_one.registry.AderItems;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod(AderOne.MODID)
public class AderOne {
    public static final String MODID = "ader_one";

    public AderOne() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        AderBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        AderBlocks.BLOCKS.register(modEventBus);
        // features
        AderItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::buildContents);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AderBlocks.SOUL_FUNGUS.getId(), AderBlocks.POTTED_SOUL_FUNGUS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(AderBlocks.SOUL_TURF.getId(), AderBlocks.POTTED_SOUL_TURF);
            Sheets.addWoodType(AderWoodTypes.SPIRIT);
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            WoodType.register(AderWoodTypes.SPIRIT);
            BlockEntityRenderers.register(AderBlockEntities.SIGN.get(), SignRenderer::new);
        });
    }

    // generate assets and data
    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean runClient = event.includeClient();
        generator.addProvider(runClient, new AderBlockStateProvider(output, helper));
        generator.addProvider(runClient, new AderItemModelProvider(output, helper));

        AderBlockTagsProvider blockTags = new AderBlockTagsProvider(output, provider, helper);

        boolean runServer = event.includeServer();
        generator.addProvider(runServer, blockTags);
        generator.addProvider(runServer, new AderDatapackBuiltinEntriesProvider(output, event.getLookupProvider(), new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, AderFeatures.CONFIGURED_FEATURES).add(Registries.PLACED_FEATURE, AderFeatures.PLACED_FEATURES)));
        generator.addProvider(runServer, new AderItemTagsProvider(output, provider, blockTags, helper));
        generator.addProvider(runServer, new AderLootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(AderLootTableProvider.AderBlockLootSubProvider::new, LootContextParamSets.BLOCK))));
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
                        populator.accept(AderBlocks.SPIRIT_SOIL.get());
                        populator.accept(AderBlocks.SPIRIT_STEM.get());
                        populator.accept(AderBlocks.SPIRIT_HYPHAE.get());
                        populator.accept(AderBlocks.STRIPPED_SPIRIT_STEM.get());
                        populator.accept(AderBlocks.STRIPPED_SPIRIT_HYPHAE.get());
                        populator.accept(AderBlocks.SPIRIT_PLANKS.get());
                        populator.accept(AderBlocks.SPIRIT_STAIRS.get());
                        populator.accept(AderBlocks.SPIRIT_SLAB.get());
                        populator.accept(AderBlocks.SPIRIT_FENCE.get());
                        populator.accept(AderBlocks.SPIRIT_FENCE_GATE.get());
//                        populator.accept(AderBlocks.SPIRIT_DOOR.get());
//                        populator.accept(AderBlocks.SPIRIT_TRAPDOOR.get());
                        populator.accept(AderBlocks.SPIRIT_PRESSURE_PLATE.get());
                        populator.accept(AderBlocks.SPIRIT_BUTTON.get());
                        populator.accept(AderBlocks.SOUL_NYLIUM.get());
                        populator.accept(AderBlocks.SPIRIT_NYLIUM.get());
                        populator.accept(AderBlocks.SOUL_WART_BLOCK.get());
                        populator.accept(AderBlocks.SOUL_FUNGUS.get());
                        populator.accept(AderBlocks.SOUL_TURF.get());
                        populator.accept(AderBlocks.SPIRIT_SIGN.get());
                    })
        );
    }
}
