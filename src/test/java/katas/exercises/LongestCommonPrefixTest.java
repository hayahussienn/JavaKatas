package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest
{
    @Test
    public void testLongestCommonPrefix()
    {
        // Test case where the common prefix is "he"
        assertEquals(LongestCommonPrefix.longestCommonPrefix(new String[]{"hello", "he", "her"}), "he");

        // Test case where the common prefix is a single character "h"
        assertEquals(LongestCommonPrefix.longestCommonPrefix(new String[]{"hello", "hi", "her"}), "h");

        // Test case where no common prefix exists
        assertEquals(LongestCommonPrefix.longestCommonPrefix(new String[]{"hello", "he", "code"}), "");

        // Test case where the common prefix is "her" and it an element in the array
        assertEquals(LongestCommonPrefix.longestCommonPrefix(new String[]{"her", "herCode", "herTest"}), "her");

        // Test case where the input is null, expected result is an empty string
        assertEquals(LongestCommonPrefix.longestCommonPrefix(null), "");

        // Test case where the input is an empty array, expected result is an empty string
        assertEquals(LongestCommonPrefix.longestCommonPrefix(new String[]{}), "");
    }
}
