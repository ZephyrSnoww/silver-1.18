package ag.ag.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

/**
 * The client-specific main mod class
 */
@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class AgClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ag.ag.Ag.PINK_LOTUS);
    }
}
