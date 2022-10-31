package io.github.superpro148.funnyjavagame;

import org.lwjgl.opengl.GL11;

public class Renderer {
    public static void drawLine(int[] windowSize, int x1, int y1, int x2, int y2, int red, int green, int blue) {
        double cx1 = calcX(x1, windowSize[0]);
        double cy1 = calcY(y1, windowSize[1]);
        double cx2 = calcX(x2, windowSize[0]);
        double cy2 = calcY(y2, windowSize[1]);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3d(red / 255, green / 255, blue / 255);
        GL11.glVertex2d(cx1, cy1);
        GL11.glVertex2d(cx2, cy2);
        GL11.glEnd();
    }

    private static double calcX(int x, int size) {
        return (float) x / (float) size * 2;
    }

    private static double calcY(int y, int size) {
        return -((float) y / (float) size * 2);
    }
}