package dynamic_programming;

/*
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days.
The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7
 */

import java.util.Arrays;

public class MinimumDifficulty {
    int[] jobDifficulty;
    int d;
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        this.d = d;
        this.dp=new int[jobDifficulty.length][d];
        for(int[] ddp : dp)
            Arrays.fill(ddp, -1);
        int result = dp(0,1);
        if(result == Integer.MAX_VALUE)
            return  -1;
        return result;
    }

    private int dp(int index, int day) {
        if(day > d) {
            if(index == jobDifficulty.length)
                return 0;
            return Integer.MAX_VALUE;
        }
        if(index == jobDifficulty.length)
            return Integer.MAX_VALUE;
        if(dp[index][day-1] != -1)
            return dp[index][day-1];

        int difficulty = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i=index; i<=jobDifficulty.length-(d-day)-1;i++){
            difficulty = Math.max(difficulty,jobDifficulty[i]);
            int recur = dp(i+1,day+1);
            if(recur != Integer.MAX_VALUE) {
                result = Math.min(result, difficulty + recur);
            }
        }
        return dp[index][day-1] = result;
    }
}
