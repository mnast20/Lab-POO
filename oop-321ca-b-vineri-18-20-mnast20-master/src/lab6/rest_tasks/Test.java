package lab6.rest_tasks;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        /**
         *  Inside the output folder, the following classes were generated:
         *  Car.class, Car$CarType.class, Dealership.class, Dealership$1.class,
         *  Dealership$BrandOffer.class, Dealership$DealerOffer.class,
         *  Dealership$SpecialOffer.class, Offer.class, Test.class, Test$1.class,
         *  Test$2.class, Test$3.class
         *  I also noticed that the anonymous classes are generated under the
         *  name Test$1, 2, 3.
         */

        Car porsche = new Car(62600, 2020, Car.CarType.CONVERTIBLE);
        Car mercedes = new Car(36858, 2021, Car.CarType.MINIVAN);
        Car jaguar = new Car(53350, 2021, Car.CarType.COUPE);

        Dealership dealership = new Dealership();

        System.out.println("Final price: " + dealership.getFinalPrice(porsche) + " euros");
        System.out.println();
        System.out.println("Final price: " + dealership.getFinalPrice(mercedes) + " euros");
        System.out.println();
        System.out.println("Final price: " + dealership.getFinalPrice(jaguar) + " euros");
        System.out.println();

        Offer offer1 = new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 1000;
            }
        };

        Offer offer2 = new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 500;
            }
        };

        Offer offer3 = new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 800;
            }
        };

        dealership.negotiate(porsche, offer1);
        System.out.println();
        dealership.negotiate(mercedes, offer2);
        System.out.println();
        dealership.negotiate(jaguar, offer3);
        System.out.println();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(porsche);
        cars.add(mercedes);
        cars.add(jaguar);
        System.out.println("Array before removing elements:");
        cars.forEach(System.out::println);
        System.out.println();

        int maxPrice = 40000;

        System.out.println("Array after removing cars with price higher than " + maxPrice + " euros:");
        cars.removeIf((c) -> c.getPrice() - maxPrice > 0);
        cars.forEach(System.out::println);
    }
}