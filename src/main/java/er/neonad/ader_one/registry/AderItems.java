package er.neonad.ader_one.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static er.neonad.ader_one.AderOne.MODID;

public class AderItems {
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

   public static final RegistryObject<Item> SPIRIT_SPLINTER = registerItem("spirit_splinter",
         () -> new Item(new Item.Properties())
   );

   private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
      RegistryObject<Item> registeredItem = ITEMS.register(name, item);
      return registeredItem;
   }

   public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
