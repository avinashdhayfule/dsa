package src.MergeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] room = minHeap.peek();

            if(room[1] <= intervals[i][0]){
                minHeap.poll();
                minHeap.add(intervals[i]);
            }else{
                minHeap.add(intervals[i]);

            }
        }

        return minHeap.size();
    }
}
