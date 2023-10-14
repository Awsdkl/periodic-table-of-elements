package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

/**
 * 这是工业锤子的合成配方类
 */

public class Hammer_ICT_recipes extends ICT_Recipe
{

    public Hammer_ICT_recipes()
    {
        super("hammer");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        if(inventory.isEmpty()) return false;
        if(inventory.get(0).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(1).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(2).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(3).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(4).getItem() != Items.STICK) return false;
        if(inventory.get(5).getItem() != Items.IRON_INGOT) return false;
        if(!inventory.get(6).isEmpty()) return false;
        if(inventory.get(7).getItem() != Items.STICK) return false;
        return !inventory.get(8).isEmpty();
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        return new ItemStack(PeriodicTableOfElements.HAMMER);
    }
}
