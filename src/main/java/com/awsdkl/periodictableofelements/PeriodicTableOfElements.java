package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.Electrolysis_machine;
import com.awsdkl.periodictableofelements.block.Industry_crafting_table;
import com.awsdkl.periodictableofelements.block.entities.Electrolysis_machine_Entity;
import com.awsdkl.periodictableofelements.block.entities.Industry_crafting_table_Entity;
import com.awsdkl.periodictableofelements.client.recipes.Gas_tank_Recipes;
import com.awsdkl.periodictableofelements.item.Gas_tank;
import com.awsdkl.periodictableofelements.screen.handler.Electrolysis_machine_ScreenHandler;
import com.awsdkl.periodictableofelements.screen.handler.Industry_crafting_table_ScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class PeriodicTableOfElements implements ModInitializer {
    public static final String NAMESPACE = "periodic-table-of-elements";
    //特殊合成表
    public static final RecipeSerializer<Gas_tank_Recipes> GAS_TANK_RECIPE = RecipeSerializer.register("gas_tank_recipe", new SpecialRecipeSerializer<>(Gas_tank_Recipes::new));
    //创建物品
    public static final Gas_tank S_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));

    public static final Gas_tank M_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));

    public static final Gas_tank L_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));

    //创建方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)

    //Electrolysis_machine(电解装置)
        public static final Electrolysis_machine ELECTROLYSIS_MACHINE = new Electrolysis_machine(FabricBlockSettings.of(Material.METAL));
        public static final BlockItem ELECTROLYSIS_MACHINE_ITEM = new BlockItem(ELECTROLYSIS_MACHINE,new Item.Settings());
        public static BlockEntityType<Electrolysis_machine_Entity> ELECTROLYSIS_MACHINE_ENTITY;
        public static ScreenHandlerType<Electrolysis_machine_ScreenHandler> ELECTROLYSIS_MACHINE_SCREEN_HANDLER;
        static
        {
            ELECTROLYSIS_MACHINE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(NAMESPACE, "electrolysis_machine"), Electrolysis_machine_ScreenHandler::new);
        }

    //Industry_crafting_table(工业工作台)
        public static final Industry_crafting_table INDUSTRY_CRAFTING_TABLE = new Industry_crafting_table(FabricBlockSettings.of(Material.METAL));
        public static final BlockItem INDUSTRY_CRAFTING_TABLE_ITEM = new BlockItem(INDUSTRY_CRAFTING_TABLE,new Item.Settings());
        public static BlockEntityType<Industry_crafting_table_Entity> INDUSTRY_CRAFTING_TABLE_ENTITY;
        public static ScreenHandlerType<Industry_crafting_table_ScreenHandler> INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER;
        static
        {
            INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(NAMESPACE,"industry_crafting_table"),Industry_crafting_table_ScreenHandler::new);
        }

    //创建物品组
    public static final ItemGroup MOD_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE,"mod_group"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.S_GAS_TANK))
            .build();
    @Override
    public void onInitialize() {
        //注册物品
        {
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"s_gas_tank"),S_GAS_TANK);

            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"m_gas_tank"),M_GAS_TANK);

            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"l_gas_tank"),L_GAS_TANK);
        }
        //注册方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)
        {
            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"electrolysis_machine"),ELECTROLYSIS_MACHINE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"electrolysis_machine"),ELECTROLYSIS_MACHINE_ITEM);
            ELECTROLYSIS_MACHINE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(NAMESPACE,"electrolysis_machine"), FabricBlockEntityTypeBuilder.create(Electrolysis_machine_Entity::new,ELECTROLYSIS_MACHINE).build(null));

            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"industry_crafting_table"),INDUSTRY_CRAFTING_TABLE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"industry_crafting_table"),INDUSTRY_CRAFTING_TABLE_ITEM);;
            INDUSTRY_CRAFTING_TABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(NAMESPACE,"industry_crafting_table"),FabricBlockEntityTypeBuilder.create(Industry_crafting_table_Entity::new,INDUSTRY_CRAFTING_TABLE).build(null));
        }


        //添加物品到物品组
        ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
            content.add(S_GAS_TANK);
            content.add(M_GAS_TANK);
            content.add(L_GAS_TANK);
            content.add(ELECTROLYSIS_MACHINE_ITEM);
            content.add(INDUSTRY_CRAFTING_TABLE_ITEM);
        });
    }

}
