package neonader.ader_one.data.server;

import neonader.ader_one.common.tag.AderItemTags;
import neonader.ader_one.registry.AderBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class AderRecipeProvider extends RecipeProvider {
    public AderRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        planksFromLogs(consumer, AderBlocks.SPIRIT_PLANKS.get(), AderItemTags.SPIRIT_STEMS, 4);
        stairBuilder(AderBlocks.SPIRIT_STAIRS.get(), Ingredient.of(AderBlocks.SPIRIT_PLANKS.get()));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, AderBlocks.SPIRIT_SLAB.get(), Ingredient.of(AderBlocks.SPIRIT_PLANKS.get()));
        fenceBuilder(AderBlocks.SPIRIT_FENCE.get(), Ingredient.of(AderBlocks.SPIRIT_PLANKS.get()));
    }
}
