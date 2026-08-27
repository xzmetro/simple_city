package org.simplecity.mod.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenCursorMixin {
    @Unique
    private long lastCursor = -1;
    @Unique
    private boolean lastHovered = false;

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo ci) {
        Screen screen = (Screen) (Object) this;
        Minecraft client = Minecraft.getInstance();

        if (client.screen == screen) {
            double mouseX = client.mouseHandler.xpos() * (double) client.getWindow().getGuiScaledWidth() / (double) client.getWindow().getScreenWidth();
            double mouseY = client.mouseHandler.ypos() * (double) client.getWindow().getGuiScaledHeight() / (double) client.getWindow().getScreenHeight();

            boolean hoverButton = false;
            for (var child : screen.children()) {
                if (child instanceof Button button && button.isMouseOver(mouseX, mouseY)) {
                    hoverButton = true;
                    break;
                }
            }

            long windowHandle = client.getWindow().getWindow();

            if (hoverButton) {
                if (!lastHovered) {
                    long cursor = GLFW.glfwCreateStandardCursor(GLFW.GLFW_HAND_CURSOR);
                    if (cursor != 0) {
                        GLFW.glfwSetCursor(windowHandle, cursor);
                        if (lastCursor != -1 && lastCursor != cursor) {
                            GLFW.glfwDestroyCursor(lastCursor);
                        }
                        lastCursor = cursor;
                    }
                    lastHovered = true;
                }
            } else {
                if (lastHovered) {
                    long cursor = GLFW.glfwCreateStandardCursor(GLFW.GLFW_ARROW_CURSOR);
                    if (cursor != 0) {
                        GLFW.glfwSetCursor(windowHandle, cursor);
                        if (lastCursor != -1 && lastCursor != cursor) {
                            GLFW.glfwDestroyCursor(lastCursor);
                        }
                        lastCursor = cursor;
                    }
                    lastHovered = false;
                }
            }
        }
    }
}