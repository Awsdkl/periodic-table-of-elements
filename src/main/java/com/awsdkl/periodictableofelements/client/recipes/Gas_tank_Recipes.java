package com.awsdkl.periodictableofelements.client.recipes;

import com.awsdkl.periodictableofelements.ModItems;
import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
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
    public boolean matches(RecipeInputInventory inventory, World world) {
        ArrayList<ItemStack> list = Lists.newArrayList();
        for(int i = 0;i < inventory.size();i++)
        {
            ItemStack stack = inventory.getStack(i);

            if(stack.isEmpty()) return false;

            if(i == 4)
            {
                if(stack.getItem() == Items.LEATHER) list.add(stack);
                if(stack.getItem() == ModItems.S_GAS_TANK) list.add(stack);
                if(stack.getItem() == ModItems.M_GAS_TANK) list.add(stack);
            }
            else if(stack.getItem() == Items.IRON_INGOT) list.add(stack);
        }
        return list.size() == 9;
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        boolean hasLeather = false;
        boolean hasS_Gas_tank = false;
        boolean hasM_Gas_tank = false;
        int count = 0; //记录铁锭的数量
        for(int i = 0;i < inventory.size();i++)
        {
            ItemStack stack = inventory.getStack(i);

            if(stack.isEmpty()) return ItemStack.EMPTY;

            if(stack.getItem() == Items.IRON_INGOT) count++;
            else if(i == 4)
            {
                hasLeather = stack.getItem() == Items.LEATHER;
                hasS_Gas_tank = stack.getItem() == ModItems.S_GAS_TANK;
                hasM_Gas_tank = stack.getItem() == ModItems.M_GAS_TANK;
            }
            else return ItemStack.EMPTY;
        }

        if(count == 8)
        {
            int tmp = 0;
            ItemStack stack = null;
            if(hasLeather)
            {
                tmp = 1;
                stack = new ItemStack(ModItems.S_GAS_TANK);
            }
            if(hasS_Gas_tank)
            {
                tmp = 2;
                stack = new ItemStack(ModItems.M_GAS_TANK);
            }
            if(hasM_Gas_tank)
            {
                tmp = 3;
                stack = new ItemStack(ModItems.L_GAS_TANK);
            }

            NbtCompound nbt = new NbtCompound();
            nbt.putInt("model",tmp);
            nbt.putInt("used",0);//单位:立方厘米
            nbt.putString("type","empty");
            assert stack != null;
            stack.setNbt(nbt);
            return stack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width == 3 && height == 3;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
        return super.getRemainder(inventory);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return PeriodicTableOfElements.GAS_TANK_RECIPE;
    }
}
