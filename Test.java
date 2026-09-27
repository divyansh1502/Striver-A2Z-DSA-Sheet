public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] arr) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ arr.length;
        return xor1 ^ xor2;
    }
}
