
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        // valid only for positive numbers
        int[] arr = {1, 2, 2, 3, 1, 1, 1, 1, 1, 6};
        System.out.println(longestSubArray(arr, 4));
    }
    static int longestSubArray(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int maxAns = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while(sum > k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k) {
                maxAns = Math.max(maxAns, right - left + 1);
            }
        }
    return maxAns;
    }
}
