package dynamic_programming;
/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i]
is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once.
Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j
with k1 % n == k2 % n.
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0];
        int currentMin = min;
        int max = nums[0];
        int currentMax = max;
        int sum = nums[0];
        for(int i=1;i<nums.length;i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            max = Math.max(max, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            min = Math.min(min, currentMin);

            sum += nums[i];
        }
        if(sum == min)
            return max;
        return Math.max(max, sum-min);

    }
}
