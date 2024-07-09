package com.awsdkl.periodictableofelements;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.awsdkl.periodictableofelements.PeriodicTableOfElements.NAMESPACE;

public class ModGroups {
    public static final RegistryKey<ItemGroup> MOD_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "mod_group"));
    public static final RegistryKey<ItemGroup> PTOE_NATURAL_BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "ptoe_natural_blocks"));
    public static final RegistryKey<ItemGroup> PTOE_INGREDIENTS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "ptoe_ingredient"));
}
