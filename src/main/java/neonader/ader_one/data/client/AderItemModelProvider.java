package neonader.ader_one.data.client;

import neonader.ader_one.AderOne;
import neonader.ader_one.registry.AderItems;
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

        Set<Item> generatedBlockItems = Set.of(
              getItem("soul_fungus"),
              getItem("soul_turf")
        );
        blockItems.removeAll(generatedBlockItems);

        Set<Item> inventoryItems = Set.of(
              getItem("spirit_fence"),
              getItem("spirit_button")
        );
        blockItems.removeAll(inventoryItems);

        // Specific cases
        blockItems.remove(getItem("spirit_nylium"));
        // TODO: Spirit Nylium model
        blockItems.remove(getItem("spirit_sign"));
        generatedItem(AderItems.SPIRIT_SIGN.get());
        // TODO: Spirit Door

        items.forEach(this::generatedItem);
        blockItems.forEach(this::blockItem);
        generatedBlockItems.forEach(this::generatedBlockItem);
        inventoryItems.forEach(this::inventoryItem);
    }

    private void blockItem(Item item) {
        withExistingParent(name(item), blockLoc(name(item)));
    }

    private void generatedItem(Item item) {
        withExistingParent(name(item), "item/generated")
              .texture("layer0", itemLoc(name(item)));
    }

    private void generatedBlockItem(Item item) {
        withExistingParent(name(item), "item/generated")
              .texture("layer0", blockLoc(name(item)));
    }

    private void inventoryItem(Item fence) {
        withExistingParent(name(fence), blockLoc(name(fence) + "_inventory"));
    }

    private ResourceLocation blockLoc(String name) {
        return new ResourceLocation(AderOne.MODID, "block/" + name);
    }

    private ResourceLocation itemLoc(String name) {
        return new ResourceLocation(AderOne.MODID, "item/" + name);
    }

    private Item getItem(String name) {
        return ForgeRegistries.ITEMS.getValue(modLoc(name));
    }

    private String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
}
