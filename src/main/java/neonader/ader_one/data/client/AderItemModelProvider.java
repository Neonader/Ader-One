package neonader.ader_one.data.client;

import neonader.ader_one.AderOne;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.stream.Collectors;

public class AderItemModelProvider extends ItemModelProvider {
    public AderItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AderOne.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(
              item -> ForgeRegistries.ITEMS.getKey(item).getNamespace().equals(AderOne.MODID)
        ).collect(Collectors.toSet());

        Set<Item> blockItems = items.stream().filter(
              item -> item instanceof BlockItem
        ).collect(Collectors.toSet());
        items.removeAll(blockItems);

        // TODO: Spirit Nylium model
        blockItems.remove(ForgeRegistries.ITEMS.getValue(modLoc("spirit_nylium")));

        blockItems.forEach(this::blockItem);
        items.forEach(this::generatedItem);
    }

    private void blockItem(Item item) {
        withExistingParent(name(item), blockLoc(name(item)));
    }

    private void generatedItem(Item item) {
        withExistingParent(name(item), "item/generated")
              .texture("layer0", itemLoc(name(item)));
    }

    private ResourceLocation blockLoc(String name) {
        return new ResourceLocation(AderOne.MODID, "block/" + name);
    }

    private ResourceLocation itemLoc(String name) {
        return new ResourceLocation(AderOne.MODID, "item/" + name);
    }

    private String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
}
