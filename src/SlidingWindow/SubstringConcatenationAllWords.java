package src.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> indices = new ArrayList();
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word: words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int wordCount = words.length;
        int wordLength = words[0].length();

        for(int i = 0 ; i <= s.length() - wordCount * wordLength; i++){
            Map<String, Integer> wordSeen = new HashMap<>();
            int numOfWords = 0;
            for(int j = 0; j < words.length; j++){
                int wordIndex = i + j * wordLength;
                String word = s.substring(wordIndex, wordIndex + wordLength);

                if(!wordMap.containsKey(word)){
                    break;
                }

                wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);

                if(wordSeen.get(word) - wordMap.get(word) == 0){
                    numOfWords++;
                    if(numOfWords - wordMap.size() == 0 ){
                        indices.add(i);
                        break;
                    }
                }
            }
        }

        return indices;
    }
}
