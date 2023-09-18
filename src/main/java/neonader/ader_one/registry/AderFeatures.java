package neonader.ader_one.registry;

import net.minecraft.core.RegistrySetBuilder.RegistryBootstrap;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class AderFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_FUNGUS = FeatureUtils.createKey("soul_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_FUNGUS_PLANTED = FeatureUtils.createKey("soul_fungus_planted");

    public static final RegistryBootstrap<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = bootstrap -> {
        bootstrap.register(
              SOUL_FUNGUS,
              new ConfiguredFeature<>(
                    Feature.HUGE_FUNGUS,
                    new HugeFungusConfiguration(
                          AderBlocks.SOUL_NYLIUM.get().defaultBlockState(),
                          AderBlocks.SPIRIT_STEM.get().defaultBlockState(),
                          AderBlocks.SOUL_WART_BLOCK.get().defaultBlockState(),
                          Blocks.GLOWSTONE.defaultBlockState(),
                          false
                    )
              )
        );
        bootstrap.register(
              SOUL_FUNGUS_PLANTED,
              new ConfiguredFeature<>(
                    Feature.HUGE_FUNGUS,
                    new HugeFungusConfiguration(
                          AderBlocks.SOUL_NYLIUM.get().defaultBlockState(),
                          AderBlocks.SPIRIT_STEM.get().defaultBlockState(),
                          AderBlocks.SOUL_WART_BLOCK.get().defaultBlockState(),
                          Blocks.GLOWSTONE.defaultBlockState(),
                          true
                    )
              )
        );
    };
    public static final RegistryBootstrap<PlacedFeature> PLACED_FEATURES = bootstrap -> {
        // TODO: spirit forest vegetation
        // TODO: soul fungi
    };
}
