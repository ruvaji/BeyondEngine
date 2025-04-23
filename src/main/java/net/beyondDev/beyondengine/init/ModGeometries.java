package net.beyondDev.beyondengine.init;

import org.zeith.hammeranims.api.animsys.AnimationSystem;
import org.zeith.hammeranims.api.geometry.IGeometryContainer;
import org.zeith.hammeranims.api.geometry.model.IGenericModel;
import org.zeith.hammeranims.api.geometry.model.IGeometricModel;
import org.zeith.hammeranims.api.geometry.model.IPositionalModel;
import org.zeith.hammeranims.core.contents.entity.EntityBilly;
import org.zeith.hammerlib.annotations.*;

@SimplyRegister
public interface ModGeometries {

    @RegistryName("first_npc")
    IGeometryContainer FIRST_NPC_GEOM = IGeometryContainer.create();
}