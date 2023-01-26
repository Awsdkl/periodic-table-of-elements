package com.awsdkl.periodictableofelements.blockitem;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Gas_tank_item extends BlockItem {
    public Gas_tank_item(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if(stack.hasNbt())
        {
            assert stack.getNbt() != null;
            return stack.getNbt().get("model") != null;
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getNbt() == null) return;
        int model = stack.getNbt().getInt("model");
        int used = stack.getNbt().getInt("used");
        String type = stack.getNbt().getString("type");
        String S_model = null;
        switch (model)
        {
            case 1:S_model = "Small";
            case 2:S_model = "Medium";
            case 3:S_model = "Large";
        }

        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_1",S_model));
        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_2",used / 1000f,model*2000f));
        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_3",type));

    }
}
