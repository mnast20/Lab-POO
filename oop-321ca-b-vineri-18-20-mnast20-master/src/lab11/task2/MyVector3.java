package lab11.task2;

import java.util.Arrays;

public class MyVector3 implements Summable {
    private int[] vector = new int[3];

    public MyVector3(int[] vector) {
        this.vector = vector;
    }

    public MyVector3(int x, int y, int z) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
    }

    public int[] getVector() {
        return vector;
    }

    public void addValue(Summable value) {
        MyVector3 vectorValue = (MyVector3) value;
        int[] vector2 = vectorValue.vector;

        for (int i = 0; i < 3; ++i) {
            vector[i] += vector2[i];
        }
    }

    @Override
    public String toString() {
        return "MyVector3{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }
}
