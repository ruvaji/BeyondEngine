package com.beyondDev.beyond_engine.core.init;

import org.zeith.hammeranims.api.geometry.IGeometryContainer;
import org.zeith.hammerlib.annotations.*;

@SimplyRegister
public interface BEGeometries {

    @RegistryName("first_npc")
    IGeometryContainer FIRST_NPC_GEOM = IGeometryContainer.create();
}