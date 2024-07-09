package com.awsdkl.periodictableofelements.Registry;

import com.awsdkl.periodictableofelements.ModItems;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.awsdkl.periodictableofelements.PeriodicTableOfElements.NAMESPACE;

public class Item
{

    private static void register(String id, net.minecraft.item.Item item)
    {
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, id), item);
    }

    public static void init()
    {
        register("s_gas_tank", ModItems.S_GAS_TANK);
        register("m_gas_tank", ModItems.M_GAS_TANK);
        register("l_gas_tank", ModItems.L_GAS_TANK);
        register("shears", ModItems.SHEARS);
        register("hammer", ModItems.HAMMER);
        register("iron_plate", ModItems.IRON_PLATE);
        register("tin_plate", ModItems.TIN_PLATE);
        register("test_fan", ModItems.TEST_FAN);
        register("battery", ModItems.BATTERY);
        register("tin_raw", ModItems.TIN_RAW);
        register("tin_ingot", ModItems.TIN_INGOT);
        register("copper_plate", ModItems.COPPER_PLATE);
        register("copper_wire", ModItems.COPPER_WIRE);
        register("electrolyzer_machine", ModItems.ELECTROLYZER_MACHINE_ITEM);
        register("industry_crafting_table", ModItems.INDUSTRY_CRAFTING_TABLE_ITEM);
        register("generator", ModItems.GENERATOR_ITEM);
        register("copper_cable", ModItems.COPPER_CABLE_ITEM);
        register("tin_ore", ModItems.TIN_ORE_ITEM);
        register("deepslate_tin_ore", ModItems.DEEPSLATE_TIN_ORE_ITEM);
        register("tin_raw_block", ModItems.TIN_RAW_BLOCK_ITEM);
        register("rubber_log", ModItems.RUBBER_LOG_ITEM);
        register("rubber_wood", ModItems.RUBBER_WOOD_ITEM);
        register("rubber_leaves", ModItems.RUBBER_LEAVES_ITEM);
        register("rubber_planks", ModItems.RUBBER_PLANKS_ITEM);
        register("stripped_rubber_log", ModItems.STRIPPED_RUBBER_LOG_ITEM);
        register("stripped_rubber_wood", ModItems.STRIPPED_RUBBER_WOOD_ITEM);
    }
}
