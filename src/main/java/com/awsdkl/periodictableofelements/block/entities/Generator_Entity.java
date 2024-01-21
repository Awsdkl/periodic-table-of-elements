package com.awsdkl.periodictableofelements.block.entities;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.entities.inventory.ImplementedInventory;
import com.awsdkl.periodictableofelements.screen.handler.Generator_ScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class Generator_Entity extends BlockEntity implements ImplementedInventory, SidedInventory, ExtendedScreenHandlerFactory
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
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    /**
     * 方块在被打破时运行: <br/>
     * 将小风扇删掉
     */
    public void beBreaking(Generator_Entity entity)
    {
        entity.inventory.set(2,ItemStack.EMPTY);
    }

    /**
     * 方块在被放置时运行 <br/>
     * 将小风扇放上
     */
    public void bePlacing(Generator_Entity entity)
    {
        entity.inventory.set(2, new ItemStack(PeriodicTableOfElements.TEST_FAN));
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf)
    {
        buf.writeBlockPos(pos);
    }
}
