package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueCounterTest
{
    @Test
    public void testTrueCounter()
    {
        assertEquals(TrueCounter.countTrueValues(new boolean[]{false,false}),0);
        assertEquals(TrueCounter.countTrueValues(new boolean[]{false, true, false}),1);
        assertEquals(TrueCounter.countTrueValues(new boolean[]{false, true, true, false}),2);
        assertEquals(TrueCounter.countTrueValues(null),0);
        assertEquals(TrueCounter.countTrueValues(new boolean[]{ }),0);
    }
}
