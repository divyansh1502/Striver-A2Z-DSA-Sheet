public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 5, 9, 6, 1, 1, 2, 2, 2, 5, 2, 9, 2, 2};
        System.out.println(majorityElement(arr));
    }
    // Moore's Voting Algo.
    static int majorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count == 0) {
                candidate = arr[i];
                count++;
            }
            else if(arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
