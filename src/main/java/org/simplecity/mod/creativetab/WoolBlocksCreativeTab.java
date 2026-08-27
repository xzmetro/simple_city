package org.simplecity.mod.creativetab;

import org.simplecity.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static org.simplecity.mod.util.Constants.getId;

public class WoolBlocksCreativeTab {
    public static final ResourceKey<CreativeModeTab> WOOL_BLOCKS_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), getId("wool_blocks"));

    public static final CreativeModeTab WOOL_BLOCKS_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.WHITE_WOOL_STAIRS))
            .title(Component.translatable("itemGroup.simple_city.wool_blocks"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.WHITE_WOOL_SLAB);
                output.accept(ModBlocks.ORANGE_WOOL_SLAB);
                output.accept(ModBlocks.MAGENTA_WOOL_SLAB);
                output.accept(ModBlocks.LIGHT_BLUE_WOOL_SLAB);
                output.accept(ModBlocks.YELLOW_WOOL_SLAB);
                output.accept(ModBlocks.LIME_WOOL_SLAB);
                output.accept(ModBlocks.PINK_WOOL_SLAB);
                output.accept(ModBlocks.GRAY_WOOL_SLAB);
                output.accept(ModBlocks.LIGHT_GRAY_WOOL_SLAB);
                output.accept(ModBlocks.CYAN_WOOL_SLAB);
                output.accept(ModBlocks.PURPLE_WOOL_SLAB);
                output.accept(ModBlocks.BLUE_WOOL_SLAB);
                output.accept(ModBlocks.BROWN_WOOL_SLAB);
                output.accept(ModBlocks.GREEN_WOOL_SLAB);
                output.accept(ModBlocks.RED_WOOL_SLAB);
                output.accept(ModBlocks.BLACK_WOOL_SLAB);

                // ===== 羊毛楼梯 =====
                output.accept(ModBlocks.WHITE_WOOL_STAIRS);
                output.accept(ModBlocks.ORANGE_WOOL_STAIRS);
                output.accept(ModBlocks.MAGENTA_WOOL_STAIRS);
                output.accept(ModBlocks.LIGHT_BLUE_WOOL_STAIRS);
                output.accept(ModBlocks.YELLOW_WOOL_STAIRS);
                output.accept(ModBlocks.LIME_WOOL_STAIRS);
                output.accept(ModBlocks.PINK_WOOL_STAIRS);
                output.accept(ModBlocks.GRAY_WOOL_STAIRS);
                output.accept(ModBlocks.LIGHT_GRAY_WOOL_STAIRS);
                output.accept(ModBlocks.CYAN_WOOL_STAIRS);
                output.accept(ModBlocks.PURPLE_WOOL_STAIRS);
                output.accept(ModBlocks.BLUE_WOOL_STAIRS);
                output.accept(ModBlocks.BROWN_WOOL_STAIRS);
                output.accept(ModBlocks.GREEN_WOOL_STAIRS);
                output.accept(ModBlocks.RED_WOOL_STAIRS);
                output.accept(ModBlocks.BLACK_WOOL_STAIRS);

                // ===== 羊毛竖半砖 =====
                output.accept(ModBlocks.WHITE_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.ORANGE_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.MAGENTA_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.LIGHT_BLUE_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.YELLOW_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.LIME_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.PINK_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.GRAY_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.LIGHT_GRAY_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.CYAN_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.PURPLE_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.BLUE_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.BROWN_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.GREEN_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.RED_WOOL_VERTICAL_SLAB);
                output.accept(ModBlocks.BLACK_WOOL_VERTICAL_SLAB);
            })
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, WOOL_BLOCKS_CREATIVE_TAB_KEY, WOOL_BLOCKS_CREATIVE_TAB);
    }
}