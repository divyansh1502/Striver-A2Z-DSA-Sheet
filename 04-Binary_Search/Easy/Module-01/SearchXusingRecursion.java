
public class SearchXusingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 12, 15, 16, 18, 21, 25};
        System.out.println(recBS(arr, 0, arr.length - 1, 16));
    }
    static int recBS(int[] arr, int start, int end, int target) {
        if(start > end) {
            return -1;
        }
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) return recBS(arr, mid + 1, end, target);
            return recBS(arr, start, mid - 1, target);
    }
}
