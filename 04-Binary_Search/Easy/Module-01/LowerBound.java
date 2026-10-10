
public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 12, 14, 17};
        System.out.println(lowerBound(arr, 10));
    }
    static int lowerBound(int[] arr, int x) {
         int start = 0;
       int end = arr.length - 1;
       int mid = 0;

       while(start <= end) {
        mid = start + (end - start) / 2;
        if(arr[mid] < x) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
       }
       return start;
    }
}

/*

 int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if(arr[mid] < x) start = mid + 1;
            else if(arr[mid] > x) end = mid - 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans == -1 ? start : ans;

*/
