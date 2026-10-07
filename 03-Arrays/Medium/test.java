import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 10};
        int[] nums2 = {1, 2, 3, 7, 9, 10, 15, 18, 25, 25, 28};
        System.out.println(Arrays.toString(union(nums1, nums2)));
    }
    static int[] union(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                if(k == 0 || nums1[i] != newArr[k - 1]) {
                    newArr[k++] = nums1[i];
                }
                i++;
            } else {
                if(k == 0 || nums2[j] != newArr[k - 1]) {
                    newArr[k++] = nums2[j];
                }
                j++;
            }
        }
        while(i < nums1.length) {
            if(k == 0 || nums1[i] != newArr[k - 1]) {
                newArr[k++] = nums1[i];
            }
            i++;
        }
        while(j < nums2.length) {
            if(k == 0 || nums2[j] != newArr[k - 1]) {
                newArr[k++] = nums2[j];
            }
            j++;
        }
        return Arrays.copyOfRange(newArr, 0, k);
    }
}