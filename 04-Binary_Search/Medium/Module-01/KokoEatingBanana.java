public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles, 8));
    }
    static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        for(int pile : piles) {
            end = Math.max(end, pile);
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            long hours = 0;

            for(int pile : piles) {
                hours += (pile + (long) mid - 1) / mid;
            }
            if(hours <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
