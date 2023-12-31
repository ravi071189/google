package dynamic_programming;

/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i=0; i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
