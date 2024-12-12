package katas.exercises;

public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
        {
            return 0; // No words in null or empty string
        }
        // Split the sentence by spaces and count number of words
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);
    }
}

