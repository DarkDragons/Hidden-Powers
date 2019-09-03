package dev.pfaff.voidsmysteries

enum class HarvestLevel(val value: Int) {
    Wood(0),
    Stone(1),
    Iron(2),
    Diamond(3),
    Obsidian(4),
    CompObsidian1(5),
    CompObsidian2(6),
    CompObsidian3(7),
    CompObsidian4(8),
    Bedrock(Int.MAX_VALUE)
}