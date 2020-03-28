package blog.stoops.cropexp;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.Random;

@Mod(CropExperience.MODID)
public class CropExperience {
    public static final String MODID = "cropexp";

    private static Random rand = new Random();

    public CropExperience() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }

    // Returns the configurable amount of exp at the configurable rate
    public static int getExpAmount() {
        return (rand.nextInt(100) + 1 <= Config.EXP_CHANCE.get()) ? Config.EXP_AMOUNT.get() : 0;
    }
}
