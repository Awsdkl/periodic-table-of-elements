package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.inventory.ImplementedInventory;
import com.awsdkl.periodictableofelements.screen.handler.Generator_ScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.function.Predicate;

public class Generator_Entity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory
{
    DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);
    public Generator_Entity(BlockPos pos, BlockState state)
    {
        super(PeriodicTableOfElements.GENERATOR_ENTITY, pos, state);
    }
    @Override
    public DefaultedList<ItemStack> getItems()
    {
        return inventory;
    }

    @Override
    public int size()
    {
        return 3;
    }

    @Override
    public boolean isEmpty()
    {
        return ImplementedInventory.super.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot)
    {
        return ImplementedInventory.super.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int count)
    {
        return ImplementedInventory.super.removeStack(slot, count);
    }

    @Override
    public ItemStack removeStack(int slot)
    {
        return ImplementedInventory.super.removeStack(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack)
    {
        ImplementedInventory.super.setStack(slot, stack);
    }

    @Override
    public int getMaxCountPerStack()
    {
        return ImplementedInventory.super.getMaxCountPerStack();
    }

    @Override
    public void clear()
    {
        ImplementedInventory.super.clear();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player)
    {
        return ImplementedInventory.super.canPlayerUse(player);
    }

    @Override
    public void onOpen(PlayerEntity player)
    {
        ImplementedInventory.super.onOpen(player);
    }

    @Override
    public void onClose(PlayerEntity player)
    {
        ImplementedInventory.super.onClose(player);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack)
    {
        return ImplementedInventory.super.isValid(slot, stack);
    }

    @Override
    public int count(Item item)
    {
        return ImplementedInventory.super.count(item);
    }

    @Override
    public boolean containsAny(Set<Item> items)
    {
        return ImplementedInventory.super.containsAny(items);
    }

    @Override
    public boolean containsAny(Predicate<ItemStack> predicate)
    {
        return ImplementedInventory.super.containsAny(predicate);
    }

    @Override
    public int[] getAvailableSlots(Direction side)
    {
        return new int[0];
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir)
    {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir)
    {
        return true;
    }

    @Override
    public Text getDisplayName()
    {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new Generator_ScreenHandler(syncId,inv,this);
    }

    @Override
    public boolean shouldCloseCurrentScreen()
    {
        return NamedScreenHandlerFactory.super.shouldCloseCurrentScreen();
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    //方块在被打破时运行
    //什么？不会用？用的IDEA吧，看到下面那个 1个用法 了吧，点一下
    //什么？不用IDEA？爬！
    public void beBreaking(Generator_Entity entity)
    {
        entity.inventory.set(2,ItemStack.EMPTY);
    }

    //方块在被放置时运行
    //什么？看不懂？看到上面beBreaking的注释了吧，一样的
    public void bePlacing(Generator_Entity entity)
    {
        entity.inventory.set(2, new ItemStack(PeriodicTableOfElements.TEST_FAN));
    }
}
