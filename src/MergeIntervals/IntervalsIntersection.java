package src.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;

        int maxStartPoint = 0;
        int minEndPoint = 0;

        while(firstIndex < firstList.length && secondIndex < secondList.length){
            maxStartPoint = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            minEndPoint = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            if(minEndPoint >= maxStartPoint ){
                int[] intersectPoint = {maxStartPoint, minEndPoint};
                result.add(intersectPoint);
            }

            if(minEndPoint == firstList[firstIndex][1]) firstIndex++;

            if(minEndPoint == secondList[secondIndex][1]) secondIndex++;

        }

        return result.toArray(new int[result.size()][]);
    }
}
