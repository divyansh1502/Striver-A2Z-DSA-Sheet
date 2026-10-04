
import java.util.*;


public class MergeOverLapTUF {
    public static void main(String[] args) {
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(2, 5));
        list.add(Arrays.asList(4, 8));
        list.add(Arrays.asList(9, 12));
        list.add(Arrays.asList(14, 17));
        list.add(Arrays.asList(15, 16));
         
        System.out.println(mergeOverlap(list));
    }
    public static List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        // Your code goes here
        if(intervals.isEmpty()) return new ArrayList<>();

        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>(intervals.get(0)));

        for(int i = 1; i < intervals.size(); i++) {
            List<Integer> last = res.get(res.size() - 1);
            List<Integer> current = intervals.get(i);

            if (current.get(0) <= last.get(1)) {
                last.set(1, Math.max(last.get(1), current.get(1)));
            } else {
                res.add(new ArrayList<>(current));
            }
        }
        return res;
    }
}
