package com.awsdkl.periodictableofelements.client;

import com.awsdkl.periodictableofelements.PeriodicTableOfElements;
import com.awsdkl.periodictableofelements.screen.Electrolysis_machine_Screen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class PeriodicTableOfElementsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(PeriodicTableOfElements.ELECTROLYSIS_MACHINE_SCREEN_HANDLER, Electrolysis_machine_Screen::new);
    }
}
