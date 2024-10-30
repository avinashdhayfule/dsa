package src.SlidingWindow;

public class LongestkSubstr {

    public int longestkSubstr(String s, int k) {
        // code here

        int windowStart = 0;
        int windowEnd = 0;
        int[] freq = new int[26];
        int uniqueChars = 0;
        int maxLen = Integer.MIN_VALUE;

        while(windowEnd < s.length()){

            if(uniqueChars <= k){
                int index = s.charAt(windowEnd) - 'a';
                if(freq[index] == 0) uniqueChars++;

                freq[index]++;
                windowEnd++;

            }else{
                int index = s.charAt(windowStart) - 'a';
                freq[index]--;

                if(freq[index] == 0) uniqueChars--;
                windowStart++;
            }

            if(uniqueChars == k){
                maxLen = Math.max(windowEnd - windowStart, maxLen);
            }

        }

        if(maxLen == Integer.MIN_VALUE) return -1;

        return maxLen;
    }
}
