package org.simplecity.mod.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import static org.simplecity.mod.util.Constants.getId;

public class ModSounds {
    public static final SoundEvent TRAIN_DEPARTURE_BELL_SOUND = register(ModSoundPaths.TRAIN_DEPARTURE_BELL_SOUND_PATH);

    public static SoundEvent register(String name) {
        ResourceLocation id = getId(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void initialize() {
    }
}
