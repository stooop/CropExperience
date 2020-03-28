package blog.stoops.cropexp;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.IntValue EXP_AMOUNT;
    public static ForgeConfigSpec.IntValue EXP_CHANCE;

    public static ForgeConfigSpec.BooleanValue WART_EXP_ENABLED;
    public static ForgeConfigSpec.BooleanValue MELON_EXP_ENABLED;
    public static ForgeConfigSpec.BooleanValue PUMPKIN_EXP_ENABLED;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        EXP_AMOUNT = COMMON_BUILDER.comment("Number of experience orbs to drop per crop")
                .defineInRange("expAmount", 1, 0, Integer.MAX_VALUE);

        EXP_CHANCE = COMMON_BUILDER.comment("Percentage chance that a crop will drop experience")
                .defineInRange("expChance", 25, 0, 100);

        WART_EXP_ENABLED = COMMON_BUILDER.comment("Enable or disable Nether Wart dropping experience")
                .define("wartExpEnabled", true);

        MELON_EXP_ENABLED = COMMON_BUILDER.comment("Enable or disable grown Melons dropping experience")
                .define("melonExpEnabled", true);

        PUMPKIN_EXP_ENABLED = COMMON_BUILDER.comment("Enable or disable grown Pumpkins dropping experience")
                .define("pumpkinExpEnabled", true);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
