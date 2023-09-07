package sliding_window;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int windowStart = 0;
        int sum = 0;
        for(int windowEnd =0; windowEnd<nums.length; windowEnd++) {
            sum += nums[windowEnd];
            while(sum >= target) {
                min = Math.min(min, windowEnd-windowStart+1);
                sum -= nums[windowStart++];
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}
