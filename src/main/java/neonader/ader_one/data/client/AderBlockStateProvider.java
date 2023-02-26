package neonader.ader_one.data.client;

import neonader.ader_one.AderOne;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static neonader.ader_one.registry.AderBlocks.*;

public class AderBlockStateProvider extends BlockStateProvider {
    public AderBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, AderOne.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(SPIRIT_SOIL.get());
        // TODO: Spirit Planks block family
        nyliumBlock(SOUL_NYLIUM.get());
        // TODO: Spirit Nylium connected texture
        logBlock((RotatedPillarBlock) SPIRIT_STEM.get());
        woodBlock((RotatedPillarBlock) SPIRIT_HYPHAE.get(), SPIRIT_STEM.get());
        logBlock((RotatedPillarBlock) STRIPPED_SPIRIT_STEM.get());
        woodBlock((RotatedPillarBlock) STRIPPED_SPIRIT_HYPHAE.get(), STRIPPED_SPIRIT_STEM.get());
    }

    private void woodBlock(RotatedPillarBlock woodBlock, Block logBlock) {
        axisBlock(
              woodBlock,
              blockTexture(logBlock),
              blockTexture(logBlock)
        );
    }

    private void nyliumBlock(Block block) {
        simpleBlock(block,
              models().cubeBottomTop(
                    name(block),
                    extend(blockTexture(block), "_side"),
                    blockTexture(Blocks.NETHERRACK),
                    blockTexture(block)
              )
        );
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
