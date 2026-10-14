public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(smallestDivisor(nums, 8));
    }
    static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        
        for(int num : nums) {
            end = Math.max(end, num);
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int sum = 0;

            for(int num : nums) {
                sum += (num + mid - 1) / mid;
            }

            if(sum <= threshold) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
