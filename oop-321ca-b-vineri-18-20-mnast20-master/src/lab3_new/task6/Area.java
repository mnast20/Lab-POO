package lab3_new.task6;

import lab3_new.candies.*;
import lab3_new.task4.CandyBag;

import java.util.ArrayList;

public class Area {
    private CandyBag candyBag;
    private int number;
    private String street;

    public Area() {
        candyBag = new CandyBag();
        number = 0;
        street = "";
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println("Adress: Street " + street + ", Number " + number);
        System.out.println("Happy birthday!");
        System.out.println("List of chocolates:");
        ArrayList<CandyBox> boxes = candyBag.getBoxes();
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i) instanceof Lindt) {
                ((Lindt) boxes.get(i)).printLindtDim();
            } else if (boxes.get(i) instanceof Baravelli) {
                ((Baravelli) boxes.get(i)).printBaravelliDim();
            } else if (boxes.get(i) instanceof ChocAmor) {
                ((ChocAmor) boxes.get(i)).printChocAmorDim();
            }
        }
    }

    public void getBirthdayCardEfficient() {
        System.out.println("Adress: Street " + street + ", Number " + number);
        System.out.println("Happy birthday!");
        System.out.println("List of chocolates:");
        ArrayList<CandyBox> boxes = candyBag.getBoxes();
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).printChocolate();
        }
    }
}
