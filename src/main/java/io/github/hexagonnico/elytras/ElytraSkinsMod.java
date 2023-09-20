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

@Mod(ElytraSkinsMod.ID)
public class ElytraSkinsMod {

    public static final String ID = "elytras";

    public ElytraSkinsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ElytraSkinsItems.register(eventBus);
        ElytraSkinsLootModifiers.register(eventBus);
        eventBus.addListener(this::commonSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ElytraSkinsConfig.CONFIG_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CraftingHelper.register(ConfigCondition.SERIALIZER);
        });
    }
}
