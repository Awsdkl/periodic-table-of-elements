package com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class Copper_plate_ICT_recipes extends ICT_Recipe {
    public Copper_plate_ICT_recipes() {
        super("copper_plate");
    }

    @Override
    public boolean matches(DefaultedList<ItemStack> inventory) {
        boolean has_hammer = false;
        boolean has_copper_ingot = false;
        for (int i = 0; i <= 9; i++) {
            if (inventory.get(i).isEmpty())
                continue;
            if (inventory.get(i).getItem() != PeriodicTableOfElements.HAMMER && inventory.get(i).getItem() != Items.COPPER_INGOT)
                return false;
            if (inventory.get(i).getItem() == PeriodicTableOfElements.HAMMER) {
                if (has_hammer) return false;
                has_hammer = true;
            }
            if (inventory.get(i).getItem() == Items.COPPER_INGOT) {
                if (has_copper_ingot) return false;
                has_copper_ingot = true;
            }
        }
        return has_copper_ingot && has_hammer;
    }


    @Override
    public ItemStack craft(DefaultedList<ItemStack> inventory) {
        ItemStack stack = new ItemStack(PeriodicTableOfElements.COPPER_PLATE);
        stack.setCount(2);
        return stack;
    }
}
