package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.inventory.ImplementedInventory;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Air_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.ICT_Recipe;
import com.awsdkl.periodictableofelements.screen.handler.Industry_crafting_table_ScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Industry_crafting_table_Entity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory
{
    DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10,ItemStack.EMPTY);
    public static ArrayList<ICT_Recipe> ict_recipes = new ArrayList<>();

    public Industry_crafting_table_Entity(BlockPos pos, BlockState state) {
        super(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_ENTITY, pos, state);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }


    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new Industry_crafting_table_ScreenHandler(syncId, inv,this);
    }

    @Override
    public void readNbt(NbtCompound nbt)
    {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt)
    {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    public static void addRecipes(ICT_Recipe recipe)
    {
        ict_recipes.add(recipe);
    }

    public static ICT_Recipe getItemRecipe(DefaultedList<ItemStack> inventory)
    {
        int len = ict_recipes.size();
        for(int i = 0;i < len;i++)
        {
            if(ict_recipes.get(i).matches(inventory))
            {
                return ict_recipes.get(i);
            }
        }
        return new Air_ICT_recipes("air");
    }

    DefaultedList<ItemStack> lst_inventory = inventory;
    public ICT_Recipe item_stack;
    public static void tick(Industry_crafting_table_Entity entity)
    {
        if(entity.inventory.isEmpty())
        {
            entity.inventory.set(9,new ItemStack(Items.AIR));
            return;
        }
        if(entity.isInventoryParity(entity.inventory,entity.lst_inventory))
        {
            entity.lst_inventory = entity.inventory;
            entity.item_stack = getItemRecipe(entity.inventory);
            //System.out.println(0);
        }
        ICT_Recipe item_tack = entity.item_stack;
        //System.out.println(item_tack.Name);

        entity.inventory.set(9,new ItemStack(item_tack.craft(entity.inventory).getItem()));
        entity.inventory.get(9).increment(entity.getCount(entity.inventory));
    }

    private boolean isInventoryParity(DefaultedList<ItemStack> inventory,DefaultedList<ItemStack> inventory1)
    {
        for(int i = 0;i < 9;i++)
        {
            if(inventory.get(i) != inventory1.get(i))
                return false;
        }
        return true;
    }

    private int getCount(DefaultedList<ItemStack> inventory)
    {
        int min = 999999999;
        for(int i = 0;i < 9;i++)
        {
            min = Math.min(inventory.get(i).getCount(),min);
        }
        return min;
    }
}
