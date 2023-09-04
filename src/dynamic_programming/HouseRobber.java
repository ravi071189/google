package dynamic_programming;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4

Input: nums = [2,7,9,3,1]
Output: 12

 */
public class HouseRobber {
    public static void main(String[] args) {
        int output = new Solution().rob(new int[]{1,4,2});
        System.out.println(output);
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int first = 0;
        int second = nums[0];
        for(int i=1;i<nums.length;i++) {
            int current = nums[i] + first;
            first = second;
            second = Math.max(current, second);
        }
        return second;
    }
}
