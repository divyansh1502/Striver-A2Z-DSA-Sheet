

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 1, 5};
        System.out.println(MinimumSubArray(arr, 7));
    }
    public static int MinimumSubArray(int[] arr, int target) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(right < arr.length) {
            sum += arr[right];
            while(sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
