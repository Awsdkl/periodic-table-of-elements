package com.awsdkl.periodictableofelements.Registry;

import com.awsdkl.periodictableofelements.ModBlocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.awsdkl.periodictableofelements.PeriodicTableOfElements.NAMESPACE;

public class Block
{
    private static void register(String id, net.minecraft.block.Block block)
    {
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, id), block);
    }

    public static void init()
    {
        register("electrolyzer_machine", ModBlocks.ELECTROLYZER_MACHINE);
        register("industry_crafting_table", ModBlocks.INDUSTRY_CRAFTING_TABLE);
        register("generator", ModBlocks.GENERATOR);
        register("copper_cable", ModBlocks.COPPER_CABLE);
        register("tin_ore", ModBlocks.TIN_ORE);
        register("deepslate_tin_ore", ModBlocks.DEEPSLATE_TIN_ORE);
        register("tin_raw_block", ModBlocks.TIN_RAW_BLOCK);
        register("rubber_log", ModBlocks.RUBBER_LOG);
        register("rubber_wood", ModBlocks.RUBBER_WOOD);
        register("rubber_leaves", ModBlocks.RUBBER_LEAVES);
        register("rubber_planks", ModBlocks.RUBBER_PLANKS);
        register("stripped_rubber_log", ModBlocks.STRIPPED_RUBBER_LOG);
        register("stripped_rubber_wood", ModBlocks.STRIPPED_RUBBER_WOOD);
    }
}
