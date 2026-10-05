import java.util.*;

public class SetMismatchUsingSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(setMismatch(arr)));
    }
    static int[] setMismatch(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int repeating = -1;
        int missing = -1;
        for(int num : arr) {
            if(set.contains(num)) {
                repeating = num;
            }
            set.add(num);
        }
        for (int i = 1; i <= arr.length; i++) {
            if(!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}
