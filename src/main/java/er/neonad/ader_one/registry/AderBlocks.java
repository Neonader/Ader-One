package er.neonad.ader_one.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

import static er.neonad.ader_one.AderOne.MODID;

public class AderBlocks {
   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

   public static final RegistryObject<Block> SPIRIT_PLANKS = registerBlock("spirit_planks",
         () -> new Block(Properties.copy(Blocks.WARPED_PLANKS))
   );

   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean hasItem) {
      RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
      if (hasItem) registerBlockItem(name, registeredBlock);
      return registeredBlock;
   }
// Method overloading makes the default value for hasItem true
   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) { return registerBlock(name, block, true); }

   private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
      return AderItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }

   public static void register(IEventBus eventBus) {
      BLOCKS.register(eventBus);
   }
}
