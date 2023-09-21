package io.github.hexagonnico.elytras.items;

import io.github.hexagonnico.elytras.ElytraSkinsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.Nullable;

/**
 * Extension of {@link ElytraItem} because needed because equipment does not allow items that are instances of
 * subclasses to be equipped on the same slot. See {@link net.minecraft.world.entity.Mob#getEquipmentSlotForItem(ItemStack)}.
 * Elytras also need to provide their own texture. See {@link io.github.hexagonnico.elytras.client.ModElytraLayer#getElytraTexture(ItemStack, LivingEntity)}.
 *
 * @author Nico
 */
public class ModElytraItem extends ElytraItem {

    /** Resource location of the elytra's texture when equipped */
    public final ResourceLocation textureLocation;

    /**
     * Creates an elytra item with the given properties and the given texture.
     *
     * @param properties Item properties
     * @param texture Path to the texture of the equipped elytra
     */
    public ModElytraItem(Properties properties, String texture) {
        super(properties);
        this.textureLocation = new ResourceLocation(ElytraSkinsMod.ID, texture);
    }

    /**
     * Creates an elytra item with the default properties and the given texture.
     *
     * @param texture Path to the texture of the equipped elytra
     */
    public ModElytraItem(String texture) {
        this(new Item.Properties().durability(432).rarity(Rarity.UNCOMMON), texture);
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.CHEST;
    }
}
