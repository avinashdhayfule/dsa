package src.HashMap;

import java.util.*;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++){
            Character ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0 ; i < s.length(); i++){
            if(freqMap.getOrDefault(s.charAt(i), 0) == 1)
                return i;
        }


        return -1;
    }
}
