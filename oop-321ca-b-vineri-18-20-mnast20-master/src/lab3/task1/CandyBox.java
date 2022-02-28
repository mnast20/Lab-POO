package lab3.task1;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        flavor = "";
        origin = "";
    }

     public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
     }

     float getVolume() {
        return 0;
     }

    @Override
    public String toString() {
        return "The candy is made in " + origin +
                " and has the flavor " + flavor;
    }
}
