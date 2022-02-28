package lab3_new.task3;

import lab3_new.candies.*;
import lab3_new.candies.Lindt;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        CandyBox Lindt1 = new Lindt("caramel", "Switzerland", 4, 6, 2);
        CandyBox Lindt2 = new Lindt("tiramisu", "Switzerland", 7, 2, 3);
        CandyBox Lindt3 = new Lindt("tiramisu", "Switzerland", 7, 2, 3);
        Lindt Lindt4 = new Lindt("tiramisu", "Switzerland", 7, 2, 3);

        System.out.println(Lindt1.equals(Lindt2));
        System.out.println(Lindt2.equals(Lindt3));
        System.out.println(Lindt3.equals(Lindt4));
    }
}
