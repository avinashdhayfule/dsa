package src.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int[] candidates, int target, int start, List<Integer> combinations, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combinations));
            return;
        }

        for(int i = start; i < candidates.length; i++){

            if(i > start && candidates[i-1] == candidates[i])
                continue;

            if(target < candidates[i])
                continue;

            combinations.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, combinations, result);
            combinations.remove(combinations.size() - 1);
        }
    }
}
