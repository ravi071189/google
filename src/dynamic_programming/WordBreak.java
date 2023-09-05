package dynamic_programming;

import java.util.*;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    String s;
    Set<String> words;
    Map<String, Boolean> dp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.words = new HashSet<>(wordDict);
        return dp(s);
    }

    private boolean dp(String string) {
        if(string.equals(""))
            return true;
        if(dp.containsKey(string))
            return dp.get(string);
        for(int len=1;len<=string.length();len++) {
            String substring = string.substring(0,len);
            if(words.contains(substring)) {
                boolean result = dp(string.substring(len));
                dp.put(string,result);
                if(result)
                    return true;
            }
        }
        dp.put(string,false);
        return false;
    }
}
