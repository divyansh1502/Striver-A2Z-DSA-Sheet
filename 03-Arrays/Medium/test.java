import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        System.out.println(subarraysWithXorK(arr, 6));
    }
    public static int subarraysWithXorK(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      int xor = 0, count = 0;
      map.put(0, 1);
      for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];

            count += map.getOrDefault(xor ^ k, 0);
            
            map.put(xor, map.getOrDefault(xor, 0) + 1);
      }
      return count;
    }
}

