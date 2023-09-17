package io.github.hexagonnico.elytras.client;

import io.github.hexagonnico.elytras.items.ModElytraItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ModElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

    public ModElytraLayer(RenderLayerParent<T, M> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent, entityModelSet);
    }

    @Override
    public boolean shouldRender(@NotNull ItemStack stack, @NotNull T entity) {
        if(stack.getItem() instanceof ModElytraItem) {
            return true;
        }
        return super.shouldRender(stack, entity);
    }

    @Override
    public @NotNull ResourceLocation getElytraTexture(@NotNull ItemStack stack, @NotNull T entity) {
        if(stack.getItem() instanceof ModElytraItem item) {
            return item.textureLocation;
        }
        return super.getElytraTexture(stack, entity);
    }
}
