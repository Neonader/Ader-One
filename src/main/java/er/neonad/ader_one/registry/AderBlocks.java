package er.neonad.ader_one.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

import static er.neonad.ader_one.AderOne.MODID;
import static net.minecraft.world.level.block.Blocks.*;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.copy;

/*
TODO IMPLEMENTING
 SPIRIT_STEM
 STRIPPED_SPIRIT_STEM
 SPIRIT_HYPHAE
 STRIPPED_SPIRIT_HYPHAE
 SOUL_FUNGUS
 POTTED_SOUL_FUNGUS
 SOUL_TURF
 POTTED_SOUL_TURF
 SPIRIT_BUTTON
 SPIRIT_PRESSURE_PLATE
 SPIRIT_DOOR
 SPIRIT_TRAPDOOR
 SPIRIT_SIGN
 SPIRIT_WALL_SIGN

TODO REGISTERING
 SPIRIT_TORCH
 SPIRIT_CAMPFIRE
 SPIRIT_FIRE

TODO PORTING
 Harvest tools
 Stripping stems
 Huge Soul fungus
 Debug resources/data
*/
public class AderBlocks {
   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

   public static final RegistryObject<Block> SPIRIT_SOIL = registerBlock("spirit_soil",
         () -> new Block(copy(SOUL_SOIL))
   );
   public static final RegistryObject<Block> SOUL_NYLIUM = registerBlock("soul_nylium",
         () -> new Block(copy(WARPED_NYLIUM))
   );
   public static final RegistryObject<Block> SPIRIT_NYLIUM = registerBlock("spirit_nylium",
         () -> new Block(copy(WARPED_NYLIUM))
   );
   public static final RegistryObject<Block> SPIRIT_PLANKS = registerBlock("spirit_planks",
         () -> new Block(copy(WARPED_PLANKS))
   );
   /*
   public static final RegistryObject<Block> SPIRIT_STEM = registerBlock("spirit_stem",
         () ->
   );
   public static final RegistryObject<Block> STRIPPED_SPIRIT_STEM = registerBlock("stripped_spirit_stem",
         () ->
   );
   public static final RegistryObject<Block> SPIRIT_HYPHAE = registerBlock("spirit_hyphae",
         () ->
   );
   public static final RegistryObject<Block> STRIPPED_SPIRIT_HYPHAE = registerBlock("stripped_spirit_hyphae",
         () ->
   );
   public static final RegistryObject<Block> SOUL_FUNGUS = registerBlock("soul_fungus",
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
   );
   */
   public static final RegistryObject<Block> SPIRIT_SLAB = registerBlock("spirit_slab",
         () -> new SlabBlock(copy(WARPED_SLAB))
   );
   public static final RegistryObject<Block> SPIRIT_FENCE = registerBlock("spirit_fence",
         () -> new FenceBlock(copy(WARPED_FENCE))
   );
   public static final RegistryObject<Block> SPIRIT_STAIRS = registerBlock("spirit_stairs",
         () -> new StairBlock(SPIRIT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(WARPED_PLANKS))
   );
   public static final RegistryObject<Block> SOUL_WART_BLOCK = registerBlock("soul_wart_block",
         () -> new Block(copy(WARPED_WART_BLOCK))
   );
   /*
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
   */
   public static final RegistryObject<Block> SPIRIT_FENCE_GATE = registerBlock("spirit_fence_gate",
         () -> new FenceGateBlock(
               copy(WARPED_FENCE_GATE),
               SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
               SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN
         )
   );

// Register the blocks to BLOCKS and optionally to ITEMS
// Return an instance of T
   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean hasItem) {
      RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
      if (hasItem) registerBlockItem(name, registeredBlock);
      return registeredBlock;
   }
// Make the default value hasItem=true by overloading the method
   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) { return registerBlock(name, block, true); }

   private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
      AderItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }

   public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
