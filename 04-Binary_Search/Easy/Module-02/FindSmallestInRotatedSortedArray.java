public class FindSmallestInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9};
        System.out.println(findSmallest(arr));
    }   
    static int findSmallest(int[] arr) {
        int pivot = findPivot(arr);
        if(pivot == -1) return arr[0];
        return arr[pivot + 1];
    } 
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if(mid > start && arr[mid] < arr[mid - 1]) return mid - 1;
            if(arr[start] <= arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
