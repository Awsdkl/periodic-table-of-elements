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
    DefaultedList<ItemStack> inventory = DefaultedList.ofSize(11,ItemStack.EMPTY);
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

    public ICT_Recipe getItemRecipe(DefaultedList<ItemStack> inventory)
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

    DefaultedList<ItemStack> lst_inventory = DefaultedList.ofSize(11,ItemStack.EMPTY);
    public static void tick(Industry_crafting_table_Entity entity)
    {
        //判断输入物品栏是否改变
        if(InventoryChange(entity.lst_inventory,entity.inventory))
        {
            entity.inventory.set(9,entity.getItemRecipe(entity.inventory).craft(entity.inventory));
        }
        //如果输入物品栏没有改变，但是输出物品栏改变了，则判定为玩家制造了物品，则将输入物品栏中的物品每个减1
        //此时还需要再将物品创建好
        else if(!entity.lst_inventory.get(9).isEmpty() && entity.inventory.get(9).isEmpty())
        {
            for(int i = 0;i < 9;i++)
            {
                entity.inventory.get(i).decrement(1);
            }
            entity.inventory.set(9,entity.getItemRecipe(entity.inventory).craft(entity.inventory));
        }

        //将原inventory copy到lst_inventory
        entity.copyNowInvToLst();
    }

    private void copyNowInvToLst()
    {
        for(int i = 0;i < 10;i++)
        {
            lst_inventory.set(i,inventory.get(i).copy());
        }
    }

    //用于检测输入物品栏中的物品是否改变（不包含物品个数）
    private static boolean InventoryChange(DefaultedList<ItemStack> inventory, DefaultedList<ItemStack> inventory1)
    {
        for(int i = 0;i < 9;i++)
        {
            if(inventory.get(i).getItem() != inventory1.get(i).getItem())
            {
                return true;
            }
        }
        return false;
    }

    //这个函数用在此方块被破坏时
    //当破坏时，则将输出物品栏中的物品设置为空
    public static void beBreaking(Industry_crafting_table_Entity entity)
    {
        entity.inventory.set(9,ItemStack.EMPTY);
        entity.inventory.set(10,ItemStack.EMPTY);
    }

    public static void bePlaced(Industry_crafting_table_Entity entity)
    {
        entity.inventory.set(10,new ItemStack(PeriodicTableOfElements.TEST_FAN));
    }
}
