package lab11.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    private static <T extends Summable> T addAll(Collection<T> summableCollection) {
        Iterator<T> iterator = summableCollection.iterator();
        T summableResult = iterator.next();
        while (iterator.hasNext()) {
            T summable = iterator.next();
            summableResult.addValue(summable);
        }

        return summableResult;
    }

    public static void main(final String[] args) {
        Summable summable1 = new MyVector3(0, 1, 2);
        Summable summable2 = new MyVector3(1, 2, 3);
        Summable summable3 = new MyVector3(2, 3, 4);

        ArrayList<Summable> vectorSummableArray = new ArrayList<>();
        vectorSummableArray.add(summable1);
        vectorSummableArray.add(summable2);
        vectorSummableArray.add(summable3);

        Summable vectorSummableResult = addAll(vectorSummableArray);

        System.out.println(vectorSummableResult);

        int[][] matrix1 = {
                {0, 1, 2, 3},
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6}
        };

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };

        int[][] matrix3 = {
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7},
                {5, 6, 7, 8}
        };

        Summable myMatrix1 = new MyMatrix(matrix1);
        Summable myMatrix2 = new MyMatrix(matrix2);
        Summable myMatrix3 = new MyMatrix(matrix3);

        ArrayList<Summable> matrixSummableArray = new ArrayList<>();
        matrixSummableArray.add(myMatrix1);
        matrixSummableArray.add(myMatrix2);
        matrixSummableArray.add(myMatrix3);

        Summable matrixSummableResult = addAll(matrixSummableArray);

        System.out.println(matrixSummableResult);
    }
}