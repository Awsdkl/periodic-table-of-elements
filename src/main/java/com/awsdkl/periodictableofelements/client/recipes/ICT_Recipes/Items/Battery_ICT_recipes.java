package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items;

import com.awsdkl.periodictableofelements.ModItems;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;

public class Battery_ICT_recipes extends ICT_Recipe
{
    public Battery_ICT_recipes()
    {
        super("battery");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        if(inventory.isEmpty()) return false;
        if(inventory.get(0).getItem() != Items.AIR) return false;
        if(inventory.get(1).getItem() != Items.IRON_NUGGET) return false;
        if(inventory.get(2).getItem() != Items.AIR) return false;
        if(inventory.get(3).getItem() != ModItems.TIN_PLATE) return false;
        if(inventory.get(4).getItem() != Items.REDSTONE) return false;
        if(inventory.get(5).getItem() != ModItems.TIN_PLATE) return false;
        if(inventory.get(6).getItem() != ModItems.TIN_PLATE) return false;
        if(inventory.get(7).getItem() != Items.REDSTONE) return false;
        return inventory.get(8).getItem() == ModItems.TIN_PLATE;
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        ItemStack stack = new ItemStack(ModItems.BATTERY);
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("e_quantity",0);
        stack.setNbt(nbt);
        return stack;
    }
}
