package neonader.ader_one.registry;

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

    public static final RegistryObject<Block> SPIRIT_SOIL = registerBlock("spirit_soil",
          () -> new Block(copy(Blocks.SOUL_SOIL))
    );
    public static final RegistryObject<Block> SOUL_NYLIUM = registerBlock("soul_nylium",
          () -> nylium(MaterialColor.WARPED_NYLIUM)
    );
    public static final RegistryObject<Block> SPIRIT_NYLIUM = registerBlock("spirit_nylium",
          () -> nylium(MaterialColor.GOLD)
    );
    public static final RegistryObject<Block> SPIRIT_PLANKS = registerBlock("spirit_planks",
          () -> new Block(of(Material.NETHER_WOOD, MaterialColor.WARPED_STEM)
                .strength(2.0F, 3.0F)
                .sound(SoundType.NETHER_WOOD))
    );
    public static final RegistryObject<Block> SPIRIT_STEM = registerBlock("spirit_stem",
          () -> netherStem(MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> STRIPPED_SPIRIT_STEM = registerBlock("stripped_spirit_stem",
          () -> netherStem(MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> SPIRIT_HYPHAE = registerBlock("spirit_hyphae",
          () -> netherStem(MaterialColor.WARPED_STEM)
    );
    public static final RegistryObject<Block> STRIPPED_SPIRIT_HYPHAE = registerBlock("stripped_spirit_hyphae",
          () -> netherStem(MaterialColor.WARPED_STEM)
    );
    /*public static final RegistryObject<Block> SOUL_FUNGUS = registerBlock("soul_fungus",
          () ->
    );
    public static final RegistryObject<Block> POTTED_SOUL_FUNGUS = registerBlock("potted_soul_fungus",
          () ->
    );
    public static final RegistryObject<Block> SOUL_TURF = registerBlock("soul_turf",
          () ->
    );
    public static final RegistryObject<Block> POTTED_SOUL_TURF = registerBlock("potted_soul_turf",
          () ->
    );*/
    public static final RegistryObject<Block> SPIRIT_SLAB = registerBlock("spirit_slab",
          () -> new SlabBlock(copy(Blocks.WARPED_SLAB))
    );
    public static final RegistryObject<Block> SPIRIT_FENCE = registerBlock("spirit_fence",
          () -> new FenceBlock(copy(Blocks.WARPED_FENCE))
    );
    public static final RegistryObject<Block> SPIRIT_STAIRS = registerBlock("spirit_stairs",
          () -> new StairBlock(
                () -> SPIRIT_PLANKS.get().defaultBlockState(), copy(Blocks.WARPED_PLANKS)
          )
    );
    /*public static final RegistryObject<Block> SOUL_WART_BLOCK = registerBlock("soul_wart_block",
          () -> new Block(copy(WARPED_WART_BLOCK))
    );
    public static final RegistryObject<Block> SPIRIT_BUTTON = registerBlock("spirit_button",
          () ->
    );
    public static final RegistryObject<Block> SPIRIT_PRESSURE_PLATE = registerBlock("spirit_pressure_plate",
          () ->
    );
    public static final RegistryObject<Block> SPIRIT_DOOR = registerBlock("spirit_door",
          () ->
    );
    public static final RegistryObject<Block> SPIRIT_TRAPDOOR = registerBlock("spirit_trapdoor",
          () ->
    );
    public static final RegistryObject<Block> SPIRIT_FENCE_GATE = registerBlock("spirit_fence_gate",
          () -> new FenceGateBlock(
                copy(WARPED_FENCE_GATE),
                SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
                SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN
          )
    );*/

    private static Block netherStem(MaterialColor color) {
        return new RotatedPillarBlock(of(Material.NETHER_WOOD, color)
              .strength(2.0F)
              .sound(SoundType.STEM)
        );
    }

    private static Block nylium(MaterialColor color) {
        return new NyliumBlock(of(Material.STONE, color)
              .requiresCorrectToolForDrops()
              .strength(0.4F)
              .sound(SoundType.NYLIUM)
              .randomTicks()
        );
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        AderItems.ITEMS.register(name,
              () -> new BlockItem(registeredBlock.get(), new Item.Properties())
        );
        return registeredBlock;
    }
}
