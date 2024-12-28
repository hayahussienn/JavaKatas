package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequirementsCoverageTest {
    @Test
    public void testMinimalTestCaseSet() {
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(List.of(1, 2, 3));  // Test case 0 covers [1, 2, 3]
        testCases.add(List.of(1, 4));     // Test case 1 covers [1, 4]
        testCases.add(List.of(2, 3, 4));  // Test case 2 covers [2, 3, 4]
        testCases.add(List.of(1, 5));     // Test case 3 covers [1, 5]
        testCases.add(List.of(3, 5));     // Test case 4 covers [3, 5]

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(2, 3), result);  // Test case 2 and 3 cover all requirements
    }

    @Test
    public void testAllRequirementsCoveredByOneTestCase() {
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(List.of(1, 2, 3, 4, 5)); // Test case 0 covers all requirements

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0), result);  // Only test case 0 is needed
    }

    @Test
    public void testNoTestCases() {
        List<List<Integer>> testCases = new ArrayList<>();

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(new ArrayList<>(), result);  // No test cases, so the result is an empty list
    }

    @Test
    public void testRequirementsWithMultipleRedundantTestCases() {
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(List.of(1, 2));   // Test case 0 covers [1, 2]
        testCases.add(List.of(1, 3));   // Test case 1 covers [1, 3]
        testCases.add(List.of(2, 3));   // Test case 2 covers [2, 3]
        testCases.add(List.of(1, 2, 3)); // Test case 3 covers [1, 2, 3]

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(3), result);  // Test case 3 cover all requirements
    }

}
