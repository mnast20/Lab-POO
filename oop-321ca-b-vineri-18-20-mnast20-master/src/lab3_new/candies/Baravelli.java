package lab3_new.candies;

public class Baravelli extends CandyBox {
    private float radius, height;

    // task 2
    public Baravelli() {
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

    // task 5
    public void printBaravelliDim() {
        System.out.println("The Baravelli chocolate bar has the radius " + radius +
                " and the height " + height);

    }

    // task 6
    public void printChocolate() {
        System.out.println("The Baravelli chocolate bar has the radius " + radius +
                " and the height " + height +
                " with a volume of " + getVolume());
    }
}
