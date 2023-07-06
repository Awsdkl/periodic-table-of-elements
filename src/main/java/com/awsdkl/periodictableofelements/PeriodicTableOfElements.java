package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.Electrolyzer_machine;
import com.awsdkl.periodictableofelements.block.Industry_crafting_table;
import com.awsdkl.periodictableofelements.block.entities.Electrolyzer_machine_Entity;
import com.awsdkl.periodictableofelements.block.entities.Industry_crafting_table_Entity;
import com.awsdkl.periodictableofelements.client.recipes.Gas_tank_Recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Air_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks.Industry_crafting_table_ICT_recipes;
import com.awsdkl.periodictableofelements.item.Gas_tank;
import com.awsdkl.periodictableofelements.screen.handler.Electrolyzer_machine_ScreenHandler;
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
    public static final Item HAMMER = new Item(new Item.Settings().maxCount(1));
    public static final Item SHEARS = new Item(new Item.Settings().maxCount(1));
    public static final Item IRON_PLATE = new Item(new Item.Settings());
    public static final Item TIN_PLATE = new Item(new Item.Settings());
    public static final Item TEST_FAN = new Item(new Item.Settings().maxCount(1));

    //创建方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)

    //Electrolyzer_machine(电解装置)
    public static final Electrolyzer_machine ELECTROLYZER_MACHINE = new Electrolyzer_machine(FabricBlockSettings.of(Material.METAL));
    public static final BlockItem ELECTROLYZER_MACHINE_ITEM = new BlockItem(ELECTROLYZER_MACHINE,new Item.Settings());
    public static BlockEntityType<Electrolyzer_machine_Entity> ELECTROLYZER_MACHINE_ENTITY;
    public static ScreenHandlerType<Electrolyzer_machine_ScreenHandler> ELECTROLYZER_MACHINE_SCREEN_HANDLER;
    static
    {
        ELECTROLYZER_MACHINE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(NAMESPACE, "electrolyzer_machine"), Electrolyzer_machine_ScreenHandler::new);
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
            .icon(() -> new ItemStack(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_ITEM))
            .build();
    @Override
    public void onInitialize() {
        //注册物品
        {
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"s_gas_tank"),S_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"m_gas_tank"),M_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"l_gas_tank"),L_GAS_TANK);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"shears"),SHEARS);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"hammer"),HAMMER);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"iron_plate"),IRON_PLATE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"tin_plate"),TIN_PLATE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"test_fan"),TEST_FAN);
        }
        //注册方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)
        {
            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"electrolyzer_machine"),ELECTROLYZER_MACHINE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"electrolyzer_machine"),ELECTROLYZER_MACHINE_ITEM);
            ELECTROLYZER_MACHINE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(NAMESPACE,"electrolyzer_machine"), FabricBlockEntityTypeBuilder.create(Electrolyzer_machine_Entity::new,ELECTROLYZER_MACHINE).build(null));

            Registry.register(Registries.BLOCK,new Identifier(NAMESPACE,"industry_crafting_table"),INDUSTRY_CRAFTING_TABLE);
            Registry.register(Registries.ITEM,new Identifier(NAMESPACE,"industry_crafting_table"),INDUSTRY_CRAFTING_TABLE_ITEM);
            INDUSTRY_CRAFTING_TABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier(NAMESPACE,"industry_crafting_table"),FabricBlockEntityTypeBuilder.create(Industry_crafting_table_Entity::new,INDUSTRY_CRAFTING_TABLE).build(null));
        }


        //添加物品到物品组
        ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
            content.add(S_GAS_TANK);
            content.add(M_GAS_TANK);
            content.add(L_GAS_TANK);
            content.add(ELECTROLYZER_MACHINE_ITEM);
            content.add(INDUSTRY_CRAFTING_TABLE_ITEM);
            content.add(HAMMER);
            content.add(SHEARS);
            content.add(IRON_PLATE);
            content.add(TIN_PLATE);
        });

        //添加工业工作台的配方
        Industry_crafting_table_Entity.ict_recipes.add(0,new Air_ICT_recipes("air"));
        Industry_crafting_table_Entity.addRecipes(new Industry_crafting_table_ICT_recipes());
    }

}
