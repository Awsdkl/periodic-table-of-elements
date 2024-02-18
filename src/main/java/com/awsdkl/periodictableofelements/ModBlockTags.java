package com.awsdkl.periodictableofelements;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags
{
    public static final TagKey<Block> RUBBER_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(PeriodicTableOfElements.NAMESPACE, "rubber_logs"));
}
