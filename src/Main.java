import TreeBFS.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1,2,3}, 4));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backTrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void backTrack(int[] candidates, int target, int start, List<Integer> combinations, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(combinations));
            return;
        }


        for(int i = start; i < candidates.length; i++){

            if(target < candidates[i])
                continue;

            combinations.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, combinations, result);
            combinations.remove(combinations.size() - 1);
        }
    }
}






