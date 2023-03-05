package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Air_ICT_recipes extends ICT_Recipe
{
    public Air_ICT_recipes(String name)
    {
        super(name);
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        if(inventory.isEmpty()) return true;
        return false;
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        return new ItemStack(Items.AIR);
    }

}
