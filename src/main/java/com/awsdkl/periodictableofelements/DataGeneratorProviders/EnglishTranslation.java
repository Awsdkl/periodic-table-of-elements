package com.awsdkl.periodictableofelements.DataGeneratorProviders;

import com.awsdkl.periodictableofelements.ModBlocks;
import com.awsdkl.periodictableofelements.ModItems;
import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.item.Battery;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import javax.swing.*;
import java.nio.file.Path;

public class EnglishTranslation extends FabricLanguageProvider {
    public EnglishTranslation(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // Blocks
        // ELECTROLYZER_MACHINE
        translationBuilder.add(ModItems.ELECTROLYZER_MACHINE_ITEM, "Electrolyzer Machine");
        // Block of raw tin
        translationBuilder.add(ModItems.TIN_RAW_BLOCK_ITEM, "Block of Raw Tin");
        // Industrial Craftin' Table
        translationBuilder.add(ModItems.INDUSTRY_CRAFTING_TABLE_ITEM, "Industrial Crafting Table");
        // Generator
        translationBuilder.add(ModItems.GENERATOR_ITEM, "Generator");
        // Copper Cable
        translationBuilder.add(ModItems.COPPER_CABLE_ITEM, "Copper Cable");
        // Tin Ore
        translationBuilder.add(ModItems.TIN_ORE_ITEM, "Tin Ore");
        // Deepslate Tin Ore
        translationBuilder.add(ModItems.DEEPSLATE_TIN_ORE_ITEM, "Deepslate Tin Ore");
        // Rubber Log
        translationBuilder.add(ModItems.RUBBER_LOG_ITEM, "Rubber Log");
        // Rubber Leaves
        translationBuilder.add(ModItems.RUBBER_LEAVES_ITEM, "Rubber Leaves");
        // Rubber Wood
        translationBuilder.add(ModItems.RUBBER_WOOD_ITEM, "Rubber Wood");
        // Rubber Plank
        translationBuilder.add(ModItems.RUBBER_PLANKS_ITEM, "Rubber Planks");
        // Stripped Rubber Log
        translationBuilder.add(ModItems.STRIPPED_RUBBER_LOG_ITEM, "Stripped Rubber Log");
        // Stripped Rubber Wood
        translationBuilder.add(ModItems.STRIPPED_RUBBER_WOOD_ITEM, "Stripped Rubber Wood");

        // Items
        translationBuilder.add(ModItems.TIN_INGOT, "Tin Ingot");
        translationBuilder.add(ModItems.TIN_PLATE, "Tin Plate");
        translationBuilder.add(ModItems.TIN_RAW, "Raw Tin");
        translationBuilder.add(ModItems.BATTERY, "Battery");
        translationBuilder.add(ModItems.HAMMER, "Hammer");
        translationBuilder.add(ModItems.IRON_PLATE, "Iron Plate");
        translationBuilder.add(ModItems.SHEARS, "Shears");
        translationBuilder.add(ModItems.TEST_FAN, "Test Fan");
        translationBuilder.add(ModItems.S_GAS_TANK, "Small Gas Tank");
        translationBuilder.add(ModItems.M_GAS_TANK, "Medium Gas Tank");
        translationBuilder.add(ModItems.L_GAS_TANK, "Large Gas Tank");
        translationBuilder.add(ModItems.COPPER_PLATE, "Copper Plate");

        // UI
        translationBuilder.add(PeriodicTableOfElements.MOD_GROUP, "Periodic Table of Elements");
        translationBuilder.add(PeriodicTableOfElements.PTOE_INGREDIENTS, "PTE - Ingredients");
        translationBuilder.add(PeriodicTableOfElements.PTOE_NATURAL_BLOCKS, "PTE - Natural Blocks");

        // Tooltips
        translationBuilder.add("item.periodic-table-of-elements.battery.tooltip_1", "Remaining: %d %%");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_1", "Model: %s");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_2", "Storage: %.2f / %.2f L");
        translationBuilder.add("item.periodic-table-of-elements.gas_tank_item.tooltip_3", "Gas: %s");
    }
}
