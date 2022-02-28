package lab3_new.candies;

public class Lindt extends CandyBox {
    private float length, width, height;

    //task 2
    public Lindt() {
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return super.toString() + " with a volume of " + getVolume();
    }

    // task 5
    public void printLindtDim() {
        System.out.println("The Lindt chocolate bar has the length " + length +
                ", the width " + width +
                " and the height " + height);

    }

    // task 6
    public void printChocolate() {
        System.out.println("The Lindt chocolate bar has the length " + length +
                ", the width " + width +
                " and the height " + height +
                " with a volume of " + getVolume());
    }
}
