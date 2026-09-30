
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 9, 5};
        arr = twoSum(arr, 11);
        System.out.println(Arrays.toString(arr));
    }
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int required  = target - arr[i];
            if(map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}