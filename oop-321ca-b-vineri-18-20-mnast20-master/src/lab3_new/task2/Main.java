package lab3_new.task2;

import lab3_new.candies.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        CandyBox Lindt = new Lindt("milk chocolate", "Switzerland", 2, 3, 5);
        CandyBox Baravelli = new Baravelli("white chocolate", "United Kingdom", 2, 4);
        CandyBox ChocAmor = new ChocAmor("peanut butter", "United Kigdom", 4);

        System.out.println(Lindt);
        System.out.println(Baravelli);
        System.out.println(ChocAmor);
    }
}
