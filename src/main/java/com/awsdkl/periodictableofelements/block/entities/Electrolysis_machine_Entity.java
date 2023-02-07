package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.inventory.ImplementedInventory;
import com.awsdkl.periodictableofelements.screen.handler.Electrolysis_machine_ScreenHandler;
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

public class Electrolysis_machine_Entity extends BlockEntity implements ImplementedInventory, SidedInventory, NamedScreenHandlerFactory
{
    DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);
    public Electrolysis_machine_Entity(BlockPos pos, BlockState state)
    {
        super(PeriodicTableOfElements.ELECTROLYSIS_MACHINE_ENTITY, pos, state);
    }


    @Override
    public DefaultedList<ItemStack> getItems()
    {
        return inventory;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new Electrolysis_machine_ScreenHandler(syncId, inv, this);
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
}
