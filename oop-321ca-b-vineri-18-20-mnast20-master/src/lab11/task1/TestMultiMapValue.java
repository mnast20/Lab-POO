package lab11.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMultiMapValue {
    private MultiMapValue<String, String> map;

    @BeforeEach
    public void setup() {
        map = new MultiMapValue<>();
    }

    @AfterEach
    public void clean() {
        map = null;
    }

    @Test
    public void testAddElementWithOneValue() {
        map.add("key", "value");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(1, map.getValues("key").size());
    }

    @Test
    public void testAddElementWithMoreValues() {
        map.add("key", "value1");
        map.add("key", "value2");

        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(2, map.getValues("key").size());
    }

    @Test
    public void testAddTwoElements() {
        map.add("key1", "value1");
        map.add("key2", "value2");

        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(2, map.size());
    }

    @Test
    public void testGetFirst() {
        ArrayList<String> values1 = new ArrayList<>();
        ArrayList<String> values2 = new ArrayList<>();

        values1.add("value1");
        values1.add("value2");
        values1.add("value3");

        values2.add("value4");
        values2.add("value5");
        values2.add("value6");

        values2.add("value7");
        values2.add("value8");

        map.addAll("key1", values1);
        map.addAll("key2", values2);

        map.add("key3", "value9");

        Assertions.assertEquals("value1", map.getFirst("key1"));
        Assertions.assertEquals("value4", map.getFirst("key2"));
        Assertions.assertEquals("value9", map.getFirst("key3"));
        Assertions.assertNull(map.getFirst("key4"));

    }

    @Test
    public void testContainsKey() {
        map.add("key1", "value1");
        map.add("key2", "value2");

        Assertions.assertTrue(map.containsKey("key1"));
        Assertions.assertTrue(map.containsKey("key2"));
        Assertions.assertFalse(map.containsKey("key3"));
    }

    @Test
    public void testSize() {
        ArrayList<String> values = new ArrayList<>();

        values.add("value4");
        values.add("value5");
        values.add("value6");

        map.add("key1", "value1");
        map.add("key2", "value2");
        map.addAll("key3", values);

        Assertions.assertEquals(3, map.size());
    }

    @Test
    public void testRemoveKey() {
        ArrayList<String> values = new ArrayList<>();

        values.add("value4");
        values.add("value5");
        values.add("value6");

        map.add("key1", "value1");
        map.add("key2", "value2");
        map.addAll("key3", values);

        Assertions.assertEquals(values, map.remove("key3"));

        ArrayList<String> valuesKey1 = new ArrayList<>();
        valuesKey1.add("value1");

        Assertions.assertEquals(valuesKey1, map.remove("key1"));
    }

    @Test
    public void testAddAllWithList() {
        ArrayList<String> values1 = new ArrayList<>();
        ArrayList<String> values2 = new ArrayList<>();

        values1.add("value1");
        values1.add("value2");
        values1.add("value3");

        values2.add("value4");
        values2.add("value5");
        values2.add("value6");
        values2.add("value7");
        values2.add("value8");

        map.addAll("key1", values1);
        map.addAll("key2", values2);

        Assertions.assertEquals(3, map.getValues("key1").size());
        Assertions.assertEquals(5, map.getValues("key2").size());

        Assertions.assertEquals(values1, map.getValues("key1"));
        Assertions.assertEquals(values2, map.getValues("key2"));

    }

    @Test
    public void testAddAllWithMultiMapValue() {
        MultiMapValue<String, String> map2 = new MultiMapValue<>();

        ArrayList<String> values1 = new ArrayList<>();
        ArrayList<String> values2 = new ArrayList<>();

        values1.add("value4");
        values1.add("value5");
        values1.add("value6");
        values1.add("value7");
        values1.add("value8");

        values2.add("value9");
        values2.add("value10");

        map2.add("key1", "value1");
        map2.add("key2", "value2");
        map2.add("key3", "value3");

        map2.addAll("key1", values1);
        map2.addAll("key2", values2);

        map.addAll(map2);

        Assertions.assertEquals(3, map.size());

        Assertions.assertEquals("value1", map.getFirst("key1"));
        Assertions.assertEquals("value2", map.getFirst("key2"));
        Assertions.assertEquals("value3", map.getFirst("key3"));

        Assertions.assertEquals(6, map.getValues("key1").size());
        Assertions.assertEquals(3, map.getValues("key2").size());

        values1.add(0, "value1");

        Assertions.assertEquals(values1, map.getValues("key1"));
    }
}