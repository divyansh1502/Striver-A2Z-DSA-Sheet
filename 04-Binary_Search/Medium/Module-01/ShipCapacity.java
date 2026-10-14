public class ShipCapacity {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(weights, 5));
    }
    static int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        for(int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int reqDays = returnDays(weights, mid);

            if(reqDays <= days) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static int returnDays(int[] weights, int cap) {
        int load =  0;
        int days = 1;

        for(int weight : weights) {
            if(load + weight > cap) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return days;
    }
}
