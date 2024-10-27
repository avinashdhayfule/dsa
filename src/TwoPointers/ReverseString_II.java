package src.TwoPointers;

public class ReverseString_II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int i = 0;
        while(i < size){
            int j = Math.min( i + k - 1, size - 1);
            chars = reverse(chars, i, j);
            i += 2 * k;
        }
        return String.valueOf(chars);
    }

    private char[] reverse(char[] chars, int start, int end){

        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++; end--;
        }

        return chars;
    }
}
