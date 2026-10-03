package com.astralmetals.registry;

import com.astralmetals.AstralMetalsMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class AstralMusic {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, AstralMetalsMain.MOD_ID);
    public static final ResourceKey<JukeboxSong> SONG = ResourceKey.create(Registries.JUKEBOX_SONG,
        ResourceLocation.fromNamespaceAndPath(AstralMetalsMain.MOD_ID, "x3n0_my_world"));
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_X3N0_MY_WORLD = SOUNDS.register("music.x3n0_my_world",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AstralMetalsMain.MOD_ID, "music.x3n0_my_world")));
    public static final DeferredItem<Item> DISC_X3N0_MY_WORLD = AstralMetalsContent.ITEMS.registerSimpleItem("music_disc_x3n0_my_world",
        new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SONG));
    public static void initialize() {}
    private AstralMusic() {}
}
