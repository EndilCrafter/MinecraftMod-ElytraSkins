package io.github.hexagonnico.elytras;

import com.mojang.serialization.Codec;
import io.github.hexagonnico.elytras.data.LootTableModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElytraSkinsLootModifiers {

    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ElytraSkinsMod.ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOT_TABLE = REGISTER.register("add_loot_table", LootTableModifier.CODEC);

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
