import java.util.Arrays;

public class RearrangeArrayBySign {
    public static void main(String[] args) {
        int[] arr  = {2, 5, -4, -5, -9, 8, -6, 7};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
    static int[] rearrangeArray(int[] nums) {
        int[] newArr = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                newArr[negIndex] = nums[i];
                negIndex += 2;
            }
            else {
                newArr[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return newArr;
    }
}
