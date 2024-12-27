package katas.exercises;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Checks if a given string has valid parentheses (try in O(n)).
     *
     * A string has valid parentheses if:
     * 1. Every opening parenthesis has a matching closing parenthesis.
     * 2. The parentheses are correctly nested.
     *
     * @param s the input string containing parentheses
     * @return true if the string has valid parentheses, false otherwise
     */
    public static boolean isValidParentheses(String s) {
        // Check if the input string is null or empty, in which case it's considered valid
        if (s == null || s.isEmpty()) {
            return true;
        }

        // Initialize an empty stack to store opening brackets
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If the character is an opening bracket, push it onto the stack
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                charStack.push(s.charAt(i));
            } else {
                // If the stack is empty (no matching opening bracket) or the top of the stack
                // doesn't match the current closing bracket, return false
                if (charStack.isEmpty() ||
                        (s.charAt(i) == ')' && charStack.peek() != '(') ||
                        (s.charAt(i) == '}' && charStack.peek() != '{') ||
                        (s.charAt(i) == ']' && charStack.peek() != '[')) {
                    return false;
                }
                // Pop the matching opening bracket from the stack after a valid match
                charStack.pop();
            }
        }

        // If the stack is empty at the end, all brackets were matched correctly
        return charStack.isEmpty();
    }


    public static void main(String[] args) {
        String validInput = "()[]{}";
        String invalidInput1 = "(]";
        String invalidInput2 = "([)]";
        String validInputNested = "{[()]}";

        System.out.println("Is valid: " + isValidParentheses(validInput));
        System.out.println("Is valid: " + isValidParentheses(invalidInput1));
        System.out.println("Is valid: " + isValidParentheses(invalidInput2));
        System.out.println("Is valid: " + isValidParentheses(validInputNested));
    }
}
