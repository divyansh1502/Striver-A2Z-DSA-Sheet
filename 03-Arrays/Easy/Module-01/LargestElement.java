public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4, 2, 8, 3, 1};
        System.out.println(largestElement(arr));
    }
    static int largestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
        }
        }
        return largest;
    }
}
