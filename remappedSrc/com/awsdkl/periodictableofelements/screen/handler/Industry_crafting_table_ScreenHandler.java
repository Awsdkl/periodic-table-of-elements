package com.awsdkl.periodictableofelements.screen.handler;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class Industry_crafting_table_ScreenHandler extends ScreenHandler
{
    public Inventory inventory;

    public Industry_crafting_table_ScreenHandler(int synId,PlayerInventory playerInventory)
    {
        this(synId,playerInventory,new SimpleInventory(11));
    }

    public Industry_crafting_table_ScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory)
    {
        super(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER,synId);
        this.inventory = inventory;
        checkSize(this.inventory,11);

        //our inventory
        for(int i = 0;i < 3;i++)
        {
            for(int j = 0;j < 3;j++)
            {
                this.addSlot(new Slot(this.inventory,i*3+j,29+18*j,19+18*i)
                {
                    @Override
                    public boolean canInsert(ItemStack stack)
                    {
                        return true;
                    }
                });
            }
        }

        this.addSlot(new Slot(this.inventory,9,125,37)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });

        //the inventory for test fan
        this.addSlot(new Slot(this.inventory,10,152,64)
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
    }



    @Override
    public boolean canUse(PlayerEntity player)
    {
        return this.inventory.canPlayerUse(player);
    }

    //shift + 左键点击物品
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot)
    {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack())
        {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size())
            {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.insertItem(originalStack, 0, this.inventory.size(), false))
            {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty())
            {
                slot.setStack(ItemStack.EMPTY);
            }
            else
            {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
