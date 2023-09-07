package sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    int minLen = Integer.MAX_VALUE;
    int minStart = -1;
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int windowStart = 0;
        int matched = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char current = s.charAt(windowEnd);
            if(map.containsKey(current)) {
                map.put(current, map.get(current)-1);
                if(map.get(current) == 0){
                    matched++;
                }
                while(matched == map.size()) {
                    if(minLen > (windowEnd-windowStart+1)) {
                        minLen  = windowEnd - windowStart + 1;
                        minStart = windowStart;
                    }
                    char start = s.charAt(windowStart);
                    if(map.containsKey(start)) {
                        if(map.get(start) == 0){
                            matched--;
                        }
                        map.put(start, map.get(start)+1);
                    }
                    windowStart++;
                }
            }
        }
        if(minStart == -1)
            return "";
        return s.substring(minStart, minStart+minLen);
    }
}
