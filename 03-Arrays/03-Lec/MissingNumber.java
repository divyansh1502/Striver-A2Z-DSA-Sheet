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
/* --> Way 2

static int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1) {
                return j + 1;
            }
        }
        return arr.length + 1;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    --> Way 3 and Best way

    static int missingNumber(int[] arr) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ arr.length;
        return xor1 ^ xor2;
    }
        
*/