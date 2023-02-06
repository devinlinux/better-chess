package game;

//  imports
import java.util.Objects;

public class Point {
    
    private static Point[][] points = new Point[10][10];
    private int x, y;

    //  do not let anyone instantiate this class
    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point instance(int x, int y) {
        if (points[y + 1][x + 1] == null) points[y + 1][x + 1] = new Point(x, y);
        return points[y + 1][x + 1];
    }

    /* getters for x and y */
    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
