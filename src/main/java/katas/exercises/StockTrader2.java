package katas.exercises;

public class StockTrader2 {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock MULTIPLE times.
     *
     * O(n) is the best complexity
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {

        if (prices==null || prices.length==0) //check if prices is null or empty
        {
            return 0;
        }
        int minPrice=prices[0];   // Track lowest price seen
        int maxProfit=0;          // Current max profit possible
        int totalMaxProfit=0;     // Sum of all profits
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]-minPrice>maxProfit) // Found better profit
            {
                maxProfit=prices[i]-minPrice;
                totalMaxProfit+=maxProfit;   // Add to totalMaxProfit
                minPrice=prices[i];          // Reset minimum
                maxProfit=0;                 // Reset current profit
            }
            minPrice=Math.min(minPrice,prices[i]); // Update the minimum price if we find a lower price
        }
        return  totalMaxProfit;

    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 7
    }
}
