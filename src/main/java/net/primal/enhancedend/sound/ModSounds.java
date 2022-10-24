package net.primal.enhancedend.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.primal.enhancedend.EnhancedEnd;

public class ModSounds {
    public static SoundEvent MYSTERIOUS_LIGHTS = registerSoundEvent("mysterious_lights");
    public static SoundEvent SANCTITY = registerSoundEvent("sanctity");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EnhancedEnd.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
