import java.util.Arrays;

public class NumberOfInversions {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(inversionCount(arr));
    }
    static long count = 0;
    public static int inversionCount(int arr[]) {
        count = 0;
        merge(arr);
        return (int)count;
    }
    static int[] merge(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] first = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] second = merge(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArray(first, second);
    }
    static int[] mergeArray(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                mix[k++] = first[i++];
            } else {
                count += first.length - i;
                mix[k++] = second[j++];
            }
        }
        while(i < first.length) {
            mix[k++] = first[i++];
        }
        while(j < second.length) {
            mix[k++] = second[j++];
        }
        return mix;
    }
}
