package io.github.hexagonnico.elytras.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;

public class ElytraSkinsConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;

    private static final HashMap<String, ForgeConfigSpec.BooleanValue> BOOLEAN_VALUES = new HashMap<>();

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        configBuilder.comment(" Enable or disable elytra skins");
        configBuilder.comment(" Settings any of these to 'false' will make the elytras uncraftable");
        configBuilder.push("elytras");
        register(configBuilder, "phantom_elytra", true);
        register(configBuilder, "vex_elytra", true);
        register(configBuilder, "allay_elytra", true);
        register(configBuilder, "dragon_elytra", true);
        register(configBuilder, "parrot_elytra", true);
        register(configBuilder, "bat_elytra", true);
        register(configBuilder, "creeper_elytra", true);
        configBuilder.pop();
        configBuilder.comment(" Enable or disable other items");
        configBuilder.comment(" Setting any of these to 'false' will make the item unobtainable");
        configBuilder.comment(" Note that the items will still be registered even if they are disabled here");
        configBuilder.push("items");
        register(configBuilder, "vex_wing", true);
        register(configBuilder, "allay_wing", true);
        register(configBuilder, "parrot_feather", true);
        register(configBuilder, "bat_wing", true);
        configBuilder.pop();
        CONFIG_SPEC = configBuilder.build();
    }

    private static void register(ForgeConfigSpec.Builder configBuilder, String key, boolean defaultValue) {
        BOOLEAN_VALUES.put(key, configBuilder.define(key, defaultValue));
    }

    public static boolean getBoolean(String key) {
        return BOOLEAN_VALUES.get(key).get();
    }
}
