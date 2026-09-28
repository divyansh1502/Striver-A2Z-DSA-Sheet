public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] arr) {
        int xor1 = 0, xor2 = 0;
        int n = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }
}
