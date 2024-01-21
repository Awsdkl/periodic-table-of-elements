package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.inventory.ImplementedInventory;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.GetRecipe;
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

public class Industry_crafting_table_Entity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory
{
    DefaultedList<ItemStack> inventory = DefaultedList.ofSize(11,ItemStack.EMPTY);
    public static ICT_Recipe[] ict_shaped_recipes = new ICT_Recipe[6+5];
    public static int ict_shaped_recipes_len = -1;//上面这个数组的长度

    public static ICT_Recipe[] ict_shapeless_recipes = new ICT_Recipe[1+5];
    public static int ict_shapeless_recipes_len = -1;

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

    public static void addShapedRecipes(ICT_Recipe recipe)
    {
        //向有序物品合成配方数组添加一个合成配方
        ict_shaped_recipes[++ict_shaped_recipes_len] = recipe;
    }

    public static void addShapelessRecipes(ICT_Recipe recipe)
    {
        //向无序物品合成配方数组添加一个合成配方
        ict_shapeless_recipes[++ict_shapeless_recipes_len] = recipe;
    }

    DefaultedList<ItemStack> lst_inventory = DefaultedList.ofSize(11,ItemStack.EMPTY);
    public static void tick(Industry_crafting_table_Entity entity)
    {
        ItemStack c_stack = new ItemStack(Items.AIR);
        //判断输入物品栏是否改变
        if(InventoryChange(entity.lst_inventory,entity.inventory))
        {
            int r_id = GetRecipe.getShapedRecipe(entity.inventory);//当前物品应该造出的东西在ict_shaped_recipes或ict_shapeless_recipes数组中的下标
            if(r_id > 0) c_stack = ict_shaped_recipes[r_id].craft(entity.inventory);//大于0表示在有序的中找到了物品
            else//表示没有找到物品，要去无序中找
            {
                r_id = GetRecipe.getShapelessRecipe(entity.inventory);
                if(r_id > 0) c_stack = ict_shapeless_recipes[r_id].craft(entity.inventory);
            }
            entity.inventory.set(9, c_stack);
        }
        //如果输入物品栏没有改变，但是输出物品栏改变了，则判定为玩家制造了物品，则将输入物品栏中的物品每个减1
        //此时还需要再将物品创建好
        else if(!entity.lst_inventory.get(9).isEmpty() && entity.inventory.get(9).isEmpty())
        {
            for(int i = 0; i < 9; i++)//这个循环中将输入物品栏的每个物品减1
            {
                entity.inventory.get(i).decrement(1);
            }
            int r_id = GetRecipe.getShapedRecipe(entity.inventory);//当前物品应该造出的东西在ict_shaped_recipes或ict_shapeless_recipes数组中的下标
            if(r_id > 0) c_stack = ict_shaped_recipes[r_id].craft(entity.inventory);//大于0表示在有序的中找到了物品
            else//表示没有找到物品，要去无序中找
            {
                r_id = GetRecipe.getShapelessRecipe(entity.inventory);
                if(r_id > 0) c_stack = ict_shapeless_recipes[r_id].craft(entity.inventory);
            }
            entity.inventory.set(9, c_stack);
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

    public static void bePlacing(Industry_crafting_table_Entity entity)
    {
        entity.inventory.set(10,new ItemStack(PeriodicTableOfElements.TEST_FAN));
    }
}
