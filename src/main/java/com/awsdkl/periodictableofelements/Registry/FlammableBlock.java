package com.awsdkl.periodictableofelements.Registry;

import com.awsdkl.periodictableofelements.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlammableBlock
{
    public static void init()
    {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(ModBlocks.RUBBER_LOG, 5, 5);
    }
}
