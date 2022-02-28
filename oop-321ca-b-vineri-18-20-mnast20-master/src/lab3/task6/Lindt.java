package lab3.task6;

public class Lindt extends CandyBox {
    private float length, width, height;

    public Lindt() {
        length = 0;
        width = 0;
        height = 0;
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

    public void printLindtDim() {
        System.out.println("The Lindt chocolate bar has the length " + length +
                ", the width " + width +
                " and the height " + height);

    }

    public void printChocolate() {
        System.out.println("The Lindt chocolate bar has the length " + length +
                ", the width " + width +
                " and the height " + height +
                " with a volume of " + getVolume());
    }
}
