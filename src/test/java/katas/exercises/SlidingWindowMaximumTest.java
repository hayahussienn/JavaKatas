package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingWindowMaximumTest {

    // Standard case with valid input
    @Test
    public void testStandardCase() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> expected = Arrays.asList(3, 3, 5, 5, 6, 7);
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    // Window size equals array length
    @Test
    public void testWindowSizeEqualsArrayLength() {
        int[] nums = {4, 2, 12, 8, 3};
        int k = 5;
        List<Integer> expected = Arrays.asList(12);
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    // Single element array
    @Test
    public void testSingleElementArray() {
        int[] nums = {5};
        int k = 1;
        List<Integer> expected = Arrays.asList(5);
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }
    //  Window size is 1
    @Test
    public void testWindowSizeIsOne() {
        int[] nums = {7, 1, 5, 3, 6};
        int k = 1;
        List<Integer> expected = Arrays.asList(7, 1, 5, 3, 6);
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    // Empty array
    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int k = 3;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    // Zero window size
    @Test
    public void testZeroWindowSize() {
        int[] nums = {1, 2, 3, 4};
        int k = 0;
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, SlidingWindowMaximum.maxSlidingWindow(nums, k));
    }
}
