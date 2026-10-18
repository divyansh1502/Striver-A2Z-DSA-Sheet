public class MedianOfSortedArrayBS {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 6, 7};
        int[] nums2 = {2, 3, 5, 8, 9};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        int low = 0;
        int high = n1;

        while(low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 == 1) {
                    return Math.max(l1, l2);
                }
                return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}