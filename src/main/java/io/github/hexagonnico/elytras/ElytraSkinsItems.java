package io.github.hexagonnico.elytras;

import io.github.hexagonnico.elytras.items.ModElytraItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElytraSkinsItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ElytraSkinsMod.ID);

    public static final RegistryObject<Item> TEST_ELYTRA = REGISTER.register("test_elytra", () -> new ModElytraItem("textures/entity/test_elytra.png"));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
