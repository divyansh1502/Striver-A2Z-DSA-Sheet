
import java.util.*;

// https://leetcode.com/problems/reverse-pairs/?utm_source=chatgpt.com

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {40, 25, 18, 16, 14, 11, 9, 6, 4, 2, 1};
        System.out.println(reversePair(arr));
    }
    static int count = 0;
    static int reversePair(int[] nums) {
        count = 0;
        merge(nums);
        return count;
    }
    static int[] merge(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] first = merge(Arrays.copyOfRange(nums, 0, mid));
        int[] second = merge(Arrays.copyOfRange(nums, mid, nums.length));
        countPairs(first, second);
        return mergeArray(first, second);
    }
    static void countPairs(int[] first, int[] second) {
        int right = 0;
        for (int left = 0; left < first.length; left++) {
            while(right < second.length && (long) first[left] > 2L * second[right]) {
                right++;
            }
            count += right;
        }
    }
    static int[] mergeArray(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                mix[k++] = first[i++];
            } else {
                mix[k++] = second[j++];
            }
        }
        while(i < first.length) {
            mix[k++] = first[i++];
        }
        while(j < second.length) {
            mix[k++] = second[j++];
        }
        return mix;
    }
}
