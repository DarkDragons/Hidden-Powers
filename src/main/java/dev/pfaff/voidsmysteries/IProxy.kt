package dev.pfaff.voidsmysteries

import net.minecraft.world.World

interface IProxy {
    val clientWorld: World?

    val instanceType: InstanceType
}
