
import java.util.*;


public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3, -2, 7, 5, -6, 4, -4};
        System.out.println(threeSum(arr));
    }
    static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    list.add(0, Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while(left < right && arr[left] == arr[left - 1]) left++;
                    while(right > left && arr[right] == arr[right + 1]) right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
