package lab3.task3;

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

    // public void equals()

    public void printChocolate() {
        System.out.println("Chocolate with the flavor " + flavor +
                ", made in" + origin);
    }

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
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
}
