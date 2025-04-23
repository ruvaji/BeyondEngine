package net.beyondDev.beyondengine.entity.render;

import net.beyondDev.beyondengine.entity.ModEntities;
import net.beyondDev.beyondengine.entity.custom.FirstNpcEntity;
import net.beyondDev.beyondengine.init.ModGeometries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.zeith.hammeranims.core.client.render.entity.BedrockEntityRenderer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirstNpcEntityRender extends BedrockEntityRenderer <FirstNpcEntity> {

    protected final ResourceLocation texture = ResourceLocation.tryBuild("beyondengine", "textures/entity/first_npc.png");

    public FirstNpcEntityRender(EntityRendererProvider.Context pContext) {
        super(pContext, ModGeometries.FIRST_NPC_GEOM, 0.6F);
    }

    @Override
    protected RenderType getRenderType(ResourceLocation texture)
    {
        return RenderType.entityCutoutNoCull(texture);
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers e)
    {
        e.registerEntityRenderer(ModEntities.FIRST_NPC.get(), FirstNpcEntityRender::new);
    }

    @Override
    public ResourceLocation getTextureLocation(FirstNpcEntity pEntity) {
        return texture;
    }
}

