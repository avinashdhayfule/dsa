package src.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        if(intervals.length == 0){
            result.add(newInterval);
            result.addAll(Arrays.asList(intervals));
            return result.toArray(new int[result.size()][]);
        }

        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(newInterval[0] > curr[1] ){
                result.add(curr);
            }else if(newInterval[1] < curr[0]){
                result.add(newInterval);
                newInterval = curr;
            }else{
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
