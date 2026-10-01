import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 2, 3, 0, 6};
        System.out.println(leadersInArray(arr));
    }
    static ArrayList<Integer> leadersInArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length - 1;
        for (int i = n; i >= 0; i--) {
            if(arr[i] > max) {
                max = arr[i];
                list.add(arr[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }
    
}