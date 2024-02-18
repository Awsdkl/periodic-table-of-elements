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
    }
}
