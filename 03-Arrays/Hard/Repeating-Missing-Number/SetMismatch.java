
import java.util.*;


public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(setMismatch(arr)));
    }
    static int[] setMismatch(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int repeating = -1;
        int missing = -1;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],  0) + 1);
        }
        // Find Repeating
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2) {
                repeating = entry.getKey();
            } 
        }
        // Find Missing
        for (int i = 1; i <= arr.length; i++) {
            if(!map.containsKey(i)) {
                missing = i;
            }
        }
        return new int[]{repeating, missing};
    }
}
