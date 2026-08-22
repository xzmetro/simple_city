package org.xzmetro.mod.util.register;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static org.xzmetro.mod.util.Constants.getId;

public final class SimpleBlock {
    private SimpleBlock() {
    }

    public static <T extends Block> T register(String name, T block, boolean shouldRegisterItem) {
        ResourceLocation id = getId(name);
        if (shouldRegisterItem) {
            Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties()));
        }
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}