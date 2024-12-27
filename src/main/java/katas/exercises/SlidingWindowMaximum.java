package katas.exercises;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    /**
     *
     * Given an array of integers and a sliding window size, your task is to find the maximum value
     * in the window at each position as the window slides from left to right.
     *
     * For example, given the array [1, 3, -1, -3, 5, 3, 6, 7] and window size 3:
     * The output should be [3, 3, 5, 5, 6, 7].
     *
     * @param nums the array of integers
     * @param k the size of the sliding window
     * @return a list of the maximum values in each window
     */
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
       int maxValue=0;
       List<Integer> result=new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0)  // Handle edge cases: empty array, null input, or zero window size
        {
            return result;
        }
       for (int i=0 ;i<=nums.length-k;i++)
       {
           maxValue=maxValueInWindow(nums,i,k);
           result.add(maxValue); // Add maximum value of the current window to result
       }
        return  result;
    }

    /**
     * Helper method to find the maximum value in a given window.
     *
     * @param nums the array of integers
     * @param i the start index of the window
     * @param k the size of the sliding window
     * @return the maximum value in the window
     */
    static int maxValueInWindow(int[] nums, int i, int k)
    {
       int maxInwindow=nums[i];
       for(int j=i;j<i+k;j++)
       {
          if (nums[j]>maxInwindow)
          {
              maxInwindow=nums[j];
          }
       }
       return maxInwindow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + result);
    }
}

