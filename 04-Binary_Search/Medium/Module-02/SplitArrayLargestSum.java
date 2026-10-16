public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(largestSubarraySumMinimized(arr, 3));
    }
    static int largestSubarraySumMinimized(int[] nums, int k) {
        if(k > nums.length) return -1;

        int low = 0;
        int high = 0;

        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while(low <= high) {
            int maxAllowedSum = low + (high - low) / 2;
            int subarrayNeeded = countSubarrays(nums, maxAllowedSum);

            if(subarrayNeeded > k) {
                low = maxAllowedSum + 1;
            } else {
                high = maxAllowedSum - 1;
            }
        }
        return low;
    }
    static int countSubarrays(int[] nums, int maxAllowedSum) {
        int subarrayNeeded = 1;
        int currentSum = 0;

        for(int num : nums) {
            if(currentSum + num <= maxAllowedSum) {
                currentSum += num;
            } else {
                subarrayNeeded++;
                currentSum = num;
            }
        }
        return subarrayNeeded;
    }
}
