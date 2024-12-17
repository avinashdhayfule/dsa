package src.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        List<List<Integer>> permutation =  new ArrayList<>();
        permutation.add(new ArrayList<>());

        for(int num : nums){
            int size = permutation.size();
            for(int i = 0; i < size; i++){
                List<Integer> oldSet = permutation.get(i);
                for(int j = 0; j <= oldSet.size(); j++){
                    List<Integer> subset = new ArrayList<>(oldSet);
                    subset.add(j, num);
                    if(subset.size() == nums.length){
                        result.add(subset);
                    }else{
                        permutation.add(subset);
                    }
                }

            }
        }
        return result;

    }
}
