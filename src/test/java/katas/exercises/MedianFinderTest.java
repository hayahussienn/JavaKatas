package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianFinderTest
{

    @Test
    void testMedianOfOneElement() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);

        assertEquals(medianFinder.findMedian(),3);
    }

    @Test
    void testMedianOfOddNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.addNum(4);
        medianFinder.addNum(8);

        assertEquals(medianFinder.findMedian(),6);
    }

    @Test
    void testMedianOfEvenNumberOfElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        medianFinder.addNum(5);
        medianFinder.addNum(8);
        medianFinder.addNum(3);

        assertEquals(medianFinder.findMedian(),6.5);
    }

    @Test
    void testFindMedianForEmptyStream() {
        MedianFinder medianFinder = new MedianFinder();

        assertEquals(medianFinder.findMedian(),0);
    }
}
