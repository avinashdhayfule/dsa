package src.Subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                int size = result.size();
                for(int j = 0; j < size; j++){
                    char[] permutation = result.get(j).toCharArray();

                    if(Character.isUpperCase(ch)){
                        permutation[i] = Character.toLowerCase(ch);
                    }else{
                        permutation[i] = Character.toUpperCase(ch);
                    }
                    result.add(String.valueOf(permutation));
                }
            }

        }

        return result;
    }
}
