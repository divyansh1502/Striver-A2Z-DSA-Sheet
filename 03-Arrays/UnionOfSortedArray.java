import java.util.ArrayList;

public class UnionOfSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 4, 4, 6, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 15, 18};
        System.out.println(findUnion(arr1, arr2));
    }
    static ArrayList<Integer> findUnion(int[] first, int[] second) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                if(union.isEmpty() || first[i] != union.get(union.size() - 1)) {
                    union.add(first[i]);
                }
                i++;
            } else {
                if(union.isEmpty() || second[j] != union.get(union.size() - 1)) {
                    union.add(second[j]);
                }
                j++;
            }
        }
        while(i < first.length) {
            if(union.isEmpty() || first[i] != union.get(union.size() - 1)) {
                union.add(first[i]);
            }
            i++;
        }
        while(j < second.length) {
            if(union.isEmpty() || second[j] != union.get(union.size() - 1)) {
                union.add(second[j]);
            }
            j++;
        }
        return union;
    }
}