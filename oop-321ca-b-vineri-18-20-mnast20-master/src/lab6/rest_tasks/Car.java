package lab6.rest_tasks;

public class Car {
    private final Integer price;
    private final Integer fabricationYear;
    private final CarType type;

    public enum CarType {
        CONVERTIBLE,
        MINIVAN,
        COUPE
    }

    public Car(Integer price, Integer fabricationYear, CarType type) {
        this.price = price;
        this.fabricationYear = fabricationYear;
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", fabricationYear=" + fabricationYear +
                ", type=" + type +
                '}';
    }
}
