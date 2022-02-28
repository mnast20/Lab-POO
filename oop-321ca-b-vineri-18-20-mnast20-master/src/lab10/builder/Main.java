package lab10.builder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<House> housesClients =  new ArrayList<>();

        House house1 = new House.HouseBuilder("Soseaua Oltenitei", 2, 5,true).securityFacilities(1).build();
        House house2 = new House.HouseBuilder("Strada Codrii Neamtului", 3, 10,true).solarPanels(3).furnishing(15).build();
        House house3 = new House.HouseBuilder("Bd. Camil Ressu", 1, 4,false).build();

        ArrayList<String> utilities = new ArrayList<>();
        utilities.add("Stove");
        utilities.add("Fridge");
        utilities.add("Dish washer");
        utilities.add("Washing machine");
        utilities.add("Speakers");
        utilities.add("Computer");
        utilities.add("TV");
        utilities.add("Microwave");
        utilities.add("Radio");
        utilities.add("Speakers");

        House house4 = new House.HouseBuilder("Popesti Leordeni", 3, 8,true).furnishing(20).pools(1).utilities(utilities).build();


        housesClients.add(house1);
        housesClients.add(house2);
        housesClients.add(house3);
        housesClients.add(house4);

        System.out.println(housesClients);
    }
}
