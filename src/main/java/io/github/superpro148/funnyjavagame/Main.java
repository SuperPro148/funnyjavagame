package io.github.superpro148.funnyjavagame;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    private long window;

    public static Vertex[] vertices = {
            new Vertex(-100, -100, 400),
            new Vertex(100, -100, 400),
            new Vertex(100, 100, 400),
            new Vertex(-100, 100, 400),
            new Vertex(-100, -100, 600),
            new Vertex(100, -100, 600),
            new Vertex(100, 100, 600),
            new Vertex(-100, 100, 600)
    };

    public static Edge[] edges = {
            new Edge(vertices[0], vertices[1]),
            new Edge(vertices[1], vertices[2]),
            new Edge(vertices[2], vertices[3]),
            new Edge(vertices[3], vertices[0]),
            new Edge(vertices[4], vertices[5]),
            new Edge(vertices[5], vertices[6]),
            new Edge(vertices[6], vertices[7]),
            new Edge(vertices[7], vertices[4]),
            new Edge(vertices[0], vertices[4]),
            new Edge(vertices[1], vertices[5]),
            new Edge(vertices[2], vertices[6]),
            new Edge(vertices[3], vertices[7])
    };

    public static int[] WS = {800, 600};

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        init();
        loop();

        glfwFreeCallbacks(window);

    }

    private void init() {

        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        window = glfwCreateWindow(WS[0], WS[1], "test", NULL, NULL);
        if (window == NULL) throw new RuntimeException("failed to create window");

        glfwSetKeyCallback(
                window,
                (window, key, scancode, action, mods) -> InputProcessor.processKeys(window, key, scancode, action, mods));

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(window, pWidth, pHeight);

            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);

        glfwShowWindow(window);

    }

    private void loop() {

        GL.createCapabilities();



        while (!glfwWindowShouldClose(window)) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            for (int i = 0; i < edges.length; i++) {
                Renderer.drawLine(WS, edges[i].getAX(), edges[i].getAY(), edges[i].getBX(), edges[i].getBY(), 255, 255, 255);
            }

            glfwSwapBuffers(window);

            glfwPollEvents();
        }

    }
    
}
