package com.awsdkl.periodictableofelements.item;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Battery extends Item
{
    private static final int MAXE = 100;
    public Battery(Settings settings)
    {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        if(stack.getNbt() == null) return;
        int e = stack.getNbt().getInt("e_quantity");

        tooltip.add(Text.translatable("item.periodic-table-of-elements.battery.tooltip_1",e).formatted(Formatting.GRAY));
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner)
    {
        return false;
    }

    /* 这个方法是每一tick这个物品要干的事情
     * 获取物品的nbt标签：e_quantity（电量），并将它更新到物品的物品栏提示中去
     */
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        int e = 0;
        if(stack.getNbt() != null)
        {
            e = stack.getNbt().getInt("e_quantity");
        }
        stack.setDamage(((int)((double) e / MAXE) * 100));
        //System.out.println(2);
    }
}
