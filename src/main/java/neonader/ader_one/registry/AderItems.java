package neonader.ader_one.registry;

import neonader.ader_one.AderOne;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AderItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AderOne.MODID);

    public static final RegistryObject<Item> SPIRIT_SPLINTER = registerItem("spirit_splinter",
          () -> new Item(new Item.Properties())
    );

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return AderItems.ITEMS.register(name, item);
    }
}
