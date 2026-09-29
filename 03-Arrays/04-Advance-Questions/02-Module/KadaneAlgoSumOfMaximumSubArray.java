// Kadane's Algorithm
public class KadaneAlgoSumOfMaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maximumSum(arr));
    }
    static int maximumSum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum); // calculte max at top otherwise for negative array it will return 0 atleast we have to return a subarray

            if(sum < 0) {
                sum = 0;
            }
        }
        return max;

        // int right = 0;
        // int sum = 0;
        // int max = Integer.MIN_VALUE;
        // while(right < arr.length) {
        //     sum += arr[right];
        //     max = Math.max(max, sum);
        //     while(sum < 0) {
        //         sum = 0;

        //     }
        //     right++;
        // }
        // return max;
    }
}
