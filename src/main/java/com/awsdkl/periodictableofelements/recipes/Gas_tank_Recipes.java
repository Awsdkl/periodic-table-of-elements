package com.awsdkl.periodictableofelements.recipes;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;

public class Gas_tank_Recipes extends SpecialCraftingRecipe {
    public Gas_tank_Recipes(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        ArrayList<ItemStack> list = Lists.newArrayList();
        for(int i = 0;i < inventory.size();i++)
        {
            ItemStack stack = inventory.getStack(i);
            if(!stack.isEmpty())
            {
                if(i == 4)
                {
                    if(stack.getItem() == Items.LEATHER) list.add(stack);
                    if(stack.getItem() == PeriodicTableOfElements.S_GAS_TANK_ITEM) list.add(stack);
                    if(stack.getItem() == PeriodicTableOfElements.M_GAS_TANK_ITEM) list.add(stack);
                }
                else if(stack.getItem() == Items.IRON_INGOT) list.add(stack);
            }
            else return false;
        }
        return list.size() == 9;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        boolean hasLeather = false;
        boolean hasS_Gas_tank = false;
        boolean hasM_Gas_tank = false;
        int count = 0; //记录铁锭的数量
        for(int i = 0;i < inventory.size();i++)
        {
            ItemStack stack = inventory.getStack(i);
            if(!stack.isEmpty())
            {
                if(stack.getItem() == Items.IRON_INGOT) count++;
                else if(i == 4)
                {
                    if(stack.getItem() == Items.LEATHER) hasLeather = true;
                    if(stack.getItem() == PeriodicTableOfElements.S_GAS_TANK_ITEM) hasS_Gas_tank = true;
                    if(stack.getItem() == PeriodicTableOfElements.M_GAS_TANK_ITEM) hasM_Gas_tank = true;
                }
                else return ItemStack.EMPTY;
            }
            else return ItemStack.EMPTY;
        }

        if(count == 8)
        {
            if(hasLeather) return PeriodicTableOfElements.S_GAS_TANK_ITEM.getDefaultStack();
            if(hasS_Gas_tank) return PeriodicTableOfElements.M_GAS_TANK_ITEM.getDefaultStack();
            if(hasM_Gas_tank) return PeriodicTableOfElements.L_GAS_TANK_ITEM.getDefaultStack();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width == 3 && height == 3;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        return super.getRemainder(inventory);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return PeriodicTableOfElements.GAS_TANK_RECIPE;
    }
}
