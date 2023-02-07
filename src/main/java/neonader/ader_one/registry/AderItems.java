package neonader.ader_one.registry;

import neonader.ader_one.AderOne;
import neonader.ader_one.registry.block.AderBlocks;
import net.minecraft.world.item.BlockItem;
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

    public static final RegistryObject<Item> SPIRIT_SOIL = registerItem("soul_soil",
          () -> new BlockItem(AderBlocks.SPIRIT_SOIL.get(), new Item.Properties()));

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
}
