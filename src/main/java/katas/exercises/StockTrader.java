package katas.exercises;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        if (prices==null || prices.length==0) //check if prices is null or empty
        {
            return 0;
        }
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++)
        {
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);  // Calculate the profit if we sell at the current price
            minPrice=Math.min(minPrice,prices[i]); // Update the minimum price if we find a lower price
        }
        return  maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
