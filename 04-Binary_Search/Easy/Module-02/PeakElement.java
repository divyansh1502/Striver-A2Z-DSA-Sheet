public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 5, 4, 2, 1};
        System.out.println(findPeak(arr));
        System.out.println(findPeak2(arr));
    }
    static int findPeak(int[] arr) {
        int start = 1;
        int end = arr.length - 2;

        if(arr.length == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] < arr[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    static int findPeak2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
