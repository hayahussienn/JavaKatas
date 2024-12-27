package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTraderTest
{
    @Test
    public void testmaxProfit() {
        // Test with null input
        assertEquals(0, StockTrader.maxProfit(null));

        // Test with empty array
        assertEquals(0, StockTrader.maxProfit(new int[]{}));

        // Test with array of one element
        assertEquals(0, StockTrader.maxProfit(new int[]{1}));

        // Test with array of equal prices
        assertEquals(0, StockTrader.maxProfit(new int[]{4, 4}));

        // Test with a valid profit scenario
        assertEquals(8, StockTrader.maxProfit(new int[]{5, 3, 10, 11}));

        // Test with a valid profit scenario
        assertEquals(9, StockTrader.maxProfit(new int[]{1, 3, 7, 5, 4, 3, 10}));
    }

}
