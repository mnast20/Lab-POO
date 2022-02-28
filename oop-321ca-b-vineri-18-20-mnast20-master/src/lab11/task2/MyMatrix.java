package lab11.task2;

import java.util.Arrays;

public class MyMatrix implements Summable {
    int[][] matrix = new int[4][4];

    public MyMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void addValue(Summable value) {
        MyMatrix matrixValue = (MyMatrix) value;

        int[][] matrix2 = matrixValue.matrix;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] += matrix2[i][j];
            }
        }
    }

    @Override
    public String toString() {
        return "MyMatrix{" +
                "matrix=" + Arrays.deepToString(matrix) +
                '}';
    }
}
