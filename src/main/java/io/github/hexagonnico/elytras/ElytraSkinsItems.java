package io.github.hexagonnico.elytras;

import io.github.hexagonnico.elytras.items.ModElytraItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Mod items registry.
 *
 * @author Nico
 */
public class ElytraSkinsItems {

    /** Deferred register used to register items */
    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ElytraSkinsMod.ID);

    /** Phantom elytra item */
    public static final RegistryObject<Item> PHANTOM_ELYTRA = REGISTER.register("phantom_elytra", () -> new ModElytraItem("textures/elytra/phantom.png"));
    /** Vex elytra item */
    public static final RegistryObject<Item> VEX_ELYTRA = REGISTER.register("vex_elytra", () -> new ModElytraItem("textures/elytra/vex.png"));
    /** Allay elytra item */
    public static final RegistryObject<Item> ALLAY_ELYTRA = REGISTER.register("allay_elytra", () -> new ModElytraItem("textures/elytra/allay.png"));
    /** Dragon elytra item */
    public static final RegistryObject<Item> DRAGON_ELYTRA = REGISTER.register("dragon_elytra", () -> new ModElytraItem("textures/elytra/dragon.png"));
    /** Parrot elytra item */
    public static final RegistryObject<Item> PARROT_ELYTRA = REGISTER.register("parrot_elytra", () -> new ModElytraItem("textures/elytra/parrot.png"));
    /** Bat elytra item */
    public static final RegistryObject<Item> BAT_ELYTRA = REGISTER.register("bat_elytra", () -> new ModElytraItem("textures/elytra/bat.png"));
    /** Creeper elytra item */
    public static final RegistryObject<Item> CREEPER_ELYTRA = REGISTER.register("creeper_elytra", () -> new ModElytraItem("textures/elytra/creeper.png"));

    /** Vex wing item */
    public static final RegistryObject<Item> VEX_WING = REGISTER.register("vex_wing", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    /** Allay wing item */
    public static final RegistryObject<Item> ALLAY_WING = REGISTER.register("allay_wing", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    /** Parrot feather item */
    public static final RegistryObject<Item> PARROT_FEATHER = REGISTER.register("parrot_feather", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    /** Bat wing item */
    public static final RegistryObject<Item> BAT_WING = REGISTER.register("bat_wing", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    /**
     * Called from mod initialization to register items.
     *
     * @param eventBus {@code FMLJavaModLoadingContext.get().getModEventBus()}
     */
    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
