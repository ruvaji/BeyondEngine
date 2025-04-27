package com.beyondDev.beyond_engine.common.entities;

import com.beyondDev.beyond_engine.core.registry.BEEntities;
import com.beyondDev.beyond_engine.core.registry.BEItems;
import com.beyondDev.beyond_engine.core.init.BEAnimations;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.hammeranims.api.animsys.layer.AnimationLayer;
import org.zeith.hammeranims.api.tile.IAnimatedEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FirstNpcEntity extends PathfinderMob implements IAnimatedEntity {
    protected final AnimationSystem animations = AnimationSystem.create(this);

    public FirstNpcEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, (double) 1.25F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, Ingredient.of(new ItemLike[]{BEItems.NPC_WAND.get()}), false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, (double) 1.0F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public void tick() {
        this.animations.tick();
        super.tick();
        if (!this.level().isClientSide) {
            this.setCustomNameVisible(false);
            this.setCustomName(Component.literal("§4ПЕРВЫЙ НПС!"));
            this.animations.startAnimationAt("ambient", BEAnimations.FIRST_NPC_IDLE);
            Vec3 pos = this.position();
            double moved = Math.sqrt(pos.distanceToSqr(this.xo, this.yo, this.zo));
            boolean posChanged = Math.abs(pos.x - this.xo) >= (double) 0.00390625F || Math.abs(pos.z - this.zo) >= (double) 0.00390625F;
            if (!posChanged) {
                moved = (double) 0.0F;
            }

            if (moved > (double) 0.0F) {
                this.animations.startAnimationAt("legs", BEAnimations.FIRST_NPC_WALK);
            } else {
                this.animations.stopAnimation("legs", 0.4F);
            }
        }
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.is(Items.STICK)) {
            this.animations.startAnimationAt("hands", BEAnimations.FIRST_NPC_HELLO);
        } else {
            this.animations.stopAnimation("hands", 3F);
        }

        if (Screen.hasAltDown()) {
            moveEntity(pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), 1f);
        }
        return super.mobInteract(pPlayer, pHand);
    }


    public void setupSystem(AnimationSystem.Builder builder) {
        builder.autoSync().addLayers(new AnimationLayer.Builder[]{new AnimationLayer.Builder("ambient"), new AnimationLayer.Builder("legs"), new AnimationLayer.Builder("hands")});
    }

    public AnimationSystem getAnimationSystem() {
        return this.animations;
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.put("Animations", this.animations.serializeNBT());
        super.addAdditionalSaveData(pCompound);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        this.animations.deserializeNBT(pCompound.getCompound("Animations"));
        super.readAdditionalSaveData(pCompound);
    }


    @SubscribeEvent
    public static void attributes(EntityAttributeCreationEvent e) {
        e.put(BEEntities.FIRST_NPC.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, (float) 20D).add(Attributes.MOVEMENT_SPEED, (double) 0.3f).build());
    }

    public void moveEntity(double x, double y, double z, float speed) {
        this.getNavigation().moveTo(x, y, z, speed);
    }
}