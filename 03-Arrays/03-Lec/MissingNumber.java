public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(missingNumber(arr));
    }
    static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int total = (n * (n + 1)) / 2;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        return total - ans;
    }
}