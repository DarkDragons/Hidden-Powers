package dev.pfaff.voidsmysteries

import net.minecraft.world.World

internal class ServerProxy : IProxy {
    override val clientWorld: World?
        get() = throw IllegalStateException("getClientWorld should only be called from the client!")

    override val instanceType: InstanceType
        get() = InstanceType.Server
}
