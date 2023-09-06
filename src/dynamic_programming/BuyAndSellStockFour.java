package dynamic_programming;

import java.util.Arrays;

public class BuyAndSellStockFour {
    int[] prices;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        this.dp = new int[prices.length][k+1][2];
        for(int[][] ddp : dp) {
            for(int[] dddp : ddp) {
                Arrays.fill(dddp,-1);
            }
        }
        return dp(0,0,k);
    }

    private int dp(int index, int holding, int k) {
        if(index == prices.length || k==0)
            return 0;
        if(dp[index][k][holding] != -1)
            return dp[index][k][holding];
        int noTransaction = dp(index+1,holding,k);
        int transaction = 0;
        if(holding == 0) {
            transaction = -prices[index] + dp(index+1,1,k);
        }
        else {
            transaction = prices[index] + dp(index+1,0,k-1);
        }
        return dp[index][k][holding] = Math.max(transaction,noTransaction);
    }
}
