package lab3.task4;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        CandyBag candyBag= new CandyBag();
        CandyBox Lindt = new Lindt("milk chocolate", "Switzerland", 2, 3, 5);
        CandyBox Baravelli = new Baravelli("white chocolate", "United Kingdom", 2, 4);
        CandyBox ChocAmor = new ChocAmor("peanut butter", "United Kigdom", 4);

        candyBag.AddCandyBag(Lindt);
        candyBag.AddCandyBag(Baravelli);
        candyBag.AddCandyBag(ChocAmor);

        System.out.println(candyBag.getBoxes());
        System.out.println();

        candyBag.printArray();
    }
}
