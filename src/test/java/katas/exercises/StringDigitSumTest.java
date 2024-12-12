package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDigitSumTest
{
    @Test
    public void testStringDigitSum()
    {
        assertEquals(StringDigitSum.sumOfDigits("h1h1h2"),4);
        assertEquals(StringDigitSum.sumOfDigits("hello"),0);
        assertEquals(StringDigitSum.sumOfDigits("hey1"),1);
        assertEquals(StringDigitSum.sumOfDigits("hey0"),0);
        assertEquals(StringDigitSum.sumOfDigits(""),0);
        assertEquals(StringDigitSum.sumOfDigits(null),0);

    }
}
