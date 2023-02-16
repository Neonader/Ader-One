package neonader.ader_one.registry;

import neonader.ader_one.AderOne;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AderItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AderOne.MODID);

    public static final RegistryObject<Item> SPIRIT_SPLINTER = ITEMS.register("spirit_splinter",
          () -> new Item(new Item.Properties())
    );
}
