package com.beyondDev.beyond_engine.core.init;

import org.zeith.hammeranims.api.animation.AnimationHolder;
import org.zeith.hammeranims.api.animation.IAnimationContainer;
import org.zeith.hammerlib.annotations.*;

@SimplyRegister
public interface BEAnimations {

    @RegistryName("first_npc_animation")
    IAnimationContainer FIRST_NPC_ANIMATION = IAnimationContainer.create();

    AnimationHolder FIRST_NPC_WALK = new AnimationHolder(FIRST_NPC_ANIMATION, "walk");
    AnimationHolder FIRST_NPC_HELLO = new AnimationHolder(FIRST_NPC_ANIMATION, "hello");
    AnimationHolder FIRST_NPC_IDLE = new AnimationHolder(FIRST_NPC_ANIMATION, "idle");
}
