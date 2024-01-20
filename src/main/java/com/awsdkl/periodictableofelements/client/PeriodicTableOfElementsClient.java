package com.awsdkl.periodictableofelements.client;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.block.models.providers.Copper_cable_ModelProviders;
import com.awsdkl.periodictableofelements.screen.screen.Electrolyzer_machine_Screen;
import com.awsdkl.periodictableofelements.screen.screen.Generator_Screen;
import com.awsdkl.periodictableofelements.screen.screen.Industry_crafting_table_Screen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class PeriodicTableOfElementsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(PeriodicTableOfElements.ELECTROLYZER_MACHINE_SCREEN_HANDLER, Electrolyzer_machine_Screen::new);
        HandledScreens.register(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER, Industry_crafting_table_Screen::new);
        HandledScreens.register(PeriodicTableOfElements.GENERATOR_SCREEN_HANDLER, Generator_Screen::new);
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new Copper_cable_ModelProviders());
    }
}
