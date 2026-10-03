package com.astralmetals;

import com.astralmetals.registry.AstralMetalsContent;
import com.astralmetals.registry.AstralMusic;
import com.astralmetals.registry.AstralTools;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(AstralMetalsMain.MOD_ID)
public final class AstralMetalsMain {
    public static final String MOD_ID = "astralmetals";

    public AstralMetalsMain(IEventBus bus) {
        // Class initialization declares entries; suppliers resolve only during registry events.
        AstralTools.initialize();
        AstralMusic.initialize();
        AstralMetalsContent.BLOCKS.register(bus);
        AstralMetalsContent.ITEMS.register(bus);
        AstralMetalsContent.TABS.register(bus);
        AstralMusic.SOUNDS.register(bus);
    }
}
