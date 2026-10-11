import java.util.Arrays;

public class FloorCeil {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 11, 15, 19};
        System.out.println(Arrays.toString(floorCeil(arr, 10)));
    }
    static int[] floorCeil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                return new int[]{arr[mid], arr[mid]};
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int floor = (end >= 0) ? arr[end] : -1;
        int ceil = (start < arr.length) ? arr[start] : -1;

        return new int[]{floor, ceil};
    }
}
