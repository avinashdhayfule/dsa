package src.GreedyAlgorithms;

import java.util.Map;
import java.util.TreeMap;

public class LargestPalindromic {
    public String largestPalindromic(String num) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>((a, b) -> b - a);

        for(char ch : num.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        if(freqMap.size() == 1){
            if(freqMap.getOrDefault('0', 0) > 0)
                return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean isSingleDigit = false;
        Character single = null;
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            int frequency = entry.getValue() / 2;
            System.out.println(frequency);
            System.out.println(entry.getValue() % 2);
            while(frequency > 0){
                if(entry.getKey() == '0'){
                    if(result.length() > 0){
                        result.append(entry.getKey());
                    }
                }else{
                    result.append(entry.getKey());
                }

                frequency--;
            }

            if(!isSingleDigit && entry.getValue() % 2 == 1){
                single = entry.getKey();
                isSingleDigit = true;
            }
        }

        String part1 = result.toString();
        String part2 = result.reverse().toString();
        String mid = "";

        if(isSingleDigit)
            mid = String.valueOf(single);

        return part1 + mid + part2;

    }
}
