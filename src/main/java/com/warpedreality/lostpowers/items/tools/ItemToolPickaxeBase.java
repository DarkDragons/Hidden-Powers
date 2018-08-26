package com.warpedreality.lostpowers.items.tools;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolPickaxeBase extends ItemPickaxe implements IHasModel {

    public ItemToolPickaxeBase(String name, int lvl, int durability, int speed, float damage, int enchantability) {
        super(EnumHelper.addToolMaterial(name + "_material", lvl, durability, speed, damage, enchantability));

        setUnlocalizedName(name);
        setRegistryName(name);

        RegistryHelper.registerTool(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
