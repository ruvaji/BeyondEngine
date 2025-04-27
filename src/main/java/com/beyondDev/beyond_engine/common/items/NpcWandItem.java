package com.beyondDev.beyond_engine.common.items;

import com.beyondDev.beyond_engine.core.registry.BEEntities;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class NpcWandItem extends Item {
    public NpcWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            if (!Screen.hasShiftDown()) {
                Level level = pContext.getLevel();
                Player player = pContext.getPlayer();
                BlockPos blockPos = pContext.getClickedPos().above();

                BEEntities.FIRST_NPC.get().spawn(level.getServer().overworld(), blockPos, MobSpawnType.MOB_SUMMONED);
                player.sendSystemMessage(Component.literal("§2Успешно заспавнен нпс:§2 " + BEEntities.FIRST_NPC.getId()));
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pHand) {
        if (!pPlayer.level().isClientSide) {
            if (Screen.hasShiftDown()) {
                pInteractionTarget.kill();
                pPlayer.sendSystemMessage(Component.literal("§4Успешно удалён нпс:§4 " + pInteractionTarget.getEncodeId()));
            }
        }
        return InteractionResult.SUCCESS;
    }
}