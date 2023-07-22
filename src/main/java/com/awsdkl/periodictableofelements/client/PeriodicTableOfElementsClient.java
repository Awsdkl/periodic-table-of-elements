package com.awsdkl.periodictableofelements.client;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.screen.Electrolyzer_machine_Screen;
import com.awsdkl.periodictableofelements.screen.Generator_Screen;
import com.awsdkl.periodictableofelements.screen.Industry_crafting_table_Screen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class PeriodicTableOfElementsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(PeriodicTableOfElements.ELECTROLYZER_MACHINE_SCREEN_HANDLER, Electrolyzer_machine_Screen::new);
        ScreenRegistry.register(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER, Industry_crafting_table_Screen::new);
        ScreenRegistry.register(PeriodicTableOfElements.GENERATOR_SCREEN_HANDLER, Generator_Screen::new);
    }
}
