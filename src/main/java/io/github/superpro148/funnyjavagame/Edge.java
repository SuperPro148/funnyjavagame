package io.github.superpro148.funnyjavagame;

public class Edge {
    public Vertex A;
    public Vertex B;
    public static final int FOCAL = 400;

    public Edge(Vertex a, Vertex b) {
        A = a;
        B = b;
    }

    public int getAX() {
        return project(FOCAL, this.A.Z, this.A.X);
    }

    public int getAY() {
        return project(FOCAL, this.A.Z, this.A.Y);
    }

    public int getBX() {
        return project(FOCAL, this.B.Z, this.B.X);
    }

    public int getBY() {
        return project(FOCAL, this.B.Z, this.B.Y);
    }

    public static int project(int focal, int depth, int width) {
        int fin = (int) (focal * ((float) width / (focal + depth)));
        return (int) (focal * ((float) width / (focal + depth)));
    }
}
