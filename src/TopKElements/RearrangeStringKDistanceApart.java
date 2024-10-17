package TopKElements;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
        System.out.println(rearrangeString("mmpp", 2));
        System.out.println(rearrangeString("Programming", 3));
        System.out.println(rearrangeString("aab", 2));
        System.out.println(rearrangeString("aappa", 3));
    }
    public static String rearrangeString(String s, int k){
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(Character ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(freqMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length()) ;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            sb.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            queue.add(curr);
            if( queue.size() == k){
                Map.Entry<Character, Integer> prev = queue.poll();
                if(prev.getValue() > 0){
                    maxHeap.add(prev);
                }
            }

        }

        if(sb.length() != s.length()) return "";

        return sb.toString();


    }
}
