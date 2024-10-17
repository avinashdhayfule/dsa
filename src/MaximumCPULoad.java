import java.util.Arrays;

public class MaximumCPULoad {
    public static void main(String[] args) {
        int[][] jobs = {{1, 4, 1}, {2, 4, 2}, {3, 6, 5}};
        System.out.println(findMaxCPULoad(jobs));
    }

    public static int findMaxCPULoad(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        int[] lastInterval = intervals[0];
        int maxCPULoad = Integer.MIN_VALUE;
        int cpuLoad =  lastInterval[2];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(lastInterval[1] >= curr[0]){
                cpuLoad = cpuLoad + curr[2];
            }else{
                lastInterval = curr;
                cpuLoad = curr[2];
            }
            maxCPULoad = Math.max(maxCPULoad, cpuLoad);
        }
        return maxCPULoad;
    }
}
