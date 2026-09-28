
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0 ,1 , 1 , 1};
        System.out.println(maximum(arr));
    }
    static int maximum(int[] arr) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                count++;
                if(count > max) {
                    max = count;
                }
            }
            else {
                count = 0;
            }
        }
        return max;
    }
}
