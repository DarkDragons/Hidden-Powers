package com.warpedreality.lostpowers.items.tools;

import com.google.common.collect.Multimap;
import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.ModConf;
import com.warpedreality.lostpowers.init.ModItems;
import com.warpedreality.lostpowers.items.ItemEnergyBase;
import com.warpedreality.lostpowers.items.ItemVoidFragment;
import com.warpedreality.lostpowers.utils.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ItemToolEnderStaff extends ItemEnergyBase {
    public float arrowVelocity;
    public double arrowDamage;
    boolean isCreativeMode = false;

    public ItemToolEnderStaff() {
        super("ender_staff", Main.tabLostPowers, ModConf.general.enderEnergyMax, ModConf.general.enderEnergyIn);

        this.maxStackSize = 1;
        this.setMaxDamage(384);

        arrowVelocity = 12F;
        arrowDamage = ModConf.enderStaff.enderStaffVoidFragmentDamage;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        final Multimap<String, AttributeModifier> modifierMultiMap = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.MAINHAND) {
            replaceModifier(modifierMultiMap, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, 0);
        }

        return modifierMultiMap;
    }

    private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) {
        // Get the modifiers for the specified attribute
        final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

        // Find the modifier with the specified ID, if any
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

        if (modifierOptional.isPresent()) { // If it exists,
            final AttributeModifier modifier = modifierOptional.get();
            modifiers.remove(modifier); // Remove it
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
        }
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (player.getHeldItemMainhand().getItem() == ModItems.ENDER_STAFF) {
            boolean isCreativeMode = player.capabilities.isCreativeMode;
            if (!isCreativeMode && ModConf.general.poweredByFE) {
                if (Utils.getEnergy(stack) - ModConf.enderStaff.enderStaffEnergyPerUseEntity > 0) {
                    if (entity instanceof EntityWither) {
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 1));
                        player.getEntityWorld().spawnEntity(item);
                    } else if (entity instanceof EntityDragon) {
                        if (Utils.getEnergy(stack) - ModConf.enderStaff.enderStaffEnergyPerUseEntityBoss > 0) {
                            BlockPos pos = entity.getPosition();
                            EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 4));
                            player.getEntityWorld().spawnEntity(item);
                            item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 16));
                            player.getEntityWorld().spawnEntity(item);
                            Utils.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseEntityBoss - ModConf.enderStaff.enderStaffEnergyPerUseEntity, stack);
                        }
                    } else if (entity instanceof EntityEnderman) {
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                        item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 1));
                        player.getEntityWorld().spawnEntity(item);
                    } else if (entity instanceof EntityGuardian || entity instanceof EntityElderGuardian) {
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                        EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                        player.getEntityWorld().spawnEntity(item2);
                    } else if (entity instanceof EntityBlaze) {
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                        EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                        player.getEntityWorld().spawnEntity(item2);
                    } else if (entity instanceof EntityCreeper) {
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                        EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                        player.getEntityWorld().spawnEntity(item2);
                    } else if (entity instanceof EntityLiving){
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                    } else if (entity instanceof EntityLivingBase){
                        BlockPos pos = entity.getPosition();
                        EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                        player.getEntityWorld().spawnEntity(item);
                    }
                    Utils.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseEntity, stack);
                    entity.setDead();
                }
            }
            else if (!isCreativeMode) {
                if (entity instanceof EntityWither) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityDragon) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 4));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 16));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityEnderman) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityGuardian || entity instanceof EntityElderGuardian) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityBlaze) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityCreeper) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityLiving){
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityLivingBase){
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                }
                entity.setDead();
            } else {
                if (entity instanceof EntityWither) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityDragon) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.NETHER_STAR, 4));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 16));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityEnderman) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.ENDER_PEARL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityGuardian || entity instanceof EntityElderGuardian) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_WATER, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityBlaze) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_FLAME, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityCreeper) {
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                    EntityItem item2 = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_ENERGY, 1));
                    player.getEntityWorld().spawnEntity(item2);
                } else if (entity instanceof EntityLiving){
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                } else if (entity instanceof EntityLivingBase){
                    BlockPos pos = entity.getPosition();
                    EntityItem item = new EntityItem(player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PRIMORDIAL_SOUL, 1));
                    player.getEntityWorld().spawnEntity(item);
                }
                entity.setDead();
            }
        }

        return false;
    }

    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() instanceof ItemVoidFragment;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stackStaff, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            isCreativeMode = entityplayer.capabilities.isCreativeMode;
            ItemStack ammo = this.findAmmo(entityplayer);

            int i = this.getMaxItemUseDuration(stackStaff) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stackStaff, worldIn, entityplayer, i, !ammo.isEmpty() || isCreativeMode);
            if (i < 0) return;

            if (!ammo.isEmpty() || isCreativeMode)
            {
                ItemStack arrow = new ItemStack(Items.ARROW);
                ItemArrow itemarrow = (ItemArrow)(arrow.getItem() instanceof ItemArrow ? arrow.getItem() : Items.ARROW);
                EntityArrow entityarrow = itemarrow.createArrow(worldIn, arrow, entityplayer);
                entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, arrowVelocity, 1.0F);
                entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                entityarrow.setDamage(arrowDamage);

                if (!isCreativeMode && ModConf.general.poweredByFE) {
                    if (Utils.getEnergy(stackStaff) - ModConf.enderStaff.enderStaffEnergyPerUseEntityRange > 0) {
                        if (!worldIn.isRemote)
                        {
                            worldIn.spawnEntity(entityarrow);
                        }

                        Utils.useEnergy(ModConf.enderStaff.enderStaffEnergyPerUseEntityRange, stackStaff);
                        ammo.shrink(1);

                        if (ammo.isEmpty())
                        {
                            entityplayer.inventory.deleteStack(ammo);
                        }
                    }
                } else if (!isCreativeMode) {
                    if (!worldIn.isRemote)
                    {
                        worldIn.spawnEntity(entityarrow);
                    }

                    ammo.shrink(1);

                    if (ammo.isEmpty())
                    {
                        entityplayer.inventory.deleteStack(ammo);
                    }
                } else {
                    if (!worldIn.isRemote)
                    {
                        worldIn.spawnEntity(entityarrow);
                    }
                }

                entityplayer.addStat(StatList.getObjectUseStats(this));

            }
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 100;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
    }
}


// Code Snipets

/**
 * Called when the equipped item is right clicked.
 */
/*public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
{
    ItemStack itemstack = playerIn.getHeldItem(handIn);
    boolean isEmpty = this.findAmmo(playerIn).isEmpty();

    ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, isEmpty);
    if (ret != null) return ret;

    if (!playerIn.capabilities.isCreativeMode && isEmpty)
    {
        return !isEmpty ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
    }
    else
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}*/

/**
 * Called when the player stops using the Item (stops holding the right mouse button)
 */
/*public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {

}*/

/**
 * Called when the player right clicks the Item
 */
/*public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer player) {
    return itemStack;
}*/































/*




private ItemStack findAmmo(EntityPlayer player) {
    if (isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
        return player.getHeldItem(EnumHand.OFF_HAND);
    } else {
        for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (isArrow(itemstack)) {
                return itemstack;
            }
        }

        return ItemStack.EMPTY;
    }
}

    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase entityLiving, int timeLeft) {
        EntityPlayer player = (EntityPlayer) entityLiving;
        boolean isCreativeMode = player.capabilities.isCreativeMode;
        ItemStack ammo = new ItemStack(Items.ARROW);
        ItemArrow itemarrow = (ItemArrow)(ammo.getItem() instanceof ItemArrow ? ammo.getItem() : Items.ARROW);

        if (!isCreativeMode && ModConf.poweredByFE) {
            if (Utils.getEnergy(itemStack) - ModConf.enderStaffEnergyPerUseEntityRange > 0) {
                if (!world.isRemote)
                {
                    EntityArrow entityarrow = itemarrow.createArrow(world, ammo, player);

                    entityarrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, arrowVelocity, 1.0F);

                    entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

                    world.spawnEntity(entityarrow);
                }

                Utils.useEnergy(ModConf.enderStaffEnergyPerUseEntityRange, itemStack);
            }
        } else if (!isCreativeMode) {
            if (!world.isRemote)
            {
                EntityArrow entityarrow = itemarrow.createArrow(world, ammo, player);

                entityarrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, arrowVelocity, 1.0F);

                entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

                world.spawnEntity(entityarrow);
            }
        } else {
            if (!world.isRemote)
            {

                EntityArrow entityarrow = itemarrow.createArrow(world, ammo, player);
                entityarrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, arrowVelocity, 1.0F);

                entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

                world.spawnEntity(entityarrow);
            }
        }

        player.addStat(StatList.getObjectUseStats(this));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean isEmpty = this.findAmmo(playerIn).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, isEmpty);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && isEmpty)
        {
            return !isEmpty ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
    }

    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() instanceof ItemArrow;
    }


   */