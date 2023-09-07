package sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if(s.length() <= k)
            return s.length();
        Map<Character,Integer> map = new HashMap<>();
        int windowStart = 0;
        int maxCount = 0;
        int max = Integer.MIN_VALUE;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char current = s.charAt(windowEnd);
            map.put(current, map.getOrDefault(current,0)+1);
            maxCount = Math.max(maxCount, map.get(current));
            if(((windowEnd-windowStart+1)-maxCount) > k){
                char start = s.charAt(windowStart);
                map.put(start, map.get(start)-1);
                windowStart++;
            }
            if(windowEnd-windowStart+1 > max) {
                max = windowEnd-windowStart+1;
            }
        }
        return max;
    }
}
