package dynamic_programming;

import java.util.Arrays;

public class BuyAndSellStockWithCooldown {
    int[] prices;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.dp = new int[prices.length][3];
        for(int[] ddp : dp)
            Arrays.fill(ddp, -1);
        return dp(0,0);
    }

    private int dp(int index, int holding) {
        if(index == prices.length)
            return 0;
        if(dp[index][holding] != -1)
            return dp[index][holding];
        int noTransaction = dp(index+1, holding);
        int transaction = 0;
        if(holding == 0)
            transaction = -prices[index] + dp(index+1, 1);
        else if(holding == 1)
            transaction = prices[index] + dp(index+1, 2);
        else
            transaction = dp(index+1, 0);
        return dp[index][holding] = Math.max(transaction, noTransaction);

    }
}
