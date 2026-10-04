import java.util.*;

public class CountSubArrayWithGiverXorK {
    public static void main(String[] args) {
        int[] arr = {6, 2, 2, 4, 8, 4, 2, 3, 3, 9, 7, 1};
        System.out.println(subarraysWithXorK(arr, 6));
    }
    public static int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            if(map.containsKey(xor ^ k)) {
                cnt += map.get(xor ^ k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return cnt;
    }
}
