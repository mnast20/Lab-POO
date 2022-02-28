package lab3.task5;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        CandyBox Lindt = new Lindt("milk chocolate", "Switzerland", 2, 3, 5);
        CandyBox Baravelli = new Baravelli("white chocolate", "United Kingdom", 2, 4);
        CandyBox ChocAmor = new ChocAmor("peanut butter", "United Kigdom", 4);

        ((Lindt) Lindt).printLindtDim();
        ((Baravelli) Baravelli).printBaravelliDim();
        ((ChocAmor) ChocAmor).printChocAmorDim();

        System.out.println();
    }
}
