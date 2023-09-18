package neonader.ader_one.common.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;

public class AderNetherStemBlock extends RotatedPillarBlock {
    private final BlockState strippedState;

    public AderNetherStemBlock(Block strippedStem, Properties pProperties) {
        super(pProperties);
        this.strippedState = strippedStem.defaultBlockState();
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState currentState, UseOnContext context, ToolAction action, boolean simulate) {
        if (action != ToolActions.AXE_STRIP) return currentState;
        BlockState newState = this.strippedState;
        for (Property property : currentState.getBlock().getStateDefinition().getProperties())
            if (newState.hasProperty(property) && currentState.getValue(property) != null)
                newState = newState.setValue(property, currentState.getValue(property));
        return newState;
    }
}
