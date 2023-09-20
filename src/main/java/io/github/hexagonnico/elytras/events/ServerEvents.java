package io.github.hexagonnico.elytras.events;

import io.github.hexagonnico.elytras.ElytraSkinsItems;
import io.github.hexagonnico.elytras.ElytraSkinsMod;
import io.github.hexagonnico.elytras.config.ElytraSkinsConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElytraSkinsMod.ID)
public class ServerEvents {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if(ElytraSkinsConfig.getBoolean("parrot_feather")) {
            LivingEntity entity = event.getEntity();
            if(entity instanceof Parrot && event.getAmount() <= 1.0) {
                Vec3 position = entity.position();
                Level world = entity.getLevel();
                ItemStack itemStack = new ItemStack(ElytraSkinsItems.PARROT_FEATHER.get());
                world.addFreshEntity(new ItemEntity(world, position.x(), position.y(), position.z(), itemStack));
            }
        }
    }
}
