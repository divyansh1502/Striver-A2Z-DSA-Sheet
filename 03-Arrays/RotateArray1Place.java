
import java.util.Arrays;


public class RotateArray1Place {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void rotateArray(int[] arr) {
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++) { 
            arr[i - 1] = arr[i];
        } 
        arr[arr.length - 1] = temp;
    }
}
