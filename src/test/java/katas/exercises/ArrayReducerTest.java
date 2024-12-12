package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayReducerTest
{
    @Test
    public void testStandardPositiveCase() {
        int[] original = new int[]{100, 120, 130};
        ArrayReducer.reduceArray(original);
        int[] expected = new int[]{100, 20, 10};
        assertArrayEquals(expected, original);
    }
    @Test
    public void testSingleElementArray() {
        int[] original = new int[]{10};
        ArrayReducer.reduceArray(original);
        int[] expected = new int[]{10};
        assertArrayEquals(expected, original);
    }
    @Test
    public void testWithZeroValues() {
        int[] original = new int[]{0, 0, 0};
        ArrayReducer.reduceArray(original);
        int[] expected = new int[]{0, 0, 0};
        assertArrayEquals(expected, original);
    }

    @Test
    public void testWithNegativeNumbers() {
        int[] original = new int[]{10, -10, 20, -30};
        ArrayReducer.reduceArray(original);
        int[] expected = new int[]{10, -20, 30, -50};
        assertArrayEquals(expected, original);
    }
    @Test
    public void testEmptyArray() {
        int[] original = new int[]{};
        ArrayReducer.reduceArray(original);
        int[] expected = new int[]{};
        assertArrayEquals(expected, original);
    }

}
