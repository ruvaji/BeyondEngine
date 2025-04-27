package com.beyondDev.beyond_engine.core.registry;

import com.beyondDev.beyond_engine.BeyondEngineMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BECreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeyondEngineMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BEYOND_ENGINE_TAB = CREATIVE_MODE_TABS.register("beyond_engine_tab", () -> CreativeModeTab
            .builder()
            .icon(() -> BEItems.NPC_WAND.get().getDefaultInstance())
            .title(Component.literal("BeyondEngine"))
            .displayItems((itemDisplayParameters, output) -> {
                BEItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}