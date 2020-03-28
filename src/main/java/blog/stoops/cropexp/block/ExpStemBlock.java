package blog.stoops.cropexp.block;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.StemBlock;
import net.minecraft.block.StemGrownBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import javax.annotation.Nullable;

public class ExpStemBlock extends StemBlock implements IGrowable {
    // Override protected constructor to pass custom melons/pumpkins
    public ExpStemBlock(StemGrownBlock crop, Block.Properties properties) {
        super(crop, properties);
    }

    @Nullable
    @Override
    public Item getSeedItem() {
        if (this.getCrop() instanceof ExpMelonBlock) {
            return Items.MELON_SEEDS;
        }
        else if (this.getCrop() instanceof ExpPumpkinBlock) {
            return Items.PUMPKIN_SEEDS;
        }

        return null;
    }
}
