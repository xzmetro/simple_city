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

public class RoadFacilitiesCreativeTab {
    public static final ResourceKey<CreativeModeTab> ROAD_FACILITIES_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), getId("road_facilities"));

    public static final CreativeModeTab ROAD_FACILITIES_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PLAIN_CONSTRUCTION_BARRIER))
            .title(Component.translatable("itemGroup.xzmetro.road_facilities"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.PLAIN_CONSTRUCTION_BARRIER);
                output.accept(ModBlocks.MESH_CONSTRUCTION_BARRIER);
                output.accept(ModBlocks.PLAIN_CONSTRUCTION_BARRIER_CORNER);
                output.accept(ModBlocks.MESH_CONSTRUCTION_BARRIER_CORNER);
                output.accept(ModBlocks.ROAD_SIGN);
                output.accept(ModBlocks.TACTILE_PAVING);
            })
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ROAD_FACILITIES_CREATIVE_TAB_KEY, ROAD_FACILITIES_CREATIVE_TAB);
    }
}
