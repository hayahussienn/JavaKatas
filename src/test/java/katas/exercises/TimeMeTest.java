package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeMeTest {

    @Test
    void testMeasureExecutionTimeWithQuickFunction() {
        // Test a very quick function
        Runnable quickFunction = () -> {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
        };

        // Measure execution time
        long timeTaken = TimeMe.measureExecutionTime(quickFunction);

        // Assert that the function completes in a reasonable time
        assertTrue(timeTaken < 100,
                "Quick function should execute reasonably fast (was " + timeTaken + " ms)");
    }

    @Test
    void testMeasureExecutionTimeWithEmptyFunction() {
        // Test with an empty function
        Runnable emptyFunction = () -> {};

        // Measure execution time
        long timeTaken = TimeMe.measureExecutionTime(emptyFunction);

        // Assert that the execution time is very short
        assertTrue(timeTaken < 10,
                "Empty function should have minimal execution time (was " + timeTaken + " ms)");
    }

    @Test
    void testMeasureExecutionTimeNotZero() {
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        };

        // Measure execution time
        long timeTaken = TimeMe.measureExecutionTime(sampleFunction);

        // Assert that the time taken is greater than zero
        assertTrue(timeTaken > 0,
                "Execution time should be greater than zero (was " + timeTaken + " ms)");
    }

    @Test
    void testMeasureExecutionTimeWithExceptionThrowing() {
        // Function that throws an exception
        Runnable exceptionFunction = () -> {
            throw new RuntimeException("Test exception");
        };

        // Verify that an exception is thrown during time measurement
        assertThrows(RuntimeException.class, () -> TimeMe.measureExecutionTime(exceptionFunction));
    }
}
