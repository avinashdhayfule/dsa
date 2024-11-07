package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            freqMap.put(magazine.charAt(i), freqMap.getOrDefault(magazine.charAt(i), 0 ) + 1);
        }

        int i;
        for(i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if( freqMap.containsKey(ch) &&  freqMap.get(ch) > 0)
                freqMap.put(ch, freqMap.get(ch) - 1);
            else{
                break;
            }
        }

        if(i == ransomNote.length()) return true;


        return false;
    }
}
