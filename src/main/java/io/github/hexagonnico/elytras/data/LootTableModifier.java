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

public class LootTableModifier extends LootModifier {

    public static final Supplier<Codec<LootTableModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter(m -> m.lootTable)).and(Codec.STRING.fieldOf("config").forGetter(m -> m.configKey)).apply(inst, LootTableModifier::new)));

    private final ResourceLocation lootTable;
    private final String configKey;

    protected LootTableModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable, String configKey) {
        super(conditionsIn);
        this.lootTable = lootTable;
        this.configKey = configKey;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(this.configKey.isEmpty() || ElytraSkinsConfig.getBoolean(this.configKey)) {
            LootTable extraTable = context.getLootTable(this.lootTable);
            extraTable.getRandomItemsRaw(context, LootTable.createStackSplitter(generatedLoot::add));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
