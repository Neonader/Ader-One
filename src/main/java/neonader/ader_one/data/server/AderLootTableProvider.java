package neonader.ader_one.data.server;

import neonader.ader_one.AderOne;
import neonader.ader_one.registry.AderItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static neonader.ader_one.registry.AderBlocks.*;
import static neonader.ader_one.registry.AderItems.SPIRIT_SPLINTER;

public class AderLootTableProvider extends LootTableProvider {
    public AderLootTableProvider(PackOutput output, Set<ResourceLocation> tables, List<SubProviderEntry> entries) {
        super(output, tables, entries);
    }

    public static class AderBlockLootSubProvider extends BlockLootSubProvider {
        public AderBlockLootSubProvider() {
            super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(
                  block -> Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getNamespace().equals(AderOne.MODID)
            ).collect(Collectors.toSet());
        }

        @Override
        protected void generate() {
            add(SPIRIT_SOIL.get(), AderBlockLootSubProvider::createSpiritDrops);
            add(SOUL_NYLIUM.get(), AderBlockLootSubProvider::createNyliumDrops);
            add(SPIRIT_NYLIUM.get(), AderBlockLootSubProvider::createNyliumDrops);
            dropSelf(SPIRIT_PLANKS.get());
            dropSelf(SPIRIT_STEM.get());
            dropSelf(STRIPPED_SPIRIT_STEM.get());
            dropSelf(SPIRIT_HYPHAE.get());
            dropSelf(STRIPPED_SPIRIT_HYPHAE.get());
            dropSelf(SOUL_FUNGUS.get());
            dropPottedContents(POTTED_SOUL_FUNGUS.get());
            dropSelf(SOUL_TURF.get());
            dropPottedContents(POTTED_SOUL_TURF.get());
            dropSelf(SPIRIT_SLAB.get());
            dropSelf(SPIRIT_FENCE.get());
            dropSelf(SPIRIT_FENCE_GATE.get());
            dropSelf(SPIRIT_STAIRS.get());
            dropSelf(SOUL_WART_BLOCK.get());
            dropSelf(SPIRIT_PRESSURE_PLATE.get());
            dropSelf(SPIRIT_BUTTON.get());
            dropOther(SPIRIT_SIGN.get(), AderItems.SPIRIT_SIGN.get());
            dropOther(SPIRIT_WALL_SIGN.get(), AderItems.SPIRIT_SIGN.get());
            // door
            // trapdoor
        }

        private static LootTable.Builder createSpiritDrops(Block block) {
            return createSilkTouchDispatchTable(
                  block,
                  LootItem.lootTableItem(SPIRIT_SPLINTER.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        .apply(ApplyExplosionDecay.explosionDecay())
            );
        }

        private static LootTable.Builder createNyliumDrops(Block block) {
            return createSilkTouchDispatchTable(
                  block,
                  LootItem.lootTableItem(Blocks.NETHERRACK)
                        .when(ExplosionCondition.survivesExplosion())
            );
        }
    }
}
