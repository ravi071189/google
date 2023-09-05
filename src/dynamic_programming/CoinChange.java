package dynamic_programming;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 */

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    int[] coins;
    Map<Integer,Integer> dp = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int result = dp(amount);
        if(result == Integer.MAX_VALUE)
            return -1;
        return result;
    }

    private int dp(int amount) {
        if(amount == 0)
            return 0;
        if(amount < 0)
            return Integer.MAX_VALUE;
        if(dp.containsKey(amount))
            return dp.get(amount);
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int recur = dp(amount - coin);
            if(recur != Integer.MAX_VALUE) {
                res = Math.min(res, recur+1);
            }
        }
        dp.put(amount,res);
        return res;
    }
}
