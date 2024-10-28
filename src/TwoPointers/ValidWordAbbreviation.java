package src.TwoPointers;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        int k = 0;
        for(int i = 0; i < abbr.length(); i++){
            char ch = abbr.charAt(i);
            if(Character.isDigit(ch)){
                int num = Character.getNumericValue(ch);
                if(num == 0) return false;

                while(num > 0 && i < abbr.length () - 1 && Character.isDigit(abbr.charAt(i+1))){
                    i++;
                    num *= 10 + Character.getNumericValue(abbr.charAt(i));
                }

                if(k + num > word.length()) return false;

                k += num;

            }else{
                if(k >= word.length() || word.charAt(k++) != ch) return false;
            }
        }

        return k == word.length();
    }
}
