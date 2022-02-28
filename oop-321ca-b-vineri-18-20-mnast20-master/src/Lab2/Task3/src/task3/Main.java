package task3;

public class Main {
    public static void main(String[] args) {
        float[] polygonPoints = {0, 1, 6, 7, 3, 2, 5, 10};
        Polygon p = new Polygon(polygonPoints);

        System.out.println("Poligon:");
        p.print_points();
    }
}
