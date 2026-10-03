
import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 0, 1, 2, 3, -5, -4, -6, 4, 2, 3};
        System.out.println(fourSum(nums, 0));
    }
    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(right > left && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum > target) right--;
                    else left++;
            }
        }
        
    }
    return list;
}
}