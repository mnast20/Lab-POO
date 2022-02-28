package task3;

public class Point {
    private float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" +
                x +
                ", " + y +
                ')';
    }

    public void print_point() {
        System.out.println(this);
    }

}
