import java.util.Arrays;

public class RearrangeArrayBySign {
    public static void main(String[] args) {
        int[] arr  = {2, 5, -4, -5, -9, 8, -6, 7};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
    static int[] rearrangeArray(int[] nums) {
        int[] newArr = new int[nums.length];
        int positive = 0;
        int negative = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                newArr[negative] = nums[i];
                negative = negative + 2;
            }
            else {
                newArr[positive] = nums[i];
                positive = positive + 2;
            }
        }
        return newArr;
    }
}
