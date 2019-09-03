package dev.pfaff.voidsmysteries.item

import dev.pfaff.voidsmysteries.VoidsMysteries
import dev.pfaff.voidsmysteries.regName
import net.minecraft.block.Block
import net.minecraft.item.BlockItem

class ItemBlockStd(block: Block) : BlockItem(block, Properties().group(VoidsMysteries.CREATIVE_TAB)) {
    init {
        setRegistryName(block.regName)
    }
}