
public class UniqueNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1, 2, 5};
        System.out.println(findUnique(arr));
    }
    static int findUnique(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}
