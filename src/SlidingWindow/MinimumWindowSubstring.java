package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {


        int minLen = s.length() + 1;
        int windowStart = 0;
        int subStrStart = 0;
        int matched = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0 ; i < t.length(); i++){
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char rightChar = s.charAt(windowEnd);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);

                if(charMap.get(rightChar) >= 0)
                    matched++;
            }


            while(t.length() == matched){

                if(minLen > windowEnd - windowStart + 1 ){
                    minLen = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = s.charAt(windowStart);
                windowStart++;
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0){
                        matched--;
                    }

                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }


            }


        }

        return minLen > s.length() ? "" : s.substring(subStrStart, subStrStart + minLen);
    }

}
