package lab3.task2;

import lab3.task1.CandyBox;

public class Baravelli extends CandyBox {
    private float radius, height;

    public Baravelli() {
        radius = 0;
        height = 0;
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    public float getVolume() {
        return (float)Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return super.toString() + " with a volume of " + getVolume();
    }
}
