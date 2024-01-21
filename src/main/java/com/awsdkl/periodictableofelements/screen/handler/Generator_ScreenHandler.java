package com.awsdkl.periodictableofelements.screen.handler;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class Generator_ScreenHandler extends ScreenHandler
{
    public BlockPos pos;
    public Inventory inventory;
    public Generator_ScreenHandler(int synId, PlayerInventory playerInventory, PacketByteBuf buf)
    {
        this(synId,playerInventory,new SimpleInventory(3));
        pos = buf.readBlockPos();
    }

    public Generator_ScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory)
    {
        super(PeriodicTableOfElements.GENERATOR_SCREEN_HANDLER,synId);
        this.inventory = inventory;
        checkSize(this.inventory,3);

        //our inventory
        this.addSlot(new Slot(this.inventory,0,56,17)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return true;
            }
        });
        this.addSlot(new Slot(this.inventory,1,56,53)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return true;
            }
        });

        //the inventory for test fan
        this.addSlot(new Slot(this.inventory,2,152,64)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
            @Override
            public boolean canTakeItems(PlayerEntity playerEntity)
            {
                return false;
            }
        });

        //player's inventory
        for(int i = 0;i < 3;i++)
        {
            for(int j = 0;j < 9;j++)
            {
                this.addSlot(new Slot(playerInventory,j + i * 9 + 9,8 + j * 18,84 + i * 18));
            }
        }
        for(int i = 0;i < 9;i++)
        {
            this.addSlot(new Slot(playerInventory,i,8 + i * 18,142));
        }

        pos = BlockPos.ORIGIN;
    }

    //shift + 左键点击物品
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot)
    {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player)
    {
        return this.inventory.canPlayerUse(player);
    }
}
