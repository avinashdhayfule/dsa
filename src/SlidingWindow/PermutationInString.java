package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int matches = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0 ; i < s1.length(); i++){
            charMap.put(s1.charAt(i), charMap.getOrDefault(s1.charAt(i), 0) + 1);
        }


        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){
            char rightChar = s2.charAt(windowEnd);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) == 0){
                    matches++;
                }
            }

            if(charMap.size() == matches){
                return true;
            }


            if(windowEnd >= s1.length() - 1 ){
                char leftChar = s2.charAt(windowStart);
                windowStart++;
                if(charMap.containsKey(leftChar)){
                    if( charMap.get(leftChar)== 0){
                        matches--;
                    }
                    charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) + 1);
                }
            }

        }

        return false;
    }
}
