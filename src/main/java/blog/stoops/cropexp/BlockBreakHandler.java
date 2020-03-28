package blog.stoops.cropexp;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CropExperience.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class BlockBreakHandler {
    @SubscribeEvent
    public static void handleBlockBreak(BlockEvent.BreakEvent event) {
        // Check that a player broke the block and server side
        if (event.getPlayer() == null || event.getPlayer().world.isRemote) {
            return;
        }

        BlockState brokenBlockState = event.getWorld().getBlockState(event.getPos());
        Block brokenBlock = brokenBlockState.getBlock();

        // Check that a crop was harvested
        if (brokenBlock instanceof CropsBlock) {
            if (((CropsBlock) brokenBlock).isMaxAge(brokenBlockState)) {
                event.setExpToDrop(CropExperience.getExpAmount());
            }
        }
        // Nether wart is not considered a crop, so check it separately
        else if (brokenBlock instanceof NetherWartBlock && Config.WART_EXP_ENABLED.get()) {
            if (brokenBlockState.get(BlockStateProperties.AGE_0_3).equals(3)) {
                event.setExpToDrop(CropExperience.getExpAmount());
            }
        }
    }
}
