package src.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> result = new ArrayList();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {

            if (newInterval[1] >= intervals[i][0]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            } else {
                newInterval = intervals[i];
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);

    }
}
