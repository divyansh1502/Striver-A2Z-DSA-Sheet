public class NoOfTimesArrayIsRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.err.println(findRotationCount(arr));
    }
    static int findRotationCount(int[] arr) {
        int pivot = findPivot(arr);
        if(pivot == -1) return 0;
        return pivot + 1;
    }
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            else if(mid > start && arr[mid] < arr[mid - 1]) return mid - 1;
            else if(arr[start] <= arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
