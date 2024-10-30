package src.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s1, String s2) {
        int windowStart = 0;
        int matches = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        List<Integer> indices = new ArrayList();
        for(int i =0 ; i < s2.length(); i++){
            charMap.put(s2.charAt(i), charMap.getOrDefault(s2.charAt(i), 0) + 1);
        }


        for(int windowEnd = 0; windowEnd < s1.length(); windowEnd++){
            char rightChar = s1.charAt(windowEnd);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) == 0){
                    matches++;
                }
            }

            if(charMap.size() == matches){
                indices.add(windowStart);
            }


            if(windowEnd >= s2.length() - 1 ){
                char leftChar = s1.charAt(windowStart);
                windowStart++;
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar)== 0){
                        matches--;
                    }
                    charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) + 1);
                }
            }

        }

        return indices;
    }
}
