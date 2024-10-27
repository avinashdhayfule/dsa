package src.TwoPointers;

public class DIStringMatch {

    public int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] result  = new int[high + 1];
        int i = 0;
        for( i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                result[i] = low++;
            }else{
                result[i] = high--;
            }
        }

        while(low <= high){
            result[result.length - 1] = low;
            low++;
        }

        return result;
    }
}
