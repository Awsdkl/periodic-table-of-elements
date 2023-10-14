package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Air_ICT_recipes extends ICT_Recipe
{
    public Air_ICT_recipes()
    {
        super("air");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        return inventory.isEmpty();
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        return new ItemStack(Items.AIR);
    }

}
