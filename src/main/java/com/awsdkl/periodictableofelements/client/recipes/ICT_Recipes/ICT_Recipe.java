package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public abstract class ICT_Recipe
{
    public final String Name;

    public ICT_Recipe(String name)
    {
        this.Name = name;
    }

    public abstract boolean matches(DefaultedList<ItemStack> inventory);

    public abstract ItemStack craft(DefaultedList<ItemStack> inventory);
}
