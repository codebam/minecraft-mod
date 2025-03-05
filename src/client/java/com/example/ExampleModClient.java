package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import com.example.screen.ExampleScreen;

public class ExampleModClient implements ClientModInitializer {
    private static KeyBinding keyBinding;

    @Override
    public void onInitializeClient() {
        // Register the keybinding
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.modid.open_screen", // Translation key
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_X, // X key
            "category.modid.general" // Translation key for the category
        ));

        // Register the tick event to check for key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                client.setScreen(new ExampleScreen());
            }
        });
    }
}
