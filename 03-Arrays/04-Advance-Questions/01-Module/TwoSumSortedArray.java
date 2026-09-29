import java.util.Arrays;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 11, 15, 17, 21};
        System.out.println(Arrays.toString(twoSum(arr, 28)));
    }
    static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(arr[left] + arr[right] == target) return new int[]{left, right};
            else if(arr[left] + arr[right] < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    } 
}
