package sliding_window;

/*
Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.

If there is no such window in s1 that covers all characters in s2, return the empty string "".
If there are multiple such minimum-length windows, return the one with the left-most starting index.
 */

public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int first = 0;
        int second = 0;
        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;
        while(first < s1.length()) {
            if(s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;

                if (second == s2.length()) {
                    int firstCopy = first;
                    --second;
                    --first;
                    while (second >= 0) {
                        if (s1.charAt(first) == s2.charAt(second)) {
                            first--;
                            second--;
                        } else {
                            first--;
                        }
                    }
                    first++;
                    if (minLen > (firstCopy - first)) {
                        minLen = firstCopy - first;
                        minIndex = first;
                    }
                    first++;
                    second = 0;

                }
            }
            else {
                first++;
            }
        }
        if(minIndex == -1)
            return "";
        return s1.substring(minIndex, minIndex+minLen);
    }
}
