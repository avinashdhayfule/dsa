package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LongestKRepeatingSubstring {
    public int longestSubstring(String s, int k) {
        Set<Character> chars = new TreeSet<>();

        for(char ch :s.toCharArray()){
            chars.add(ch);
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for(int unique = 1; unique <= chars.size(); unique++){
            int windowStart = 0;
            int windowEnd = 0;
            int atLeastK = 0;
            freqMap.clear();
            while(windowEnd < s.length()){
                if(freqMap.size() <= unique){

                    freqMap.put(s.charAt(windowEnd), freqMap.getOrDefault(s.charAt(windowEnd), 0) + 1);
                    if( freqMap.get(s.charAt(windowEnd)) == k) atLeastK++;
                    windowEnd++;

                }else{

                    if(freqMap.get(s.charAt(windowStart)) == k) atLeastK--;
                    freqMap.put(s.charAt(windowStart), freqMap.get(s.charAt(windowStart)) - 1);
                    if(freqMap.get(s.charAt(windowStart)) == 0) freqMap.remove(s.charAt(windowStart));
                    windowStart++;

                }

                if(freqMap.size() == unique && atLeastK == unique){
                    maxLen = Math.max(maxLen, windowEnd - windowStart);
                }
            }
        }
        if(maxLen == Integer.MIN_VALUE) return 0;
        return maxLen;
    }
}
