
import java.util.Arrays;

public class MergeSortedArray1 {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 8, 9};
        int[] arr2 = {1, 2, 7, 10, 12, 15, 18};
        mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    static void mergeArray(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                newArr[k] = arr1[i];
                i++;
            } else {
                newArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < arr1.length) {
            newArr[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            newArr[k++] = arr2[j++];
        }
        for (int l = 0, m = 0; l < newArr.length; l++) {
            if(l < arr1.length) arr1[l] = newArr[l];
            else arr2[m++] = newArr[l]; 
        }
    }
}