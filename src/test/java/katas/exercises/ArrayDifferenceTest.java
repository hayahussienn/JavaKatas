package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDifferenceTest
{
    @Test
    public void testArrayDifference() {
        // Test with a typical array of positive integers
        assertEquals(ArrayDifference.findDifference(new int[]{100, 105, 200, 250}), 150,
                "Should return the difference between max (250) and min (100)");

        // Test with an array containing both positive and negative integers
        assertEquals(ArrayDifference.findDifference(new int[]{30, -5, -10, 9}), 40,
                "Should return the difference between max (30) and min (-10)");

        // Test with a single-element array
        assertEquals(ArrayDifference.findDifference(new int[]{10}), 0,
                "Should return 0 as there is no difference in a single-element array");

        // Test with an array where all elements are the same
        assertEquals(ArrayDifference.findDifference(new int[]{9, 9, 9, 9}), 0,
                "Should return 0 as all elements are the same");

        // Test with a null array
        assertEquals(ArrayDifference.findDifference(null), 0,
                "Should return 0 for a null array");

        // Test with an empty array
        assertEquals(ArrayDifference.findDifference(new int[]{}), 0,
                "Should return 0 for an empty array");
    }
}
