package com.example.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ExampleScreen extends Screen {
    public ExampleScreen() {
        super(Text.literal("Example Screen"));
    }

    @Override
    protected void init() {
        // Add a button as an example
        ButtonWidget button = ButtonWidget.builder(
            Text.literal("Close"),
            btn -> close()  // Changed 'button' to 'btn' to avoid naming conflict
        )
        .dimensions(width / 2 - 50, height / 2 - 10, 100, 20)
        .build();

        addDrawableChild(button);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game when this screen is open
    }
}
