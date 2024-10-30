package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringWithoutRepeatingCharcters {

    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int windowEnd = 0 ; windowEnd < s.length(); windowEnd++){
            char c = s.charAt(windowEnd);

            if(charMap.containsKey(c)){
                windowStart = Math.max(windowStart, charMap.get(c) + 1);
            }

            charMap.put(c, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
