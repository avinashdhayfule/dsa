package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap();

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for(Character key : freqMap.keySet()){
            count += freqMap.get(key) / 2;
        }

        return (s.length() > 2* count ) ? 2* count + 1 : 2* count;
    }
}
