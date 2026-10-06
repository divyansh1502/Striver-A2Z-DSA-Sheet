import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 3, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = getMaxIndex(arr, last);
            swap(arr, max, last);
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    static int getMaxIndex(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
