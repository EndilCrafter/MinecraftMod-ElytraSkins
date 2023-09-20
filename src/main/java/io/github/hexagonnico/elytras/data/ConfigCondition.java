package io.github.hexagonnico.elytras.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.hexagonnico.elytras.ElytraSkinsMod;
import io.github.hexagonnico.elytras.config.ElytraSkinsConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigCondition implements ICondition {

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(ElytraSkinsMod.ID, "config");
    public static final Serializer SERIALIZER = new Serializer();

    private final String key;

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
