package src.TwoPointers;

public class ReverseWords {
    public String reverseWords(String s) {
        int start = 0;
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(chs[i] == ' '){
                chs = reverse(chs, start, i - 1);
                start = i + 1;
            }
        }
        // to reverse last word on sentence;
        chs = reverse(chs, start, s.length() - 1);

        return String.valueOf(chs);
    }

    public char[] reverse(char[] chs, int start, int end){

        while(start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }

        return chs;
    }

}
