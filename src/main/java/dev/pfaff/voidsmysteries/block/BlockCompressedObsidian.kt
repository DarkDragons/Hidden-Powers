package dev.pfaff.voidsmysteries.block

import dev.pfaff.voidsmysteries.VoidsMysteries
import dev.pfaff.voidsmysteries.HarvestLevel
import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraftforge.common.ToolType

class BlockCompressedObsidian(level: Int) : Block(buildProps(level)) {
    init {
        setRegistryName(VoidsMysteries.MOD_ID, "compressed_obsidian_block_$level")
    }

    companion object {
        @JvmStatic
        fun buildProps(level: Int): Properties = Properties.create(Material.GLASS)
                .sound(SoundType.GLASS)
                .hardnessAndResistance(50f + 5 * level, 6000f + 1000 * level)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(HarvestLevel.values()[level + 4].value)
    }
}