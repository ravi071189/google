package sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<Math.min(k,nums.length);i++) {
            while((!list.isEmpty()) && nums[list.getLast()]< nums[i])
                list.pollLast();
            list.addLast(i);
        }
        int[] output = new int[nums.length-k+1];
        int index = 0;
        output[index++] = nums[list.getFirst()];
        for(int i=k;i<nums.length;i++) {
            if((!list.isEmpty()) && list.getFirst()<=(i-k))
                list.pollFirst();
            while((!list.isEmpty()) && nums[list.getLast()]< nums[i])
                list.pollLast();
            list.addLast(i);
            output[index++] = nums[list.getFirst()];
        }
        return output;
    }
}
