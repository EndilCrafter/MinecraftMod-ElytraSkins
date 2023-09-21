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
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

/**
 * {@link ElytraLayer} needs to be extended because it does not allow items that are instances of a subclass of {@link net.minecraft.world.item.ElytraItem}
 * to render when they are equipped.
 *
 * @param <T> {@code LivingEntity}
 * @param <M> {@code EntityModel}
 *
 * @author Nico
 */
@OnlyIn(Dist.CLIENT)
public class ModElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

    /**
     * Constructor used in {@link io.github.hexagonnico.elytras.events.ClientEvents#onAddLayersEvent(EntityRenderersEvent.AddLayers)}.
     *
     * @param renderLayerParent Render layer parent
     * @param entityModelSet Entity model set
     */
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
