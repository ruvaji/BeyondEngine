package net.beyondDev.beyondengine.entity;

import net.beyondDev.beyondengine.Beyondengine;
import net.beyondDev.beyondengine.entity.custom.FirstNpcEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Beyondengine.MODID);

    public static final RegistryObject<EntityType<FirstNpcEntity>> FIRST_NPC =
            ENTITY_TYPES.register("first_npc", () -> EntityType.Builder.of(FirstNpcEntity :: new, MobCategory.CREATURE)
                    .sized(0.5f, 1.6f)
                    .build(ResourceLocation.tryBuild(Beyondengine.MODID, "first_npc").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
