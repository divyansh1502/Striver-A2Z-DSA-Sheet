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

/* --> Return an array not ArrayList

public int[] unionArray(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                if(k == 0 || nums1[i] != arr[k - 1]) {
                    arr[k] = nums1[i];
                    k++;
                }
                i++;
            }
            else {
                if(k == 0 || nums2[j] != arr[k - 1]) {
                    arr[k] = nums2[j];
                    k++;
                }
                j++;
            }
        }
        while(i < nums1.length) {
            if(k == 0 || nums1[i] != arr[k - 1]) {
                arr[k] = nums1[i];
                k++;
            }
            i++;
        }
        while(j < nums2.length) {
            if(k == 0 || nums2[j] != arr[k - 1]) {
                arr[k] = nums2[j];
                k++;
            }
            j++;
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

*/