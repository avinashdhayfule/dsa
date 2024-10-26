package src.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;

        HashSet<Character> charSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));
        char[] chars = s.toCharArray();
        while(left < right){
            while(left < s.length() && !charSet.contains(Character.toLowerCase(chars[left])))  left++;

            while(right > 0 && !charSet.contains(Character.toLowerCase(chars[right]))) right--;

            if(left < right){
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
            }


            left++;
            right--;

        }

        return String.valueOf(chars);
    }
}
