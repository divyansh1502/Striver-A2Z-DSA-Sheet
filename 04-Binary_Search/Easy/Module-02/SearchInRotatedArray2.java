public class SearchInRotatedArray2 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 3, 3, 3, 3, 3};
        System.out.println(searchTarget(arr, 1));
    }   
    static boolean searchTarget(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return true;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            }
            if(arr[start] <= arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    } 
}