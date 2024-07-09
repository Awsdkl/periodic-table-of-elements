package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.Registry.FlammableBlock;
import com.awsdkl.periodictableofelements.Registry.StrippableBlock;
import com.awsdkl.periodictableofelements.block.entities.Copper_cable_Entity;
import com.awsdkl.periodictableofelements.block.entities.Electrolyzer_machine_Entity;
import com.awsdkl.periodictableofelements.block.entities.Generator_Entity;
import com.awsdkl.periodictableofelements.block.entities.Industry_crafting_table_Entity;
import com.awsdkl.periodictableofelements.client.recipes.Gas_tank_Recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Air_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks.Generator_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks.Industry_crafting_table_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items.*;
import com.awsdkl.periodictableofelements.screen.handler.Electrolyzer_machine_ScreenHandler;
import com.awsdkl.periodictableofelements.screen.handler.Generator_ScreenHandler;
import com.awsdkl.periodictableofelements.screen.handler.Industry_crafting_table_ScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeriodicTableOfElements implements ModInitializer {
    public static final String NAMESPACE = "periodic-table-of-elements";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);
    //特殊合成表
    public static final RecipeSerializer<Gas_tank_Recipes> GAS_TANK_RECIPE = RecipeSerializer.register("gas_tank_recipe", new SpecialRecipeSerializer<>(Gas_tank_Recipes::new));
    //Electrolyzer_machine(电解装置)
    public static BlockEntityType<Electrolyzer_machine_Entity> ELECTROLYZER_MACHINE_ENTITY;
    public static ScreenHandlerType<Electrolyzer_machine_ScreenHandler> ELECTROLYZER_MACHINE_SCREEN_HANDLER;

    static
    {
        ELECTROLYZER_MACHINE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,new Identifier(NAMESPACE, "electrolyzer_machine"), new ExtendedScreenHandlerType<>(Electrolyzer_machine_ScreenHandler::new));
    }

    //Industry_crafting_table(工业工作台)
    public static BlockEntityType<Industry_crafting_table_Entity> INDUSTRY_CRAFTING_TABLE_ENTITY;
    public static ScreenHandlerType<Industry_crafting_table_ScreenHandler> INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER;

    static
    {
        INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(NAMESPACE, "industry_crafting_table"), new ExtendedScreenHandlerType<>(Industry_crafting_table_ScreenHandler::new));
    }

    //Generator(火力发电机)
    public static BlockEntityType<Generator_Entity> GENERATOR_ENTITY;
    public static ScreenHandlerType<Generator_ScreenHandler> GENERATOR_SCREEN_HANDLER;
    static
    {
        GENERATOR_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(NAMESPACE,"generator"), new ExtendedScreenHandlerType<>(Generator_ScreenHandler::new));
    }

    //Copper_cable(铜制线缆)
    public static BlockEntityType<Copper_cable_Entity> COPPER_CABLE_ENTITY;

    @Override
    public void onInitialize()
    {
        LOGGER.info("Start loading Periodic Table of Elements!");
        //注册物品
        //注册方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)
        //electrolyzer_machine(电解装置)
        ELECTROLYZER_MACHINE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "electrolyzer_machine"), FabricBlockEntityTypeBuilder.create(Electrolyzer_machine_Entity::new, ModBlocks.ELECTROLYZER_MACHINE).build(null));
        //industry_crafting_table(工业工作台)
        INDUSTRY_CRAFTING_TABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "industry_crafting_table"), FabricBlockEntityTypeBuilder.create(Industry_crafting_table_Entity::new, ModBlocks.INDUSTRY_CRAFTING_TABLE).build(null));
        //generator(火力发电机)
        GENERATOR_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "generator"), FabricBlockEntityTypeBuilder.create(Generator_Entity::new, ModBlocks.GENERATOR).build(null));
        //copper_cable(铜质线缆)
        COPPER_CABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "copper_cable"), FabricBlockEntityTypeBuilder.create(Copper_cable_Entity::new, ModBlocks.COPPER_CABLE).build(null));

        // 注册物品组并添加物品到物品组
        LOGGER.info("Registering Item Groups");
        com.awsdkl.periodictableofelements.Registry.Groups.Companion.init();

        LOGGER.info("Applying recipes to Industrial Crafting Table");
        //添加工业工作台的配方
        /*0 :空气*/           Industry_crafting_table_Entity.addShapedRecipes(new Air_ICT_recipes());
        /*1 :工业工作台*/      Industry_crafting_table_Entity.addShapedRecipes(new Industry_crafting_table_ICT_recipes());
        /*2 :火力发电机*/      Industry_crafting_table_Entity.addShapedRecipes(new Generator_ICT_recipes());
        /*3 :工业锤子*/        Industry_crafting_table_Entity.addShapedRecipes(new Hammer_ICT_recipes());
        /*4 :工业剪刀*/        Industry_crafting_table_Entity.addShapedRecipes(new Shears_ICT_recipes());
        /*5 :电池*/           Industry_crafting_table_Entity.addShapedRecipes(new Battery_ICT_recipes());

        /*0 :空气*/           Industry_crafting_table_Entity.addShapelessRecipes(new Air_ICT_recipes());
        /*1 :锡板*/           Industry_crafting_table_Entity.addShapelessRecipes(new Tin_plate_ICT_recipes());
        /*2 :Copper Plate*/
        Industry_crafting_table_Entity.addShapelessRecipes(new Copper_plate_ICT_recipes());

        LOGGER.info("Registering Blocks and Items");
        StrippableBlock.init();
        FlammableBlock.init();
        com.awsdkl.periodictableofelements.Registry.Block.init();
        com.awsdkl.periodictableofelements.Registry.Item.init();
    }
}
