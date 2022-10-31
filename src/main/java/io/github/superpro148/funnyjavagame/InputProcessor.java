package io.github.superpro148.funnyjavagame;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_B;

public class InputProcessor {
    public static void processKeys(long window, int key, int scancode, int action, int mods) {
        if (key == GLFW_KEY_W && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].Z += 100;
            }
        }
        if (key == GLFW_KEY_S && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].Z -= 100;
            }
        }
        if (key == GLFW_KEY_Q && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].Y += 100;
            }
        }
        if (key == GLFW_KEY_E && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].Y -= 100;
            }
        }
        if (key == GLFW_KEY_A && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].X -= 100;
            }
        }
        if (key == GLFW_KEY_D && action == GLFW_PRESS) {
            for (int i = 0; i < Main.vertices.length; i++) {
                Main.vertices[i].X += 100;
            }
        }
    }
}
