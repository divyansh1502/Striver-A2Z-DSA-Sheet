public class MinBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 13, 12, 11, 7};
        System.out.println(minDays(bloomDay, 2, 3));
    }
    static int minDays(int[] bloomDay, int m, int k) {

        if((long)m * k > bloomDay.length) return -1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int bloom : bloomDay) {
            start = Math.min(start, bloom);
            end = Math.max(end, bloom);
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(isPossible(bloomDay, m , k, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static boolean isPossible(int[] bloomDay, int m , int k, int day) {
        int flowers = 0;
        int bouquets = 0;

        for(int bloom : bloomDay) {
            if(bloom <= day) {
                flowers++;

                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

}