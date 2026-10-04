
import java.util.*;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {-10, 5, 23, 14, 2, 1, 2, 23, 3, 4, 5, 8, 9, -5, -5, 3, 5, -9};
        System.out.println(longestSubarray(arr, 60));
    }
    static int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;
        map.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
}
