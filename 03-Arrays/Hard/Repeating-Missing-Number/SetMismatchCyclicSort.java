import java.util.Arrays;

public class SetMismatchCyclicSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(setMismatch(arr)));
    }
    static int[] setMismatch(int[] arr) {
        int i = 0;
        int repeating = -1;
        int missing = -1;
        while(i < arr.length) {
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1) {
                repeating = arr[j];
                missing = j + 1;
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}
