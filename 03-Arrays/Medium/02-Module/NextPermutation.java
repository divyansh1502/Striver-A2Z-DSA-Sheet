import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3, 0, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void nextPermutation(int[] nums) {

        int index = -1;
        int n = nums.length - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            reverse(nums, 0, n);
            return;
        }
        for (int i = n; i > index; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, n);
    }
    static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    
}