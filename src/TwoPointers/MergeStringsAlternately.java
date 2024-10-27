package src.TwoPointers;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;

        StringBuilder sb = new StringBuilder();

        while(index1 < word1.length() && index2 < word2.length()){
            sb.append(word1.charAt(index1++)).append(word2.charAt(index2++));
        }

        while(index1 < word1.length()) sb.append(word1.charAt(index1++));

        while(index2 < word2.length()) sb.append(word2.charAt(index2++));

        return sb.toString();
    }
}
