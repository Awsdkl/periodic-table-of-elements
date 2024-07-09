package com.awsdkl.periodictableofelements.Registry

import com.awsdkl.periodictableofelements.ModBlocks
import com.awsdkl.periodictableofelements.ModGroups.*
import com.awsdkl.periodictableofelements.ModItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text

class Groups {
    // ModGroup Object
    object ModGroup {
        private fun registerGroup(): Unit {
            register(MOD_GROUP, ModItems.INDUSTRY_CRAFTING_TABLE_ITEM, "itemGroup.periodic-table-of-elements.mod_group")
        }

        private fun addItems(): Unit {
            ItemGroupEvents.modifyEntriesEvent(MOD_GROUP).register(
                ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                    content.add(ModItems.S_GAS_TANK)
                    content.add(ModItems.M_GAS_TANK)
                    content.add(ModItems.L_GAS_TANK)
                    content.add(ModItems.ELECTROLYZER_MACHINE_ITEM)
                    content.add(ModItems.ELECTROLYZER_MACHINE_ITEM)
                    content.add(ModItems.INDUSTRY_CRAFTING_TABLE_ITEM)
                    content.add(ModItems.GENERATOR_ITEM)
                    content.add(ModItems.TIN_ORE_ITEM)
                    content.add(ModItems.HAMMER)
                    content.add(ModItems.SHEARS)
                    content.add(ModItems.IRON_PLATE)
                    content.add(ModItems.TIN_PLATE)
                    content.add(ModItems.COPPER_PLATE)
                    content.add(ModItems.BATTERY)
                }
            )
        }

        fun init(): Unit {
            registerGroup() // Register MOD_GROUP
            addItems() // Add Items to Group
        }
    }

    object NaturalBlocks {
        private fun registerGroup(): Unit {
            register(
                PTOE_NATURAL_BLOCKS,
                ModItems.TIN_ORE_ITEM,
                "itemGroup.periodic-table-of-elements.ptoe_natural_block"
            )
        }

        private fun addItem() {
            ItemGroupEvents.modifyEntriesEvent(PTOE_NATURAL_BLOCKS).register(
                ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                    content.add(ModBlocks.TIN_ORE)
                    content.add(ModBlocks.DEEPSLATE_TIN_ORE)
                }
            )
        }

        fun init(): Unit {
            registerGroup() // Register PTOE_NATURAL_BLOCK
            addItem() // add items to NaturalBlocks
        }
    }

    object Ingredients {
        private fun registerGroup(): Unit {
            register(PTOE_INGREDIENTS, ModItems.TIN_INGOT, "itemGroup.periodic-table-of-elements.ptoe_ingredients")
        }

        private fun addItem(): Unit {
            ItemGroupEvents.modifyEntriesEvent(PTOE_INGREDIENTS).register(
                ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                    content.add(ModItems.TIN_RAW)
                    content.add(ModItems.TIN_RAW_BLOCK_ITEM)
                    content.add(ModItems.TIN_INGOT)
                }
            )
        }

        fun init(): Unit {
            registerGroup() // Register PTOE_INGREDIENT
            addItem() // Add items
        }
    }

    companion object {
        /**
         * @param registryKey
         * @param iconItem
         * @param translation
         */
        private fun register(registryKey: RegistryKey<ItemGroup>, iconItem: Item, translation: String): Unit {
            Registry.register(
                Registries.ITEM_GROUP, registryKey, FabricItemGroup.builder()
                    .icon { ItemStack(iconItem) }
                    .displayName(Text.translatable(translation))
                    .build()
            )
        }

        fun init(): Unit {
            // Init Mod Group
            ModGroup.init()
            // 元素周期表 自然方块(PTOE Natural Blocks)物品组
            NaturalBlocks.init()
            // 元素周期表 原材料(PTOE Ingredients)物品组
            Ingredients.init()
        }
    }
}