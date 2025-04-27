package com.beyondDev.beyond_engine.core.registry;

import com.beyondDev.beyond_engine.BeyondEngineMod;
import com.beyondDev.beyond_engine.common.entities.FirstNpcEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BEEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BeyondEngineMod.MOD_ID);

    public static final RegistryObject<EntityType<FirstNpcEntity>> FIRST_NPC =
            ENTITY_TYPES.register("first_npc", () -> EntityType.Builder.of(FirstNpcEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1.6f)
                    .build(ResourceLocation.tryBuild(BeyondEngineMod.MOD_ID, "first_npc").toString()));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
