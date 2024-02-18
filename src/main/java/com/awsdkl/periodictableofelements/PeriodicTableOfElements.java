package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.blocks.Copper_cable;
import com.awsdkl.periodictableofelements.block.blocks.Electrolyzer_machine;
import com.awsdkl.periodictableofelements.block.blocks.Generator;
import com.awsdkl.periodictableofelements.block.blocks.Industry_crafting_table;
import com.awsdkl.periodictableofelements.block.entities.Copper_cable_Entity;
import com.awsdkl.periodictableofelements.block.entities.Electrolyzer_machine_Entity;
import com.awsdkl.periodictableofelements.block.entities.Generator_Entity;
import com.awsdkl.periodictableofelements.block.entities.Industry_crafting_table_Entity;
import com.awsdkl.periodictableofelements.client.recipes.Gas_tank_Recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Air_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks.Generator_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Blocks.Industry_crafting_table_ICT_recipes;
import com.awsdkl.periodictableofelements.client.recipes.ICT_Recipes.Items.*;
import com.awsdkl.periodictableofelements.item.Battery;
import com.awsdkl.periodictableofelements.item.Gas_tank;
import com.awsdkl.periodictableofelements.screen.handler.Electrolyzer_machine_ScreenHandler;
import com.awsdkl.periodictableofelements.screen.handler.Generator_ScreenHandler;
import com.awsdkl.periodictableofelements.screen.handler.Industry_crafting_table_ScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
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

    //小气体储罐
    public static final Gas_tank S_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    //中气体储罐
    public static final Gas_tank M_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    //大气体储罐
    public static final Gas_tank L_GAS_TANK = new Gas_tank(new Item.Settings().maxCount(1));
    //工业锤子
    public static final Item HAMMER = new Item(new Item.Settings().maxCount(1));
    //工业剪刀
    public static final Item SHEARS = new Item(new Item.Settings().maxCount(1));
    //铁板
    public static final Item IRON_PLATE = new Item(new Item.Settings());
    //锡板
    public static final Item TIN_PLATE = new Item(new Item.Settings());
    //测试风扇
    public static final Item TEST_FAN = new Item(new Item.Settings().maxCount(1));
    //电池
    public static final Battery BATTERY = new Battery(new Item.Settings().maxCount(1).maxDamage(100));
    //粗锡
    public static final Item TIN_RAW = new Item(new Item.Settings());
    //锡锭
    public static final Item TIN_INGOT = new Item(new Item.Settings());
    //铜板
    public static final Item COPPER_PLATE = new Item(new Item.Settings());
    //铜线
    public static final Item COPPER_WIRE = new Item(new Item.Settings());

    //创建方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)

    //Electrolyzer_machine(电解装置)
    public static final Electrolyzer_machine ELECTROLYZER_MACHINE = new Electrolyzer_machine(FabricBlockSettings.of(Material.METAL));
    public static final BlockItem ELECTROLYZER_MACHINE_ITEM = new BlockItem(ELECTROLYZER_MACHINE, new Item.Settings());
    public static BlockEntityType<Electrolyzer_machine_Entity> ELECTROLYZER_MACHINE_ENTITY;
    public static ScreenHandlerType<Electrolyzer_machine_ScreenHandler> ELECTROLYZER_MACHINE_SCREEN_HANDLER;

    static
    {
        ELECTROLYZER_MACHINE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,new Identifier(NAMESPACE, "electrolyzer_machine"), new ExtendedScreenHandlerType<>(Electrolyzer_machine_ScreenHandler::new));
    }

    //Industry_crafting_table(工业工作台)
    public static final Industry_crafting_table INDUSTRY_CRAFTING_TABLE = new Industry_crafting_table(FabricBlockSettings.of(Material.METAL));
    public static final BlockItem INDUSTRY_CRAFTING_TABLE_ITEM = new BlockItem(INDUSTRY_CRAFTING_TABLE, new Item.Settings());
    public static BlockEntityType<Industry_crafting_table_Entity> INDUSTRY_CRAFTING_TABLE_ENTITY;
    public static ScreenHandlerType<Industry_crafting_table_ScreenHandler> INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER;

    static
    {
        INDUSTRY_CRAFTING_TABLE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(NAMESPACE, "industry_crafting_table"), new ExtendedScreenHandlerType<>(Industry_crafting_table_ScreenHandler::new));
    }

    //Generator(火力发电机)
    public static final Generator GENERATOR = new Generator(FabricBlockSettings.of(Material.METAL));
    public static final BlockItem GENERATOR_ITEM = new BlockItem(GENERATOR, new Item.Settings());
    public static BlockEntityType<Generator_Entity> GENERATOR_ENTITY;
    public static ScreenHandlerType<Generator_ScreenHandler> GENERATOR_SCREEN_HANDLER;
    static
    {
        GENERATOR_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(NAMESPACE,"generator"), new ExtendedScreenHandlerType<>(Generator_ScreenHandler::new));
    }

    //Copper_cable(铜制线缆)
    public static final Copper_cable COPPER_CABLE = new Copper_cable(FabricBlockSettings.of(Material.METAL));
    public static final BlockItem COPPER_CABLE_ITEM = new BlockItem(COPPER_CABLE, new Item.Settings());
    public static BlockEntityType<Copper_cable_Entity> COPPER_CABLE_ENTITY;

    //tin_ore(锡矿石)
    public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final BlockItem TIN_ORE_ITEM = new BlockItem(TIN_ORE,new Item.Settings());

    //deepslate_tin_ore(深层锡矿石)
    public static final Block DEEPSLATE_TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.DEEPSLATE_GRAY).requiresTool().strength(4.5F,3.0F));
    public static final BlockItem DEEPSLATE_TIN_ORE_ITEM = new BlockItem(DEEPSLATE_TIN_ORE,new Item.Settings());

    //tin_raw_block(粗锡块)
    public static final Block TIN_RAW_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.RAW_IRON_PINK));
    public static final BlockItem TIN_RAW_BLOCK_ITEM = new BlockItem(TIN_RAW_BLOCK,new Item.Settings());

    //创建物品组
    public static final ItemGroup MOD_GROUP = FabricItemGroup.builder(new Identifier(NAMESPACE, "mod_group"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.INDUSTRY_CRAFTING_TABLE_ITEM))
            .build();
    //元素周期表 自然方块(PTOE Natural Blocks)物品组
    public static final ItemGroup PTOE_NATURAL_BLOCKS = FabricItemGroup.builder(new Identifier(NAMESPACE,"ptoe_natural_blocks"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.TIN_ORE))
            .build();
    //元素周期表 原材料(PTOE Ingredients)物品组
    public static final ItemGroup PTOE_INGREDIENTS = FabricItemGroup.builder(new Identifier(NAMESPACE,"ptoe_ingredients"))
            .icon(() -> new ItemStack(PeriodicTableOfElements.TIN_INGOT))
            .build();

    @Override
    public void onInitialize()
    {
        //注册物品
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "s_gas_tank"), S_GAS_TANK);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "m_gas_tank"), M_GAS_TANK);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "l_gas_tank"), L_GAS_TANK);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "shears"), SHEARS);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "hammer"), HAMMER);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "iron_plate"), IRON_PLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_plate"), TIN_PLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "test_fan"), TEST_FAN);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "battery"),BATTERY);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_raw"),TIN_RAW);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "tin_ingot"),TIN_INGOT);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_plate"),COPPER_PLATE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_wire"), COPPER_WIRE);

        //注册方块及其物品(还有一些杂项，一个方块的东西将会被放在一起)

        //electrolyzer_machine(电解装置)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "electrolyzer_machine"), ELECTROLYZER_MACHINE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "electrolyzer_machine"), ELECTROLYZER_MACHINE_ITEM);
        ELECTROLYZER_MACHINE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "electrolyzer_machine"), FabricBlockEntityTypeBuilder.create(Electrolyzer_machine_Entity::new, ELECTROLYZER_MACHINE).build(null));
        //industry_crafting_table(工业工作台)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "industry_crafting_table"), INDUSTRY_CRAFTING_TABLE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "industry_crafting_table"), INDUSTRY_CRAFTING_TABLE_ITEM);
        INDUSTRY_CRAFTING_TABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "industry_crafting_table"), FabricBlockEntityTypeBuilder.create(Industry_crafting_table_Entity::new, INDUSTRY_CRAFTING_TABLE).build(null));
        //generator(火力发电机)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "generator"), GENERATOR);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "generator"), GENERATOR_ITEM);
        GENERATOR_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "generator"), FabricBlockEntityTypeBuilder.create(Generator_Entity::new, GENERATOR).build(null));
        //copper_cable(铜质线缆)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "copper_cable"), COPPER_CABLE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "copper_cable"), COPPER_CABLE_ITEM);
        COPPER_CABLE_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NAMESPACE, "copper_cable"), FabricBlockEntityTypeBuilder.create(Copper_cable_Entity::new, COPPER_CABLE).build(null));

        //tin_ore(锡矿石)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE,"tin_ore"), TIN_ORE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE,"tin_ore"), TIN_ORE_ITEM);
        //deepslate_tin_ore(深层锡矿石)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE,"deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE,"deepslate_tin_ore"), DEEPSLATE_TIN_ORE_ITEM);
        //tin_raw_block(粗锡块)
        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE,"tin_raw_block"),TIN_RAW_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE,"tin_raw_block"),TIN_RAW_BLOCK_ITEM);


        //添加物品到物品组
        // block arraies
        Gas_tank modGroup_GasTank[] = {S_GAS_TANK, M_GAS_TANK, L_GAS_TANK};
        Block naturalBlocks[] = {TIN_ORE, DEEPSLATE_TIN_ORE, TIN_RAW_BLOCK};
        BlockItem modGroup_BlockItem[] = {ELECTROLYZER_MACHINE_ITEM, INDUSTRY_CRAFTING_TABLE_ITEM, GENERATOR_ITEM, TIN_ORE_ITEM};
        Item ingredients[] = {TIN_RAW, TIN_INGOT};
        Item modGroup_Item[] = {HAMMER, SHEARS, IRON_PLATE, TIN_PLATE, TIN_RAW, COPPER_PLATE};
        Battery modGroup_battery[] = {BATTERY};

        ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(content -> {
            // the i is the size of array
            for (Gas_tank gasTank : modGroup_GasTank) {
                content.add(gasTank);
            }
            for (BlockItem blockItem : modGroup_BlockItem) {
                content.add(blockItem);
            }
            for (Item item : modGroup_Item) {
                content.add(item);
            }
            for (Battery battery : modGroup_battery) {
                content.add(battery);
            }
        });

        ItemGroupEvents.modifyEntriesEvent(PTOE_NATURAL_BLOCKS).register(content -> {
            for (Block naturalBlock : naturalBlocks) {
                content.add(naturalBlock);
            }
        });

        ItemGroupEvents.modifyEntriesEvent(PTOE_INGREDIENTS).register(content -> {
            for (Item ingredient : ingredients) {
                content.add(ingredient);
            }
        });

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

        // Hanatomizu: Uhh my fcitx5 doesn't work in Intellij Idea for no reason QAQ

    }
}
