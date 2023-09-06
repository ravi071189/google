package dynamic_programming;

/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++)
            dp[0][i] = matrix[0][i];

        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                int left = (j==0)?Integer.MAX_VALUE:dp[i-1][j-1];
                int right = (j==n-1)?Integer.MAX_VALUE:dp[i-1][j+1];
                int up = dp[i-1][j];
                dp[i][j] = Math.min(Math.min(left,right),up)+matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            min = Math.min(min, dp[m-1][i]);
        return min;
    }
}
