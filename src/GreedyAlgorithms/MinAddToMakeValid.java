package src.GreedyAlgorithms;

public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int bracket = 0;
        int unblancedClosedBracket = 0;

        for(char ch : s.toCharArray()){
            if('(' == ch){
                bracket++;
            }else{
                bracket--;
            }

            if(bracket < 0){
                unblancedClosedBracket++;
                bracket++;
            }
        }

        return bracket + unblancedClosedBracket;
    }
}
