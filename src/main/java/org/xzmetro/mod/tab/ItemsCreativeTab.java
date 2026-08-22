package org.xzmetro.mod.tab;

import org.xzmetro.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static org.xzmetro.mod.util.Constants.getId;

public class ItemsCreativeTab {
    public static final ResourceKey<CreativeModeTab> ITEMS_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), getId("items"));

    public static final CreativeModeTab ITEMS_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.WUZHOU_METRO_LOGO_1_3))
            .title(Component.translatable("itemGroup.xzmetro.items"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.WUZHOU_METRO_LOGO_1_3);
                output.accept(ModBlocks.WUZHOU_METRO_LOGO_3_3);
                output.accept(ModBlocks.FIRE_EXTINGUISHER);
                output.accept(ModBlocks.FIRE_EXTINGUISHER_CABINET);
                output.accept(ModBlocks.TRAIN_DEPARTURE_BELL);
                output.accept(ModBlocks.PARKING_BARRIER_LEFT);
                output.accept(ModBlocks.PARKING_BARRIER_MIDDLE);
                output.accept(ModBlocks.PARKING_BARRIER_RIGHT);
                output.accept(ModBlocks.PARKING_BARRIER_BRACKET);
                output.accept(ModBlocks.APG_RAILING);
                output.accept(ModBlocks.METRO_BENCHMARK_SIGN);
                output.accept(ModBlocks.LOW_STATION_SIGN);
                output.accept(ModBlocks.HIGH_STATION_SIGN);
                output.accept(ModBlocks.GLOWING_SLAB);
            })
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEMS_CREATIVE_TAB_KEY, ITEMS_CREATIVE_TAB);
    }
}
