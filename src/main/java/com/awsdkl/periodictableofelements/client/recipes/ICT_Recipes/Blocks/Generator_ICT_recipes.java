package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.Type_of_Item;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Generator_ICT_recipes extends ICT_Recipe
{
    public Generator_ICT_recipes()
    {
        super("generator");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        if(inventory.isEmpty()) return false;
        if(inventory.get(0).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(1).getItem() != Items.IRON_INGOT) return false;
        if(inventory.get(2).getItem() != Items.IRON_INGOT) return false;
        if(!Type_of_Item.isPlank(inventory.get(3).getItem())) return false;
        //if(inventory.get(4) != PeriodicTableOfElements().BATTERY) return false;
        if(!Type_of_Item.isPlank(inventory.get(5).getItem())) return false;
        if(inventory.get(6).getItem() != Items.COPPER_INGOT) return false;
        if(!Type_of_Item.isPlank(inventory.get(7).getItem())) return false;
        return inventory.get(8).getItem() == Items.COPPER_INGOT;
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        return new ItemStack(new PeriodicTableOfElements().GENERATOR);
    }
}
