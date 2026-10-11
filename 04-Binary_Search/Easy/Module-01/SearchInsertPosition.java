
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 11, 15, 19};
        System.out.println(insertPosition(arr, 10));
    }
    static int insertPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    
}
