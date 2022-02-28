package lab8.task8;

import java.util.*;

public class Solution{
    static int solver(){
        Map<Integer, Integer> mapAppearances = new HashMap<>();
        List<Integer> numberList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());

        for (int i = 1; i <= n; i++) {
            int nr = Integer.parseInt(scanner.next());
            Integer nrAppearances = mapAppearances.get(nr);
            if (nrAppearances == null) {
                nrAppearances = 0;
                numberList.add(nr);
            }
            mapAppearances.put(nr, nrAppearances + 1);
        }

        int i = 0;

        for (Integer number: numberList) {
            System.out.print(number + ": " + mapAppearances.get(number));
            if (i != numberList.size()) {
                System.out.print(" ");
            }
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int s = solver();
    }
}