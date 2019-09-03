package dev.pfaff.voidsmysteries

import net.minecraft.client.Minecraft
import net.minecraft.world.World

internal class ClientProxy : IProxy {
    override val clientWorld: World?
        get() = Minecraft.getInstance().world

    override val instanceType: InstanceType
        get() = InstanceType.Client
}
