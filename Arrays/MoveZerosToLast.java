import java.util.Arrays;

public class MoveZerosToLast {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 3, 5, 8, 9, 0, 4, 0, 0, 2};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void moveZero(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;

        for (int i = j + 1; i < arr.length; i++) {
            if(arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
