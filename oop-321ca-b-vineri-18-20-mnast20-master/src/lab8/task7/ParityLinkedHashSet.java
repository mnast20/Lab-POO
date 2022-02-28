package lab8.task7;

import java.util.LinkedHashSet;

public class ParityLinkedHashSet extends LinkedHashSet<Integer> {


    public ParityLinkedHashSet() {
    }

    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
