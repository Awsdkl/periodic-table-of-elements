package com.awsdkl.periodictableofelements.Registry;

import com.awsdkl.periodictableofelements.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;

public class StrippableBlock
{
    protected static void sbr(Block input, Block stripped)
    {
        StrippableBlockRegistry.register(input, stripped);
    }
    public static void init()
    {
        //rubber
        sbr(ModBlocks.RUBBER_LOG, ModBlocks.STRIPPED_RUBBER_LOG);
        sbr(ModBlocks.RUBBER_WOOD, ModBlocks.STRIPPED_RUBBER_WOOD);
    }
}
