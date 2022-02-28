package lab3_new.task1;

import lab3_new.candies.CandyBox;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        CandyBox candyBox = new CandyBox();
        System.out.println(candyBox);

        System.out.println();

        CandyBox candyBox1 = new CandyBox("hazelnut", "Germany");
        System.out.println(candyBox1);

    }
}
