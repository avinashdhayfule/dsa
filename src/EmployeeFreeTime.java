import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        int[][] jobs = {{1, 4, 1}, {2, 4, 2}, {3, 6, 5}};
        System.out.println(findEmployeeFreeTime(jobs));
    }

    public static int[][] findEmployeeFreeTime(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        int[] lastInterval = intervals[0];
        List<int[]> result = new ArrayList<>();
        int cpuLoad =  lastInterval[2];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(lastInterval[1] < curr[0]){
                result.add(lastInterval);
            }
            lastInterval = curr;
        }
        return result.toArray(new int[result.size()][]);
    }
}
