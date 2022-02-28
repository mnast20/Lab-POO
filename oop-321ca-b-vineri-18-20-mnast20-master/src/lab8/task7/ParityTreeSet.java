package lab8.task7;

import java.util.TreeSet;

public class ParityTreeSet extends TreeSet<Integer> {


    public ParityTreeSet() {
    }

    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
