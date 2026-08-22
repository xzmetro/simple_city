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

public class ConcreteBlocksCreativeTab {
    public static final ResourceKey<CreativeModeTab> CONCRETE_BLOCKS_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), getId("concrete_blocks"));

    public static final CreativeModeTab CONCRETE_BLOCKS_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.WHITE_CONCRETE_STAIRS))
            .title(Component.translatable("itemGroup.xzmetro.concrete_blocks"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.WHITE_CONCRETE_SLAB);
                output.accept(ModBlocks.ORANGE_CONCRETE_SLAB);
                output.accept(ModBlocks.MAGENTA_CONCRETE_SLAB);
                output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
                output.accept(ModBlocks.YELLOW_CONCRETE_SLAB);
                output.accept(ModBlocks.LIME_CONCRETE_SLAB);
                output.accept(ModBlocks.PINK_CONCRETE_SLAB);
                output.accept(ModBlocks.GRAY_CONCRETE_SLAB);
                output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
                output.accept(ModBlocks.CYAN_CONCRETE_SLAB);
                output.accept(ModBlocks.PURPLE_CONCRETE_SLAB);
                output.accept(ModBlocks.BLUE_CONCRETE_SLAB);
                output.accept(ModBlocks.BROWN_CONCRETE_SLAB);
                output.accept(ModBlocks.GREEN_CONCRETE_SLAB);
                output.accept(ModBlocks.RED_CONCRETE_SLAB);
                output.accept(ModBlocks.BLACK_CONCRETE_SLAB);
                output.accept(ModBlocks.WHITE_CONCRETE_STAIRS);
                output.accept(ModBlocks.ORANGE_CONCRETE_STAIRS);
                output.accept(ModBlocks.MAGENTA_CONCRETE_STAIRS);
                output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
                output.accept(ModBlocks.YELLOW_CONCRETE_STAIRS);
                output.accept(ModBlocks.LIME_CONCRETE_STAIRS);
                output.accept(ModBlocks.PINK_CONCRETE_STAIRS);
                output.accept(ModBlocks.GRAY_CONCRETE_STAIRS);
                output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
                output.accept(ModBlocks.CYAN_CONCRETE_STAIRS);
                output.accept(ModBlocks.PURPLE_CONCRETE_STAIRS);
                output.accept(ModBlocks.BLUE_CONCRETE_STAIRS);
                output.accept(ModBlocks.BROWN_CONCRETE_STAIRS);
                output.accept(ModBlocks.GREEN_CONCRETE_STAIRS);
                output.accept(ModBlocks.RED_CONCRETE_STAIRS);
                output.accept(ModBlocks.BLACK_CONCRETE_STAIRS);
                output.accept(ModBlocks.WHITE_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.ORANGE_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.MAGENTA_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.LIGHT_BLUE_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.YELLOW_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.LIME_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.PINK_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.GRAY_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.LIGHT_GRAY_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.CYAN_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.PURPLE_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.BLUE_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.BROWN_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.GREEN_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.RED_CONCRETE_VERTICAL_SLAB);
                output.accept(ModBlocks.BLACK_CONCRETE_VERTICAL_SLAB);
            })
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CONCRETE_BLOCKS_CREATIVE_TAB_KEY, CONCRETE_BLOCKS_CREATIVE_TAB);
    }
}
