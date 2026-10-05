import java.util.*;

public class MergeSortedArrayInPlace {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 8, 9};
        int[] arr2 = {1, 2, 7, 10, 12, 15, 18};
        mergeArrayInPlace(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    static void mergeArrayInPlace(int[] arr1, int[] arr2) {
        int left = arr1.length - 1;
        int right = 0;
        while(left >= 0 && right < arr2.length) {
            if(arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
