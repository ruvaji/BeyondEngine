package com.beyondDev.beyond_engine.client.render;

import com.beyondDev.beyond_engine.BeyondEngineMod;
import com.beyondDev.beyond_engine.core.registry.BEEntities;
import com.beyondDev.beyond_engine.common.entities.FirstNpcEntity;
import com.beyondDev.beyond_engine.core.init.BEGeometries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.zeith.hammeranims.core.client.render.entity.BedrockEntityRenderer;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirstNpcRenderer extends BedrockEntityRenderer<FirstNpcEntity> {

    protected final ResourceLocation texture = ResourceLocation.tryBuild(BeyondEngineMod.MOD_ID, "textures/entity/first_npc.png");

    public FirstNpcRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, BEGeometries.FIRST_NPC_GEOM, 0.6F);
    }

    @Override
    protected RenderType getRenderType(ResourceLocation texture) {
        return RenderType.entityCutoutNoCull(texture);
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(BEEntities.FIRST_NPC.get(), FirstNpcRenderer::new);
    }

    @Override
    public ResourceLocation getTextureLocation(FirstNpcEntity pEntity) {
        return texture;
    }
}

