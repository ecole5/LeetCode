package other;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            else maxProfit = Math.max(prices[i] - min, maxProfit);


        }
        return maxProfit;

    }
}
