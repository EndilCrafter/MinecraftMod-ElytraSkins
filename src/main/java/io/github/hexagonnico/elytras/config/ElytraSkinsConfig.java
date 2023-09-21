package io.github.hexagonnico.elytras.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;

/**
 * Class containing the mod's config.
 *
 * @author Nico
 */
public class ElytraSkinsConfig {

    /** Config spec must be registered in the initialization of the mod */
    public static final ForgeConfigSpec CONFIG_SPEC;

    /** Stores the config's boolean values for easier access */
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

    /**
     * Creates a boolean config value and stores it for easier access.
     *
     * @param configBuilder {@code ForgeConfigSpec.Builder}
     * @param key The key used in the config file and to retrieve the value
     * @param defaultValue The default value in the config file
     */
    private static void register(ForgeConfigSpec.Builder configBuilder, String key, boolean defaultValue) {
        BOOLEAN_VALUES.put(key, configBuilder.define(key, defaultValue));
    }

    /**
     * Gets a boolean value from the config.
     *
     * @param key The key used in the config file.
     * @return The requested value
     */
    public static boolean getBoolean(String key) {
        return BOOLEAN_VALUES.get(key).get();
    }
}
