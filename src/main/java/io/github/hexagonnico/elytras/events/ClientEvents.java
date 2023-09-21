package io.github.hexagonnico.elytras.events;

import io.github.hexagonnico.elytras.ElytraSkinsMod;
import io.github.hexagonnico.elytras.client.ModElytraLayer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Mod event handler to handle client events.
 *
 * @author Nico
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = ElytraSkinsMod.ID)
public class ClientEvents {

    /**
     * Adds a render layer to players to render the new elytra skins.
     *
     * @param event {@code AddLayers} event
     */
    @SubscribeEvent
    public static void onAddLayersEvent(EntityRenderersEvent.AddLayers event) {
        EntityModelSet entityModelSet = event.getEntityModels();
        event.getSkins().forEach(skin -> {
            LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = event.getSkin(skin);
            if(livingEntityRenderer instanceof PlayerRenderer playerRenderer) {
                playerRenderer.addLayer(new ModElytraLayer<>(playerRenderer, entityModelSet));
            }
        });
    }
}
