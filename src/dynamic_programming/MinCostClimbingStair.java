package dynamic_programming;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStair {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <=1)
            return 0;
        int first = 0;
        int second = 0;
        for(int i=2;i<=cost.length;i++) {
            int current = Math.min(cost[i-2] + first, cost[i-1] + second);
            first = second;
            second = current;
        }
        return second;
    }
}

