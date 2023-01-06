package er.neonad.ader_one.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static er.neonad.ader_one.AderOne.MODID;

public class AderItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

//  Spirit Splinter
    public static final RegistryObject<Item> SPIRIT_SPLINTER = ITEMS.register(
        "spirit_splinter",
        () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
