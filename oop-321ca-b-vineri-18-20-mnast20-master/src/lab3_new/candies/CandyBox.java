package lab3_new.candies;

public class CandyBox {
    private String flavor;
    private String origin;

    // task 1
    public CandyBox() {
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

    // task 3
    public boolean equals(CandyBox c) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CandyBox)) {
            return false;
        }
        return equals((CandyBox) obj);
    }

    // task 6
    public void printChocolate() {
        System.out.println("Chocolate with the flavor " + flavor +
                ", made in" + origin);
    }
}
