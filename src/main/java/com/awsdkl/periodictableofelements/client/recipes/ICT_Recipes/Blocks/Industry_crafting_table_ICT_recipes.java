package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.Type_of_Item;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Industry_crafting_table_ICT_recipes extends ICT_Recipe
{
    public Industry_crafting_table_ICT_recipes()
    {
        super("industry_crafting_table");
    }


    @Override
    public boolean matches(DefaultedList<ItemStack> inventory)
    {
        if(inventory.isEmpty() || inventory.get(0).getItem() != Items.IRON_BLOCK) return false;
        if(inventory.isEmpty() || inventory.get(1).getItem() != Items.IRON_BLOCK) return false;
        if(inventory.isEmpty() || inventory.get(2).getItem() != Items.IRON_BLOCK) return false;
        if(inventory.get(3).getItem() != Items.AIR) return false;
        if(inventory.isEmpty() || inventory.get(4).getItem() != Items.CRAFTING_TABLE) return false;
        if(inventory.get(5).getItem() != Items.AIR) return false;
        if(inventory.isEmpty() || !Type_of_Item.isPlank(inventory.get(6).getItem())) return false;
        if(inventory.isEmpty() || !Type_of_Item.isPlank(inventory.get(7).getItem())) return false;
        return !inventory.isEmpty() && Type_of_Item.isPlank(inventory.get(8).getItem());
    }

    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory)
    {
        return new ItemStack(new PeriodicTableOfElements().INDUSTRY_CRAFTING_TABLE_ITEM);
    }

}
