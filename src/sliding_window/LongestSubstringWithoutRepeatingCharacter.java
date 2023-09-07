package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int windowStart = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int windowEnd=0;windowEnd<s.length();windowEnd++) {
            char current = s.charAt(windowEnd);
            if(map.containsKey(current) && map.get(current)>=windowStart) {
                windowStart = map.get(current)+1;
            }
            map.put(current,windowEnd);
            len = Math.max(len, windowEnd-windowStart+1);
        }
        return len;
    }
}
