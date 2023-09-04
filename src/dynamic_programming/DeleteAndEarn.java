package dynamic_programming;

import java.util.*;

/*
You are given an integer array nums. You want to maximize the number of points you get by performing
the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1
and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.

 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        int first = 0;
        int second = keys.get(0) * map.get(keys.get(0));
        for(int i=1;i<keys.size();i++) {
            int prev = keys.get(i-1);
            int curr = keys.get(i);
            if(curr == prev + 1) {
                int current = Math.max(second, first + curr * map.get(curr));
                first = second;
                second = current;
            }
            else {
                int current = second + curr * map.get(curr);
                first = second;
                second = current;
            }
        }
        return second;
    }
}
