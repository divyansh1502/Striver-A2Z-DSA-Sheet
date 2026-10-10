
public class SearchX {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 12, 15, 16, 18, 21, 25};
        System.out.println(binarySearch(arr, 16));
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
