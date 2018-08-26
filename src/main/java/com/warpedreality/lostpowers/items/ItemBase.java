package com.warpedreality.lostpowers.items;

import com.warpedreality.lostpowers.Main;
import com.warpedreality.lostpowers.utils.IHasModel;
import com.warpedreality.lostpowers.utils.RegistryHelper;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);

        RegistryHelper.registerItem(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
