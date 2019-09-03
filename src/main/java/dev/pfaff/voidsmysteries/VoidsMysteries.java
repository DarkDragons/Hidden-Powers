package dev.pfaff.voidsmysteries;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VoidsMysteries.MOD_ID)
public class VoidsMysteries implements IHasLogger {
	public static final String MOD_ID = "voidsmysteries";
	public static final ItemGroup CREATIVE_TAB = new TabStd(MOD_ID);

	public static final IProxy proxy = DistExecutor.runForDist(
		() -> ClientProxy::new,
		() -> ServerProxy::new
	);

	// Directly reference a log4j _logger.
//	private static final _logger _logger = LogManager.getLogger(EternalVoid.class.getName());

	public VoidsMysteries() {
		// Register the setup method for mod loading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the doClientStuff method for mod loading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
	}

	private void setup(FMLCommonSetupEvent event) {
		// some preinit code
		getLogger().debug("--- PreInit ---");
		getLogger().debug("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	private void doClientStuff(FMLClientSetupEvent event) {
		// do something that can only be done on the client
		getLogger().info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}

	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		// See EVBlocks or EVItems for example.
	}
}
