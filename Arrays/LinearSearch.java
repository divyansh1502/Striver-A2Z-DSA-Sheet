public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {0, 4, 6, 7, 3, 5, 7, 8, 3, 2, 1};
        System.out.println(linearSearch(arr, 7));
    }
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
