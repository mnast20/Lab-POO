package lab3.task6;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        CandyBox Lindt = new Lindt("milk chocolate", "Switzerland", 2, 3, 5);
        CandyBox Baravelli = new Baravelli("white chocolate", "United Kingdom", 2, 4);
        CandyBox ChocAmor = new ChocAmor("peanut butter", "United Kigdom", 4);

        CandyBag candyBag = new CandyBag();

        candyBag.AddCandyBag(Lindt);
        candyBag.AddCandyBag(Baravelli);
        candyBag.AddCandyBag(ChocAmor);

        Area Area = new Area(candyBag, 313, "Splaiul Independentei");

        Area.getBirthdayCard();

        System.out.println();

        Area.getBirthdayCardEfficient();
    }
}
