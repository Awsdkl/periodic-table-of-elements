package com.awsdkl.periodictableofelements.DataGeneratorProviders;

import com.awsdkl.periodictableofelements.ModBlocks;
import com.awsdkl.periodictableofelements.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishTranslation extends FabricLanguageProvider {
    private EnglishTranslation(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // Blocks
        // ELECTROLYZER_MACHINE
        translationBuilder.add(ModBlocks.ELECTROLYZER_MACHINE, "Electrolyzer Machine");
        translationBuilder.add(ModItems.ELECTROLYZER_MACHINE_ITEM, "Electrolyzer Machine");
        // Block of raw tin
        translationBuilder.add(ModBlocks.TIN_RAW_BLOCK, "Block of Raw Tin");
        translationBuilder.add(ModItems.TIN_RAW_BLOCK_ITEM, "Block of Raw Tin");
        // Industrial Craftin' Table
        translationBuilder.add(ModBlocks.INDUSTRY_CRAFTING_TABLE, "Industrial Crafting Table");
        translationBuilder.add(ModItems.INDUSTRY_CRAFTING_TABLE_ITEM, "Industrial Crafting Table");
        // Generator
        translationBuilder.add(ModBlocks.GENERATOR, "Generator");
        translationBuilder.add(ModItems.GENERATOR_ITEM, "Generator");
        // Copper Cable
        translationBuilder.add(ModBlocks.COPPER_CABLE, "Copper Cable");
        translationBuilder.add(ModItems.COPPER_CABLE_ITEM, "Copper Cable");
        // Tin Ore
        translationBuilder.add(ModBlocks.TIN_ORE, "Tin Ore");
        translationBuilder.add(ModItems.TIN_ORE_ITEM, "Tin Ore");
        // Deepslate Tin Ore
        translationBuilder.add(ModBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        translationBuilder.add(ModItems.DEEPSLATE_TIN_ORE_ITEM, "Deepslate Tin Ore");
        // Rubber Log
        translationBuilder.add(ModBlocks.RUBBER_LOG, "Rubber Log");
        translationBuilder.add(ModItems.RUBBER_LOG_ITEM, "Rubber Log");
        // Rubber Leaves
        translationBuilder.add(ModBlocks.RUBBER_LEAVES, "Rubber Leaves");
        translationBuilder.add(ModItems.RUBBER_LEAVES_ITEM, "Rubber Leaves");
        // Rubber Wood
        translationBuilder.add(ModBlocks.RUBBER_WOOD, "Rubber Wood");
        translationBuilder.add(ModItems.RUBBER_WOOD_ITEM, "Rubber Wood");
        // Rubber Plank
        translationBuilder.add(ModBlocks.RUBBER_PLANKS, "Rubber Planks");
        translationBuilder.add(ModItems.RUBBER_PLANKS_ITEM, "Rubber Planks");
        // Stripped Rubber Log
        translationBuilder.add(ModBlocks.STRIPPED_RUBBER_LOG, "Stripped Rubber Log");
        translationBuilder.add(ModItems.STRIPPED_RUBBER_LOG_ITEM, "Stripped Rubber Log");
        // Stripped Rubber Wood
        translationBuilder.add(ModBlocks.STRIPPED_RUBBER_WOOD, "Stripped Rubber Wood");
        translationBuilder.add(ModItems.STRIPPED_RUBBER_WOOD_ITEM, "Stripped Rubber Wood");


    }
}
