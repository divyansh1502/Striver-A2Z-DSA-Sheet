
public class UpperBound {
 public static void main(String[] args) {
    int[] arr = {2, 6, 9, 12, 14, 17};
    System.out.println(upperBound(arr, 9));
 }  
    static int upperBound(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    } 
}
