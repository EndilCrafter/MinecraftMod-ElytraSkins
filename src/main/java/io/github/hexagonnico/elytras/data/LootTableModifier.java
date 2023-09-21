package io.github.hexagonnico.elytras.data;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.hexagonnico.elytras.config.ElytraSkinsConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * A forge loot modifier that can add items to a vanilla loot table without replacing it.
 *
 * @author Nico
 */
public class LootTableModifier extends LootModifier {

    /** This monstrous one-liner is the way Mojang wants you to deserialize things */
    public static final Supplier<Codec<LootTableModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter(m -> m.lootTable)).and(Codec.STRING.fieldOf("config").forGetter(m -> m.configKey)).apply(inst, LootTableModifier::new)));

    /** Resource location of the loot table containing the items to add */
    private final ResourceLocation lootTable;
    /** Key used by some loot modifiers to check if a certain config is enabled before modifying a loot table */
    private final String configKey;

    /**
     * Constructs a loot modifier.
     * This constructor is only supposed to be used in the {@link Codec}.
     *
     * @param conditions {@code LootItemCondition}
     * @param lootTable Resource location of the loot table containing the items to add
     * @param configKey Key used by some loot modifiers to check if a certain config is enabled before modifying a loot table
     */
    protected LootTableModifier(LootItemCondition[] conditions, ResourceLocation lootTable, String configKey) {
        super(conditions);
        this.lootTable = lootTable;
        this.configKey = configKey;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(this.configKey.isEmpty() || ElytraSkinsConfig.getBoolean(this.configKey)) {
            LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
            extraTable.getRandomItemsRaw(context, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
