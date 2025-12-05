package com.astralmetals.registry;

import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AstralMusic {

    public static final String MOD_ID = "astralmetals";

    // === Sound registration ===
    public static final SoundEvent MUSIC_X3N0_MY_WORLD =
            registerSound("music.x3n0_my_world");

    // === Music disc item ===
    public static final Item DISC_X3N0_MY_WORLD =
            registerDisc("music_disc_x3n0_my_world", MUSIC_X3N0_MY_WORLD, 14);

    private static SoundEvent registerSound(String id) {
        Identifier soundId = new Identifier(MOD_ID, id);
        SoundEvent event = SoundEvent.of(soundId);
        Registry.register(Registries.SOUND_EVENT, soundId, event);
        return event;
    }

    private static Item registerDisc(String id, SoundEvent sound, int comparatorOutput) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id),
                new MusicDiscItem(comparatorOutput, sound,
                        new Item.Settings().maxCount(1)
                                .rarity(net.minecraft.util.Rarity.RARE), 200));
    }

    public static void registerAll() {
        System.out.println("[Astral Metals] Registered music disc: X3N0 – My World");
    }
}
