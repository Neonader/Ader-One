package neonader.ader_one.registry;

import neonader.ader_one.common.block.entity.AderSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static neonader.ader_one.AderOne.MODID;

public class AderBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<AderSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign",
          () -> BlockEntityType.Builder.of(
                AderSignBlockEntity::new,
                AderBlocks.SPIRIT_SIGN.get(),
                AderBlocks.SPIRIT_WALL_SIGN.get()
          ).build(null)
    );
}
