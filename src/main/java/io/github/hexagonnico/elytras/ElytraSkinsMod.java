package io.github.hexagonnico.elytras;

import io.github.hexagonnico.elytras.config.ElytraSkinsConfig;
import io.github.hexagonnico.elytras.data.ConfigCondition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main mod class.
 *
 * @author Nico
 */
@Mod(ElytraSkinsMod.ID)
public class ElytraSkinsMod {

    /** Forge mod id */
    public static final String ID = "elytras";

    /**
     * Initialization of the mod.
     */
    public ElytraSkinsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ElytraSkinsItems.register(eventBus);
        ElytraSkinsLootModifiers.register(eventBus);
        eventBus.addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ElytraSkinsConfig.CONFIG_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Setup events common to client and server.
     *
     * @param event Setup event
     */
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CraftingHelper.register(ConfigCondition.SERIALIZER);
        });
    }
}
