package dev.pfaff.voidsmysteries.registry;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import dev.pfaff.voidsmysteries.VoidsMysteries;
import dev.pfaff.voidsmysteries.block.BlockCompressedObsidian;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = VoidsMysteries.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(VoidsMysteries.MOD_ID)
public class Blocks {
	private static final Logger LOGGER = LogManager.getLogger(Blocks.class.getName());

	public static final Block compressed_obsidian_block_1 = null;

	public static final Block compressed_obsidian_block_2 = null;

	public static final Block compressed_obsidian_block_3 = null;

	public static final Block compressed_obsidian_block_4 = null;

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		LOGGER.info("Begin - Registering Blocks");

		LOGGER.info("| Registering Compressed Obsidian Blocks");
		event.getRegistry().registerAll(
			new BlockCompressedObsidian(1),
			new BlockCompressedObsidian(2),
			new BlockCompressedObsidian(3),
			new BlockCompressedObsidian(4)
		);

		LOGGER.info("End - Registering Blocks");
	}

}