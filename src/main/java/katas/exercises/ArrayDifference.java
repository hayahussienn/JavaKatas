package katas.exercises;

public class ArrayDifference {

    /**
     * Finds the difference between the largest and smallest numbers in the array.
     *
     * @param numbers the array of integers
     * @return the difference between the largest and smallest numbers
     */
    public static int findDifference(int[] numbers)
    {
        if (numbers==null || numbers.length==0) // Handles null or empty arrays
        {
            return 0;
        }
        int maxValue = numbers[0]; // Initialize the max element
        int minValue = numbers[0]; // Initialize the min element
        // Iterate through the array to find the max and min values
        for(int i=0;i<numbers.length;i++)
        {
            if (numbers[i]>maxValue)
            {
                maxValue=numbers[i]; // Update maxValue when a larger value is found
            }

            if (numbers[i]<minValue)
            {
                minValue=numbers[i]; // Update minValue when a smaller value is found
            }

        }

        return  maxValue-minValue; // Calculate and return the difference between the largest and smallest values in the array
    }

    public static void main(String[] args) {
        int[] sampleArray = {10, 3, 5, 6, 20, -2};
        int difference = findDifference(sampleArray);
        System.out.println(difference);
    }
}
