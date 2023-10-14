package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.Type_of_Item;
import com.awsdkl.periodictableofelements.block.entities.Industry_crafting_table_Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class GetRecipe
{
    public static int getShapedRecipe(DefaultedList<ItemStack> inventory)
    {
        Item i0 = inventory.get(0).getItem();
        Item i1 = inventory.get(1).getItem();
        Item i2 = inventory.get(2).getItem();
        Item i3 = inventory.get(3).getItem();
        Item i4 = inventory.get(4).getItem();
        Item i5 = inventory.get(5).getItem();
        Item i6 = inventory.get(6).getItem();
        Item i7 = inventory.get(7).getItem();
        Item i8 = inventory.get(8).getItem();
        if(inventory.isEmpty())
        {
            return 0;
        }
        else if(i0 == Items.IRON_BLOCK)
        {
            if(i1 == Items.IRON_BLOCK)
            {
                if(i2 == Items.IRON_BLOCK)
                {
                    if(i3 == PeriodicTableOfElements.HAMMER)
                    {
                        if(i4 == Items.CRAFTING_TABLE)
                        {
                            if(i5 == PeriodicTableOfElements.SHEARS)
                            {
                                if(Type_of_Item.isPlank(i6))
                                {
                                    if(Type_of_Item.isPlank(i7))
                                    {
                                        if(Type_of_Item.isPlank(i8))
                                        {
                                            return 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else if(i0 == Items.IRON_INGOT)
        {
            if(i1 == Items.IRON_INGOT)
            {
                if(i2 == Items.IRON_INGOT)
                {
                    if(i3 == Items.IRON_INGOT)
                    {
                        if(i4 == Items.STICK)
                        {
                            if(i5 == Items.IRON_INGOT)
                            {
                                if(i6 == Items.AIR)
                                {
                                    if(i7 == Items.STICK)
                                    {
                                        if(i8 == Items.AIR)
                                        {
                                            return 3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(Type_of_Item.isPlank(i3))
                    {
                        if(i4 == PeriodicTableOfElements.BATTERY)
                        {
                            if(Type_of_Item.isPlank(i5))
                            {
                                if(i6 == Items.COPPER_INGOT)
                                {
                                    if(i7 == Items.FURNACE)
                                    {
                                        if(i8 == Items.COPPER_INGOT)
                                        {
                                            return 2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(i1 == Items.AIR)
            {
                if(i2 == Items.IRON_INGOT)
                {
                    if(i3 == Items.AIR)
                    {
                        if(i4 == Items.IRON_INGOT)
                        {
                            if(i5 == Items.AIR)
                            {
                                if(i6 == Items.STICK)
                                {
                                    if(i7 == Items.AIR)
                                    {
                                        if(i8 == Items.STICK)
                                        {
                                            return 4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else if(i0 == Items.AIR)
        {
            if(i1 == Items.IRON_NUGGET)
            {
                if(i2 == Items.AIR)
                {
                    if(i3 == PeriodicTableOfElements.TIN_PLATE)
                    {
                        if(i4 == Items.REDSTONE)
                        {
                            if(i5 == i3)
                            {
                                if(i6 == i5)
                                {
                                    if(i7 == i4)
                                    {
                                        if(i8 == i6)
                                        {
                                            return 5;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }


    public static int getShapelessRecipe(DefaultedList<ItemStack> inventory)
    {
        for(int i = 1; i <= Industry_crafting_table_Entity.ict_shapeless_recipes_len; i++)
        {
            if(Industry_crafting_table_Entity.ict_shapeless_recipes[i].matches(inventory))
            {
                return i;
            }
        }
        return -1;
    }
}
