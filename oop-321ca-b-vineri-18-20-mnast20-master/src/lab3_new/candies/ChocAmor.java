package lab3_new.candies;

public class ChocAmor extends CandyBox {
    private float length;

    // task 1
    public ChocAmor() {
    }

    public ChocAmor(String flavor, String origin , int length) {
        super(flavor, origin);
        this.length = length;
    }

    public float getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return super.toString() + " with a volume of " + getVolume();
    }

    // task 5
    public void printChocAmorDim() {
        System.out.println("The ChocAmor chocolate bar has the length " + length);

    }

    // task 6
    public void printChocolate() {
        System.out.println("The ChocAmor chocolate bar has the length " + length +
                " with a volume of " + getVolume());
    }
}
