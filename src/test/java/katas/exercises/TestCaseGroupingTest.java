package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCaseGroupingTest {

    @Test
    @DisplayName("Test with null input")
    public void testWithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            TestCaseGrouping.groupTestCases(null);
        });
    }

    @Test
    @DisplayName("Test with empty input")
    public void testEmptyInput() {
        List<Integer> input = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> result = TestCaseGrouping.groupTestCases(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test with basic input from the example")
    public void testBasicExample() {
        List<Integer> input = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1, 5),
                List.of(2, 3, 4)
        );
        List<List<Integer>> result = TestCaseGrouping.groupTestCases(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test with single element groups")
    public void testSingleElementGroups() {
        List<Integer> input = List.of(1, 1, 1);
        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1),
                List.of(2)
        );
        List<List<Integer>> result = TestCaseGrouping.groupTestCases(input);
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Test with multiple groups of same size")
    public void testMultipleGroupsSameSize() {
        List<Integer> input = List.of(2, 2, 2, 2);
        List<List<Integer>> expected = List.of(
                List.of(0, 1),
                List.of(2, 3)
        );
        List<List<Integer>> result = TestCaseGrouping.groupTestCases(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test invalid input - not enough elements for group size")
    public void testInvalidInputNotEnoughElements() {
        List<Integer> input = List.of(2, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            TestCaseGrouping.groupTestCases(input);
        });
    }

    @Test
    @DisplayName("Test invalid input - group size larger than total elements")
    public void testInvalidInputGroupSizeTooLarge() {
        List<Integer> input = List.of(4, 1, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            TestCaseGrouping.groupTestCases(input);
        });
    }
}
