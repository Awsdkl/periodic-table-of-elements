package com.awsdkl.periodictableofelements.item;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Gas_tank extends Item
{
    public Gas_tank(Settings settings)
    {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        if(stack.getNbt() == null) return;
        int model = stack.getNbt().getInt("model");
        int used = stack.getNbt().getInt("used");
        String type = stack.getNbt().getString("type");
        String Smodel = null;
        switch(model)
        {
            case 1:Smodel = "Small";
            case 2:Smodel = "Medium";
            case 3:Smodel = "Large";
        }

        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_1",Smodel));
        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_2",used / 1000f,model * 1000f));
        tooltip.add(Text.translatable("item.periodic-table-of-elements.gas_tank_item.tooltip_3",type));
    }

    @Override
    public int getMaxUseTime(ItemStack stack)
    {
        if(stack.getNbt() == null) return 8000;
        int max_time = stack.getNbt().getInt("model");
        return max_time * 2000;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner)
    {
        return false;
    }


}
