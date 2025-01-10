package katas.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedMap<K, V>
{
    private final Map<K, V> map;  // Stores key-value pairs
    private final List<K> orderedKeys;   // Maintains the order of keys based on insertion


    // Constructor initializes the map and ordered keys list
    public OrderedMap()
    {
        map = new HashMap<>();
        orderedKeys = new ArrayList<>();
    }


    // Adds a key-value pair, maintaining insertion order
    public void put(K key, V value)
    {
        if (!map.containsKey(key))
        {
            orderedKeys.add(key); // Add to orderedKeys only if key does not exist
        }
        map.put(key, value);

    }

    // Retrieves the value associated with a given key
    public V get(K key)
    {

        if (map.containsKey(key))
        {
            return map.get(key);
        }
        return null;
    }

    // Removes a key-value pair and updates ordered keys
    public void remove(K key)
    {

        if (map.containsKey(key))
        {
            map.remove(key);
            orderedKeys.remove(key);
        }
    }


    // Returns all keys in the order they were added
    public List<K> keys()
    {

        return orderedKeys;
    }

    // Removes all key-value pairs from the map
    public int size()
    {

        return map.size();
    }

    //Remove all key-value pairs from the map.
    public void clear()
    {
        map.clear();
        orderedKeys.clear();
    }

    public static void main(String[] args) {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        System.out.println("Keys in order: " + orderedMap.keys());
        System.out.println("Value of 'Two': " + orderedMap.get("Two"));

        orderedMap.remove("Two");
        System.out.println("Keys after removal: " + orderedMap.keys());

        orderedMap.put("Two", 22);
        System.out.println("Keys after re-adding 'Two': " + orderedMap.keys());

        System.out.println("Map size: " + orderedMap.size());

        orderedMap.clear();
        System.out.println("Map size after clearing: " + orderedMap.size());
    }
}

