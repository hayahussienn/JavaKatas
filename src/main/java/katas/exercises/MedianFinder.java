package katas.exercises;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * find the median of a stream of integers.
 *
 * The numbers will be provided one at a time in a dynamic data stream, and after each new number is added,
 * your function should efficiently compute the median of all numbers seen so far.
 *
 * Adding a number: O(log n).
 * Finding the median: O(1) or O(log n).
 *
 * Hint: Consider using two heaps (min-heap and max-heap) to efficiently maintain the order of elements.
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;

    /**
     * Initializes the MedianFinder object.
     */
    public MedianFinder() {
        // Max heap stores the smaller half, min heap stores the larger half
       minHeap = new PriorityQueue<>();
       maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    /**
     * Adds a number to the data stream.
     *
     * @param num the number to be added
     */
    public void addNum(int num) {
        // Insert into the correct heap
        if (maxHeap.isEmpty() || num<=maxHeap.peek())
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }

        // Balance the heaps to ensure maxHeap is at most 1 larger than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    /**
     * Finds and returns the median of the data stream.
     *
     * @return the median as a double
     */
    public double findMedian() {
        if(minHeap.isEmpty() && maxHeap.isEmpty()) //check if the heaps are empty
        {
            return 0;
        }
        if (maxHeap.size()>minHeap.size())
        {
            return maxHeap.peek();  // Odd number of elements
        }
        else
        {
            int firstMiddleVal=minHeap.peek();
            int secondMiddleVal=maxHeap.peek();
            return (firstMiddleVal + secondMiddleVal) / 2.0; // Even number of elements
        }

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}
