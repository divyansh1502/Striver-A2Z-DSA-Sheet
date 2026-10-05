import java.util.Arrays;

public class MergeSortedArrayGapMethod {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 8, 9};
        int[] arr2 = {1, 2, 7, 10, 12, 15, 18};
        merge(arr1, arr1.length, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    static void merge(int[] arr1, int m, int[] arr2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2); // Gives ceiling value
        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while(right < len) {
                // arr1 && arr2
                if(left < m && right >= m) {
                    swapIFGreater(arr1, arr2, left, right - m);
                // arr2 && arr2
                } else if(left >= m) {
                    swapIFGreater(arr2, arr2, left - m, right - m);
                // arr1 && arr1
                } else {
                    swapIFGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
    static void swapIFGreater(int[] arr1, int[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
}
}
