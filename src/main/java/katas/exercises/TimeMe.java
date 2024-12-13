package katas.exercises;

public class TimeMe {

    /**
     * Measures the time it takes to execute a given function.
     *
     * @param func the function to measure
     * @return the execution time in milliseconds
     */
    public static long measureExecutionTime(Runnable func) {
        long startTime = System.currentTimeMillis(); // Record start time
        func.run();                                  // Execute the function
        long endTime = System.currentTimeMillis();   // Record end time
        return endTime - startTime;                  // Calculate elapsed time
    }

    public static void main(String[] args) {
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500); // Simulates a delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long timeTaken = measureExecutionTime(sampleFunction);
        System.out.println("Time taken by sampleFunction: " + timeTaken + " ms");

        Runnable quickFunction = () -> System.out.println("Quick task done!");
        timeTaken = measureExecutionTime(quickFunction);
        System.out.println("Time taken by quickFunction: " + timeTaken + " ms");
    }
}
