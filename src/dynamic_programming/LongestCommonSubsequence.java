package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    String text1;
    String text2;

    Map<String,Integer> dp = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        return dp(0,0);
    }

    private int dp(int i, int j) {
        if(i == text1.length() || j == text2.length())
            return 0;
        if(dp.containsKey(i+","+j))
            return dp.get(i+","+j);
        int res = 0;
        if(text1.charAt(i) == text2.charAt(j))
            res =  1 + dp(i+1,j+1);
        else
            res = Math.max(dp(i+1,j), dp(i,j+1));
        dp.put(i+","+j,res);
        return res;
    }
}
