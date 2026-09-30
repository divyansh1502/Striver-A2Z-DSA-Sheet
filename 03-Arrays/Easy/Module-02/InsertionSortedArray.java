
import java.util.ArrayList;


public class InsertionSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 5, 8};
        int[] arr2 = {1, 2, 2, 2, 3, 3, 7, 8, 9, 11};
        System.out.println(insertion(arr1, arr2));
    }
    static ArrayList<Integer> insertion(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                i++;
            } else if(arr2[j] < arr1[i]) {
                j++;
            }
            else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }
}
