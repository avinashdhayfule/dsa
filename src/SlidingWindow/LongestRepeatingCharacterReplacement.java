package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int maxLen = 0;
        int maxRepeatingLetter = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char rightChar = s.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatingLetter = Math.max(maxRepeatingLetter, charMap.get(rightChar));

            if(windowEnd - windowStart + 1 - maxRepeatingLetter > k){
                char leftChar = s.charAt(windowStart);
                charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) - 1);
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}
