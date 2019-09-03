package dev.pfaff.voidsmysteries.registry;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pfaff.voidsmysteries.VoidsMysteries;
import dev.pfaff.voidsmysteries.item.ItemBlockStd;
import dev.pfaff.voidsmysteries.item.ItemEnderStaff;

@Mod.EventBusSubscriber(modid = VoidsMysteries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(VoidsMysteries.MOD_ID)
public class Items {
	private static final Logger LOGGER = LogManager.getLogger(Items.class.getName());

	public static final Item comp_obsidian_block_1 = null;
	public static final Item comp_obsidian_block_2 = null;
	public static final Item comp_obsidian_block_3 = null;
	public static final Item comp_obsidian_block_4 = null;

	public static final Item ender_staff = null;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		LOGGER.info("Begin - Registering Items");

		LOGGER.info("| Registering Compressed Obsidian BlockItems");
		event.getRegistry().registerAll(
			new ItemBlockStd(Blocks.compressed_obsidian_block_1),
			new ItemBlockStd(Blocks.compressed_obsidian_block_2),
			new ItemBlockStd(Blocks.compressed_obsidian_block_3),
			new ItemBlockStd(Blocks.compressed_obsidian_block_4),

			new ItemEnderStaff()
		);

		LOGGER.info("End - Registering Items");
	}

}