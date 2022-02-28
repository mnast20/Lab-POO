package lab11.task1;

import java.util.*;

public class MultiMapValue<K, V> {
    private final Map<K, List<V>> map = new HashMap<>();

    public void add(K key, V value) {
        if (!containsKey(key)) {
            ArrayList<V> newList = new ArrayList<>();
            newList.add(value);

            map.put(key, newList);

            return;
        }

        List<V> valuesList = getValues(key);
        valuesList.add(value);
        map.put(key, valuesList);
    }

    public void addAll(K key, List<V> values) {
        if (!containsKey(key)) {
            map.put(key, values);

            return;
        }

        List<V> valuesList = getValues(key);
        valuesList.addAll(values);
        map.put(key, valuesList);
    }

    public void addAll(MultiMapValue<K, V> map) {
        for (K key : map.map.keySet()) {
            this.addAll(key, map.getValues(key));
        }
    }

    public V getFirst(K key) {
        if (!containsKey(key)) {
            return null;
        }

        return getValues(key).get(0);
    }

    public List<V> getValues(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public List<V> remove(K key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }
}