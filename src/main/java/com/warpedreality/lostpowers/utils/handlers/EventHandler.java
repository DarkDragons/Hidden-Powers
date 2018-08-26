package com.warpedreality.lostpowers.utils.handlers;

import com.warpedreality.lostpowers.ModConf;
import com.warpedreality.lostpowers.init.ModEffects;
import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.utils.EnergyHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class EventHandler {

    /*public static void register() {
        MinecraftForge.EVENT_BUS.register(new EventVoidMultitoolBlock());
        MinecraftForge.EVENT_BUS.register(new EventMobDrops());
        MinecraftForge.EVENT_BUS.register(new EventPlayerAttacked());
    }/*

    /*@SubscribeEvent
    public static void customReach(MouseEvent event) {
        if (event.getButton() == 0 && event.isButtonstate()) {
            Minecraft minecraft = Minecraft.getMinecraft();
            Item heldItem = minecraft.player.getHeldItemMainhand().getItem();
            if (heldItem == ModItems.ENDER_STAFF) {
                Entity hit = Utils.getMouseOverExtended(12).entityHit;
                if (hit != null && minecraft.objectMouseOver.entityHit == null) {
                    Main.network.sendToServer(new MessageCustomReachAttackEnderStaff(hit.getEntityId()));
                }
            }
        }
    }*/

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();

            if (player.getHeldItemMainhand().getItem() != ModItems.ENDER_STAFF) {

                if (event.getEntity() instanceof EntityGuardian || event.getEntity() instanceof EntityElderGuardian) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityBlaze) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (event.getEntity() instanceof EntityCreeper) {
                    BlockPos pos = event.getEntity().getPosition();
                    EntityItem item1 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                    player.getEntityWorld().spawnEntity(item1);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL_FRAGMENT, 1));
                    player.getEntityWorld().spawnEntity(item2);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingAttacked(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            boolean isCreativeMode = player.capabilities.isCreativeMode;

            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (player.inventory.armorInventory.get(0).getItem() == ModItems.ENDER_BOOTS && player.inventory.armorInventory.get(1).getItem() == ModItems.ENDER_LEGGINGS && player.inventory.armorInventory.get(2).getItem() == ModItems.ENDER_CHESTPLATE && player.inventory.armorInventory.get(3).getItem() == ModItems.ENDER_HELM) {
                    if (EnergyHelper.getEnergy(player.inventory.armorInventory.get(0)) - ModConf.enderArmor.baseEnergyPerHit / 4 * ModConf.enderArmor.attackEnergyDrainMultiplier >= 0 && EnergyHelper.getEnergy(player.inventory.armorInventory.get(1)) - ModConf.enderArmor.baseEnergyPerHit / 4 * ModConf.enderArmor.attackEnergyDrainMultiplier >= 0 && EnergyHelper.getEnergy(player.inventory.armorInventory.get(2)) - ModConf.enderArmor.baseEnergyPerHit / 4 * ModConf.enderArmor.attackEnergyDrainMultiplier >= 0 && EnergyHelper.getEnergy(player.inventory.armorInventory.get(3)) - ModConf.enderArmor.baseEnergyPerHit / 4 * ModConf.enderArmor.attackEnergyDrainMultiplier >= 0) {
                        EnergyHelper.useEnergy((ModConf.enderArmor.baseEnergyPerHit / 4) * ModConf.enderArmor.attackEnergyDrainMultiplier, player.inventory.armorInventory.get(0));
                        EnergyHelper.useEnergy((ModConf.enderArmor.baseEnergyPerHit / 4) * ModConf.enderArmor.attackEnergyDrainMultiplier, player.inventory.armorInventory.get(1));
                        EnergyHelper.useEnergy((ModConf.enderArmor.baseEnergyPerHit / 4) * ModConf.enderArmor.attackEnergyDrainMultiplier, player.inventory.armorInventory.get(2));
                        EnergyHelper.useEnergy((ModConf.enderArmor.baseEnergyPerHit / 4) * ModConf.enderArmor.attackEnergyDrainMultiplier, player.inventory.armorInventory.get(3));

                        event.setCanceled(true);
                        //player.hurtResistantTime = 20;
                    }
                }
            } else {
                if (player.inventory.armorInventory.get(0).getItem() == ModItems.ENDER_BOOTS && player.inventory.armorInventory.get(1).getItem() == ModItems.ENDER_LEGGINGS && player.inventory.armorInventory.get(2).getItem() == ModItems.ENDER_CHESTPLATE && player.inventory.armorInventory.get(3).getItem() == ModItems.ENDER_HELM) {
                    event.setCanceled(true);
                    //player.hurtResistantTime = 20;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerInteractLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.ENDER_STAFF) {
            boolean isCreativeMode = event.getEntityPlayer().capabilities.isCreativeMode;
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                ItemStack stackStaff = event.getEntityPlayer().getHeldItemMainhand();
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.BEDROCK) {
                    if (EnergyHelper.getEnergy(event.getItemStack()) - ModConf.enderStaff.enderStaffEnergyPerUseBlockBoss > 0) {
                        BlockPos pos = event.getPos();

                        EntityPlayer player = event.getEntityPlayer();

                        ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                        if (!event.getWorld().isRemote)
                            player.getEntityWorld().spawnEntity(item);

                        EnergyHelper.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseBlockBoss, stackStaff);
                        event.getWorld().setBlockToAir(pos);
                    }
                } else if (EnergyHelper.getEnergy(event.getItemStack()) - ModConf.enderStaff.enderStaffEnergyPerUseBlock > 0) {
                    BlockPos pos = event.getPos();

                    EntityPlayer player = event.getEntityPlayer();

                    ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                    if (!event.getWorld().isRemote)
                        player.getEntityWorld().spawnEntity(item);

                    EnergyHelper.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseBlock, stackStaff);
                    event.getWorld().setBlockToAir(pos);
                }
            } else if (!isCreativeMode) {
                BlockPos pos = event.getPos();

                EntityPlayer player = event.getEntityPlayer();

                ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                if (!event.getWorld().isRemote)
                    player.getEntityWorld().spawnEntity(item);

                event.getWorld().setBlockToAir(pos);
            } else {
                BlockPos pos = event.getPos();

                EntityPlayer player = event.getEntityPlayer();

                ItemStack stack = event.getWorld().getBlockState(pos).getBlock().getPickBlock(event.getWorld().getBlockState(pos), null, event.getWorld(), pos, event.getEntityPlayer());

                EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), stack);

                if (!event.getWorld().isRemote)
                    player.getEntityWorld().spawnEntity(item);

                event.getWorld().setBlockToAir(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.isPotionActive(ModEffects.POTION_FLIGHT) || event.player.isCreative() || event.player.isSpectator()) {
            event.player.capabilities.allowFlying = true;
        } else {
            event.player.capabilities.allowFlying = false;
            event.player.capabilities.isFlying = false;
        }
    }
}
