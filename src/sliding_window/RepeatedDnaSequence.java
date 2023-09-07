package sliding_window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string, s, that represents a DNA subsequence, and a number k, return all the contiguous subsequences (substrings) of length
k that occur more than once in the string. The order of the returned subsequences does not matter.
If no repeated substring is found, the function should return an empty set.
 */
public class RepeatedDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        int k = 10;
        if(s.length() < k)
            return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i=0; i<=s.length()-k;i++){
            String substring = s.substring(i,i+k);
            if(set.contains(substring))
                result.add(substring);
            set.add(substring);
        }
        return new ArrayList<>(result);
    }
}
