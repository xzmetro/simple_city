package org.simplecity.mod.util.register;

import org.simplecity.mod.item.TooltipBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static org.simplecity.mod.util.Constants.getId;

public final class TooltipBlock {
    private TooltipBlock() {
    }

    public static <T extends Block> T register(String name, T block, String... tooltips) {
        ResourceLocation id = getId(name);
        Registry.register(BuiltInRegistries.ITEM, id, new TooltipBlockItem(block, new Item.Properties(), tooltips));
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        return block;
    }
}
