package com.awsdkl.periodictableofelements;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Type_of_Item
{
    public static boolean isPlank(Item item)
    {
        if(item == Items.OAK_PLANKS) return true;
        if(item == Items.SPRUCE_PLANKS) return true;
        if(item == Items.BIRCH_PLANKS) return true;
        if(item == Items.JUNGLE_PLANKS) return true;
        if(item == Items.ACACIA_PLANKS) return true;
        if(item == Items.DARK_OAK_PLANKS) return true;
        if(item == Items.MANGROVE_PLANKS) return true;
        if(item == Items.BAMBOO_PLANKS) return true;
        if(item == Items.CRIMSON_PLANKS) return true;
        return item == Items.WARPED_PLANKS;
    }
}
