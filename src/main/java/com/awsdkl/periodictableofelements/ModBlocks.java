package com.awsdkl.periodictableofelements;

import com.awsdkl.periodictableofelements.block.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks
{
    public static final Electrolyzer_machine ELECTROLYZER_MACHINE = new Electrolyzer_machine(FabricBlockSettings.create());
    public static final Industry_crafting_table INDUSTRY_CRAFTING_TABLE = new Industry_crafting_table(FabricBlockSettings.create());
    public static final Generator GENERATOR = new Generator(FabricBlockSettings.create());
    public static final Copper_cable COPPER_CABLE = new Copper_cable(FabricBlockSettings.create());
    public static final Block TIN_ORE = new Block(FabricBlockSettings.create().requiresTool().strength(3.0F, 3.0F));
    public static final Block DEEPSLATE_TIN_ORE = new Block(FabricBlockSettings.create().requiresTool().strength(4.5F, 3.0F));
    public static final Block TIN_RAW_BLOCK = new Block(FabricBlockSettings.create());
    public static final Rubber_log RUBBER_LOG = new Rubber_log(FabricBlockSettings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final LeavesBlock RUBBER_LEAVES = Blocks.createLeavesBlock(BlockSoundGroup.GRASS);
    public static final Rubber_wood RUBBER_WOOD = new Rubber_wood(FabricBlockSettings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block RUBBER_PLANKS = new Block(FabricBlockSettings.create());
    public static final Stripped_rubber_log STRIPPED_RUBBER_LOG = new Stripped_rubber_log(FabricBlockSettings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Stripped_rubber_wood STRIPPED_RUBBER_WOOD = new Stripped_rubber_wood(FabricBlockSettings.create().strength(2.0F).sounds(BlockSoundGroup.WOOD));
}
