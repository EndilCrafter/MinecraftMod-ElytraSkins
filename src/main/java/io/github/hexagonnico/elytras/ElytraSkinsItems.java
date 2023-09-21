package io.github.hexagonnico.elytras;

import io.github.hexagonnico.elytras.items.ModElytraItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElytraSkinsItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ElytraSkinsMod.ID);

    public static final RegistryObject<Item> PHANTOM_ELYTRA = REGISTER.register("phantom_elytra", () -> new ModElytraItem("textures/elytra/phantom.png"));
    public static final RegistryObject<Item> VEX_ELYTRA = REGISTER.register("vex_elytra", () -> new ModElytraItem("textures/elytra/vex.png"));
    public static final RegistryObject<Item> ALLAY_ELYTRA = REGISTER.register("allay_elytra", () -> new ModElytraItem("textures/elytra/allay.png"));
    public static final RegistryObject<Item> DRAGON_ELYTRA = REGISTER.register("dragon_elytra", () -> new ModElytraItem("textures/elytra/dragon.png"));
    public static final RegistryObject<Item> PARROT_ELYTRA = REGISTER.register("parrot_elytra", () -> new ModElytraItem("textures/elytra/parrot.png"));
    public static final RegistryObject<Item> BAT_ELYTRA = REGISTER.register("bat_elytra", () -> new ModElytraItem("textures/elytra/bat.png"));
    public static final RegistryObject<Item> CREEPER_ELYTRA = REGISTER.register("creeper_elytra", () -> new ModElytraItem("textures/elytra/creeper.png"));

    public static final RegistryObject<Item> VEX_WING = REGISTER.register("vex_wing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALLAY_WING = REGISTER.register("allay_wing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PARROT_FEATHER = REGISTER.register("parrot_feather", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BAT_WING = REGISTER.register("bat_wing", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
