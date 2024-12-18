package src.GreedyAlgorithms;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int length = s.length();
        if(length <= 1) return true;

        if(length == 2 && s.charAt(0) == s.charAt(1)) return true;
        int left = 0;
        int right = length - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrom(s.substring(left + 1, right + 1)) || isPalindrom(s.substring(left, right));
            }else{
                left++;
                right--;
            }

        }

        return true;
    }

    public boolean isPalindrom(String s){
        System.out.println(s);
        int left = 0;
        int right = s.length() - 1;

        //if(left >= s.length() || right < 0 || left > right) return false;

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
