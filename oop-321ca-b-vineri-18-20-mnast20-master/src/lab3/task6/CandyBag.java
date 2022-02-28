package lab3.task6;

import java.util.ArrayList;

public class CandyBag {
    private ArrayList<CandyBox> boxes;
    public CandyBag() {
        this.boxes = new ArrayList<CandyBox>();
    }

    public CandyBag(ArrayList<CandyBox> boxes) {
        this.boxes = boxes;
    }

    public void AddCandyBag(CandyBox box) {
        boxes.add(box);
    }

    public void setBoxes(ArrayList<CandyBox> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<CandyBox> getBoxes() {
        return boxes;
    }

    public void printArray() {
        for (int i = 0; i < boxes.size(); i++) {
            System.out.println(boxes.get(i));
        }
    }
}
