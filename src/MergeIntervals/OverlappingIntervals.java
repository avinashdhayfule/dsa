package src.MergeIntervals;

import java.util.Arrays;

public class OverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(isAnyOverlappingIntervals(new int[][]{
                new int[]{1, 3},
                new int[]{5, 7},
                new int[]{2, 4},
                new int[]{6, 8}
         }));

        System.out.println(isAnyOverlappingIntervals(new int[][]{
                new int[]{1, 3},
                new int[]{7, 9},
                new int[]{4, 6},
                new int[]{10, 12}
        }));
    }
    public static boolean isAnyOverlappingIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            int[] first = intervals[i - 1];
            int[] second = intervals[i];

            if(second[0] <= first[1]) return true;

        }
        return false;
    }
}
