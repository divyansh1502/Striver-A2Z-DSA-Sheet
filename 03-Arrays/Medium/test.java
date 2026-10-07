import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 10};
        int[] nums2 = {1, 2, 3, 4, 10};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;

       while(i < nums1.length && j < nums2.length) {
        if(nums1[i] < nums2[j]) {
            i++;
        } else if(nums2[j] < nums1[i]){
            j++;
        } else {
            newArr[k++] = nums1[i];
            i++;
            j++;
        }
       }
       return Arrays.copyOfRange(newArr, 0, k);
    }
}