package ag.ag.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class PinkLotus extends PlantBlock {
    public PinkLotus(Settings settings) {
        super(settings.sounds(BlockSoundGroup.GRASS).nonOpaque().breakInstantly().noCollision());
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.WATER);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockBelow = pos.down();
        return this.canPlantOnTop(world.getBlockState(blockBelow), world, blockBelow);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return !state.getFluidState().isEmpty();
    }
}
