package neonader.ader_one.common.block.entity;

import neonader.ader_one.registry.AderBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AderSignBlockEntity extends SignBlockEntity {
    public AderSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(AderBlockEntities.SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AderBlockEntities.SIGN.get();
    }
}
