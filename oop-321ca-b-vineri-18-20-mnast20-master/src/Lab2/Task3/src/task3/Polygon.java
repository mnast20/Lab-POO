package task3;

public class Polygon {
    private int n;
    private Point[] pct;

    public Polygon(int n) {
        this.n = n;
        this.pct = new Point[n];
        for (int i = 0; i < n; i++) {
            pct[i] = new Point(0, 0);
        }
    }
    public Polygon(float [] pairs) {
        this(pairs.length / 2);
        for (int i = 0; i < pairs.length; i += 2) {
            pct[i / 2].changeCoords(pairs[i], pairs[i + 1]);
        }
    }
    public void print_points() {
        for (int i = 0; i < n; ++i) {
            this.pct[i].print_point();
        }
    }
}
