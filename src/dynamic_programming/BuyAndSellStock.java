package dynamic_programming;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i< prices.length;i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }
}
