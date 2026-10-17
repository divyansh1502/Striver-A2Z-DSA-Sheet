public class GasStations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minimiseMaxDistance(arr, 4));
    }
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        
        for(int i = 1; i < n; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        double diff = 1e-6;

        while(high - low > diff) {
            double mid = low + (high - low) / 2.0;

            int count = 0;

            for (int i = 1; i < n; i++) {
                int stations = (int) ((arr[i] - arr[i - 1]) / mid);

                if((arr[i] - arr[i - 1]) / mid == stations * 1.0) {
                    stations--;
                }

                count += stations;
            }

            if(count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}