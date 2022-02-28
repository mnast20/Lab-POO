package lab3.task6;

public class ChocAmor extends CandyBox {
    private float length;

    public ChocAmor() {
        length = 0;
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

    public void printChocAmorDim() {
        System.out.println("The ChocAmor chocolate bar has the length " + length);

    }

    public void printChocolate() {
        System.out.println("The ChocAmor chocolate bar has the length " + length +
                " with a volume of " + getVolume());
    }
}
