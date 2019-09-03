package dev.pfaff.voidsmysteries

import dev.pfaff.voidsmysteries.registry.Items
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn


class TabStd(path: String) : ItemGroup(path) {
    init {
        setTabPath(path)
    }

    @OnlyIn(Dist.CLIENT)
    override fun createIcon(): ItemStack {
        return ItemStack(Items.ender_staff)
    }
}