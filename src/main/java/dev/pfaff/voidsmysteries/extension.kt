package dev.pfaff.voidsmysteries

import net.minecraft.block.Block
import net.minecraft.item.Item
import java.util.*
import kotlin.streams.toList

val Item.regName: String get() = registryName!!.toString()

val Item.namespace: String get() = registryName!!.namespace

val Item.path: String get() = registryName!!.path

val Block.regName: String get() = registryName!!.toString()

val Block.namespace: String get() = registryName!!.namespace

val Block.path: String get() = registryName!!.path

fun Random.randInt(origin: Int, bound: Int): Int {
    val index = Random().nextInt(100)
    val possibilities = ints(100, origin, bound)
    return possibilities.toList()[index]
}

fun Random.randDouble(origin: Double, bound: Double): Double {
    val index = Random().nextInt(100)
    val possibilities = doubles(100, origin, bound)
    return possibilities.toList()[index]
}

fun Random.randLong(origin: Long, bound: Long): Long {
    val index = Random().nextInt(100)
    val possibilities = longs(100, origin, bound)
    return possibilities.toList()[index]
}