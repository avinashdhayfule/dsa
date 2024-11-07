package src.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < text.length(); i++){
            freqMap.put(text.charAt(i), freqMap.getOrDefault(text.charAt(i), 0 ) + 1);
        }

        int inst = 0;
        String s = "balloon";
        while(true){
            int i;
            for(i = 0; i < s.length(); i++){
                Character ch = s.charAt(i);
                if(freqMap.containsKey(ch) && freqMap.get(ch) > 0){
                    freqMap.put(ch, freqMap.get(ch) - 1);
                }else{
                    break;
                }
            }

            if( i != s.length()){
                break;
            }
            else{
                inst++;
            }
        }
        return inst;
    }
}
