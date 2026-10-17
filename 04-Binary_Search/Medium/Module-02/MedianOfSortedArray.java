public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 8, 9, 10, 14, 15, 25};
        int[] arr2 = {2, 3, 5, 7, 11};
        System.out.println(median(arr1, arr2));
     }
    public static double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        int n = n1 + n2;
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int count = 0;
        int ind1el = -1;
        int ind2el = -1;

        while(i < n1 && j < n2) {
            if(arr1[i] <= arr2[j]) {
                if(count == ind1) ind1el = arr1[i];
                if(count == ind2) ind2el = arr1[i];
                count++;
                i++;
            } else {
                if(count == ind1) ind1el = arr2[j];
                if(count == ind2) ind2el = arr2[j];
                count++;
                j++;
            }
        }
        while(i < n1) {
            if(count == ind1) ind1el = arr1[i];
            if(count == ind2) ind2el = arr1[i];
            count++;
            i++;
        }
        while(j < n2) {
            if(count == ind1) ind1el = arr2[j];
            if(count == ind2) ind2el = arr2[j];
            count++;
            j++;
        }
        if(n % 2 == 1) {
            return ind2el;
        } 
        return (double)((ind1el + ind2el) / 2.0);
    }
}
