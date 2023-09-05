package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreFromPerformingMultiplication {
    int[] nums;
    int[] multipliers;

    Map<String,Integer> dp = new HashMap<>();
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        return dp(0,0);
    }

    private int dp(int index, int left) {
        if(index == multipliers.length)
            return 0;
        if(dp.containsKey(index+","+left))
            return dp.get(index+","+left);
        int l = multipliers[index] * nums[left] + dp(index+1, left+1);
        int r = multipliers[index] * nums[nums.length - (index - left)-1] + dp(index+1,left);
        dp.put(index+","+left, Math.max(l,r));
        return dp.get(index+","+left);
    }
}
