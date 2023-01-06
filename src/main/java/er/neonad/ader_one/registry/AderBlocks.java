package er.neonad.ader_one.registry;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static er.neonad.ader_one.AderOne.MODID;

public class AderBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
