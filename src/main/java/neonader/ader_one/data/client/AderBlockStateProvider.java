package neonader.ader_one.data.client;

import neonader.ader_one.AderOne;
import neonader.ader_one.common.AderBlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Objects;

import static neonader.ader_one.registry.AderBlocks.*;

public class AderBlockStateProvider extends BlockStateProvider {
    public AderBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, AderOne.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(SPIRIT_SOIL.get());
        blockFamily(AderBlockFamilies.SPIRIT_PLANKS_FAMILY);
        nyliumBlock(SOUL_NYLIUM.get());
        // TODO: Spirit Nylium model
        logBlock((RotatedPillarBlock) SPIRIT_STEM.get());
        woodBlock((RotatedPillarBlock) SPIRIT_HYPHAE.get(), SPIRIT_STEM.get());
        logBlock((RotatedPillarBlock) STRIPPED_SPIRIT_STEM.get());
        woodBlock((RotatedPillarBlock) STRIPPED_SPIRIT_HYPHAE.get(), STRIPPED_SPIRIT_STEM.get());
        crossBlock(SOUL_FUNGUS.get());
        pottedBlock("soul_fungus", POTTED_SOUL_FUNGUS.get());
        crossBlock(SOUL_TURF.get());
        pottedBlock("soul_turf_pot", POTTED_SOUL_TURF.get());
        simpleBlock(SOUL_WART_BLOCK.get());
    }

    private void blockFamily(BlockFamily family) {
        Block baseBlock = family.getBaseBlock();
        Map<Variant, Block> variants = family.getVariants();

        simpleBlock(baseBlock);

        if (variants.containsKey(Variant.BUTTON)) {
            ButtonBlock buttonVariant = (ButtonBlock) family.get(Variant.BUTTON);
            buttonBlock(
                  buttonVariant,
                  models().withExistingParent(
                        name(buttonVariant),
                        "block/button"
                  ).texture("texture", blockTexture(baseBlock)),
                  models().withExistingParent(
                        name(buttonVariant) + "_pressed",
                        "block/button_pressed"
                  ).texture("texture", blockTexture(baseBlock))
            );
            models().withExistingParent(
                  name(buttonVariant) + "_inventory",
                  "block/button_inventory"
            ).texture("texture", blockTexture(baseBlock));
        }

        if (variants.containsKey(Variant.DOOR)) {
            DoorBlock doorVariant = (DoorBlock) family.get(Variant.DOOR);
            doorBlock(doorVariant, extend(blockTexture(doorVariant), "_bottom"), extend(blockTexture(doorVariant), "_top"));
        }

        if (variants.containsKey(Variant.FENCE)) {
            FenceBlock fenceVariant = (FenceBlock) family.get(Variant.FENCE);
            fenceBlock(fenceVariant, blockTexture(baseBlock));
            models().withExistingParent(
                  name(fenceVariant) + "_inventory",
                  "block/fence_inventory"
            ).texture("texture", blockTexture(baseBlock));
        }

        if (variants.containsKey(Variant.FENCE_GATE)) {
            FenceGateBlock fenceGateVariant = (FenceGateBlock) family.get(Variant.FENCE_GATE);
            fenceGateBlock(fenceGateVariant, blockTexture(baseBlock));
        }

        if (variants.containsKey(Variant.SIGN)) {
            SignBlock signVariant = (SignBlock) family.get(Variant.SIGN);
            simpleBlock(
                  signVariant,
                  models().getBuilder(
                        name(signVariant)
                  ).texture("particle", blockTexture(baseBlock))
            );
        }

        if (variants.containsKey(Variant.SLAB)) {
            SlabBlock slabVariant = (SlabBlock) family.get(Variant.SLAB);
            slabBlock(slabVariant, blockTexture(baseBlock), blockTexture(baseBlock));
        }

        if (variants.containsKey(Variant.STAIRS)) {
            StairBlock stairsVariant = (StairBlock) family.get(Variant.STAIRS);
            stairsBlock(stairsVariant, blockTexture(baseBlock));
        }

        if (variants.containsKey(Variant.PRESSURE_PLATE)) {
            PressurePlateBlock pressurePlateVariant = (PressurePlateBlock) family.get(Variant.PRESSURE_PLATE);
            pressurePlateBlock(
                  pressurePlateVariant,
                  models().withExistingParent(
                        name(pressurePlateVariant),
                        "block/pressure_plate_up"
                  ).texture("texture", blockTexture(baseBlock)),
                  models().withExistingParent(
                        name(pressurePlateVariant) + "_down",
                        "block/pressure_plate_down"
                  ).texture("texture", blockTexture(baseBlock))
            );
        }

        if (variants.containsKey(Variant.TRAPDOOR)) {
            TrapDoorBlock trapdoorVariant = (TrapDoorBlock) family.get(Variant.TRAPDOOR);
            trapdoorBlock(trapdoorVariant, blockTexture(trapdoorVariant), true);
        }

        if (variants.containsKey(Variant.WALL_SIGN)) {
            WallSignBlock wallSignVariant = (WallSignBlock) family.get(Variant.WALL_SIGN);
            simpleBlock(
                  wallSignVariant,
                  models().getBuilder(
                        name(wallSignVariant)
                  ).texture("particle", blockTexture(baseBlock))
            );
        }
    }

    private void crossBlock(Block block) {
        simpleBlock(block, models().withExistingParent(
              name(block),
              "block/cross"
        ).texture("cross", blockTexture(block)).renderType("minecraft:cutout"));
    }

    private void pottedBlock(String plantTexture, Block block) {
        simpleBlock(block, models().withExistingParent(
              name(block),
              "block/flower_pot_cross"
        ).texture("plant", modLoc("block/" + plantTexture)).renderType("minecraft:cutout"));
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
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
