package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.Gas_tank;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PeriodicTableOfElements implements ModInitializer {
    public static final String NAMESPACE = "periodic-table-of-elements";


    //创建方块及其物品
    public static final Gas_tank GAS_TANK = new Gas_tank(FabricBlockSettings.of(Material.METAL).strength(0.5f,3.0f).requiresTool());
    public static final BlockItem GAS_TANK_ITEM = new BlockItem(GAS_TANK,new FabricItemSettings());


    //创建物品组
    public static final ItemGroup MOD_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE,"mod_group"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.GAS_TANK_ITEM))
            .build();
    @Override
    public void onInitialize() {
        //注册方块及其物品
        Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"gas_tank"),GAS_TANK);
        Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"gas_tank"),GAS_TANK_ITEM);

        //添加物品到物品组
        ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
            content.add(GAS_TANK_ITEM);
        });
    }

}
