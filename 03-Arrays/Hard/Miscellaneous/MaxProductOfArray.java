public class MaxProductOfArray {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 6, 3, -6, -2};
        System.out.println(maxProduct(arr));
    }
    static int maxProduct(int[] nums) {
        int pre = 1;
        int suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre = pre * nums[i];
            suff = suff * nums[nums.length - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}
