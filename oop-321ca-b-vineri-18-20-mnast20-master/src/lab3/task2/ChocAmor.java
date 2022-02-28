package lab3.task2;

import lab3.task1.CandyBox;

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
}
