public class CountOccurence {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6};
        System.out.println(countOccurence(arr, 2));
    }
    static int countOccurence(int[] arr, int target) {
        int a = binarySearch(arr, target, true); 
        if(a == -1) return 0;
        int b = binarySearch(arr, target, false);
        int ans = b - a + 1;
        return ans;
    }
    static int binarySearch(int[] arr, int target, boolean searchLeft) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if(searchLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
