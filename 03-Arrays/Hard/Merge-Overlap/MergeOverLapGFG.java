
import java.util.*;


public class MergeOverLapGFG {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 3},
            {2, 5},
            {4, 8},
            {9, 12},
            {14, 17},
            {15, 16}
        };
        System.out.println(mergeOverlap(arr));
    }
    public static ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        if(arr.length == 0) return new ArrayList<>();
        
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        
        res.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] current = arr[i];
            
            if(current[0] <= last[1]) {
                last[1] = Math.max(current[1], last[1]);
            } else {
                res.add(current);
            }   
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int[] interval : res) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(interval[0]);
            temp.add(interval[1]);
            ans.add(temp);
        }
        return ans;
    }
}
