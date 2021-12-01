package ag.ag.blocks.entities;

import ag.ag.Ag;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class GeneratorEntity extends BlockEntity {
    public GeneratorEntity(BlockPos blockPos, BlockState blockState) {
        super(Ag.GENERATOR_ENTITY, blockPos, blockState);
    }
}
