package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTrader2Test
{
    @Test
    public void testmaxProfit2() {
        // Test edge cases
        assertEquals(0, StockTrader2.maxProfit(null));
        assertEquals(0, StockTrader2.maxProfit(new int[]{}));
        assertEquals(0, StockTrader2.maxProfit(new int[]{1}));

        // Test no profit possible
        assertEquals(0, StockTrader2.maxProfit(new int[]{4, 4}));
        assertEquals(0, StockTrader2.maxProfit(new int[]{7,6,4,3,1}));

        // Test typical profit scenarios
        assertEquals(7, StockTrader2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, StockTrader2.maxProfit(new int[]{1,2,3,4,5}));
    }

}
