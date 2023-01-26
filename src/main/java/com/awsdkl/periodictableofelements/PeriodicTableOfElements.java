package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.Gas_tank;
import com.awsdkl.periodictableofelements.blockitem.Gas_tank_item;
import com.awsdkl.periodictableofelements.recipes.Gas_tank_Recipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PeriodicTableOfElements implements ModInitializer {
    public static final String NAMESPACE = "periodic-table-of-elements";
    //特殊合成表
    public static final RecipeSerializer<Gas_tank_Recipes> GAS_TANK_RECIPE = RecipeSerializer.register("gas_tank_recipe", new SpecialRecipeSerializer<>(Gas_tank_Recipes::new));


    //创建方块及其物品
    public static final Gas_tank S_GAS_TANK = new Gas_tank(FabricBlockSettings.of(Material.METAL).strength(0.5f,3.0f).requiresTool());
    public static final Gas_tank_item S_GAS_TANK_ITEM = new Gas_tank_item(S_GAS_TANK,new FabricItemSettings());

    public static final Gas_tank M_GAS_TANK = new Gas_tank(FabricBlockSettings.of(Material.METAL).strength(0.5f,3.0f).requiresTool());
    public static final Gas_tank_item M_GAS_TANK_ITEM = new Gas_tank_item(M_GAS_TANK,new FabricItemSettings());

    public static final Gas_tank L_GAS_TANK = new Gas_tank(FabricBlockSettings.of(Material.METAL).strength(0.5f,3.0f).requiresTool());
    public static final Gas_tank_item L_GAS_TANK_ITEM = new Gas_tank_item(L_GAS_TANK,new FabricItemSettings());




    //创建物品组
    public static final ItemGroup MOD_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE,"mod_group"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.S_GAS_TANK_ITEM))
            .build();
    @Override
    public void onInitialize() {
        //注册方块及其物品
        {
            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"s_gas_tank"),S_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"s_gas_tank"),S_GAS_TANK_ITEM);

            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"m_gas_tank"),M_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"m_gas_tank"),M_GAS_TANK_ITEM);

            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"l_gas_tank"),L_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"l_gas_tank"),L_GAS_TANK_ITEM);
        }


        //添加物品到物品组
        ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
            content.add(S_GAS_TANK_ITEM);
            content.add(M_GAS_TANK_ITEM);
            content.add(L_GAS_TANK_ITEM);
        });
    }

}
