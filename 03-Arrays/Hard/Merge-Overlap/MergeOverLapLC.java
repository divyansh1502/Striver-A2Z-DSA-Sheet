
import java.util.*;

public class MergeOverLapLC {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 3},
            {2, 5},
            {4, 8},
            {9, 12},
            {14, 17},
            {15, 16}
        };
        arr = merge(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        
        if(intervals.length == 0) {
            return new int[0][0];
        }

        // Sort by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            // overlaps
            if(current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            }

            // no overlap
            else {
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

// Sort first, then compare every current interval with the LAST MERGED interval. Overlap → extend it. No overlap → start a new interval.