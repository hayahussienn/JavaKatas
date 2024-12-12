package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest
{
    @Test
    public void testWordCounter()
    {
        assertEquals(WordCounter.countWords("hello my name is haya"),5);
        assertEquals(WordCounter.countWords("hi"),1);
        assertEquals(WordCounter.countWords(" "),0);
        assertEquals(WordCounter.countWords(null),0);
        assertEquals(WordCounter.countWords("    i like coding   "),3);

    }
}
