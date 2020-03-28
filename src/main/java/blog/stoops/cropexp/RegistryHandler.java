package blog.stoops.cropexp;

import blog.stoops.cropexp.block.ExpMelonBlock;
import blog.stoops.cropexp.block.ExpPumpkinBlock;
import blog.stoops.cropexp.block.ExpStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = CropExperience.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class RegistryHandler {
    @ObjectHolder(CropExperience.MODID + ":melon")
    public static final Block EXP_MELON = null;

    @ObjectHolder(CropExperience.MODID + ":pumpkin")
    public static final Block EXP_PUMPKIN = null;

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> blockRegistry = event.getRegistry();

        ExpMelonBlock newMelon = new ExpMelonBlock(Block.Properties.from(Blocks.MELON));
        ExpPumpkinBlock newPumpkin = new ExpPumpkinBlock(Block.Properties.from(Blocks.PUMPKIN));
        ExpStemBlock newMelonStem = new ExpStemBlock(newMelon, Block.Properties.from(Blocks.MELON_STEM));
        ExpStemBlock newPumpkinStem = new ExpStemBlock(newPumpkin, Block.Properties.from(Blocks.PUMPKIN_STEM));

        blockRegistry.registerAll(
                newMelon.setRegistryName(CropExperience.MODID + ":melon"),
                newPumpkin.setRegistryName(CropExperience.MODID + ":pumpkin"),
                newMelonStem.setRegistryName("minecraft:melon_stem"),
                newPumpkinStem.setRegistryName("minecraft:pumpkin_stem")
        );

        Item.BLOCK_TO_ITEM.put(newMelonStem, Items.MELON_SEEDS);
        Item.BLOCK_TO_ITEM.put(newPumpkinStem, Items.PUMPKIN_SEEDS);
    }
}
