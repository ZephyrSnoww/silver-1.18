package ag.ag.blocks;

import ag.ag.blocks.entities.GeneratorEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class Generator extends BlockWithEntity implements BlockEntityProvider {
    public Generator(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GeneratorEntity(pos, state);
    }
}
