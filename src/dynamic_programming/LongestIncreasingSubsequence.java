package dynamic_programming;

import java.util.Arrays;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

 */
public class LongestIncreasingSubsequence {
    int[] nums;
    int[] dp;

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 1;
        for(int i=1; i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }


}
