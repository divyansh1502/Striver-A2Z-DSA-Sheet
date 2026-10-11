import java.util.Arrays;

public class firstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 2, 2, 4, 4, 4, 5, 5, 6};
        System.out.println(Arrays.toString(findFirstAndLast(arr, 2)));
    }
    static int[] findFirstAndLast(int[] arr, int target) {
        int[] ans = {-1, -1};

        ans[0] = binarySearch(arr, target, true);
        ans[1] = binarySearch(arr, target, false);

        return ans;
    }

    static int binarySearch(int[] arr, int target, boolean searchFirstOccurence) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if(searchFirstOccurence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
