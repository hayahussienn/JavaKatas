package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest
{
    @Test
    public void testisValidParentheses() {
        // Test for empty string
        assertTrue(ValidParentheses.isValidParentheses(""));

        // Test for null string
        assertTrue(ValidParentheses.isValidParentheses(null));

        // Test for valid parentheses combinations
        assertTrue(ValidParentheses.isValidParentheses("()[]{}"));
        assertTrue(ValidParentheses.isValidParentheses("([])"));
        assertTrue(ValidParentheses.isValidParentheses("{}"));

        // Test for invalid parentheses combinations
        assertFalse(ValidParentheses.isValidParentheses("("));
        assertFalse(ValidParentheses.isValidParentheses("{]"));
        assertFalse(ValidParentheses.isValidParentheses("({}[)]"));
    }

}
