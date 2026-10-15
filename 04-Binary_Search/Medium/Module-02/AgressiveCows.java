
import java.util.Arrays;

public class AgressiveCows {
    public static void main(String[] args) {
        int[] stall = {1, 4, 7, 10, 9};
        System.out.println(agressiveCows(stall, 4));
    }
    static int agressiveCows(int[] arr, int k) {

        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canWePlace(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    static boolean canWePlace(int[] stall, int dis, int cows) {
        int countCows = 1;
        int lastCow = stall[0];

        for (int i = 1; i < stall.length; i++) {
            if(stall[i] - lastCow >= dis) {
                countCows++;
                lastCow = stall[i];
            }
            if(countCows >= cows) return true;
        }
        return false;
    }
}
