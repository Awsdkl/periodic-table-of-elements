package com.awsdkl.periodictableofelements.block.models.providers;

import com.awsdkl.periodictableofelements.block.models.models.Copper_cable_Model;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class Copper_cable_ModelProviders implements ModelResourceProvider
{
    public static final Identifier COPPER_CABLE_MODEL_PROVIDERS = new Identifier("periodic-table-of-elements:block/copper_cable");
    /**
     * @param resourceId The resource identifier to be loaded.
     * @param context
     * @return The loaded UnbakedModel, or null if this ModelResourceProvider doesn't handle a specific Identifier
     * (or if there was no error!).
     */
    public @Nullable UnbakedModel loadModelResource(Identifier resourceId, ModelProviderContext context) throws ModelProviderException
    {
        if(resourceId.equals(COPPER_CABLE_MODEL_PROVIDERS)) {
            return new Copper_cable_Model();
        } else {
            return null;
        }
    }
}
