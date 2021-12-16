package ag.ag.client;

import ag.ag.Ag;
import ag.ag.blocks.screenHandlers.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

/**
 * The client-specific main mod class
 */
@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AgClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ag.ag.Ag.PINK_LOTUS);
        ScreenRegistry.register(Ag.GENERATOR_SCREEN_HANDLER, GeneratorScreen::new);
        ScreenRegistry.register(Ag.ELECTRIC_FURNACE_SCREEN_HANDLER, ElectricFurnaceScreen::new);
        ScreenRegistry.register(Ag.ALLOY_FURNACE_SCREEN_HANDLER, AlloyFurnaceScreen::new);
    }
}
