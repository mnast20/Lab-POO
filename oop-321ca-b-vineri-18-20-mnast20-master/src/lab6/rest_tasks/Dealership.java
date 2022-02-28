package lab6.rest_tasks;

import java.util.Random;

public class Dealership {
    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            Car.CarType type = car.getType();
            int discount = switch (type) {
                case CONVERTIBLE -> 5; // 5% discount for convertible
                case COUPE -> 10; // 10% discount for coupe
                case MINIVAN -> 15; // 15% discount for minivan
            };
            return discount * car.getPrice() / 100;
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return 100 * (2021 -car.getFabricationYear());
        }
    }

    private class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            Random r = new Random();
            int low = 0;
            int high = 301;
            return r.nextInt(high-low) + low;
        }
    }

    public int getFinalPrice(Car car) {
        System.out.println("Initial price: " + car.getPrice() + " euros");

        BrandOffer brandOffer = new BrandOffer();
        DealerOffer dealerOffer = new DealerOffer();
        SpecialOffer specialOffer = new SpecialOffer();

        int brandDiscount = brandOffer.getDiscount(car);
        System.out.println("Applying Brand discount: " + brandDiscount + " euros");

        int dealerDiscount = dealerOffer.getDiscount(car);
        System.out.println("Applying Dealer discount: " + dealerDiscount + " euros");

        int specialDiscount = specialOffer.getDiscount(car);
        System.out.println("Applying Special discount: " + specialDiscount + " euros");

        int discount = brandDiscount + dealerDiscount + specialDiscount;

        return car.getPrice() - discount;
    }

    void negotiate(Car car, Offer offer) {
        Random r = new Random();
        int low = 0;
        int high = 2;
        int random = r.nextInt(high-low) + low;
        int finalPrice = getFinalPrice(car);
        System.out.println("Final price: " + finalPrice + " euros");
        if (random == 1) {
            System.out.println("Applying Client discount: " + offer.getDiscount(car) + " euros");
            finalPrice -= offer.getDiscount(car);
            System.out.println("Final price after negotiation: " + finalPrice + " euros");
        } else {
            System.out.println("The discount requested by the client was dismissed");
        }
    }
}
