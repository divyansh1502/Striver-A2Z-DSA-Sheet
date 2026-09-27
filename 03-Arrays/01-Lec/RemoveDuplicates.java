
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4};
        System.out.println(removeDuplicates(arr));
    }
    static int removeDuplicates(int[] arr) {
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < arr.length; i++) {
        //     set.add(arr[i]);
        // }
        // return set.size();
    }
}
