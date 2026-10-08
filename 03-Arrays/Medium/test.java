import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 9, 11};
        System.out.println(Arrays.toString(missing(nums1, 15)));
    }
    static int[] missing(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
        int required = target - nums[i];
            if(map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(nums[i], i);
       }
       return new int[]{-1, -1};/
    }
}

