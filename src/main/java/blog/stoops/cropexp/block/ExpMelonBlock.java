package blog.stoops.cropexp.block;

import blog.stoops.cropexp.Config;
import blog.stoops.cropexp.CropExperience;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MelonBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class ExpMelonBlock extends MelonBlock {
    public ExpMelonBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return Config.MELON_EXP_ENABLED.get() ? CropExperience.getExpAmount() : 0;
    }

    @Override
    public ResourceLocation getLootTable() {
        return Blocks.MELON.getLootTable();
    }

    @Override
    public Block getBlock() {
        return Blocks.MELON;
    }
}
