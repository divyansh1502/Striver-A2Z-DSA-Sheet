import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(setMisMatch(arr)));
    }
    public static int[] setMisMatch(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeating = -1;
        int missing = -1;
        for (int num : nums) {
            if(!set.add(num)) {
                repeating = num;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                missing = i;
            }
        }
        return new int[]{repeating, missing};
    }
}

/*

int i = 0;
      while(i < nums.length) {
        int correct = nums[i] - 1;
        if(nums[i] != nums[correct]) {
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct]= temp;
        } else {
            i++;
        }
      }
    for (int j = 0; j < nums.length; j++) {
        if(j + 1 != nums[j]) {
            return new int[]{nums[j], j + 1};
        }    
    }
    return new int[]{-1, -1};

*/