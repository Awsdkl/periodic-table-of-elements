package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.DataGeneratorProviders.EnglishTranslation;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Add providers
        pack.addProvider(EnglishTranslation::new);
    }
}
