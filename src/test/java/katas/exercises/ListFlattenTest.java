package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFlattenTest
{
    @Test
    public void testFlattenList() {
        // Test with a nested list
        List<Object> nestedList = List.of(
                10,
                List.of(20, 30),
                List.of(List.of(40,50,60), 70),
                List.of(80, List.of(90, 100))
        );

        // Expected flattened list
        List<Integer> expected = List.of(10, 20, 30, 40, 50, 60, 70,80,90,100);

        // Assert that flattenList returns the expected flattened list
        List<Integer> actual = ListFlatten.flattenList(nestedList);
        assertEquals(expected, actual, "The flattened list should match the expected list.");
    }

    @Test
    public void testEmptyList() {
        // Test with an empty nested list
        List<Object> emptyList = new ArrayList<>();

        // Expected flattened list is also empty
        List<Integer> expected = new ArrayList<>();

        // Assert that flattenList returns an empty list
        List<Integer> actual = ListFlatten.flattenList(emptyList);
        assertEquals(expected, actual, "The flattened list should be empty.");
    }

    @Test
    public void testNullList() {
        // Test with a null list
        List<Object> nullList = null;

        // Expected flattened list is an empty list
        List<Integer> expected = new ArrayList<>();

        // Assert that flattenList returns an empty list for null input
        List<Integer> actual = ListFlatten.flattenList(nullList);
        assertEquals(expected, actual, "The flattened list for a null input should be empty.");
    }
}
