package dev.pfaff.voidsmysteries

import net.minecraft.block.Blocks
import net.minecraft.item.IItemTier
import net.minecraft.item.Items
import net.minecraft.item.crafting.Ingredient
import net.minecraft.tags.ItemTags
import net.minecraft.util.LazyLoadBase
import java.util.function.Supplier

enum class ItemTier constructor(harvestLevel: Int, maxUses: Int, efficiency: Float, attackDamage: Float, enchantability: Int, repairMatSupplier: Supplier<Ingredient>) : IItemTier {
    /*
     *
     * Wood through Gold are duplicates of the Minecraft implementation of IItemTier and are for informational purposes *only*.
     */
    WOOD(0, 59, 2.0f, 0.0f, 15, Supplier { Ingredient.fromTag(ItemTags.PLANKS) }),
    STONE(1, 131, 4.0f, 1.0f, 5, Supplier { Ingredient.fromItems(Blocks.COBBLESTONE) }),
    IRON(2, 250, 6.0f, 2.0f, 14, Supplier { Ingredient.fromItems(Items.IRON_INGOT) }),
    DIAMOND(3, 1561, 8.0f, 3.0f, 10, Supplier { Ingredient.fromItems(Items.DIAMOND) }),
    GOLD(0, 32, 12.0f, 0.0f, 22, Supplier { Ingredient.fromItems(Items.GOLD_INGOT) }),
    OBSIDIAN(4, 3600, 10.0f, 4.0f, 18, Supplier { Ingredient.fromItems(Items.OBSIDIAN) });
    //DIAMOND(3, 1561, 8.0f, 3.0f, 10, Supplier { Ingredient.fromItems(*arrayOf<IItemProvider>(Items.DIAMOND)) }),
    //DIAMOND(3, 1561, 8.0f, 3.0f, 10, Supplier { Ingredient.fromItems(*arrayOf<IItemProvider>(Items.DIAMOND)) }),

    private val _harvestLevel = harvestLevel
    override fun getHarvestLevel(): Int = _harvestLevel

    private val _maxUses = maxUses
    override fun getMaxUses(): Int = _maxUses

    private val _efficiency = efficiency
    override fun getEfficiency(): Float = _efficiency

    private val _attackDamage = attackDamage
    override fun getAttackDamage(): Float = _attackDamage

    private val _enchantability = enchantability
    override fun getEnchantability(): Int = _enchantability


    private val repairMaterial: LazyLoadBase<Ingredient> = LazyLoadBase(repairMatSupplier)
    override fun getRepairMaterial(): Ingredient = this.repairMaterial.value

    companion object {
        @JvmStatic
        val obsidianTiers: List<ItemTier> = listOf(OBSIDIAN)
    }
}
