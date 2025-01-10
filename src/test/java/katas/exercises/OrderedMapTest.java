package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedMapTest
{

    // Test to verify that keys are ordered in the map
    @Test
    public void testOrderOfKeys()
    {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("A", 1);
        orderedMap.put("B", 2);
        orderedMap.put("C", 3);

        assertEquals(orderedMap.keys(), List.of("A","B","C"));
    }


    // Test to verify adding multiple key-value pairs to the map
    @Test
    public void testAddPairs()
    {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("A", 1);
        orderedMap.put("B", 2);
        orderedMap.put("D",3);

        assertEquals(orderedMap.size(),3);
        assertEquals(orderedMap.get("D"),3);


    }


    // Test to verify updating the value of an existing key
    @Test
    public void testAddPairWithExistKey()
    {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("A", 1);
        orderedMap.put("B", 2);
        assertEquals(orderedMap.size(),2);
        assertEquals(orderedMap.get("B"),2);

        orderedMap.put("B",4);
        assertEquals(orderedMap.size(),2);
        assertEquals(orderedMap.get("B"),4);


    }

    // Test to verify the removal of a key-value pair
    @Test
    public void testRemovepair()
    {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("A", 1);
        orderedMap.put("B", 2);
        orderedMap.remove("A");

        assertEquals(orderedMap.keys(), List.of("B"));
        assertEquals(orderedMap.get("A"),null);
        assertEquals(orderedMap.size(),1);



    }

    // Test to verify that the map is cleared properly
    @Test
    public void testClearMap()
    {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("A", 1);
        orderedMap.put("B", 2);
        orderedMap.clear();
        assertEquals(orderedMap.size(),0);
        assertEquals(orderedMap.get("A"),null);
        assertEquals(orderedMap.get("B"),null);

    }


}
