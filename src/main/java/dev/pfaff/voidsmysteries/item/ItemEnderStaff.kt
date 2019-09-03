package dev.pfaff.voidsmysteries.item

import dev.pfaff.voidsmysteries.VoidsMysteries
import dev.pfaff.voidsmysteries.IHasLogger
import dev.pfaff.voidsmysteries.randInt
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.boss.WitherEntity
import net.minecraft.entity.boss.dragon.EnderDragonEntity
import net.minecraft.entity.monster.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.AbstractArrowEntity
import net.minecraft.item.ArrowItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ShootableItem
import net.minecraft.item.Items as MCItems
import net.minecraft.stats.Stats
import net.minecraft.tags.ItemTags
import net.minecraft.util.*
import net.minecraft.world.World
import java.util.*
import java.util.function.Predicate


class ItemEnderStaff : ShootableItem(Item.Properties().group(VoidsMysteries.CREATIVE_TAB).maxStackSize(1).maxDamage(324)), IHasLogger {
    override fun getInventoryAmmoPredicate(): Predicate<ItemStack> = Predicate { stack -> stack.item.isIn(ItemTags.ARROWS) }

    init {
        setRegistryName(VoidsMysteries.MOD_ID, "ender_staff")
    }

    override fun onLeftClickEntity(stack: ItemStack, player: PlayerEntity, entity: Entity): Boolean {
        val isCreative = player.isCreative
//        val world = player.entityWorld

//        val entX = entity.posX
//        val entY = entity.posY
//        val entZ = entity.posZ

        entity.remove()

        if (!isCreative) {
            val exp = when (entity) {
                is WitherEntity -> {
                    player.addItemStackToInventory(ItemStack(MCItems.NETHER_STAR, 1))
                    Random().randInt(38, 64)
                }
                is EnderDragonEntity -> {
//                    player.addItemStackToInventory(ItemStack(Items.DRAGON_HEART, 1))
                    player.addItemStackToInventory(ItemStack(MCItems.ENDER_PEARL, 16))
                    Random().randInt(103, 136)
                }
                is EndermanEntity -> {
                    player.addItemStackToInventory(ItemStack(MCItems.ENDER_PEARL, 1))
                    Random().randInt(11, 24)
                }
                is ElderGuardianEntity -> {
//                    player.addItemStackToInventory(ItemStack(Items.WATER, 1))
                    Random().randInt(24, 34)
                }
                is BlazeEntity -> {
//                    player.addItemStackToInventory(ItemStack(Items.FIRE, 1))
                    Random().randInt(11, 24)
                }
                is CreeperEntity -> {
//                    player.addItemStackToInventory(ItemStack(Items.LIGHTNING, 1))
                    Random().randInt(6, 13)
                }
                is LivingEntity -> {
//                    player.addItemStackToInventory(ItemStack(Items.SOUL, 1))
                    Random().randInt(-21, -9)
                }
                else -> Random().randInt(6, 13)
            }

            logger.debug("Giving player $exp experience levels on top of existing ${player.experienceLevel} levels")

            player.addExperienceLevel(exp)

            logger.debug("Player now has ${player.experienceLevel} levels")
        }

        return false
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    override fun onPlayerStoppedUsing(stack: ItemStack, worldIn: World, player: LivingEntity, timeLeft: Int) {
        if (player is PlayerEntity) {
            val ammoFlag = player.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0
            var ammoStack = player.findAmmo(stack)

            // We want shooting be instant
            val useDuration = getUseDuration(stack)
            val i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, player, useDuration/* - timeLeft*/, !ammoStack.isEmpty || ammoFlag)
//            if (i < 0) return

            if (!ammoStack.isEmpty || ammoFlag) {
                if (ammoStack.isEmpty) {
                    ammoStack = ItemStack(MCItems.ARROW)
                }

                val f = getArrowVelocity(useDuration)
                if (f.toDouble() >= 0.1) {
                    val flag1 = player.abilities.isCreativeMode || ammoStack.item is ArrowItem && (ammoStack.item as ArrowItem).isInfinite(ammoStack, stack, player)
                    if (!worldIn.isRemote) {
                        val arrowitem = (if (ammoStack.item is ArrowItem) ammoStack.item else net.minecraft.item.Items.ARROW) as ArrowItem
                        val abstractarrowentity = arrowitem.createArrow(worldIn, ammoStack, player)
                        abstractarrowentity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0f, f * 3.0f, 1.0f)
                        if (f == 1.0f) {
                            abstractarrowentity.isCritical = true
                        }

                        val j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack)
                        if (j > 0) {
                            abstractarrowentity.damage = abstractarrowentity.damage + j.toDouble() * 0.5 + 0.5
                        }

                        val k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack)
                        if (k > 0) {
                            abstractarrowentity.setKnockbackStrength(k)
                        }

                        abstractarrowentity.setFire(600)

                        abstractarrowentity.pierceLevel = 10

                        stack.damageItem(1, player, { playerEntity -> playerEntity.sendBreakAnimation(player.activeHand) })

                        abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY

                        worldIn.addEntity(abstractarrowentity)
                    }

                    worldIn.playSound(null as PlayerEntity?, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (Item.random.nextFloat() * 0.4f + 1.2f) + f * 0.5f)
                    if (!flag1 && !player.abilities.isCreativeMode) {
                        ammoStack.shrink(1)
                        if (ammoStack.isEmpty) {
                            player.inventory.deleteStack(ammoStack)
                        }
                    }

                    player.addStat(Stats.ITEM_USED.get(this))
                }
            }
        }
    }

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    private fun getArrowVelocity(charge: Int): Float {
        var f = charge.toFloat() / 20.0f
        f = (f * f + f * 2.0f) / 3.0f
        if (f > 1.0f) {
            f = 1.0f
        }

        return f
    }

    /**
     * How long it takes to use or consume an item
     */
    override fun getUseDuration(stack: ItemStack): Int {
        return 72000
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * [.onItemUse].
     */
    override fun onItemRightClick(world: World, player: PlayerEntity, hand: Hand): ActionResult<ItemStack> {
        val stack = player.getHeldItem(hand)
        val flag = !player.findAmmo(stack).isEmpty

        val ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, world, player, hand, flag)
        if (ret != null) return ret

        return if (!player.abilities.isCreativeMode && !flag) {
            if (flag) ActionResult(ActionResultType.PASS, stack) else ActionResult(ActionResultType.FAIL, stack)
        } else {
            player.activeHand = hand
            ActionResult(ActionResultType.SUCCESS, stack)
        }
    }

    /*override fun onItemRightClick(world: World, player: PlayerEntity, hand: Hand): ActionResult<ItemStack> {
        val itemstack = player.getHeldItem(hand)
        val flag = !this.findAmmo(player).isEmpty

        val ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, world, player, hand, flag)
        if (ret != null) return ret

        return if (!player.isCreative && !flag) {
            ActionResult(ActionResultType.FAIL, itemstack)
        } else {
            player.activeHand = hand
            ActionResult(ActionResultType.SUCCESS, itemstack)
        }
    }

    /**
     * Called when a player has stopped using (right click) this item.
     */
    override fun onPlayerStoppedUsing(itemStack: ItemStack, world: World, player: LivingEntity, timeLeft: Int) {
        if (player !is PlayerEntity) {
            logger.warn("[onPlayerStoppedUsing]: player was not a PlayerEntity")
            return super.onPlayerStoppedUsing(itemStack, world, player, timeLeft)
        }
        
        val isCreative = player.isCreative
        val ammo = findAmmo(player)

        var i = getMaxItemUseDuration() - timeLeft
        i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(itemStack, world, player, i, !ammo.isEmpty || isCreative)
        if (i < 0) return

        if (!ammo.isEmpty || isCreative) {
            val entityArrow = ArrowEntity(world, player)
            entityArrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0f, arrowVelocity, 1.0f)
            entityArrow.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY
            entityArrow.damage = arrowDamage

            MCItems.BOW

            if (!world.isRemote) {
                // I think this is equivalent to world.spawnEntity, which seems to have been replaced.
                world.addEntity(entityArrow)
            }

            if (!isCreative) {
                ammo.shrink(1)

                if (ammo.isEmpty) {
                    player.inventory.deleteStack(ammo)
                }
            }

            player.addStat(Stats.ITEM_USED.get(this))
        }
    }



    /**
     * How long it takes to use or consume an item
     */
    private fun getMaxItemUseDuration(): Int {
        return 100
    }

    private fun findAmmo(player: PlayerEntity): ItemStack = player.inventory.decrStackSize(player.inventory.getSlotFor(ItemStack(MCItems.ARROW)), 1)*/

    companion object {
        const val arrowDamage: Double = 100.0
        const val arrowVelocity: Float = 12.0f
    }
}

/*

Must port for new energy system (whatever that is).

if (!isCreative && ModConf.general.poweredByFE) {
            if (EnergyHelper.getEnergy(stack) - ModConf.enderStaff.enderStaffEnergyPerUseEntity > 0) {
                if (entity is EntityWither) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 1))
                    world.addEntity(item)
                } else if (entity is EntityDragon) {
                    if (EnergyHelper.getEnergy(stack) - ModConf.enderStaff.enderStaffEnergyPerUseEntityBoss > 0) {
                        val pos = entity.getPosition()
                        var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 4))
                        world.addEntity(item)
                        item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 16))
                        world.addEntity(item)
                        EnergyHelper.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseEntityBoss - ModConf.enderStaff.enderStaffEnergyPerUseEntity, stack)
                    }
                } else if (entity is EntityEnderman) {
                    val pos = entity.getPosition()
                    var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                    item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 1))
                    world.addEntity(item)
                } else if (entity is EntityGuardian || entity is EntityElderGuardian) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                    val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_WATER, 1))
                    world.addEntity(item2)
                } else if (entity is EntityBlaze) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                    val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_FLAME, 1))
                    world.addEntity(item2)
                } else if (entity is EntityCreeper) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                    val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_ENERGY, 1))
                    world.addEntity(item2)
                } else if (entity is EntityLiving) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                } else if (entity is EntityLivingBase) {
                    val pos = entity.getPosition()
                    val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                    world.addEntity(item)
                }
                EnergyHelper.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseEntity, stack)
                entity.setDead()
            }
        } else if (!isCreative) {
            if (entity is EntityWither) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 1))
                world.addEntity(item)
            } else if (entity is EntityDragon) {
                val pos = entity.getPosition()
                var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 4))
                world.addEntity(item)
                item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 16))
                world.addEntity(item)
            } else if (entity is EntityEnderman) {
                val pos = entity.getPosition()
                var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 1))
                world.addEntity(item)
            } else if (entity is EntityGuardian || entity is EntityElderGuardian) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_WATER, 1))
                world.addEntity(item2)
            } else if (entity is EntityBlaze) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_FLAME, 1))
                world.addEntity(item2)
            } else if (entity is EntityCreeper) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_ENERGY, 1))
                world.addEntity(item2)
            } else if (entity is EntityLiving) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
            } else if (entity is EntityLivingBase) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
            }
            entity.setDead()
        } else {
            if (entity is EntityWither) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 1))
                world.addEntity(item)
            } else if (entity is EntityDragon) {
                val pos = entity.getPosition()
                var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.NETHER_STAR, 4))
                world.addEntity(item)
                item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 16))
                world.addEntity(item)
            } else if (entity is EntityEnderman) {
                val pos = entity.getPosition()
                var item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(Items.ENDER_PEARL, 1))
                world.addEntity(item)
            } else if (entity is EntityGuardian || entity is EntityElderGuardian) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_WATER, 1))
                world.addEntity(item2)
            } else if (entity is EntityBlaze) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_FLAME, 1))
                world.addEntity(item2)
            } else if (entity is EntityCreeper) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
                val item2 = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_ENERGY, 1))
                world.addEntity(item2)
            } else if (entity is EntityLiving) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
            } else if (entity is EntityLivingBase) {
                val pos = entity.getPosition()
                val item = ItemEntity(world, entity.posX, entity.posY, entity.posZ, ItemStack(ModItems.PRIMORDIAL_SOUL, 1))
                world.addEntity(item)
            }
            entity.setDead()
        }

*/