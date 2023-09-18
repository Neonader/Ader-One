package neonader.ader_one.registry;

import neonader.ader_one.common.AderWoodTypes;
import neonader.ader_one.common.block.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static neonader.ader_one.AderOne.MODID;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.copy;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;

public class AderBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> SPIRIT_SOIL = registerBlockWithItem("spirit_soil",
          () -> new Block(copy(Blocks.SOUL_SOIL))
    );
    public static final RegistryObject<Block> SOUL_NYLIUM = registerBlockWithItem("soul_nylium",
          () -> nylium(MaterialColor.WARPED_NYLIUM)
    );
    public static final RegistryObject<Block> SPIRIT_NYLIUM = registerBlockWithItem("spirit_nylium",
          () -> nylium(MaterialColor.GOLD)
    );
    public static final RegistryObject<Block> SPIRIT_PLANKS = registerBlockWithItem("spirit_planks",
          () -> new Block(of(Material.NETHER_WOOD, MaterialColor.WARPED_STEM)
                .strength(2.0F, 3.0F)
                .sound(SoundType.NETHER_WOOD))
    );
    public static final RegistryObject<Block> STRIPPED_SPIRIT_STEM = registerBlockWithItem("stripped_spirit_stem",
          () -> strippedNetherStem(MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> SPIRIT_STEM = registerBlockWithItem("spirit_stem",
          () -> netherStem(STRIPPED_SPIRIT_STEM.get(), MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> STRIPPED_SPIRIT_HYPHAE = registerBlockWithItem("stripped_spirit_hyphae",
          () -> strippedNetherStem(MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> SPIRIT_HYPHAE = registerBlockWithItem("spirit_hyphae",
          () -> netherStem(STRIPPED_SPIRIT_HYPHAE.get(), MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> SOUL_FUNGUS = registerBlockWithItem("soul_fungus",
          () -> new FungusBlock(
                copy(Blocks.WARPED_FUNGUS),
                AderFeatures.SOUL_FUNGUS_PLANTED,
                SOUL_NYLIUM.get()
          )
    );
    public static final RegistryObject<Block> POTTED_SOUL_FUNGUS = BLOCKS.register("potted_soul_fungus",
          () -> new FlowerPotBlock(
                null,
                SOUL_FUNGUS,
                copy(Blocks.POTTED_WARPED_FUNGUS)
          )
    );
    public static final RegistryObject<Block> SOUL_TURF = registerBlockWithItem("soul_turf",
          () -> new RootsBlock(copy(Blocks.WARPED_ROOTS))
    );
    public static final RegistryObject<Block> POTTED_SOUL_TURF = BLOCKS.register("potted_soul_turf",
          () -> new FlowerPotBlock(
                null,
                SOUL_TURF,
                copy(Blocks.POTTED_WARPED_ROOTS)
          )
    );
    public static final RegistryObject<Block> SPIRIT_SLAB = registerBlockWithItem("spirit_slab",
          () -> new SlabBlock(copy(Blocks.WARPED_SLAB))
    );
    public static final RegistryObject<Block> SPIRIT_FENCE = registerBlockWithItem("spirit_fence",
          () -> new FenceBlock(copy(Blocks.WARPED_FENCE))
    );
    public static final RegistryObject<Block> SPIRIT_STAIRS = registerBlockWithItem("spirit_stairs",
          () -> new StairBlock(
                () -> SPIRIT_PLANKS.get().defaultBlockState(),
                copy(Blocks.WARPED_PLANKS)
          )
    );
    public static final RegistryObject<Block> SOUL_WART_BLOCK = registerBlockWithItem("soul_wart_block",
          () -> new Block(copy(Blocks.WARPED_WART_BLOCK))
    );
    public static final RegistryObject<Block> SPIRIT_BUTTON = registerBlockWithItem("spirit_button",
          () -> new ButtonBlock(
                copy(Blocks.WARPED_BUTTON),
                30,
                true,
                SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF,
                SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON
          )
    );
    public static final RegistryObject<Block> SPIRIT_PRESSURE_PLATE = registerBlockWithItem("spirit_pressure_plate",
          () ->new PressurePlateBlock(
                PressurePlateBlock.Sensitivity.EVERYTHING,
                copy(Blocks.WARPED_PRESSURE_PLATE),
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON
          )
    );
    /*public static final RegistryObject<Block> SPIRIT_DOOR = registerBlockWithItem("spirit_door",
          () ->
    );
    public static final RegistryObject<Block> SPIRIT_TRAPDOOR = registerBlockWithItem("spirit_trapdoor",
          () ->
    );*/
    public static final RegistryObject<Block> SPIRIT_SIGN = BLOCKS.register("spirit_sign",
          () -> new AderStandingSignBlock(
                copy(Blocks.WARPED_SIGN),
                AderWoodTypes.SPIRIT
          )
    );
    public static final RegistryObject<Block> SPIRIT_WALL_SIGN = BLOCKS.register("spirit_wall_sign",
          () -> new AderWallSignBlock(
                copy(Blocks.WARPED_SIGN),
                AderWoodTypes.SPIRIT
          )
    );
    public static final RegistryObject<Block> SPIRIT_FENCE_GATE = registerBlockWithItem("spirit_fence_gate",
          () -> new FenceGateBlock(
                copy(Blocks.WARPED_FENCE_GATE),
                SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
                SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN
          )
    );

    private static Block netherStem(Block strippedStem, MaterialColor color) {
        return new AderNetherStemBlock(
              strippedStem,
              copy(Blocks.WARPED_STEM).color(color)
        );
    }

    private static Block strippedNetherStem(MaterialColor color) {
        return new RotatedPillarBlock(copy(Blocks.WARPED_HYPHAE).color(color));
    }

    private static Block nylium(MaterialColor color) {
        return new NyliumBlock(of(Material.STONE, color)
              .requiresCorrectToolForDrops()
              .strength(0.4F)
              .sound(SoundType.NYLIUM)
              .randomTicks()
        );
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        AderItems.ITEMS.register(name,
              () -> new BlockItem(registeredBlock.get(), new Item.Properties())
        );
        return registeredBlock;
    }
}
