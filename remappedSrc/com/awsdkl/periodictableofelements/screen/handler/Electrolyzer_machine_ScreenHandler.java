package com.awsdkl.periodictableofelements.screen.handler;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class Electrolyzer_machine_ScreenHandler extends ScreenHandler
{
    public Inventory inventory;

    public Electrolyzer_machine_ScreenHandler(int syncId, PlayerInventory inventory)
    {
        this(syncId,inventory,new SimpleInventory(2));
    }

    public Electrolyzer_machine_ScreenHandler(int synId, PlayerInventory playerInventory, Inventory inventory)
    {
        super(PeriodicTableOfElements.ELECTROLYZER_MACHINE_SCREEN_HANDLER,synId);
        this.inventory = inventory;
        checkSize(inventory,2);
        this.addSlot(new Slot(this.inventory,0,80,14)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return stack.getItem() == Items.WATER_BUCKET;
            }
        });
        this.addSlot(new Slot(this.inventory,1,152,62)
        {
            @Override
            public boolean canInsert(ItemStack stack)
            {
                return false;
            }
        });

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
