package io.github.hexagonnico.elytras.items;

import io.github.hexagonnico.elytras.ElytraSkinsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

public class ModElytraItem extends ElytraItem {

    public final ResourceLocation textureLocation;

    public ModElytraItem(Properties properties, String texture) {
        super(properties);
        this.textureLocation = new ResourceLocation(ElytraSkinsMod.ID, texture);
    }

    public ModElytraItem(String texture) {
        this(new Item.Properties().durability(432).tab(CreativeModeTab.TAB_TRANSPORTATION).rarity(Rarity.UNCOMMON), texture);
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.CHEST;
    }
}
