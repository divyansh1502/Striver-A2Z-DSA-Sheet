public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 2, 4, 6, 8, 3};
        System.out.println(maxProfit(prices));
    }
    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
