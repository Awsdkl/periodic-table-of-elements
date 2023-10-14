package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Tin_plate_ICT_recipes extends ICT_Recipe
{

    public Tin_plate_ICT_recipes()
    {
        super("tin_plate");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        boolean has_hammer = false;
        boolean has_iron_ingot = false;
        for(int i = 0;i < 9;i++)
        {
            if(inventory.get(i).isEmpty()) continue;
            if(inventory.get(i).getItem() != PeriodicTableOfElements.HAMMER && inventory.get(i).getItem() != Items.IRON_INGOT)
            {
                return false;
            }
            if(inventory.get(i).getItem() == PeriodicTableOfElements.HAMMER)
            {
                if(has_hammer) return false;
                has_hammer = true;
            }
            if(inventory.get(i).getItem() == Items.IRON_INGOT)
            {
                if(has_iron_ingot) return false;
                has_iron_ingot = true;
            }
        }
        if(has_iron_ingot && has_hammer) return true;
        return false;
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        ItemStack stack = new ItemStack(PeriodicTableOfElements.TIN_PLATE);
        stack.setCount(2);
        return stack;
    }
}
