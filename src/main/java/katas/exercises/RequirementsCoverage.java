package katas.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequirementsCoverage {

    /**
     * In software testing, it's often required to select a minimal set of test cases that cover all the requirements.
     * You are given a set of test cases and their associated covered requirements.
     * Your task is to select the minimal subset of test cases such that all requirements are covered.
     *
     * For example, you have the following test cases and requirements they cover:
     *
     * testCases = [
     *   [1, 2, 3],   // Test case 0 covers requirements 1, 2, 3
     *   [1, 4],      // Test case 1 covers requirements 1, 4
     *   [2, 3, 4],   // Test case 2 covers requirements 2, 3, 4
     *   [1, 5],      // Test case 3 covers requirements 1, 5
     *   [3, 5]       // Test case 4 covers requirements 3, 5
     * ]
     *
     * @param testCases a list of test cases, where each test case is a list of requirements it covers
     * @return a list of indices of the minimal subset of test cases that covers all requirements
     */


    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
        // Return an empty list if no test cases are provided
        if (testCases == null || testCases.isEmpty())
        {
            return new ArrayList<>();
        }
        Set<Integer> allRequirements = new HashSet<>();
        for (List<Integer> testCase : testCases) {
            allRequirements.addAll(testCase);
        }

        // Generate all subsets of test cases and find the smallest subset that covers all requirements
        List<Integer> bestSubset = null;

        // Loop through all subsets of test cases using backtracking
        for (int i = 1; i < (1 << testCases.size()); i++) {
            Set<Integer> coveredRequirements = new HashSet<>();
            List<Integer> currentSubset = new ArrayList<>();

            // Build the current subset
            for (int j = 0; j < testCases.size(); j++) {
                if ((i & (1 << j)) != 0) {  // If the j-th test case is in the subset
                    currentSubset.add(j);
                    coveredRequirements.addAll(testCases.get(j));
                }
            }

            // If this subset covers all requirements and is smaller than the previous best, update it
            if (coveredRequirements.containsAll(allRequirements)) {
                if (bestSubset == null || currentSubset.size() < bestSubset.size()) {
                    bestSubset = currentSubset;
                }
            }
        }

        return bestSubset;
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        System.out.println(result); // Expected output: [2, 3]
    }
}
