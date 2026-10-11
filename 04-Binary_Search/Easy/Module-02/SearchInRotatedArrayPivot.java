
public class SearchInRotatedArrayPivot {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2, 3};
        System.out.println(searchInRotatedArray(arr, 0));
    }
    static int searchInRotatedArray(int[] nums, int target) {
        int pivot = findPivot(nums);

        int firstHalf = binarySearch(nums, target, 0, pivot);
        if(firstHalf != -1) {
            return firstHalf;
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }
    static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1]) return mid;
            if(mid > start && nums[mid] < nums[mid - 1]) return mid - 1;
            else if(nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
