package src.TwoPointers;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.*;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> stroboMap = new HashMap<Character, Character>() {{
            put('0' , '0');
            put('1' , '1');
            put('6' , '9');
            put('8' , '8');
            put('9' , '6');
        }};

        StringBuilder sb = new StringBuilder();
        for(char ch : num.toCharArray()){
            if(!stroboMap.containsKey(ch)) return false;

            sb.append(stroboMap.get(ch));
        }

        return num.equals(sb.reverse().toString());
    }
}
