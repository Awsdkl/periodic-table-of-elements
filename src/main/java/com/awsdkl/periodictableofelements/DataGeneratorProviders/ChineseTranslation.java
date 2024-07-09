package com.awsdkl.periodictableofelements.DataGeneratorProviders;

import com.awsdkl.periodictableofelements.ModGroups;
import com.awsdkl.periodictableofelements.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ChineseTranslation extends FabricLanguageProvider {
    public ChineseTranslation(FabricDataOutput dataGenerator) {
        super(dataGenerator, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // Blocks
        // ELECTROLYZER_MACHINE
        translationBuilder.add(ModItems.ELECTROLYZER_MACHINE_ITEM, "水电解机");
        // Block of raw tin
        translationBuilder.add(ModItems.TIN_RAW_BLOCK_ITEM, "粗锡块");
        // Industrial Craftin' Table
        translationBuilder.add(ModItems.INDUSTRY_CRAFTING_TABLE_ITEM, "工业工作台");
        // Generator
        translationBuilder.add(ModItems.GENERATOR_ITEM, "发电机");
        // Copper Cable
        translationBuilder.add(ModItems.COPPER_CABLE_ITEM, "铜制电缆");
        // Tin Ore
        translationBuilder.add(ModItems.TIN_ORE_ITEM, "锡矿石");
        // Deepslate Tin Ore
        translationBuilder.add(ModItems.DEEPSLATE_TIN_ORE_ITEM, "深层锡矿石");
        // Rubber Log
        translationBuilder.add(ModItems.RUBBER_LOG_ITEM, "橡胶原木");
        // Rubber Leaves
        translationBuilder.add(ModItems.RUBBER_LEAVES_ITEM, "橡胶树叶");
        // Rubber Wood
        translationBuilder.add(ModItems.RUBBER_WOOD_ITEM, "橡胶木");
        // Rubber Plank
        translationBuilder.add(ModItems.RUBBER_PLANKS_ITEM, "橡胶木板");
        // Stripped Rubber Log
        translationBuilder.add(ModItems.STRIPPED_RUBBER_LOG_ITEM, "去皮橡胶原木");
        // Stripped Rubber Wood
        translationBuilder.add(ModItems.STRIPPED_RUBBER_WOOD_ITEM, "去皮橡胶木");

        // Items
        translationBuilder.add(ModItems.TIN_INGOT, "锡锭");
        translationBuilder.add(ModItems.TIN_PLATE, "锡板");
        translationBuilder.add(ModItems.TIN_RAW, "粗锡");
        translationBuilder.add(ModItems.BATTERY, "电池");
        translationBuilder.add(ModItems.HAMMER, "锤子");
        translationBuilder.add(ModItems.IRON_PLATE, "铁板");
        translationBuilder.add(ModItems.SHEARS, "剪刀");
        translationBuilder.add(ModItems.TEST_FAN, "测试风扇");
        translationBuilder.add(ModItems.S_GAS_TANK, "小型气体储罐");
        translationBuilder.add(ModItems.M_GAS_TANK, "中型气体储罐");
        translationBuilder.add(ModItems.L_GAS_TANK, "大型气体储罐");
        translationBuilder.add(ModItems.COPPER_PLATE, "铜板");

        // UI
        translationBuilder.add(ModGroups.MOD_GROUP, "元素周期表");
        translationBuilder.add(ModGroups.PTOE_INGREDIENTS, "元素周期表 - 原料");
        translationBuilder.add(ModGroups.PTOE_NATURAL_BLOCKS, "元素周期表 - 自然方块");

        // Tooltips
        translationBuilder.add("item.periodic-table-of-elements.battery.tooltip_1", "剩余电量: %d %%");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_1", "储罐型号: %s");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_2", "剩余容量: %.2f / %.2f L");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_3", "气体类型: %s");
    }
}
