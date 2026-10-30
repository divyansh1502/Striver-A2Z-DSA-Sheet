import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= product;
            product *= nums[j];
        }
        return ans;
    }
}
