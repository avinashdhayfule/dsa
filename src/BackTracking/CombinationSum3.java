package src.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int target, int k, int start, List<Integer> combinations, List<List<Integer>> result){
        if(target == 0 && combinations.size() == k){
            result.add(new ArrayList<>(combinations));
            return;
        }

        for(int i = start; i < 10; i++){

            if(target < i) continue;
            if(combinations.size() == k + 1)
                break;
            combinations.add(i);
            backTrack(target - i, k,  i + 1, combinations, result);
            combinations.remove(combinations.size() - 1);
        }
    }
}
