package src.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int startTree = 0 ;
        int maxFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int endTree = 0; endTree < fruits.length; endTree++){
            map.put(fruits[endTree], map.getOrDefault(fruits[endTree],0) + 1);
            while(map.size() > 2){
                map.put(fruits[startTree], map.get(fruits[startTree]) - 1);
                if(map.get(fruits[startTree]) == 0) {
                    map.remove(fruits[startTree]);
                }
                startTree++;
            }
            maxFruits = Math.max(endTree - startTree + 1, maxFruits);
        }
        return maxFruits;
    }
}
