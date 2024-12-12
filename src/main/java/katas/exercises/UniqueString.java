package katas.exercises;

import java.util.HashSet;

public class UniqueString {

    /**
     * Checks if a string has all unique characters (case-insensitive).
     *
     * @param str the input string
     * @return true if all characters are unique, false otherwise
     */
    public static boolean isUnique(String str)
    {
        // Check if the string is null or empty
        if (str == null || str.isEmpty())
        {
            return true;
        }
        String lowerCaseString = str.toLowerCase(); //convert the string to lower case
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<lowerCaseString.length();i++)
        {
            if (set.contains(lowerCaseString.charAt(i))) //check if the char in the set
            {
                return false;

            }
            set.add(lowerCaseString.charAt(i)); // if the char not in the set we add it
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "Hello";
        String test2 = "World";
        String test3 = "Java";
        String test4 = "Unique";

        System.out.println("\"" + test1 + "\" has all unique characters: " + isUnique(test1));
        System.out.println("\"" + test2 + "\" has all unique characters: " + isUnique(test2));
        System.out.println("\"" + test3 + "\" has all unique characters: " + isUnique(test3));
        System.out.println("\"" + test4 + "\" has all unique characters: " + isUnique(test4));
    }
}
