package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStorageCapacityTest
{
    @Test
    public void testMaxStorageArea() {
        // check Empty array
        int[] containers6 = {};
        int result6 = MaxStorageCapacity.maxStorageArea(containers6);
        assertEquals(0, result6);

        // check Null array
        int[] containers7 = null;
        int result7 = MaxStorageCapacity.maxStorageArea(containers7);
        assertEquals(0, result7);

        // Example given in the problem statement
        int[] containers1 = {2, 1, 5, 6, 2, 3};
        int result1 = MaxStorageCapacity.maxStorageArea(containers1);
        assertEquals(10, result1);

        // check Single container
        int[] containers2 = {4};
        int result2 = MaxStorageCapacity.maxStorageArea(containers2);
        assertEquals(4, result2);

        // check Containers in decreasing order
        int[] containers3 = {6, 5, 4, 3, 2, 1};
        int result3 = MaxStorageCapacity.maxStorageArea(containers3);
        assertEquals(12, result3);

        // check Containers in increasing order
        int[] containers4 = {1, 2, 3, 4, 5, 6};
        int result4 = MaxStorageCapacity.maxStorageArea(containers4);
        assertEquals(12, result4);

        // check All containers with the same height
        int[] containers5 = {4, 4, 4, 4, 4};
        int result5 = MaxStorageCapacity.maxStorageArea(containers5);
        assertEquals(20, result5);
    }
}
