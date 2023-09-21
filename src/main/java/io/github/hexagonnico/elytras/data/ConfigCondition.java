package io.github.hexagonnico.elytras.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.hexagonnico.elytras.ElytraSkinsMod;
import io.github.hexagonnico.elytras.config.ElytraSkinsConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

/**
 * Condition used in crafting recipes that allows modpack authors to disable crafting recipes.
 *
 * @author Nico
 */
public class ConfigCondition implements ICondition {

    /** The key to use in the crafting recipe's json file */
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(ElytraSkinsMod.ID, "config");
    /** The condition serializer must be registered in the common setup */
    public static final Serializer SERIALIZER = new Serializer();

    /** The config key */
    private final String key;

    /**
     * Creates a condition with the given key
     *
     * @param key The config key
     */
    private ConfigCondition(String key) {
        this.key = key;
    }

    @Override
    public ResourceLocation getID() {
        return RESOURCE_LOCATION;
    }

    @Override
    public boolean test(IContext context) {
        return ElytraSkinsConfig.getBoolean(this.key);
    }

    /**
     * Responsible for serializing and deserializing conditions to and from json files.
     *
     * @author Nico
     */
    private static class Serializer implements IConditionSerializer<ConfigCondition> {

        @Override
        public void write(JsonObject json, ConfigCondition value) {
            json.addProperty("key", value.key);
        }

        @Override
        public ConfigCondition read(JsonObject json) {
            JsonElement key = json.get("key");
            if(key != null) {
                return new ConfigCondition(key.getAsString());
            }
            return null;
        }

        @Override
        public ResourceLocation getID() {
            return RESOURCE_LOCATION;
        }
    }
}
