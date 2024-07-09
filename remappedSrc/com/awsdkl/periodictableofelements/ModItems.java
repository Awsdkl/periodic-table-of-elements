package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.item.Battery;
import com.awsdkl.periodictableofelements.item.Gas_tank;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ModItems
{
    public static final Gas_tank S_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    public static final Gas_tank M_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    public static final Gas_tank L_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    public static final Item HAMMER = new Item(new Item.Settings().maxCount(1));
    public static final Item SHEARS = new Item(new Item.Settings().maxCount(1));
    public static final Item IRON_PLATE = new Item(new Item.Settings());
    public static final Item TIN_PLATE = new Item(new Item.Settings());
    public static final Item TEST_FAN = new Item(new Item.Settings().maxCount(1));
    public static final Battery BATTERY = new Battery(new Item.Settings().maxCount(1).maxDamage(100));
    public static final Item TIN_RAW = new Item(new Item.Settings());
    public static final Item TIN_INGOT = new Item(new Item.Settings());
    public static final Item COPPER_PLATE = new Item(new Item.Settings());
    public static final Item COPPER_WIRE = new Item(new Item.Settings());
    public static final BlockItem ELECTROLYZER_MACHINE_ITEM = new BlockItem(ModBlocks.ELECTROLYZER_MACHINE, new Item.Settings());
    public static final BlockItem INDUSTRY_CRAFTING_TABLE_ITEM = new BlockItem(ModBlocks.INDUSTRY_CRAFTING_TABLE, new Item.Settings());
    public static final BlockItem GENERATOR_ITEM = new BlockItem(ModBlocks.GENERATOR, new Item.Settings());
    public static final BlockItem COPPER_CABLE_ITEM = new BlockItem(ModBlocks.COPPER_CABLE, new Item.Settings());
    public static final BlockItem TIN_ORE_ITEM = new BlockItem(ModBlocks.TIN_ORE,new Item.Settings());
    public static final BlockItem DEEPSLATE_TIN_ORE_ITEM = new BlockItem(ModBlocks.DEEPSLATE_TIN_ORE,new Item.Settings());
    public static final BlockItem TIN_RAW_BLOCK_ITEM = new BlockItem(ModBlocks.TIN_RAW_BLOCK,new Item.Settings());
    public static final BlockItem RUBBER_LOG_ITEM = new BlockItem(ModBlocks.RUBBER_LOG, new Item.Settings());
    public static final BlockItem RUBBER_LEAVES_ITEM = new BlockItem(ModBlocks.RUBBER_LEAVES, new Item.Settings());
    public static final BlockItem RUBBER_WOOD_ITEM = new BlockItem(ModBlocks.RUBBER_WOOD, new Item.Settings());
    public static final BlockItem RUBBER_PLANKS_ITEM = new BlockItem(ModBlocks.RUBBER_PLANKS, new Item.Settings());
    public static final BlockItem STRIPPED_RUBBER_LOG_ITEM = new BlockItem(ModBlocks.STRIPPED_RUBBER_LOG, new Item.Settings());
    public static final BlockItem STRIPPED_RUBBER_WOOD_ITEM = new BlockItem(ModBlocks.STRIPPED_RUBBER_WOOD, new Item.Settings());
}
