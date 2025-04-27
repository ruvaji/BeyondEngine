package com.beyondDev.beyond_engine.core.registry;

import com.beyondDev.beyond_engine.BeyondEngineMod;
import com.beyondDev.beyond_engine.common.items.NpcWandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BEItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeyondEngineMod.MOD_ID);

    public static final RegistryObject<Item> NPC_WAND = ITEMS.register("npc_wand",
            () -> new NpcWandItem(new Item.Properties()));

    private static RegistryObject<Item> registerSimpleItem(String id) {
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}