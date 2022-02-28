package lab8.task7;

import java.util.HashSet;

public class ParityHashSet extends HashSet<Integer> {


    public ParityHashSet() {
    }

    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
