package src.BackTracking;

import java.util.HashSet;

public class MaxUniqueSplit {
    int substringsCount = 0;
    public int maxUniqueSplit(String s) {
        int index = 0;

        backTrack(s, index, new HashSet<String>());

        return substringsCount;
    }

    public void backTrack(String s, int index, HashSet<String> subStrings){

        if(s.length() == index){
            substringsCount = Math.max(substringsCount, subStrings.size());
        }

        String result = "";

        for(int i = index; i < s.length(); i++){
            result += s.charAt(i);

            if(subStrings.contains(result))
                continue;

            subStrings.add(result);
            backTrack(s, i + 1, subStrings);
            subStrings.remove(result);
        }


    }
}
