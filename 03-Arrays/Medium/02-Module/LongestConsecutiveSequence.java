import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 100, 102, 200, 5, 201, 202, 103}; 
        System.out.println(longestSequence(arr));
    }
    static int longestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (Integer val : set) {
            int count = 1;
            if(set.contains(val - 1)) {
                continue;
            } else {
                while(set.contains(val + 1)) {
                    count++;
                    val++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
