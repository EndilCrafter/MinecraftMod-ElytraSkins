package io.github.hexagonnico.elytras.items;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ModElytraItem extends ElytraItem {

    public ModElytraItem(Properties properties) {
        super(properties);
    }

    public ModElytraItem() {
        this(new Item.Properties().durability(432).tab(CreativeModeTab.TAB_TRANSPORTATION).rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.CHEST;
    }

    // TODO: Item can't be shift-clicked into chestplate slot

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(player.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            player.setItemSlot(EquipmentSlot.CHEST, itemstack.copy());
            if(!world.isClientSide()) {
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            itemstack.setCount(0);
            return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }
}
