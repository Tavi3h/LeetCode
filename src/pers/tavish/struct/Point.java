package pers.tavish.struct;

public class Point {
    public int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
