package katas.exercises;

public class TrueCounter {

    /**
     * Counts the number of true values in the given boolean array.
     *
     * @param array the boolean array to check
     * @return the count of true values in the array
     */
    public static int countTrueValues(boolean[] array)
    {
        if (array == null)
        {
            return 0; // Handle the case when the array is null
        }
        int count=0;
        for(int i=0;i< array.length;i++)
        {
            if(array[i]) //check if array[i] is true
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        boolean[] sampleArray = {true, false, true, true, false};
        int trueCount = countTrueValues(sampleArray);
        System.out.println(trueCount);
    }
}
